package com.google.common.collect;

import com.google.common.base.i;
import java.io.Serializable;
import java.util.Iterator;

final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering Tm = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        i.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    /* renamed from: a */
    public <E extends Comparable> E min(E e, E e2) {
        return (Comparable) NaturalOrdering.Su.max(e, e2);
    }

    /* renamed from: a */
    public <E extends Comparable> E min(E e, E e2, E e3, E... eArr) {
        return (Comparable) NaturalOrdering.Su.max(e, e2, e3, eArr);
    }

    /* renamed from: u */
    public <E extends Comparable> E min(Iterator<E> it) {
        return (Comparable) NaturalOrdering.Su.max((Iterator) it);
    }

    /* renamed from: y */
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.Su.max((Iterable) iterable);
    }

    /* renamed from: b */
    public <E extends Comparable> E max(E e, E e2) {
        return (Comparable) NaturalOrdering.Su.min(e, e2);
    }

    /* renamed from: b */
    public <E extends Comparable> E max(E e, E e2, E e3, E... eArr) {
        return (Comparable) NaturalOrdering.Su.min(e, e2, e3, eArr);
    }

    /* renamed from: v */
    public <E extends Comparable> E max(Iterator<E> it) {
        return (Comparable) NaturalOrdering.Su.min((Iterator) it);
    }

    /* renamed from: z */
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.Su.min((Iterable) iterable);
    }

    private Object readResolve() {
        return Tm;
    }

    private ReverseNaturalOrdering() {
    }
}
