package com.venjee.webportbridge.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.PrintStream;

public class SysHelper
{
  public static void ConfigIp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(ActionString.IP_CFG);
    localIntent.putExtra("ipaddr", paramString1);
    localIntent.putExtra("netmask", paramString3);
    localIntent.putExtra("gateway", paramString2);
    localIntent.putExtra("dns", paramString4);
    paramContext.sendBroadcast(localIntent);
  }

  public static void InstallApk(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(ActionString.INSTALL_APK);
    localIntent.putExtra("file", paramString);
    paramContext.sendBroadcast(localIntent);
  }

  public static void Reboot(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent(ActionString.REBOOT_SYS));
  }

  public static void RebootRecovery(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent(ActionString.REBOOT_RECOVERY));
  }

  public static void TrunOnOffAdb(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(ActionString.ADB_ON_OFF);
    localIntent.putExtra("enable", paramBoolean);
    paramContext.sendBroadcast(localIntent);
  }

  public static void TrunOnOffEthernet(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(ActionString.ETHERNET_ON_OFF);
    localIntent.putExtra("data", paramBoolean);
    paramContext.sendBroadcast(localIntent);
  }

  public static int getAPPVersionCodeFromAPP(Context paramContext)
  {
    int j = 0;
    Object localObject = paramContext.getPackageManager();
    int i = j;
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
      i = j;
      localObject = paramContext.versionName;
      i = j;
      j = paramContext.versionCode;
      i = j;
      System.out.println(j + " " + (String)localObject);
      return j;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return i;
  }

  public static String getAPPVersionStringFromAPP(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.tools.SysHelper
 * JD-Core Version:    0.6.0
 */