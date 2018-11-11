package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;

public final class FlowableOnBackpressureError<T> extends a<T, T> {

    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements h<T>, d {
        private static final long serialVersionUID = -3176480756392482682L;
        final c<? super T> actual;
        boolean done;
        d s;

        BackpressureErrorSubscriber(c<? super T> cVar) {
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
            if (!this.done) {
                if (get() != 0) {
                    this.actual.e(t);
                    b.c(this, 1);
                } else {
                    onError(new MissingBackpressureException("could not emit value due to lack of requests"));
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this, j);
            }
        }

        public void cancel() {
            this.s.cancel();
        }
    }

    public FlowableOnBackpressureError(e<T> eVar) {
        super(eVar);
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new BackpressureErrorSubscriber(cVar));
    }
}
