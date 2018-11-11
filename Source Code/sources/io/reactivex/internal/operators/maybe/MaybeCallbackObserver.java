package io.reactivex.internal.operators.maybe;

import io.reactivex.c.a;
import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<b> implements b, j<T> {
    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onSuccess;

    public MaybeCallbackObserver(e<? super T> eVar, e<? super Throwable> eVar2, a aVar) {
        this.onSuccess = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void d(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            io.reactivex.d.a.onError(th);
        }
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.V(th2);
            io.reactivex.d.a.onError(new CompositeException(th, th2));
        }
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            io.reactivex.d.a.onError(th);
        }
    }
}
