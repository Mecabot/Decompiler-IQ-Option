package io.reactivex.internal.operators.maybe;

import io.reactivex.i;
import io.reactivex.internal.b.g;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.j;

/* compiled from: MaybeEmpty */
public final class b extends i<Object> implements g<Object> {
    public static final b ers = new b();

    public Object call() {
        return null;
    }

    protected void b(j<? super Object> jVar) {
        EmptyDisposable.complete((j) jVar);
    }
}
