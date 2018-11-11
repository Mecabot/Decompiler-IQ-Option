package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.i;
import com.google.common.base.j;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Iterators {

    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            g.ac(false);
        }
    }

    private static class b<T> implements Iterator<T> {
        private Iterator<? extends T> RB;
        private Iterator<? extends T> RC = Iterators.tI();
        private Iterator<? extends Iterator<? extends T>> RD;
        private Deque<Iterator<? extends Iterator<? extends T>>> RF;

        b(Iterator<? extends Iterator<? extends T>> it) {
            this.RD = (Iterator) i.checkNotNull(it);
        }

        private Iterator<? extends Iterator<? extends T>> tL() {
            while (true) {
                if (this.RD != null && this.RD.hasNext()) {
                    return this.RD;
                }
                if (this.RF != null && !this.RF.isEmpty()) {
                    this.RD = (Iterator) this.RF.removeFirst();
                }
            }
            return null;
        }

        public boolean hasNext() {
            while (!((Iterator) i.checkNotNull(this.RC)).hasNext()) {
                this.RD = tL();
                if (this.RD == null) {
                    return false;
                }
                this.RC = (Iterator) this.RD.next();
                if (this.RC instanceof b) {
                    b bVar = (b) this.RC;
                    this.RC = bVar.RC;
                    if (this.RF == null) {
                        this.RF = new ArrayDeque();
                    }
                    this.RF.addFirst(this.RD);
                    if (bVar.RF != null) {
                        while (!bVar.RF.isEmpty()) {
                            this.RF.addFirst(bVar.RF.removeLast());
                        }
                    }
                    this.RD = bVar.RD;
                }
            }
            return true;
        }

        public T next() {
            if (hasNext()) {
                this.RB = this.RC;
                return this.RC.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            g.ac(this.RB != null);
            this.RB.remove();
            this.RB = null;
        }
    }

    private static final class a<T> extends a<T> {
        static final ak<Object> RA = new a(new Object[0], 0, 0, 0);
        private final T[] array;
        private final int offset;

        a(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.array = tArr;
            this.offset = i;
        }

        protected T get(int i) {
            return this.array[this.offset + i];
        }
    }

    static <T> aj<T> tI() {
        return tJ();
    }

    static <T> ak<T> tJ() {
        return a.RA;
    }

    static <T> Iterator<T> tK() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> aj<T> i(final Iterator<? extends T> it) {
        i.checkNotNull(it);
        if (it instanceof aj) {
            return (aj) it;
        }
        return new aj<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static int j(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.I(j);
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        i.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean b(Iterator<?> it, Collection<?> collection) {
        i.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!f.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return it2.hasNext() ^ 1;
    }

    public static String k(Iterator<?> it) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            obj = null;
            stringBuilder.append(it.next());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static <T> T l(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <");
        stringBuilder.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(", ");
            stringBuilder.append(it.next());
        }
        if (it.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        i.checkNotNull(collection);
        i.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> Iterator<T> m(Iterator<? extends Iterator<? extends T>> it) {
        return new b(it);
    }

    public static <T> aj<T> a(final Iterator<T> it, final j<? super T> jVar) {
        i.checkNotNull(it);
        i.checkNotNull(jVar);
        return new AbstractIterator<T>() {
            protected T pr() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (jVar.apply(next)) {
                        return next;
                    }
                }
                return ps();
            }
        };
    }

    public static <T> boolean b(Iterator<T> it, j<? super T> jVar) {
        return d(it, jVar) != -1;
    }

    public static <T> Optional<T> c(Iterator<T> it, j<? super T> jVar) {
        i.checkNotNull(it);
        i.checkNotNull(jVar);
        while (it.hasNext()) {
            Object next = it.next();
            if (jVar.apply(next)) {
                return Optional.E(next);
            }
        }
        return Optional.pN();
    }

    public static <T> int d(Iterator<T> it, j<? super T> jVar) {
        i.checkNotNull(jVar, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (jVar.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, final d<? super F, ? extends T> dVar) {
        i.checkNotNull(dVar);
        return new ah<F, T>(it) {
            T ax(F f) {
                return dVar.apply(f);
            }
        };
    }

    public static <T> T a(Iterator<T> it, int i) {
        aW(i);
        int b = b((Iterator) it, i);
        if (it.hasNext()) {
            return it.next();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("position (");
        stringBuilder.append(i);
        stringBuilder.append(") must be less than the number of elements that remained (");
        stringBuilder.append(b);
        stringBuilder.append(")");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    static void aW(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("position (");
            stringBuilder.append(i);
            stringBuilder.append(") must not be negative");
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
    }

    public static <T> T a(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T n(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static int b(Iterator<?> it, int i) {
        i.checkNotNull(it);
        int i2 = 0;
        i.checkArgument(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static <T> Iterator<T> c(final Iterator<T> it, final int i) {
        i.checkNotNull(it);
        i.checkArgument(i >= 0, "limit is negative");
        return new Iterator<T>() {
            private int count;

            public boolean hasNext() {
                return this.count < i && it.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    this.count++;
                    return it.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                it.remove();
            }
        };
    }

    static <T> T o(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    static void p(Iterator<?> it) {
        i.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    static <T> ak<T> a(T[] tArr, int i, int i2, int i3) {
        i.checkArgument(i2 >= 0);
        i.g(i, i + i2, tArr.length);
        i.t(i3, i2);
        if (i2 == 0) {
            return tJ();
        }
        return new a(tArr, i, i2, i3);
    }

    public static <T> aj<T> aw(final T t) {
        return new aj<T>() {
            boolean done;

            public boolean hasNext() {
                return this.done ^ 1;
            }

            public T next() {
                if (this.done) {
                    throw new NoSuchElementException();
                }
                this.done = true;
                return t;
            }
        };
    }

    static <T> ListIterator<T> q(Iterator<T> it) {
        return (ListIterator) it;
    }
}
