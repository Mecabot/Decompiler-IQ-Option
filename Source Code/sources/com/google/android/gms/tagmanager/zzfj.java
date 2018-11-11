package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzdkj;
import com.google.android.gms.internal.zzdkn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfj {
    private final Set<zzdkn> zzkss = new HashSet();
    private final Map<zzdkn, List<zzdkj>> zzktc = new HashMap();
    private final Map<zzdkn, List<zzdkj>> zzktd = new HashMap();
    private final Map<zzdkn, List<String>> zzkte = new HashMap();
    private final Map<zzdkn, List<String>> zzktf = new HashMap();
    private zzdkj zzktg;

    public final void zza(zzdkn zzdkn) {
        this.zzkss.add(zzdkn);
    }

    public final void zza(zzdkn zzdkn, zzdkj zzdkj) {
        List list = (List) this.zzktc.get(zzdkn);
        if (list == null) {
            list = new ArrayList();
            this.zzktc.put(zzdkn, list);
        }
        list.add(zzdkj);
    }

    public final void zza(zzdkn zzdkn, String str) {
        List list = (List) this.zzkte.get(zzdkn);
        if (list == null) {
            list = new ArrayList();
            this.zzkte.put(zzdkn, list);
        }
        list.add(str);
    }

    public final void zzb(zzdkj zzdkj) {
        this.zzktg = zzdkj;
    }

    public final void zzb(zzdkn zzdkn, zzdkj zzdkj) {
        List list = (List) this.zzktd.get(zzdkn);
        if (list == null) {
            list = new ArrayList();
            this.zzktd.put(zzdkn, list);
        }
        list.add(zzdkj);
    }

    public final void zzb(zzdkn zzdkn, String str) {
        List list = (List) this.zzktf.get(zzdkn);
        if (list == null) {
            list = new ArrayList();
            this.zzktf.put(zzdkn, list);
        }
        list.add(str);
    }

    public final Set<zzdkn> zzbhs() {
        return this.zzkss;
    }

    public final Map<zzdkn, List<zzdkj>> zzbht() {
        return this.zzktc;
    }

    public final Map<zzdkn, List<String>> zzbhu() {
        return this.zzkte;
    }

    public final Map<zzdkn, List<String>> zzbhv() {
        return this.zzktf;
    }

    public final Map<zzdkn, List<zzdkj>> zzbhw() {
        return this.zzktd;
    }

    public final zzdkj zzbhx() {
        return this.zzktg;
    }
}
