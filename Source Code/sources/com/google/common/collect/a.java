package com.google.common.collect;

import com.google.common.base.i;
import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator */
abstract class a<E> extends ak<E> {
    private int position;
    private final int size;

    protected abstract E get(int i);

    protected a(int i) {
        this(i, 0);
    }

    protected a(int i, int i2) {
        i.t(i2, i);
        this.size = i;
        this.position = i2;
    }

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.position;
            this.position = i + 1;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.position - 1;
            this.position = i;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }
}
