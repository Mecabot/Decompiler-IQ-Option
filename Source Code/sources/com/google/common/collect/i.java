package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.d;
import com.google.common.base.j;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: FluentIterable */
public abstract class i<E> implements Iterable<E> {
    private final Optional<Iterable<E>> QE;

    protected i() {
        this.QE = Optional.pN();
    }

    i(Iterable<E> iterable) {
        Object iterable2;
        com.google.common.base.i.checkNotNull(iterable2);
        if (this == iterable2) {
            iterable2 = null;
        }
        this.QE = Optional.F(iterable2);
    }

    private Iterable<E> sy() {
        return (Iterable) this.QE.w(this);
    }

    public static <E> i<E> c(final Iterable<E> iterable) {
        return iterable instanceof i ? (i) iterable : new i<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <E> i<E> d(E[] eArr) {
        return c(Arrays.asList(eArr));
    }

    public static <T> i<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return a(iterable, iterable2);
    }

    private static <T> i<T> a(final Iterable<? extends T>... iterableArr) {
        for (Object checkNotNull : iterableArr) {
            com.google.common.base.i.checkNotNull(checkNotNull);
        }
        return new i<T>() {
            public Iterator<T> iterator() {
                return Iterators.m(new a<Iterator<? extends T>>(iterableArr.length) {
                    /* renamed from: aN */
                    public Iterator<? extends T> get(int i) {
                        return iterableArr[i].iterator();
                    }
                });
            }
        };
    }

    public static <T> i<T> d(final Iterable<? extends Iterable<? extends T>> iterable) {
        com.google.common.base.i.checkNotNull(iterable);
        return new i<T>() {
            public Iterator<T> iterator() {
                return Iterators.m(Iterators.a(iterable.iterator(), s.tH()));
            }
        };
    }

    public String toString() {
        return s.q(sy());
    }

    public final int size() {
        return s.p(sy());
    }

    public final i<E> e(Iterable<? extends E> iterable) {
        return a(sy(), iterable);
    }

    public final i<E> c(j<? super E> jVar) {
        return c(s.a(sy(), (j) jVar));
    }

    public final boolean d(j<? super E> jVar) {
        return s.b(sy(), (j) jVar);
    }

    public final Optional<E> e(j<? super E> jVar) {
        return s.c(sy(), (j) jVar);
    }

    public final <T> i<T> b(d<? super E, T> dVar) {
        return c(s.a(sy(), (d) dVar));
    }

    public <T> i<T> c(d<? super E, ? extends Iterable<? extends T>> dVar) {
        return d(b(dVar));
    }

    public final Optional<E> sz() {
        Iterator it = sy().iterator();
        return it.hasNext() ? Optional.E(it.next()) : Optional.pN();
    }

    public final i<E> aM(int i) {
        return c(s.b(sy(), i));
    }

    public final ImmutableList<E> sA() {
        return ImmutableList.g(sy());
    }

    public final ImmutableList<E> a(Comparator<? super E> comparator) {
        return Ordering.from((Comparator) comparator).immutableSortedCopy(sy());
    }

    public final ImmutableSet<E> sB() {
        return ImmutableSet.l(sy());
    }

    public final E[] l(Class<E> cls) {
        return s.a(sy(), (Class) cls);
    }
}
