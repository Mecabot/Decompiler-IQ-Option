package com.google.common.cache;

import com.google.common.base.d;

/* compiled from: LoadingCache */
public interface e<K, V> extends d<K, V>, b<K, V> {
    V L(K k);

    @Deprecated
    V apply(K k);
}
