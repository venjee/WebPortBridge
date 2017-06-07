package com.venjee.webportbridge.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceHelper
{
  public static void clean(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.clear();
    paramContext.commit();
  }

  public static boolean readBoolean(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, false);
  }

  public static boolean readBoolean(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, paramBoolean);
  }

  public static int readInt(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }

  public static int readInt(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, paramInt);
  }

  public static String readString(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, null);
  }

  public static String readString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
  }

  public static void remove(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.remove(paramString2);
    paramContext.commit();
  }

  public static void write(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.commit();
  }

  public static void write(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
  }

  public static void write(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putBoolean(paramString2, paramBoolean);
    paramContext.commit();
  }
}