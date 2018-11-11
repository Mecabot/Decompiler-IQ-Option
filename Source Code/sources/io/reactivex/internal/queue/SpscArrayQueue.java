package io.reactivex.internal.queue;

import io.reactivex.internal.b.h;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements h<E> {
    private static final Integer erJ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    int d(long j, int i) {
        return ((int) j) & i;
    }

    public SpscArrayQueue(int i) {
        super(f.jk(i));
        this.lookAheadStep = Math.min(i / 4, erJ.intValue());
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.mask;
        long j = this.producerIndex.get();
        int d = d(j, i);
        if (j >= this.producerLookAhead) {
            long j2 = j + ((long) this.lookAheadStep);
            if (jf(d(j2, i)) == null) {
                this.producerLookAhead = j2;
            } else if (jf(d) != null) {
                return false;
            }
        }
        d(d, (Object) e);
        cT(j + 1);
        return true;
    }

    public E poll() {
        long j = this.consumerIndex.get();
        int cV = cV(j);
        E jf = jf(cV);
        if (jf == null) {
            return null;
        }
        cU(j + 1);
        d(cV, null);
        return jf;
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    void cT(long j) {
        this.producerIndex.lazySet(j);
    }

    void cU(long j) {
        this.consumerIndex.lazySet(j);
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

    int cV(long j) {
        return ((int) j) & this.mask;
    }

    void d(int i, E e) {
        lazySet(i, e);
    }

    E jf(int i) {
        return get(i);
    }
}
