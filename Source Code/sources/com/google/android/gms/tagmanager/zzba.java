package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzba implements zzdk {
    private int zzebd = 5;

    public final void e(String str) {
        if (this.zzebd <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public final void setLogLevel(int i) {
        this.zzebd = i;
    }

    public final void v(String str) {
        if (this.zzebd <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public final void zzb(String str, Throwable th) {
        if (this.zzebd <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public final void zzby(String str) {
        if (this.zzebd <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public final void zzc(String str, Throwable th) {
        if (this.zzebd <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public final void zzcy(String str) {
        if (this.zzebd <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public final void zzcz(String str) {
        if (this.zzebd <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
