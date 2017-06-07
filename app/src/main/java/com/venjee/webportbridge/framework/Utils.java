package com.venjee.webportbridge.framework;

import android.content.Context;

import com.skyworthdigital.framework.interfaces.IChipInterfaceFactory;

public class Utils
{
  public static IChipInterfaceFactory reflectChipInterfaceFactory(Context paramContext, String paramString)
  {
    try
    {
      IChipInterfaceFactory factory = (IChipInterfaceFactory)Class.forName(paramString)
              .getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      return factory;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
}