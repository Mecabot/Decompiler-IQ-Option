package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
final class zzdc<K, V> implements zzp<K, V> {
    private LruCache<K, V> zzkqs;

    zzdc(int i, zzs<K, V> zzs) {
        this.zzkqs = new zzdd(this, 1048576, zzs);
    }

    public final V get(K k) {
        return this.zzkqs.get(k);
    }

    public final void zzf(K k, V v) {
        this.zzkqs.put(k, v);
    }
}
