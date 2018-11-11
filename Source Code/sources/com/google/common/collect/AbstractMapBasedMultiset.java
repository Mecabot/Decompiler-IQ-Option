package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.primitives.Ints;
import com.iqoption.dto.event.OtnEmissionExecuted;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    transient e<E> PZ;
    private transient long size = ((long) super.size());

    private class a implements Iterator<E> {
        final Iterator<com.google.common.collect.w.a<E>> Qd;
        com.google.common.collect.w.a<E> Qe;
        int Qf = 0;
        boolean canRemove = false;

        a() {
            this.Qd = AbstractMapBasedMultiset.this.PZ.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.Qf > 0 || this.Qd.hasNext();
        }

        public E next() {
            if (this.Qf == 0) {
                this.Qe = (com.google.common.collect.w.a) this.Qd.next();
                this.Qf = this.Qe.getCount();
            }
            this.Qf--;
            this.canRemove = true;
            return this.Qe.getElement();
        }

        public void remove() {
            g.ac(this.canRemove);
            int count = this.Qe.getCount();
            if (count <= 0) {
                throw new ConcurrentModificationException();
            }
            if (count == 1) {
                this.Qd.remove();
            } else {
                ((d) this.Qe).aK(count - 1);
            }
            AbstractMapBasedMultiset.this.size = AbstractMapBasedMultiset.this.size - 1;
            this.canRemove = false;
        }
    }

    protected AbstractMapBasedMultiset(e<E> eVar) {
        this.PZ = (e) i.checkNotNull(eVar);
    }

    void a(e<E> eVar) {
        this.PZ = eVar;
    }

    Set<E> rX() {
        return this.PZ.keySet();
    }

    public Set<com.google.common.collect.w.a<E>> rF() {
        return new b();
    }

    Iterator<com.google.common.collect.w.a<E>> rD() {
        final Iterator it = this.PZ.entrySet().iterator();
        return new Iterator<com.google.common.collect.w.a<E>>() {
            com.google.common.collect.w.a<E> Qa;
            boolean canRemove;

            public boolean hasNext() {
                return it.hasNext();
            }

            /* renamed from: rZ */
            public com.google.common.collect.w.a<E> next() {
                com.google.common.collect.w.a<E> aVar = (com.google.common.collect.w.a) it.next();
                this.Qa = aVar;
                this.canRemove = true;
                return aVar;
            }

            public void remove() {
                g.ac(this.canRemove);
                AbstractMapBasedMultiset.this.size = AbstractMapBasedMultiset.this.size - ((long) this.Qa.getCount());
                it.remove();
                this.canRemove = false;
                this.Qa = null;
            }
        };
    }

    public void clear() {
        this.PZ.clear();
        this.size = 0;
    }

    int rY() {
        return this.PZ.size();
    }

    public int size() {
        return Ints.I(this.size);
    }

    public Iterator<E> iterator() {
        return new a();
    }

    public int count(Object obj) {
        return this.PZ.get(obj);
    }

    public int d(E e, int i) {
        if (i == 0) {
            return count(e);
        }
        boolean z = false;
        i.a(i > 0, "occurrences cannot be negative: %s", i);
        int i2 = this.PZ.get(e);
        long j = (long) i;
        long j2 = ((long) i2) + j;
        if (j2 <= 2147483647L) {
            z = true;
        }
        i.a(z, "too many occurrences: %s", j2);
        this.PZ.g(e, (int) j2);
        this.size += j;
        return i2;
    }

    public int e(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        i.a(i > 0, "occurrences cannot be negative: %s", i);
        int i2 = this.PZ.get(obj);
        if (i2 > i) {
            this.PZ.g(obj, i2 - i);
        } else {
            this.PZ.W(obj);
            i = i2;
        }
        this.size -= (long) i;
        return i2;
    }

    public int f(E e, int i) {
        g.b(i, OtnEmissionExecuted.COUNT);
        int W = i == 0 ? this.PZ.W(e) : this.PZ.g(e, i);
        this.size += (long) (i - W);
        return W;
    }
}
