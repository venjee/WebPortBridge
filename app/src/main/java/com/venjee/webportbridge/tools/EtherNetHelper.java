package com.venjee.webportbridge.tools;

import android.content.Context;

import com.venjee.webportbridge.bean.EthernetInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EtherNetHelper
{
  public static final int ETHERNET_DEVICE_SCAN_RESULT_READY = 0;
  public static final String ETHERNET_DISLINKED_ACTION = "android.net.ethernet.DISLINKED_ACTION";
  public static final String ETHERNET_LINKED_ACTION = "android.net.ethernet.LINKED_ACTION";
  public static final String ETHERNET_STATE_CHANGED_ACTION = "android.net.ethernet.ETHERNET_STATE_CHANGED";
  public static final int ETHERNET_STATE_DISABLED = 0;
  public static final int ETHERNET_STATE_ENABLED = 1;
  public static final int EVENT_CONFIGURATION_FAILED = 2;
  public static final int EVENT_CONFIGURATION_SUCCEEDED = 1;
  public static final int EVENT_DEVREM = 8;
  public static final int EVENT_DHCP_START = 0;
  public static final int EVENT_DISCONNECTED = 5;
  public static final int EVENT_NEWDEV = 3;
  public static final String EXTRA_ETHERNET_INFO = "ethernetInfo";
  public static final String EXTRA_ETHERNET_STATE = "ethernet_state";
  public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
  public static final String EXTRA_NETWORK_INFO = "networkInfo";
  public static final String EXTRA_PPPOE_STATE = "pppoe_state";
  public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.ethernet.STATE_CHANGE";
  public static final int NOTIFY_ID = 9;
  public static final String PPPOE_STATE_CHANGED_ACTION = "android.net.pppoe.STATE_CHANGE";
  public static final int PPPOE_STATE_DISABLED = 0;
  public static final int PPPOE_STATE_ENABLED = 1;
  private static String STR_ETHERNET_DEV_INFO;
  private static String STR_ETHERNET_MANAGER;
  private static Class<?> ethernetManagerCls;
  private static Object ethernetManagerObj = null;
  private static Context mContexServer;
  private static EtherNetHelper mInstance;

  static
  {
    ethernetManagerCls = null;
    STR_ETHERNET_MANAGER = "android.net.ethernet.EthernetManager";
    STR_ETHERNET_DEV_INFO = "android.net.ethernet.EthernetDevInfo";
    mInstance = null;
    mContexServer = null;
  }

  public static EthernetInfo InitEthernet(Context paramContext)
  {
    if (mInstance == null)
    {
      mInstance = new EtherNetHelper();
      mContexServer = paramContext;
    }
    try
    {
      Object localObject1 = Class.forName(STR_ETHERNET_MANAGER);
      ethernetManagerCls = (Class)localObject1;
      localObject1 = ((Class)localObject1).getMethods();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        System.out.println(localObject2.getName() + "          " + localObject2.toGenericString());
        i += 1;
      }
      paramContext = paramContext.getSystemService("ethernet");
      if (paramContext != null)
        ethernetManagerObj = paramContext;
      if ((ethernetManagerObj != null) && (ethernetManagerCls != null))
        return getDevInfo();
    }
    catch (ClassNotFoundException paramContext)
    {
      while (true)
        paramContext.printStackTrace();
    }
    return (EthernetInfo)null;
  }

  // ERROR //
  public static void TurnOnOff(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 72	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerCls	Ljava/lang/Class;
    //   3: ldc 163
    //   5: iconst_1
    //   6: anewarray 95	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 168	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   14: aastore
    //   15: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   18: astore_1
    //   19: aload_1
    //   20: getstatic 70	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerObj	Ljava/lang/Object;
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: iload_0
    //   30: invokestatic 176	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   33: aastore
    //   34: invokevirtual 180	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 181	java/lang/IllegalAccessException:printStackTrace	()V
    //   44: return
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 182	java/lang/NoSuchMethodException:printStackTrace	()V
    //   50: return
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 183	java/lang/IllegalArgumentException:printStackTrace	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 184	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   62: return
    //
    // Exception table:
    //   from	to	target	type
    //   19	38	39	java/lang/IllegalAccessException
    //   0	19	45	java/lang/NoSuchMethodException
    //   19	38	45	java/lang/NoSuchMethodException
    //   40	44	45	java/lang/NoSuchMethodException
    //   52	56	45	java/lang/NoSuchMethodException
    //   58	62	45	java/lang/NoSuchMethodException
    //   19	38	51	java/lang/IllegalArgumentException
    //   19	38	57	java/lang/reflect/InvocationTargetException
  }

  public static boolean getBoolean(Object paramObject, Class paramClass, String paramString)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod(paramString, new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramObject)
    {
      paramObject.printStackTrace();
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      while (true)
        paramObject.printStackTrace();
    }
    catch (IllegalAccessException paramObject)
    {
      while (true)
        paramObject.printStackTrace();
    }
  }

  // ERROR //
  public static EthernetInfo getDevInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_2
    //   14: astore_0
    //   15: aload 6
    //   17: astore_1
    //   18: getstatic 72	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerCls	Ljava/lang/Class;
    //   21: ldc 192
    //   23: iconst_0
    //   24: anewarray 95	java/lang/Class
    //   27: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: astore 8
    //   32: aload_2
    //   33: astore_0
    //   34: aload 6
    //   36: astore_1
    //   37: getstatic 80	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:STR_ETHERNET_DEV_INFO	Ljava/lang/String;
    //   40: invokestatic 99	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   43: astore 7
    //   45: aload_2
    //   46: astore_0
    //   47: aload 6
    //   49: astore_1
    //   50: aload 8
    //   52: getstatic 70	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerObj	Ljava/lang/Object;
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokevirtual 180	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore 8
    //   64: aload_2
    //   65: astore_0
    //   66: aload 6
    //   68: astore_1
    //   69: aload 7
    //   71: ldc 194
    //   73: iconst_0
    //   74: anewarray 95	java/lang/Class
    //   77: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   80: aload 8
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokevirtual 180	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   89: checkcast 196	java/lang/String
    //   92: astore 9
    //   94: aload_2
    //   95: astore_0
    //   96: aload 6
    //   98: astore_1
    //   99: new 198	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo
    //   102: dup
    //   103: invokespecial 199	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:<init>	()V
    //   106: astore_2
    //   107: aload 8
    //   109: aload 7
    //   111: ldc 194
    //   113: invokestatic 203	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getString	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    //   116: pop
    //   117: getstatic 70	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerObj	Ljava/lang/Object;
    //   120: getstatic 72	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerCls	Ljava/lang/Class;
    //   123: ldc 205
    //   125: invokestatic 207	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getBoolean	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Z
    //   128: pop
    //   129: aload 9
    //   131: ldc 209
    //   133: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +93 -> 229
    //   139: getstatic 72	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerCls	Ljava/lang/Class;
    //   142: ldc 215
    //   144: iconst_0
    //   145: anewarray 95	java/lang/Class
    //   148: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   151: getstatic 70	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerObj	Ljava/lang/Object;
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokevirtual 180	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 217	android/net/DhcpInfo
    //   164: astore_0
    //   165: aload_2
    //   166: iconst_1
    //   167: invokevirtual 220	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setDhcp	(Z)V
    //   170: aload_0
    //   171: ifnull +47 -> 218
    //   174: aload_2
    //   175: aload_0
    //   176: getfield 223	android/net/DhcpInfo:ipAddress	I
    //   179: invokestatic 227	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ipInt2String	(I)Ljava/lang/String;
    //   182: invokevirtual 230	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setIpAddr	(Ljava/lang/String;)V
    //   185: aload_2
    //   186: aload_0
    //   187: getfield 233	android/net/DhcpInfo:dns1	I
    //   190: invokestatic 227	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ipInt2String	(I)Ljava/lang/String;
    //   193: invokevirtual 236	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setDns	(Ljava/lang/String;)V
    //   196: aload_2
    //   197: aload_0
    //   198: getfield 239	android/net/DhcpInfo:gateway	I
    //   201: invokestatic 227	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ipInt2String	(I)Ljava/lang/String;
    //   204: invokevirtual 242	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setGateway	(Ljava/lang/String;)V
    //   207: aload_2
    //   208: aload_0
    //   209: getfield 245	android/net/DhcpInfo:netmask	I
    //   212: invokestatic 227	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ipInt2String	(I)Ljava/lang/String;
    //   215: invokevirtual 248	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setNetmask	(Ljava/lang/String;)V
    //   218: aload_2
    //   219: ldc 250
    //   221: invokestatic 254	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:readFileInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 257	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setHwAddr	(Ljava/lang/String;)V
    //   227: aload_2
    //   228: areturn
    //   229: aload_2
    //   230: iconst_0
    //   231: invokevirtual 220	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setDhcp	(Z)V
    //   234: aload_2
    //   235: aload 8
    //   237: aload 7
    //   239: ldc_w 259
    //   242: invokestatic 203	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getString	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 230	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setIpAddr	(Ljava/lang/String;)V
    //   248: aload_2
    //   249: aload 8
    //   251: aload 7
    //   253: ldc_w 261
    //   256: invokestatic 203	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getString	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 236	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setDns	(Ljava/lang/String;)V
    //   262: aload_2
    //   263: aload 8
    //   265: aload 7
    //   267: ldc_w 263
    //   270: invokestatic 203	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getString	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    //   273: invokevirtual 242	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setGateway	(Ljava/lang/String;)V
    //   276: aload_2
    //   277: aload 8
    //   279: aload 7
    //   281: ldc_w 265
    //   284: invokestatic 203	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:getString	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    //   287: invokevirtual 248	com/skyworthdigital/sky2dlauncher/bean/EthernetInfo:setNetmask	(Ljava/lang/String;)V
    //   290: goto -72 -> 218
    //   293: astore_3
    //   294: aload_2
    //   295: astore_0
    //   296: aload_2
    //   297: astore_1
    //   298: aload_3
    //   299: invokevirtual 181	java/lang/IllegalAccessException:printStackTrace	()V
    //   302: aload_2
    //   303: areturn
    //   304: astore_2
    //   305: aload_0
    //   306: astore_1
    //   307: aload_2
    //   308: astore_0
    //   309: aload_0
    //   310: invokevirtual 182	java/lang/NoSuchMethodException:printStackTrace	()V
    //   313: aload_1
    //   314: areturn
    //   315: astore_0
    //   316: aload_3
    //   317: astore_2
    //   318: aload_0
    //   319: astore_3
    //   320: aload_2
    //   321: astore_0
    //   322: aload_2
    //   323: astore_1
    //   324: aload_3
    //   325: invokevirtual 183	java/lang/IllegalArgumentException:printStackTrace	()V
    //   328: aload_2
    //   329: areturn
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 151	java/lang/ClassNotFoundException:printStackTrace	()V
    //   335: aload_1
    //   336: areturn
    //   337: astore_3
    //   338: aload 5
    //   340: astore_2
    //   341: aload_2
    //   342: astore_0
    //   343: aload_2
    //   344: astore_1
    //   345: aload_3
    //   346: invokevirtual 184	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   349: aload_2
    //   350: areturn
    //   351: astore_0
    //   352: aload_2
    //   353: astore_1
    //   354: goto -23 -> 331
    //   357: astore_0
    //   358: aload_2
    //   359: astore_1
    //   360: goto -51 -> 309
    //   363: astore_3
    //   364: goto -23 -> 341
    //   367: astore_3
    //   368: goto -48 -> 320
    //   371: astore_3
    //   372: aload 4
    //   374: astore_2
    //   375: goto -81 -> 294
    //
    // Exception table:
    //   from	to	target	type
    //   107	170	293	java/lang/IllegalAccessException
    //   174	218	293	java/lang/IllegalAccessException
    //   218	227	293	java/lang/IllegalAccessException
    //   229	290	293	java/lang/IllegalAccessException
    //   18	32	304	java/lang/NoSuchMethodException
    //   37	45	304	java/lang/NoSuchMethodException
    //   50	64	304	java/lang/NoSuchMethodException
    //   69	94	304	java/lang/NoSuchMethodException
    //   99	107	304	java/lang/NoSuchMethodException
    //   298	302	304	java/lang/NoSuchMethodException
    //   324	328	304	java/lang/NoSuchMethodException
    //   345	349	304	java/lang/NoSuchMethodException
    //   50	64	315	java/lang/IllegalArgumentException
    //   69	94	315	java/lang/IllegalArgumentException
    //   99	107	315	java/lang/IllegalArgumentException
    //   18	32	330	java/lang/ClassNotFoundException
    //   37	45	330	java/lang/ClassNotFoundException
    //   50	64	330	java/lang/ClassNotFoundException
    //   69	94	330	java/lang/ClassNotFoundException
    //   99	107	330	java/lang/ClassNotFoundException
    //   298	302	330	java/lang/ClassNotFoundException
    //   324	328	330	java/lang/ClassNotFoundException
    //   345	349	330	java/lang/ClassNotFoundException
    //   50	64	337	java/lang/reflect/InvocationTargetException
    //   69	94	337	java/lang/reflect/InvocationTargetException
    //   99	107	337	java/lang/reflect/InvocationTargetException
    //   107	170	351	java/lang/ClassNotFoundException
    //   174	218	351	java/lang/ClassNotFoundException
    //   218	227	351	java/lang/ClassNotFoundException
    //   229	290	351	java/lang/ClassNotFoundException
    //   107	170	357	java/lang/NoSuchMethodException
    //   174	218	357	java/lang/NoSuchMethodException
    //   218	227	357	java/lang/NoSuchMethodException
    //   229	290	357	java/lang/NoSuchMethodException
    //   107	170	363	java/lang/reflect/InvocationTargetException
    //   174	218	363	java/lang/reflect/InvocationTargetException
    //   218	227	363	java/lang/reflect/InvocationTargetException
    //   229	290	363	java/lang/reflect/InvocationTargetException
    //   107	170	367	java/lang/IllegalArgumentException
    //   174	218	367	java/lang/IllegalArgumentException
    //   218	227	367	java/lang/IllegalArgumentException
    //   229	290	367	java/lang/IllegalArgumentException
    //   50	64	371	java/lang/IllegalAccessException
    //   69	94	371	java/lang/IllegalAccessException
    //   99	107	371	java/lang/IllegalAccessException
  }

  // ERROR //
  public static android.net.DhcpInfo getDhcpInfo()
  {
    // Byte code:
    //   0: getstatic 72	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerCls	Ljava/lang/Class;
    //   3: ldc 215
    //   5: iconst_0
    //   6: anewarray 95	java/lang/Class
    //   9: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   12: astore_0
    //   13: getstatic 80	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:STR_ETHERNET_DEV_INFO	Ljava/lang/String;
    //   16: invokestatic 99	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   19: pop
    //   20: aload_0
    //   21: getstatic 70	com/skyworthdigital/sky2dlauncher/tools/EtherNetHelper:ethernetManagerObj	Ljava/lang/Object;
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokevirtual 180	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 217	android/net/DhcpInfo
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 181	java/lang/IllegalAccessException:printStackTrace	()V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 182	java/lang/NoSuchMethodException:printStackTrace	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 183	java/lang/IllegalArgumentException:printStackTrace	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 151	java/lang/ClassNotFoundException:printStackTrace	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 184	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   70: aconst_null
    //   71: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   20	35	37	java/lang/IllegalAccessException
    //   0	20	44	java/lang/NoSuchMethodException
    //   20	35	44	java/lang/NoSuchMethodException
    //   38	42	44	java/lang/NoSuchMethodException
    //   52	56	44	java/lang/NoSuchMethodException
    //   66	70	44	java/lang/NoSuchMethodException
    //   20	35	51	java/lang/IllegalArgumentException
    //   0	20	58	java/lang/ClassNotFoundException
    //   20	35	58	java/lang/ClassNotFoundException
    //   38	42	58	java/lang/ClassNotFoundException
    //   52	56	58	java/lang/ClassNotFoundException
    //   66	70	58	java/lang/ClassNotFoundException
    //   20	35	65	java/lang/reflect/InvocationTargetException
  }

  public static String getString(Object paramObject, Class paramClass, String paramString)
  {
    try
    {
      paramObject = (String)paramClass.getMethod(paramString, new Class[0]).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      while (true)
        paramObject.printStackTrace();
    }
    catch (IllegalAccessException paramObject)
    {
      while (true)
        paramObject.printStackTrace();
    }
  }

  public static String ipInt2String(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF);
    localStringBuffer.append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    System.out.println("####22######" + localStringBuffer.toString());
    return localStringBuffer.toString();
  }

  public static String readFileInfo(String paramString)
  {
    String str = null;
    Object localObject = new File(paramString);
    paramString = str;
    try
    {
      localObject = new BufferedReader(new FileReader((File)localObject));
      paramString = str;
      str = ((BufferedReader)localObject).readLine();
      paramString = str;
      ((BufferedReader)localObject).close();
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return (String)paramString;
  }

  public static void setManualIp(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString2 = ethernetManagerCls.getMethod("getSavedEthConfig", new Class[0]);
      paramString1 = Class.forName(STR_ETHERNET_DEV_INFO);
      paramString2 = paramString2.invoke(ethernetManagerObj, new Object[0]);
      setString(paramString2, paramString1, "setIpAddress", "192.168.1.229");
      setString(paramString2, paramString1, "setConnectMode", "dhcp");
      setString(paramString2, paramString1, "setDnsAddr", "192.168.1.254");
      setString(paramString2, paramString1, "setRouteAddr", "192.168.1.254");
      setString(paramString2, paramString1, "setNetMask", "255.255.255.0");
      ethernetManagerCls.getMethod("updateEthDevInfo", new Class[] { paramString1 }).invoke(ethernetManagerObj, new Object[] { paramString2 });
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
  }

  public static String setString(Object paramObject, Class paramClass, String paramString1, String paramString2)
  {
    try
    {
      paramClass.getMethod(paramString1, new Class[] { String.class }).invoke(paramObject, new Object[] { paramString2 });
      return null;
    }
    catch (NoSuchMethodException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }

  public void turnOffEther()
  {
    try
    {
      Runtime.getRuntime().exec("netcfg eth0 down");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void turnOnEther()
  {
    try
    {
      Runtime.getRuntime().exec("netcfg eth0 up dhcp");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.tools.EtherNetHelper
 * JD-Core Version:    0.6.0
 */