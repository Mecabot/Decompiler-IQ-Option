package io.reactivex.internal.disposables;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable(b bVar) {
        lazySet(bVar);
    }

    public boolean h(b bVar) {
        return DisposableHelper.replace(this, bVar);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }
}
