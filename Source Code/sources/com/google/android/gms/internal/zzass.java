package com.google.android.gms.internal;

import android.os.Build.VERSION;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzass {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException unused) {
            zzatc.zzf("Invalid version number", VERSION.SDK);
            return 0;
        }
    }
}
