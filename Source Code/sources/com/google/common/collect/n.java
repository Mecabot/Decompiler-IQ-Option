package com.google.common.collect;

import java.util.Map.Entry;

/* compiled from: ForwardingMapEntry */
public abstract class n<K, V> extends o implements Entry<K, V> {
    /* renamed from: sE */
    protected abstract Entry<K, V> qB();

    protected n() {
    }

    public K getKey() {
        return qB().getKey();
    }

    public V getValue() {
        return qB().getValue();
    }

    public V setValue(V v) {
        return qB().setValue(v);
    }

    public boolean equals(Object obj) {
        return qB().equals(obj);
    }

    public int hashCode() {
        return qB().hashCode();
    }
}
