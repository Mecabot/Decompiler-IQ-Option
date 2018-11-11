package com.google.common.collect;

import com.google.common.base.i;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] QJ = new Object[0];

    public static abstract class b<E> {
        public abstract b<E> ae(E e);

        static int u(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            i = (i + (i >> 1)) + 1;
            if (i < i2) {
                i = Integer.highestOneBit(i2 - 1) << 1;
            }
            return i < 0 ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i;
        }

        b() {
        }

        public b<E> e(E... eArr) {
            for (Object ae : eArr) {
                ae(ae);
            }
            return this;
        }

        public b<E> f(Iterable<? extends E> iterable) {
            for (Object ae : iterable) {
                ae(ae);
            }
            return this;
        }

        public b<E> b(Iterator<? extends E> it) {
            while (it.hasNext()) {
                ae(it.next());
            }
            return this;
        }
    }

    static abstract class a<E> extends b<E> {
        Object[] QK;
        boolean QL;
        int size = 0;

        a(int i) {
            g.b(i, "initialCapacity");
            this.QK = new Object[i];
        }

        private void aP(int i) {
            if (this.QK.length < i) {
                this.QK = Arrays.copyOf(this.QK, b.u(this.QK.length, i));
                this.QL = false;
            } else if (this.QL) {
                this.QK = (Object[]) this.QK.clone();
                this.QL = false;
            }
        }

        /* renamed from: ad */
        public a<E> ae(E e) {
            i.checkNotNull(e);
            aP(this.size + 1);
            Object[] objArr = this.QK;
            int i = this.size;
            this.size = i + 1;
            objArr[i] = e;
            return this;
        }

        public b<E> e(E... eArr) {
            x.o(eArr);
            aP(this.size + eArr.length);
            System.arraycopy(eArr, 0, this.QK, this.size, eArr.length);
            this.size += eArr.length;
            return this;
        }

        public b<E> f(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                aP(this.size + ((Collection) iterable).size());
            }
            super.f(iterable);
            return this;
        }
    }

    public abstract boolean contains(Object obj);

    /* renamed from: sI */
    public abstract aj<E> iterator();

    abstract boolean sK();

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return QJ;
        }
        Object[] objArr = new Object[size];
        a(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        i.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = x.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> sJ() {
        return isEmpty() ? ImmutableList.sL() : ImmutableList.h(toArray());
    }

    int a(Object[] objArr, int i) {
        Iterator sI = iterator();
        while (sI.hasNext()) {
            int i2 = i + 1;
            objArr[i] = sI.next();
            i = i2;
        }
        return i;
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
