package io.reactivex.internal.subscriptions;

import io.reactivex.internal.a.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<d> missedSubscription = new AtomicReference();
    long requested;
    protected boolean unbounded;

    public final void b(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        b.requireNonNull(dVar, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            d dVar2 = this.actual;
            if (dVar2 != null) {
                dVar2.cancel();
            }
            this.actual = dVar;
            long j = this.requested;
            if (decrementAndGet() != 0) {
                aWG();
            }
            if (j != 0) {
                dVar.request(j);
            }
            return;
        }
        dVar = (d) this.missedSubscription.getAndSet(dVar);
        if (dVar != null) {
            dVar.cancel();
        }
        drain();
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != Long.MAX_VALUE) {
                    j2 = io.reactivex.internal.util.b.y(j2, j);
                    this.requested = j2;
                    if (j2 == Long.MAX_VALUE) {
                        this.unbounded = true;
                    }
                }
                d dVar = this.actual;
                if (decrementAndGet() != 0) {
                    aWG();
                }
                if (dVar != null) {
                    dVar.request(j);
                }
                return;
            }
            io.reactivex.internal.util.b.a(this.missedRequested, j);
            drain();
        }
    }

    public final void cX(long j) {
        if (!this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != Long.MAX_VALUE) {
                    long j3 = j2 - j;
                    j = 0;
                    if (j3 < 0) {
                        SubscriptionHelper.reportMoreProduced(j3);
                    } else {
                        j = j3;
                    }
                    this.requested = j;
                }
                if (decrementAndGet() != 0) {
                    aWG();
                    return;
                }
                return;
            }
            io.reactivex.internal.util.b.a(this.missedProduced, j);
            drain();
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    final void drain() {
        if (getAndIncrement() == 0) {
            aWG();
        }
    }

    final void aWG() {
        d dVar = null;
        long j = 0;
        int i = 1;
        do {
            int i2;
            d dVar2;
            d dVar3 = (d) this.missedSubscription.get();
            if (dVar3 != null) {
                dVar3 = (d) this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0);
            }
            d dVar4 = this.actual;
            if (this.cancelled) {
                if (dVar4 != null) {
                    dVar4.cancel();
                    this.actual = null;
                }
                if (dVar3 != null) {
                    dVar3.cancel();
                }
                i2 = i;
                dVar2 = dVar;
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = io.reactivex.internal.util.b.y(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        i2 = i;
                        dVar2 = dVar;
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            SubscriptionHelper.reportMoreProduced(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    } else {
                        i2 = i;
                        dVar2 = dVar;
                    }
                    this.requested = j4;
                } else {
                    i2 = i;
                    dVar2 = dVar;
                }
                if (dVar3 != null) {
                    if (dVar4 != null) {
                        dVar4.cancel();
                    }
                    this.actual = dVar3;
                    if (j4 != 0) {
                        j = io.reactivex.internal.util.b.y(j, j4);
                        dVar = dVar3;
                    }
                } else if (!(dVar4 == null || j2 == 0)) {
                    j = io.reactivex.internal.util.b.y(j, j2);
                    dVar = dVar4;
                }
                i = i2;
                i = addAndGet(-i);
            }
            i = i2;
            dVar = dVar2;
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            dVar.request(j);
        }
    }
}
