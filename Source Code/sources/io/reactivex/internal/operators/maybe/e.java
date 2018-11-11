package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.c;
import io.reactivex.i;
import io.reactivex.internal.b.g;
import io.reactivex.j;

/* compiled from: MaybeJust */
public final class e<T> extends i<T> implements g<T> {
    final T value;

    public e(T t) {
        this.value = t;
    }

    protected void b(j<? super T> jVar) {
        jVar.d(c.aWp());
        jVar.onSuccess(this.value);
    }

    public T call() {
        return this.value;
    }
}
