package com.google.common.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Cache */
public interface b<K, V> {
    V I(Object obj);

    void J(Object obj);

    V a(K k, Callable<? extends V> callable);

    void invalidateAll();

    void put(K k, V v);

    ConcurrentMap<K, V> qg();
}
