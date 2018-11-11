package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.b;
import com.facebook.internal.p;
import com.facebook.internal.v;
import com.facebook.internal.w;
import com.facebook.internal.x;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FacebookSdk */
public final class h {
    private static final String TAG = h.class.getCanonicalName();
    private static volatile String applicationId = null;
    private static volatile String applicationName = null;
    private static Executor executor = null;
    private static final HashSet<LoggingBehavior> xB = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static volatile String xC = null;
    private static volatile Boolean xD = null;
    private static volatile Boolean xE = null;
    private static volatile String xF = "facebook.com";
    private static AtomicLong xG = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    private static volatile boolean xH = false;
    private static boolean xI = false;
    private static p<File> xJ = null;
    private static Context xK = null;
    private static int xL = 64206;
    private static final Object xM = new Object();
    private static String xN = v.mt();
    private static final BlockingQueue<Runnable> xO = new LinkedBlockingQueue(10);
    private static final ThreadFactory xP = new ThreadFactory() {
        private final AtomicInteger xR = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FacebookSdk #");
            stringBuilder.append(this.xR.incrementAndGet());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private static Boolean xQ = Boolean.valueOf(false);

    /* compiled from: FacebookSdk */
    public interface a {
        void ji();
    }

    public static String ja() {
        return "4.38.0";
    }

    @Deprecated
    public static synchronized void Q(Context context) {
        synchronized (h.class) {
            a(context, null);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0011, code:
            return;
     */
    @java.lang.Deprecated
    public static synchronized void a(final android.content.Context r3, final com.facebook.h.a r4) {
        /*
        r0 = com.facebook.h.class;
        monitor-enter(r0);
        r1 = xQ;	 Catch:{ all -> 0x0084 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x0012;
    L_0x000b:
        if (r4 == 0) goto L_0x0010;
    L_0x000d:
        r4.ji();	 Catch:{ all -> 0x0084 }
    L_0x0010:
        monitor-exit(r0);
        return;
    L_0x0012:
        r1 = "applicationContext";
        com.facebook.internal.x.a(r3, r1);	 Catch:{ all -> 0x0084 }
        r1 = 0;
        com.facebook.internal.x.c(r3, r1);	 Catch:{ all -> 0x0084 }
        com.facebook.internal.x.b(r3, r1);	 Catch:{ all -> 0x0084 }
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x0084 }
        xK = r1;	 Catch:{ all -> 0x0084 }
        r1 = xK;	 Catch:{ all -> 0x0084 }
        S(r1);	 Catch:{ all -> 0x0084 }
        r1 = applicationId;	 Catch:{ all -> 0x0084 }
        r1 = com.facebook.internal.w.bc(r1);	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x0039;
    L_0x0031:
        r3 = new com.facebook.FacebookException;	 Catch:{ all -> 0x0084 }
        r4 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.";
        r3.<init>(r4);	 Catch:{ all -> 0x0084 }
        throw r3;	 Catch:{ all -> 0x0084 }
    L_0x0039:
        r1 = xK;	 Catch:{ all -> 0x0084 }
        r1 = r1 instanceof android.app.Application;	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x0050;
    L_0x003f:
        r1 = xD;	 Catch:{ all -> 0x0084 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x0050;
    L_0x0047:
        r1 = xK;	 Catch:{ all -> 0x0084 }
        r1 = (android.app.Application) r1;	 Catch:{ all -> 0x0084 }
        r2 = applicationId;	 Catch:{ all -> 0x0084 }
        com.facebook.appevents.internal.a.a(r1, r2);	 Catch:{ all -> 0x0084 }
    L_0x0050:
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0084 }
        xQ = r1;	 Catch:{ all -> 0x0084 }
        com.facebook.internal.FetchedAppSettingsManager.lP();	 Catch:{ all -> 0x0084 }
        com.facebook.internal.k.lE();	 Catch:{ all -> 0x0084 }
        com.facebook.internal.s.mk();	 Catch:{ all -> 0x0084 }
        r1 = xK;	 Catch:{ all -> 0x0084 }
        com.facebook.internal.c.aa(r1);	 Catch:{ all -> 0x0084 }
        r1 = new com.facebook.internal.p;	 Catch:{ all -> 0x0084 }
        r2 = new com.facebook.h$2;	 Catch:{ all -> 0x0084 }
        r2.<init>();	 Catch:{ all -> 0x0084 }
        r1.<init>(r2);	 Catch:{ all -> 0x0084 }
        xJ = r1;	 Catch:{ all -> 0x0084 }
        r1 = new java.util.concurrent.FutureTask;	 Catch:{ all -> 0x0084 }
        r2 = new com.facebook.h$3;	 Catch:{ all -> 0x0084 }
        r2.<init>(r4, r3);	 Catch:{ all -> 0x0084 }
        r1.<init>(r2);	 Catch:{ all -> 0x0084 }
        r3 = getExecutor();	 Catch:{ all -> 0x0084 }
        r3.execute(r1);	 Catch:{ all -> 0x0084 }
        monitor-exit(r0);
        return;
    L_0x0084:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.h.a(android.content.Context, com.facebook.h$a):void");
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (h.class) {
            booleanValue = xQ.booleanValue();
        }
        return booleanValue;
    }

    public static boolean a(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (xB) {
            z = isDebugEnabled() && xB.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return xH;
    }

    public static boolean iX() {
        return xI;
    }

    public static Executor getExecutor() {
        synchronized (xM) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static String iY() {
        return xF;
    }

    public static Context getApplicationContext() {
        x.mC();
        return xK;
    }

    public static String iZ() {
        w.E(TAG, String.format("getGraphApiVersion: %s", new Object[]{xN}));
        return xN;
    }

    public static void l(Context context, final String str) {
        context = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                h.m(context, str);
            }
        });
    }

    static void m(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            b Y = b.Y(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("ping");
            String stringBuilder2 = stringBuilder.toString();
            long j = sharedPreferences.getLong(stringBuilder2, 0);
            i a = i.a(null, String.format("%s/activities", new Object[]{str}), AppEventsLoggerUtility.a(GraphAPIActivityType.MOBILE_INSTALL_EVENT, Y, AppEventsLogger.U(context), R(context), context), null);
            if (j == 0) {
                a.jq();
                Editor edit = sharedPreferences.edit();
                edit.putLong(stringBuilder2, System.currentTimeMillis());
                edit.apply();
            }
        } catch (Throwable e) {
            throw new FacebookException("An error occurred while publishing install.", e);
        } catch (Exception e2) {
            w.a("Facebook-publish", e2);
        }
    }

    public static boolean R(Context context) {
        x.mC();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static long jb() {
        x.mC();
        return xG.get();
    }

    static void S(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                applicationId = str.substring(2);
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (xC == null) {
                        xC = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (xL == 64206) {
                        xL = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
                    }
                    if (xD == null) {
                        xD = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoLogAppEventsEnabled", true));
                    }
                    if (xE == null) {
                        xE = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                    }
                }
            } catch (NameNotFoundException unused) {
            }
        }
    }

    public static String it() {
        x.mC();
        return applicationId;
    }

    public static String jc() {
        x.mC();
        return xC;
    }

    public static boolean jd() {
        x.mC();
        return xD.booleanValue();
    }

    public static boolean je() {
        x.mC();
        return xE.booleanValue();
    }

    public static File getCacheDir() {
        x.mC();
        return (File) xJ.getValue();
    }

    public static int jf() {
        x.mC();
        return xL;
    }
}
