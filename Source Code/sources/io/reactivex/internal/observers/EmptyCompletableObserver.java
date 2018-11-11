package io.reactivex.internal.observers;

import io.reactivex.d.a;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver extends AtomicReference<b> implements io.reactivex.b, b {
    private static final long serialVersionUID = -7545121636549663526L;

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        a.onError(new OnErrorNotImplementedException(th));
    }

    public void d(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
