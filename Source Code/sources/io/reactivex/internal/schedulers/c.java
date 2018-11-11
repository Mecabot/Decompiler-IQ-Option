package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InstantPeriodicTask */
final class c implements b, Callable<Void> {
    static final FutureTask<Void> esn = new FutureTask(a.eqp, null);
    final Runnable Wc;
    final AtomicReference<Future<?>> esl = new AtomicReference();
    final AtomicReference<Future<?>> esm = new AtomicReference();
    final ExecutorService executor;
    Thread runner;

    c(Runnable runnable, ExecutorService executorService) {
        this.Wc = runnable;
        this.executor = executorService;
    }

    public Void call() {
        this.runner = Thread.currentThread();
        try {
            this.Wc.run();
            j(this.executor.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.d.a.onError(th);
        }
        return null;
    }

    public void dispose() {
        Future future = (Future) this.esm.getAndSet(esn);
        boolean z = false;
        if (!(future == null || future == esn)) {
            future.cancel(this.runner != Thread.currentThread());
        }
        future = (Future) this.esl.getAndSet(esn);
        if (future != null && future != esn) {
            if (this.runner != Thread.currentThread()) {
                z = true;
            }
            future.cancel(z);
        }
    }

    public boolean isDisposed() {
        return this.esm.get() == esn;
    }

    void i(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.esm.get();
            if (future2 == esn) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.esm.compareAndSet(future2, future));
    }

    void j(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.esl.get();
            if (future2 == esn) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.esl.compareAndSet(future2, future));
    }
}
