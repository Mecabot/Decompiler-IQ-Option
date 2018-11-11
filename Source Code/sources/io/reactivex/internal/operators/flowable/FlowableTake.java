package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.a.c;
import org.a.d;

public final class FlowableTake<T> extends a<T, T> {
    final long limit;

    static final class TakeSubscriber<T> extends AtomicBoolean implements h<T>, d {
        private static final long serialVersionUID = -5636543848937116287L;
        final c<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        d subscription;

        TakeSubscriber(c<? super T> cVar, long j) {
            this.actual = cVar;
            this.limit = j;
            this.remaining = j;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                if (this.limit == 0) {
                    dVar.cancel();
                    this.done = true;
                    EmptySubscription.complete(this.actual);
                    return;
                }
                this.actual.a(this);
            }
        }

        public void e(T t) {
            if (!this.done) {
                long j = this.remaining;
                this.remaining = j - 1;
                if (j > 0) {
                    Object obj = this.remaining == 0 ? 1 : null;
                    this.actual.e(t);
                    if (obj != null) {
                        this.subscription.cancel();
                        onComplete();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                a.onError(th);
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (get() || !compareAndSet(false, true) || j < this.limit) {
                this.subscription.request(j);
            } else {
                this.subscription.request(Long.MAX_VALUE);
            }
        }

        public void cancel() {
            this.subscription.cancel();
        }
    }

    public FlowableTake(e<T> eVar, long j) {
        super(eVar);
        this.limit = j;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new TakeSubscriber(cVar, this.limit));
    }
}
