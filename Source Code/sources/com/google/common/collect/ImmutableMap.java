package com.google.common.collect;

import com.google.common.collect.ImmutableCollection.b;
import java.io.Serializable;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Entry<?, ?>[] QN = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> QO;
    private transient ImmutableSet<K> QP;
    private transient ImmutableCollection<V> QQ;

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            Iterator sI = immutableMap.entrySet().iterator();
            int i = 0;
            while (sI.hasNext()) {
                Entry entry = (Entry) sI.next();
                this.keys[i] = entry.getKey();
                this.values[i] = entry.getValue();
                i++;
            }
        }

        Object readResolve() {
            return a(new a(this.keys.length));
        }

        Object a(a<Object, Object> aVar) {
            for (int i = 0; i < this.keys.length; i++) {
                aVar.r(this.keys[i], this.values[i]);
            }
            return aVar.tc();
        }
    }

    public static class a<K, V> {
        Comparator<? super V> QS;
        Object[] QT;
        boolean QU;
        int size;

        public a() {
            this(4);
        }

        a(int i) {
            this.QT = new Object[(i * 2)];
            this.size = 0;
            this.QU = false;
        }

        private void ensureCapacity(int i) {
            i *= 2;
            if (i > this.QT.length) {
                this.QT = Arrays.copyOf(this.QT, b.u(this.QT.length, i));
                this.QU = false;
            }
        }

        public a<K, V> r(K k, V v) {
            ensureCapacity(this.size + 1);
            g.n(k, v);
            this.QT[this.size * 2] = k;
            this.QT[(this.size * 2) + 1] = v;
            this.size++;
            return this;
        }

        public a<K, V> b(Entry<? extends K, ? extends V> entry) {
            return r(entry.getKey(), entry.getValue());
        }

        public a<K, V> o(Map<? extends K, ? extends V> map) {
            return j(map.entrySet());
        }

        public a<K, V> j(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                ensureCapacity(this.size + ((Collection) iterable).size());
            }
            for (Entry b : iterable) {
                b(b);
            }
            return this;
        }

        public ImmutableMap<K, V> tc() {
            td();
            this.QU = true;
            return RegularImmutableMap.c(this.size, this.QT);
        }

        void td() {
            if (this.QS != null) {
                if (this.QU) {
                    this.QT = Arrays.copyOf(this.QT, this.size * 2);
                }
                Entry[] entryArr = new Entry[this.size];
                int i = 0;
                for (int i2 = 0; i2 < this.size; i2++) {
                    int i3 = i2 * 2;
                    entryArr[i2] = new SimpleImmutableEntry(this.QT[i3], this.QT[i3 + 1]);
                }
                Arrays.sort(entryArr, 0, this.size, Ordering.from(this.QS).onResultOf(Maps.ur()));
                while (i < this.size) {
                    int i4 = i * 2;
                    this.QT[i4] = entryArr[i].getKey();
                    this.QT[i4 + 1] = entryArr[i].getValue();
                    i++;
                }
            }
        }
    }

    public abstract V get(Object obj);

    abstract boolean sK();

    abstract ImmutableSet<Entry<K, V>> sW();

    abstract ImmutableSet<K> sY();

    abstract ImmutableCollection<V> ta();

    boolean tb() {
        return false;
    }

    public static <K, V> ImmutableMap<K, V> sT() {
        return RegularImmutableMap.Tb;
    }

    public static <K, V> ImmutableMap<K, V> a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        g.n(k, v);
        g.n(k2, v2);
        g.n(k3, v3);
        g.n(k4, v4);
        g.n(k5, v5);
        return RegularImmutableMap.c(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public static <K, V> a<K, V> sU() {
        return new a();
    }

    public static <K, V> ImmutableMap<K, V> n(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.sK()) {
                return immutableMap;
            }
        }
        return i(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> i(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.j(iterable);
        return aVar.tc();
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* renamed from: sV */
    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.QO;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = sW();
        this.QO = immutableSet;
        return immutableSet;
    }

    /* renamed from: sX */
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.QP;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = sY();
        this.QP = immutableSet;
        return immutableSet;
    }

    /* renamed from: sZ */
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.QQ;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = ta();
        this.QQ = immutableCollection;
        return immutableCollection;
    }

    public boolean equals(Object obj) {
        return Maps.d((Map) this, obj);
    }

    public int hashCode() {
        return Sets.d(entrySet());
    }

    public String toString() {
        return Maps.q(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
