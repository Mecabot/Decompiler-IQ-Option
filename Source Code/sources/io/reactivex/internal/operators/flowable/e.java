package io.reactivex.internal.operators.flowable;

import io.reactivex.h;
import io.reactivex.internal.b.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.o;
import io.reactivex.q;
import java.util.NoSuchElementException;
import org.a.d;

/* compiled from: FlowableElementAtSingle */
public final class e<T> extends o<T> implements b<T> {
    final T defaultValue;
    final io.reactivex.e<T> eqM;
    final long index;

    /* compiled from: FlowableElementAtSingle */
    static final class a<T> implements io.reactivex.disposables.b, h<T> {
        final q<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;
        d s;

        a(q<? super T> qVar, long j, T t) {
            this.actual = qVar;
            this.index = j;
            this.defaultValue = t;
        }

        public void a(d dVar) {
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
                Object obj = this.defaultValue;
                if (obj != null) {
                    this.actual.onSuccess(obj);
                } else {
                    this.actual.onError(new NoSuchElementException());
                }
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

    public e(io.reactivex.e<T> eVar, long j, T t) {
        this.eqM = eVar;
        this.index = j;
        this.defaultValue = t;
    }

    protected void b(q<? super T> qVar) {
        this.eqM.a(new a(qVar, this.index, this.defaultValue));
    }

    public io.reactivex.e<T> aWu() {
        return io.reactivex.d.a.g(new FlowableElementAt(this.eqM, this.index, this.defaultValue, true));
    }
}
