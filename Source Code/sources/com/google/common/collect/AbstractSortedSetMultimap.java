package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;

abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements af<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    /* renamed from: so */
    abstract SortedSet<V> sj();

    protected AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: sp */
    SortedSet<V> sk() {
        if (tv() == null) {
            return Collections.unmodifiableSortedSet(sj());
        }
        return ImmutableSortedSet.e(tv());
    }

    /* renamed from: Z */
    public SortedSet<V> X(K k) {
        return (SortedSet) super.R(k);
    }

    /* renamed from: aa */
    public SortedSet<V> Y(Object obj) {
        return (SortedSet) super.S(obj);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }
}
