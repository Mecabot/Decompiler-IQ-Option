package io.reactivex;

import io.reactivex.disposables.b;

/* compiled from: Observer */
public interface m<T> {
    void d(b bVar);

    void e(T t);

    void onComplete();

    void onError(Throwable th);
}
