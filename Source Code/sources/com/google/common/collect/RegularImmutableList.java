package com.google.common.collect;

import com.google.common.base.i;

class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> Ta = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    boolean sK() {
        return false;
    }

    RegularImmutableList(Object[] objArr, int i) {
        this.array = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.array, 0, objArr, i, this.size);
        return i + this.size;
    }

    public E get(int i) {
        i.s(i, this.size);
        return this.array[i];
    }

    /* renamed from: aQ */
    public ak<E> listIterator(int i) {
        return Iterators.a(this.array, 0, this.size, i);
    }
}
