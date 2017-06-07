package com.venjee.webportbridge.tools;

import android.content.Context;
import java.lang.reflect.Method;

public class SysPropHelper
{
  public static String MBOX_OUTPUT_MODE;
  public static String POSITION_SETTINGS;
  public static String SysWriteServer = "android.app.SystemWriteManager";
  private static Class<?> mBoxServerCls;
  private static Object mBoxServerObj;
  private static Context mContext;
  private static Class<?> mDisplayCls;
  private static Object mDisplayObj;
  private static Object mSysWriteSvr;
  private static Class<?> mSysWriterCls;

  static
  {
    MBOX_OUTPUT_MODE = "android.app.MboxOutputModeManager";
    POSITION_SETTINGS = "com.skyworthdigital.framework.amlogic.s805.AMLS805DisplayFunctionsImp";
    mSysWriterCls = null;
    mSysWriteSvr = null;
    mBoxServerCls = null;
    mBoxServerObj = null;
    mDisplayCls = null;
    mDisplayObj = null;
  }

  public static void InitDisplay(Context paramContext)
  {
    int i = 0;
    if (mDisplayObj == null)
      try
      {
        mDisplayCls = Class.forName(POSITION_SETTINGS);
        Method[] arrayOfMethod = mDisplayCls.getDeclaredMethods();
        int j = arrayOfMethod.length;
        while (i < j)
        {
          Method localMethod = arrayOfMethod[i];
          System.out.println("####:" + localMethod.toString());
          i += 1;
        }
        mDisplayObj = mDisplayCls.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        if (mDisplayObj != null)
        {
          System.out.println("####:OK created!!!");
          return;
        }
        System.out.println("####:F created!!!");
      } catch (ReflectiveOperationException | SecurityException e)
      {
        e.printStackTrace();
      }
  }

