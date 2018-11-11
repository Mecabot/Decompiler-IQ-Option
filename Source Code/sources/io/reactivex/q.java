package io.reactivex;

import io.reactivex.disposables.b;

/* compiled from: SingleObserver */
public interface q<T> {
    void d(b bVar);

    void onError(Throwable th);

    void onSuccess(T t);
}
