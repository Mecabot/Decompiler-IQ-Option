package com.google.common.collect;

import com.google.common.base.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private transient ImmutableList<E> Rb;

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.k(this.elements);
        }
    }

    static abstract class Indexed<E> extends ImmutableSet<E> {
        abstract E get(int i);

        Indexed() {
        }

        /* renamed from: sI */
        public aj<E> iterator() {
            return sJ().iterator();
        }

        ImmutableList<E> tr() {
            return new ImmutableList<E>() {
                public E get(int i) {
                    return Indexed.this.get(i);
                }

                boolean sK() {
                    return Indexed.this.sK();
                }

                public int size() {
                    return Indexed.this.size();
                }
            };
        }
    }

    public static class a<E> extends a<E> {
        Object[] Rg;
        private int hashCode;

        public a() {
            super(4);
        }

        /* renamed from: an */
        public a<E> ae(E e) {
            i.checkNotNull(e);
            if (this.Rg == null || ImmutableSet.aU(this.size) > this.Rg.length) {
                this.Rg = null;
                super.ae(e);
                return this;
            }
            ao(e);
            return this;
        }

        private void ao(E e) {
            int length = this.Rg.length - 1;
            int hashCode = e.hashCode();
            int aO = r.aO(hashCode);
            while (true) {
                aO &= length;
                Object obj = this.Rg[aO];
                if (obj == null) {
                    this.Rg[aO] = e;
                    this.hashCode += hashCode;
                    super.ae(e);
                    return;
                } else if (!obj.equals(e)) {
                    aO++;
                } else {
                    return;
                }
            }
        }

        /* renamed from: l */
        public a<E> e(E... eArr) {
            if (this.Rg != null) {
                for (Object an : eArr) {
                    ae(an);
                }
            } else {
                super.e(eArr);
            }
            return this;
        }

        /* renamed from: m */
        public a<E> f(Iterable<? extends E> iterable) {
            i.checkNotNull(iterable);
            if (this.Rg != null) {
                for (Object an : iterable) {
                    ae(an);
                }
            } else {
                super.f(iterable);
            }
            return this;
        }

        /* renamed from: g */
        public a<E> b(Iterator<? extends E> it) {
            i.checkNotNull(it);
            while (it.hasNext()) {
                ae(it.next());
            }
            return this;
        }

        public ImmutableSet<E> tt() {
            switch (this.size) {
                case 0:
                    return ImmutableSet.tq();
                case 1:
                    return ImmutableSet.am(this.QK[0]);
                default:
                    ImmutableSet<E> b;
                    if (this.Rg == null || ImmutableSet.aU(this.size) != this.Rg.length) {
                        b = ImmutableSet.a(this.size, this.QK);
                        this.size = b.size();
                    } else {
                        Object[] copyOf;
                        if (ImmutableSet.x(this.size, this.QK.length)) {
                            copyOf = Arrays.copyOf(this.QK, this.size);
                        } else {
                            copyOf = this.QK;
                        }
                        ImmutableSet<E> regularImmutableSet = new RegularImmutableSet(copyOf, this.hashCode, this.Rg, this.Rg.length - 1, this.size);
                    }
                    this.QL = true;
                    this.Rg = null;
                    return b;
            }
        }
    }

    private static boolean x(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* renamed from: sI */
    public abstract aj<E> iterator();

    boolean tb() {
        return false;
    }

    public static <E> ImmutableSet<E> tq() {
        return RegularImmutableSet.Ti;
    }

    public static <E> ImmutableSet<E> am(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> s(E e, E e2) {
        return a(2, e, e2);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> a(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object obj = new Object[(eArr.length + 6)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        System.arraycopy(eArr, 0, obj, 6, eArr.length);
        return a(obj.length, obj);
    }

    private static <E> ImmutableSet<E> a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return tq();
            case 1:
                return am(objArr[0]);
            default:
                int aU = aU(i);
                Object[] objArr2 = new Object[aU];
                int i2 = aU - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object l = x.l(objArr[i5], i5);
                    int hashCode = l.hashCode();
                    int aO = r.aO(hashCode);
                    while (true) {
                        int i6 = aO & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            aO = i4 + 1;
                            objArr[i4] = l;
                            objArr2[i6] = l;
                            i3 += hashCode;
                            i4 = aO;
                        } else if (!obj.equals(l)) {
                            aO++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i, null);
                if (i4 == 1) {
                    return new SingletonImmutableSet(objArr[0], i3);
                }
                if (aU(i4) < aU / 2) {
                    return a(i4, objArr);
                }
                if (x(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
        }
    }

    static int aU(int i) {
        i = Math.max(i, 2);
        boolean z = true;
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (i >= 1073741824) {
            z = false;
        }
        i.checkArgument(z, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> n(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.sK()) {
                return immutableSet;
            }
        }
        Object[] toArray = collection.toArray();
        return a(toArray.length, toArray);
    }

    public static <E> ImmutableSet<E> l(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return n((Collection) iterable);
        }
        return f(iterable.iterator());
    }

    public static <E> ImmutableSet<E> f(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return tq();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new a().ae(next).b(it).tt();
        }
        return am(next);
    }

    public static <E> ImmutableSet<E> k(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return tq();
            case 1:
                return am(eArr[0]);
            default:
                return a(eArr.length, (Object[]) eArr.clone());
        }
    }

    ImmutableSet() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && tb() && ((ImmutableSet) obj).tb() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a((Set) this, obj);
    }

    public int hashCode() {
        return Sets.d(this);
    }

    public ImmutableList<E> sJ() {
        ImmutableList<E> immutableList = this.Rb;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = tr();
        this.Rb = immutableList;
        return immutableList;
    }

    ImmutableList<E> tr() {
        return ImmutableList.h(toArray());
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> a<E> ts() {
        return new a();
    }
}
