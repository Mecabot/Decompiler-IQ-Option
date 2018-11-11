package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class h extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = (enx + 1);
    private static final int MAXIMUM_POOL_SIZE = ((enx * 2) + 1);
    private static final int enx = Runtime.getRuntime().availableProcessors();

    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class a implements ThreadFactory {
        private final int enW;

        public a(int i) {
            this.enW = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.enW);
            thread.setName("Queue");
            return thread;
        }
    }

    <T extends Runnable & a & i & f> h(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & a & i & f> h aX(int i, int i2) {
        return new h(i, i2, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new a(10));
    }

    public static h aVc() {
        return aX(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new e(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new e(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (g.bU(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        i iVar = (i) runnable;
        iVar.gr(true);
        iVar.P(th);
        getQueue().aVa();
        super.afterExecute(runnable, th);
    }

    /* renamed from: aVd */
    public DependencyPriorityBlockingQueue getQueue() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
