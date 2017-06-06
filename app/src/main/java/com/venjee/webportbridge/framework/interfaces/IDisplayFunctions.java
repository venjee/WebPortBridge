package com.skyworthdigital.framework.interfaces;

public abstract interface IDisplayFunctions
{
  public abstract String getBestMatchResolution();

  public abstract String getCurrentOutputMode();

  public abstract int[] getCurrentScreenPosition();

  public abstract String getHdmiSupportList();

  public abstract boolean isAvOutputmMode();

  public abstract boolean isBestOutputMode();

  public abstract void saveScreenPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void screenZoomIn();

  public abstract void screenZoomOut();

  public abstract void setBestOutputMode();

  public abstract void setOutputMode(String paramString);

  public abstract void setScreenPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IDisplayFunctions
 * JD-Core Version:    0.6.0
 */