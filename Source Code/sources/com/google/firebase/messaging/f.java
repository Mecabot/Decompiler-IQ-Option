package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;

@Hide
final class f {
    private static AppMeasurement aE(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    private static void b(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        stringExtra = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra != null) {
            bundle.putString("_nmn", stringExtra);
        }
        Object stringExtra2 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PlusShare.KEY_CALL_TO_ACTION_LABEL, stringExtra2);
        }
        stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            stringExtra = null;
        }
        if (stringExtra != null) {
            bundle.putString("_nt", stringExtra);
        }
        try {
            bundle.putInt("_nmt", Integer.valueOf(intent.getStringExtra("google.c.a.ts")).intValue());
        } catch (Throwable e) {
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.valueOf(intent.getStringExtra("google.c.a.udt")).intValue());
            } catch (Throwable e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            stringExtra = String.valueOf(bundle);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(stringExtra).length());
            stringBuilder.append("Sending event=");
            stringBuilder.append(str);
            stringBuilder.append(" params=");
            stringBuilder.append(stringExtra);
            Log.d("FirebaseMessaging", stringBuilder.toString());
        }
        AppMeasurement aE = aE(context);
        if (aE != null) {
            aE.logEventInternal(AppMeasurement.FCM_ORIGIN, str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    public static void g(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("google.c.a.abt");
        if (stringExtra != null) {
            e.a(context, AppMeasurement.FCM_ORIGIN, Base64.decode(stringExtra, 0), new d(), 1);
        }
        b(context, "_nr", intent);
    }

    public static void h(Context context, Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                AppMeasurement aE = aE(context);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aE != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aE.setUserPropertyInternal(AppMeasurement.FCM_ORIGIN, UserProperty.FIREBASE_LAST_NOTIFICATION, stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(b.SOURCE, "Firebase");
                    bundle.putString(b.MEDIUM, "notification");
                    bundle.putString(b.CAMPAIGN, stringExtra);
                    aE.logEventInternal(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        b(context, "_no", intent);
    }

    public static void i(Context context, Intent intent) {
        b(context, "_nd", intent);
    }

    public static void j(Context context, Intent intent) {
        b(context, "_nf", intent);
    }
}
