package com.venjee.webportbridge.bean;

public class EthernetInfo
{
  String dns;
  String gateway;
  String hwAddr;
  String ipAddr;
  boolean isDhcp;
  String netmask;

  public String getDns()
  {
    return this.dns;
  }

  public String getGateway()
  {
    return this.gateway;
  }

  public String getHwAddr()
  {
    return this.hwAddr;
  }

  public String getIpAddr()
  {
    return this.ipAddr;
  }

  public String getNetmask()
  {
    return this.netmask;
  }

  public boolean isDhcp()
  {
    return this.isDhcp;
  }

  public void setDhcp(boolean paramBoolean)
  {
    this.isDhcp = paramBoolean;
  }

  public void setDns(String paramString)
  {
    this.dns = paramString;
  }

  public void setGateway(String paramString)
  {
    this.gateway = paramString;
  }

  public void setHwAddr(String paramString)
  {
    this.hwAddr = paramString;
  }

  public void setIpAddr(String paramString)
  {
    this.ipAddr = paramString;
  }

  public void setNetmask(String paramString)
  {
    this.netmask = paramString;
  }
}