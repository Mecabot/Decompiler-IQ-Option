package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.collect.ImmutableCollection.b;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;

public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> Rk = new ImmutableSortedMap(ImmutableSortedSet.e(Ordering.natural()), ImmutableList.sL());
    private static final long serialVersionUID = 0;
    private final transient RegularImmutableSortedSet<K> Rl;
    private final transient ImmutableList<V> Rm;
    private transient ImmutableSortedMap<K, V> Rn;

    private static class SerializedForm extends SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        Object readResolve() {
            return a(new a(this.comparator));
        }
    }

    public static class a<K, V> extends com.google.common.collect.ImmutableMap.a<K, V> {
        private final Comparator<? super K> comparator;
        private transient Object[] keys;
        private transient Object[] values;

        public a(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        private a(Comparator<? super K> comparator, int i) {
            this.comparator = (Comparator) i.checkNotNull(comparator);
            this.keys = new Object[i];
            this.values = new Object[i];
        }

        private void ensureCapacity(int i) {
            if (i > this.keys.length) {
                i = b.u(this.keys.length, i);
                this.keys = Arrays.copyOf(this.keys, i);
                this.values = Arrays.copyOf(this.values, i);
            }
        }

        /* renamed from: u */
        public a<K, V> r(K k, V v) {
            ensureCapacity(this.size + 1);
            g.n(k, v);
            this.keys[this.size] = k;
            this.values[this.size] = v;
            this.size++;
            return this;
        }

        /* renamed from: c */
        public a<K, V> b(Entry<? extends K, ? extends V> entry) {
            super.b(entry);
            return this;
        }

        /* renamed from: p */
        public a<K, V> o(Map<? extends K, ? extends V> map) {
            super.o(map);
            return this;
        }

        /* renamed from: n */
        public a<K, V> j(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            super.j(iterable);
            return this;
        }

        /* renamed from: tB */
        public ImmutableSortedMap<K, V> tc() {
            int i = 0;
            switch (this.size) {
                case 0:
                    return ImmutableSortedMap.d(this.comparator);
                case 1:
                    return ImmutableSortedMap.a(this.comparator, this.keys[0], this.values[0]);
                default:
                    Object[] copyOf = Arrays.copyOf(this.keys, this.size);
                    Object[] objArr = copyOf;
                    Arrays.sort(objArr, this.comparator);
                    Object[] objArr2 = new Object[this.size];
                    while (i < this.size) {
                        if (i > 0) {
                            int i2 = i - 1;
                            if (this.comparator.compare(copyOf[i2], copyOf[i]) == 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("keys required to be distinct but compared as equal: ");
                                stringBuilder.append(copyOf[i2]);
                                stringBuilder.append(" and ");
                                stringBuilder.append(copyOf[i]);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                        objArr2[Arrays.binarySearch(objArr, this.keys[i], this.comparator)] = this.values[i];
                        i++;
                    }
                    return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.h(copyOf), this.comparator), ImmutableList.h(objArr2));
            }
        }
    }

    static <K, V> ImmutableSortedMap<K, V> d(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return tw();
        }
        return new ImmutableSortedMap(ImmutableSortedSet.e(comparator), ImmutableList.sL());
    }

    public static <K, V> ImmutableSortedMap<K, V> tw() {
        return Rk;
    }

    private static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> comparator, K k, V v) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.af(k), (Comparator) i.checkNotNull(comparator)), ImmutableList.af(v));
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.Rl = regularImmutableSortedSet;
        this.Rm = immutableList;
        this.Rn = immutableSortedMap;
    }

    public int size() {
        return this.Rm.size();
    }

    public V get(Object obj) {
        int indexOf = this.Rl.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.Rm.get(indexOf);
    }

    boolean sK() {
        return this.Rl.sK() || this.Rm.sK();
    }

    /* renamed from: sV */
    public ImmutableSet<Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    ImmutableSet<Entry<K, V>> sW() {
        return isEmpty() ? ImmutableSet.tq() : new ImmutableMapEntrySet<K, V>() {
            /* renamed from: sI */
            public aj<Entry<K, V>> iterator() {
                return sJ().iterator();
            }

            ImmutableList<Entry<K, V>> tr() {
                return new ImmutableList<Entry<K, V>>() {
                    boolean sK() {
                        return true;
                    }

                    /* renamed from: aV */
                    public Entry<K, V> get(int i) {
                        return new SimpleImmutableEntry(ImmutableSortedMap.this.Rl.sJ().get(i), ImmutableSortedMap.this.Rm.get(i));
                    }

                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }
                };
            }

            ImmutableMap<K, V> te() {
                return ImmutableSortedMap.this;
            }
        };
    }

    /* renamed from: tx */
    public ImmutableSortedSet<K> sX() {
        return this.Rl;
    }

    ImmutableSet<K> sY() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: sZ */
    public ImmutableCollection<V> values() {
        return this.Rm;
    }

    ImmutableCollection<V> ta() {
        throw new AssertionError("should never be called");
    }

    public Comparator<? super K> comparator() {
        return sX().comparator();
    }

    public K firstKey() {
        return sX().first();
    }

    public K lastKey() {
        return sX().last();
    }

    private ImmutableSortedMap<K, V> z(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return d(comparator());
        }
        return new ImmutableSortedMap(this.Rl.B(i, i2), this.Rm.subList(i, i2));
    }

    /* renamed from: ar */
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return z(0, this.Rl.g(i.checkNotNull(k), z));
    }

    /* renamed from: t */
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        i.checkNotNull(k);
        i.checkNotNull(k2);
        i.a(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", (Object) k, (Object) k2);
        return headMap(k2, z2).tailMap(k, z);
    }

    /* renamed from: as */
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    /* renamed from: b */
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return z(this.Rl.h(i.checkNotNull(k), z), size());
    }

    public Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    public K lowerKey(K k) {
        return Maps.e(lowerEntry(k));
    }

    public Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    public K floorKey(K k) {
        return Maps.e(floorEntry(k));
    }

    public Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    public K ceilingKey(K k) {
        return Maps.e(ceilingEntry(k));
    }

    public Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K higherKey(K k) {
        return Maps.e(higherEntry(k));
    }

    public Entry<K, V> firstEntry() {
        return isEmpty() ? null : (Entry) entrySet().sJ().get(0);
    }

    public Entry<K, V> lastEntry() {
        return isEmpty() ? null : (Entry) entrySet().sJ().get(size() - 1);
    }

    @Deprecated
    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: ty */
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.Rn;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return d(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.Rl.descendingSet(), this.Rm.sN(), this);
    }

    /* renamed from: tz */
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.Rl;
    }

    /* renamed from: tA */
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.Rl.descendingSet();
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
