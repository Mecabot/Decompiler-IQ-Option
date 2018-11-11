package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.a.a;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements b {
    protected static final FutureTask<Void> erR = new FutureTask(a.eqp, null);
    protected static final FutureTask<Void> erS = new FutureTask(a.eqp, null);
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    public final void dispose() {
        Future future = (Future) get();
        if (future != erR && future != erS && compareAndSet(future, erS) && future != null) {
            future.cancel(this.runner != Thread.currentThread());
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        return future == erR || future == erS;
    }

    public final void h(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != erR) {
                if (future2 == erS) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
