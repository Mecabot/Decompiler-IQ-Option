package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.n;
import io.reactivex.n.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends n {
    static final n ese = io.reactivex.e.a.aXv();
    final Executor executor;

    final class a implements Runnable {
        private final DelayedRunnable esf;

        a(DelayedRunnable delayedRunnable) {
            this.esf = delayedRunnable;
        }

        public void run() {
            this.esf.direct.h(ExecutorScheduler.this.q(this.esf));
        }
    }

    static final class DelayedRunnable extends AtomicReference<Runnable> implements b, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct = new SequentialDisposable();
        final SequentialDisposable timed = new SequentialDisposable();

        DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    Object obj = null;
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                }
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }

        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }
    }

    public static final class ExecutorWorker extends c implements Runnable {
        volatile boolean disposed;
        final MpscLinkedQueue<Runnable> esh;
        final io.reactivex.disposables.a esi = new io.reactivex.disposables.a();
        final Executor executor;
        final AtomicInteger wip = new AtomicInteger();

        final class a implements Runnable {
            private final Runnable epZ;
            private final SequentialDisposable esj;

            a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.esj = sequentialDisposable;
                this.epZ = runnable;
            }

            public void run() {
                this.esj.h(ExecutorWorker.this.r(this.epZ));
            }
        }

        static final class BooleanRunnable extends AtomicBoolean implements b, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            public void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }

            public void dispose() {
                lazySet(true);
            }

            public boolean isDisposed() {
                return get();
            }
        }

        public ExecutorWorker(Executor executor) {
            this.executor = executor;
            this.esh = new MpscLinkedQueue();
        }

        public b r(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b booleanRunnable = new BooleanRunnable(io.reactivex.d.a.u(runnable));
            this.esh.offer(booleanRunnable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (Throwable e) {
                    this.disposed = true;
                    this.esh.clear();
                    io.reactivex.d.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return r(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Object sequentialDisposable = new SequentialDisposable();
            b sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            b scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, io.reactivex.d.a.u(runnable)), this.esi);
            this.esi.e(scheduledRunnable);
            if (this.executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.h(((ScheduledExecutorService) this.executor).schedule(scheduledRunnable, j, timeUnit));
                } catch (Throwable e) {
                    this.disposed = true;
                    io.reactivex.d.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            scheduledRunnable.h(new b(ExecutorScheduler.ese.b(scheduledRunnable, j, timeUnit)));
            sequentialDisposable.h(scheduledRunnable);
            return sequentialDisposable2;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.esi.dispose();
                if (this.wip.getAndIncrement() == 0) {
                    this.esh.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        /* JADX WARNING: Missing block: B:8:0x0015, code:
            if (r3.disposed == false) goto L_0x001b;
     */
        /* JADX WARNING: Missing block: B:9:0x0017, code:
            r0.clear();
     */
        /* JADX WARNING: Missing block: B:10:0x001a, code:
            return;
     */
        /* JADX WARNING: Missing block: B:11:0x001b, code:
            r1 = r3.wip.addAndGet(-r1);
     */
        /* JADX WARNING: Missing block: B:12:0x0022, code:
            if (r1 != 0) goto L_0x0003;
     */
        /* JADX WARNING: Missing block: B:13:0x0024, code:
            return;
     */
        public void run() {
            /*
            r3 = this;
            r0 = r3.esh;
            r1 = 1;
        L_0x0003:
            r2 = r3.disposed;
            if (r2 == 0) goto L_0x000b;
        L_0x0007:
            r0.clear();
            return;
        L_0x000b:
            r2 = r0.poll();
            r2 = (java.lang.Runnable) r2;
            if (r2 != 0) goto L_0x0025;
        L_0x0013:
            r2 = r3.disposed;
            if (r2 == 0) goto L_0x001b;
        L_0x0017:
            r0.clear();
            return;
        L_0x001b:
            r2 = r3.wip;
            r1 = -r1;
            r1 = r2.addAndGet(r1);
            if (r1 != 0) goto L_0x0003;
        L_0x0024:
            return;
        L_0x0025:
            r2.run();
            r2 = r3.disposed;
            if (r2 == 0) goto L_0x000b;
        L_0x002c:
            r0.clear();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.executor = executor;
    }

    public c aWg() {
        return new ExecutorWorker(this.executor);
    }

    public b q(Runnable runnable) {
        runnable = io.reactivex.d.a.u(runnable);
        try {
            if (this.executor instanceof ExecutorService) {
                b scheduledDirectTask = new ScheduledDirectTask(runnable);
                scheduledDirectTask.h(((ExecutorService) this.executor).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            Object booleanRunnable = new BooleanRunnable(runnable);
            this.executor.execute(booleanRunnable);
            return booleanRunnable;
        } catch (Throwable e) {
            io.reactivex.d.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public b b(Runnable runnable, long j, TimeUnit timeUnit) {
        runnable = io.reactivex.d.a.u(runnable);
        b scheduledDirectTask;
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                scheduledDirectTask = new ScheduledDirectTask(runnable);
                scheduledDirectTask.h(((ScheduledExecutorService) this.executor).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (Throwable e) {
                io.reactivex.d.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        scheduledDirectTask = new DelayedRunnable(runnable);
        scheduledDirectTask.timed.h(ese.b(new a(scheduledDirectTask), j, timeUnit));
        return scheduledDirectTask;
    }

    public b c(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.executor instanceof ScheduledExecutorService)) {
            return super.c(runnable, j, j2, timeUnit);
        }
        try {
            b scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(io.reactivex.d.a.u(runnable));
            scheduledDirectPeriodicTask.h(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e) {
            io.reactivex.d.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }
}
