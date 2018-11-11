package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.a;
import io.reactivex.o;
import io.reactivex.q;
import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable */
public final class c<T> extends o<T> {
    final Callable<? extends T> callable;

    public c(Callable<? extends T> callable) {
        this.callable = callable;
    }

    protected void b(q<? super T> qVar) {
        b aWo = io.reactivex.disposables.c.aWo();
        qVar.d(aWo);
        if (!aWo.isDisposed()) {
            try {
                Object requireNonNull = io.reactivex.internal.a.b.requireNonNull(this.callable.call(), "The callable returned a null value");
                if (!aWo.isDisposed()) {
                    qVar.onSuccess(requireNonNull);
                }
            } catch (Throwable th) {
                a.V(th);
                if (aWo.isDisposed()) {
                    io.reactivex.d.a.onError(th);
                } else {
                    qVar.onError(th);
                }
            }
        }
    }
}
