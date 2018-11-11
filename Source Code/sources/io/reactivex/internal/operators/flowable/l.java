package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.b.g;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.a.c;

/* compiled from: FlowableJust */
public final class l<T> extends e<T> implements g<T> {
    private final T value;

    public l(T t) {
        this.value = t;
    }

    protected void a(c<? super T> cVar) {
        cVar.a(new ScalarSubscription(cVar, this.value));
    }

    public T call() {
        return this.value;
    }
}
