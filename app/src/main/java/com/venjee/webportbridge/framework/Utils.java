package com.skyworthdigital.framework;

import android.content.Context;
import com.skyworthdigital.framework.interfaces.IChipInterfaceFactory;
import java.lang.reflect.Constructor;

public class Utils
{
  public static IChipInterfaceFactory reflectChipInterfaceFactory(Context paramContext, String paramString)
  {
    try
    {
      paramContext = (IChipInterfaceFactory)Class.forName(paramString).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.Utils
 * JD-Core Version:    0.6.0
 */