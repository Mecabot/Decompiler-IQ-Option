package com.facebook.appevents.internal;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONObject;

/* compiled from: AutomaticAnalyticsLogger */
public class c {
    private static final g AC = new g(h.getApplicationContext());
    private static final String TAG = c.class.getCanonicalName();

    /* compiled from: AutomaticAnalyticsLogger */
    private static class a {
        BigDecimal AK;
        Currency AP;
        Bundle AV;

        a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.AK = bigDecimal;
            this.AP = currency;
            this.AV = bundle;
        }
    }

    public static void kZ() {
        Object applicationContext = h.getApplicationContext();
        String it = h.it();
        boolean jd = h.jd();
        x.a(applicationContext, "context");
        if (!jd) {
            return;
        }
        if (applicationContext instanceof Application) {
            AppEventsLogger.b((Application) applicationContext, it);
        } else {
            Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static void d(String str, long j) {
        Object applicationContext = h.getApplicationContext();
        String it = h.it();
        x.a(applicationContext, "context");
        l f = FetchedAppSettingsManager.f(it, false);
        if (f != null && f.lH() && j > 0) {
            AppEventsLogger T = AppEventsLogger.T(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_aa_time_spent_view_name", str);
            T.a("fb_aa_time_spent_on_view", (double) j, bundle);
        }
    }

    public static void x(String str, String str2) {
        if (la()) {
            a y = y(str, str2);
            if (y != null) {
                AC.b(y.AK, y.AP, y.AV);
            }
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0032, code:
            r3 = y(r3, r4);
     */
    /* JADX WARNING: Missing block: B:14:0x0036, code:
            if (r3 == null) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:15:0x0038, code:
            AC.a(r2, r3.AK, r3.AP, r3.AV);
     */
    /* JADX WARNING: Missing block: B:16:0x0043, code:
            return;
     */
    /* JADX WARNING: Missing block: B:17:0x0044, code:
            return;
     */
    public static void a(com.facebook.appevents.internal.SubscriptionType r2, java.lang.String r3, java.lang.String r4) {
        /*
        r0 = la();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = com.facebook.h.it();
        r1 = com.facebook.appevents.internal.c.AnonymousClass1.AJ;
        r2 = r2.ordinal();
        r2 = r1[r2];
        switch(r2) {
            case 1: goto L_0x0030;
            case 2: goto L_0x002d;
            case 3: goto L_0x002a;
            case 4: goto L_0x0027;
            case 5: goto L_0x0017;
            default: goto L_0x0016;
        };
    L_0x0016:
        goto L_0x0044;
    L_0x0017:
        r2 = "app_events_if_auto_log_subs";
        r1 = 1;
        r2 = com.facebook.internal.k.a(r2, r0, r1);
        if (r2 == 0) goto L_0x0023;
    L_0x0020:
        r2 = "Subscribe";
        goto L_0x0032;
    L_0x0023:
        x(r3, r4);
        goto L_0x0044;
    L_0x0027:
        r2 = "SubscriptionExpire";
        goto L_0x0032;
    L_0x002a:
        r2 = "SubscriptionHeartbeat";
        goto L_0x0032;
    L_0x002d:
        r2 = "SubscriptionCancel";
        goto L_0x0032;
    L_0x0030:
        r2 = "SubscriptionRestore";
    L_0x0032:
        r3 = y(r3, r4);
        if (r3 == 0) goto L_0x0043;
    L_0x0038:
        r4 = AC;
        r0 = r3.AK;
        r1 = r3.AP;
        r3 = r3.AV;
        r4.a(r2, r0, r1, r3);
    L_0x0043:
        return;
    L_0x0044:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.c.a(com.facebook.appevents.internal.SubscriptionType, java.lang.String, java.lang.String):void");
    }

    public static boolean la() {
        l bF = FetchedAppSettingsManager.bF(h.it());
        return bF != null && h.jd() && bF.lJ();
    }

    @Nullable
    private static a y(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            Object optString = jSONObject2.optString(Param.TYPE);
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                CharSequence optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            return new a(new BigDecimal(((double) jSONObject2.getLong("price_amount_micros")) / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
        } catch (Throwable e) {
            Log.e(TAG, "Error parsing in-app subscription data.", e);
            return null;
        }
    }
}
