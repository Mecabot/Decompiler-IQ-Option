package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Multiset */
public interface w<E> extends Collection<E> {

    /* compiled from: Multiset */
    public interface a<E> {
        int getCount();

        E getElement();
    }

    boolean a(E e, int i, int i2);

    boolean add(E e);

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    int d(E e, int i);

    int e(Object obj, int i);

    Set<a<E>> entrySet();

    int f(E e, int i);

    Iterator<E> iterator();

    boolean remove(Object obj);

    Set<E> se();

    int size();

    String toString();
}
