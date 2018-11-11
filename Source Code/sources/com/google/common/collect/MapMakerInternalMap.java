package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

class MapMakerInternalMap<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final t<Object, Object, c> RQ = new t<Object, Object, c>() {
        public t<Object, Object, c> a(ReferenceQueue<Object> referenceQueue, c cVar) {
            return this;
        }

        public void clear() {
        }

        public Object get() {
            return null;
        }

        /* renamed from: tU */
        public c tV() {
            return null;
        }
    };
    private static final long serialVersionUID = 5;
    final transient int Oi;
    final transient int Oj;
    transient Set<K> Os;
    transient Collection<V> Ot;
    transient Set<Entry<K, V>> Ou;
    final transient Segment<K, V, E, S>[] RN;
    final transient h<K, V, E, S> RP;
    final int concurrencyLevel;
    final Equivalence<Object> keyEquivalence;

    static abstract class Segment<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        abstract S ub();

        void uc() {
        }

        void ud() {
        }

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            a(aE(i));
        }

        void a(E e, V v) {
            this.map.RP.a(ub(), (g) e, (Object) v);
        }

        E a(E e, E e2) {
            return this.map.RP.a(ub(), (g) e, (g) e2);
        }

        AtomicReferenceArray<E> aE(int i) {
            return new AtomicReferenceArray(i);
        }

        void a(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (this.threshold == this.maxSegmentSize) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        void rf() {
            if (tryLock()) {
                try {
                    uc();
                } finally {
                    unlock();
                }
            }
        }

        void a(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.a((g) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        void b(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.a((t) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        <T> void c(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        E be(int i) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            return (g) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        E i(Object obj, int i) {
            if (this.count != 0) {
                for (E be = be(i); be != null; be = be.tW()) {
                    if (be.getHash() == i) {
                        Object key = be.getKey();
                        if (key == null) {
                            rf();
                        } else if (this.map.keyEquivalence.f(obj, key)) {
                            return be;
                        }
                    }
                }
            }
            return null;
        }

        E j(Object obj, int i) {
            return i(obj, i);
        }

        V get(Object obj, int i) {
            try {
                g j = j(obj, i);
                if (j == null) {
                    return null;
                }
                V value = j.getValue();
                if (value == null) {
                    rf();
                }
                ro();
                return value;
            } finally {
                ro();
            }
        }

        boolean b(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    g j = j(obj, i);
                    if (!(j == null || j.getValue() == null)) {
                        z = true;
                    }
                    ro();
                    return z;
                }
                ro();
                return false;
            } catch (Throwable th) {
                ro();
            }
        }

        /* JADX WARNING: Missing block: B:13:0x003e, code:
            r9 = r4.getValue();
     */
        /* JADX WARNING: Missing block: B:14:0x0042, code:
            if (r9 != null) goto L_0x0055;
     */
        /* JADX WARNING: Missing block: B:15:0x0044, code:
            r8.modCount++;
            a(r4, (java.lang.Object) r11);
            r8.count = r8.count;
     */
        /* JADX WARNING: Missing block: B:17:0x0055, code:
            if (r12 == false) goto L_0x005b;
     */
        /* JADX WARNING: Missing block: B:18:0x0057, code:
            unlock();
     */
        /* JADX WARNING: Missing block: B:19:0x005a, code:
            return r9;
     */
        /* JADX WARNING: Missing block: B:21:?, code:
            r8.modCount++;
            a(r4, (java.lang.Object) r11);
     */
        /* JADX WARNING: Missing block: B:22:0x0064, code:
            unlock();
     */
        /* JADX WARNING: Missing block: B:23:0x0067, code:
            return r9;
     */
        V a(K r9, int r10, V r11, boolean r12) {
            /*
            r8 = this;
            r8.lock();
            r8.ue();	 Catch:{ all -> 0x008b }
            r0 = r8.count;	 Catch:{ all -> 0x008b }
            r0 = r0 + 1;
            r1 = r8.threshold;	 Catch:{ all -> 0x008b }
            if (r0 <= r1) goto L_0x0015;
        L_0x000e:
            r8.expand();	 Catch:{ all -> 0x008b }
            r0 = r8.count;	 Catch:{ all -> 0x008b }
            r0 = r0 + 1;
        L_0x0015:
            r1 = r8.table;	 Catch:{ all -> 0x008b }
            r2 = r1.length();	 Catch:{ all -> 0x008b }
            r2 = r2 + -1;
            r2 = r2 & r10;
            r3 = r1.get(r2);	 Catch:{ all -> 0x008b }
            r3 = (com.google.common.collect.MapMakerInternalMap.g) r3;	 Catch:{ all -> 0x008b }
            r4 = r3;
        L_0x0025:
            r5 = 0;
            if (r4 == 0) goto L_0x006d;
        L_0x0028:
            r6 = r4.getKey();	 Catch:{ all -> 0x008b }
            r7 = r4.getHash();	 Catch:{ all -> 0x008b }
            if (r7 != r10) goto L_0x0068;
        L_0x0032:
            if (r6 == 0) goto L_0x0068;
        L_0x0034:
            r7 = r8.map;	 Catch:{ all -> 0x008b }
            r7 = r7.keyEquivalence;	 Catch:{ all -> 0x008b }
            r6 = r7.f(r9, r6);	 Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x0068;
        L_0x003e:
            r9 = r4.getValue();	 Catch:{ all -> 0x008b }
            if (r9 != 0) goto L_0x0055;
        L_0x0044:
            r9 = r8.modCount;	 Catch:{ all -> 0x008b }
            r9 = r9 + 1;
            r8.modCount = r9;	 Catch:{ all -> 0x008b }
            r8.a(r4, r11);	 Catch:{ all -> 0x008b }
            r9 = r8.count;	 Catch:{ all -> 0x008b }
            r8.count = r9;	 Catch:{ all -> 0x008b }
            r8.unlock();
            return r5;
        L_0x0055:
            if (r12 == 0) goto L_0x005b;
        L_0x0057:
            r8.unlock();
            return r9;
        L_0x005b:
            r10 = r8.modCount;	 Catch:{ all -> 0x008b }
            r10 = r10 + 1;
            r8.modCount = r10;	 Catch:{ all -> 0x008b }
            r8.a(r4, r11);	 Catch:{ all -> 0x008b }
            r8.unlock();
            return r9;
        L_0x0068:
            r4 = r4.tW();	 Catch:{ all -> 0x008b }
            goto L_0x0025;
        L_0x006d:
            r12 = r8.modCount;	 Catch:{ all -> 0x008b }
            r12 = r12 + 1;
            r8.modCount = r12;	 Catch:{ all -> 0x008b }
            r12 = r8.map;	 Catch:{ all -> 0x008b }
            r12 = r12.RP;	 Catch:{ all -> 0x008b }
            r4 = r8.ub();	 Catch:{ all -> 0x008b }
            r9 = r12.a(r4, r9, r10, r3);	 Catch:{ all -> 0x008b }
            r8.a(r9, r11);	 Catch:{ all -> 0x008b }
            r1.set(r2, r9);	 Catch:{ all -> 0x008b }
            r8.count = r0;	 Catch:{ all -> 0x008b }
            r8.unlock();
            return r5;
        L_0x008b:
            r9 = move-exception;
            r8.unlock();
            throw r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.a(java.lang.Object, int, java.lang.Object, boolean):V");
        }

        void expand() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray aE = aE(length << 1);
                this.threshold = (aE.length() * 3) / 4;
                int length2 = aE.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    g gVar = (g) atomicReferenceArray.get(i2);
                    if (gVar != null) {
                        g tW = gVar.tW();
                        int hash = gVar.getHash() & length2;
                        if (tW == null) {
                            aE.set(hash, gVar);
                        } else {
                            g gVar2 = gVar;
                            while (tW != null) {
                                int hash2 = tW.getHash() & length2;
                                if (hash2 != hash) {
                                    gVar2 = tW;
                                    hash = hash2;
                                }
                                tW = tW.tW();
                            }
                            aE.set(hash, gVar2);
                            while (gVar != gVar2) {
                                int hash3 = gVar.getHash() & length2;
                                g a = a(gVar, (g) aE.get(hash3));
                                if (a != null) {
                                    aE.set(hash3, a);
                                } else {
                                    i--;
                                }
                                gVar = gVar.tW();
                            }
                        }
                    }
                }
                this.table = aE;
                this.count = i;
            }
        }

        boolean a(K k, int i, V v, V v2) {
            lock();
            try {
                ue();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.tW()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.f(k, key)) {
                        Object value = gVar2.getValue();
                        if (value == null) {
                            if (d(gVar2)) {
                                int i2 = this.count;
                                this.modCount++;
                                i = this.count - 1;
                                atomicReferenceArray.set(length, b(gVar, gVar2));
                                this.count = i;
                            }
                            unlock();
                            return false;
                        } else if (this.map.tT().f(v, value)) {
                            this.modCount++;
                            a(gVar2, (Object) v2);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } catch (Throwable th) {
                unlock();
            }
        }

        V a(K k, int i, V v) {
            lock();
            try {
                ue();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.tW()) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.f(k, key)) {
                        V value = gVar2.getValue();
                        if (value == null) {
                            if (d(gVar2)) {
                                int i2 = this.count;
                                this.modCount++;
                                i = this.count - 1;
                                atomicReferenceArray.set(length, b(gVar, gVar2));
                                this.count = i;
                            }
                            unlock();
                            return null;
                        }
                        this.modCount++;
                        a(gVar2, (Object) v);
                        unlock();
                        return value;
                    }
                }
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
            }
        }

        V c(Object obj, int i) {
            lock();
            try {
                ue();
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                g gVar2 = gVar;
                while (gVar2 != null) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() == i && key != null && this.map.keyEquivalence.f(obj, key)) {
                        V value = gVar2.getValue();
                        if (value == null && !d(gVar2)) {
                            unlock();
                            return null;
                        }
                        this.modCount++;
                        g b = b(gVar, gVar2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, b);
                        this.count = i3;
                        return value;
                    }
                    gVar2 = gVar2.tW();
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARNING: Missing block: B:11:0x003f, code:
            if (r8.map.tT().f(r11, r4.getValue()) == false) goto L_0x0043;
     */
        /* JADX WARNING: Missing block: B:12:0x0041, code:
            r5 = true;
     */
        /* JADX WARNING: Missing block: B:14:0x0047, code:
            if (d(r4) == false) goto L_0x005e;
     */
        /* JADX WARNING: Missing block: B:15:0x0049, code:
            r8.modCount++;
            r10 = r8.count - 1;
            r0.set(r1, b(r3, r4));
            r8.count = r10;
     */
        /* JADX WARNING: Missing block: B:17:0x005e, code:
            unlock();
     */
        /* JADX WARNING: Missing block: B:18:0x0061, code:
            return r5;
     */
        boolean b(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
            r8 = this;
            r8.lock();
            r8.ue();	 Catch:{ all -> 0x006b }
            r0 = r8.count;	 Catch:{ all -> 0x006b }
            r0 = r8.table;	 Catch:{ all -> 0x006b }
            r1 = r0.length();	 Catch:{ all -> 0x006b }
            r2 = 1;
            r1 = r1 - r2;
            r1 = r1 & r10;
            r3 = r0.get(r1);	 Catch:{ all -> 0x006b }
            r3 = (com.google.common.collect.MapMakerInternalMap.g) r3;	 Catch:{ all -> 0x006b }
            r4 = r3;
        L_0x0018:
            r5 = 0;
            if (r4 == 0) goto L_0x0067;
        L_0x001b:
            r6 = r4.getKey();	 Catch:{ all -> 0x006b }
            r7 = r4.getHash();	 Catch:{ all -> 0x006b }
            if (r7 != r10) goto L_0x0062;
        L_0x0025:
            if (r6 == 0) goto L_0x0062;
        L_0x0027:
            r7 = r8.map;	 Catch:{ all -> 0x006b }
            r7 = r7.keyEquivalence;	 Catch:{ all -> 0x006b }
            r6 = r7.f(r9, r6);	 Catch:{ all -> 0x006b }
            if (r6 == 0) goto L_0x0062;
        L_0x0031:
            r9 = r4.getValue();	 Catch:{ all -> 0x006b }
            r10 = r8.map;	 Catch:{ all -> 0x006b }
            r10 = r10.tT();	 Catch:{ all -> 0x006b }
            r9 = r10.f(r11, r9);	 Catch:{ all -> 0x006b }
            if (r9 == 0) goto L_0x0043;
        L_0x0041:
            r5 = 1;
            goto L_0x0049;
        L_0x0043:
            r9 = d(r4);	 Catch:{ all -> 0x006b }
            if (r9 == 0) goto L_0x005e;
        L_0x0049:
            r9 = r8.modCount;	 Catch:{ all -> 0x006b }
            r9 = r9 + r2;
            r8.modCount = r9;	 Catch:{ all -> 0x006b }
            r9 = r8.b(r3, r4);	 Catch:{ all -> 0x006b }
            r10 = r8.count;	 Catch:{ all -> 0x006b }
            r10 = r10 - r2;
            r0.set(r1, r9);	 Catch:{ all -> 0x006b }
            r8.count = r10;	 Catch:{ all -> 0x006b }
            r8.unlock();
            return r5;
        L_0x005e:
            r8.unlock();
            return r5;
        L_0x0062:
            r4 = r4.tW();	 Catch:{ all -> 0x006b }
            goto L_0x0018;
        L_0x0067:
            r8.unlock();
            return r5;
        L_0x006b:
            r9 = move-exception;
            r8.unlock();
            throw r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.b(java.lang.Object, int, java.lang.Object):boolean");
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    ud();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        E b(E e, E e2) {
            int i = this.count;
            E tW = e2.tW();
            g e3;
            while (e3 != e2) {
                E a = a(e3, (g) tW);
                if (a != null) {
                    tW = a;
                } else {
                    i--;
                }
                e3 = e3.tW();
            }
            this.count = i;
            return tW;
        }

        boolean a(E e, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                boolean z = true;
                i &= atomicReferenceArray.length() - z;
                g gVar = (g) atomicReferenceArray.get(i);
                for (g gVar2 = gVar; gVar2 != null; gVar2 = gVar2.tW()) {
                    if (gVar2 == e) {
                        this.modCount += z;
                        g b = b(gVar, gVar2);
                        int i3 = this.count - z;
                        atomicReferenceArray.set(i, b);
                        this.count = i3;
                        return z;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        boolean a(K k, int i, t<K, V, E> tVar) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - z) & i;
                g gVar = (g) atomicReferenceArray.get(length);
                g gVar2 = gVar;
                while (gVar2 != null) {
                    Object key = gVar2.getKey();
                    if (gVar2.getHash() != i || key == null || !this.map.keyEquivalence.f(k, key)) {
                        gVar2 = gVar2.tW();
                    } else if (((s) gVar2).uj() == tVar) {
                        this.modCount += z;
                        i = this.count - z;
                        atomicReferenceArray.set(length, b(gVar, gVar2));
                        this.count = i;
                        return z;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        static <K, V, E extends g<K, V, E>> boolean d(E e) {
            return e.getValue() == null;
        }

        V b(E e) {
            if (e.getKey() == null) {
                rf();
                return null;
            }
            V value = e.getValue();
            if (value != null) {
                return value;
            }
            rf();
            return null;
        }

        void ro() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                uf();
            }
        }

        void ue() {
            ug();
        }

        void uf() {
            ug();
        }

        void ug() {
            if (tryLock()) {
                try {
                    uc();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }
    }

    enum Strength {
        STRONG {
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.pK();
            }
        },
        WEAK {
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.pL();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();
    }

    abstract class f<T> implements Iterator<T> {
        int OB;
        int OC = -1;
        AtomicReferenceArray<E> OE;
        Segment<K, V, E, S> RX;
        E RY;
        v RZ;
        v Sa;

        f() {
            this.OB = MapMakerInternalMap.this.RN.length - 1;
            advance();
        }

        final void advance() {
            this.RZ = null;
            if (!ra() && !rb()) {
                while (this.OB >= 0) {
                    Segment[] segmentArr = MapMakerInternalMap.this.RN;
                    int i = this.OB;
                    this.OB = i - 1;
                    this.RX = segmentArr[i];
                    if (this.RX.count != 0) {
                        this.OE = this.RX.table;
                        this.OC = this.OE.length() - 1;
                        if (rb()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean ra() {
            if (this.RY != null) {
                do {
                    this.RY = this.RY.tW();
                    if (this.RY != null) {
                    }
                } while (!c(this.RY));
                return true;
            }
            return false;
        }

        boolean rb() {
            while (this.OC >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.OE;
                int i = this.OC;
                this.OC = i - 1;
                g gVar = (g) atomicReferenceArray.get(i);
                this.RY = gVar;
                if (gVar != null && (c(this.RY) || ra())) {
                    return true;
                }
            }
            return false;
        }

        boolean c(E e) {
            try {
                Object key = e.getKey();
                Object b = MapMakerInternalMap.this.b(e);
                if (b != null) {
                    this.RZ = new v(key, b);
                    return true;
                }
                this.RX.ro();
                return false;
            } finally {
                this.RX.ro();
            }
        }

        public boolean hasNext() {
            return this.RZ != null;
        }

        v tY() {
            if (this.RZ == null) {
                throw new NoSuchElementException();
            }
            this.Sa = this.RZ;
            advance();
            return this.Sa;
        }

        public void remove() {
            g.ac(this.Sa != null);
            MapMakerInternalMap.this.remove(this.Sa.getKey());
            this.Sa = null;
        }
    }

    interface g<K, V, E extends g<K, V, E>> {
        int getHash();

        K getKey();

        V getValue();

        E tW();
    }

    interface h<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        E a(S s, E e, E e2);

        E a(S s, K k, int i, E e);

        void a(S s, E e, V v);

        Strength tZ();

        Strength ua();
    }

    private static abstract class k<E> extends AbstractSet<E> {
        private k() {
        }

        /* synthetic */ k(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.f(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.f(this).toArray(tArr);
        }
    }

    final class p extends AbstractCollection<V> {
        p() {
        }

        public Iterator<V> iterator() {
            return new o();
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.f(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.f(this).toArray(tArr);
        }
    }

    interface t<K, V, E extends g<K, V, E>> {
        t<K, V, E> a(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        V get();

        E tV();
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
        /* renamed from: ui */
        StrongKeyStrongValueSegment<K, V> ub() {
            return this;
        }

        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue();

        /* renamed from: ul */
        StrongKeyWeakValueSegment<K, V> ub() {
            return this;
        }

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        void uc() {
            b(this.queueForValues);
        }

        void ud() {
            c(this.queueForValues);
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();

        /* renamed from: un */
        WeakKeyStrongValueSegment<K, V> ub() {
            return this;
        }

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        void uc() {
            a(this.queueForKeys);
        }

        void ud() {
            c(this.queueForKeys);
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue();

        /* renamed from: up */
        WeakKeyWeakValueSegment<K, V> ub() {
            return this;
        }

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        void uc() {
            a(this.queueForKeys);
            b(this.queueForValues);
        }

        void ud() {
            c(this.queueForKeys);
        }
    }

    static abstract class a<K, V, E extends g<K, V, E>> implements g<K, V, E> {
        final E RT;
        final int hash;
        final K key;

        a(K k, int i, E e) {
            this.key = k;
            this.hash = i;
            this.RT = e;
        }

        public K getKey() {
            return this.key;
        }

        public int getHash() {
            return this.hash;
        }

        public E tW() {
            return this.RT;
        }
    }

    static abstract class b<K, V, E extends g<K, V, E>> extends WeakReference<K> implements g<K, V, E> {
        final E RT;
        final int hash;

        b(ReferenceQueue<K> referenceQueue, K k, int i, E e) {
            super(k, referenceQueue);
            this.hash = i;
            this.RT = e;
        }

        public K getKey() {
            return get();
        }

        public int getHash() {
            return this.hash;
        }

        public E tW() {
            return this.RT;
        }
    }

    static final class c implements g<Object, Object, c> {
        private c() {
            throw new AssertionError();
        }

        /* renamed from: tX */
        public c tW() {
            throw new AssertionError();
        }

        public int getHash() {
            throw new AssertionError();
        }

        public Object getKey() {
            throw new AssertionError();
        }

        public Object getValue() {
            throw new AssertionError();
        }
    }

    final class d extends f<Entry<K, V>> {
        d() {
            super();
        }

        public Entry<K, V> next() {
            return tY();
        }
    }

    final class e extends k<Entry<K, V>> {
        e() {
            super();
        }

        public Iterator<Entry<K, V>> iterator() {
            return new d();
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                return false;
            }
            key = MapMakerInternalMap.this.get(key);
            if (key != null && MapMakerInternalMap.this.tT().f(entry.getValue(), key)) {
                z = true;
            }
            return z;
        }

        public boolean remove(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key != null && MapMakerInternalMap.this.remove(key, entry.getValue())) {
                z = true;
            }
            return z;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    final class i extends f<K> {
        i() {
            super();
        }

        public K next() {
            return tY().getKey();
        }
    }

    final class j extends k<K> {
        j() {
            super();
        }

        public Iterator<K> iterator() {
            return new i();
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    interface n extends g {
    }

    final class o extends f<V> {
        o() {
            super();
        }

        public V next() {
            return tY().getValue();
        }
    }

    interface s<K, V, E extends g<K, V, E>> extends g<K, V, E> {
        t<K, V, E> uj();
    }

    static final class u<K, V, E extends g<K, V, E>> extends WeakReference<V> implements t<K, V, E> {
        final E Sg;

        u(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.Sg = e;
        }

        public E tV() {
            return this.Sg;
        }

        public t<K, V, E> a(ReferenceQueue<V> referenceQueue, E e) {
            return new u(referenceQueue, get(), e);
        }
    }

    final class v extends b<K, V> {
        final K key;
        V value;

        v(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public V setValue(V v) {
            V put = MapMakerInternalMap.this.put(this.key, v);
            this.value = v;
            return put;
        }
    }

    static final class l<K, V> extends a<K, V, l<K, V>> implements n<K, V, l<K, V>> {
        private volatile V value = null;

        static final class a<K, V> implements h<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> Sb = new a();

            a() {
            }

            static <K, V> a<K, V> uh() {
                return Sb;
            }

            public Strength tZ() {
                return Strength.STRONG;
            }

            public Strength ua() {
                return Strength.STRONG;
            }

            /* renamed from: b */
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            public l<K, V> a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, l<K, V> lVar2) {
                return lVar.a(lVar2);
            }

            public void a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, V v) {
                lVar.setValue(v);
            }

            public l<K, V> a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, l<K, V> lVar) {
                return new l(k, i, lVar);
            }
        }

        l(K k, int i, l<K, V> lVar) {
            super(k, i, lVar);
        }

        public V getValue() {
            return this.value;
        }

        void setValue(V v) {
            this.value = v;
        }

        l<K, V> a(l<K, V> lVar) {
            l<K, V> lVar2 = new l(this.key, this.hash, lVar);
            lVar2.value = this.value;
            return lVar2;
        }
    }

    static final class m<K, V> extends a<K, V, m<K, V>> implements s<K, V, m<K, V>> {
        private volatile t<K, V, m<K, V>> Sc = MapMakerInternalMap.tS();

        static final class a<K, V> implements h<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> Sd = new a();

            a() {
            }

            static <K, V> a<K, V> uk() {
                return Sd;
            }

            public Strength tZ() {
                return Strength.STRONG;
            }

            public Strength ua() {
                return Strength.WEAK;
            }

            /* renamed from: c */
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            public m<K, V> a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, m<K, V> mVar2) {
                if (Segment.d(mVar)) {
                    return null;
                }
                return mVar.a(strongKeyWeakValueSegment.queueForValues, (m) mVar2);
            }

            public void a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, V v) {
                mVar.a((Object) v, strongKeyWeakValueSegment.queueForValues);
            }

            public m<K, V> a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, m<K, V> mVar) {
                return new m(k, i, mVar);
            }
        }

        m(K k, int i, m<K, V> mVar) {
            super(k, i, mVar);
        }

        public V getValue() {
            return this.Sc.get();
        }

        void a(V v, ReferenceQueue<V> referenceQueue) {
            t tVar = this.Sc;
            this.Sc = new u(referenceQueue, v, this);
            tVar.clear();
        }

        m<K, V> a(ReferenceQueue<V> referenceQueue, m<K, V> mVar) {
            m<K, V> mVar2 = new m(this.key, this.hash, mVar);
            mVar2.Sc = this.Sc.a(referenceQueue, mVar2);
            return mVar2;
        }

        public t<K, V, m<K, V>> uj() {
            return this.Sc;
        }
    }

    static final class q<K, V> extends b<K, V, q<K, V>> implements n<K, V, q<K, V>> {
        private volatile V value = null;

        static final class a<K, V> implements h<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> Se = new a();

            a() {
            }

            static <K, V> a<K, V> um() {
                return Se;
            }

            public Strength tZ() {
                return Strength.WEAK;
            }

            public Strength ua() {
                return Strength.STRONG;
            }

            /* renamed from: d */
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            public q<K, V> a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, q<K, V> qVar2) {
                if (qVar.getKey() == null) {
                    return null;
                }
                return qVar.a(weakKeyStrongValueSegment.queueForKeys, qVar2);
            }

            public void a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v) {
                qVar.setValue(v);
            }

            public q<K, V> a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, q<K, V> qVar) {
                return new q(weakKeyStrongValueSegment.queueForKeys, k, i, qVar);
            }
        }

        q(ReferenceQueue<K> referenceQueue, K k, int i, q<K, V> qVar) {
            super(referenceQueue, k, i, qVar);
        }

        public V getValue() {
            return this.value;
        }

        void setValue(V v) {
            this.value = v;
        }

        q<K, V> a(ReferenceQueue<K> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q(referenceQueue, getKey(), this.hash, qVar);
            qVar2.setValue(this.value);
            return qVar2;
        }
    }

    static final class r<K, V> extends b<K, V, r<K, V>> implements s<K, V, r<K, V>> {
        private volatile t<K, V, r<K, V>> Sc = MapMakerInternalMap.tS();

        static final class a<K, V> implements h<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> Sf = new a();

            a() {
            }

            static <K, V> a<K, V> uo() {
                return Sf;
            }

            public Strength tZ() {
                return Strength.WEAK;
            }

            public Strength ua() {
                return Strength.WEAK;
            }

            /* renamed from: e */
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            public r<K, V> a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, r<K, V> rVar2) {
                if (rVar.getKey() == null || Segment.d(rVar)) {
                    return null;
                }
                return rVar.a(weakKeyWeakValueSegment.queueForKeys, weakKeyWeakValueSegment.queueForValues, rVar2);
            }

            public void a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v) {
                rVar.a(v, weakKeyWeakValueSegment.queueForValues);
            }

            public r<K, V> a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, r<K, V> rVar) {
                return new r(weakKeyWeakValueSegment.queueForKeys, k, i, rVar);
            }
        }

        r(ReferenceQueue<K> referenceQueue, K k, int i, r<K, V> rVar) {
            super(referenceQueue, k, i, rVar);
        }

        public V getValue() {
            return this.Sc.get();
        }

        r<K, V> a(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, r<K, V> rVar) {
            r<K, V> rVar2 = new r(referenceQueue, getKey(), this.hash, rVar);
            rVar2.Sc = this.Sc.a(referenceQueue2, rVar2);
            return rVar2;
        }

        void a(V v, ReferenceQueue<V> referenceQueue) {
            t tVar = this.Sc;
            this.Sc = new u(referenceQueue, v, this);
            tVar.clear();
        }

        public t<K, V, r<K, V>> uj() {
            return this.Sc;
        }
    }

    static abstract class AbstractSerializationProxy<K, V> extends k<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        transient ConcurrentMap<K, V> RR;
        final int concurrencyLevel;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.RR = concurrentMap;
        }

        /* renamed from: sC */
        protected ConcurrentMap<K, V> sD() {
            return this.RR;
        }

        void a(ObjectOutputStream objectOutputStream) {
            objectOutputStream.writeInt(this.RR.size());
            for (Entry entry : this.RR.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        u a(ObjectInputStream objectInputStream) {
            return new u().ba(objectInputStream.readInt()).a(this.keyStrength).b(this.valueStrength).c(this.keyEquivalence).bb(this.concurrencyLevel);
        }

        void b(ObjectInputStream objectInputStream) {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.RR.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            a(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.RR = a(objectInputStream).tR();
            b(objectInputStream);
        }

        private Object readResolve() {
            return this.RR;
        }
    }

    static int aB(int i) {
        i += (i << 15) ^ -12931;
        i ^= i >>> 10;
        i += i << 3;
        i ^= i >>> 6;
        i += (i << 2) + (i << 14);
        return i ^ (i >>> 16);
    }

    private MapMakerInternalMap(u uVar, h<K, V, E, S> hVar) {
        this.concurrencyLevel = Math.min(uVar.ql(), 65536);
        this.keyEquivalence = uVar.qi();
        this.RP = hVar;
        int min = Math.min(uVar.qk(), 1073741824);
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.concurrencyLevel) {
            i3++;
            i2 <<= 1;
        }
        this.Oj = 32 - i3;
        this.Oi = i2 - 1;
        this.RN = bd(i2);
        i3 = min / i2;
        if (i2 * i3 < min) {
            i3++;
        }
        while (i < i3) {
            i <<= 1;
        }
        for (int i4 = 0; i4 < this.RN.length; i4++) {
            this.RN[i4] = A(i, -1);
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends g<K, V, ?>, ?> a(u uVar) {
        if (uVar.tP() == Strength.STRONG && uVar.tQ() == Strength.STRONG) {
            return new MapMakerInternalMap(uVar, a.uh());
        }
        if (uVar.tP() == Strength.STRONG && uVar.tQ() == Strength.WEAK) {
            return new MapMakerInternalMap(uVar, a.uk());
        }
        if (uVar.tP() == Strength.WEAK && uVar.tQ() == Strength.STRONG) {
            return new MapMakerInternalMap(uVar, a.um());
        }
        if (uVar.tP() == Strength.WEAK && uVar.tQ() == Strength.WEAK) {
            return new MapMakerInternalMap(uVar, a.uo());
        }
        throw new AssertionError();
    }

    static <K, V, E extends g<K, V, E>> t<K, V, E> tS() {
        return RQ;
    }

    int hash(Object obj) {
        return aB(this.keyEquivalence.hash(obj));
    }

    void a(t<K, V, E> tVar) {
        g tV = tVar.tV();
        int hash = tV.getHash();
        bc(hash).a(tV.getKey(), hash, (t) tVar);
    }

    void a(E e) {
        int hash = e.getHash();
        bc(hash).a((g) e, hash);
    }

    Segment<K, V, E, S> bc(int i) {
        return this.RN[(i >>> this.Oj) & this.Oi];
    }

    Segment<K, V, E, S> A(int i, int i2) {
        return this.RP.a(this, i, i2);
    }

    V b(E e) {
        if (e.getKey() == null) {
            return null;
        }
        V value = e.getValue();
        if (value == null) {
            return null;
        }
        return value;
    }

    final Segment<K, V, E, S>[] bd(int i) {
        return new Segment[i];
    }

    Equivalence<Object> tT() {
        return this.RP.ua().defaultEquivalence();
    }

    public boolean isEmpty() {
        Segment[] segmentArr = this.RN;
        long j = 0;
        int i = 0;
        while (i < segmentArr.length) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            i++;
            j += (long) segmentArr[i].modCount;
        }
        if (j != 0) {
            i = 0;
            while (i < segmentArr.length) {
                if (segmentArr[i].count != 0) {
                    return false;
                }
                i++;
                j -= (long) segmentArr[i].modCount;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        Segment[] segmentArr = this.RN;
        long j = 0;
        int i = 0;
        while (i < segmentArr.length) {
            i++;
            j += (long) segmentArr[i].count;
        }
        return Ints.I(j);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return bc(hash).get(obj, hash);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return bc(hash).b(obj, hash);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        Segment[] segmentArr = this.RN;
        long j = -1;
        while (0 < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            int i = 0;
            while (i < length) {
                Segment segment = segmentArr[i];
                int i2 = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                while (0 < atomicReferenceArray.length()) {
                    for (g gVar = (g) atomicReferenceArray.get(0); gVar != null; gVar = gVar.tW()) {
                        Object b = segment.b(gVar);
                        if (b != null && tT().f(obj2, b)) {
                            return true;
                        }
                    }
                    int i3 = 0 + 1;
                }
                i++;
                j2 += (long) segment.modCount;
            }
            if (j2 == j) {
                break;
            }
            int i4 = 0 + 1;
            j = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return bc(hash).a((Object) k, hash, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return bc(hash).a((Object) k, hash, (Object) v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return bc(hash).c(obj, hash);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return bc(hash).b(obj, hash, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return bc(hash).a((Object) k, hash, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return bc(hash).a((Object) k, hash, (Object) v);
    }

    public void clear() {
        for (Segment clear : this.RN) {
            clear.clear();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.Os;
        if (set != null) {
            return set;
        }
        set = new j();
        this.Os = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.Ot;
        if (collection != null) {
            return collection;
        }
        collection = new p();
        this.Ot = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.Ou;
        if (set != null) {
            return set;
        }
        set = new e();
        this.Ou = set;
        return set;
    }

    private static <E> ArrayList<E> f(Collection<E> collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    Object writeReplace() {
        return new SerializationProxy(this.RP.tZ(), this.RP.ua(), this.keyEquivalence, this.RP.ua().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
