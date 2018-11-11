package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.a.b;

/* compiled from: AbstractFlowableWithUpstream */
abstract class a<T, R> extends e<R> {
    protected final e<T> eqM;

    a(e<T> eVar) {
        this.eqM = (e) b.requireNonNull(eVar, "source is null");
    }
}
