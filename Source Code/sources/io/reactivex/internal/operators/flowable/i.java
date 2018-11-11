package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.exceptions.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.a.c;

/* compiled from: FlowableFromFuture */
public final class i<T> extends e<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public i(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    public void a(c<? super T> cVar) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(cVar);
        cVar.a(deferredScalarSubscription);
        try {
            Object obj = this.unit != null ? this.future.get(this.timeout, this.unit) : this.future.get();
            if (obj == null) {
                cVar.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable th) {
            a.V(th);
            if (!deferredScalarSubscription.isCancelled()) {
                cVar.onError(th);
            }
        }
    }
}
