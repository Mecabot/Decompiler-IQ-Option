package com.google.common.collect;

import com.google.common.base.i;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

final class Synchronized {

    static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, Object obj2) {
            this.delegate = i.checkNotNull(obj);
            if (obj2 == null) {
                obj2 = this;
            }
            this.mutex = obj2;
        }

        Object qB() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        /* renamed from: su */
        Collection<E> qB() {
            return (Collection) super.qB();
        }

        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = qB().add(e);
            }
            return add;
        }

        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = qB().addAll(collection);
            }
            return addAll;
        }

        public void clear() {
            synchronized (this.mutex) {
                qB().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = qB().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = qB().containsAll(collection);
            }
            return containsAll;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = qB().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return qB().iterator();
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = qB().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = qB().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = qB().retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = qB().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] toArray;
            synchronized (this.mutex) {
                toArray = qB().toArray();
            }
            return toArray;
        }

        public <T> T[] toArray(T[] tArr) {
            synchronized (this.mutex) {
                tArr = qB().toArray(tArr);
            }
            return tArr;
        }
    }

    private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<K> Os;
        transient Collection<V> Ot;
        transient Set<Entry<K, V>> Ou;

        SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        /* renamed from: sD */
        Map<K, V> qB() {
            return (Map) super.qB();
        }

        public void clear() {
            synchronized (this.mutex) {
                qB().clear();
            }
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = qB().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = qB().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.Ou == null) {
                    this.Ou = Synchronized.b(qB().entrySet(), this.mutex);
                }
                set = this.Ou;
            }
            return set;
        }

        public V get(Object obj) {
            V v;
            synchronized (this.mutex) {
                v = qB().get(obj);
            }
            return v;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = qB().isEmpty();
            }
            return isEmpty;
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.Os == null) {
                    this.Os = Synchronized.b(qB().keySet(), this.mutex);
                }
                set = this.Os;
            }
            return set;
        }

        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = qB().put(k, v);
            }
            return put;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                qB().putAll(map);
            }
        }

        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = qB().remove(obj);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = qB().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.Ot == null) {
                    this.Ot = Synchronized.e(qB().values(), this.mutex);
                }
                collection = this.Ot;
            }
            return collection;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean equals;
            synchronized (this.mutex) {
                equals = qB().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = qB().hashCode();
            }
            return hashCode;
        }
    }

    private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements v<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<K> Os;
        transient Collection<Entry<K, V>> Qg;
        transient Map<K, Collection<V>> Qi;

        /* renamed from: uM */
        v<K, V> qB() {
            return (v) super.qB();
        }

        SynchronizedMultimap(v<K, V> vVar, Object obj) {
            super(vVar, obj);
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = qB().size();
            }
            return size;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = qB().isEmpty();
            }
            return isEmpty;
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = qB().containsKey(obj);
            }
            return containsKey;
        }

        public boolean m(Object obj, Object obj2) {
            boolean m;
            synchronized (this.mutex) {
                m = qB().m(obj, obj2);
            }
            return m;
        }

        public Collection<V> R(K k) {
            Collection<V> g;
            synchronized (this.mutex) {
                g = Synchronized.f(qB().R(k), this.mutex);
            }
            return g;
        }

        public boolean j(K k, V v) {
            boolean j;
            synchronized (this.mutex) {
                j = qB().j(k, v);
            }
            return j;
        }

        public boolean a(K k, Iterable<? extends V> iterable) {
            boolean a;
            synchronized (this.mutex) {
                a = qB().a(k, iterable);
            }
            return a;
        }

        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = qB().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> S(Object obj) {
            Collection<V> S;
            synchronized (this.mutex) {
                S = qB().S(obj);
            }
            return S;
        }

        public void clear() {
            synchronized (this.mutex) {
                qB().clear();
            }
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.Os == null) {
                    this.Os = Synchronized.c(qB().keySet(), this.mutex);
                }
                set = this.Os;
            }
            return set;
        }

        public Collection<Entry<K, V>> rC() {
            Collection<Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.Qg == null) {
                    this.Qg = Synchronized.f(qB().rC(), this.mutex);
                }
                collection = this.Qg;
            }
            return collection;
        }

        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.Qi == null) {
                    this.Qi = new SynchronizedAsMap(qB().asMap(), this.mutex);
                }
                map = this.Qi;
            }
            return map;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean equals;
            synchronized (this.mutex) {
                equals = qB().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = qB().hashCode();
            }
            return hashCode;
        }
    }

    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        transient Set<Entry<K, Collection<V>>> To;
        transient Collection<Collection<V>> Tp;

        SynchronizedAsMap(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
        }

        /* renamed from: R */
        public Collection<V> get(Object obj) {
            Collection<V> collection;
            synchronized (this.mutex) {
                Collection collection2 = (Collection) super.get(obj);
                if (collection2 == null) {
                    collection = null;
                } else {
                    collection = Synchronized.f(collection2, this.mutex);
                }
            }
            return collection;
        }

        public Set<Entry<K, Collection<V>>> entrySet() {
            Set<Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.To == null) {
                    this.To = new SynchronizedAsMapEntries(qB().entrySet(), this.mutex);
                }
                set = this.To;
            }
            return set;
        }

        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.Tp == null) {
                    this.Tp = new SynchronizedAsMapValues(qB().values(), this.mutex);
                }
                collection = this.Tp;
            }
            return collection;
        }

        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }
    }

    private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj);
        }

        public Iterator<Collection<V>> iterator() {
            return new ah<Collection<V>, Collection<V>>(super.iterator()) {
                /* renamed from: r */
                Collection<V> ax(Collection<V> collection) {
                    return Synchronized.f((Collection) collection, SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, Object obj) {
            super(list, obj);
        }

        /* renamed from: uL */
        List<E> su() {
            return (List) super.qB();
        }

        public void add(int i, E e) {
            synchronized (this.mutex) {
                su().add(i, e);
            }
        }

        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = su().addAll(i, collection);
            }
            return addAll;
        }

        public E get(int i) {
            E e;
            synchronized (this.mutex) {
                e = su().get(i);
            }
            return e;
        }

        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = su().indexOf(obj);
            }
            return indexOf;
        }

        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = su().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        public ListIterator<E> listIterator() {
            return su().listIterator();
        }

        public ListIterator<E> listIterator(int i) {
            return su().listIterator(i);
        }

        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = su().remove(i);
            }
            return remove;
        }

        public E set(int i, E e) {
            E e2;
            synchronized (this.mutex) {
                e2 = su().set(i, e);
            }
            return e2;
        }

        public List<E> subList(int i, int i2) {
            List<E> g;
            synchronized (this.mutex) {
                g = Synchronized.f(su().subList(i, i2), this.mutex);
            }
            return g;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean equals;
            synchronized (this.mutex) {
                equals = su().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = su().hashCode();
            }
            return hashCode;
        }
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        /* renamed from: st */
        Set<E> su() {
            return (Set) super.qB();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean equals;
            synchronized (this.mutex) {
                equals = su().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = su().hashCode();
            }
            return hashCode;
        }
    }

    private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements ac<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Entry<K, V>> Ou;

        SynchronizedSetMultimap(ac<K, V> acVar, Object obj) {
            super(acVar, obj);
        }

        /* renamed from: uN */
        ac<K, V> uM() {
            return (ac) super.qB();
        }

        /* renamed from: X */
        public Set<V> R(K k) {
            Set<V> b;
            synchronized (this.mutex) {
                b = Synchronized.b(uM().X(k), this.mutex);
            }
            return b;
        }

        /* renamed from: Y */
        public Set<V> S(Object obj) {
            Set<V> Y;
            synchronized (this.mutex) {
                Y = uM().Y(obj);
            }
            return Y;
        }

        /* renamed from: sl */
        public Set<Entry<K, V>> rC() {
            Set<Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.Ou == null) {
                    this.Ou = Synchronized.b(uM().sl(), this.mutex);
                }
                set = this.Ou;
            }
            return set;
        }
    }

    private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
        }

        public Iterator<Entry<K, Collection<V>>> iterator() {
            return new ah<Entry<K, Collection<V>>, Entry<K, Collection<V>>>(super.iterator()) {
                /* renamed from: g */
                Entry<K, Collection<V>> ax(final Entry<K, Collection<V>> entry) {
                    return new n<K, Collection<V>>() {
                        /* renamed from: sE */
                        protected Entry<K, Collection<V>> qB() {
                            return entry;
                        }

                        /* renamed from: uK */
                        public Collection<V> getValue() {
                            return Synchronized.f((Collection) entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        public Object[] toArray() {
            Object[] q;
            synchronized (this.mutex) {
                q = x.q(su());
            }
            return q;
        }

        public <T> T[] toArray(T[] tArr) {
            synchronized (this.mutex) {
                tArr = x.a(su(), (Object[]) tArr);
            }
            return tArr;
        }

        public boolean contains(Object obj) {
            boolean c;
            synchronized (this.mutex) {
                c = Maps.c(su(), obj);
            }
            return c;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean a;
            synchronized (this.mutex) {
                a = h.a(su(), (Collection) collection);
            }
            return a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean a;
            synchronized (this.mutex) {
                a = Sets.a(su(), obj);
            }
            return a;
        }

        public boolean remove(Object obj) {
            boolean d;
            synchronized (this.mutex) {
                d = Maps.d(su(), obj);
            }
            return d;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean a;
            synchronized (this.mutex) {
                a = Iterators.a(su().iterator(), (Collection) collection);
            }
            return a;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean b;
            synchronized (this.mutex) {
                b = Iterators.b(su().iterator(), (Collection) collection);
            }
            return b;
        }
    }

    private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
        }
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        /* renamed from: sF */
        SortedSet<E> su() {
            return (SortedSet) super.su();
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = su().comparator();
            }
            return comparator;
        }

        public SortedSet<E> subSet(E e, E e2) {
            SortedSet<E> b;
            synchronized (this.mutex) {
                b = Synchronized.a(su().subSet(e, e2), this.mutex);
            }
            return b;
        }

        public SortedSet<E> headSet(E e) {
            SortedSet<E> b;
            synchronized (this.mutex) {
                b = Synchronized.a(su().headSet(e), this.mutex);
            }
            return b;
        }

        public SortedSet<E> tailSet(E e) {
            SortedSet<E> b;
            synchronized (this.mutex) {
                b = Synchronized.a(su().tailSet(e), this.mutex);
            }
            return b;
        }

        public E first() {
            E first;
            synchronized (this.mutex) {
                first = su().first();
            }
            return first;
        }

        public E last() {
            E last;
            synchronized (this.mutex) {
                last = su().last();
            }
            return last;
        }
    }

    private static <E> Collection<E> e(Collection<E> collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    static <E> Set<E> b(Set<E> set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    private static <E> SortedSet<E> a(SortedSet<E> sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    private static <E> List<E> f(List<E> list, Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static <K, V> ac<K, V> a(ac<K, V> acVar, Object obj) {
        return ((acVar instanceof SynchronizedSetMultimap) || (acVar instanceof ImmutableSetMultimap)) ? acVar : new SynchronizedSetMultimap(acVar, obj);
    }

    private static <E> Collection<E> f(Collection<E> collection, Object obj) {
        if (collection instanceof SortedSet) {
            return a((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return b((Set) collection, obj);
        }
        if (collection instanceof List) {
            return f((List) collection, obj);
        }
        return e(collection, obj);
    }

    private static <E> Set<E> c(Set<E> set, Object obj) {
        if (set instanceof SortedSet) {
            return a((SortedSet) set, obj);
        }
        return b((Set) set, obj);
    }
}
