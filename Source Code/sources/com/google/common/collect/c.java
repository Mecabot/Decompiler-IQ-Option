package com.google.common.collect;

import com.google.common.base.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: AbstractMultimap */
abstract class c<K, V> implements v<K, V> {
    private transient Set<K> Os;
    private transient Collection<Entry<K, V>> Qg;
    private transient w<K> Qh;
    private transient Map<K, Collection<V>> Qi;

    /* compiled from: AbstractMultimap */
    private class a extends a<K, V> {
        private a() {
        }

        v<K, V> sd() {
            return c.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return c.this.rD();
        }
    }

    /* compiled from: AbstractMultimap */
    private class b extends a implements Set<Entry<K, V>> {
        private b() {
            super();
        }

        public int hashCode() {
            return Sets.d(this);
        }

        public boolean equals(Object obj) {
            return Sets.a((Set) this, obj);
        }
    }

    abstract Iterator<Entry<K, V>> rD();

    abstract Map<K, Collection<V>> rE();

    c() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean m(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean j(K k, V v) {
        return R(k).add(v);
    }

    public boolean a(K k, Iterable<? extends V> iterable) {
        i.checkNotNull(iterable);
        boolean z = false;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (!collection.isEmpty() && R(k).addAll(collection)) {
                z = true;
            }
            return z;
        }
        Iterator it = iterable.iterator();
        if (it.hasNext() && Iterators.a(R(k), it)) {
            z = true;
        }
        return z;
    }

    public boolean a(v<? extends K, ? extends V> vVar) {
        boolean z = false;
        for (Entry entry : vVar.rC()) {
            z |= j(entry.getKey(), entry.getValue());
        }
        return z;
    }

    public Collection<Entry<K, V>> rC() {
        Collection<Entry<K, V>> collection = this.Qg;
        if (collection != null) {
            return collection;
        }
        collection = sa();
        this.Qg = collection;
        return collection;
    }

    Collection<Entry<K, V>> sa() {
        if (this instanceof ac) {
            return new b();
        }
        return new a();
    }

    public Set<K> keySet() {
        Set<K> set = this.Os;
        if (set != null) {
            return set;
        }
        set = rB();
        this.Os = set;
        return set;
    }

    Set<K> rB() {
        return new b(asMap());
    }

    public w<K> sb() {
        w<K> wVar = this.Qh;
        if (wVar != null) {
            return wVar;
        }
        wVar = sc();
        this.Qh = wVar;
        return wVar;
    }

    w<K> sc() {
        return new b(this);
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.Qi;
        if (map != null) {
            return map;
        }
        map = rE();
        this.Qi = map;
        return map;
    }

    public boolean equals(Object obj) {
        return Multimaps.a((v) this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
