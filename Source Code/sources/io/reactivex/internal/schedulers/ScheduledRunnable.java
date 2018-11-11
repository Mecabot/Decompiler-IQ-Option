package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements b, Runnable, Callable<Object> {
    static final Object esB = new Object();
    static final Object esC = new Object();
    static final Object esD = new Object();
    static final Object esE = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(2, null);
            obj = get(0);
            if (!(obj == esB || !compareAndSet(0, obj, esE) || obj == null)) {
                ((a) obj).g(this);
            }
            do {
                obj = get(1);
                if (obj == esC || obj == esD) {
                }
            } while (!compareAndSet(1, obj, esE));
        }
        lazySet(2, null);
        obj = get(0);
        if (!(obj == esB || !compareAndSet(0, obj, esE) || obj == null)) {
            ((a) obj).g(this);
        }
        do {
            obj = get(1);
            if (obj == esC || obj == esD) {
                return;
            }
        } while (!compareAndSet(1, obj, esE));
    }

    public void h(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != esE) {
                if (obj == esC) {
                    future.cancel(false);
                    return;
                } else if (obj == esD) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public void dispose() {
        Object obj;
        boolean z;
        Object obj2;
        do {
            obj = get(1);
            if (obj == esE || obj == esC || obj == esD) {
                break;
            }
            z = get(2) != Thread.currentThread();
        } while (!compareAndSet(1, obj, z ? esD : esC));
        if (obj != null) {
            ((Future) obj).cancel(z);
        }
        do {
            obj2 = get(0);
            if (obj2 == esE || obj2 == esB || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, esB));
        ((a) obj2).g(this);
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == esB || obj == esE) {
            return true;
        }
        return false;
    }
}
