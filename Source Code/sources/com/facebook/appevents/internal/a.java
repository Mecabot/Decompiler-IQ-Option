package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.b;
import com.facebook.appevents.codeless.c;
import com.facebook.appevents.codeless.d;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.q;
import com.facebook.internal.w;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ActivityLifecycleTracker */
public class a {
    private static volatile ScheduledFuture Ak;
    private static final Object Al = new Object();
    private static AtomicInteger Am = new AtomicInteger(0);
    private static volatile h An;
    private static AtomicBoolean Ao = new AtomicBoolean(false);
    private static long Ap;
    private static final b Aq = new b();
    private static final d Ar = new d();
    private static SensorManager As;
    private static c At;
    @Nullable
    private static String Au;
    private static Boolean Av = Boolean.valueOf(false);
    private static volatile Boolean Aw = Boolean.valueOf(false);
    private static final String TAG = a.class.getCanonicalName();
    private static String appId;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    public static void a(Application application, String str) {
        if (Ao.compareAndSet(false, true)) {
            appId = str;
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityCreated");
                    b.kW();
                    a.h(activity);
                }

                public void onActivityStarted(Activity activity) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityStarted");
                }

                public void onActivityResumed(Activity activity) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityResumed");
                    b.kW();
                    a.onActivityResumed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityPaused");
                    b.kW();
                    a.onActivityPaused(activity);
                }

                public void onActivityStopped(Activity activity) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityStopped");
                    AppEventsLogger.kk();
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivitySaveInstanceState");
                }

                public void onActivityDestroyed(Activity activity) {
                    q.a(LoggingBehavior.APP_EVENTS, a.TAG, "onActivityDestroyed");
                }
            });
        }
    }

    public static UUID kH() {
        return An != null ? An.getSessionId() : null;
    }

    public static void h(Activity activity) {
        System.currentTimeMillis();
        activity.getApplicationContext();
        w.ae(activity);
        com.facebook.appevents.internal.j.a.j(activity);
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                if (a.An == null) {
                    a.An = h.lg();
                }
            }
        });
    }

    public static void onActivityResumed(Activity activity) {
        Am.incrementAndGet();
        kJ();
        final long currentTimeMillis = System.currentTimeMillis();
        Ap = currentTimeMillis;
        final String ae = w.ae(activity);
        Aq.add(activity);
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                if (a.An == null) {
                    a.An = new h(Long.valueOf(currentTimeMillis), null);
                    i.a(ae, null, a.appId);
                } else if (a.An.li() != null) {
                    long longValue = currentTimeMillis - a.An.li().longValue();
                    if (longValue > ((long) (a.kI() * 1000))) {
                        i.a(ae, a.An, a.appId);
                        i.a(ae, null, a.appId);
                        a.An = new h(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > 1000) {
                        a.An.lk();
                    }
                }
                a.An.a(Long.valueOf(currentTimeMillis));
                a.An.lo();
            }
        });
        Context applicationContext = activity.getApplicationContext();
        final String it = h.it();
        final l bF = FetchedAppSettingsManager.bF(it);
        if (bF != null && bF.lL()) {
            As = (SensorManager) applicationContext.getSystemService("sensor");
            if (As != null) {
                Sensor defaultSensor = As.getDefaultSensor(1);
                At = new c(activity);
                Ar.a(new com.facebook.appevents.codeless.d.a() {
                    public void kB() {
                        if (bF != null && bF.lK()) {
                            a.bt(it);
                        }
                    }
                });
                As.registerListener(Ar, defaultSensor, 2);
                if (bF != null && bF.lK()) {
                    At.schedule();
                }
            }
        }
    }

    private static void onActivityPaused(Activity activity) {
        if (Am.decrementAndGet() < 0) {
            Am.set(0);
            Log.w(TAG, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        kJ();
        final long currentTimeMillis = System.currentTimeMillis();
        final String ae = w.ae(activity);
        Aq.g(activity);
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                if (a.An == null) {
                    a.An = new h(Long.valueOf(currentTimeMillis), null);
                }
                a.An.a(Long.valueOf(currentTimeMillis));
                if (a.Am.get() <= 0) {
                    Runnable anonymousClass1 = new Runnable() {
                        public void run() {
                            if (a.Am.get() <= 0) {
                                i.a(ae, a.An, a.appId);
                                h.lh();
                                a.An = null;
                            }
                            synchronized (a.Al) {
                                a.Ak = null;
                            }
                        }
                    };
                    synchronized (a.Al) {
                        a.Ak = a.singleThreadExecutor.schedule(anonymousClass1, (long) a.kI(), TimeUnit.SECONDS);
                    }
                }
                long kS = a.Ap;
                long j = 0;
                if (kS > 0) {
                    j = (currentTimeMillis - kS) / 1000;
                }
                c.d(ae, j);
                a.An.lo();
            }
        });
        if (At != null) {
            At.kz();
        }
        if (As != null) {
            As.unregisterListener(Ar);
        }
    }

    private static int kI() {
        l bF = FetchedAppSettingsManager.bF(h.it());
        if (bF == null) {
            return d.lb();
        }
        return bF.kI();
    }

    private static void kJ() {
        synchronized (Al) {
            if (Ak != null) {
                Ak.cancel(false);
            }
            Ak = null;
        }
    }

    public static void bt(final String str) {
        if (!Aw.booleanValue()) {
            Aw = Boolean.valueOf(true);
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    boolean z = true;
                    i a = i.a(null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{str}), null, null);
                    Bundle jn = a.jn();
                    if (jn == null) {
                        jn = new Bundle();
                    }
                    com.facebook.internal.b Y = com.facebook.internal.b.Y(h.getApplicationContext());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                    if (Y == null || Y.lx() == null) {
                        jSONArray.put("");
                    } else {
                        jSONArray.put(Y.lx());
                    }
                    jSONArray.put("0");
                    jSONArray.put(b.kX() ? "1" : "0");
                    Locale mz = w.mz();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(mz.getLanguage());
                    stringBuilder.append("_");
                    stringBuilder.append(mz.getCountry());
                    jSONArray.put(stringBuilder.toString());
                    String jSONArray2 = jSONArray.toString();
                    jn.putString("device_session_id", a.kK());
                    jn.putString("extinfo", jSONArray2);
                    a.setParameters(jn);
                    if (a != null) {
                        JSONObject jK = a.jq().jK();
                        if (jK == null || !jK.optBoolean("is_app_indexing_enabled", false)) {
                            z = false;
                        }
                        a.Av = Boolean.valueOf(z);
                        if (a.Av.booleanValue()) {
                            a.At.schedule();
                        } else {
                            a.Au = null;
                        }
                    }
                    a.Aw = Boolean.valueOf(false);
                }
            });
        }
    }

    public static String kK() {
        if (Au == null) {
            Au = UUID.randomUUID().toString();
        }
        return Au;
    }

    public static boolean kL() {
        return Av.booleanValue();
    }

    public static void c(Boolean bool) {
        Av = bool;
    }
}
