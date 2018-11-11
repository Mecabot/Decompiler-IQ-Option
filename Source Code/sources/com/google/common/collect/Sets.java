package com.google.common.collect;

import com.google.common.base.i;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public final class Sets {

    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) i.checkNotNull(collection));
        }
    }

    static final class UnmodifiableNavigableSet<E> extends q<E> implements Serializable, NavigableSet<E> {
        private static final long serialVersionUID = 0;
        private transient UnmodifiableNavigableSet<E> Tn;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) i.checkNotNull(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        /* renamed from: sF */
        protected SortedSet<E> su() {
            return this.unmodifiableDelegate;
        }

        public E lower(E e) {
            return this.delegate.lower(e);
        }

        public E floor(E e) {
            return this.delegate.floor(e);
        }

        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        public E higher(E e) {
            return this.delegate.higher(e);
        }

        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> descendingSet() {
            NavigableSet<E> navigableSet = this.Tn;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableSet unmodifiableNavigableSet = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.Tn = unmodifiableNavigableSet;
            unmodifiableNavigableSet.Tn = this;
            return unmodifiableNavigableSet;
        }

        public Iterator<E> descendingIterator() {
            return Iterators.i(this.delegate.descendingIterator());
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(e, z, e2, z2));
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(e, z));
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(e, z));
        }
    }

    public static <E> HashSet<E> uI() {
        return new HashSet();
    }

    public static <E> HashSet<E> bu(int i) {
        return new HashSet(Maps.bg(i));
    }

    public static <E> HashSet<E> A(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet(h.b(iterable));
        }
        return w(iterable.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> it) {
        Collection uI = uI();
        Iterators.a(uI, (Iterator) it);
        return uI;
    }

    public static <E> Set<E> uJ() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> TreeSet<E> f(Comparator<? super E> comparator) {
        return new TreeSet((Comparator) i.checkNotNull(comparator));
    }

    static int d(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            i = ((i + (next != null ? next.hashCode() : 0)) ^ -1) ^ -1;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A:{RETURN, Splitter: B:6:0x000b, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException)} */
    /* JADX WARNING: Missing block: B:13:0x001e, code:
            return false;
     */
    static boolean a(java.util.Set<?> r4, java.lang.Object r5) {
        /*
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        if (r1 != r3) goto L_0x001c;
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001e, NullPointerException -> 0x001e }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
    L_0x001e:
        return r2;
    L_0x001f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.a(java.util.Set, java.lang.Object):boolean");
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableSortedSet) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        Collection collection2;
        i.checkNotNull(collection2);
        if (collection2 instanceof w) {
            collection2 = ((w) collection2).se();
        }
        if (!(collection2 instanceof Set) || collection2.size() <= set.size()) {
            return a((Set) set, collection2.iterator());
        }
        return Iterators.a(set.iterator(), collection2);
    }
}
