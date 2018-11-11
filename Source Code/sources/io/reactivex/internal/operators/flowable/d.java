package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.b.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;

/* compiled from: FlowableElementAtMaybe */
public final class d<T> extends i<T> implements b<T> {
    final e<T> eqM;
    final long index;

    /* compiled from: FlowableElementAtMaybe */
    static final class a<T> implements io.reactivex.disposables.b, h<T> {
        final j<? super T> actual;
        long count;
        boolean done;
        final long index;
        org.a.d s;

        a(j<? super T> jVar, long j) {
            this.actual = jVar;
            this.index = j;
        }

        public void a(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.d(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void e(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.s.cancel();
                    this.s = SubscriptionHelper.CANCELLED;
                    this.actual.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            this.s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.s = SubscriptionHelper.CANCELLED;
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        public void dispose() {
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.s == SubscriptionHelper.CANCELLED;
        }
    }

    public d(e<T> eVar, long j) {
        this.eqM = eVar;
        this.index = j;
    }

    protected void b(j<? super T> jVar) {
        this.eqM.a(new a(jVar, this.index));
    }

    public e<T> aWu() {
        return io.reactivex.d.a.g(new FlowableElementAt(this.eqM, this.index, null, false));
    }
}
