package com.google.android.gms.tagmanager;

import android.util.LruCache;

final class zzdd extends LruCache<K, V> {
    private /* synthetic */ zzs zzkqt;

    zzdd(zzdc zzdc, int i, zzs zzs) {
        this.zzkqt = zzs;
        super(i);
    }

    protected final int sizeOf(K k, V v) {
        return this.zzkqt.sizeOf(k, v);
    }
}
