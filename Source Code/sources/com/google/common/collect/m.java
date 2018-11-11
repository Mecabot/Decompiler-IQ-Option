package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ForwardingMap */
public abstract class m<K, V> extends o implements Map<K, V> {
    /* renamed from: sD */
    protected abstract Map<K, V> qB();

    protected m() {
    }

    public int size() {
        return qB().size();
    }

    public boolean isEmpty() {
        return qB().isEmpty();
    }

    public V remove(Object obj) {
        return qB().remove(obj);
    }

    public void clear() {
        qB().clear();
    }

    public boolean containsKey(Object obj) {
        return qB().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return qB().containsValue(obj);
    }

    public V get(Object obj) {
        return qB().get(obj);
    }

    public V put(K k, V v) {
        return qB().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        qB().putAll(map);
    }

    public Set<K> keySet() {
        return qB().keySet();
    }

    public Collection<V> values() {
        return qB().values();
    }

    public Set<Entry<K, V>> entrySet() {
        return qB().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || qB().equals(obj);
    }

    public int hashCode() {
        return qB().hashCode();
    }
}
