package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractSequentialIterator */
public abstract class f<T> extends aj<T> {
    private T Qs;

    protected abstract T O(T t);

    protected f(T t) {
        this.Qs = t;
    }

    public final boolean hasNext() {
        return this.Qs != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.Qs;
                return t;
            } finally {
                this.Qs = O(this.Qs);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
