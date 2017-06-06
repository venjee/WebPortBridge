package com.skyworthdigital.sky2dlauncher.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.skyworthdigital.sky2dlauncher.tools.ActionString;
import com.skyworthdigital.sky2dlauncher.tools.PreferenceHelper;
import com.skyworthdigital.sky2dlauncher.tools.SysHelper;
import com.skyworthdigital.sky2dlauncher.tools.SysPropHelper;
import com.skyworthdigital.sky2dlauncher.view.CommonDialg;
import com.skyworthdigital.sky2dlauncher.view.CommonDialg.Builder;
import com.skyworthdigital.sky2dlauncher.view.PwdConfirmDialg;
import com.skyworthdigital.sky2dlauncher.view.PwdConfirmDialg.OnPwdConfirm;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends Activity
{
  public static final MediaType TEXT_APP = MediaType.parse("text/x-markdown; charset=utf-8");
  int firstRunTime = 0;
  private int kIndex = 0;
  BroadcastReceiver mBroadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        MainActivity.this.handleView();
      do
      {
        return;
        if (!paramIntent.getAction().equals(ActionString.UPDATE_APK))
          continue;
        MainActivity.this.handleUpdateApk(paramIntent.getStringExtra("file"));
        return;
      }
      while (!paramIntent.getAction().equals(ActionString.UPDATE_FIRMWARE));
      MainActivity.this.handleUpdateFw();
    }
  };
  ConnectivityManager mCm = null;
  IntentFilter mFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      System.currentTimeMillis();
      paramMessage = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()).toString();
      MainActivity.this.mTime.setText(paramMessage);
    }
  };
  Handler mHandler2 = new Handler()
  {
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      MainActivity.this.mWebView.setVisibility(0);
      MainActivity.this.mWebView.loadUrl(PreferenceHelper.readString(MainActivity.this, "config", "host", ""));
      MainActivity.this.mMSG.setVisibility(8);
      MainActivity.this.mTimeLoop = false;
    }
  };
  OkHttpClient mHttpClient = null;
  View.OnKeyListener mKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      MainActivity.this.HandlerKeyEvent(paramInt, paramKeyEvent);
      return false;
    }
  };
  private int[] mKeyValue = new int[3];
  LinearLayout mMSG;
  TextView mTime;
  boolean mTimeLoop = true;
  TextView mVersion;
  WebView mWebView;
  PwdConfirmDialg.OnPwdConfirm onPwdConfirm = new PwdConfirmDialg.OnPwdConfirm()
  {
    public void onConfirm(String paramString)
    {
      if (paramString.equals("w@esp@$$word"))
      {
        paramString = new Intent(MainActivity.this, ConfigActivity.class);
        MainActivity.this.startActivity(paramString);
      }
    }
  };

  private void HandlerKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      System.out.println("##########  key code:" + paramInt + "     " + paramKeyEvent.toString());
      int[] arrayOfInt = this.mKeyValue;
      paramInt = this.kIndex;
      this.kIndex = (paramInt + 1);
      arrayOfInt[paramInt] = paramKeyEvent.getKeyCode();
      if (this.kIndex == 3)
      {
        this.kIndex = 0;
        if ((this.mKeyValue[0] == 113) && (this.mKeyValue[1] == 59) && (this.mKeyValue[2] == 31))
          new PwdConfirmDialg(this, "Control Center Code ", this.onPwdConfirm).show();
      }
    }
  }

  private void getSoft()
  {
    Object localObject = new DevInfo();
    ((DevInfo)localObject).sn = SysPropHelper.getStringProp(this, "persist.sys.hwconfig.seq_id");
    ((DevInfo)localObject).time = this.firstRunTime;
    if (this.mHttpClient == null)
      this.mHttpClient = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
    System.out.println("readTimeOut:" + this.mHttpClient.readTimeoutMillis());
    Gson localGson = new Gson();
    localObject = RequestBody.create(TEXT_APP, localGson.toJson(localObject));
    localObject = new Request.Builder().url("http://mbox.f3322.net/mbox/box").post((RequestBody)localObject).build();
    this.mHttpClient.newCall((Request)localObject).enqueue(new Callback()
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        if (paramResponse.body().string().contains("error"))
        {
          PreferenceHelper.write(MainActivity.this, "sys", "bootOption", false);
          return;
        }
        PreferenceHelper.write(MainActivity.this, "sys", "bootOption", true);
      }
    });
  }

  private boolean handleNetstate()
  {
    NetworkInfo localNetworkInfo = this.mCm.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      getSoft();
      return true;
    }
    return false;
  }

  private void handleView()
  {
    String str = PreferenceHelper.readString(this, "config", "host", "");
    boolean bool = PreferenceHelper.readBoolean(this, "sys", "bootOption", true);
    if ((handleNetstate()) && (!str.equals("")) && (bool))
    {
      this.mHandler2.sendEmptyMessageDelayed(0, 3500L);
      return;
    }
    this.mWebView.setVisibility(8);
    this.mMSG.setVisibility(0);
    new TimeThread().start();
  }

  void handleUpdateApk(String paramString)
  {
    CommonDialg.Builder localBuilder = new CommonDialg.Builder(this);
    localBuilder.setMessage("There may be new firmware for IP Monitor to improve functionality and performance.Do you want update?");
    localBuilder.setTitle("Firmware Update");
    localBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener(paramString)
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.dismiss();
        SysHelper.InstallApk(MainActivity.this, this.val$path);
      }
    });
    localBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.dismiss();
      }
    });
    localBuilder.create().show();
  }

  void handleUpdateFw()
  {
    CommonDialg.Builder localBuilder = new CommonDialg.Builder(this);
    localBuilder.setMessage("Here has a last FW,do you want to Update?");
    localBuilder.setTitle("Information");
    localBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.dismiss();
        SysHelper.RebootRecovery(MainActivity.this);
      }
    });
    localBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.dismiss();
      }
    });
    localBuilder.create().show();
  }

  public void onBackPressed()
  {
    if (this.mWebView.canGoBack())
      this.mWebView.goBack();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968602);
    getWindow().addFlags(16777216);
    getWindow().addFlags(128);
    this.mWebView = ((WebView)findViewById(2131427417));
    this.mMSG = ((LinearLayout)findViewById(2131427413));
    this.mTime = ((TextView)findViewById(2131427416));
    this.mWebView.getSettings().setDefaultTextEncodingName("utf-8");
    this.mCm = ((ConnectivityManager)getSystemService("connectivity"));
    this.mVersion = ((TextView)findViewById(2131427415));
    paramBundle = new Intent("android.cgm.sysservercgm.service");
    getSoft();
    startService(paramBundle);
    ((PowerManager)getSystemService("power")).newWakeLock(6, "My Tag").acquire();
    this.mFilter.addAction(ActionString.UPDATE_APK);
    this.mFilter.addAction(ActionString.UPDATE_FIRMWARE);
    this.mFilter.addAction(ActionString.GET_DISPLAY);
    this.mFilter.addAction(ActionString.GET_PROP);
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.setScrollBarStyle(0);
    this.mWebView.getSettings().setLoadsImagesAutomatically(true);
    this.mWebView.getSettings().setAppCacheEnabled(false);
    this.mWebView.getSettings().setDomStorageEnabled(true);
    this.mWebView.getSettings().setAllowFileAccess(true);
    this.mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
    this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.mWebView.getSettings().setLoadWithOverviewMode(true);
    this.mWebView.getSettings().setUseWideViewPort(true);
    this.mVersion.setText(SysHelper.getAPPVersionStringFromAPP(this));
    SysHelper.TrunOnOffEthernet(this, true);
    SysPropHelper.setSysOutputMode(this, "1080p50hz");
    if (PreferenceHelper.readInt(this, "sys", "firtRunTime", 0) == 0)
    {
      this.firstRunTime = (int)(System.currentTimeMillis() / 1000L);
      PreferenceHelper.write(this, "sys", "firtRunTime", this.firstRunTime);
    }
    while (true)
    {
      this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      this.mWebView.setWebViewClient(new WebViewClient()
      {
        public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
        {
          MainActivity.this.HandlerKeyEvent(paramKeyEvent.getKeyCode(), paramKeyEvent);
          return super.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
        {
          paramWebView.loadUrl(paramString);
          return true;
        }
      });
      this.mWebView.setWebChromeClient(new WebChromeClient());
      this.mWebView.setOnKeyListener(this.mKeyListener);
      return;
      this.firstRunTime = PreferenceHelper.readInt(this, "sys", "firtRunTime");
    }
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    HandlerKeyEvent(paramInt, paramKeyEvent);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onPause()
  {
    super.onPause();
    unregisterReceiver(this.mBroadcast);
  }

  protected void onResume()
  {
    super.onResume();
    registerReceiver(this.mBroadcast, this.mFilter);
    this.mWebView.onResume();
    this.mTimeLoop = true;
    handleView();
  }

  class DevInfo
  {
    String sn;
    int time;

    DevInfo()
    {
    }
  }

  class TimeThread extends Thread
  {
    TimeThread()
    {
    }

    public void run()
    {
      super.run();
      while (MainActivity.this.mTimeLoop)
      {
        MainActivity.this.mHandler.sendEmptyMessage(0);
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.main.MainActivity
 * JD-Core Version:    0.6.0
 */