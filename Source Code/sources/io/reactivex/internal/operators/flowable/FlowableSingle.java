package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.a.c;
import org.a.d;

public final class FlowableSingle<T> extends a<T, T> {
    final T defaultValue;
    final boolean failOnEmpty;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements h<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        d s;

        SingleElementSubscriber(c<? super T> cVar, T t, boolean z) {
            super(cVar);
            this.defaultValue = t;
            this.failOnEmpty = z;
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
                if (this.value != null) {
                    this.done = true;
                    this.s.cancel();
                    this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
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
                Object obj = this.value;
                this.value = null;
                if (obj == null) {
                    obj = this.defaultValue;
                }
                if (obj != null) {
                    complete(obj);
                } else if (this.failOnEmpty) {
                    this.actual.onError(new NoSuchElementException());
                } else {
                    this.actual.onComplete();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }

    public FlowableSingle(e<T> eVar, T t, boolean z) {
        super(eVar);
        this.defaultValue = t;
        this.failOnEmpty = z;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new SingleElementSubscriber(cVar, this.defaultValue, this.failOnEmpty));
    }
}
