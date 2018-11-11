package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.n;
import io.reactivex.n.c;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler */
public final class i extends n {
    static final RxThreadFactory esM = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    static final ScheduledExecutorService esN = Executors.newScheduledThreadPool(0);
    final ThreadFactory eny;
    final AtomicReference<ScheduledExecutorService> esL;

    /* compiled from: SingleScheduler */
    static final class a extends c {
        volatile boolean disposed;
        final io.reactivex.disposables.a esi = new io.reactivex.disposables.a();
        final ScheduledExecutorService executor;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Future submit;
            b scheduledRunnable = new ScheduledRunnable(io.reactivex.d.a.u(runnable), this.esi);
            this.esi.e(scheduledRunnable);
            if (j <= 0) {
                try {
                    submit = this.executor.submit(scheduledRunnable);
                } catch (Throwable e) {
                    dispose();
                    io.reactivex.d.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            submit = this.executor.schedule(scheduledRunnable, j, timeUnit);
            scheduledRunnable.h(submit);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.esi.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static {
        esN.shutdown();
    }

    public i() {
        this(esM);
    }

    public i(ThreadFactory threadFactory) {
        this.esL = new AtomicReference();
        this.eny = threadFactory;
        this.esL.lazySet(b(threadFactory));
    }

    static ScheduledExecutorService b(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService = null;
        ScheduledExecutorService scheduledExecutorService2;
        do {
            scheduledExecutorService2 = (ScheduledExecutorService) this.esL.get();
            if (scheduledExecutorService2 != esN) {
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                return;
            } else if (scheduledExecutorService == null) {
                scheduledExecutorService = b(this.eny);
            }
        } while (!this.esL.compareAndSet(scheduledExecutorService2, scheduledExecutorService));
    }

    public c aWg() {
        return new a((ScheduledExecutorService) this.esL.get());
    }

    public b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future submit;
        b scheduledDirectTask = new ScheduledDirectTask(io.reactivex.d.a.u(runnable));
        if (j <= 0) {
            try {
                submit = ((ScheduledExecutorService) this.esL.get()).submit(scheduledDirectTask);
            } catch (Throwable e) {
                io.reactivex.d.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        submit = ((ScheduledExecutorService) this.esL.get()).schedule(scheduledDirectTask, j, timeUnit);
        scheduledDirectTask.h(submit);
        return scheduledDirectTask;
    }

    public b c(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        runnable = io.reactivex.d.a.u(runnable);
        if (j2 <= 0) {
            Future submit;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.esL.get();
            b cVar = new c(runnable, scheduledExecutorService);
            if (j <= 0) {
                try {
                    submit = scheduledExecutorService.submit(cVar);
                } catch (Throwable e) {
                    io.reactivex.d.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            submit = scheduledExecutorService.schedule(cVar, j, timeUnit);
            cVar.i(submit);
            return cVar;
        }
        b scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
        try {
            scheduledDirectPeriodicTask.h(((ScheduledExecutorService) this.esL.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e2) {
            io.reactivex.d.a.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
