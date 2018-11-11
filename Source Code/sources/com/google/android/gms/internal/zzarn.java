package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzarn {
    private final Map<String, String> zzbwu;
    private final String zzdxk;
    private final long zzdzi = 0;
    private final String zzdzj;
    private final boolean zzdzk;
    private long zzdzl;

    public zzarn(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        this.zzdxk = str;
        this.zzdzj = str2;
        this.zzdzk = z;
        this.zzdzl = j2;
        this.zzbwu = map != null ? new HashMap(map) : Collections.emptyMap();
    }

    public final Map<String, String> zzjq() {
        return this.zzbwu;
    }

    public final void zzm(long j) {
        this.zzdzl = j;
    }

    public final String zzxe() {
        return this.zzdxk;
    }

    public final long zzyr() {
        return this.zzdzi;
    }

    public final String zzys() {
        return this.zzdzj;
    }

    public final boolean zzyt() {
        return this.zzdzk;
    }

    public final long zzyu() {
        return this.zzdzl;
    }
}
