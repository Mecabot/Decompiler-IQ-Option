package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.collect.ImmutableCollection.b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements w<E> {
    private transient ImmutableSet<com.google.common.collect.w.a<E>> QO;
    private transient ImmutableList<E> Rb;

    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(w<?> wVar) {
            int size = wVar.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            size = 0;
            for (com.google.common.collect.w.a aVar : wVar.entrySet()) {
                this.elements[size] = aVar.getElement();
                this.counts[size] = aVar.getCount();
                size++;
            }
        }

        Object readResolve() {
            a aVar = new a(this.elements.length);
            for (int i = 0; i < this.elements.length; i++) {
                aVar.h(this.elements[i], this.counts[i]);
            }
            return aVar.tp();
        }
    }

    public static class a<E> extends b<E> {
        e<E> Rd;
        boolean Re;
        boolean Rf;

        public a() {
            this(4);
        }

        a(int i) {
            this.Re = false;
            this.Rf = false;
            this.Rd = y.bm(i);
        }

        /* renamed from: al */
        public a<E> ae(E e) {
            return h(e, 1);
        }

        public a<E> h(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.Re) {
                this.Rd = new y(this.Rd);
                this.Rf = false;
            }
            this.Re = false;
            i.checkNotNull(e);
            this.Rd.g(e, i + this.Rd.get(e));
            return this;
        }

        /* renamed from: j */
        public a<E> e(E... eArr) {
            super.e(eArr);
            return this;
        }

        /* renamed from: k */
        public a<E> f(Iterable<? extends E> iterable) {
            if (iterable instanceof w) {
                for (com.google.common.collect.w.a aVar : Multisets.x(iterable).entrySet()) {
                    h(aVar.getElement(), aVar.getCount());
                }
            } else {
                super.f(iterable);
            }
            return this;
        }

        /* renamed from: e */
        public a<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }

        public ImmutableMultiset<E> tp() {
            if (this.Rd.isEmpty()) {
                return ImmutableMultiset.tn();
            }
            if (this.Rf) {
                this.Rd = new y(this.Rd);
                this.Rf = false;
            }
            this.Re = true;
            return new RegularImmutableMultiset((y) this.Rd);
        }
    }

    private final class EntrySet extends Indexed<com.google.common.collect.w.a<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, AnonymousClass1 anonymousClass1) {
            this();
        }

        boolean sK() {
            return ImmutableMultiset.this.sK();
        }

        /* renamed from: aT */
        com.google.common.collect.w.a<E> get(int i) {
            return ImmutableMultiset.this.aH(i);
        }

        public int size() {
            return ImmutableMultiset.this.se().size();
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof com.google.common.collect.w.a)) {
                return false;
            }
            com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
            if (aVar.getCount() <= 0) {
                return false;
            }
            if (ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount()) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    abstract com.google.common.collect.w.a<E> aH(int i);

    /* renamed from: tm */
    public abstract ImmutableSet<E> se();

    public static <E> ImmutableMultiset<E> tn() {
        return RegularImmutableMultiset.Tf;
    }

    ImmutableMultiset() {
    }

    /* renamed from: sI */
    public aj<E> iterator() {
        final Iterator sI = entrySet().iterator();
        return new aj<E>() {
            int Rc;
            E element;

            public boolean hasNext() {
                return this.Rc > 0 || sI.hasNext();
            }

            public E next() {
                if (this.Rc <= 0) {
                    com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) sI.next();
                    this.element = aVar.getElement();
                    this.Rc = aVar.getCount();
                }
                this.Rc--;
                return this.element;
            }
        };
    }

    public ImmutableList<E> sJ() {
        ImmutableList<E> immutableList = this.Rb;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = super.sJ();
        this.Rb = immutableList;
        return immutableList;
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Deprecated
    public final int d(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int e(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int f(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean a(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    int a(Object[] objArr, int i) {
        Iterator sI = entrySet().iterator();
        while (sI.hasNext()) {
            com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) sI.next();
            Arrays.fill(objArr, i, aVar.getCount() + i, aVar.getElement());
            i += aVar.getCount();
        }
        return i;
    }

    public boolean equals(Object obj) {
        return Multisets.a((w) this, obj);
    }

    public int hashCode() {
        return Sets.d(entrySet());
    }

    public String toString() {
        return entrySet().toString();
    }

    /* renamed from: sV */
    public ImmutableSet<com.google.common.collect.w.a<E>> entrySet() {
        ImmutableSet<com.google.common.collect.w.a<E>> immutableSet = this.QO;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = sW();
        this.QO = immutableSet;
        return immutableSet;
    }

    private final ImmutableSet<com.google.common.collect.w.a<E>> sW() {
        return isEmpty() ? ImmutableSet.tq() : new EntrySet(this, null);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
