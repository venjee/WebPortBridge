package com.skyworthdigital.framework.interfaces;

public abstract interface IChipInterfaceFactory
{
  public abstract IBluetoothFunctions getBluetoothFramworkFN();

  public abstract IDisplayFunctions getDisplayFrameworkFN();

  public abstract INetworkFunctions getNetworkFrameworkFN();

  public abstract IOtherFunctions getOtherBaseFramworkFN();

  public abstract IPowerFunctions getPowerFramworkFN();
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IChipInterfaceFactory
 * JD-Core Version:    0.6.0
 */