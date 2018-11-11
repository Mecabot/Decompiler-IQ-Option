package io.reactivex.internal.observers;

import io.reactivex.c.a;
import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<b> implements io.reactivex.b, e<Throwable>, b {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final e<? super Throwable> onError;

    public CallbackCompletableObserver(e<? super Throwable> eVar, a aVar) {
        this.onError = eVar;
        this.onComplete = aVar;
    }

    /* renamed from: o */
    public void accept(Throwable th) {
        io.reactivex.d.a.onError(new OnErrorNotImplementedException(th));
    }

    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            io.reactivex.d.a.onError(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.V(th2);
            io.reactivex.d.a.onError(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void d(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
