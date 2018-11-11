package com.google.common.collect;

import com.google.common.base.i;
import java.io.Serializable;

final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering Su = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    private transient Ordering<Comparable> Sv;
    private transient Ordering<Comparable> Sw;

    public String toString() {
        return "Ordering.natural()";
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        i.checkNotNull(comparable);
        i.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = this.Sv;
        if (ordering != null) {
            return ordering;
        }
        ordering = super.nullsFirst();
        this.Sv = ordering;
        return ordering;
    }

    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = this.Sw;
        if (ordering != null) {
            return ordering;
        }
        ordering = super.nullsLast();
        this.Sw = ordering;
        return ordering;
    }

    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.Tm;
    }

    private Object readResolve() {
        return Su;
    }

    private NaturalOrdering() {
    }
}
