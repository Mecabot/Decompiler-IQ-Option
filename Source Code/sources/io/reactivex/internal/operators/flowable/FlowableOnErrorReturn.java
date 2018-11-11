package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.a.b;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.a.c;

public final class FlowableOnErrorReturn<T> extends a<T, T> {
    final f<? super Throwable, ? extends T> valueSupplier;

    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final f<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnSubscriber(c<? super T> cVar, f<? super Throwable, ? extends T> fVar) {
            super(cVar);
            this.valueSupplier = fVar;
        }

        public void e(T t) {
            this.produced++;
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            try {
                complete(b.requireNonNull(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                a.V(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public FlowableOnErrorReturn(e<T> eVar, f<? super Throwable, ? extends T> fVar) {
        super(eVar);
        this.valueSupplier = fVar;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new OnErrorReturnSubscriber(cVar, this.valueSupplier));
    }
}
