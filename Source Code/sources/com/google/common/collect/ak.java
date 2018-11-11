package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: UnmodifiableListIterator */
public abstract class ak<E> extends aj<E> implements ListIterator<E> {
    protected ak() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
