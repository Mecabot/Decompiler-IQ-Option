package com.google.common.collect;

import com.google.common.base.f;
import com.google.common.base.i;
import com.google.common.primitives.Ints;
import com.iqoption.dto.event.OtnEmissionExecuted;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Multisets {

    static final class d<E> implements Iterator<E> {
        private final Iterator<com.google.common.collect.w.a<E>> Qd;
        private com.google.common.collect.w.a<E> Qe;
        private final w<E> Sr;
        private int Ss;
        private int St;
        private boolean canRemove;

        d(w<E> wVar, Iterator<com.google.common.collect.w.a<E>> it) {
            this.Sr = wVar;
            this.Qd = it;
        }

        public boolean hasNext() {
            return this.Ss > 0 || this.Qd.hasNext();
        }

        public E next() {
            if (hasNext()) {
                if (this.Ss == 0) {
                    this.Qe = (com.google.common.collect.w.a) this.Qd.next();
                    int count = this.Qe.getCount();
                    this.Ss = count;
                    this.St = count;
                }
                this.Ss--;
                this.canRemove = true;
                return this.Qe.getElement();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            g.ac(this.canRemove);
            if (this.St == 1) {
                this.Qd.remove();
            } else {
                this.Sr.remove(this.Qe.getElement());
            }
            this.St--;
            this.canRemove = false;
        }
    }

    static abstract class a<E> implements com.google.common.collect.w.a<E> {
        a() {
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof com.google.common.collect.w.a)) {
                return false;
            }
            com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
            if (getCount() == aVar.getCount() && f.equal(getElement(), aVar.getElement())) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            int i;
            Object element = getElement();
            if (element == null) {
                i = 0;
            } else {
                i = element.hashCode();
            }
            return i ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(valueOf);
            stringBuilder.append(" x ");
            stringBuilder.append(count);
            return stringBuilder.toString();
        }
    }

    static abstract class b<E> extends a<E> {
        abstract w<E> sf();

        b() {
        }

        public void clear() {
            sf().clear();
        }

        public boolean contains(Object obj) {
            return sf().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return sf().containsAll(collection);
        }

        public boolean isEmpty() {
            return sf().isEmpty();
        }

        public Iterator<E> iterator() {
            return new ah<com.google.common.collect.w.a<E>, E>(sf().entrySet().iterator()) {
                /* renamed from: a */
                E ax(com.google.common.collect.w.a<E> aVar) {
                    return aVar.getElement();
                }
            };
        }

        public boolean remove(Object obj) {
            return sf().e(obj, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) > 0;
        }

        public int size() {
            return sf().entrySet().size();
        }
    }

    static abstract class c<E> extends a<com.google.common.collect.w.a<E>> {
        abstract w<E> sf();

        c() {
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
            if (sf().count(aVar.getElement()) == aVar.getCount()) {
                z = true;
            }
            return z;
        }

        public boolean remove(Object obj) {
            if (obj instanceof com.google.common.collect.w.a) {
                com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return sf().a(element, count, 0);
                }
            }
            return false;
        }

        public void clear() {
            sf().clear();
        }
    }

    static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E e, int i) {
            this.element = e;
            this.count = i;
            g.b(i, OtnEmissionExecuted.COUNT);
        }

        public final E getElement() {
            return this.element;
        }

        public final int getCount() {
            return this.count;
        }
    }

    public static <E> com.google.common.collect.w.a<E> k(E e, int i) {
        return new ImmutableEntry(e, i);
    }

    static boolean a(w<?> wVar, Object obj) {
        if (obj == wVar) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar2 = (w) obj;
        if (wVar.size() != wVar2.size() || wVar.entrySet().size() != wVar2.entrySet().size()) {
            return false;
        }
        for (com.google.common.collect.w.a aVar : wVar2.entrySet()) {
            if (wVar.count(aVar.getElement()) != aVar.getCount()) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean a(w<E> wVar, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof w) {
            for (com.google.common.collect.w.a aVar : x(collection).entrySet()) {
                wVar.d(aVar.getElement(), aVar.getCount());
            }
        } else {
            Iterators.a((Collection) wVar, collection.iterator());
        }
        return true;
    }

    static boolean b(w<?> wVar, Collection<?> collection) {
        Collection collection2;
        if (collection2 instanceof w) {
            collection2 = ((w) collection2).se();
        }
        return wVar.se().removeAll(collection2);
    }

    static boolean c(w<?> wVar, Collection<?> collection) {
        Collection collection2;
        i.checkNotNull(collection2);
        if (collection2 instanceof w) {
            collection2 = ((w) collection2).se();
        }
        return wVar.se().retainAll(collection2);
    }

    static <E> int a(w<E> wVar, E e, int i) {
        g.b(i, OtnEmissionExecuted.COUNT);
        int count = wVar.count(e);
        i -= count;
        if (i > 0) {
            wVar.d(e, i);
        } else if (i < 0) {
            wVar.e(e, -i);
        }
        return count;
    }

    static <E> boolean a(w<E> wVar, E e, int i, int i2) {
        g.b(i, "oldCount");
        g.b(i2, "newCount");
        if (wVar.count(e) != i) {
            return false;
        }
        wVar.f(e, i2);
        return true;
    }

    static <E> Iterator<E> a(w<E> wVar) {
        return new d(wVar, wVar.entrySet().iterator());
    }

    static int b(w<?> wVar) {
        long j = 0;
        for (com.google.common.collect.w.a count : wVar.entrySet()) {
            j += (long) count.getCount();
        }
        return Ints.I(j);
    }

    static <T> w<T> x(Iterable<T> iterable) {
        return (w) iterable;
    }
}
