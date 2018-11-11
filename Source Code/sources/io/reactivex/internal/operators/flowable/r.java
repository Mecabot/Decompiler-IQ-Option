package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.b.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.o;
import io.reactivex.q;
import java.util.NoSuchElementException;
import org.a.d;

/* compiled from: FlowableSingleSingle */
public final class r<T> extends o<T> implements b<T> {
    final T defaultValue;
    final e<T> eqM;

    /* compiled from: FlowableSingleSingle */
    static final class a<T> implements io.reactivex.disposables.b, h<T> {
        final q<? super T> actual;
        final T defaultValue;
        boolean done;
        d s;
        T value;

        a(q<? super T> qVar, T t) {
            this.actual = qVar;
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
                if (this.value != null) {
                    this.done = true;
                    this.s.cancel();
                    this.s = SubscriptionHelper.CANCELLED;
                    this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
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
            if (!this.done) {
                this.done = true;
                this.s = SubscriptionHelper.CANCELLED;
                Object obj = this.value;
                this.value = null;
                if (obj == null) {
                    obj = this.defaultValue;
                }
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

    public r(e<T> eVar, T t) {
        this.eqM = eVar;
        this.defaultValue = t;
    }

    protected void b(q<? super T> qVar) {
        this.eqM.a(new a(qVar, this.defaultValue));
    }

    public e<T> aWu() {
        return io.reactivex.d.a.g(new FlowableSingle(this.eqM, this.defaultValue, true));
    }
}
