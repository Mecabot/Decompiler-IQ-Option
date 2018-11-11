package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.a.c;
import org.a.d;

public final class FlowableElementAt<T> extends a<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements h<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        d s;

        ElementAtSubscriber(c<? super T> cVar, long j, T t, boolean z) {
            super(cVar);
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
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
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.s.cancel();
                    complete(t);
                    return;
                }
                this.count = j + 1;
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
                Object obj = this.defaultValue;
                if (obj != null) {
                    complete(obj);
                } else if (this.errorOnFewer) {
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

    public FlowableElementAt(e<T> eVar, long j, T t, boolean z) {
        super(eVar);
        this.index = j;
        this.defaultValue = t;
        this.errorOnFewer = z;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new ElementAtSubscriber(cVar, this.index, this.defaultValue, this.errorOnFewer));
    }
}
