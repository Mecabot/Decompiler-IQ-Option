package com.google.common.collect;

import com.google.common.base.i;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements ad<E>, NavigableSet<E> {
    transient ImmutableSortedSet<E> Ro;
    final transient Comparator<? super E> comparator;

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        Object readResolve() {
            return new a(this.comparator).l(this.elements).tt();
        }
    }

    public static final class a<E> extends com.google.common.collect.ImmutableSet.a<E> {
        private final Comparator<? super E> comparator;

        public a(Comparator<? super E> comparator) {
            this.comparator = (Comparator) i.checkNotNull(comparator);
        }

        /* renamed from: av */
        public a<E> an(E e) {
            super.ae(e);
            return this;
        }

        /* renamed from: m */
        public a<E> l(E... eArr) {
            super.e(eArr);
            return this;
        }

        /* renamed from: o */
        public a<E> m(Iterable<? extends E> iterable) {
            super.f(iterable);
            return this;
        }

        /* renamed from: h */
        public a<E> g(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }

        /* renamed from: tG */
        public ImmutableSortedSet<E> tt() {
            ImmutableSortedSet<E> a = ImmutableSortedSet.a(this.comparator, this.size, this.QK);
            this.size = a.size();
            this.QL = true;
            return a;
        }
    }

    abstract ImmutableSortedSet<E> c(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> e(E e, boolean z);

    abstract ImmutableSortedSet<E> f(E e, boolean z);

    abstract int indexOf(Object obj);

    /* renamed from: sI */
    public abstract aj<E> iterator();

    abstract ImmutableSortedSet<E> tE();

    /* renamed from: tF */
    public abstract aj<E> descendingIterator();

    static <E> RegularImmutableSortedSet<E> e(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedSet.Tk;
        }
        return new RegularImmutableSortedSet(ImmutableList.sL(), comparator);
    }

    static <E> ImmutableSortedSet<E> a(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return e(comparator);
        }
        Object[] eArr2;
        x.d(eArr2, i);
        Arrays.sort(eArr2, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            Object obj = eArr2[i3];
            if (comparator.compare(obj, eArr2[i2 - 1]) != 0) {
                int i4 = i2 + 1;
                eArr2[i2] = obj;
                i2 = i4;
            }
        }
        Arrays.fill(eArr2, i2, i, null);
        if (i2 < eArr2.length / 2) {
            eArr2 = Arrays.copyOf(eArr2, i2);
        }
        return new RegularImmutableSortedSet(ImmutableList.b(eArr2, i2), comparator);
    }

    public static <E extends Comparable<?>> a<E> tC() {
        return new a(Ordering.natural());
    }

    int v(Object obj, Object obj2) {
        return c(this.comparator, obj, obj2);
    }

    static int c(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    /* renamed from: at */
    public ImmutableSortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    /* renamed from: c */
    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return e(i.checkNotNull(e), z);
    }

    /* renamed from: w */
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    /* renamed from: b */
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        i.checkNotNull(e);
        i.checkNotNull(e2);
        i.checkArgument(this.comparator.compare(e, e2) <= 0);
        return c(e, z, e2, z2);
    }

    /* renamed from: au */
    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }

    /* renamed from: d */
    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return f(i.checkNotNull(e), z);
    }

    public E lower(E e) {
        return Iterators.a(headSet(e, false).descendingIterator(), null);
    }

    public E floor(E e) {
        return Iterators.a(headSet(e, true).descendingIterator(), null);
    }

    public E ceiling(E e) {
        return s.a(tailSet(e, true), null);
    }

    public E higher(E e) {
        return s.a(tailSet(e, false), null);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return descendingIterator().next();
    }

    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: tD */
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.Ro;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = tE();
        this.Ro = immutableSortedSet;
        immutableSortedSet.Ro = this;
        return immutableSortedSet;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
