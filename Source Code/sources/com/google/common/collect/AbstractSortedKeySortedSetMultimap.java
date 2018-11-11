package com.google.common.collect;

import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    /* renamed from: sm */
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* renamed from: sn */
    SortedMap<K, Collection<V>> rA() {
        return (SortedMap) super.rA();
    }

    /* renamed from: rK */
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
