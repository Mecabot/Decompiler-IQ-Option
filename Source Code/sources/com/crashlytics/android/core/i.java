package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashlyticsBackgroundWorker */
class i {
    private final ExecutorService executorService;

    public i(ExecutorService executorService) {
        this.executorService = executorService;
    }

    <T> T b(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            c.aUg().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e) {
            c.aUg().e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }

    Future<?> submit(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable e) {
                        c.aUg().e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            c.aUg().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> submit(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() {
                public T call() {
                    try {
                        return callable.call();
                    } catch (Throwable e) {
                        c.aUg().e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            c.aUg().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
