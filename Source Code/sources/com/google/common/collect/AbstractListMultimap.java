package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements t<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    /* renamed from: rw */
    abstract List<V> ry();

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: rx */
    List<V> rz() {
        return ImmutableList.sL();
    }

    /* renamed from: get */
    public List<V> R(K k) {
        return (List) super.R(k);
    }

    /* renamed from: Q */
    public List<V> S(Object obj) {
        return (List) super.S(obj);
    }

    public boolean j(K k, V v) {
        return super.j(k, v);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
