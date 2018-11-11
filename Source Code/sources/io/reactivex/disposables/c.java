package io.reactivex.disposables;

import io.reactivex.internal.a.a;
import io.reactivex.internal.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Disposables */
public final class c {
    public static b s(Runnable runnable) {
        b.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b aWo() {
        return s(a.eqp);
    }

    public static b aWp() {
        return EmptyDisposable.INSTANCE;
    }
}
