package io.reactivex.b;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.operators.flowable.FlowableRefCount;

/* compiled from: ConnectableFlowable */
public abstract class a<T> extends e<T> {
    public abstract void e(io.reactivex.c.e<? super b> eVar);

    public e<T> aWr() {
        return io.reactivex.d.a.g(new FlowableRefCount(this));
    }
}
