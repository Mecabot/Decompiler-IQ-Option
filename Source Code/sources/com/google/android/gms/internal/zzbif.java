package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzs;

public final class zzbif {
    private static Context zzglq;
    private static Boolean zzglr;

    public static synchronized boolean zzdb(Context context) {
        synchronized (zzbif.class) {
            Context applicationContext = context.getApplicationContext();
            boolean booleanValue;
            if (zzglq == null || zzglr == null || zzglq != applicationContext) {
                Boolean valueOf;
                zzglr = null;
                if (zzs.isAtLeastO()) {
                    valueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzglr = Boolean.valueOf(true);
                    } catch (ClassNotFoundException unused) {
                        valueOf = Boolean.valueOf(false);
                    }
                    zzglq = applicationContext;
                    booleanValue = zzglr.booleanValue();
                    return booleanValue;
                }
                zzglr = valueOf;
                zzglq = applicationContext;
                booleanValue = zzglr.booleanValue();
                return booleanValue;
            }
            booleanValue = zzglr.booleanValue();
            return booleanValue;
        }
    }
}
