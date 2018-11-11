package com.google.common.collect;

import com.google.common.base.d;
import com.google.common.base.i;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: Collections2 */
public final class h {

    /* compiled from: Collections2 */
    static class a<F, T> extends AbstractCollection<T> {
        final Collection<F> Qu;
        final d<? super F, ? extends T> function;

        a(Collection<F> collection, d<? super F, ? extends T> dVar) {
            this.Qu = (Collection) i.checkNotNull(collection);
            this.function = (d) i.checkNotNull(dVar);
        }

        public void clear() {
            this.Qu.clear();
        }

        public boolean isEmpty() {
            return this.Qu.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.a(this.Qu.iterator(), this.function);
        }

        public int size() {
            return this.Qu.size();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A:{Splitter: B:1:0x0003, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return false;
     */
    static boolean a(java.util.Collection<?> r0, java.lang.Object r1) {
        /*
        com.google.common.base.i.checkNotNull(r0);
        r0 = r0.contains(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.h.a(java.util.Collection, java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A:{Splitter: B:1:0x0003, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return false;
     */
    static boolean b(java.util.Collection<?> r0, java.lang.Object r1) {
        /*
        com.google.common.base.i.checkNotNull(r0);
        r0 = r0.remove(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.h.b(java.util.Collection, java.lang.Object):boolean");
    }

    public static <F, T> Collection<T> a(Collection<F> collection, d<? super F, T> dVar) {
        return new a(collection, dVar);
    }

    static boolean a(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder aL(int i) {
        g.b(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> b(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
