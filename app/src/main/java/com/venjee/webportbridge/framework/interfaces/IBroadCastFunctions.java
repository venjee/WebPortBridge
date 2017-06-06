package com.skyworthdigital.framework.interfaces;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract interface IBroadCastFunctions
{
  public abstract IntentFilter getBroadcastIntentFilter();

  public abstract void handleBroadcast(Intent paramIntent, IHandleBroadcastNotify paramIHandleBroadcastNotify);

  public abstract void registerHandleBroadCastNotify(Context paramContext, IHandleBroadcastNotify paramIHandleBroadcastNotify);

  public abstract void unregisterReceiver(Context paramContext);
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.framework.interfaces.IBroadCastFunctions
 * JD-Core Version:    0.6.0
 */