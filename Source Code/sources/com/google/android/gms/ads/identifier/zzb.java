package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.zzs;

@Hide
public final class zzb {
    private SharedPreferences zzang;

    @Hide
    public zzb(Context context) {
        try {
            context = zzs.getRemoteContext(context);
            this.zzang = context == null ? null : context.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.zzang = null;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        try {
            return this.zzang == null ? false : this.zzang.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    final float getFloat(String str, float f) {
        try {
            return this.zzang == null ? 0.0f : this.zzang.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    final String getString(String str, String str2) {
        try {
            return this.zzang == null ? str2 : this.zzang.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }
}
