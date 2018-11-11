package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ImmutableMultimap<K, V> extends c<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class a<K, V> {
        Comparator<? super V> QS;
        v<K, V> QV;
        Comparator<? super K> QW;

        public a() {
            this(MultimapBuilder.uw().uB().uA());
        }

        a(v<K, V> vVar) {
            this.QV = vVar;
        }

        public a<K, V> q(K k, V v) {
            g.n(k, v);
            this.QV.j(k, v);
            return this;
        }

        public ImmutableMultimap<K, V> sS() {
            if (this.QS != null) {
                for (Collection collection : this.QV.asMap().values()) {
                    Collections.sort((List) collection, this.QS);
                }
            }
            if (this.QW != null) {
                v uA = MultimapBuilder.uw().uB().uA();
                for (Entry entry : Ordering.from(this.QW).onKeys().immutableSortedCopy(this.QV.asMap().entrySet())) {
                    uA.a(entry.getKey(), (Iterable) entry.getValue());
                }
                this.QV = uA;
            }
            return ImmutableMultimap.d(this.QV);
        }
    }

    static class b {
        static final a<ImmutableMultimap> QX = ab.c(ImmutableMultimap.class, "map");
        static final a<ImmutableMultimap> QY = ab.c(ImmutableMultimap.class, "size");
        static final a<ImmutableSetMultimap> QZ = ab.c(ImmutableSetMultimap.class, "emptySet");
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        /* renamed from: sI */
        public aj<Entry<K, V>> iterator() {
            return this.multimap.rD();
        }

        boolean sK() {
            return this.multimap.sK();
        }

        public int size() {
            return this.multimap.size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.multimap.m(entry.getKey(), entry.getValue());
        }
    }

    private abstract class c<T> extends aj<T> {
        Iterator<V> Pz;
        final Iterator<Entry<K, Collection<V>>> Ra;
        K key;

        abstract T l(K k, V v);

        private c() {
            this.Ra = ImmutableMultimap.this.asMap().entrySet().iterator();
            this.key = null;
            this.Pz = Iterators.tI();
        }

        /* synthetic */ c(ImmutableMultimap immutableMultimap, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean hasNext() {
            return this.Ra.hasNext() || this.Pz.hasNext();
        }

        public T next() {
            if (!this.Pz.hasNext()) {
                Entry entry = (Entry) this.Ra.next();
                this.key = entry.getKey();
                this.Pz = ((Collection) entry.getValue()).iterator();
            }
            return l(this.key, this.Pz.next());
        }
    }

    class Keys extends ImmutableMultiset<K> {
        boolean sK() {
            return true;
        }

        Keys() {
        }

        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        public int count(Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.map.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        /* renamed from: tm */
        public ImmutableSet<K> se() {
            return ImmutableMultimap.this.keySet();
        }

        public int size() {
            return ImmutableMultimap.this.size();
        }

        com.google.common.collect.w.a<K> aH(int i) {
            Entry entry = (Entry) ImmutableMultimap.this.map.entrySet().sJ().get(i);
            return Multisets.k(entry.getKey(), ((Collection) entry.getValue()).size());
        }
    }

    /* renamed from: aj */
    public abstract ImmutableCollection<V> R(K k);

    public static <K, V> a<K, V> tf() {
        return new a();
    }

    public static <K, V> ImmutableMultimap<K, V> d(v<? extends K, ? extends V> vVar) {
        if (vVar instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) vVar;
            if (!immutableMultimap.sK()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.c(vVar);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    @Deprecated
    /* renamed from: ak */
    public ImmutableCollection<V> S(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean j(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean a(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean a(v<? extends K, ? extends V> vVar) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    boolean sK() {
        return this.map.sK();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public int size() {
        return this.size;
    }

    /* renamed from: sX */
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    /* renamed from: tg */
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    Map<K, Collection<V>> rE() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: th */
    public ImmutableCollection<Entry<K, V>> rC() {
        return (ImmutableCollection) super.rC();
    }

    /* renamed from: ti */
    ImmutableCollection<Entry<K, V>> sa() {
        return new EntryCollection(this);
    }

    /* renamed from: tj */
    aj<Entry<K, V>> rD() {
        return new c<Entry<K, V>>() {
            /* renamed from: k */
            Entry<K, V> l(K k, V v) {
                return Maps.x(k, v);
            }
        };
    }

    /* renamed from: tk */
    public ImmutableMultiset<K> sb() {
        return (ImmutableMultiset) super.sb();
    }

    /* renamed from: tl */
    ImmutableMultiset<K> sc() {
        return new Keys();
    }
}
