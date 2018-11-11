package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class zzeed<K, V> implements zzedz<K, V> {
    private final V value;
    private final K zzmbd;
    private zzedz<K, V> zzmyv;
    private final zzedz<K, V> zzmyw;

    zzeed(K k, V v, zzedz<K, V> zzedz, zzedz<K, V> zzedz2) {
        zzedz zzedz3;
        zzedz zzedz22;
        this.zzmbd = k;
        this.value = v;
        if (zzedz3 == null) {
            zzedz3 = zzedy.zzbvx();
        }
        this.zzmyv = zzedz3;
        if (zzedz22 == null) {
            zzedz22 = zzedy.zzbvx();
        }
        this.zzmyw = zzedz22;
    }

    private static int zzb(zzedz zzedz) {
        return zzedz.zzbvw() ? zzeea.zzmyt : zzeea.zzmys;
    }

    private final zzeed<K, V> zzb(K k, V v, Integer num, zzedz<K, V> zzedz, zzedz<K, V> zzedz2) {
        zzedz zzedz3;
        zzedz zzedz22;
        Object obj = this.zzmbd;
        Object obj2 = this.value;
        if (zzedz3 == null) {
            zzedz3 = this.zzmyv;
        }
        if (zzedz22 == null) {
            zzedz22 = this.zzmyw;
        }
        return num == zzeea.zzmys ? new zzeec(obj, obj2, zzedz3, zzedz22) : new zzedx(obj, obj2, zzedz3, zzedz22);
    }

    private final zzedz<K, V> zzbwc() {
        if (this.zzmyv.isEmpty()) {
            return zzedy.zzbvx();
        }
        zzeed zzbwd = (this.zzmyv.zzbvw() || this.zzmyv.zzbvy().zzbvw()) ? this : zzbwd();
        return zzbwd.zza(null, null, ((zzeed) zzbwd.zzmyv).zzbwc(), null).zzbwe();
    }

    private final zzeed<K, V> zzbwd() {
        zzeed<K, V> zzbwh = zzbwh();
        return zzbwh.zzmyw.zzbvy().zzbvw() ? zzbwh.zza(null, null, null, ((zzeed) zzbwh.zzmyw).zzbwg()).zzbwf().zzbwh() : zzbwh;
    }

    private final zzeed<K, V> zzbwe() {
        zzeed<K, V> zzbwf = (!this.zzmyw.zzbvw() || this.zzmyv.zzbvw()) ? this : zzbwf();
        if (zzbwf.zzmyv.zzbvw() && ((zzeed) zzbwf.zzmyv).zzmyv.zzbvw()) {
            zzbwf = zzbwf.zzbwg();
        }
        return (zzbwf.zzmyv.zzbvw() && zzbwf.zzmyw.zzbvw()) ? zzbwf.zzbwh() : zzbwf;
    }

    private final zzeed<K, V> zzbwf() {
        return (zzeed) this.zzmyw.zza(null, null, zzbvv(), zzb(null, null, zzeea.zzmys, null, ((zzeed) this.zzmyw).zzmyv), null);
    }

    private final zzeed<K, V> zzbwg() {
        return (zzeed) this.zzmyv.zza(null, null, zzbvv(), null, zzb(null, null, zzeea.zzmys, ((zzeed) this.zzmyv).zzmyw, null));
    }

    private final zzeed<K, V> zzbwh() {
        return zzb(null, null, zzb(this), this.zzmyv.zza(null, null, zzb(this.zzmyv), null, null), this.zzmyw.zza(null, null, zzb(this.zzmyw), null, null));
    }

    public final K getKey() {
        return this.zzmbd;
    }

    public final V getValue() {
        return this.value;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final /* synthetic */ zzedz zza(Object obj, Object obj2, int i, zzedz zzedz, zzedz zzedz2) {
        return zzb(null, null, i, zzedz, zzedz2);
    }

    public final zzedz<K, V> zza(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.zzmbd);
        zzeed zza = compare < 0 ? zza(null, null, this.zzmyv.zza(k, v, comparator), null) : compare == 0 ? zza(k, v, null, null) : zza(null, null, null, this.zzmyw.zza(k, v, comparator));
        return zza.zzbwe();
    }

    public final zzedz<K, V> zza(K k, Comparator<K> comparator) {
        zzeed zza;
        zzeed zzbwd;
        if (comparator.compare(k, this.zzmbd) < 0) {
            zzbwd = (this.zzmyv.isEmpty() || this.zzmyv.zzbvw() || ((zzeed) this.zzmyv).zzmyv.zzbvw()) ? this : zzbwd();
            zza = zzbwd.zza(null, null, zzbwd.zzmyv.zza(k, comparator), null);
        } else {
            zzbwd = this.zzmyv.zzbvw() ? zzbwg() : this;
            if (!(zzbwd.zzmyw.isEmpty() || zzbwd.zzmyw.zzbvw() || ((zzeed) zzbwd.zzmyw).zzmyv.zzbvw())) {
                zzbwd = zzbwd.zzbwh();
                if (zzbwd.zzmyv.zzbvy().zzbvw()) {
                    zzbwd = zzbwd.zzbwg().zzbwh();
                }
            }
            if (comparator.compare(k, zzbwd.zzmbd) == 0) {
                if (zzbwd.zzmyw.isEmpty()) {
                    return zzedy.zzbvx();
                }
                zzedz zzbwa = zzbwd.zzmyw.zzbwa();
                zzbwd = zzbwd.zza(zzbwa.getKey(), zzbwa.getValue(), null, ((zzeed) zzbwd.zzmyw).zzbwc());
            }
            zza = zzbwd.zza(null, null, null, zzbwd.zzmyw.zza(k, comparator));
        }
        return zza.zzbwe();
    }

    protected abstract zzeed<K, V> zza(K k, V v, zzedz<K, V> zzedz, zzedz<K, V> zzedz2);

    void zza(zzedz<K, V> zzedz) {
        this.zzmyv = zzedz;
    }

    public final void zza(zzeeb<K, V> zzeeb) {
        this.zzmyv.zza(zzeeb);
        zzeeb.zzh(this.zzmbd, this.value);
        this.zzmyw.zza(zzeeb);
    }

    protected abstract int zzbvv();

    public final zzedz<K, V> zzbvy() {
        return this.zzmyv;
    }

    public final zzedz<K, V> zzbvz() {
        return this.zzmyw;
    }

    public final zzedz<K, V> zzbwa() {
        return this.zzmyv.isEmpty() ? this : this.zzmyv.zzbwa();
    }

    public final zzedz<K, V> zzbwb() {
        return this.zzmyw.isEmpty() ? this : this.zzmyw.zzbwb();
    }
}
