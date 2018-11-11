package com.google.common.collect;

import com.google.common.collect.w.a;
import com.google.common.primitives.Ints;

class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> Tf = new RegularImmutableMultiset(y.uE());
    private final transient y<E> Tg;
    private transient ImmutableSet<E> Th;
    private final transient int size;

    private final class ElementSet extends Indexed<E> {
        boolean sK() {
            return true;
        }

        private ElementSet() {
        }

        E get(int i) {
            return RegularImmutableMultiset.this.Tg.getKey(i);
        }

        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        public int size() {
            return RegularImmutableMultiset.this.Tg.size();
        }
    }

    boolean sK() {
        return false;
    }

    RegularImmutableMultiset(y<E> yVar) {
        this.Tg = yVar;
        long j = 0;
        int i = 0;
        while (i < yVar.size()) {
            i++;
            j += (long) yVar.getValue(i);
        }
        this.size = Ints.I(j);
    }

    public int count(Object obj) {
        return this.Tg.get(obj);
    }

    public int size() {
        return this.size;
    }

    /* renamed from: tm */
    public ImmutableSet<E> se() {
        ImmutableSet<E> immutableSet = this.Th;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new ElementSet();
        this.Th = immutableSet;
        return immutableSet;
    }

    a<E> aH(int i) {
        return this.Tg.aH(i);
    }
}
