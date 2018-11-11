package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.c;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
public final class l {
    public static ExecutorService lA(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(lC(str));
        a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService lB(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(lC(str));
        a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory lC(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new h() {
                    public void id() {
                        runnable.run();
                    }
                });
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(atomicLong.getAndIncrement());
                newThread.setName(stringBuilder.toString());
                return newThread;
            }
        };
    }

    private static final void a(String str, ExecutorService executorService) {
        a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        Runnable anonymousClass2 = new h() {
            public void id() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Executing shutdown hook for ");
                    stringBuilder.append(str2);
                    c.aUg().d("Fabric", stringBuilder.toString());
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                        c.aUg().d("Fabric", stringBuilder.toString());
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    c.aUg().d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Shutdown Hook for ");
        stringBuilder.append(str);
        runtime.addShutdownHook(new Thread(anonymousClass2, stringBuilder.toString()));
    }
}
