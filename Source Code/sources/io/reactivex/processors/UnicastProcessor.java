package io.reactivex.processors;

import io.reactivex.internal.queue.a;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class UnicastProcessor<T> extends a<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final AtomicReference<Runnable> etE;
    final AtomicReference<c<? super T>> etF;
    final BasicIntQueueSubscription<T> etG;
    boolean etH;
    final AtomicBoolean once;
    final a<T> queue;
    final AtomicLong requested;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.etH = true;
            return 2;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(UnicastProcessor.this.requested, j);
                UnicastProcessor.this.drain();
            }
        }

        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.aXr();
                if (!UnicastProcessor.this.etH && UnicastProcessor.this.etG.getAndIncrement() == 0) {
                    UnicastProcessor.this.queue.clear();
                    UnicastProcessor.this.etF.lazySet(null);
                }
            }
        }
    }

    public static <T> UnicastProcessor<T> jl(int i) {
        return new UnicastProcessor(i);
    }

    UnicastProcessor(int i) {
        this(i, null, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.queue = new a(io.reactivex.internal.a.b.n(i, "capacityHint"));
        this.etE = new AtomicReference(runnable);
        this.delayError = z;
        this.etF = new AtomicReference();
        this.once = new AtomicBoolean();
        this.etG = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    void aXr() {
        Runnable runnable = (Runnable) this.etE.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    void d(c<? super T> cVar) {
        a aVar = this.queue;
        boolean z = this.delayError ^ 1;
        int i = 1;
        do {
            long j;
            long j2 = this.requested.get();
            long j3 = 0;
            while (j2 != j3) {
                boolean z2 = this.done;
                Object poll = aVar.poll();
                boolean z3 = poll == null;
                j = j3;
                if (!a(z, z2, z3, cVar, aVar)) {
                    if (z3) {
                        break;
                    }
                    cVar.e(poll);
                    j3 = j + 1;
                } else {
                    return;
                }
            }
            j = j3;
            c<? super T> cVar2 = cVar;
            if (j2 == j) {
                if (a(z, this.done, aVar.isEmpty(), cVar2, aVar)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                this.requested.addAndGet(-j);
            }
            i = this.etG.addAndGet(-i);
        } while (i != 0);
    }

    void e(c<? super T> cVar) {
        a aVar = this.queue;
        int i = 1;
        int i2 = this.delayError ^ 1;
        while (!this.cancelled) {
            boolean z = this.done;
            if (i2 == 0 || !z || this.error == null) {
                cVar.e(null);
                if (z) {
                    this.etF.lazySet(null);
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return;
                }
                i = this.etG.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            aVar.clear();
            this.etF.lazySet(null);
            cVar.onError(this.error);
            return;
        }
        aVar.clear();
        this.etF.lazySet(null);
    }

    void drain() {
        if (this.etG.getAndIncrement() == 0) {
            int i = 1;
            c cVar = (c) this.etF.get();
            while (cVar == null) {
                i = this.etG.addAndGet(-i);
                if (i != 0) {
                    cVar = (c) this.etF.get();
                } else {
                    return;
                }
            }
            if (this.etH) {
                e(cVar);
            } else {
                d(cVar);
            }
        }
    }

    boolean a(boolean z, boolean z2, boolean z3, c<? super T> cVar, a<T> aVar) {
        if (this.cancelled) {
            aVar.clear();
            this.etF.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.error != null) {
                aVar.clear();
                this.etF.lazySet(null);
                cVar.onError(this.error);
                return true;
            } else if (z3) {
                Throwable th = this.error;
                this.etF.lazySet(null);
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public void a(d dVar) {
        if (this.done || this.cancelled) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void e(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.queue.offer(t);
            drain();
        }
    }

    public void onError(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.cancelled) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        aXr();
        drain();
    }

    public void onComplete() {
        if (!this.done && !this.cancelled) {
            this.done = true;
            aXr();
            drain();
        }
    }

    protected void a(c<? super T> cVar) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.a(this.etG);
        this.etF.set(cVar);
        if (this.cancelled) {
            this.etF.lazySet(null);
        } else {
            drain();
        }
    }
}