  public static void InitSys(Context paramContext)
  {
    mContext = paramContext;
    if (mSysWriteSvr == null);
    try
    {
      mSysWriterCls = Class.forName(SysWriteServer);
      mSysWriteSvr = paramContext.getSystemService("system_write");
      if (mBoxServerObj != null);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        mBoxServerCls = Class.forName(MBOX_OUTPUT_MODE);
        mBoxServerObj = paramContext.getSystemService("mbox_outputmode_service");
        paramContext = mBoxServerCls.getDeclaredMethods();
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramContext[i];
          System.out.println(localObject.toString());
          i += 1;
          continue;
          localClassNotFoundException = localClassNotFoundException;
          localClassNotFoundException.printStackTrace();
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }

  public static boolean getBooleanProp(Context paramContext, String paramString, boolean paramBoolean)
  {
    InitSys(paramContext);
    return ((Boolean)getValue("getPropertyBoolean", paramString, Boolean.TYPE, Boolean.valueOf(paramBoolean))).booleanValue();
  }

  // ERROR //
  public static String getCurrentOutputMode()
  {
    // Byte code:
    //   0: getstatic 43	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayCls	Ljava/lang/Class;
    //   3: ldc 160
    //   5: iconst_0
    //   6: anewarray 59	java/lang/Class
    //   9: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   12: astore_0
    //   13: aload_0
    //   14: getstatic 45	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayObj	Ljava/lang/Object;
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 170	java/lang/String
    //   27: astore_0
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   63: aconst_null
    //   64: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   13	28	30	java/lang/IllegalAccessException
    //   0	13	37	java/lang/NoSuchMethodException
    //   13	28	37	java/lang/NoSuchMethodException
    //   31	35	37	java/lang/NoSuchMethodException
    //   45	49	37	java/lang/NoSuchMethodException
    //   59	63	37	java/lang/NoSuchMethodException
    //   13	28	44	java/lang/IllegalArgumentException
    //   0	13	51	java/lang/SecurityException
    //   13	28	51	java/lang/SecurityException
    //   31	35	51	java/lang/SecurityException
    //   45	49	51	java/lang/SecurityException
    //   59	63	51	java/lang/SecurityException
    //   13	28	58	java/lang/reflect/InvocationTargetException
  }

  // ERROR //
  public static int[] getCurrentScreenPosition()
  {
    // Byte code:
    //   0: getstatic 43	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayCls	Ljava/lang/Class;
    //   3: ldc 177
    //   5: iconst_0
    //   6: anewarray 59	java/lang/Class
    //   9: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   12: astore_0
    //   13: aload_0
    //   14: getstatic 45	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayObj	Ljava/lang/Object;
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 179	[I
    //   27: checkcast 179	[I
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   13	31	33	java/lang/IllegalAccessException
    //   0	13	40	java/lang/NoSuchMethodException
    //   13	31	40	java/lang/NoSuchMethodException
    //   34	38	40	java/lang/NoSuchMethodException
    //   48	52	40	java/lang/NoSuchMethodException
    //   62	66	40	java/lang/NoSuchMethodException
    //   13	31	47	java/lang/IllegalArgumentException
    //   0	13	54	java/lang/SecurityException
    //   13	31	54	java/lang/SecurityException
    //   34	38	54	java/lang/SecurityException
    //   48	52	54	java/lang/SecurityException
    //   62	66	54	java/lang/SecurityException
    //   13	31	61	java/lang/reflect/InvocationTargetException
  }

  public static int getIntProp(Context paramContext, String paramString, int paramInt)
  {
    InitSys(paramContext);
    return ((Integer)getValue("getPropertyInt", paramString, Integer.TYPE, Integer.valueOf(paramInt))).intValue();
  }

  public static long getLongProp(Context paramContext, String paramString, long paramLong)
  {
    InitSys(paramContext);
    return ((Integer)getValue("getPropertyLong", paramString, Long.TYPE, Long.valueOf(paramLong))).intValue();
  }

  public static String getStringProp(Context paramContext, String paramString)
  {
    InitSys(paramContext);
    return (String)getValue("getProperty", paramString);
  }

  public static long getStringPropDef(Context paramContext, String paramString1, String paramString2)
  {
    InitSys(paramContext);
    return ((Integer)getValue("getPropertyString", paramString1, String.class, paramString2)).intValue();
  }

  // ERROR //
  private static Object getValue(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 35	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriterCls	Ljava/lang/Class;
    //   3: aload_0
    //   4: iconst_1
    //   5: anewarray 59	java/lang/Class
    //   8: dup
    //   9: iconst_0
    //   10: ldc 170
    //   12: aastore
    //   13: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   16: astore_0
    //   17: aload_0
    //   18: getstatic 37	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriteSvr	Ljava/lang/Object;
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   32: astore_0
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   68: aconst_null
    //   69: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   17	33	35	java/lang/IllegalAccessException
    //   0	17	42	java/lang/NoSuchMethodException
    //   17	33	42	java/lang/NoSuchMethodException
    //   36	40	42	java/lang/NoSuchMethodException
    //   50	54	42	java/lang/NoSuchMethodException
    //   64	68	42	java/lang/NoSuchMethodException
    //   17	33	49	java/lang/IllegalArgumentException
    //   0	17	56	java/lang/SecurityException
    //   17	33	56	java/lang/SecurityException
    //   36	40	56	java/lang/SecurityException
    //   50	54	56	java/lang/SecurityException
    //   64	68	56	java/lang/SecurityException
    //   17	33	63	java/lang/reflect/InvocationTargetException
  }

  // ERROR //
  private static Object getValue(String paramString1, String paramString2, Class paramClass, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 35	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriterCls	Ljava/lang/Class;
    //   3: aload_0
    //   4: iconst_2
    //   5: anewarray 59	java/lang/Class
    //   8: dup
    //   9: iconst_0
    //   10: ldc 170
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: aload_2
    //   16: aastore
    //   17: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   20: astore_0
    //   21: aload_0
    //   22: getstatic 37	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriteSvr	Ljava/lang/Object;
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_1
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_3
    //   36: aastore
    //   37: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: areturn
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   62: aconst_null
    //   63: areturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   21	41	43	java/lang/IllegalAccessException
    //   0	21	50	java/lang/NoSuchMethodException
    //   21	41	50	java/lang/NoSuchMethodException
    //   44	48	50	java/lang/NoSuchMethodException
    //   58	62	50	java/lang/NoSuchMethodException
    //   72	76	50	java/lang/NoSuchMethodException
    //   21	41	57	java/lang/IllegalArgumentException
    //   0	21	64	java/lang/SecurityException
    //   21	41	64	java/lang/SecurityException
    //   44	48	64	java/lang/SecurityException
    //   58	62	64	java/lang/SecurityException
    //   72	76	64	java/lang/SecurityException
    //   21	41	71	java/lang/reflect/InvocationTargetException
  }

  public static String readSysfs(Context paramContext, String paramString)
  {
    InitSys(paramContext);
    return (String)getValue("readSysfs", paramString);
  }

  // ERROR //
  public static void saveScreenPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: getstatic 43	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayCls	Ljava/lang/Class;
    //   3: ldc 219
    //   5: iconst_4
    //   6: anewarray 59	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   26: aastore
    //   27: dup
    //   28: iconst_3
    //   29: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   32: aastore
    //   33: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: astore 4
    //   38: aload 4
    //   40: getstatic 45	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayObj	Ljava/lang/Object;
    //   43: iconst_4
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: iload_0
    //   50: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: iload_1
    //   57: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: iload_2
    //   64: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_3
    //   70: iload_3
    //   71: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: return
    //   80: astore 4
    //   82: aload 4
    //   84: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   87: return
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   95: return
    //   96: astore 4
    //   98: aload 4
    //   100: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   103: return
    //   104: astore 4
    //   106: aload 4
    //   108: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   111: return
    //   112: astore 4
    //   114: aload 4
    //   116: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   119: return
    //
    // Exception table:
    //   from	to	target	type
    //   38	79	80	java/lang/IllegalAccessException
    //   0	38	88	java/lang/NoSuchMethodException
    //   38	79	88	java/lang/NoSuchMethodException
    //   82	87	88	java/lang/NoSuchMethodException
    //   98	103	88	java/lang/NoSuchMethodException
    //   114	119	88	java/lang/NoSuchMethodException
    //   38	79	96	java/lang/IllegalArgumentException
    //   0	38	104	java/lang/SecurityException
    //   38	79	104	java/lang/SecurityException
    //   82	87	104	java/lang/SecurityException
    //   98	103	104	java/lang/SecurityException
    //   114	119	104	java/lang/SecurityException
    //   38	79	112	java/lang/reflect/InvocationTargetException
  }

  public static void setOutputMode(Context paramContext, String paramString)
  {
    InitSys(paramContext);
    setOutputValue("setOutputMode", paramString);
  }

  // ERROR //
  private static void setOutputValue(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 39	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mBoxServerCls	Ljava/lang/Class;
    //   3: aload_0
    //   4: iconst_1
    //   5: anewarray 59	java/lang/Class
    //   8: dup
    //   9: iconst_0
    //   10: ldc 170
    //   12: aastore
    //   13: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   16: astore_0
    //   17: aload_0
    //   18: getstatic 41	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mBoxServerObj	Ljava/lang/Object;
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: return
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   39: return
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   45: return
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   51: return
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   57: return
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   63: return
    //
    // Exception table:
    //   from	to	target	type
    //   17	33	34	java/lang/IllegalAccessException
    //   0	17	40	java/lang/NoSuchMethodException
    //   17	33	40	java/lang/NoSuchMethodException
    //   35	39	40	java/lang/NoSuchMethodException
    //   47	51	40	java/lang/NoSuchMethodException
    //   59	63	40	java/lang/NoSuchMethodException
    //   17	33	46	java/lang/IllegalArgumentException
    //   0	17	52	java/lang/SecurityException
    //   17	33	52	java/lang/SecurityException
    //   35	39	52	java/lang/SecurityException
    //   47	51	52	java/lang/SecurityException
    //   59	63	52	java/lang/SecurityException
    //   17	33	58	java/lang/reflect/InvocationTargetException
  }

  public static void setProp(Context paramContext, String paramString1, String paramString2)
  {
    InitSys(paramContext);
    setValue("setProperty", paramString1, paramString2);
  }

  // ERROR //
  public static void setScreenPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: getstatic 43	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayCls	Ljava/lang/Class;
    //   3: ldc 236
    //   5: iconst_4
    //   6: anewarray 59	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   26: aastore
    //   27: dup
    //   28: iconst_3
    //   29: getstatic 186	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   32: aastore
    //   33: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: astore 4
    //   38: aload 4
    //   40: getstatic 45	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mDisplayObj	Ljava/lang/Object;
    //   43: iconst_4
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: iload_0
    //   50: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: iload_1
    //   57: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: iload_2
    //   64: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_3
    //   70: iload_3
    //   71: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: return
    //   80: astore 4
    //   82: aload 4
    //   84: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   87: return
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   95: return
    //   96: astore 4
    //   98: aload 4
    //   100: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   103: return
    //   104: astore 4
    //   106: aload 4
    //   108: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   111: return
    //   112: astore 4
    //   114: aload 4
    //   116: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   119: return
    //
    // Exception table:
    //   from	to	target	type
    //   38	79	80	java/lang/IllegalAccessException
    //   0	38	88	java/lang/NoSuchMethodException
    //   38	79	88	java/lang/NoSuchMethodException
    //   82	87	88	java/lang/NoSuchMethodException
    //   98	103	88	java/lang/NoSuchMethodException
    //   114	119	88	java/lang/NoSuchMethodException
    //   38	79	96	java/lang/IllegalArgumentException
    //   0	38	104	java/lang/SecurityException
    //   38	79	104	java/lang/SecurityException
    //   82	87	104	java/lang/SecurityException
    //   98	103	104	java/lang/SecurityException
    //   114	119	104	java/lang/SecurityException
    //   38	79	112	java/lang/reflect/InvocationTargetException
  }

