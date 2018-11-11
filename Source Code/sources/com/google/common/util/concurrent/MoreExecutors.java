package com.google.common.util.concurrent;

import com.google.common.base.i;
import com.google.common.base.o;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors {

    private enum DirectExecutor implements Executor {
        INSTANCE;

        public String toString() {
            return "MoreExecutors.directExecutor()";
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static class a extends c {
        private final ExecutorService WW;

        a(ExecutorService executorService) {
            this.WW = (ExecutorService) i.checkNotNull(executorService);
        }

        public final boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.WW.awaitTermination(j, timeUnit);
        }

        public final boolean isShutdown() {
            return this.WW.isShutdown();
        }

        public final boolean isTerminated() {
            return this.WW.isTerminated();
        }

        public final void shutdown() {
            this.WW.shutdown();
        }

        public final List<Runnable> shutdownNow() {
            return this.WW.shutdownNow();
        }

        public final void execute(Runnable runnable) {
            this.WW.execute(runnable);
        }
    }

    private static final class b extends a implements v {
        final ScheduledExecutorService WX;

        private static final class a<V> extends com.google.common.util.concurrent.m.a<V> implements t<V> {
            private final ScheduledFuture<?> WY;

            public a(s<V> sVar, ScheduledFuture<?> scheduledFuture) {
                super(sVar);
                this.WY = scheduledFuture;
            }

            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.WY.cancel(z);
                }
                return cancel;
            }

            public long getDelay(TimeUnit timeUnit) {
                return this.WY.getDelay(timeUnit);
            }

            public int compareTo(Delayed delayed) {
                return this.WY.compareTo(delayed);
            }
        }

        private static final class b extends b<Void> implements Runnable {
            private final Runnable WZ;

            public b(Runnable runnable) {
                this.WZ = (Runnable) i.checkNotNull(runnable);
            }

            public void run() {
                try {
                    this.WZ.run();
                } catch (Throwable th) {
                    h(th);
                    RuntimeException g = o.g(th);
                }
            }
        }

        b(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.WX = (ScheduledExecutorService) i.checkNotNull(scheduledExecutorService);
        }

        /* renamed from: a */
        public t<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Object b = TrustedListenableFutureTask.b(runnable, null);
            return new a(b, this.WX.schedule(b, j, timeUnit));
        }

        /* renamed from: a */
        public <V> t<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            Object d = TrustedListenableFutureTask.d(callable);
            return new a(d, this.WX.schedule(d, j, timeUnit));
        }

        /* renamed from: a */
        public t<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            s bVar = new b(runnable);
            return new a(bVar, this.WX.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        }

        /* renamed from: b */
        public t<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            s bVar = new b(runnable);
            return new a(bVar, this.WX.scheduleWithFixedDelay(bVar, j, j2, timeUnit));
        }
    }

    public static Executor vV() {
        return DirectExecutor.INSTANCE;
    }

    public static v a(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof v ? (v) scheduledExecutorService : new b(scheduledExecutorService);
    }

    static Executor a(final Executor executor, final b<?> bVar) {
        i.checkNotNull(executor);
        i.checkNotNull(bVar);
        if (executor == vV()) {
            return executor;
        }
        return new Executor() {
            boolean WQ = true;

            public void execute(final Runnable runnable) {
                try {
                    executor.execute(new Runnable() {
                        public void run() {
                            AnonymousClass1.this.WQ = false;
                            runnable.run();
                        }
                    });
                } catch (Throwable e) {
                    if (this.WQ) {
                        bVar.h(e);
                    }
                }
            }
        };
    }
}
