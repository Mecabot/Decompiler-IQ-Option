package com.google.common.cache;

import com.google.common.collect.o;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ForwardingCache */
public abstract class d<K, V> extends o implements b<K, V> {
    /* renamed from: qA */
    protected abstract b<K, V> qB();

    protected d() {
    }

    public V I(Object obj) {
        return qB().I(obj);
    }

    public V a(K k, Callable<? extends V> callable) {
        return qB().a(k, callable);
    }

    public void put(K k, V v) {
        qB().put(k, v);
    }

    public void J(Object obj) {
        qB().J(obj);
    }

    public void invalidateAll() {
        qB().invalidateAll();
    }

    public ConcurrentMap<K, V> qg() {
        return qB().qg();
    }
}