  public static void setSysOutputMode(Context paramContext, String paramString)
  {
    setProp(paramContext, "ubootenv.var.prepare", "video open;video clear;video dev open " + paramString);
    if (!paramString.equals(readSysfs(paramContext, "/sys/class/display/mode")))
    {
      setOutputMode(paramContext, paramString);
      Settings.Global.putInt(mContext.getContentResolver(), "display_outputmode_auto", 0);
    }
  }

  public static void setSysfs(Context paramContext, String paramString1, String paramString2)
  {
    InitSys(paramContext);
    setValue("writeSysfs", paramString1, paramString2);
  }

  // ERROR //
  private static void setValue(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: getstatic 35	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriterCls	Ljava/lang/Class;
    //   3: aload_0
    //   4: iconst_2
    //   5: anewarray 59	java/lang/Class
    //   8: dup
    //   9: iconst_0
    //   10: ldc 170
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 170
    //   17: aastore
    //   18: invokevirtual 164	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: astore_0
    //   22: aload_0
    //   23: getstatic 37	com/skyworthdigital/sky2dlauncher/tools/SysPropHelper:mSysWriteSvr	Ljava/lang/Object;
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_2
    //   37: aastore
    //   38: invokevirtual 168	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: return
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 171	java/lang/IllegalAccessException:printStackTrace	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 172	java/lang/NoSuchMethodException:printStackTrace	()V
    //   54: return
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 173	java/lang/IllegalArgumentException:printStackTrace	()V
    //   60: return
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 116	java/lang/SecurityException:printStackTrace	()V
    //   66: return
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 174	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   72: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	42	43	java/lang/IllegalAccessException
    //   0	22	49	java/lang/NoSuchMethodException
    //   22	42	49	java/lang/NoSuchMethodException
    //   44	48	49	java/lang/NoSuchMethodException
    //   56	60	49	java/lang/NoSuchMethodException
    //   68	72	49	java/lang/NoSuchMethodException
    //   22	42	55	java/lang/IllegalArgumentException
    //   0	22	61	java/lang/SecurityException
    //   22	42	61	java/lang/SecurityException
    //   44	48	61	java/lang/SecurityException
    //   56	60	61	java/lang/SecurityException
    //   68	72	61	java/lang/SecurityException
    //   22	42	67	java/lang/reflect/InvocationTargetException
  }
}