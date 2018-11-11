package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ac<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    /* renamed from: sj */
    abstract Set<V> ry();

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: sk */
    Set<V> rz() {
        return ImmutableSet.tq();
    }

    /* renamed from: X */
    public Set<V> R(K k) {
        return (Set) super.R(k);
    }

    /* renamed from: sl */
    public Set<Entry<K, V>> rC() {
        return (Set) super.rC();
    }

    /* renamed from: Y */
    public Set<V> S(Object obj) {
        return (Set) super.S(obj);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean j(K k, V v) {
        return super.j(k, v);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
