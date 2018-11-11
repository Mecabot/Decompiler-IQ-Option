package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzs;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean XT = false;
    private static l XU;
    private static l XV;

    private final void a(Context context, Intent intent, String str) {
        String str2 = null;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        int i = 0;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("google.com/iid".equals(intent.getStringExtra("from")) || "com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
            str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(str) || "com.google.firebase.MESSAGING_EVENT".equals(str)) {
            str2 = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
        }
        int i2 = -1;
        if (str2 != null) {
            if (zzs.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
                i = 1;
            }
            if (i != 0) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                t(context, str2).a(intent, goAsync());
            } else {
                i2 = ac.wP().a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i2);
        }
    }

    private static synchronized l t(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            l lVar;
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (XV == null) {
                    XV = new l(context, str);
                }
                lVar = XV;
                return lVar;
            }
            if (XU == null) {
                XU = new l(context, str);
            }
            lVar = XU;
            return lVar;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                a(context, (Intent) parcelableExtra, intent.getAction());
            } else {
                a(context, intent, intent.getAction());
            }
        }
    }
}
