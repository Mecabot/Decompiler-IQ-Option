package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.b;

/* compiled from: CompletableFromRunnable */
public final class c extends a {
    final Runnable runnable;

    public c(Runnable runnable) {
        this.runnable = runnable;
    }

    protected void b(b bVar) {
        io.reactivex.disposables.b aWo = io.reactivex.disposables.c.aWo();
        bVar.d(aWo);
        try {
            this.runnable.run();
            if (!aWo.isDisposed()) {
                bVar.onComplete();
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            if (!aWo.isDisposed()) {
                bVar.onError(th);
            }
        }
    }
}
