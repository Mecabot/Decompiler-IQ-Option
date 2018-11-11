package com.google.common.collect;

import com.google.common.base.d;
import com.google.common.base.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object obj) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot compare value: ");
            stringBuilder.append(obj);
            super(stringBuilder.toString());
            this.value = obj;
        }
    }

    private static class b {
        static final Ordering<Object> SW = new a();
    }

    static class a extends Ordering<Object> {
        private final ConcurrentMap<Object, Integer> SU = z.b(new u()).tR();
        private final AtomicInteger xR = new AtomicInteger(0);

        public String toString() {
            return "Ordering.arbitrary()";
        }

        a() {
        }

        private Integer az(Object obj) {
            Integer num = (Integer) this.SU.get(obj);
            if (num != null) {
                return num;
            }
            num = Integer.valueOf(this.xR.getAndIncrement());
            Integer num2 = (Integer) this.SU.putIfAbsent(obj, num);
            return num2 != null ? num2 : num;
        }

        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            int i = -1;
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int identityHashCode = identityHashCode(obj);
            int identityHashCode2 = identityHashCode(obj2);
            if (identityHashCode != identityHashCode2) {
                if (identityHashCode >= identityHashCode2) {
                    i = 1;
                }
                return i;
            }
            int compareTo = az(obj).compareTo(az(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        int identityHashCode(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public abstract int compare(T t, T t2);

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.Su;
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) i.checkNotNull(ordering);
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering((List) list);
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.a((Object) t, (Object[]) tArr));
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.Qt;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.Tw;
    }

    public static Ordering<Object> arbitrary() {
        return b.SW;
    }

    protected Ordering() {
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <F> Ordering<F> onResultOf(d<F, ? extends T> dVar) {
        return new ByFunctionOrdering(dVar, this);
    }

    <T2 extends T> Ordering<Entry<T2, ?>> onKeys() {
        return onResultOf(Maps.uq());
    }

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) i.checkNotNull(comparator));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = min(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return min(iterable.iterator());
    }

    public <E extends T> E min(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        e = min(min(e, e2), e3);
        for (Object min : eArr) {
            e = min(e, min);
        }
        return e;
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = max(next, it.next());
        }
        return next;
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return max(iterable.iterator());
    }

    public <E extends T> E max(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        e = max(max(e, e2), e3);
        for (Object max : eArr) {
            e = max(e, max);
        }
        return e;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (((long) collection.size()) <= ((long) i) * 2) {
                Object[] toArray = collection.toArray();
                Arrays.sort(toArray, this);
                if (toArray.length > i) {
                    toArray = Arrays.copyOf(toArray, i);
                }
                return Collections.unmodifiableList(Arrays.asList(toArray));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i) {
        i.checkNotNull(it);
        g.b(i, "k");
        if (i == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i >= 1073741823) {
            List r = Lists.r(it);
            Collections.sort(r, this);
            if (r.size() > i) {
                r.subList(i, r.size()).clear();
            }
            r.trimToSize();
            return Collections.unmodifiableList(r);
        }
        ag a = ag.a(i, this);
        a.x(it);
        return a.uO();
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf((Iterable) iterable, i);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf((Iterator) it, i);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] s = s.s(iterable);
        Arrays.sort(s, this);
        return Lists.w(Arrays.asList(s));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.a((Comparator) this, (Iterable) iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }
}
