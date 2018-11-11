package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.a;
import io.reactivex.i;
import io.reactivex.j;
import java.util.concurrent.Callable;

/* compiled from: MaybeFromCallable */
public final class c<T> extends i<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public c(Callable<? extends T> callable) {
        this.callable = callable;
    }

    protected void b(j<? super T> jVar) {
        b aWo = io.reactivex.disposables.c.aWo();
        jVar.d(aWo);
        if (!aWo.isDisposed()) {
            try {
                Object call = this.callable.call();
                if (!aWo.isDisposed()) {
                    if (call == null) {
                        jVar.onComplete();
                    } else {
                        jVar.onSuccess(call);
                    }
                }
            } catch (Throwable th) {
                a.V(th);
                if (aWo.isDisposed()) {
                    io.reactivex.d.a.onError(th);
                } else {
                    jVar.onError(th);
                }
            }
        }
    }

    public T call() {
        return this.callable.call();
    }
}
