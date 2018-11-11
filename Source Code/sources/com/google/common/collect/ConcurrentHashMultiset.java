package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConcurrentHashMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> Qv;

    private static class b {
        static final a<ConcurrentHashMultiset> QC = ab.c(ConcurrentHashMultiset.class, "countMap");
    }

    private class a extends b {
        private a() {
            super();
        }

        /* synthetic */ a(ConcurrentHashMultiset concurrentHashMultiset, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: sx */
        ConcurrentHashMultiset<E> sf() {
            return ConcurrentHashMultiset.this;
        }

        public Object[] toArray() {
            return ss().toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return ss().toArray(tArr);
        }

        private List<com.google.common.collect.w.a<E>> ss() {
            Collection aZ = Lists.aZ(size());
            Iterators.a(aZ, iterator());
            return aZ;
        }
    }

    public static <E> ConcurrentHashMultiset<E> sr() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        i.a(concurrentMap.isEmpty(), "the backing map (%s) must be empty", (Object) concurrentMap);
        this.Qv = concurrentMap;
    }

    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.Qv, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.Qv.values()) {
            j += (long) atomicInteger.get();
        }
        return Ints.I(j);
    }

    public Object[] toArray() {
        return ss().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return ss().toArray(tArr);
    }

    private List<E> ss() {
        List<E> aZ = Lists.aZ(size());
        for (com.google.common.collect.w.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                aZ.add(element);
            }
        }
        return aZ;
    }

    /* JADX WARNING: Missing block: B:18:0x005a, code:
            r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Missing block: B:19:0x0065, code:
            if (r4.Qv.putIfAbsent(r5, r2) == null) goto L_0x006f;
     */
    public int d(E r5, int r6) {
        /*
        r4 = this;
        com.google.common.base.i.checkNotNull(r5);
        if (r6 != 0) goto L_0x000a;
    L_0x0005:
        r5 = r4.count(r5);
        return r5;
    L_0x000a:
        r0 = "occurences";
        com.google.common.collect.g.c(r6, r0);
    L_0x000f:
        r0 = r4.Qv;
        r0 = com.google.common.collect.Maps.a(r0, r5);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x002a;
    L_0x001a:
        r0 = r4.Qv;
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r0 = r0.putIfAbsent(r5, r2);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r2 = r0.get();
        if (r2 == 0) goto L_0x005a;
    L_0x0030:
        r3 = com.google.common.c.b.E(r2, r6);	 Catch:{ ArithmeticException -> 0x003b }
        r3 = r0.compareAndSet(r2, r3);	 Catch:{ ArithmeticException -> 0x003b }
        if (r3 == 0) goto L_0x002a;
    L_0x003a:
        return r2;
    L_0x003b:
        r5 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Overflow adding ";
        r0.append(r1);
        r0.append(r6);
        r6 = " occurrences to a count of ";
        r0.append(r6);
        r0.append(r2);
        r6 = r0.toString();
        r5.<init>(r6);
        throw r5;
    L_0x005a:
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r3 = r4.Qv;
        r3 = r3.putIfAbsent(r5, r2);
        if (r3 == 0) goto L_0x006f;
    L_0x0067:
        r3 = r4.Qv;
        r0 = r3.replace(r5, r0, r2);
        if (r0 == 0) goto L_0x000f;
    L_0x006f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.d(java.lang.Object, int):int");
    }

    public int e(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        g.c(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.Qv, obj);
        if (atomicInteger == null) {
            return 0;
        }
        int i2;
        int max;
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.Qv.remove(obj, atomicInteger);
        }
        return i2;
    }

    /* JADX WARNING: Missing block: B:10:0x002c, code:
            if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Missing block: B:11:0x002e, code:
            return 0;
     */
    /* JADX WARNING: Missing block: B:12:0x002f, code:
            r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Missing block: B:13:0x003a, code:
            if (r4.Qv.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    public int f(E r5, int r6) {
        /*
        r4 = this;
        com.google.common.base.i.checkNotNull(r5);
        r0 = "count";
        com.google.common.collect.g.b(r6, r0);
    L_0x0008:
        r0 = r4.Qv;
        r0 = com.google.common.collect.Maps.a(r0, r5);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x0026;
    L_0x0013:
        if (r6 != 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r0 = r4.Qv;
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r0 = r0.putIfAbsent(r5, r2);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = r0.get();
        if (r2 != 0) goto L_0x0045;
    L_0x002c:
        if (r6 != 0) goto L_0x002f;
    L_0x002e:
        return r1;
    L_0x002f:
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r3 = r4.Qv;
        r3 = r3.putIfAbsent(r5, r2);
        if (r3 == 0) goto L_0x0044;
    L_0x003c:
        r3 = r4.Qv;
        r0 = r3.replace(r5, r0, r2);
        if (r0 == 0) goto L_0x0008;
    L_0x0044:
        return r1;
    L_0x0045:
        r3 = r0.compareAndSet(r2, r6);
        if (r3 == 0) goto L_0x0026;
    L_0x004b:
        if (r6 != 0) goto L_0x0052;
    L_0x004d:
        r6 = r4.Qv;
        r6.remove(r5, r0);
    L_0x0052:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.f(java.lang.Object, int):int");
    }

    public boolean a(E e, int i, int i2) {
        i.checkNotNull(e);
        g.b(i, "oldCount");
        g.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.Qv, e);
        boolean z = false;
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.Qv.remove(e, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    if (this.Qv.putIfAbsent(e, atomicInteger2) == null || this.Qv.replace(e, atomicInteger, atomicInteger2)) {
                        z = true;
                    }
                    return z;
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.Qv.remove(e, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 == 0) {
                return true;
            }
            if (this.Qv.putIfAbsent(e, new AtomicInteger(i2)) == null) {
                z = true;
            }
            return z;
        }
    }

    Set<E> rX() {
        final Set keySet = this.Qv.keySet();
        return new p<E>() {
            /* renamed from: st */
            protected Set<E> su() {
                return keySet;
            }

            public boolean contains(Object obj) {
                return obj != null && h.a(keySet, obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return k(collection);
            }

            public boolean remove(Object obj) {
                return obj != null && h.b(keySet, obj);
            }

            public boolean removeAll(Collection<?> collection) {
                return l(collection);
            }
        };
    }

    public Set<com.google.common.collect.w.a<E>> rF() {
        return new a(this, null);
    }

    int rY() {
        return this.Qv.size();
    }

    public boolean isEmpty() {
        return this.Qv.isEmpty();
    }

    Iterator<com.google.common.collect.w.a<E>> rD() {
        final Iterator anonymousClass2 = new AbstractIterator<com.google.common.collect.w.a<E>>() {
            private final Iterator<Entry<E, AtomicInteger>> Qy = ConcurrentHashMultiset.this.Qv.entrySet().iterator();

            /* renamed from: sv */
            protected com.google.common.collect.w.a<E> pr() {
                while (this.Qy.hasNext()) {
                    Entry entry = (Entry) this.Qy.next();
                    int i = ((AtomicInteger) entry.getValue()).get();
                    if (i != 0) {
                        return Multisets.k(entry.getKey(), i);
                    }
                }
                return (com.google.common.collect.w.a) ps();
            }
        };
        return new l<com.google.common.collect.w.a<E>>() {
            private com.google.common.collect.w.a<E> Qz;

            /* renamed from: sw */
            protected Iterator<com.google.common.collect.w.a<E>> qB() {
                return anonymousClass2;
            }

            /* renamed from: rZ */
            public com.google.common.collect.w.a<E> next() {
                this.Qz = (com.google.common.collect.w.a) super.next();
                return this.Qz;
            }

            public void remove() {
                g.ac(this.Qz != null);
                ConcurrentHashMultiset.this.f(this.Qz.getElement(), 0);
                this.Qz = null;
            }
        };
    }

    public void clear() {
        this.Qv.clear();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Qv);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        b.QC.set((Object) this, (ConcurrentMap) objectInputStream.readObject());
    }
}
