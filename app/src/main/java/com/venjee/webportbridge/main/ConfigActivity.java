package com.venjee.webportbridge.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.venjee.webportbridge.R;
import com.venjee.webportbridge.bean.EthernetInfo;
import com.venjee.webportbridge.tools.EtherNetHelper;
import com.venjee.webportbridge.tools.PreferenceHelper;
import com.venjee.webportbridge.tools.SysHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class ConfigActivity extends Activity {
    public static int DAY_TIME_SECOND = 86400000;
    public static int HOUR_TIME_SECOND = 3600000;
    public static int MIN_TIME_SECOND = 60000;
    public static int SEC_TIME_SECOND = 1000;
    CompoundButton.OnCheckedChangeListener mCheckListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
            if (paramBoolean) {
                ConfigActivity.this.mIpAddress.setEnabled(true);
                ConfigActivity.this.mIpconfigView.setVisibility(View.VISIBLE);
                return;
            }
            ConfigActivity.this.mIpAddress.setEnabled(false);
            ConfigActivity.this.mIpconfigView.setVisibility(View.GONE);
        }
    };
    Button mConfirm;
    EditText mCtl;
    Button mDisplay;
    EditText mDns;
    EditText mGateway;
    Handler mHandler = new Handler() {
        public void handleMessage(Message paramMessage) {
            super.handleMessage(paramMessage);
            System.currentTimeMillis();
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            ConfigActivity.this.mTime.setText(time);
            ConfigActivity.this.mRuntime.setText("Runtime:" + ConfigActivity.this.getUptime());
        }
    };
    EditText mIpAddress;
    LinearLayout mIpconfigView;
    EditText mNetmask;
    TextView mRuntime;
    Switch mSwitchBtn;
    Switch mSwitchSc;
    TextView mTime;
    boolean mTimeLoop = true;
    TextView mVersion;
    int orientation;

    public static boolean IsIP(String paramString) {
        return !((paramString.length() < 7) || (paramString.length() > 15)
                || ("".equals(paramString)))
                && Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}")
                .matcher(paramString).find();
    }

    String getUptime() {
        StringBuilder localStringBuffer = new StringBuilder();
        long l = SystemClock.uptimeMillis();
        int i = (int) (l / DAY_TIME_SECOND);
        if (i > 0)
            localStringBuffer.append(i).append(":");
        i = (int) (l % DAY_TIME_SECOND / HOUR_TIME_SECOND);
        if (i <= 9)
            localStringBuffer.append(0);
        localStringBuffer.append(i).append(":");
        i = (int) (l % HOUR_TIME_SECOND) / MIN_TIME_SECOND;
        if (i <= 9)
            localStringBuffer.append(0);
        localStringBuffer.append(i).append(":");
        i = (int) (l % MIN_TIME_SECOND) / SEC_TIME_SECOND;
        if (i <= 9)
            localStringBuffer.append(0);
        localStringBuffer.append(i);
        return localStringBuffer.toString();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        ...
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) ;
        do
            return;
        while (getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.config_layout);
        this.mSwitchBtn = ((Switch) findViewById(2131427426));
        this.mSwitchSc = ((Switch) findViewById(2131427436));
        this.mIpconfigView = ((LinearLayout) findViewById(2131427429));
        this.mIpAddress = ((EditText) findViewById(2131427428));
        this.mGateway = ((EditText) findViewById(2131427431));
        this.mNetmask = ((EditText) findViewById(2131427433));
        this.mDns = ((EditText) findViewById(2131427435));
        this.mConfirm = ((Button) findViewById(2131427438));
        this.mDisplay = ((Button) findViewById(2131427439));
        this.mCtl = ((EditText) findViewById(2131427424));
        this.mTime = ((TextView) findViewById(2131427420));
        this.mVersion = ((TextView) findViewById(2131427443));
        this.mRuntime = ((TextView) findViewById(2131427440));
        this.mVersion.setText(SysHelper.getAPPVersionStringFromAPP(this));
        this.mRuntime.setText("Runtime:" + getUptime());
        new TimeThread().start();
    }

    protected void onPause() {
        super.onPause();
        this.mTimeLoop = false;
    }

    protected void onResume() {
        super.onResume();
        NetworkInfo info = ((ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        int j = 0;
        int i = j;
        if (info != null) {
            i = j;
            if (info.isConnected()) {
                i = j;
                if (info.getType() == 9)
                    i = 1;
            }
        }
        boolean bool1 = PreferenceHelper.readBoolean(this, "config", "dhcp", true);
        boolean bool2 = PreferenceHelper.readBoolean(this, "config", "sc", true);
        this.mSwitchSc.setChecked(bool2);
        this.mCtl.setText(PreferenceHelper.readString(this, "config", "host", ""));
        this.mGateway.setText(PreferenceHelper.readString(this, "config", "gateway", ""));
        this.mNetmask.setText(PreferenceHelper.readString(this, "config", "netmask", ""));
        this.mDns.setText(PreferenceHelper.readString(this, "config", "dns", ""));
        EthernetInfo ethernetInfo = EtherNetHelper.InitEthernet(this);
        if (!bool1) {
            this.mSwitchBtn.setChecked(false);
            this.mIpconfigView.setVisibility(View.GONE);
            this.mIpAddress.setEnabled(false);
            if (i != 0)
                this.mIpAddress.setText(ethernetInfo.getIpAddr());
        }
        while (true) {
            this.mSwitchBtn.setOnCheckedChangeListener(this.mCheckListener);
            this.mConfirm.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramView) {
                    PreferenceHelper.write(ConfigActivity.this, "config", "host", ConfigActivity.this.mCtl.getText().toString());
                    PreferenceHelper.write(ConfigActivity.this, "config", "sc", ConfigActivity.this.mSwitchSc.isChecked());
                    if (ConfigActivity.this.mSwitchBtn.isChecked()) {
                        ConfigActivity.this.mIpAddress.setEnabled(true);
                        if (!ConfigActivity.IsIP(ConfigActivity.this.mIpAddress.getText().toString()))
                            ;
                        do
                            return;
                        while ((!ConfigActivity.IsIP(ConfigActivity.this.mGateway.getText().toString()))
                                || (!ConfigActivity.IsIP(ConfigActivity.this.mNetmask.getText().toString()))
                                || (!ConfigActivity.IsIP(ConfigActivity.this.mDns.getText().toString())));
                        PreferenceHelper.write(ConfigActivity.this, "config", "ipaddress", ConfigActivity.this.mIpAddress.getText().toString());
                        PreferenceHelper.write(ConfigActivity.this, "config", "gateway", ConfigActivity.this.mGateway.getText().toString());
                        PreferenceHelper.write(ConfigActivity.this, "config", "dns", ConfigActivity.this.mDns.getText().toString());
                        PreferenceHelper.write(ConfigActivity.this, "config", "netmask", ConfigActivity.this.mNetmask.getText().toString());
                        PreferenceHelper.write(ConfigActivity.this, "config", "dhcp", ConfigActivity.this.mSwitchBtn.isChecked());
                        SysHelper.ConfigIp(ConfigActivity.this, ConfigActivity.this.mIpAddress.getText().toString(), ConfigActivity.this.mGateway.getText().toString(), ConfigActivity.this.mNetmask.getText().toString(), ConfigActivity.this.mDns.getText().toString());
                    }
                    while (true) {
                        ConfigActivity.this.finish();
                        return;
                        ConfigActivity.this.mIpAddress.setEnabled(false);
                        SysHelper.ConfigIp(ConfigActivity.this, "", null, null, null);
                        PreferenceHelper.write(ConfigActivity.this, "config", "dhcp", ConfigActivity.this.mSwitchBtn.isChecked());
                    }
                }
            });
            this.mDisplay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramView) {
                    Intent intent = new Intent(ConfigActivity.this, PositionSetting.class);
                    ConfigActivity.this.startActivity(intent);
                }
            });
            return;
            this.mIpAddress.setText("Network Not Available");
            continue;
            this.mSwitchBtn.setChecked(true);
            this.mIpAddress.setEnabled(true);
            this.mGateway.setText(PreferenceHelper.readString(this, "config", "gateway", ""));
            this.mNetmask.setText(PreferenceHelper.readString(this, "config", "netmask", ""));
            this.mDns.setText(PreferenceHelper.readString(this, "config", "dns", ""));
            this.mIpAddress.setText(PreferenceHelper.readString(this, "config", "ipaddress", ""));
            this.mIpconfigView.setVisibility(View.VISIBLE);
        }
    }

    class TimeThread extends Thread {
        TimeThread() {
        }

        public void run() {
            super.run();
            while (ConfigActivity.this.mTimeLoop) {
                ConfigActivity.this.mHandler.sendEmptyMessage(0);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException localInterruptedException) {
                    localInterruptedException.printStackTrace();
                }
            }
        }
    }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.main.ConfigActivity
 * JD-Core Version:    0.6.0
 */