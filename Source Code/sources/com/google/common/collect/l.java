package com.google.common.collect;

import java.util.Iterator;

/* compiled from: ForwardingIterator */
public abstract class l<T> extends o implements Iterator<T> {
    /* renamed from: sw */
    protected abstract Iterator<T> qB();

    protected l() {
    }

    public boolean hasNext() {
        return qB().hasNext();
    }

    public T next() {
        return qB().next();
    }

    public void remove() {
        qB().remove();
    }
}
