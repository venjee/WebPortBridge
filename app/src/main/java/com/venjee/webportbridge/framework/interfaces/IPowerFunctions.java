package com.skyworthdigital.framework.interfaces;

import android.content.ComponentName;

public abstract interface IPowerFunctions
{
  public abstract int getScreensaverTime();

  public abstract int getStandbyTime();

  public abstract void setDreamComponents(ComponentName[] paramArrayOfComponentName);

  public abstract void setDreamEnablePackageNames(String paramString);

  public abstract void setScreensaverTime(int paramInt);

  public abstract void setStandbyTime(int paramInt);
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IPowerFunctions
 * JD-Core Version:    0.6.0
 */