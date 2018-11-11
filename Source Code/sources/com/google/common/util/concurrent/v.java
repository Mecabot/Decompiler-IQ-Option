package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ListeningScheduledExecutorService */
public interface v extends u, ScheduledExecutorService {
    t<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    t<?> a(Runnable runnable, long j, TimeUnit timeUnit);

    <V> t<V> a(Callable<V> callable, long j, TimeUnit timeUnit);

    t<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
