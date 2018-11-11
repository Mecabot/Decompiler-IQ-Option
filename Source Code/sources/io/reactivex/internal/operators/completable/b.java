package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.disposables.c;

/* compiled from: CompletableFromAction */
public final class b extends a {
    final io.reactivex.c.a eqF;

    public b(io.reactivex.c.a aVar) {
        this.eqF = aVar;
    }

    protected void b(io.reactivex.b bVar) {
        io.reactivex.disposables.b aWo = c.aWo();
        bVar.d(aWo);
        try {
            this.eqF.run();
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
