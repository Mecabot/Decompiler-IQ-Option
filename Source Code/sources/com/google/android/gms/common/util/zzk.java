package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics.b;

public final class zzk {
    private static IntentFilter zzgkv = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzgkw = 0;
    private static float zzgkx = Float.NaN;

    @TargetApi(20)
    public static int zzcy(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgkv);
        int i = 0;
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (zzs.zzanw() ? powerManager.isInteractive() : powerManager.isScreenOn()) {
            i = 1;
        }
        return (i << 1) | i2;
    }

    public static synchronized float zzcz(Context context) {
        synchronized (zzk.class) {
            float f;
            if (SystemClock.elapsedRealtime() - zzgkw >= 60000 || Float.isNaN(zzgkx)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgkv);
                if (registerReceiver != null) {
                    zzgkx = ((float) registerReceiver.getIntExtra(b.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzgkw = SystemClock.elapsedRealtime();
                f = zzgkx;
                return f;
            }
            f = zzgkx;
            return f;
        }
    }
}
