package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final q<Object, Object> Oq = new q<Object, Object>() {
        public void N(Object obj) {
        }

        public q<Object, Object> a(ReferenceQueue<Object> referenceQueue, Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public int getWeight() {
            return 0;
        }

        public boolean isActive() {
            return false;
        }

        public ReferenceEntry<Object, Object> qV() {
            return null;
        }

        public boolean qW() {
            return false;
        }

        public Object qX() {
            return null;
        }
    };
    static final Queue<?> Or = new AbstractQueue<Object>() {
        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }

        public Iterator<Object> iterator() {
            return ImmutableSet.tq().iterator();
        }
    };
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    final long Oa;
    final int Oi;
    final int Oj;
    final Segment<K, V>[] Ok;
    final Queue<RemovalNotification<K, V>> Ol;
    final EntryFactory Om;
    final com.google.common.cache.a.b Oo;
    final CacheLoader<? super K, V> Op;
    Set<K> Os;
    Collection<V> Ot;
    Set<Entry<K, V>> Ou;
    final int concurrencyLevel;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    final Strength keyStrength;
    final long maxWeight;
    final g<K, V> removalListener;
    final com.google.common.base.p ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    final h<K, V> weigher;

    enum EntryFactory {
        STRONG {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new m(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new k(k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_WRITE {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new o(k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_ACCESS_WRITE {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new l(k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new u(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new s(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_WRITE {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new w(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_ACCESS_WRITE {
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new t(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        
        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = null;

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry);

        static {
            factories = new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            int i = 0;
            int i2 = (strength == Strength.WEAK ? 4 : 0) | z;
            if (z2) {
                i = 2;
            }
            return factories[i2 | i];
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.a(referenceEntry.getPreviousInAccessQueue(), (ReferenceEntry) referenceEntry2);
            LocalCache.a((ReferenceEntry) referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.b(referenceEntry);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.b(referenceEntry.getPreviousInWriteQueue(), (ReferenceEntry) referenceEntry2);
            LocalCache.b((ReferenceEntry) referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.c(referenceEntry);
        }
    }

    interface ReferenceEntry<K, V> {
        long getAccessTime();

        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextInAccessQueue();

        ReferenceEntry<K, V> getNextInWriteQueue();

        ReferenceEntry<K, V> getPreviousInAccessQueue();

        ReferenceEntry<K, V> getPreviousInWriteQueue();

        q<K, V> getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(q<K, V> qVar);

        void setWriteTime(long j);
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final com.google.common.cache.a.b statsCounter;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, com.google.common.cache.a.b bVar) {
            Queue concurrentLinkedQueue;
            Queue cVar;
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (com.google.common.cache.a.b) com.google.common.base.i.checkNotNull(bVar);
            a(aE(i));
            ReferenceQueue referenceQueue = null;
            this.keyReferenceQueue = localCache.qO() ? new ReferenceQueue() : null;
            if (localCache.qP()) {
                referenceQueue = new ReferenceQueue();
            }
            this.valueReferenceQueue = referenceQueue;
            if (localCache.qH()) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
            } else {
                concurrentLinkedQueue = LocalCache.qS();
            }
            this.recencyQueue = concurrentLinkedQueue;
            if (localCache.qI()) {
                concurrentLinkedQueue = new aa();
            } else {
                concurrentLinkedQueue = LocalCache.qS();
            }
            this.writeQueue = concurrentLinkedQueue;
            if (localCache.qH()) {
                cVar = new c();
            } else {
                cVar = LocalCache.qS();
            }
            this.accessQueue = cVar;
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> aE(int i) {
            return new AtomicReferenceArray(i);
        }

        void a(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.qD() && ((long) this.threshold) == this.maxSegmentWeight) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        ReferenceEntry<K, V> a(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            return this.map.Om.newEntry(this, com.google.common.base.i.checkNotNull(k), i, referenceEntry);
        }

        ReferenceEntry<K, V> c(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            q valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && valueReference.isActive()) {
                return null;
            }
            referenceEntry = this.map.Om.copyEntry(this, referenceEntry, referenceEntry2);
            referenceEntry.setValueReference(valueReference.a(this.valueReferenceQueue, obj, referenceEntry));
            return referenceEntry;
        }

        void a(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            q valueReference = referenceEntry.getValueReference();
            int weigh = this.map.weigher.weigh(k, v);
            com.google.common.base.i.a(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v, weigh));
            a((ReferenceEntry) referenceEntry, weigh, j);
            valueReference.N(v);
        }

        V a(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            com.google.common.base.i.checkNotNull(k);
            com.google.common.base.i.checkNotNull(cacheLoader);
            try {
                V a;
                if (this.count != 0) {
                    ReferenceEntry a2 = a((Object) k, i);
                    if (a2 != null) {
                        long qd = this.map.ticker.qd();
                        Object a3 = a(a2, qd);
                        if (a3 != null) {
                            c(a2, qd);
                            this.statsCounter.ay(1);
                            a = a(a2, k, i, a3, qd, cacheLoader);
                            ro();
                            return a;
                        }
                        q valueReference = a2.getValueReference();
                        if (valueReference.qW()) {
                            a = a(a2, (Object) k, valueReference);
                            ro();
                            return a;
                        }
                    }
                }
                a = b((Object) k, i, (CacheLoader) cacheLoader);
                ro();
                return a;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw e;
                }
            } catch (Throwable th) {
                ro();
            }
        }

        /*  JADX ERROR: NullPointerException in pass: EliminatePhiNodes
            java.lang.NullPointerException
            */
        V b(K r20, int r21, com.google.common.cache.CacheLoader<? super K, V> r22) {
            /*
            r19 = this;
            r7 = r19;
            r8 = r20;
            r9 = r21;
            r19.lock();
            r1 = r7.map;	 Catch:{ all -> 0x00e5 }
            r1 = r1.ticker;	 Catch:{ all -> 0x00e5 }
            r1 = r1.qd();	 Catch:{ all -> 0x00e5 }
            r7.E(r1);	 Catch:{ all -> 0x00e5 }
            r3 = r7.count;	 Catch:{ all -> 0x00e5 }
            r10 = 1;	 Catch:{ all -> 0x00e5 }
            r11 = r3 + -1;	 Catch:{ all -> 0x00e5 }
            r12 = r7.table;	 Catch:{ all -> 0x00e5 }
            r3 = r12.length();	 Catch:{ all -> 0x00e5 }
            r3 = r3 - r10;	 Catch:{ all -> 0x00e5 }
            r13 = r9 & r3;	 Catch:{ all -> 0x00e5 }
            r3 = r12.get(r13);	 Catch:{ all -> 0x00e5 }
            r14 = r3;	 Catch:{ all -> 0x00e5 }
            r14 = (com.google.common.cache.LocalCache.ReferenceEntry) r14;	 Catch:{ all -> 0x00e5 }
            r15 = r14;	 Catch:{ all -> 0x00e5 }
        L_0x002a:
            r16 = 0;	 Catch:{ all -> 0x00e5 }
            if (r15 == 0) goto L_0x009f;	 Catch:{ all -> 0x00e5 }
        L_0x002e:
            r3 = r15.getKey();	 Catch:{ all -> 0x00e5 }
            r4 = r15.getHash();	 Catch:{ all -> 0x00e5 }
            if (r4 != r9) goto L_0x0099;	 Catch:{ all -> 0x00e5 }
        L_0x0038:
            if (r3 == 0) goto L_0x0099;	 Catch:{ all -> 0x00e5 }
        L_0x003a:
            r4 = r7.map;	 Catch:{ all -> 0x00e5 }
            r4 = r4.keyEquivalence;	 Catch:{ all -> 0x00e5 }
            r4 = r4.f(r8, r3);	 Catch:{ all -> 0x00e5 }
            if (r4 == 0) goto L_0x0099;	 Catch:{ all -> 0x00e5 }
        L_0x0044:
            r6 = r15.getValueReference();	 Catch:{ all -> 0x00e5 }
            r4 = r6.qW();	 Catch:{ all -> 0x00e5 }
            if (r4 == 0) goto L_0x0051;	 Catch:{ all -> 0x00e5 }
        L_0x004e:
            r1 = 0;	 Catch:{ all -> 0x00e5 }
            r10 = r6;	 Catch:{ all -> 0x00e5 }
            goto L_0x00a2;	 Catch:{ all -> 0x00e5 }
        L_0x0051:
            r4 = r6.get();	 Catch:{ all -> 0x00e5 }
            if (r4 != 0) goto L_0x0067;	 Catch:{ all -> 0x00e5 }
        L_0x0057:
            r5 = r6.getWeight();	 Catch:{ all -> 0x00e5 }
            r17 = com.google.common.cache.RemovalCause.COLLECTED;	 Catch:{ all -> 0x00e5 }
            r1 = r7;	 Catch:{ all -> 0x00e5 }
            r2 = r3;	 Catch:{ all -> 0x00e5 }
            r3 = r9;	 Catch:{ all -> 0x00e5 }
            r10 = r6;	 Catch:{ all -> 0x00e5 }
            r6 = r17;	 Catch:{ all -> 0x00e5 }
            r1.a(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00e5 }
            goto L_0x007c;	 Catch:{ all -> 0x00e5 }
        L_0x0067:
            r10 = r6;	 Catch:{ all -> 0x00e5 }
            r5 = r7.map;	 Catch:{ all -> 0x00e5 }
            r5 = r5.b(r15, r1);	 Catch:{ all -> 0x00e5 }
            if (r5 == 0) goto L_0x0089;	 Catch:{ all -> 0x00e5 }
        L_0x0070:
            r5 = r10.getWeight();	 Catch:{ all -> 0x00e5 }
            r6 = com.google.common.cache.RemovalCause.EXPIRED;	 Catch:{ all -> 0x00e5 }
            r1 = r7;	 Catch:{ all -> 0x00e5 }
            r2 = r3;	 Catch:{ all -> 0x00e5 }
            r3 = r9;	 Catch:{ all -> 0x00e5 }
            r1.a(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00e5 }
        L_0x007c:
            r1 = r7.writeQueue;	 Catch:{ all -> 0x00e5 }
            r1.remove(r15);	 Catch:{ all -> 0x00e5 }
            r1 = r7.accessQueue;	 Catch:{ all -> 0x00e5 }
            r1.remove(r15);	 Catch:{ all -> 0x00e5 }
            r7.count = r11;	 Catch:{ all -> 0x00e5 }
            goto L_0x00a1;	 Catch:{ all -> 0x00e5 }
        L_0x0089:
            r7.d(r15, r1);	 Catch:{ all -> 0x00e5 }
            r1 = r7.statsCounter;	 Catch:{ all -> 0x00e5 }
            r2 = 1;	 Catch:{ all -> 0x00e5 }
            r1.ay(r2);	 Catch:{ all -> 0x00e5 }
            r19.unlock();
            r19.rp();
            return r4;
        L_0x0099:
            r15 = r15.getNext();	 Catch:{ all -> 0x00e5 }
            r10 = 1;	 Catch:{ all -> 0x00e5 }
            goto L_0x002a;	 Catch:{ all -> 0x00e5 }
        L_0x009f:
            r10 = r16;	 Catch:{ all -> 0x00e5 }
        L_0x00a1:
            r1 = 1;	 Catch:{ all -> 0x00e5 }
        L_0x00a2:
            if (r1 == 0) goto L_0x00ba;	 Catch:{ all -> 0x00e5 }
        L_0x00a4:
            r2 = new com.google.common.cache.LocalCache$i;	 Catch:{ all -> 0x00e5 }
            r2.<init>();	 Catch:{ all -> 0x00e5 }
            if (r15 != 0) goto L_0x00b6;	 Catch:{ all -> 0x00e5 }
        L_0x00ab:
            r15 = r7.a(r8, r9, r14);	 Catch:{ all -> 0x00e5 }
            r15.setValueReference(r2);	 Catch:{ all -> 0x00e5 }
            r12.set(r13, r15);	 Catch:{ all -> 0x00e5 }
            goto L_0x00bc;	 Catch:{ all -> 0x00e5 }
        L_0x00b6:
            r15.setValueReference(r2);	 Catch:{ all -> 0x00e5 }
            goto L_0x00bc;
        L_0x00ba:
            r2 = r16;
        L_0x00bc:
            r19.unlock();
            r19.rp();
            if (r1 == 0) goto L_0x00e0;
        L_0x00c4:
            monitor-enter(r15);	 Catch:{ all -> 0x00d7 }
            r1 = r22;
            r1 = r7.a(r8, r9, r2, r1);	 Catch:{ all -> 0x00d3 }
            monitor-exit(r15);	 Catch:{ all -> 0x00d3 }
            r2 = r7.statsCounter;
            r3 = 1;
            r2.az(r3);
            return r1;
        L_0x00d3:
            r0 = move-exception;
            r1 = r0;
            monitor-exit(r15);	 Catch:{ all -> 0x00d3 }
            throw r1;	 Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r0 = move-exception;
            r1 = r0;
            r2 = r7.statsCounter;
            r3 = 1;
            r2.az(r3);
            throw r1;
        L_0x00e0:
            r1 = r7.a(r15, r8, r10);
            return r1;
        L_0x00e5:
            r0 = move-exception;
            r1 = r0;
            r19.unlock();
            r19.rp();
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.b(java.lang.Object, int, com.google.common.cache.CacheLoader):V");
        }

        V a(ReferenceEntry<K, V> referenceEntry, K k, q<K, V> qVar) {
            if (qVar.qW()) {
                com.google.common.base.i.b(Thread.holdsLock(referenceEntry) ^ true, "Recursive load of: %s", (Object) k);
                try {
                    V qVar2 = qVar2.qX();
                    if (qVar2 == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("CacheLoader returned null for key ");
                        stringBuilder.append(k);
                        stringBuilder.append(".");
                        throw new InvalidCacheLoadException(stringBuilder.toString());
                    }
                    c((ReferenceEntry) referenceEntry, this.map.ticker.qd());
                    return qVar2;
                } finally {
                    this.statsCounter.az(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        V a(K k, int i, i<K, V> iVar, CacheLoader<? super K, V> cacheLoader) {
            return a((Object) k, i, (i) iVar, iVar.b(k, cacheLoader));
        }

        com.google.common.util.concurrent.s<V> b(K k, int i, i<K, V> iVar, CacheLoader<? super K, V> cacheLoader) {
            com.google.common.util.concurrent.s<V> b = iVar.b(k, cacheLoader);
            final K k2 = k;
            final int i2 = i;
            final i<K, V> iVar2 = iVar;
            final com.google.common.util.concurrent.s<V> sVar = b;
            b.a(new Runnable() {
                public void run() {
                    try {
                        Segment.this.a(k2, i2, iVar2, sVar);
                    } catch (Throwable th) {
                        LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", th);
                        iVar2.h(th);
                    }
                }
            }, MoreExecutors.vV());
            return b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
        V a(K r4, int r5, com.google.common.cache.LocalCache.i<K, V> r6, com.google.common.util.concurrent.s<V> r7) {
            /*
            r3 = this;
            r7 = com.google.common.util.concurrent.ab.c(r7);	 Catch:{ all -> 0x003f }
            if (r7 != 0) goto L_0x0024;
        L_0x0006:
            r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException;	 Catch:{ all -> 0x0022 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0022 }
            r1.<init>();	 Catch:{ all -> 0x0022 }
            r2 = "CacheLoader returned null for key ";
            r1.append(r2);	 Catch:{ all -> 0x0022 }
            r1.append(r4);	 Catch:{ all -> 0x0022 }
            r2 = ".";
            r1.append(r2);	 Catch:{ all -> 0x0022 }
            r1 = r1.toString();	 Catch:{ all -> 0x0022 }
            r0.<init>(r1);	 Catch:{ all -> 0x0022 }
            throw r0;	 Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception;
            goto L_0x0041;
        L_0x0024:
            r0 = r3.statsCounter;	 Catch:{ all -> 0x0022 }
            r1 = r6.pZ();	 Catch:{ all -> 0x0022 }
            r0.y(r1);	 Catch:{ all -> 0x0022 }
            r3.a(r4, r5, r6, r7);	 Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x003e;
        L_0x0032:
            r0 = r3.statsCounter;
            r1 = r6.pZ();
            r0.z(r1);
            r3.a(r4, r5, r6);
        L_0x003e:
            return r7;
        L_0x003f:
            r0 = move-exception;
            r7 = 0;
        L_0x0041:
            if (r7 != 0) goto L_0x004f;
        L_0x0043:
            r7 = r3.statsCounter;
            r1 = r6.pZ();
            r7.z(r1);
            r3.a(r4, r5, r6);
        L_0x004f:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a(java.lang.Object, int, com.google.common.cache.LocalCache$i, com.google.common.util.concurrent.s):V");
        }

        V a(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            if (this.map.qG() && j - referenceEntry.getWriteTime() > this.map.Oa && !referenceEntry.getValueReference().qW()) {
                V a = a((Object) k, i, (CacheLoader) cacheLoader, true);
                if (a != null) {
                    return a;
                }
            }
            return v;
        }

        V a(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            i a = a((Object) k, i, z);
            if (a == null) {
                return null;
            }
            Future b = b(k, i, a, cacheLoader);
            if (b.isDone()) {
                try {
                    return com.google.common.util.concurrent.ab.c(b);
                } catch (Throwable unused) {
                    return null;
                }
            }
        }

        i<K, V> a(K k, int i, boolean z) {
            lock();
            try {
                long qd = this.map.ticker.qd();
                E(qd);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.f(k, key)) {
                        q valueReference = referenceEntry2.getValueReference();
                        if (valueReference.qW() || (z && qd - referenceEntry2.getWriteTime() < this.map.Oa)) {
                            unlock();
                            rp();
                            return null;
                        }
                        this.modCount++;
                        i<K, V> i2 = new i(valueReference);
                        referenceEntry2.setValueReference(i2);
                        return i2;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                this.modCount++;
                Object iVar = new i();
                ReferenceEntry a = a((Object) k, i2, referenceEntry);
                a.setValueReference(iVar);
                atomicReferenceArray.set(length, a);
                unlock();
                rp();
                return iVar;
            } finally {
                unlock();
                rp();
            }
        }

        void rf() {
            if (tryLock()) {
                try {
                    rg();
                } finally {
                    unlock();
                }
            }
        }

        void rg() {
            if (this.map.qO()) {
                rh();
            }
            if (this.map.qP()) {
                ri();
            }
        }

        void rh() {
            int i = 0;
            do {
                Reference poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.a((ReferenceEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        void ri() {
            int i = 0;
            do {
                Reference poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.a((q) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        void rj() {
            if (this.map.qO()) {
                rk();
            }
            if (this.map.qP()) {
                rl();
            }
        }

        void rk() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void rl() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        void c(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.qK()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        void d(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.qK()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        void a(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            rm();
            this.totalWeight += (long) i;
            if (this.map.qK()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.qJ()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        void rm() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.recencyQueue.poll();
                if (referenceEntry == null) {
                    return;
                }
                if (this.accessQueue.contains(referenceEntry)) {
                    this.accessQueue.add(referenceEntry);
                }
            }
        }

        void C(long j) {
            if (tryLock()) {
                try {
                    D(j);
                } finally {
                    unlock();
                }
            }
        }

        void D(long j) {
            rm();
            ReferenceEntry referenceEntry;
            do {
                referenceEntry = (ReferenceEntry) this.writeQueue.peek();
                if (referenceEntry == null || !this.map.b(referenceEntry, j)) {
                    do {
                        referenceEntry = (ReferenceEntry) this.accessQueue.peek();
                        if (referenceEntry == null || !this.map.b(referenceEntry, j)) {
                            return;
                        }
                    } while (a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        void a(K k, int i, V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.qf();
            }
            if (this.map.Ol != LocalCache.Or) {
                this.map.Ol.offer(RemovalNotification.a(k, v, removalCause));
            }
        }

        void g(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.qC()) {
                rm();
                if (((long) referenceEntry.getValueReference().getWeight()) <= this.maxSegmentWeight || a((ReferenceEntry) referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry rn = rn();
                        if (!a(rn, rn.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        ReferenceEntry<K, V> rn() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        ReferenceEntry<K, V> aF(int i) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            return (ReferenceEntry) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        ReferenceEntry<K, V> a(Object obj, int i) {
            for (ReferenceEntry<K, V> aF = aF(i); aF != null; aF = aF.getNext()) {
                if (aF.getHash() == i) {
                    Object key = aF.getKey();
                    if (key == null) {
                        rf();
                    } else if (this.map.keyEquivalence.f(obj, key)) {
                        return aF;
                    }
                }
            }
            return null;
        }

        ReferenceEntry<K, V> a(Object obj, int i, long j) {
            ReferenceEntry a = a(obj, i);
            if (a == null) {
                return null;
            }
            if (!this.map.b(a, j)) {
                return a;
            }
            C(j);
            return null;
        }

        V a(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                rf();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                rf();
                return null;
            } else if (!this.map.b((ReferenceEntry) referenceEntry, j)) {
                return v;
            } else {
                C(j);
                return null;
            }
        }

        V get(Object obj, int i) {
            try {
                V v = null;
                if (this.count != 0) {
                    long qd = this.map.ticker.qd();
                    ReferenceEntry a = a(obj, i, qd);
                    if (a == null) {
                        return v;
                    }
                    Object obj2 = a.getValueReference().get();
                    if (obj2 != null) {
                        c(a, qd);
                        V a2 = a(a, a.getKey(), i, obj2, qd, this.map.Op);
                        ro();
                        return a2;
                    }
                    rf();
                }
                ro();
                return v;
            } finally {
                ro();
            }
        }

        boolean b(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    ReferenceEntry a = a(obj, i, this.map.ticker.qd());
                    if (a == null) {
                        return z;
                    }
                    if (a.getValueReference().get() != null) {
                        z = true;
                    }
                    ro();
                    return z;
                }
                ro();
                return z;
            } finally {
                ro();
            }
        }

        V a(K k, int i, V v, boolean z) {
            Object obj = k;
            int i2 = i;
            lock();
            try {
                int i3;
                ReferenceEntry referenceEntry;
                long qd = this.map.ticker.qd();
                E(qd);
                if (this.count + 1 > this.threshold) {
                    expand();
                    i3 = this.count;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    Object key = referenceEntry.getKey();
                    if (referenceEntry.getHash() == i2 && key != null && this.map.keyEquivalence.f(obj, key)) {
                        q valueReference = referenceEntry.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 == null) {
                            this.modCount++;
                            if (valueReference.isActive()) {
                                a(obj, i2, v2, valueReference.getWeight(), RemovalCause.COLLECTED);
                                a(referenceEntry, obj, (Object) v, qd);
                                i3 = this.count;
                            } else {
                                a(referenceEntry, obj, (Object) v, qd);
                                i3 = this.count + 1;
                            }
                            this.count = i3;
                            g(referenceEntry);
                            unlock();
                            rp();
                            return null;
                        } else if (z) {
                            d(referenceEntry, qd);
                            unlock();
                            rp();
                            return v2;
                        } else {
                            this.modCount++;
                            a(obj, i2, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                            a(referenceEntry, obj, (Object) v, qd);
                            g(referenceEntry);
                            unlock();
                            rp();
                            return v2;
                        }
                    }
                }
                this.modCount++;
                referenceEntry = a(obj, i2, referenceEntry2);
                a(referenceEntry, obj, (Object) v, qd);
                atomicReferenceArray.set(length, referenceEntry);
                this.count++;
                g(referenceEntry);
                unlock();
                rp();
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                unlock();
                rp();
            }
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
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            aE.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            aE.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry c = c(referenceEntry, (ReferenceEntry) aE.get(hash3));
                                if (c != null) {
                                    aE.set(hash3, c);
                                } else {
                                    h(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = aE;
                this.count = i;
            }
        }

        boolean a(K k, int i, V v, V v2) {
            int i2 = i;
            lock();
            try {
                long qd = this.map.ticker.qd();
                E(qd);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    K k2;
                    if (referenceEntry2.getHash() != i2 || key == null) {
                        k2 = k;
                    } else {
                        k2 = k;
                        if (this.map.keyEquivalence.f(k2, key)) {
                            q valueReference = referenceEntry2.getValueReference();
                            Object obj = valueReference.get();
                            if (obj == null) {
                                if (valueReference.isActive()) {
                                    int i3 = this.count;
                                    this.modCount++;
                                    Object obj2 = obj;
                                    ReferenceEntry referenceEntry3 = referenceEntry2;
                                    q qVar = valueReference;
                                    ReferenceEntry a = a(referenceEntry, referenceEntry3, key, i2, obj2, qVar, RemovalCause.COLLECTED);
                                    int i4 = this.count - 1;
                                    atomicReferenceArray.set(length, a);
                                    this.count = i4;
                                }
                                unlock();
                                rp();
                                return false;
                            }
                            key = obj;
                            q qVar2 = valueReference;
                            if (this.map.valueEquivalence.f(v, key)) {
                                this.modCount++;
                                a(k2, i2, key, qVar2.getWeight(), RemovalCause.REPLACED);
                                a(referenceEntry2, (Object) k2, (Object) v2, qd);
                                g(referenceEntry2);
                                unlock();
                                rp();
                                return true;
                            }
                            d(referenceEntry2, qd);
                            unlock();
                            rp();
                            return false;
                        }
                    }
                    V v3 = v;
                }
                unlock();
                rp();
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                unlock();
                rp();
            }
        }

        V a(K k, int i, V v) {
            int i2 = i;
            lock();
            try {
                long qd = this.map.ticker.qd();
                E(qd);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    K k2;
                    if (referenceEntry2.getHash() != i2 || key == null) {
                        k2 = k;
                    } else {
                        k2 = k;
                        if (this.map.keyEquivalence.f(k2, key)) {
                            q valueReference = referenceEntry2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 == null) {
                                if (valueReference.isActive()) {
                                    int i3 = this.count;
                                    this.modCount++;
                                    ReferenceEntry a = a(referenceEntry, referenceEntry2, key, i2, v2, valueReference, RemovalCause.COLLECTED);
                                    int i4 = this.count - 1;
                                    atomicReferenceArray.set(length, a);
                                    this.count = i4;
                                }
                                unlock();
                                rp();
                                return null;
                            }
                            this.modCount++;
                            a(k2, i2, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                            a(referenceEntry2, (Object) k2, (Object) v, qd);
                            g(referenceEntry2);
                            unlock();
                            rp();
                            return v2;
                        }
                    }
                }
                unlock();
                rp();
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                unlock();
                rp();
            }
        }

        V c(Object obj, int i) {
            lock();
            try {
                E(this.map.ticker.qd());
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.f(obj, key)) {
                        RemovalCause removalCause;
                        q valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            rp();
                            return null;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, a(referenceEntry, referenceEntry2, key, i, v, valueReference, removalCause2));
                        this.count = i3;
                        return v;
                    }
                }
                unlock();
                rp();
                return null;
            } finally {
                unlock();
                rp();
            }
        }

        boolean a(K k, int i, i<K, V> iVar, V v) {
            Object obj = k;
            int i2 = i;
            lock();
            try {
                ReferenceEntry referenceEntry;
                long qd = this.map.ticker.qd();
                E(qd);
                int i3 = this.count + 1;
                if (i3 > this.threshold) {
                    expand();
                    i3 = this.count + 1;
                }
                int i4 = i3;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    Object key = referenceEntry.getKey();
                    if (referenceEntry.getHash() == i2 && key != null && this.map.keyEquivalence.f(obj, key)) {
                        q valueReference = referenceEntry.getValueReference();
                        Object obj2 = valueReference.get();
                        if (iVar == valueReference || (obj2 == null && valueReference != LocalCache.Oq)) {
                            this.modCount++;
                            if (iVar.isActive()) {
                                a(obj, i2, obj2, iVar.getWeight(), obj2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i4--;
                            }
                            a(referenceEntry, obj, (Object) v, qd);
                            this.count = i4;
                            g(referenceEntry);
                            unlock();
                            rp();
                            return true;
                        }
                        a(obj, i2, v, 0, RemovalCause.REPLACED);
                        unlock();
                        rp();
                        return false;
                    }
                    i<K, V> iVar2 = iVar;
                }
                this.modCount++;
                referenceEntry = a(obj, i2, referenceEntry2);
                a(referenceEntry, obj, (Object) v, qd);
                atomicReferenceArray.set(length, referenceEntry);
                this.count = i4;
                g(referenceEntry);
                unlock();
                rp();
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                unlock();
                rp();
            }
        }

        boolean b(Object obj, int i, Object obj2) {
            lock();
            try {
                E(this.map.ticker.qd());
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.f(obj, key)) {
                        RemovalCause removalCause;
                        q valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.valueEquivalence.f(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (obj3 == null && valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            rp();
                            return false;
                        }
                        this.modCount++;
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, a(referenceEntry, referenceEntry2, key, i, obj3, valueReference, removalCause));
                        this.count = i3;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z = false;
                        }
                        unlock();
                        rp();
                        return z;
                    }
                }
                unlock();
                rp();
                return false;
            } catch (Throwable th) {
                unlock();
                rp();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    int i;
                    E(this.map.ticker.qd());
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    for (i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                Object key = referenceEntry.getKey();
                                Object obj = referenceEntry.getValueReference().get();
                                RemovalCause removalCause = (key == null || obj == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT;
                                a(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    rj();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    rp();
                }
            }
        }

        ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k, int i, V v, q<K, V> qVar, RemovalCause removalCause) {
            a(k, i, v, qVar.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!qVar.qW()) {
                return d((ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            }
            qVar.N(null);
            return referenceEntry;
        }

        ReferenceEntry<K, V> d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            ReferenceEntry referenceEntry3;
            while (referenceEntry3 != referenceEntry2) {
                ReferenceEntry<K, V> c = c(referenceEntry3, (ReferenceEntry) next);
                if (c != null) {
                    next = c;
                } else {
                    h(referenceEntry3);
                    i--;
                }
                referenceEntry3 = referenceEntry3.getNext();
            }
            this.count = i;
            return next;
        }

        void h(ReferenceEntry<K, V> referenceEntry) {
            a(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        boolean a(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - z) & i;
                ReferenceEntry<K, V> referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount += z;
                        i = this.count - z;
                        atomicReferenceArray.set(length, a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                        this.count = i;
                        return z;
                    }
                }
                unlock();
                rp();
                return false;
            } finally {
                unlock();
                rp();
            }
        }

        boolean a(K k, int i, q<K, V> qVar) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - z) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.f(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == qVar) {
                        this.modCount += z;
                        i = this.count - z;
                        atomicReferenceArray.set(length, a(referenceEntry, referenceEntry2, key, i, qVar.get(), qVar, RemovalCause.COLLECTED));
                        this.count = i;
                        return z;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            rp();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    rp();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    rp();
                }
            }
        }

        boolean a(K k, int i, i<K, V> iVar) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.f(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == iVar) {
                        if (iVar.isActive()) {
                            referenceEntry2.setValueReference(iVar.rd());
                        } else {
                            atomicReferenceArray.set(length, d(referenceEntry, referenceEntry2));
                        }
                        unlock();
                        rp();
                        return true;
                    } else {
                        unlock();
                        rp();
                        return false;
                    }
                }
                unlock();
                rp();
                return false;
            } catch (Throwable th) {
                unlock();
                rp();
            }
        }

        boolean a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    i = this.count - 1;
                    atomicReferenceArray.set(length, a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count = i;
                    return true;
                }
            }
            return false;
        }

        void ro() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                bV();
            }
        }

        void E(long j) {
            F(j);
        }

        void rp() {
            rq();
        }

        void bV() {
            F(this.map.ticker.qd());
            rq();
        }

        void F(long j) {
            if (tryLock()) {
                try {
                    rg();
                    D(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void rq() {
            if (!isHeldByCurrentThread()) {
                this.map.qT();
            }
        }
    }

    enum Strength {
        STRONG {
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new n(v) : new y(v, i);
            }

            Equivalence<Object> defaultEquivalence() {
                return Equivalence.pK();
            }
        },
        SOFT {
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new j(segment.valueReferenceQueue, v, referenceEntry) : new x(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            Equivalence<Object> defaultEquivalence() {
                return Equivalence.pL();
            }
        },
        WEAK {
            <K, V> q<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new v(segment.valueReferenceQueue, v, referenceEntry) : new z(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            Equivalence<Object> defaultEquivalence() {
                return Equivalence.pL();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> q<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    abstract class a<T> extends AbstractSet<T> {
        final ConcurrentMap<?, ?> Ov;

        a(ConcurrentMap<?, ?> concurrentMap) {
            this.Ov = concurrentMap;
        }

        public int size() {
            return this.Ov.size();
        }

        public boolean isEmpty() {
            return this.Ov.isEmpty();
        }

        public void clear() {
            this.Ov.clear();
        }

        public Object[] toArray() {
            return LocalCache.f(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.f(this).toArray(eArr);
        }
    }

    static final class aa<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> Ox = new b<K, V>() {
            ReferenceEntry<K, V> OZ = this;
            ReferenceEntry<K, V> Pa = this;

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setWriteTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.OZ;
            }

            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.OZ = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.Pa;
            }

            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.Pa = referenceEntry;
            }
        };

        aa() {
        }

        /* renamed from: d */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.b(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.b(this.Ox.getPreviousInWriteQueue(), (ReferenceEntry) referenceEntry);
            LocalCache.b((ReferenceEntry) referenceEntry, this.Ox);
            return true;
        }

        /* renamed from: qY */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.Ox.getNextInWriteQueue();
            return nextInWriteQueue == this.Ox ? null : nextInWriteQueue;
        }

        /* renamed from: qZ */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.Ox.getNextInWriteQueue();
            if (nextInWriteQueue == this.Ox) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.b(previousInWriteQueue, nextInWriteQueue);
            LocalCache.c(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.Ox.getNextInWriteQueue() == this.Ox;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry nextInWriteQueue = this.Ox.getNextInWriteQueue(); nextInWriteQueue != this.Ox; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry nextInWriteQueue = this.Ox.getNextInWriteQueue();
            while (nextInWriteQueue != this.Ox) {
                ReferenceEntry nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                LocalCache.c(nextInWriteQueue);
                nextInWriteQueue = nextInWriteQueue2;
            }
            this.Ox.setNextInWriteQueue(this.Ox);
            this.Ox.setPreviousInWriteQueue(this.Ox);
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new com.google.common.collect.f<ReferenceEntry<K, V>>(peek()) {
                /* renamed from: e */
                protected ReferenceEntry<K, V> O(ReferenceEntry<K, V> referenceEntry) {
                    referenceEntry = referenceEntry.getNextInWriteQueue();
                    return referenceEntry == aa.this.Ox ? null : referenceEntry;
                }
            };
        }
    }

    final class ab implements Entry<K, V> {
        final K key;
        V value;

        ab(K k, V v) {
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
            V put = LocalCache.this.put(this.key, v);
            this.value = v;
            return put;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append("=");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    static final class c<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> Ox = new b<K, V>() {
            ReferenceEntry<K, V> Oy = this;
            ReferenceEntry<K, V> Oz = this;

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public void setAccessTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.Oy;
            }

            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.Oy = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.Oz;
            }

            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.Oz = referenceEntry;
            }
        };

        c() {
        }

        /* renamed from: d */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.a(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.a(this.Ox.getPreviousInAccessQueue(), (ReferenceEntry) referenceEntry);
            LocalCache.a((ReferenceEntry) referenceEntry, this.Ox);
            return true;
        }

        /* renamed from: qY */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.Ox.getNextInAccessQueue();
            return nextInAccessQueue == this.Ox ? null : nextInAccessQueue;
        }

        /* renamed from: qZ */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.Ox.getNextInAccessQueue();
            if (nextInAccessQueue == this.Ox) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.a(previousInAccessQueue, nextInAccessQueue);
            LocalCache.b(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.Ox.getNextInAccessQueue() == this.Ox;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry nextInAccessQueue = this.Ox.getNextInAccessQueue(); nextInAccessQueue != this.Ox; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry nextInAccessQueue = this.Ox.getNextInAccessQueue();
            while (nextInAccessQueue != this.Ox) {
                ReferenceEntry nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                LocalCache.b(nextInAccessQueue);
                nextInAccessQueue = nextInAccessQueue2;
            }
            this.Ox.setNextInAccessQueue(this.Ox);
            this.Ox.setPreviousInAccessQueue(this.Ox);
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new com.google.common.collect.f<ReferenceEntry<K, V>>(peek()) {
                /* renamed from: e */
                protected ReferenceEntry<K, V> O(ReferenceEntry<K, V> referenceEntry) {
                    referenceEntry = referenceEntry.getNextInAccessQueue();
                    return referenceEntry == c.this.Ox ? null : referenceEntry;
                }
            };
        }
    }

    abstract class f<T> implements Iterator<T> {
        int OB;
        int OC = -1;
        Segment<K, V> OD;
        AtomicReferenceArray<ReferenceEntry<K, V>> OE;
        ReferenceEntry<K, V> OF;
        ab OG;
        ab OH;

        f() {
            this.OB = LocalCache.this.Ok.length - 1;
            advance();
        }

        final void advance() {
            this.OG = null;
            if (!ra() && !rb()) {
                while (this.OB >= 0) {
                    Segment[] segmentArr = LocalCache.this.Ok;
                    int i = this.OB;
                    this.OB = i - 1;
                    this.OD = segmentArr[i];
                    if (this.OD.count != 0) {
                        this.OE = this.OD.table;
                        this.OC = this.OE.length() - 1;
                        if (rb()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean ra() {
            if (this.OF != null) {
                do {
                    this.OF = this.OF.getNext();
                    if (this.OF != null) {
                    }
                } while (!f(this.OF));
                return true;
            }
            return false;
        }

        boolean rb() {
            while (this.OC >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.OE;
                int i = this.OC;
                this.OC = i - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
                this.OF = referenceEntry;
                if (referenceEntry != null && (f(this.OF) || ra())) {
                    return true;
                }
            }
            return false;
        }

        boolean f(ReferenceEntry<K, V> referenceEntry) {
            try {
                long qd = LocalCache.this.ticker.qd();
                Object key = referenceEntry.getKey();
                Object a = LocalCache.this.a((ReferenceEntry) referenceEntry, qd);
                if (a != null) {
                    this.OG = new ab(key, a);
                    return true;
                }
                this.OD.ro();
                return false;
            } finally {
                this.OD.ro();
            }
        }

        public boolean hasNext() {
            return this.OG != null;
        }

        ab rc() {
            if (this.OG == null) {
                throw new NoSuchElementException();
            }
            this.OH = this.OG;
            advance();
            return this.OH;
        }

        public void remove() {
            com.google.common.base.i.checkState(this.OH != null);
            LocalCache.this.remove(this.OH.getKey());
            this.OH = null;
        }
    }

    interface q<K, V> {
        void N(V v);

        q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry);

        V get();

        int getWeight();

        boolean isActive();

        ReferenceEntry<K, V> qV();

        boolean qW();

        V qX();
    }

    final class r extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> Ov;

        r(ConcurrentMap<?, ?> concurrentMap) {
            this.Ov = concurrentMap;
        }

        public int size() {
            return this.Ov.size();
        }

        public boolean isEmpty() {
            return this.Ov.isEmpty();
        }

        public void clear() {
            this.Ov.clear();
        }

        public Iterator<V> iterator() {
            return new p();
        }

        public boolean contains(Object obj) {
            return this.Ov.containsValue(obj);
        }

        public Object[] toArray() {
            return LocalCache.f(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.f(this).toArray(eArr);
        }
    }

    static class LocalManualCache<K, V> implements b<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* synthetic */ LocalManualCache(LocalCache localCache, AnonymousClass1 anonymousClass1) {
            this(localCache);
        }

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        public V I(Object obj) {
            return this.localCache.I(obj);
        }

        public V a(K k, final Callable<? extends V> callable) {
            com.google.common.base.i.checkNotNull(callable);
            return this.localCache.a((Object) k, new CacheLoader<Object, V>() {
                public V K(Object obj) {
                    return callable.call();
                }
            });
        }

        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        public void J(Object obj) {
            com.google.common.base.i.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        public void invalidateAll() {
            this.localCache.clear();
        }

        public ConcurrentMap<K, V> qg() {
            return this.localCache;
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public long getAccessTime() {
            return 0;
        }

        public int getHash() {
            return 0;
        }

        public Object getKey() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        public q<Object, Object> getValueReference() {
            return null;
        }

        public long getWriteTime() {
            return 0;
        }

        public void setAccessTime(long j) {
        }

        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setValueReference(q<Object, Object> qVar) {
        }

        public void setWriteTime(long j) {
        }
    }

    static abstract class b<K, V> implements ReferenceEntry<K, V> {
        b() {
        }

        public q<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(q<K, V> qVar) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    final class d extends f<Entry<K, V>> {
        d() {
            super();
        }

        public Entry<K, V> next() {
            return rc();
        }
    }

    final class e extends a<Entry<K, V>> {
        e(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
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
            key = LocalCache.this.get(key);
            if (key != null && LocalCache.this.valueEquivalence.f(entry.getValue(), key)) {
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
            if (key != null && LocalCache.this.remove(key, entry.getValue())) {
                z = true;
            }
            return z;
        }
    }

    final class g extends f<K> {
        g() {
            super();
        }

        public K next() {
            return rc().getKey();
        }
    }

    final class h extends a<K> {
        h(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        public Iterator<K> iterator() {
            return new g();
        }

        public boolean contains(Object obj) {
            return this.Ov.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.Ov.remove(obj) != null;
        }
    }

    static class i<K, V> implements q<K, V> {
        volatile q<K, V> OJ;
        final com.google.common.util.concurrent.y<V> OK;
        final com.google.common.base.l OL;

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> qV() {
            return null;
        }

        public boolean qW() {
            return true;
        }

        public i() {
            this(LocalCache.qQ());
        }

        public i(q<K, V> qVar) {
            this.OK = com.google.common.util.concurrent.y.wb();
            this.OL = com.google.common.base.l.pW();
            this.OJ = qVar;
        }

        public boolean isActive() {
            return this.OJ.isActive();
        }

        public int getWeight() {
            return this.OJ.getWeight();
        }

        public boolean P(V v) {
            return this.OK.P(v);
        }

        public boolean h(Throwable th) {
            return this.OK.h(th);
        }

        private com.google.common.util.concurrent.s<V> i(Throwable th) {
            return com.google.common.util.concurrent.o.m(th);
        }

        public void N(V v) {
            if (v != null) {
                P(v);
            } else {
                this.OJ = LocalCache.qQ();
            }
        }

        public com.google.common.util.concurrent.s<V> b(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.OL.pY();
                Object obj = this.OJ.get();
                if (obj == null) {
                    Object K = cacheLoader.K(k);
                    return P(K) ? this.OK : com.google.common.util.concurrent.o.aR(K);
                }
                com.google.common.util.concurrent.s i = cacheLoader.i(k, obj);
                if (i == null) {
                    return com.google.common.util.concurrent.o.aR(null);
                }
                return com.google.common.util.concurrent.o.b(i, new com.google.common.base.d<V, V>() {
                    public V apply(V v) {
                        i.this.P(v);
                        return v;
                    }
                }, MoreExecutors.vV());
            } catch (Throwable th) {
                com.google.common.util.concurrent.s<V> i2 = h(th) ? this.OK : i(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return i2;
            }
        }

        public long pZ() {
            return this.OL.a(TimeUnit.NANOSECONDS);
        }

        public V qX() {
            return com.google.common.util.concurrent.ab.c(this.OK);
        }

        public V get() {
            return this.OJ.get();
        }

        public q<K, V> rd() {
            return this.OJ;
        }
    }

    static class j<K, V> extends SoftReference<V> implements q<K, V> {
        final ReferenceEntry<K, V> OW;

        public void N(V v) {
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean qW() {
            return false;
        }

        j(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.OW = referenceEntry;
        }

        public ReferenceEntry<K, V> qV() {
            return this.OW;
        }

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new j(referenceQueue, v, referenceEntry);
        }

        public V qX() {
            return get();
        }
    }

    static class n<K, V> implements q<K, V> {
        final V Pd;

        public void N(V v) {
        }

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public ReferenceEntry<K, V> qV() {
            return null;
        }

        public boolean qW() {
            return false;
        }

        n(V v) {
            this.Pd = v;
        }

        public V get() {
            return this.Pd;
        }

        public V qX() {
            return get();
        }
    }

    final class p extends f<V> {
        p() {
            super();
        }

        public V next() {
            return rc().getValue();
        }
    }

    static class u<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final ReferenceEntry<K, V> Pb;
        volatile q<K, V> Pc = LocalCache.qQ();
        final int hash;

        u(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = i;
            this.Pb = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public q<K, V> getValueReference() {
            return this.Pc;
        }

        public void setValueReference(q<K, V> qVar) {
            this.Pc = qVar;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.Pb;
        }
    }

    static class v<K, V> extends WeakReference<V> implements q<K, V> {
        final ReferenceEntry<K, V> OW;

        public void N(V v) {
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean qW() {
            return false;
        }

        v(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.OW = referenceEntry;
        }

        public ReferenceEntry<K, V> qV() {
            return this.OW;
        }

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new v(referenceQueue, v, referenceEntry);
        }

        public V qX() {
            return get();
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements e<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) com.google.common.base.i.checkNotNull(cacheLoader)), null);
        }

        public V get(K k) {
            return this.localCache.M(k);
        }

        public V L(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        public final V apply(K k) {
            return L(k);
        }

        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    static class ManualSerializationProxy<K, V> extends d<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        transient b<K, V> OQ;
        final int concurrencyLevel;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final g<? super K, ? super V> removalListener;
        final com.google.common.base.p ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final h<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            LocalCache<K, V> localCache2 = localCache;
            Strength strength = localCache2.keyStrength;
            Strength strength2 = localCache2.valueStrength;
            Equivalence equivalence = localCache2.keyEquivalence;
            Equivalence equivalence2 = localCache2.valueEquivalence;
            long j = localCache2.expireAfterWriteNanos;
            long j2 = localCache2.expireAfterAccessNanos;
            long j3 = localCache2.maxWeight;
            h hVar = localCache2.weigher;
            int i = localCache2.concurrencyLevel;
            g gVar = localCache2.removalListener;
            com.google.common.base.p pVar = localCache2.ticker;
            CacheLoader cacheLoader = localCache2.Op;
            this(strength, strength2, equivalence, equivalence2, j, j2, j3, hVar, i, gVar, pVar, cacheLoader);
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, h<K, V> hVar, int i, g<? super K, ? super V> gVar, com.google.common.base.p pVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = hVar;
            this.concurrencyLevel = i;
            this.removalListener = gVar;
            if (pVar == com.google.common.base.p.qe() || pVar == CacheBuilder.NT) {
                pVar = null;
            }
            this.ticker = pVar;
            this.loader = cacheLoader;
        }

        CacheBuilder<K, V> re() {
            CacheBuilder<K, V> a = CacheBuilder.qh().a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.valueEquivalence).aA(this.concurrencyLevel).a(this.removalListener);
            a.NV = false;
            if (this.expireAfterWriteNanos > 0) {
                a.a(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
            }
            if (this.expireAfterAccessNanos > 0) {
                a.b(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
            }
            if (this.weigher != OneWeigher.INSTANCE) {
                a.a(this.weigher);
                if (this.maxWeight != -1) {
                    a.B(this.maxWeight);
                }
            } else if (this.maxWeight != -1) {
                a.A(this.maxWeight);
            }
            if (this.ticker != null) {
                a.a(this.ticker);
            }
            return a;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.OQ = re().qw();
        }

        private Object readResolve() {
            return this.OQ;
        }

        /* renamed from: qA */
        protected b<K, V> qB() {
            return this.OQ;
        }
    }

    static class m<K, V> extends b<K, V> {
        final ReferenceEntry<K, V> Pb;
        volatile q<K, V> Pc = LocalCache.qQ();
        final int hash;
        final K key;

        m(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            this.key = k;
            this.hash = i;
            this.Pb = referenceEntry;
        }

        public K getKey() {
            return this.key;
        }

        public q<K, V> getValueReference() {
            return this.Pc;
        }

        public void setValueReference(q<K, V> qVar) {
            this.Pc = qVar;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.Pb;
        }
    }

    static final class s<K, V> extends u<K, V> {
        volatile long OX = Long.MAX_VALUE;
        ReferenceEntry<K, V> Oy = LocalCache.qR();
        ReferenceEntry<K, V> Oz = LocalCache.qR();

        s(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.OX;
        }

        public void setAccessTime(long j) {
            this.OX = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.Oy;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oy = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.Oz;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oz = referenceEntry;
        }
    }

    static final class t<K, V> extends u<K, V> {
        volatile long OX = Long.MAX_VALUE;
        volatile long OY = Long.MAX_VALUE;
        ReferenceEntry<K, V> OZ = LocalCache.qR();
        ReferenceEntry<K, V> Oy = LocalCache.qR();
        ReferenceEntry<K, V> Oz = LocalCache.qR();
        ReferenceEntry<K, V> Pa = LocalCache.qR();

        t(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.OX;
        }

        public void setAccessTime(long j) {
            this.OX = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.Oy;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oy = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.Oz;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oz = referenceEntry;
        }

        public long getWriteTime() {
            return this.OY;
        }

        public void setWriteTime(long j) {
            this.OY = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.OZ;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.OZ = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.Pa;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Pa = referenceEntry;
        }
    }

    static final class w<K, V> extends u<K, V> {
        volatile long OY = Long.MAX_VALUE;
        ReferenceEntry<K, V> OZ = LocalCache.qR();
        ReferenceEntry<K, V> Pa = LocalCache.qR();

        w(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getWriteTime() {
            return this.OY;
        }

        public void setWriteTime(long j) {
            this.OY = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.OZ;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.OZ = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.Pa;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Pa = referenceEntry;
        }
    }

    static final class x<K, V> extends j<K, V> {
        final int weight;

        x(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new x(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class y<K, V> extends n<K, V> {
        final int weight;

        y(V v, int i) {
            super(v);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    static final class z<K, V> extends v<K, V> {
        final int weight;

        z(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }

        public q<K, V> a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new z(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements e<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient e<K, V> OI;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.OI = re().a(this.loader);
        }

        public V L(K k) {
            return this.OI.L(k);
        }

        public final V apply(K k) {
            return this.OI.apply(k);
        }

        private Object readResolve() {
            return this.OI;
        }
    }

    static final class k<K, V> extends m<K, V> {
        volatile long OX = Long.MAX_VALUE;
        ReferenceEntry<K, V> Oy = LocalCache.qR();
        ReferenceEntry<K, V> Oz = LocalCache.qR();

        k(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.OX;
        }

        public void setAccessTime(long j) {
            this.OX = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.Oy;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oy = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.Oz;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oz = referenceEntry;
        }
    }

    static final class l<K, V> extends m<K, V> {
        volatile long OX = Long.MAX_VALUE;
        volatile long OY = Long.MAX_VALUE;
        ReferenceEntry<K, V> OZ = LocalCache.qR();
        ReferenceEntry<K, V> Oy = LocalCache.qR();
        ReferenceEntry<K, V> Oz = LocalCache.qR();
        ReferenceEntry<K, V> Pa = LocalCache.qR();

        l(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.OX;
        }

        public void setAccessTime(long j) {
            this.OX = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.Oy;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oy = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.Oz;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Oz = referenceEntry;
        }

        public long getWriteTime() {
            return this.OY;
        }

        public void setWriteTime(long j) {
            this.OY = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.OZ;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.OZ = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.Pa;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Pa = referenceEntry;
        }
    }

    static final class o<K, V> extends m<K, V> {
        volatile long OY = Long.MAX_VALUE;
        ReferenceEntry<K, V> OZ = LocalCache.qR();
        ReferenceEntry<K, V> Pa = LocalCache.qR();

        o(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getWriteTime() {
            return this.OY;
        }

        public void setWriteTime(long j) {
            this.OY = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.OZ;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.OZ = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.Pa;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.Pa = referenceEntry;
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

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        this.concurrencyLevel = Math.min(cacheBuilder.ql(), 65536);
        this.keyStrength = cacheBuilder.qp();
        this.valueStrength = cacheBuilder.qq();
        this.keyEquivalence = cacheBuilder.qi();
        this.valueEquivalence = cacheBuilder.qj();
        this.maxWeight = cacheBuilder.qm();
        this.weigher = cacheBuilder.qn();
        this.expireAfterAccessNanos = cacheBuilder.qs();
        this.expireAfterWriteNanos = cacheBuilder.qr();
        this.Oa = cacheBuilder.qt();
        this.removalListener = cacheBuilder.qu();
        this.Ol = this.removalListener == NullListener.INSTANCE ? qS() : new ConcurrentLinkedQueue();
        this.ticker = cacheBuilder.ab(qL());
        this.Om = EntryFactory.getFactory(this.keyStrength, qN(), qM());
        this.Oo = (com.google.common.cache.a.b) cacheBuilder.qv().get();
        this.Op = cacheLoader;
        int min = Math.min(cacheBuilder.qk(), 1073741824);
        if (qC() && !qD()) {
            min = Math.min(min, (int) this.maxWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel && (!qC() || ((long) (i3 * 20)) <= this.maxWeight)) {
            i4++;
            i3 <<= 1;
        }
        this.Oj = 32 - i4;
        this.Oi = i3 - 1;
        this.Ok = aD(i3);
        i4 = min / i3;
        if (i4 * i3 < min) {
            i4++;
        }
        while (i2 < i4) {
            i2 <<= 1;
        }
        if (qC()) {
            long j = (long) i3;
            long j2 = (this.maxWeight / j) + 1;
            long j3 = this.maxWeight % j;
            while (i < this.Ok.length) {
                if (((long) i) == j3) {
                    j2--;
                }
                this.Ok[i] = a(i2, j2, (com.google.common.cache.a.b) cacheBuilder.qv().get());
                i++;
            }
            return;
        }
        while (i < this.Ok.length) {
            this.Ok[i] = a(i2, -1, (com.google.common.cache.a.b) cacheBuilder.qv().get());
            i++;
        }
    }

    boolean qC() {
        return this.maxWeight >= 0;
    }

    boolean qD() {
        return this.weigher != OneWeigher.INSTANCE;
    }

    boolean qE() {
        return this.expireAfterWriteNanos > 0;
    }

    boolean qF() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean qG() {
        return this.Oa > 0;
    }

    boolean qH() {
        return qF() || qC();
    }

    boolean qI() {
        return qE();
    }

    boolean qJ() {
        return qE() || qG();
    }

    boolean qK() {
        return qF();
    }

    boolean qL() {
        return qJ() || qK();
    }

    boolean qM() {
        return qI() || qJ();
    }

    boolean qN() {
        return qH() || qK();
    }

    boolean qO() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean qP() {
        return this.valueStrength != Strength.STRONG;
    }

    static <K, V> q<K, V> qQ() {
        return Oq;
    }

    static <K, V> ReferenceEntry<K, V> qR() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> qS() {
        return Or;
    }

    int hash(Object obj) {
        return aB(this.keyEquivalence.hash(obj));
    }

    void a(q<K, V> qVar) {
        ReferenceEntry qV = qVar.qV();
        int hash = qV.getHash();
        aC(hash).a(qV.getKey(), hash, (q) qVar);
    }

    void a(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        aC(hash).a((ReferenceEntry) referenceEntry, hash);
    }

    Segment<K, V> aC(int i) {
        return this.Ok[(i >>> this.Oj) & this.Oi];
    }

    Segment<K, V> a(int i, long j, com.google.common.cache.a.b bVar) {
        return new Segment(this, i, j, bVar);
    }

    V a(ReferenceEntry<K, V> referenceEntry, long j) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null || b((ReferenceEntry) referenceEntry, j)) {
            return null;
        }
        return v;
    }

    boolean b(ReferenceEntry<K, V> referenceEntry, long j) {
        com.google.common.base.i.checkNotNull(referenceEntry);
        if (qF() && j - referenceEntry.getAccessTime() >= this.expireAfterAccessNanos) {
            return true;
        }
        if (!qE() || j - referenceEntry.getWriteTime() < this.expireAfterWriteNanos) {
            return false;
        }
        return true;
    }

    static <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void b(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry qR = qR();
        referenceEntry.setNextInAccessQueue(qR);
        referenceEntry.setPreviousInAccessQueue(qR);
    }

    static <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <K, V> void c(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry qR = qR();
        referenceEntry.setNextInWriteQueue(qR);
        referenceEntry.setPreviousInWriteQueue(qR);
    }

    void qT() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.Ol.poll();
            if (removalNotification != null) {
                try {
                    this.removalListener.onRemoval(removalNotification);
                } catch (Throwable th) {
                    logger.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    final Segment<K, V>[] aD(int i) {
        return new Segment[i];
    }

    public boolean isEmpty() {
        Segment[] segmentArr = this.Ok;
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

    long qU() {
        Segment[] segmentArr = this.Ok;
        long j = 0;
        int i = 0;
        while (i < segmentArr.length) {
            i++;
            j += (long) Math.max(0, segmentArr[i].count);
        }
        return j;
    }

    public int size() {
        return Ints.I(qU());
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return aC(hash).get(obj, hash);
    }

    public V I(Object obj) {
        int hash = hash(com.google.common.base.i.checkNotNull(obj));
        V v = aC(hash).get(obj, hash);
        if (v == null) {
            this.Oo.az(1);
        } else {
            this.Oo.ay(1);
        }
        return v;
    }

    public V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    V a(K k, CacheLoader<? super K, V> cacheLoader) {
        int hash = hash(com.google.common.base.i.checkNotNull(k));
        return aC(hash).a((Object) k, hash, (CacheLoader) cacheLoader);
    }

    V M(K k) {
        return a((Object) k, this.Op);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return aC(hash).b(obj, hash);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        long qd = this.ticker.qd();
        Segment[] segmentArr = this.Ok;
        long j = -1;
        while (0 < 3) {
            Segment[] segmentArr2;
            long j2;
            int length = segmentArr.length;
            long j3 = 0;
            int i = 0;
            while (i < length) {
                Segment segment = segmentArr[i];
                int i2 = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i3);
                    while (referenceEntry != null) {
                        segmentArr2 = segmentArr;
                        Object a = segment.a(referenceEntry, qd);
                        if (a != null) {
                            j2 = qd;
                            if (this.valueEquivalence.f(obj2, a)) {
                                return true;
                            }
                        } else {
                            j2 = qd;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        qd = j2;
                    }
                    j2 = qd;
                    segmentArr2 = segmentArr;
                }
                i++;
                j3 += (long) segment.modCount;
                segmentArr = segmentArr;
                qd = qd;
            }
            j2 = qd;
            segmentArr2 = segmentArr;
            if (j3 == j) {
                break;
            }
            int i4 = 0 + 1;
            j = j3;
            segmentArr = segmentArr2;
            qd = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return aC(hash).a((Object) k, hash, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return aC(hash).a((Object) k, hash, (Object) v, true);
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
        return aC(hash).c(obj, hash);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return aC(hash).b(obj, hash, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return aC(hash).a((Object) k, hash, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        com.google.common.base.i.checkNotNull(k);
        com.google.common.base.i.checkNotNull(v);
        int hash = hash(k);
        return aC(hash).a((Object) k, hash, (Object) v);
    }

    public void clear() {
        for (Segment clear : this.Ok) {
            clear.clear();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.Os;
        if (set != null) {
            return set;
        }
        set = new h(this);
        this.Os = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.Ot;
        if (collection != null) {
            return collection;
        }
        collection = new r(this);
        this.Ot = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.Ou;
        if (set != null) {
            return set;
        }
        set = new e(this);
        this.Ou = set;
        return set;
    }

    private static <E> ArrayList<E> f(Collection<E> collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }
}
