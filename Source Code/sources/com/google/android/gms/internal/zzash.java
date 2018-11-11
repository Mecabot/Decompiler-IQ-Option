package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;

@Hide
public enum zzash {
    NONE,
    GZIP;

    public static zzash zzek(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
