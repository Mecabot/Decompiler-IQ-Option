package com.google.common.collect;

import com.google.common.base.i;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    private transient int cachedHashCode;
    final transient E element;

    boolean sK() {
        return false;
    }

    public int size() {
        return 1;
    }

    SingletonImmutableSet(E e) {
        this.element = i.checkNotNull(e);
    }

    SingletonImmutableSet(E e, int i) {
        this.element = e;
        this.cachedHashCode = i;
    }

    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    /* renamed from: sI */
    public aj<E> iterator() {
        return Iterators.aw(this.element);
    }

    ImmutableList<E> tr() {
        return ImmutableList.af(this.element);
    }

    int a(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        i = this.element.hashCode();
        this.cachedHashCode = i;
        return i;
    }

    boolean tb() {
        return this.cachedHashCode != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(this.element.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
