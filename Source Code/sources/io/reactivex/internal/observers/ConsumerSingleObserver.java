package io.reactivex.internal.observers;

import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<b> implements b, q<T> {
    private static final long serialVersionUID = -7012088219455310787L;
    final e<? super Throwable> onError;
    final e<? super T> onSuccess;

    public ConsumerSingleObserver(e<? super T> eVar, e<? super Throwable> eVar2) {
        this.onSuccess = eVar;
        this.onError = eVar2;
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            a.V(th2);
            io.reactivex.d.a.onError(new CompositeException(th, th2));
        }
    }

    public void d(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            a.V(th);
            io.reactivex.d.a.onError(th);
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
