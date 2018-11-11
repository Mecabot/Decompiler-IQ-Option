package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbt;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzbr {
    private final Set<String> zzkpr;
    private final String zzkps;

    public zzbr(String str, String... strArr) {
        this.zzkps = str;
        this.zzkpr = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.zzkpr.add(add);
        }
    }

    public abstract boolean zzbfh();

    public String zzbgp() {
        return this.zzkps;
    }

    public Set<String> zzbgq() {
        return this.zzkpr;
    }

    final boolean zzd(Set<String> set) {
        return set.containsAll(this.zzkpr);
    }

    public abstract zzbt zzx(Map<String, zzbt> map);
}
