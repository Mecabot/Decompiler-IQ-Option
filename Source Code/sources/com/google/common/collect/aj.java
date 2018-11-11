package com.google.common.collect;

import java.util.Iterator;

/* compiled from: UnmodifiableIterator */
public abstract class aj<E> implements Iterator<E> {
    protected aj() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
