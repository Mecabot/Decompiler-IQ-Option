package com.google.common.collect;

import com.google.common.base.f;
import com.google.common.base.i;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: AbstractObjectCountMap */
abstract class e<K> {
    private transient Set<K> Qm;
    private transient Set<com.google.common.collect.w.a<K>> Qn;
    transient Object[] keys;
    transient int modCount;
    transient int size;
    transient int[] values;

    /* compiled from: AbstractObjectCountMap */
    abstract class b<T> implements Iterator<T> {
        boolean Qp = false;
        int expectedModCount = e.this.modCount;
        int index = 0;

        abstract T aJ(int i);

        b() {
        }

        public boolean hasNext() {
            return this.index < e.this.size;
        }

        public T next() {
            sh();
            if (hasNext()) {
                this.Qp = true;
                int i = this.index;
                this.index = i + 1;
                return aJ(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            sh();
            g.ac(this.Qp);
            this.expectedModCount++;
            this.index--;
            e.this.aG(this.index);
            this.Qp = false;
        }

        void sh() {
            if (e.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* compiled from: AbstractObjectCountMap */
    abstract class a extends a<com.google.common.collect.w.a<K>> {
        a() {
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof com.google.common.collect.w.a)) {
                return false;
            }
            com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
            int indexOf = e.this.indexOf(aVar.getElement());
            if (indexOf != -1 && e.this.values[indexOf] == aVar.getCount()) {
                z = true;
            }
            return z;
        }

        public boolean remove(Object obj) {
            if (obj instanceof com.google.common.collect.w.a) {
                com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
                int indexOf = e.this.indexOf(aVar.getElement());
                if (indexOf != -1 && e.this.values[indexOf] == aVar.getCount()) {
                    e.this.aG(indexOf);
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return e.this.size;
        }
    }

    /* compiled from: AbstractObjectCountMap */
    class c extends a<K> {
        c() {
        }

        public Object[] toArray() {
            return x.a(e.this.keys, 0, e.this.size);
        }

        public <T> T[] toArray(T[] tArr) {
            return x.a(e.this.keys, 0, e.this.size, tArr);
        }

        public Iterator<K> iterator() {
            return new b<K>() {
                {
                    e eVar = e.this;
                }

                K aJ(int i) {
                    return e.this.keys[i];
                }
            };
        }

        public int size() {
            return e.this.size;
        }
    }

    /* compiled from: AbstractObjectCountMap */
    class d extends a<K> {
        int Qr;
        final K key;

        d(int i) {
            this.key = e.this.keys[i];
            this.Qr = i;
        }

        public K getElement() {
            return this.key;
        }

        void si() {
            if (this.Qr == -1 || this.Qr >= e.this.size() || !f.equal(this.key, e.this.keys[this.Qr])) {
                this.Qr = e.this.indexOf(this.key);
            }
        }

        public int getCount() {
            si();
            return this.Qr == -1 ? 0 : e.this.values[this.Qr];
        }

        public int aK(int i) {
            si();
            if (this.Qr == -1) {
                e.this.g(this.key, i);
                return 0;
            }
            int i2 = e.this.values[this.Qr];
            e.this.values[this.Qr] = i;
            return i2;
        }
    }

    abstract int W(Object obj);

    abstract int aG(int i);

    abstract void clear();

    abstract int g(K k, int i);

    abstract int get(Object obj);

    abstract int indexOf(Object obj);

    abstract Set<com.google.common.collect.w.a<K>> rF();

    int sg() {
        return 0;
    }

    e() {
    }

    Set<K> keySet() {
        if (this.Qm != null) {
            return this.Qm;
        }
        Set<K> rB = rB();
        this.Qm = rB;
        return rB;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    Set<K> rB() {
        return new c();
    }

    K getKey(int i) {
        i.s(i, this.size);
        return this.keys[i];
    }

    int getValue(int i) {
        i.s(i, this.size);
        return this.values[i];
    }

    com.google.common.collect.w.a<K> aH(int i) {
        i.s(i, this.size);
        return new d(i);
    }

    int aI(int i) {
        i++;
        return i < this.size ? i : -1;
    }

    Set<com.google.common.collect.w.a<K>> entrySet() {
        if (this.Qn != null) {
            return this.Qn;
        }
        Set<com.google.common.collect.w.a<K>> rF = rF();
        this.Qn = rF;
        return rF;
    }
}
