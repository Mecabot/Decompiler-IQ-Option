package io.reactivex.internal.operators.flowable;

import io.reactivex.c.e;
import io.reactivex.exceptions.a;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;

public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements e<T> {
    final e<? super T> onDrop = this;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements h<T>, d {
        private static final long serialVersionUID = -6246093802440953054L;
        final c<? super T> actual;
        boolean done;
        final e<? super T> onDrop;
        d s;

        BackpressureDropSubscriber(c<? super T> cVar, e<? super T> eVar) {
            this.actual = cVar;
            this.onDrop = eVar;
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
                    try {
                        this.onDrop.accept(t);
                    } catch (Throwable th) {
                        a.V(th);
                        cancel();
                        onError(th);
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
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

    public void accept(T t) {
    }

    public FlowableOnBackpressureDrop(io.reactivex.e<T> eVar) {
        super(eVar);
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new BackpressureDropSubscriber(cVar, this.onDrop));
    }
}
