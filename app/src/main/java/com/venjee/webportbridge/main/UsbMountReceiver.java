package com.venjee.webportbridge.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.venjee.webportbridge.tools.ActionString;

import java.io.File;

public class UsbMountReceiver extends BroadcastReceiver
{
  Context mContext;
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      String path = (String)paramMessage.obj;
      File zipFile = new File(path + "/update.zip");
      File localFile = new File(path + "/factory_update_param.aml");
      localObject = new File(path + "/update.ipm");
      System.out.println("###########update check :ok");
      if ((zipFile.exists()) && (localFile.exists()))
      {
        System.out.println("###########update file :ok");
        paramMessage = new Intent(ActionString.UPDATE_FIRMWARE);
        UsbMountReceiver.this.mContext.sendBroadcast(paramMessage);
      }
      do
        return;
      while (!((File)localObject).exists());
      paramMessage = new Intent(ActionString.UPDATE_APK);
      paramMessage.putExtra("file", ((File)localObject).getPath());
      UsbMountReceiver.this.mContext.sendBroadcast(paramMessage);
    }
  };

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals(Intent.ACTION_MEDIA_MOUNTED))
    {
      System.out.println("######mount#" + paramIntent.getDataString());
      this.mContext = paramContext;
      String path = paramIntent.getDataString().split("file://")[1];
      Message msg = mHandler.obtainMessage(0);
      msg.obj = path;
      this.mHandler.sendMessageDelayed(msg, 3000L);
    }
  }
}