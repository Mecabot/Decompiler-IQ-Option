package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ConsPStack */
final class a<E> implements Iterable<E> {
    private static final a<Object> eXU = new a();
    final a<E> eXV;
    final E first;
    private final int size;

    /* compiled from: ConsPStack */
    private static class a<E> implements Iterator<E> {
        private a<E> eXW;

        public a(a<E> aVar) {
            this.eXW = aVar;
        }

        public boolean hasNext() {
            return this.eXW.size > 0;
        }

        public E next() {
            E e = this.eXW.first;
            this.eXW = this.eXW.eXV;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> a<E> bzJ() {
        return eXU;
    }

    private a() {
        this.size = 0;
        this.first = null;
        this.eXV = null;
    }

    private a(E e, a<E> aVar) {
        this.first = e;
        this.eXV = aVar;
        this.size = aVar.size + 1;
    }

    public E get(int i) {
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return md(i).next();
        } catch (NoSuchElementException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index: ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
    }

    public Iterator<E> iterator() {
        return md(0);
    }

    public int size() {
        return this.size;
    }

    private Iterator<E> md(int i) {
        return new a(mf(i));
    }

    public a<E> dn(E e) {
        return new a(e, this);
    }

    private a<E> do(Object obj) {
        if (this.size == 0) {
            return this;
        }
        if (this.first.equals(obj)) {
            return this.eXV;
        }
        a aVar = this.eXV.do(obj);
        if (aVar == this.eXV) {
            return this;
        }
        return new a(this.first, aVar);
    }

    public a<E> me(int i) {
        return do(get(i));
    }

    private a<E> mf(int i) {
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.eXV.mf(i - 1);
        }
    }
}
