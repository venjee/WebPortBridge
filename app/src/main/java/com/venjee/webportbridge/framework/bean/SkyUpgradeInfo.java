package com.skyworthdigital.framework.bean;

public class SkyUpgradeInfo
{
  private boolean mHasUpgrade;
  private String mNewVersion;

  public String getNewVersion()
  {
    return this.mNewVersion;
  }

  public boolean hasUpgrade()
  {
    return this.mHasUpgrade;
  }

  public void setNewVersion(String paramString)
  {
    this.mNewVersion = paramString;
  }

  public void sethasUpgrade(boolean paramBoolean)
  {
    this.mHasUpgrade = paramBoolean;
  }

  public String toString()
  {
    return this.mHasUpgrade + ", mNewVersion=" + this.mNewVersion + "]";
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.bean.SkyUpgradeInfo
 * JD-Core Version:    0.6.0
 */