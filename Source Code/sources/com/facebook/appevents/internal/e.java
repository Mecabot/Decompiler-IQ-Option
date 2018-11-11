package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: InAppPurchaseActivityLifecycleTracker */
public class e {
    private static final AtomicBoolean AY = new AtomicBoolean(false);
    private static Boolean Ba;
    private static Boolean Bb;
    private static ServiceConnection Bc;
    private static ActivityLifecycleCallbacks Bd;
    private static Object Be;
    private static final String TAG = e.class.getCanonicalName();
    private static Intent intent;

    public static void update() {
        lc();
        if (Ba.booleanValue() && c.la()) {
            startTracking();
        }
    }

    private static void lc() {
        if (Ba == null) {
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                Ba = Boolean.valueOf(true);
                try {
                    Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                    Bb = Boolean.valueOf(true);
                } catch (ClassNotFoundException unused) {
                    Bb = Boolean.valueOf(false);
                }
                f.lf();
                intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                Bc = new ServiceConnection() {
                    public void onServiceDisconnected(ComponentName componentName) {
                    }

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        e.Be = f.a(h.getApplicationContext(), iBinder);
                    }
                };
                Bd = new ActivityLifecycleCallbacks() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivityPaused(Activity activity) {
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityResumed(Activity activity) {
                        h.getExecutor().execute(new Runnable() {
                            public void run() {
                                Context applicationContext = h.getApplicationContext();
                                e.a(applicationContext, f.a(applicationContext, e.Be));
                                Map c = f.c(applicationContext, e.Be);
                                Iterator it = f.b(applicationContext, e.Be).iterator();
                                while (it.hasNext()) {
                                    c.put((String) it.next(), SubscriptionType.EXPIRE);
                                }
                                e.b(applicationContext, c);
                            }
                        });
                    }

                    public void onActivityStopped(Activity activity) {
                        if (e.Bb.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                            h.getExecutor().execute(new Runnable() {
                                public void run() {
                                    Context applicationContext = h.getApplicationContext();
                                    ArrayList a = f.a(applicationContext, e.Be);
                                    if (a.isEmpty()) {
                                        a = f.d(applicationContext, e.Be);
                                    }
                                    e.a(applicationContext, a);
                                }
                            });
                        }
                    }
                };
            } catch (ClassNotFoundException unused2) {
                Ba = Boolean.valueOf(false);
            }
        }
    }

    private static void startTracking() {
        if (AY.compareAndSet(false, true)) {
            Context applicationContext = h.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(Bd);
                applicationContext.bindService(intent, Bc, 1);
            }
        }
    }

    private static void a(Context context, ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            Map hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    String string = new JSONObject(str).getString("productId");
                    hashMap.put(string, str);
                    arrayList2.add(string);
                } catch (Throwable e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            for (Entry entry : f.a(context, arrayList2, Be, false).entrySet()) {
                c.x((String) hashMap.get(entry.getKey()), (String) entry.getValue());
            }
        }
    }

    private static void b(Context context, Map<String, SubscriptionType> map) {
        if (!map.isEmpty()) {
            String str;
            Map hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                try {
                    String string = new JSONObject(str2).getString("productId");
                    arrayList.add(string);
                    hashMap.put(string, str2);
                } catch (Throwable e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            Map a = f.a(context, arrayList, Be, true);
            for (String str3 : a.keySet()) {
                str2 = (String) hashMap.get(str3);
                c.a((SubscriptionType) map.get(str2), str2, (String) a.get(str3));
            }
        }
    }
}
