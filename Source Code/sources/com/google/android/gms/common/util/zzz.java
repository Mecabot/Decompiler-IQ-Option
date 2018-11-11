package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzt;
import com.google.android.gms.internal.zzbih;

public final class zzz {
    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        return zzbih.zzdd(context).zzf(i, str);
    }

    public static boolean zze(Context context, int i) {
        if (!zzb(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return zzt.zzcj(context).zza(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }
}
