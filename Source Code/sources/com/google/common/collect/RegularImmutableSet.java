package com.google.common.collect;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> Ti = new RegularImmutableSet(new Object[0], 0, null, 0, 0);
    final transient Object[] Tj;
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;

    boolean sK() {
        return false;
    }

    boolean tb() {
        return true;
    }

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.elements = objArr;
        this.Tj = objArr2;
        this.mask = i2;
        this.hashCode = i;
        this.size = i3;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.Tj;
        if (obj == null || objArr == null) {
            return false;
        }
        int ac = r.ac(obj);
        while (true) {
            ac &= this.mask;
            Object obj2 = objArr[ac];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            ac++;
        }
    }

    public int size() {
        return this.size;
    }

    /* renamed from: sI */
    public aj<E> iterator() {
        return Iterators.a(this.elements, 0, this.size, 0);
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.elements, 0, objArr, i, this.size);
        return i + this.size;
    }

    ImmutableList<E> tr() {
        return ImmutableList.b(this.elements, this.size);
    }

    public int hashCode() {
        return this.hashCode;
    }
}
