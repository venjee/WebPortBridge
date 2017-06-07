package com.venjee.webportbridge.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class SysHelper {
    public static void ConfigIp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
        Intent localIntent = new Intent(ActionString.IP_CFG);
        localIntent.putExtra("ipaddr", paramString1);
        localIntent.putExtra("netmask", paramString3);
        localIntent.putExtra("gateway", paramString2);
        localIntent.putExtra("dns", paramString4);
        paramContext.sendBroadcast(localIntent);
    }

    public static void InstallApk(Context paramContext, String paramString) {
        Intent localIntent = new Intent(ActionString.INSTALL_APK);
        localIntent.putExtra("file", paramString);
        paramContext.sendBroadcast(localIntent);
    }

    public static void Reboot(Context paramContext) {
        paramContext.sendBroadcast(new Intent(ActionString.REBOOT_SYS));
    }

    public static void RebootRecovery(Context paramContext) {
        paramContext.sendBroadcast(new Intent(ActionString.REBOOT_RECOVERY));
    }

    public static void TrunOnOffAdb(Context paramContext, boolean paramBoolean) {
        Intent localIntent = new Intent(ActionString.ADB_ON_OFF);
        localIntent.putExtra("enable", paramBoolean);
        paramContext.sendBroadcast(localIntent);
    }

    public static void TrunOnOffEthernet(Context paramContext, boolean paramBoolean) {
        Intent localIntent = new Intent(ActionString.ETHERNET_ON_OFF);
        localIntent.putExtra("data", paramBoolean);
        paramContext.sendBroadcast(localIntent);
    }

    public static int getAPPVersionCodeFromAPP(Context paramContext) {
        PackageManager packageManager = paramContext.getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(paramContext.getPackageName(), 0);
            System.out.println(info.versionCode + " " + info.versionName);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getAPPVersionStringFromAPP(Context paramContext) {
        PackageManager packageManager = paramContext.getPackageManager();
        try {
            return packageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}