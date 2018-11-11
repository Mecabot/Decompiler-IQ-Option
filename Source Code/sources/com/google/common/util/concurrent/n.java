package com.google.common.util.concurrent;

/* compiled from: FutureCallback */
public interface n<V> {
    void l(Throwable th);

    void onSuccess(V v);
}
