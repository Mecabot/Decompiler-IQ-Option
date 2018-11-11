package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzgk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzdkm {
    private String zzfli;
    private final List<zzdkn> zzlcb;
    private final Map<String, List<zzdkj>> zzlcc;
    private int zzlcd;

    private zzdkm() {
        this.zzlcb = new ArrayList();
        this.zzlcc = new HashMap();
        this.zzfli = "";
        this.zzlcd = 0;
    }

    public final zzdkm zzb(zzdkn zzdkn) {
        this.zzlcb.add(zzdkn);
        return this;
    }

    public final zzdkl zzbky() {
        return new zzdkl(this.zzlcb, this.zzlcc, this.zzfli, this.zzlcd);
    }

    public final zzdkm zzc(zzdkj zzdkj) {
        String zzd = zzgk.zzd((zzbt) zzdkj.zzbkd().get(zzbi.INSTANCE_NAME.toString()));
        List list = (List) this.zzlcc.get(zzd);
        if (list == null) {
            list = new ArrayList();
            this.zzlcc.put(zzd, list);
        }
        list.add(zzdkj);
        return this;
    }

    public final zzdkm zzfk(int i) {
        this.zzlcd = i;
        return this;
    }

    public final zzdkm zznn(String str) {
        this.zzfli = str;
        return this;
    }
}
