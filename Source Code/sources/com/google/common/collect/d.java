package com.google.common.collect;

import com.google.common.base.f;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: AbstractMultiset */
abstract class d<E> extends AbstractCollection<E> implements w<E> {
    private transient Set<com.google.common.collect.w.a<E>> Ou;
    private transient Set<E> Qk;

    /* compiled from: AbstractMultiset */
    class a extends b<E> {
        a() {
        }

        w<E> sf() {
            return d.this;
        }
    }

    /* compiled from: AbstractMultiset */
    class b extends c<E> {
        b() {
        }

        w<E> sf() {
            return d.this;
        }

        public Iterator<com.google.common.collect.w.a<E>> iterator() {
            return d.this.rD();
        }

        public int size() {
            return d.this.rY();
        }
    }

    abstract Iterator<com.google.common.collect.w.a<E>> rD();

    abstract int rY();

    d() {
    }

    public int size() {
        return Multisets.b(this);
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Iterator<E> iterator() {
        return Multisets.a(this);
    }

    public int count(Object obj) {
        for (com.google.common.collect.w.a aVar : entrySet()) {
            if (f.equal(aVar.getElement(), obj)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    public boolean add(E e) {
        d(e, 1);
        return true;
    }

    public int d(E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        return e(obj, 1) > 0;
    }

    public int e(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int f(E e, int i) {
        return Multisets.a(this, e, i);
    }

    public boolean a(E e, int i, int i2) {
        return Multisets.a(this, e, i, i2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a((w) this, (Collection) collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    public void clear() {
        Iterators.p(rD());
    }

    public Set<E> se() {
        Set<E> set = this.Qk;
        if (set != null) {
            return set;
        }
        set = rX();
        this.Qk = set;
        return set;
    }

    Set<E> rX() {
        return new a();
    }

    public Set<com.google.common.collect.w.a<E>> entrySet() {
        Set<com.google.common.collect.w.a<E>> set = this.Ou;
        if (set != null) {
            return set;
        }
        set = rF();
        this.Ou = set;
        return set;
    }

    Set<com.google.common.collect.w.a<E>> rF() {
        return new b();
    }

    public boolean equals(Object obj) {
        return Multisets.a((w) this, obj);
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        return entrySet().toString();
    }
}
