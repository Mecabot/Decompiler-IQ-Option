package com.google.common.collect;

import com.google.common.base.i;
import java.util.Collection;
import java.util.Set;

/* compiled from: ForwardingSet */
public abstract class p<E> extends j<E> implements Set<E> {
    /* renamed from: st */
    protected abstract Set<E> su();

    protected p() {
    }

    public boolean equals(Object obj) {
        return obj == this || su().equals(obj);
    }

    public int hashCode() {
        return su().hashCode();
    }

    protected boolean l(Collection<?> collection) {
        return Sets.a((Set) this, (Collection) i.checkNotNull(collection));
    }
}
