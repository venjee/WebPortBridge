package com.skyworthdigital.framework.interfaces;

import com.skyworthdigital.framework.bean.SkyNetworkInfo;
import com.skyworthdigital.framework.bean.SkyUpgradeInfo;

public abstract interface IHandleBroadcastNotify
{
  public abstract void notifyNetWorkInfo(SkyNetworkInfo paramSkyNetworkInfo);

  public abstract void notifyRefreshAPList();

  public abstract void notifyUpgradeInfo(SkyUpgradeInfo paramSkyUpgradeInfo);

  public abstract void notifyWiFiStateChanged(WifiState paramWifiState);

  public static enum WifiState
  {
    static
    {
      $VALUES = new WifiState[] { WIFI_STATE_DISABLED, WIFI_STATE_DISABLING, WIFI_STATE_ENABLED, WIFI_STATE_ENABLING, WIFI_STATE_UNKNOWN };
    }
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IHandleBroadcastNotify
 * JD-Core Version:    0.6.0
 */