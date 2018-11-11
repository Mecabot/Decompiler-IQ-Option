package com.google.common.collect;

import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.i;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class Lists {

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(E e, E[] eArr) {
            this.first = e;
            this.rest = (Object[]) i.checkNotNull(eArr);
        }

        public int size() {
            return com.google.common.c.b.F(this.rest.length, 1);
        }

        public E get(int i) {
            i.s(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final d<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, d<? super F, ? extends T> dVar) {
            this.fromList = (List) i.checkNotNull(list);
            this.function = (d) i.checkNotNull(dVar);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new ai<F, T>(this.fromList.listIterator(i)) {
                T ax(F f) {
                    return TransformingRandomAccessList.this.function.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final d<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, d<? super F, ? extends T> dVar) {
            this.fromList = (List) i.checkNotNull(list);
            this.function = (d) i.checkNotNull(dVar);
        }

        public void clear() {
            this.fromList.clear();
        }

        public int size() {
            return this.fromList.size();
        }

        public ListIterator<T> listIterator(int i) {
            return new ai<F, T>(this.fromList.listIterator(i)) {
                T ax(F f) {
                    return TransformingSequentialList.this.function.apply(f);
                }
            };
        }
    }

    private static class b<T> extends AbstractList<T> {
        private final List<T> RG;

        b(List<T> list) {
            this.RG = (List) i.checkNotNull(list);
        }

        List<T> tN() {
            return this.RG;
        }

        private int aR(int i) {
            int size = size();
            i.s(i, size);
            return (size - 1) - i;
        }

        private int aS(int i) {
            int size = size();
            i.t(i, size);
            return size - i;
        }

        public void add(int i, T t) {
            this.RG.add(aS(i), t);
        }

        public void clear() {
            this.RG.clear();
        }

        public T remove(int i) {
            return this.RG.remove(aR(i));
        }

        protected void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        public T set(int i, T t) {
            return this.RG.set(aR(i), t);
        }

        public T get(int i) {
            return this.RG.get(aR(i));
        }

        public int size() {
            return this.RG.size();
        }

        public List<T> subList(int i, int i2) {
            i.g(i, i2, size());
            return Lists.reverse(this.RG.subList(aS(i2), aS(i)));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            final ListIterator listIterator = this.RG.listIterator(aS(i));
            return new ListIterator<T>() {
                boolean RH;

                public void add(T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.RH = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.RH = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return b.this.aS(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.RH = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    g.ac(this.RH);
                    listIterator.remove();
                    this.RH = false;
                }

                public void set(T t) {
                    i.checkState(this.RH);
                    listIterator.set(t);
                }
            };
        }
    }

    private static class a<T> extends b<T> implements RandomAccess {
        a(List<T> list) {
            super(list);
        }
    }

    private Lists() {
    }

    public static <E> ArrayList<E> tM() {
        return new ArrayList();
    }

    @SafeVarargs
    public static <E> ArrayList<E> n(E... eArr) {
        i.checkNotNull(eArr);
        Object arrayList = new ArrayList(aX(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    static int aX(int i) {
        g.b(i, "arraySize");
        return Ints.I((((long) i) + 5) + ((long) (i / 10)));
    }

    public static <E> ArrayList<E> w(Iterable<? extends E> iterable) {
        i.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList(h.b(iterable));
        }
        return r(iterable.iterator());
    }

    public static <E> ArrayList<E> r(Iterator<? extends E> it) {
        Collection tM = tM();
        Iterators.a(tM, (Iterator) it);
        return tM;
    }

    public static <E> ArrayList<E> aY(int i) {
        g.b(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static <E> ArrayList<E> aZ(int i) {
        return new ArrayList(aX(i));
    }

    public static <E> List<E> a(E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    public static <F, T> List<T> a(List<F> list, d<? super F, ? extends T> dVar) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, dVar) : new TransformingSequentialList(list, dVar);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).sN();
        }
        if (list instanceof b) {
            return ((b) list).tN();
        }
        if (list instanceof RandomAccess) {
            return new a(list);
        }
        return new b(list);
    }

    static boolean a(List<?> list, Object obj) {
        if (obj == i.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!f.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return c(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (f.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int c(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(list.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (f.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (obj.equals(list.get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }
}
