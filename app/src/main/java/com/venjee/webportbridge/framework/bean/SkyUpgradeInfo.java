package com.venjee.webportbridge.framework.bean;

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