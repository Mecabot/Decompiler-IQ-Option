package io.reactivex.internal.operators.completable;

import io.reactivex.b;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletableEmpty */
public final class a extends io.reactivex.a {
    public static final io.reactivex.a eqE = new a();

    private a() {
    }

    public void b(b bVar) {
        EmptyDisposable.complete(bVar);
    }
}
