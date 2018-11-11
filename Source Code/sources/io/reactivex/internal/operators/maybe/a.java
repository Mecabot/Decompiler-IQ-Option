package io.reactivex.internal.operators.maybe;

import io.reactivex.i;
import io.reactivex.k;

/* compiled from: AbstractMaybeWithUpstream */
abstract class a<T, R> extends i<R> {
    protected final k<T> err;

    a(k<T> kVar) {
        this.err = kVar;
    }
}
