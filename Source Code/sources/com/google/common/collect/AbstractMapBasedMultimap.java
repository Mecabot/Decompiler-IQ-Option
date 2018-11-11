package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient int Ps;
    private transient Map<K, Collection<V>> map;

    private abstract class b<T> implements Iterator<T> {
        Collection<V> Px = null;
        final Iterator<Entry<K, Collection<V>>> Py;
        Iterator<V> Pz = Iterators.tK();
        K key = null;

        abstract T l(K k, V v);

        b() {
            this.Py = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.Py.hasNext() || this.Pz.hasNext();
        }

        public T next() {
            if (!this.Pz.hasNext()) {
                Entry entry = (Entry) this.Py.next();
                this.key = entry.getKey();
                this.Px = (Collection) entry.getValue();
                this.Pz = this.Px.iterator();
            }
            return l(this.key, this.Pz.next());
        }

        public void remove() {
            this.Pz.remove();
            if (this.Px.isEmpty()) {
                this.Py.remove();
            }
            AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - 1;
        }
    }

    private class i extends AbstractCollection<V> {
        Collection<V> PJ;
        final i PO;
        final Collection<V> PP;
        final K key;

        class a implements Iterator<V> {
            final Collection<V> PQ = i.this.PJ;
            final Iterator<V> Pw;

            a() {
                this.Pw = AbstractMapBasedMultimap.i(i.this.PJ);
            }

            a(Iterator<V> it) {
                this.Pw = it;
            }

            void rR() {
                i.this.rM();
                if (i.this.PJ != this.PQ) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                rR();
                return this.Pw.hasNext();
            }

            public V next() {
                rR();
                return this.Pw.next();
            }

            public void remove() {
                this.Pw.remove();
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - 1;
                i.this.rN();
            }

            Iterator<V> rS() {
                rR();
                return this.Pw;
            }
        }

        i(K k, Collection<V> collection, i iVar) {
            Collection collection2;
            this.key = k;
            this.PJ = collection;
            this.PO = iVar;
            if (iVar == null) {
                collection2 = null;
            } else {
                collection2 = iVar.rP();
            }
            this.PP = collection2;
        }

        void rM() {
            if (this.PO != null) {
                this.PO.rM();
                if (this.PO.rP() != this.PP) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.PJ.isEmpty()) {
                Collection collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.key);
                if (collection != null) {
                    this.PJ = collection;
                }
            }
        }

        void rN() {
            if (this.PO != null) {
                this.PO.rN();
            } else if (this.PJ.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }

        K getKey() {
            return this.key;
        }

        void rO() {
            if (this.PO != null) {
                this.PO.rO();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.key, this.PJ);
            }
        }

        public int size() {
            rM();
            return this.PJ.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            rM();
            return this.PJ.equals(obj);
        }

        public int hashCode() {
            rM();
            return this.PJ.hashCode();
        }

        public String toString() {
            rM();
            return this.PJ.toString();
        }

        Collection<V> rP() {
            return this.PJ;
        }

        public Iterator<V> iterator() {
            rM();
            return new a();
        }

        public boolean add(V v) {
            rM();
            boolean isEmpty = this.PJ.isEmpty();
            boolean add = this.PJ.add(v);
            if (add) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + 1;
                if (isEmpty) {
                    rO();
                }
            }
            return add;
        }

        i rQ() {
            return this.PO;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.PJ.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + (this.PJ.size() - size);
                if (size == 0) {
                    rO();
                }
            }
            return addAll;
        }

        public boolean contains(Object obj) {
            rM();
            return this.PJ.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            rM();
            return this.PJ.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.PJ.clear();
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - size;
                rN();
            }
        }

        public boolean remove(Object obj) {
            rM();
            boolean remove = this.PJ.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - 1;
                rN();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.PJ.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + (this.PJ.size() - size);
                rN();
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.i.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.PJ.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + (this.PJ.size() - size);
                rN();
            }
            return retainAll;
        }
    }

    private class a extends d<K, Collection<V>> {
        final transient Map<K, Collection<V>> Pu;

        class b implements Iterator<Entry<K, Collection<V>>> {
            final Iterator<Entry<K, Collection<V>>> Pw = a.this.Pu.entrySet().iterator();
            Collection<V> Px;

            b() {
            }

            public boolean hasNext() {
                return this.Pw.hasNext();
            }

            public Entry<K, Collection<V>> next() {
                Entry entry = (Entry) this.Pw.next();
                this.Px = (Collection) entry.getValue();
                return a.this.a(entry);
            }

            public void remove() {
                this.Pw.remove();
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - this.Px.size();
                this.Px.clear();
            }
        }

        class a extends a<K, Collection<V>> {
            a() {
            }

            Map<K, Collection<V>> rG() {
                return a.this;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            public boolean contains(Object obj) {
                return h.a(a.this.Pu.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.U(((Entry) obj).getKey());
                return true;
            }
        }

        a(Map<K, Collection<V>> map) {
            this.Pu = map;
        }

        protected Set<Entry<K, Collection<V>>> rF() {
            return new a();
        }

        public boolean containsKey(Object obj) {
            return Maps.b(this.Pu, obj);
        }

        /* renamed from: R */
        public Collection<V> get(Object obj) {
            Collection collection = (Collection) Maps.a(this.Pu, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.a(obj, collection);
        }

        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.Pu.size();
        }

        /* renamed from: V */
        public Collection<V> remove(Object obj) {
            Collection collection = (Collection) this.Pu.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> ry = AbstractMapBasedMultimap.this.ry();
            ry.addAll(collection);
            AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - collection.size();
            collection.clear();
            return ry;
        }

        public boolean equals(Object obj) {
            return this == obj || this.Pu.equals(obj);
        }

        public int hashCode() {
            return this.Pu.hashCode();
        }

        public String toString() {
            return this.Pu.toString();
        }

        public void clear() {
            if (this.Pu == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.p(new b());
            }
        }

        Entry<K, Collection<V>> a(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return Maps.x(key, AbstractMapBasedMultimap.this.a(key, (Collection) entry.getValue()));
        }
    }

    private class j extends i implements List<V> {

        private class a extends com.google.common.collect.AbstractMapBasedMultimap$i.a implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i) {
                super(j.this.rT().listIterator(i));
            }

            private ListIterator<V> rU() {
                return (ListIterator) rS();
            }

            public boolean hasPrevious() {
                return rU().hasPrevious();
            }

            public V previous() {
                return rU().previous();
            }

            public int nextIndex() {
                return rU().nextIndex();
            }

            public int previousIndex() {
                return rU().previousIndex();
            }

            public void set(V v) {
                rU().set(v);
            }

            public void add(V v) {
                boolean isEmpty = j.this.isEmpty();
                rU().add(v);
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + 1;
                if (isEmpty) {
                    j.this.rO();
                }
            }
        }

        j(K k, List<V> list, i iVar) {
            super(k, list, iVar);
        }

        List<V> rT() {
            return (List) rP();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = rT().addAll(i, collection);
            if (addAll) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + (rP().size() - size);
                if (size == 0) {
                    rO();
                }
            }
            return addAll;
        }

        public V get(int i) {
            rM();
            return rT().get(i);
        }

        public V set(int i, V v) {
            rM();
            return rT().set(i, v);
        }

        public void add(int i, V v) {
            rM();
            boolean isEmpty = rP().isEmpty();
            rT().add(i, v);
            AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + 1;
            if (isEmpty) {
                rO();
            }
        }

        public V remove(int i) {
            rM();
            V remove = rT().remove(i);
            AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - 1;
            rN();
            return remove;
        }

        public int indexOf(Object obj) {
            rM();
            return rT().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            rM();
            return rT().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            rM();
            return new a();
        }

        public ListIterator<V> listIterator(int i) {
            rM();
            return new a(i);
        }

        public List<V> subList(int i, int i2) {
            rM();
            return AbstractMapBasedMultimap.this.a(getKey(), rT().subList(i, i2), rQ() == null ? this : rQ());
        }
    }

    private class l extends i implements Set<V> {
        l(K k, Set<V> set) {
            super(k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = Sets.a((Set) this.PJ, (Collection) collection);
            if (a) {
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps + (this.PJ.size() - size);
                rN();
            }
            return a;
        }
    }

    private class m extends i implements SortedSet<V> {
        m(K k, SortedSet<V> sortedSet, i iVar) {
            super(k, sortedSet, iVar);
        }

        SortedSet<V> rW() {
            return (SortedSet) rP();
        }

        public Comparator<? super V> comparator() {
            return rW().comparator();
        }

        public V first() {
            rM();
            return rW().first();
        }

        public V last() {
            rM();
            return rW().last();
        }

        public SortedSet<V> headSet(V v) {
            rM();
            return new m(getKey(), rW().headSet(v), rQ() == null ? this : rQ());
        }

        public SortedSet<V> subSet(V v, V v2) {
            rM();
            return new m(getKey(), rW().subSet(v, v2), rQ() == null ? this : rQ());
        }

        public SortedSet<V> tailSet(V v) {
            rM();
            return new m(getKey(), rW().tailSet(v), rQ() == null ? this : rQ());
        }
    }

    private class c extends b<K, Collection<V>> {
        c(Map<K, Collection<V>> map) {
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = rG().entrySet().iterator();
            return new Iterator<K>() {
                Entry<K, Collection<V>> PB;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.PB = (Entry) it.next();
                    return this.PB.getKey();
                }

                public void remove() {
                    g.ac(this.PB != null);
                    Collection collection = (Collection) this.PB.getValue();
                    it.remove();
                    AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - collection.size();
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) rG().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.this.Ps = AbstractMapBasedMultimap.this.Ps - size;
            } else {
                size = 0;
            }
            if (size > 0) {
                return true;
            }
            return false;
        }

        public void clear() {
            Iterators.p(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return rG().keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || rG().keySet().equals(obj);
        }

        public int hashCode() {
            return rG().keySet().hashCode();
        }
    }

    private class f extends j implements RandomAccess {
        f(K k, List<V> list, i iVar) {
            super(k, list, iVar);
        }
    }

    private class g extends a implements SortedMap<K, Collection<V>> {
        SortedSet<K> PI;

        g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> rL() {
            return (SortedMap) this.Pu;
        }

        public Comparator<? super K> comparator() {
            return rL().comparator();
        }

        public K firstKey() {
            return rL().firstKey();
        }

        public K lastKey() {
            return rL().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(rL().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(rL().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(rL().tailMap(k));
        }

        /* renamed from: rK */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.PI;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = rB();
            this.PI = sortedSet;
            return sortedSet;
        }

        /* renamed from: rJ */
        SortedSet<K> rB() {
            return new h(rL());
        }
    }

    class k extends m implements NavigableSet<V> {
        k(K k, NavigableSet<V> navigableSet, i iVar) {
            super(k, navigableSet, iVar);
        }

        /* renamed from: rV */
        NavigableSet<V> rW() {
            return (NavigableSet) super.rW();
        }

        public V lower(V v) {
            return rW().lower(v);
        }

        public V floor(V v) {
            return rW().floor(v);
        }

        public V ceiling(V v) {
            return rW().ceiling(v);
        }

        public V higher(V v) {
            return rW().higher(v);
        }

        public V pollFirst() {
            return Iterators.o(iterator());
        }

        public V pollLast() {
            return Iterators.o(descendingIterator());
        }

        private NavigableSet<V> a(NavigableSet<V> navigableSet) {
            return new k(this.key, navigableSet, rQ() == null ? this : rQ());
        }

        public NavigableSet<V> descendingSet() {
            return a(rW().descendingSet());
        }

        public Iterator<V> descendingIterator() {
            return new a(rW().descendingIterator());
        }

        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return a(rW().subSet(v, z, v2, z2));
        }

        public NavigableSet<V> headSet(V v, boolean z) {
            return a(rW().headSet(v, z));
        }

        public NavigableSet<V> tailSet(V v, boolean z) {
            return a(rW().tailSet(v, z));
        }
    }

    class d extends g implements NavigableMap<K, Collection<V>> {
        d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* renamed from: rH */
        NavigableMap<K, Collection<V>> rL() {
            return (NavigableMap) super.rL();
        }

        public Entry<K, Collection<V>> lowerEntry(K k) {
            Entry lowerEntry = rL().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return a(lowerEntry);
        }

        public K lowerKey(K k) {
            return rL().lowerKey(k);
        }

        public Entry<K, Collection<V>> floorEntry(K k) {
            Entry floorEntry = rL().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return a(floorEntry);
        }

        public K floorKey(K k) {
            return rL().floorKey(k);
        }

        public Entry<K, Collection<V>> ceilingEntry(K k) {
            Entry ceilingEntry = rL().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return a(ceilingEntry);
        }

        public K ceilingKey(K k) {
            return rL().ceilingKey(k);
        }

        public Entry<K, Collection<V>> higherEntry(K k) {
            Entry higherEntry = rL().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return a(higherEntry);
        }

        public K higherKey(K k) {
            return rL().higherKey(k);
        }

        public Entry<K, Collection<V>> firstEntry() {
            Entry firstEntry = rL().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return a(firstEntry);
        }

        public Entry<K, Collection<V>> lastEntry() {
            Entry lastEntry = rL().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return a(lastEntry);
        }

        public Entry<K, Collection<V>> pollFirstEntry() {
            return a(entrySet().iterator());
        }

        public Entry<K, Collection<V>> pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        Entry<K, Collection<V>> a(Iterator<Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Entry entry = (Entry) it.next();
            Collection ry = AbstractMapBasedMultimap.this.ry();
            ry.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.x(entry.getKey(), AbstractMapBasedMultimap.h(ry));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(rL().descendingMap());
        }

        /* renamed from: keySet */
        public NavigableSet<K> rK() {
            return (NavigableSet) super.keySet();
        }

        /* renamed from: rI */
        NavigableSet<K> rJ() {
            return new e(rL());
        }

        public NavigableSet<K> navigableKeySet() {
            return rK();
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new d(rL().subMap(k, z, k2, z2));
        }

        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new d(rL().headMap(k, z));
        }

        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new d(rL().tailMap(k, z));
        }
    }

    private class h extends c implements SortedSet<K> {
        h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> rL() {
            return (SortedMap) super.rG();
        }

        public Comparator<? super K> comparator() {
            return rL().comparator();
        }

        public K first() {
            return rL().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(rL().headMap(k));
        }

        public K last() {
            return rL().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(rL().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(rL().tailMap(k));
        }
    }

    class e extends h implements NavigableSet<K> {
        e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* renamed from: rH */
        NavigableMap<K, Collection<V>> rL() {
            return (NavigableMap) super.rL();
        }

        public K lower(K k) {
            return rL().lowerKey(k);
        }

        public K floor(K k) {
            return rL().floorKey(k);
        }

        public K ceiling(K k) {
            return rL().ceilingKey(k);
        }

        public K higher(K k) {
            return rL().higherKey(k);
        }

        public K pollFirst() {
            return Iterators.o(iterator());
        }

        public K pollLast() {
            return Iterators.o(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new e(rL().descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return new e(rL().headMap(k, z));
        }

        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new e(rL().subMap(k, z, k2, z2));
        }

        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return new e(rL().tailMap(k, z));
        }
    }

    abstract Collection<V> ry();

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.i.checkArgument(map.isEmpty());
        this.map = map;
    }

    final void m(Map<K, Collection<V>> map) {
        this.map = map;
        this.Ps = 0;
        for (Collection collection : map.values()) {
            com.google.common.base.i.checkArgument(collection.isEmpty() ^ 1);
            this.Ps += collection.size();
        }
    }

    Collection<V> rz() {
        return h(ry());
    }

    Collection<V> T(K k) {
        return ry();
    }

    Map<K, Collection<V>> rA() {
        return this.map;
    }

    public int size() {
        return this.Ps;
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean j(K k, V v) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = T(k);
            if (collection.add(v)) {
                this.Ps++;
                this.map.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.Ps++;
            return true;
        }
    }

    public Collection<V> S(Object obj) {
        Collection collection = (Collection) this.map.remove(obj);
        if (collection == null) {
            return rz();
        }
        Collection ry = ry();
        ry.addAll(collection);
        this.Ps -= collection.size();
        collection.clear();
        return h(ry);
    }

    static <E> Collection<E> h(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public void clear() {
        for (Collection clear : this.map.values()) {
            clear.clear();
        }
        this.map.clear();
        this.Ps = 0;
    }

    public Collection<V> R(K k) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = T(k);
        }
        return a((Object) k, collection);
    }

    Collection<V> a(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new k(k, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new m(k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new l(k, (Set) collection);
        }
        if (collection instanceof List) {
            return a(k, (List) collection, null);
        }
        return new i(k, collection, null);
    }

    private List<V> a(K k, List<V> list, i iVar) {
        return list instanceof RandomAccess ? new f(k, list, iVar) : new j(k, list, iVar);
    }

    private static <E> Iterator<E> i(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    Set<K> rB() {
        if (this.map instanceof NavigableMap) {
            return new e((NavigableMap) this.map);
        }
        if (this.map instanceof SortedMap) {
            return new h((SortedMap) this.map);
        }
        return new c(this.map);
    }

    private void U(Object obj) {
        Collection collection = (Collection) Maps.c(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.Ps -= size;
        }
    }

    public Collection<Entry<K, V>> rC() {
        return super.rC();
    }

    Iterator<Entry<K, V>> rD() {
        return new b<Entry<K, V>>() {
            /* renamed from: k */
            Entry<K, V> l(K k, V v) {
                return Maps.x(k, v);
            }
        };
    }

    Map<K, Collection<V>> rE() {
        if (this.map instanceof NavigableMap) {
            return new d((NavigableMap) this.map);
        }
        if (this.map instanceof SortedMap) {
            return new g((SortedMap) this.map);
        }
        return new a(this.map);
    }
}
