package com.skyworthdigital.framework;

import android.content.Context;
import com.skyworthdigital.framework.interfaces.IBluetoothFunctions;
import com.skyworthdigital.framework.interfaces.IChipInterfaceFactory;
import com.skyworthdigital.framework.interfaces.IDisplayFunctions;
import com.skyworthdigital.framework.interfaces.INetworkFunctions;
import com.skyworthdigital.framework.interfaces.IOtherFunctions;
import com.skyworthdigital.framework.interfaces.IPowerFunctions;

public class SimpleInterfaceFactory
{
  private static final String INTERFACE_FACTORY_CLASS_NAME = "com.skyworthdigital.framework.InterfaceFactoryImp";
  private static IChipInterfaceFactory mChipInterfaceFactory;
  private static SimpleInterfaceFactory mInstance;

  private SimpleInterfaceFactory(Context paramContext)
  {
    if (mChipInterfaceFactory == null)
      mChipInterfaceFactory = initChipFactory(paramContext);
  }

  public static SimpleInterfaceFactory getInstance(Context paramContext)
  {
    if (mInstance == null);
    monitorenter;
    try
    {
      if (mInstance == null)
        mInstance = new SimpleInterfaceFactory(paramContext);
      return mInstance;
    }
    finally
    {
      monitorexit;
    }
    throw paramContext;
  }

  private static IChipInterfaceFactory initChipFactory(Context paramContext)
  {
    return Utils.reflectChipInterfaceFactory(paramContext, "com.skyworthdigital.framework.InterfaceFactoryImp");
  }

  public IBluetoothFunctions creatBluetoothInterface()
    throws NullPointerException
  {
    return mChipInterfaceFactory.getBluetoothFramworkFN();
  }

  public IDisplayFunctions creatDisplayInterface()
    throws NullPointerException
  {
    return mChipInterfaceFactory.getDisplayFrameworkFN();
  }

  public INetworkFunctions creatNetworkInterface()
    throws NullPointerException
  {
    return mChipInterfaceFactory.getNetworkFrameworkFN();
  }

  public IOtherFunctions creatOtherInterface()
    throws NullPointerException
  {
    return mChipInterfaceFactory.getOtherBaseFramworkFN();
  }

  public IPowerFunctions creatPowerInterface()
    throws NullPointerException
  {
    return mChipInterfaceFactory.getPowerFramworkFN();
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.SimpleInterfaceFactory
 * JD-Core Version:    0.6.0
 */