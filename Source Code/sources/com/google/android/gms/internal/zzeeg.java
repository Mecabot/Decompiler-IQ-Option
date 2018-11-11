package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzeeg<A, B, C> {
    private final Map<B, C> values;
    private final List<A> zzmyy;
    private final zzedt<A, B> zzmyz;
    private zzeed<A, C> zzmza;
    private zzeed<A, C> zzmzb;

    private zzeeg(List<A> list, Map<B, C> map, zzedt<A, B> zzedt) {
        this.zzmyy = list;
        this.values = map;
        this.zzmyz = zzedt;
    }

    private final C zzbt(A a) {
        return this.values.get(this.zzmyz.zzbo(a));
    }

    public static <A, B, C> zzeee<A, C> zzc(List<A> list, Map<B, C> map, zzedt<A, B> zzedt, Comparator<A> comparator) {
        zzeeg zzeeg = new zzeeg(list, map, zzedt);
        Collections.sort(list, comparator);
        Iterator it = new zzeeh(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            int i;
            zzeej zzeej = (zzeej) it.next();
            size -= zzeej.zzmzf;
            if (zzeej.zzmze) {
                i = zzeea.zzmyt;
            } else {
                zzeeg.zzf(zzeea.zzmyt, zzeej.zzmzf, size);
                size -= zzeej.zzmzf;
                i = zzeea.zzmys;
            }
            zzeeg.zzf(i, zzeej.zzmzf, size);
        }
        return new zzeee(zzeeg.zzmza == null ? zzedy.zzbvx() : zzeeg.zzmza, comparator, null);
    }

    private final void zzf(int i, int i2, int i3) {
        zzedz zzx = zzx(i3 + 1, i2 - 1);
        Object obj = this.zzmyy.get(i3);
        zzedz zzeec = i == zzeea.zzmys ? new zzeec(obj, zzbt(obj), null, zzx) : new zzedx(obj, zzbt(obj), null, zzx);
        if (this.zzmza == null) {
            this.zzmza = zzeec;
        } else {
            this.zzmzb.zza(zzeec);
        }
        this.zzmzb = zzeec;
    }

    private final zzedz<A, C> zzx(int i, int i2) {
        if (i2 == 0) {
            return zzedy.zzbvx();
        }
        if (i2 == 1) {
            Object obj = this.zzmyy.get(i);
            return new zzedx(obj, zzbt(obj), null, null);
        }
        i2 /= 2;
        int i3 = i + i2;
        zzedz zzx = zzx(i, i2);
        zzedz zzx2 = zzx(i3 + 1, i2);
        Object obj2 = this.zzmyy.get(i3);
        return new zzedx(obj2, zzbt(obj2), zzx, zzx2);
    }
}
