package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public final class zzdkk {
    private zzbt zzktb;
    private final Map<String, zzbt> zzlce;

    private zzdkk() {
        this.zzlce = new HashMap();
    }

    public final zzdkk zzb(String str, zzbt zzbt) {
        this.zzlce.put(str, zzbt);
        return this;
    }

    public final zzdkj zzbkv() {
        return new zzdkj(this.zzlce, this.zzktb);
    }

    public final zzdkk zzn(zzbt zzbt) {
        this.zzktb = zzbt;
        return this;
    }
}
