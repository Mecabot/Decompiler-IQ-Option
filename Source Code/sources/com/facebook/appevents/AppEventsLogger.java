package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.a;
import com.facebook.appevents.internal.c;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.q;
import com.facebook.internal.w;
import com.facebook.internal.x;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class AppEventsLogger {
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static ScheduledThreadPoolExecutor zk;
    private static FlushBehavior zl = FlushBehavior.AUTO;
    private static Object zm = new Object();
    private static String zn;
    private static boolean zo;
    private static String zp;
    private final String zi;
    private final AccessTokenAppIdPair zj;

    /* renamed from: com.facebook.appevents.AppEventsLogger$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ AppEventsLogger zq;

        AnonymousClass1(AppEventsLogger appEventsLogger) {
            this.zq = appEventsLogger;
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:21:0x006a, code:
            r4.zq.a("fb_sdk_initialize", null, r0);
     */
        /* JADX WARNING: Missing block: B:22:0x0072, code:
            return;
     */
        public void run() {
            /*
            r4 = this;
            r0 = new android.os.Bundle;
            r0.<init>();
            r1 = 1;
            r2 = "com.facebook.core.Core";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0010 }
            r2 = "core_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0010 }
        L_0x0010:
            r2 = "com.facebook.login.Login";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x001a }
            r2 = "login_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x001a }
        L_0x001a:
            r2 = "com.facebook.share.Share";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0024 }
            r2 = "share_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0024 }
        L_0x0024:
            r2 = "com.facebook.places.Places";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x002e }
            r2 = "places_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x002e }
        L_0x002e:
            r2 = "com.facebook.messenger.Messenger";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0038 }
            r2 = "messenger_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0038 }
        L_0x0038:
            r2 = "com.facebook.applinks.AppLinks";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0042 }
            r2 = "applinks_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0042 }
        L_0x0042:
            r2 = "com.facebook.marketing.b";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x004c }
            r2 = "marketing_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x004c }
        L_0x004c:
            r2 = "com.facebook.all.All";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0056 }
            r2 = "all_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0056 }
        L_0x0056:
            r2 = "com.android.billingclient.api.BillingClient";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0060 }
            r2 = "billing_client_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x0060 }
        L_0x0060:
            r2 = "com.android.vending.billing.IInAppBillingService";
            java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x006a }
            r2 = "billing_service_lib_included";
            r0.putInt(r2, r1);	 Catch:{ ClassNotFoundException -> 0x006a }
        L_0x006a:
            r1 = r4.zq;
            r2 = "fb_sdk_initialize";
            r3 = 0;
            r1.a(r2, r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.1.run():void");
        }
    }

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    public static void b(Application application, String str) {
        if (h.isInitialized()) {
            a.jW();
            g.jW();
            if (str == null) {
                str = h.it();
            }
            h.l(application, str);
            a.a(application, str);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    public static void n(Context context, String str) {
        if (h.jd()) {
            zk.execute(new AnonymousClass1(new AppEventsLogger(context, str, null)));
        }
    }

    public static AppEventsLogger T(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger o(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static FlushBehavior kj() {
        FlushBehavior flushBehavior;
        synchronized (zm) {
            flushBehavior = zl;
        }
        return flushBehavior;
    }

    public void bq(String str) {
        logEvent(str, null);
    }

    public void logEvent(String str, Bundle bundle) {
        a(str, null, bundle, false, a.kH());
    }

    public void a(String str, double d, Bundle bundle) {
        a(str, Double.valueOf(d), bundle, false, a.kH());
    }

    public void a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (c.la()) {
            Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        a(bigDecimal, currency, bundle, false);
    }

    protected void b(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        a(bigDecimal, currency, bundle, true);
    }

    private void a(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            br("purchaseAmount cannot be null");
        } else if (currency == null) {
            br("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            a("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z, a.kH());
            ko();
        }
    }

    public void flush() {
        c.a(FlushReason.EXPLICIT);
    }

    public static void kk() {
        c.kd();
    }

    static String kl() {
        String str;
        synchronized (zm) {
            str = zp;
        }
        return str;
    }

    public static String jX() {
        return a.jX();
    }

    public static String km() {
        return g.ks();
    }

    public void a(String str, Double d, Bundle bundle) {
        a(str, d, bundle, true, a.kH());
    }

    private AppEventsLogger(Context context, String str, com.facebook.a aVar) {
        this(w.ae(context), str, aVar);
    }

    protected AppEventsLogger(String str, String str2, com.facebook.a aVar) {
        x.mC();
        this.zi = str;
        if (aVar == null) {
            aVar = com.facebook.a.ik();
        }
        if (com.facebook.a.il() && (str2 == null || str2.equals(aVar.it()))) {
            this.zj = new AccessTokenAppIdPair(aVar);
        } else {
            if (str2 == null) {
                str2 = w.ac(h.getApplicationContext());
            }
            this.zj = new AccessTokenAppIdPair(null, str2);
        }
        kn();
    }

    private static void kn() {
        synchronized (zm) {
            if (zk != null) {
                return;
            }
            zk = new ScheduledThreadPoolExecutor(1);
            zk.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    Set<String> hashSet = new HashSet();
                    for (AccessTokenAppIdPair it : c.getKeySet()) {
                        hashSet.add(it.it());
                    }
                    for (String f : hashSet) {
                        FetchedAppSettingsManager.f(f, true);
                    }
                }
            }, 0, 86400, TimeUnit.SECONDS);
        }
    }

    protected void a(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        a(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, a.kH());
    }

    private void a(String str, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        try {
            a(new AppEvent(this.zi, str, d, bundle, z, uuid), this.zj);
        } catch (JSONException e) {
            q.a(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
        } catch (FacebookException e2) {
            q.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
        }
    }

    private static void a(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        c.b(accessTokenAppIdPair, appEvent);
        if (!appEvent.jZ() && !zo) {
            if (appEvent.getName().equals("fb_mobile_activate_app")) {
                zo = true;
            } else {
                q.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    static void ko() {
        if (kj() != FlushBehavior.EXPLICIT_ONLY) {
            c.a(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void br(String str) {
        q.a(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    static Executor kp() {
        if (zk == null) {
            kn();
        }
        return zk;
    }

    public static String U(Context context) {
        if (zn == null) {
            synchronized (zm) {
                if (zn == null) {
                    zn = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (zn == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("XZ");
                        stringBuilder.append(UUID.randomUUID().toString());
                        zn = stringBuilder.toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", zn).apply();
                    }
                }
            }
        }
        return zn;
    }
}
