package com.google.common.collect;

import com.google.common.base.i;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> Tk = new RegularImmutableSortedSet(ImmutableList.sL(), Ordering.natural());
    final transient ImmutableList<E> Tl;

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.Tl = immutableList;
    }

    /* renamed from: sI */
    public aj<E> iterator() {
        return this.Tl.iterator();
    }

    /* renamed from: tF */
    public aj<E> descendingIterator() {
        return this.Tl.sN().iterator();
    }

    public int size() {
        return this.Tl.size();
    }

    public boolean contains(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                if (aA(obj) >= 0) {
                    z = true;
                }
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057 A:{RETURN, Splitter: B:11:0x0034, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException)} */
    /* JADX WARNING: Missing block: B:26:0x0057, code:
            return false;
     */
    public boolean containsAll(java.util.Collection<?> r7) {
        /*
        r6 = this;
        r0 = r7 instanceof com.google.common.collect.w;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r7 = (com.google.common.collect.w) r7;
        r7 = r7.se();
    L_0x000a:
        r0 = r6.comparator();
        r0 = com.google.common.collect.ae.b(r0, r7);
        if (r0 == 0) goto L_0x0058;
    L_0x0014:
        r0 = r7.size();
        r1 = 1;
        if (r0 > r1) goto L_0x001c;
    L_0x001b:
        goto L_0x0058;
    L_0x001c:
        r0 = r6.iterator();
        r7 = r7.iterator();
        r2 = r0.hasNext();
        r3 = 0;
        if (r2 != 0) goto L_0x002c;
    L_0x002b:
        return r3;
    L_0x002c:
        r2 = r7.next();
        r4 = r0.next();
    L_0x0034:
        r5 = r6.v(r4, r2);	 Catch:{ NullPointerException -> 0x0057, NullPointerException -> 0x0057 }
        if (r5 >= 0) goto L_0x0046;
    L_0x003a:
        r4 = r0.hasNext();	 Catch:{ NullPointerException -> 0x0057, NullPointerException -> 0x0057 }
        if (r4 != 0) goto L_0x0041;
    L_0x0040:
        return r3;
    L_0x0041:
        r4 = r0.next();	 Catch:{ NullPointerException -> 0x0057, NullPointerException -> 0x0057 }
        goto L_0x0034;
    L_0x0046:
        if (r5 != 0) goto L_0x0054;
    L_0x0048:
        r2 = r7.hasNext();	 Catch:{ NullPointerException -> 0x0057, NullPointerException -> 0x0057 }
        if (r2 != 0) goto L_0x004f;
    L_0x004e:
        return r1;
    L_0x004f:
        r2 = r7.next();	 Catch:{ NullPointerException -> 0x0057, NullPointerException -> 0x0057 }
        goto L_0x0034;
    L_0x0054:
        if (r5 <= 0) goto L_0x0034;
    L_0x0056:
        return r3;
    L_0x0057:
        return r3;
    L_0x0058:
        r7 = super.containsAll(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableSortedSet.containsAll(java.util.Collection):boolean");
    }

    private int aA(Object obj) {
        return Collections.binarySearch(this.Tl, obj, uH());
    }

    boolean sK() {
        return this.Tl.sK();
    }

    int a(Object[] objArr, int i) {
        return this.Tl.a(objArr, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!ae.b(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator sI = iterator();
            while (sI.hasNext()) {
                Object next = sI.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (v(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        } catch (NoSuchElementException unused2) {
            return false;
        }
    }

    public E first() {
        if (!isEmpty()) {
            return this.Tl.get(0);
        }
        throw new NoSuchElementException();
    }

    public E last() {
        if (!isEmpty()) {
            return this.Tl.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public E lower(E e) {
        int g = g(e, false) - 1;
        if (g == -1) {
            return null;
        }
        return this.Tl.get(g);
    }

    public E floor(E e) {
        int g = g(e, true) - 1;
        if (g == -1) {
            return null;
        }
        return this.Tl.get(g);
    }

    public E ceiling(E e) {
        int h = h(e, true);
        return h == size() ? null : this.Tl.get(h);
    }

    public E higher(E e) {
        int h = h(e, false);
        return h == size() ? null : this.Tl.get(h);
    }

    ImmutableSortedSet<E> e(E e, boolean z) {
        return B(0, g(e, z));
    }

    int g(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.Tl, i.checkNotNull(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (z) {
            binarySearch++;
        }
        return binarySearch;
    }

    ImmutableSortedSet<E> c(E e, boolean z, E e2, boolean z2) {
        return f(e, z).e(e2, z2);
    }

    ImmutableSortedSet<E> f(E e, boolean z) {
        return B(h(e, z), size());
    }

    int h(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.Tl, i.checkNotNull(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (!z) {
            binarySearch++;
        }
        return binarySearch;
    }

    Comparator<Object> uH() {
        return this.comparator;
    }

    RegularImmutableSortedSet<E> B(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet(this.Tl.subList(i, i2), this.comparator);
        }
        return ImmutableSortedSet.e(this.comparator);
    }

    int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.Tl, obj, uH());
            if (binarySearch < 0) {
                binarySearch = -1;
            }
            return binarySearch;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public ImmutableList<E> sJ() {
        return this.Tl;
    }

    ImmutableSortedSet<E> tE() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return ImmutableSortedSet.e(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.Tl.sN(), reverseOrder);
    }
}
