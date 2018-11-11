package com.google.common.collect;

import com.google.common.base.i;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.f(this.elements);
        }
    }

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> QM;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.QM = immutableList;
        }

        private int aR(int i) {
            return (size() - 1) - i;
        }

        private int aS(int i) {
            return size() - i;
        }

        public ImmutableList<E> sN() {
            return this.QM;
        }

        public boolean contains(Object obj) {
            return this.QM.contains(obj);
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.QM.lastIndexOf(obj);
            return lastIndexOf >= 0 ? aR(lastIndexOf) : -1;
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.QM.indexOf(obj);
            return indexOf >= 0 ? aR(indexOf) : -1;
        }

        /* renamed from: v */
        public ImmutableList<E> subList(int i, int i2) {
            i.g(i, i2, size());
            return this.QM.subList(aS(i2), aS(i)).sN();
        }

        public E get(int i) {
            i.s(i, size());
            return this.QM.get(aR(i));
        }

        public int size() {
            return this.QM.size();
        }

        boolean sK() {
            return this.QM.sK();
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        boolean sK() {
            return true;
        }

        SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public int size() {
            return this.length;
        }

        public E get(int i) {
            i.s(i, this.length);
            return ImmutableList.this.get(i + this.offset);
        }

        /* renamed from: v */
        public ImmutableList<E> subList(int i, int i2) {
            i.g(i, i2, this.length);
            return ImmutableList.this.subList(i + this.offset, i2 + this.offset);
        }
    }

    public static final class a<E> extends a<E> {
        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        /* renamed from: ag */
        public a<E> ae(E e) {
            super.ae(e);
            return this;
        }

        /* renamed from: h */
        public a<E> f(Iterable<? extends E> iterable) {
            super.f(iterable);
            return this;
        }

        /* renamed from: i */
        public a<E> e(E... eArr) {
            super.e(eArr);
            return this;
        }

        /* renamed from: d */
        public a<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }

        public ImmutableList<E> sP() {
            this.QL = true;
            return ImmutableList.b(this.QK, this.size);
        }
    }

    public final ImmutableList<E> sJ() {
        return this;
    }

    public static <E> ImmutableList<E> sL() {
        return RegularImmutableList.Ta;
    }

    public static <E> ImmutableList<E> af(E e) {
        return g(e);
    }

    public static <E> ImmutableList<E> o(E e, E e2) {
        return g(e, e2);
    }

    public static <E> ImmutableList<E> a(E e, E e2, E e3) {
        return g(e, e2, e3);
    }

    public static <E> ImmutableList<E> g(Iterable<? extends E> iterable) {
        i.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return m((Collection) iterable);
        }
        return c(iterable.iterator());
    }

    public static <E> ImmutableList<E> m(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return g(collection.toArray());
        }
        ImmutableList<E> sJ = ((ImmutableCollection) collection).sJ();
        if (sJ.sK()) {
            sJ = h(sJ.toArray());
        }
        return sJ;
    }

    public static <E> ImmutableList<E> c(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return sL();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new a().ae(next).b(it).sP();
        }
        return af(next);
    }

    public static <E> ImmutableList<E> f(E[] eArr) {
        if (eArr.length == 0) {
            return sL();
        }
        return g((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        i.checkNotNull(comparator);
        Object[] s = s.s(iterable);
        x.o(s);
        Arrays.sort(s, comparator);
        return h(s);
    }

    private static <E> ImmutableList<E> g(Object... objArr) {
        return h(x.o(objArr));
    }

    static <E> ImmutableList<E> h(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> ImmutableList<E> b(Object[] objArr, int i) {
        if (i == 0) {
            return sL();
        }
        return new RegularImmutableList(objArr, i);
    }

    ImmutableList() {
    }

    /* renamed from: sI */
    public aj<E> iterator() {
        return listIterator();
    }

    /* renamed from: sM */
    public ak<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: aQ */
    public ak<E> listIterator(int i) {
        return new a<E>(size(), i) {
            protected E get(int i) {
                return ImmutableList.this.get(i);
            }
        };
    }

    public int indexOf(Object obj) {
        return obj == null ? -1 : Lists.b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        return obj == null ? -1 : Lists.d(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: v */
    public ImmutableList<E> subList(int i, int i2) {
        i.g(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return sL();
        }
        return w(i, i2);
    }

    ImmutableList<E> w(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> sN() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    public boolean equals(Object obj) {
        return Lists.a((List) this, obj);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> a<E> sO() {
        return new a();
    }
}
