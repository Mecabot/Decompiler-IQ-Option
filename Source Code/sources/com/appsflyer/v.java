package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

final class v {
    private IntentFilter qz = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    static final class a {
        private final String pr;
        private final float qA;

        a(float f, String str) {
            this.qA = f;
            this.pr = str;
        }

        final float fT() {
            return this.qA;
        }

        final String fw() {
            return this.pr;
        }

        a() {
        }
    }

    static final class b {
        static final v qB = new v();
    }

    v() {
    }

    @NonNull
    final a D(Context context) {
        String str = null;
        float f = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver(null, this.qz);
            if (registerReceiver != null) {
                int intExtra;
                String str2;
                if ((2 == registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1) ? 1 : null) != null) {
                    intExtra = registerReceiver.getIntExtra("plugged", -1);
                    if (intExtra != 4) {
                        switch (intExtra) {
                            case 1:
                                str2 = "ac";
                                break;
                            case 2:
                                str2 = "usb";
                                break;
                            default:
                                str2 = "other";
                                break;
                        }
                    }
                    str2 = "wireless";
                } else {
                    str2 = "no";
                }
                str = str2;
                intExtra = registerReceiver.getIntExtra(com.google.firebase.analytics.FirebaseAnalytics.b.LEVEL, -1);
                int intExtra2 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra || -1 == intExtra2)) {
                    f = (((float) intExtra) * 100.0f) / ((float) intExtra2);
                }
            }
        } catch (Throwable unused) {
            return new a(f, str);
        }
    }
}
