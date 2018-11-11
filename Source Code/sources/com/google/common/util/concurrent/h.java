package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* compiled from: Callables */
public final class h {
    public static <T> Callable<T> aQ(final T t) {
        return new Callable<T>() {
            public T call() {
                return t;
            }
        };
    }
}
