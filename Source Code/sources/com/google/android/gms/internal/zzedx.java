package com.google.android.gms.internal;

public final class zzedx<K, V> extends zzeed<K, V> {
    private int size = -1;

    zzedx(K k, V v, zzedz<K, V> zzedz, zzedz<K, V> zzedz2) {
        super(k, v, zzedz, zzedz2);
    }

    public final int size() {
        if (this.size == -1) {
            this.size = (zzbvy().size() + 1) + zzbvz().size();
        }
        return this.size;
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
        return new zzedx(k2, v2, zzedz3, zzedz22);
    }

    final void zza(zzedz<K, V> zzedz) {
        if (this.size != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.zza((zzedz) zzedz);
    }

    protected final int zzbvv() {
        return zzeea.zzmyt;
    }

    public final boolean zzbvw() {
        return false;
    }
}
