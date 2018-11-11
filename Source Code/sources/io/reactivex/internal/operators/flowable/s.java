package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.c;
import org.a.d;

/* compiled from: FlowableSkip */
public final class s<T> extends a<T, T> {
    final long erp;

    /* compiled from: FlowableSkip */
    static final class a<T> implements h<T>, d {
        final c<? super T> actual;
        long remaining;
        d s;

        a(c<? super T> cVar, long j) {
            this.actual = cVar;
            this.remaining = j;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                long j = this.remaining;
                this.s = dVar;
                this.actual.a(this);
                dVar.request(j);
            }
        }

        public void e(T t) {
            if (this.remaining != 0) {
                this.remaining--;
            } else {
                this.actual.e(t);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void request(long j) {
            this.s.request(j);
        }

        public void cancel() {
            this.s.cancel();
        }
    }

    public s(e<T> eVar, long j) {
        super(eVar);
        this.erp = j;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new a(cVar, this.erp));
    }
}
