package com.google.android.gms.internal;

public final class zzeec<K, V> extends zzeed<K, V> {
    zzeec(K k, V v) {
        super(k, v, zzedy.zzbvx(), zzedy.zzbvx());
    }

    zzeec(K k, V v, zzedz<K, V> zzedz, zzedz<K, V> zzedz2) {
        super(k, v, zzedz, zzedz2);
    }

    public final int size() {
        return (zzbvy().size() + 1) + zzbvz().size();
    }

    protected final zzeed<K, V> zza(K k, V v, zzedz<K, V> zzedz, zzedz<K, V> zzedz2) {
        Object k2;
        Object v2;
        zzedz zzedz3;
        zzedz zzedz22;
        if (k2 == null) {
            k2 = getKey();
        }
        if (v2 == null) {
            v2 = getValue();
        }
        if (zzedz3 == null) {
            zzedz3 = zzbvy();
        }
        if (zzedz22 == null) {
            zzedz22 = zzbvz();
        }
        return new zzeec(k2, v2, zzedz3, zzedz22);
    }

    protected final int zzbvv() {
        return zzeea.zzmys;
    }

    public final boolean zzbvw() {
        return true;
    }
}
