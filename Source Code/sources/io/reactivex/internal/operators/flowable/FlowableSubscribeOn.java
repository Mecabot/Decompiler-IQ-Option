package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class FlowableSubscribeOn<T> extends a<T, T> {
    final boolean nonScheduledRequests;
    final n scheduler;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements h<T>, Runnable, d {
        private static final long serialVersionUID = 8094547886072529208L;
        final c<? super T> actual;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<d> s = new AtomicReference();
        b<T> source;
        final n.c worker;

        static final class a implements Runnable {
            private final long erp;
            private final d s;

            a(d dVar, long j) {
                this.s = dVar;
                this.erp = j;
            }

            public void run() {
                this.s.request(this.erp);
            }
        }

        SubscribeOnSubscriber(c<? super T> cVar, n.c cVar2, b<T> bVar, boolean z) {
            this.actual = cVar;
            this.worker = cVar2;
            this.source = bVar;
            this.nonScheduledRequests = z ^ 1;
        }

        public void run() {
            lazySet(Thread.currentThread());
            b bVar = this.source;
            this.source = null;
            bVar.b(this);
        }

        public void a(d dVar) {
            if (SubscriptionHelper.setOnce(this.s, dVar)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, dVar);
                }
            }
        }

        public void e(T t) {
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                d dVar = (d) this.s.get();
                if (dVar != null) {
                    a(j, dVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.requested, j);
                d dVar2 = (d) this.s.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, dVar2);
                    }
                }
            }
        }

        void a(long j, d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j);
            } else {
                this.worker.r(new a(dVar, j));
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            this.worker.dispose();
        }
    }

    public FlowableSubscribeOn(e<T> eVar, n nVar, boolean z) {
        super(eVar);
        this.scheduler = nVar;
        this.nonScheduledRequests = z;
    }

    public void a(c<? super T> cVar) {
        n.c aWg = this.scheduler.aWg();
        Object subscribeOnSubscriber = new SubscribeOnSubscriber(cVar, aWg, this.eqM, this.nonScheduledRequests);
        cVar.a(subscribeOnSubscriber);
        aWg.r(subscribeOnSubscriber);
    }
}
