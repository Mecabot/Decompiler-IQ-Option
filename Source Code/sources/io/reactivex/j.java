package io.reactivex;

import io.reactivex.disposables.b;

/* compiled from: MaybeObserver */
public interface j<T> {
    void d(b bVar);

    void onComplete();

    void onError(Throwable th);

    void onSuccess(T t);
}
