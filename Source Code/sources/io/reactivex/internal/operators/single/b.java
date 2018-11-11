package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.o;
import io.reactivex.q;
import java.util.concurrent.Callable;

/* compiled from: SingleError */
public final class b<T> extends o<T> {
    final Callable<? extends Throwable> eqV;

    public b(Callable<? extends Throwable> callable) {
        this.eqV = callable;
    }

    protected void b(q<? super T> qVar) {
        Throwable th;
        try {
            th = (Throwable) io.reactivex.internal.a.b.requireNonNull(this.eqV.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.V(th);
        }
        EmptyDisposable.error(th, (q) qVar);
    }
}
