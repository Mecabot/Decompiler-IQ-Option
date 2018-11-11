package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* compiled from: AbstractListeningExecutorService */
public abstract class c extends AbstractExecutorService implements u {
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return TrustedListenableFutureTask.b(runnable, t);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.d(callable);
    }

    /* renamed from: i */
    public s<?> submit(Runnable runnable) {
        return (s) super.submit(runnable);
    }

    /* renamed from: a */
    public <T> s<T> submit(Runnable runnable, T t) {
        return (s) super.submit(runnable, t);
    }

    /* renamed from: c */
    public <T> s<T> submit(Callable<T> callable) {
        return (s) super.submit(callable);
    }
}
