package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: ForwardingCollection */
public abstract class j<E> extends o implements Collection<E> {
    /* renamed from: su */
    protected abstract Collection<E> qB();

    protected j() {
    }

    public Iterator<E> iterator() {
        return qB().iterator();
    }

    public int size() {
        return qB().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return qB().removeAll(collection);
    }

    public boolean isEmpty() {
        return qB().isEmpty();
    }

    public boolean contains(Object obj) {
        return qB().contains(obj);
    }

    public boolean add(E e) {
        return qB().add(e);
    }

    public boolean remove(Object obj) {
        return qB().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return qB().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return qB().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return qB().retainAll(collection);
    }

    public void clear() {
        qB().clear();
    }

    public Object[] toArray() {
        return qB().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return qB().toArray(tArr);
    }

    protected boolean k(Collection<?> collection) {
        return h.a((Collection) this, (Collection) collection);
    }

    protected boolean l(Collection<?> collection) {
        return Iterators.a(iterator(), (Collection) collection);
    }
}
