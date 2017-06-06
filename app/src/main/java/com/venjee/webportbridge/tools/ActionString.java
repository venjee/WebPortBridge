package com.venjee.webportbridge.tools;

public class ActionString
{
  public static String ADB_ON_OFF;
  public static String ETHERNET_ON_OFF = "com.cgm.ethernet.on_off";
  public static String GET_DISPLAY;
  public static String GET_PROP;
  public static String HDMI_CFG;
  public static String INSTALL_APK;
  public static String IP_CFG;
  public static String REBOOT_RECOVERY;
  public static String REBOOT_SYS;
  public static String SET_DISPLAY;
  public static String SET_PROP;
  public static String UPDATE_APK;
  public static String UPDATE_FIRMWARE;

  static
  {
    ADB_ON_OFF = "com.cgm.adb.scan.on_off";
    INSTALL_APK = "com.cgm.install.cfg";
    HDMI_CFG = "com.cgm.hdmi.cfg";
    IP_CFG = "com.cgm.ip.cfg";
    REBOOT_RECOVERY = "com.cgm.reboot.recovery";
    REBOOT_SYS = "com.cgm.reboot.sys";
    GET_DISPLAY = "com.cgm.get.display";
    SET_DISPLAY = "com.cgm.set.display";
    GET_PROP = "com.cgm.get.prop";
    SET_PROP = "com.cgm.set.prop";
    UPDATE_FIRMWARE = "com.cgm.update.zip";
    UPDATE_APK = "com.cgm.update.apk";
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.tools.ActionString
 * JD-Core Version:    0.6.0
 */