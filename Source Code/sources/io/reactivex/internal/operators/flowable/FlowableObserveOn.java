package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.b.f;
import io.reactivex.internal.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.n;
import io.reactivex.n.c;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;

public final class FlowableObserveOn<T> extends a<T, T> {
    final boolean delayError;
    final int prefetch;
    final n scheduler;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements h<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        i<T> queue;
        final AtomicLong requested = new AtomicLong();
        d s;
        int sourceMode;
        final c worker;

        abstract void aWN();

        abstract void aWO();

        abstract void aWP();

        BaseObserveOnSubscriber(c cVar, boolean z, int i) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public final void e(T t) {
            if (!this.done) {
                if (this.sourceMode == 2) {
                    aWM();
                    return;
                }
                if (!this.queue.offer(t)) {
                    this.s.cancel();
                    this.error = new MissingBackpressureException("Queue is full?!");
                    this.done = true;
                }
                aWM();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            aWM();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                aWM();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                aWM();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        final void aWM() {
            if (getAndIncrement() == 0) {
                this.worker.r(this);
            }
        }

        public final void run() {
            if (this.outputFused) {
                aWN();
            } else if (this.sourceMode == 1) {
                aWO();
            } else {
                aWP();
            }
        }

        final boolean a(boolean z, boolean z2, org.a.c<?> cVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (z) {
                Throwable th;
                if (!this.delayError) {
                    th = this.error;
                    if (th != null) {
                        clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return true;
                    } else if (z2) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                } else if (z2) {
                    th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                }
            }
            return false;
        }

        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final io.reactivex.internal.b.a<? super T> actual;
        long consumed;

        ObserveOnConditionalSubscriber(io.reactivex.internal.b.a<? super T> aVar, c cVar, boolean z, int i) {
            super(cVar, z, i);
            this.actual = aVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof f) {
                    f fVar = (f) dVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = fVar;
                        this.done = true;
                        this.actual.a(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = fVar;
                        this.actual.a(this);
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.a(this);
                dVar.request((long) this.prefetch);
            }
        }

        void aWO() {
            io.reactivex.internal.b.a aVar = this.actual;
            i iVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object poll = iVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                aVar.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (aVar.cf(poll)) {
                                j++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        this.s.cancel();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (iVar.isEmpty()) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        void aWP() {
            org.a.c cVar = this.actual;
            i iVar = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            int i = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j != j3) {
                    boolean z = this.done;
                    try {
                        Object poll = iVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            if (cVar.cf(poll)) {
                                j++;
                            }
                            long j4 = j2 + 1;
                            if (j4 == ((long) this.limit)) {
                                this.s.request(j4);
                                j2 = 0;
                            } else {
                                j2 = j4;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        this.s.cancel();
                        iVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j != j3 || !a(this.done, iVar.isEmpty(), cVar)) {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        this.consumed = j2;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        void aWN() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.e(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public T poll() {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j = this.consumed + 1;
                if (j == ((long) this.limit)) {
                    this.consumed = 0;
                    this.s.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return poll;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements h<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final org.a.c<? super T> actual;

        ObserveOnSubscriber(org.a.c<? super T> cVar, c cVar2, boolean z, int i) {
            super(cVar2, z, i);
            this.actual = cVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof f) {
                    f fVar = (f) dVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = fVar;
                        this.done = true;
                        this.actual.a(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = fVar;
                        this.actual.a(this);
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.a(this);
                dVar.request((long) this.prefetch);
            }
        }

        void aWO() {
            org.a.c cVar = this.actual;
            i iVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object poll = iVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                cVar.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            cVar.e(poll);
                            j++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        this.s.cancel();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (iVar.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        void aWP() {
            org.a.c cVar = this.actual;
            i iVar = this.queue;
            long j = this.produced;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    boolean z = this.done;
                    try {
                        Object poll = iVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.e(poll);
                            long j3 = j + 1;
                            if (j3 == ((long) this.limit)) {
                                if (j2 != Long.MAX_VALUE) {
                                    j2 = this.requested.addAndGet(-j3);
                                }
                                this.s.request(j3);
                                j = 0;
                            } else {
                                j = j3;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        this.s.cancel();
                        iVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j != j2 || !a(this.done, iVar.isEmpty(), cVar)) {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        void aWN() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.e(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public T poll() {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j = this.produced + 1;
                if (j == ((long) this.limit)) {
                    this.produced = 0;
                    this.s.request(j);
                } else {
                    this.produced = j;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(e<T> eVar, n nVar, boolean z, int i) {
        super(eVar);
        this.scheduler = nVar;
        this.delayError = z;
        this.prefetch = i;
    }

    public void a(org.a.c<? super T> cVar) {
        c aWg = this.scheduler.aWg();
        if (cVar instanceof io.reactivex.internal.b.a) {
            this.eqM.a(new ObserveOnConditionalSubscriber((io.reactivex.internal.b.a) cVar, aWg, this.delayError, this.prefetch));
        } else {
            this.eqM.a(new ObserveOnSubscriber(cVar, aWg, this.delayError, this.prefetch));
        }
    }
}
