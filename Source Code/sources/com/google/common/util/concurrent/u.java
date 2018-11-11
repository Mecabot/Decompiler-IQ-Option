package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: ListeningExecutorService */
public interface u extends ExecutorService {
    <T> s<T> c(Callable<T> callable);

    s<?> i(Runnable runnable);
}
