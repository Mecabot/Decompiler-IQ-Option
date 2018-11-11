package io.reactivex.internal.queue;

import io.reactivex.internal.b.h;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue */
public final class a<T> implements h<T> {
    static final int erK = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object erQ = new Object();
    final AtomicLong consumerIndex = new AtomicLong();
    int erL;
    final int erM;
    AtomicReferenceArray<Object> erN;
    final int erO;
    AtomicReferenceArray<Object> erP;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    private static int jh(int i) {
        return i;
    }

    public a(int i) {
        i = f.jk(Math.max(8, i));
        int i2 = i - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i + 1);
        this.erN = atomicReferenceArray;
        this.erM = i2;
        jg(i);
        this.erP = atomicReferenceArray;
        this.erO = i2;
        this.producerLookAhead = (long) (i2 - 1);
        cT(0);
    }

    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.erN;
        long aWY = aWY();
        int i = this.erM;
        int e = e(aWY, i);
        if (aWY < this.producerLookAhead) {
            return a(atomicReferenceArray, t, aWY, e);
        }
        long j = aWY + ((long) this.erL);
        if (b(atomicReferenceArray, e(j, i)) == null) {
            this.producerLookAhead = j - 1;
            return a(atomicReferenceArray, t, aWY, e);
        } else if (b(atomicReferenceArray, e(aWY + 1, i)) == null) {
            return a(atomicReferenceArray, t, aWY, e);
        } else {
            a(atomicReferenceArray, aWY, e, t, (long) i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a((AtomicReferenceArray) atomicReferenceArray, i, (Object) t);
        cT(j + 1);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.erN = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, (Object) t);
        a((AtomicReferenceArray) atomicReferenceArray, atomicReferenceArray2);
        a((AtomicReferenceArray) atomicReferenceArray, i, erQ);
        cT(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a((AtomicReferenceArray) atomicReferenceArray, jh(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        i = jh(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, i);
        a((AtomicReferenceArray) atomicReferenceArray, i, null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray atomicReferenceArray = this.erP;
        long aWZ = aWZ();
        int i = this.erO;
        int e = e(aWZ, i);
        T b = b(atomicReferenceArray, e);
        Object obj = b == erQ ? 1 : null;
        if (b != null && obj == null) {
            a(atomicReferenceArray, e, null);
            cU(aWZ + 1);
            return b;
        } else if (obj != null) {
            return a(a(atomicReferenceArray, i + 1), aWZ, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.erP = atomicReferenceArray;
        i = e(j, i);
        T b = b(atomicReferenceArray, i);
        if (b != null) {
            a((AtomicReferenceArray) atomicReferenceArray, i, null);
            cU(j + 1);
        }
        return b;
    }

    public void clear() {
        while (true) {
            if (poll() == null) {
                if (isEmpty()) {
                    return;
                }
            }
        }
    }

    public boolean isEmpty() {
        return aWW() == aWX();
    }

    private void jg(int i) {
        this.erL = Math.min(i / 4, erK);
    }

    private long aWW() {
        return this.producerIndex.get();
    }

    private long aWX() {
        return this.consumerIndex.get();
    }

    private long aWY() {
        return this.producerIndex.get();
    }

    private long aWZ() {
        return this.consumerIndex.get();
    }

    private void cT(long j) {
        this.producerIndex.lazySet(j);
    }

    private void cU(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int e(long j, int i) {
        return jh(((int) j) & i);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray atomicReferenceArray = this.erN;
        long aWW = aWW();
        int i = this.erM;
        long j = aWW + 2;
        int e;
        if (b(atomicReferenceArray, e(j, i)) == null) {
            e = e(aWW, i);
            a(atomicReferenceArray, e + 1, (Object) t2);
            a(atomicReferenceArray, e, (Object) t);
            cT(j);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.erN = atomicReferenceArray2;
            e = e(aWW, i);
            a(atomicReferenceArray2, e + 1, (Object) t2);
            a(atomicReferenceArray2, e, (Object) t);
            a(atomicReferenceArray, atomicReferenceArray2);
            a(atomicReferenceArray, e, erQ);
            cT(j);
        }
        return true;
    }
}
