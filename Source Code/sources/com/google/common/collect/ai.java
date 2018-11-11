package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: TransformedListIterator */
abstract class ai<F, T> extends ah<F, T> implements ListIterator<T> {
    ai(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> uP() {
        return Iterators.q(this.Tv);
    }

    public final boolean hasPrevious() {
        return uP().hasPrevious();
    }

    public final T previous() {
        return ax(uP().previous());
    }

    public final int nextIndex() {
        return uP().nextIndex();
    }

    public final int previousIndex() {
        return uP().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
