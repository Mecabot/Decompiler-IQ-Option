package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public final class zzdkj {
    private final zzbt zzktb;
    private final Map<String, zzbt> zzlce;

    private zzdkj(Map<String, zzbt> map, zzbt zzbt) {
        this.zzlce = map;
        this.zzktb = zzbt;
    }

    public static zzdkk zzbku() {
        return new zzdkk();
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.zzlce));
        String valueOf2 = String.valueOf(this.zzktb);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length());
        stringBuilder.append("Properties: ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" pushAfterEvaluate: ");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }

    public final void zza(String str, zzbt zzbt) {
        this.zzlce.put(str, zzbt);
    }

    public final zzbt zzbhr() {
        return this.zzktb;
    }

    public final Map<String, zzbt> zzbkd() {
        return Collections.unmodifiableMap(this.zzlce);
    }
}
