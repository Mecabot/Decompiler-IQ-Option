package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: ForwardingSortedSet */
public abstract class q<E> extends p<E> implements SortedSet<E> {
    /* renamed from: sF */
    protected abstract SortedSet<E> su();

    protected q() {
    }

    public Comparator<? super E> comparator() {
        return su().comparator();
    }

    public E first() {
        return su().first();
    }

    public SortedSet<E> headSet(E e) {
        return su().headSet(e);
    }

    public E last() {
        return su().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return su().subSet(e, e2);
    }

    public SortedSet<E> tailSet(E e) {
        return su().tailSet(e);
    }
}
