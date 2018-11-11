package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver */
public final class d<T> implements q<T> {
    final q<? super T> actual;
    final AtomicReference<b> eqD;

    public d(AtomicReference<b> atomicReference, q<? super T> qVar) {
        this.eqD = atomicReference;
        this.actual = qVar;
    }

    public void d(b bVar) {
        DisposableHelper.replace(this.eqD, bVar);
    }

    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    public void onError(Throwable th) {
        this.actual.onError(th);
    }
}
