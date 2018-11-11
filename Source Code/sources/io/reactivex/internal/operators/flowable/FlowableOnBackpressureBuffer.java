package io.reactivex.internal.operators.flowable;

import io.reactivex.c.a;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;

public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {
    final int bufferSize;
    final boolean delayError;
    final a onOverflow;
    final boolean unbounded;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements h<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final a onOverflow;
        boolean outputFused;
        final io.reactivex.internal.b.h<T> queue;
        final AtomicLong requested = new AtomicLong();
        d s;

        BackpressureBufferSubscriber(c<? super T> cVar, int i, boolean z, boolean z2, a aVar) {
            io.reactivex.internal.b.h aVar2;
            this.actual = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                aVar2 = new io.reactivex.internal.queue.a(i);
            } else {
                aVar2 = new SpscArrayQueue(i);
            }
            this.queue = aVar2;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void e(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.actual.e(null);
                } else {
                    drain();
                }
                return;
            }
            this.s.cancel();
            Throwable missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        public void request(long j) {
            if (!this.outputFused && SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.b.h hVar = this.queue;
                c cVar = this.actual;
                int i = 1;
                while (!a(this.done, hVar.isEmpty(), cVar)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        Object poll = hVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.e(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !a(this.done, hVar.isEmpty(), cVar)) {
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j2);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean a(boolean z, boolean z2, c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th;
                if (!this.delayError) {
                    th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        cVar.onError(th);
                        return true;
                    } else if (z2) {
                        cVar.onComplete();
                        return true;
                    }
                } else if (z2) {
                    th = this.error;
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

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public T poll() {
            return this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public FlowableOnBackpressureBuffer(e<T> eVar, int i, boolean z, boolean z2, a aVar) {
        super(eVar);
        this.bufferSize = i;
        this.unbounded = z;
        this.delayError = z2;
        this.onOverflow = aVar;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new BackpressureBufferSubscriber(cVar, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }
}
