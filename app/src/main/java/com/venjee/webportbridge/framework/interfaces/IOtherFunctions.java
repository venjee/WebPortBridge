package com.skyworthdigital.framework.interfaces;

public abstract interface IOtherFunctions extends IBroadCastFunctions
{
  public abstract boolean getAdbDebugEnable();

  public abstract String getAndroidVersion();

  public abstract boolean getCECDebugEnable();

  public abstract void getMemoryUseInfo(long[] paramArrayOfLong);

  public abstract String getProductModel();

  public abstract String getSerialId();

  public abstract String getSoftVersion();

  public abstract void getStorageUseInfo(INotifyStorageSize paramINotifyStorageSize);

  public abstract boolean isRemoteDeviceSupportCEC();

  public abstract void resetFactory(boolean paramBoolean);

  public abstract void setAdbDebugEnable(boolean paramBoolean);

  public abstract void setCECEnable(boolean paramBoolean);

  public abstract void setEnableAutoRunningComponents(String paramString);

  public abstract void setEnableRunningBackgroudComponents(String paramString);

  public abstract void setLauncherComponents(String paramString);

  public abstract void setWallpaper(int paramInt);
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IOtherFunctions
 * JD-Core Version:    0.6.0
 */