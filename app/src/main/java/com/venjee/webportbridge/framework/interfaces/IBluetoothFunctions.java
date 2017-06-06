package com.skyworthdigital.framework.interfaces;

public abstract interface IBluetoothFunctions extends IBroadCastFunctions
{
  public abstract String getConnectedBluetoothDevice();

  public abstract boolean getRemoteControllerConnectState();

  public abstract boolean isSupportBluetooth();
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IBluetoothFunctions
 * JD-Core Version:    0.6.0
 */