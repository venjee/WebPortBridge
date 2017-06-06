package com.skyworthdigital.framework.interfaces;

public abstract class INetworkFunctions
  implements IBroadCastFunctions
{
  public static final int INVALID_NETWORK_ID = -127;
  public static final int SHOW_INPUT_PASSWORD_DIALOG = 65295;

  public abstract void disablePPPoe();

  public abstract String[] getMac();

  public abstract boolean getWifiApState();

  public abstract boolean isCablePlugin();

  public abstract boolean isPPPoeConnected();

  public abstract boolean isPPPoeEnable();

  public abstract boolean isWifiEnabled();

  public abstract void saveEthernetConfig(String[] paramArrayOfString);

  public abstract void setWifiApState(boolean paramBoolean);

  public abstract void setWifiEnabled(boolean paramBoolean);
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.INetworkFunctions
 * JD-Core Version:    0.6.0
 */