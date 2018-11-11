package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.internal.Hide;

@Hide
@Deprecated
public final class zzatc {
    private static volatile Logger zzedt = new zzasm();

    public static Logger getLogger() {
        return zzedt;
    }

    public static void setLogger(Logger logger) {
        zzedt = logger;
    }

    public static void v(String str) {
        zzarh zzaat = zzatd.zzaat();
        if (zzaat != null) {
            zzaat.zzea(str);
        } else if (zzae(0)) {
            Log.v((String) zzast.zzebn.get(), str);
        }
        Logger logger = zzedt;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    private static boolean zzae(int i) {
        return zzedt != null && zzedt.getLogLevel() <= i;
    }

    public static void zzcz(String str) {
        zzarh zzaat = zzatd.zzaat();
        if (zzaat != null) {
            zzaat.zzed(str);
        } else if (zzae(2)) {
            Log.w((String) zzast.zzebn.get(), str);
        }
        Logger logger = zzedt;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static void zzf(String str, Object obj) {
        zzarh zzaat = zzatd.zzaat();
        if (zzaat != null) {
            zzaat.zze(str, obj);
        } else if (zzae(3)) {
            String valueOf;
            if (obj != null) {
                valueOf = String.valueOf(obj);
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length());
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(valueOf);
                valueOf = stringBuilder.toString();
            } else {
                valueOf = str;
            }
            Log.e((String) zzast.zzebn.get(), valueOf);
        }
        Logger logger = zzedt;
        if (logger != null) {
            logger.error(str);
        }
    }
}
