package com.google.common.collect;

import com.google.common.base.i;
import java.util.Iterator;

/* compiled from: TransformedIterator */
abstract class ah<F, T> implements Iterator<T> {
    final Iterator<? extends F> Tv;

    abstract T ax(F f);

    ah(Iterator<? extends F> it) {
        this.Tv = (Iterator) i.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.Tv.hasNext();
    }

    public final T next() {
        return ax(this.Tv.next());
    }

    public final void remove() {
        this.Tv.remove();
    }
}
