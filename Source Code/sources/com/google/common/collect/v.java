package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Multimap */
public interface v<K, V> {
    Collection<V> R(K k);

    Collection<V> S(Object obj);

    boolean a(K k, Iterable<? extends V> iterable);

    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsKey(Object obj);

    boolean equals(Object obj);

    int hashCode();

    boolean isEmpty();

    boolean j(K k, V v);

    Set<K> keySet();

    boolean m(Object obj, Object obj2);

    Collection<Entry<K, V>> rC();

    boolean remove(Object obj, Object obj2);

    int size();
}
