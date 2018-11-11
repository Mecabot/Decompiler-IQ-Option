package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements h<T>, d {
        private static final long serialVersionUID = 163080509307634843L;
        final c<? super T> actual;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference();
        volatile boolean done;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        d s;

        BackpressureLatestSubscriber(c<? super T> cVar) {
            this.actual = cVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void e(T t) {
            this.current.lazySet(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(null);
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                c cVar = this.actual;
                AtomicLong atomicLong = this.requested;
                AtomicReference atomicReference = this.current;
                int i = 1;
                do {
                    boolean z;
                    boolean z2;
                    long j = 0;
                    while (true) {
                        z = false;
                        if (j == atomicLong.get()) {
                            break;
                        }
                        z2 = this.done;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z3 = andSet == null;
                        if (!a(z2, z3, cVar, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            cVar.e(andSet);
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (j == atomicLong.get()) {
                        z2 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (a(z2, z, cVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j != 0) {
                        b.c(atomicLong, j);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        boolean a(boolean z, boolean z2, c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet(null);
                    cVar.onError(th);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableOnBackpressureLatest(e<T> eVar) {
        super(eVar);
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new BackpressureLatestSubscriber(cVar));
    }
}
