package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzdkj;
import com.google.android.gms.internal.zzdkn;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzff implements zzfh {
    private /* synthetic */ Map zzksw;
    private /* synthetic */ Map zzksx;
    private /* synthetic */ Map zzksy;
    private /* synthetic */ Map zzksz;

    zzff(zzfc zzfc, Map map, Map map2, Map map3, Map map4) {
        this.zzksw = map;
        this.zzksx = map2;
        this.zzksy = map3;
        this.zzksz = map4;
    }

    public final void zza(zzdkn zzdkn, Set<zzdkj> set, Set<zzdkj> set2, zzer zzer) {
        List list = (List) this.zzksw.get(zzdkn);
        this.zzksx.get(zzdkn);
        if (list != null) {
            set.addAll(list);
            zzer.zzbgx();
        }
        List list2 = (List) this.zzksy.get(zzdkn);
        this.zzksz.get(zzdkn);
        if (list2 != null) {
            set2.addAll(list2);
            zzer.zzbgy();
        }
    }
}
