package io.reactivex.internal.observers;

import io.reactivex.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import io.reactivex.q;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver */
public final class c<T> extends CountDownLatch implements b, j<T>, q<T> {
    volatile boolean cancelled;
    io.reactivex.disposables.b d;
    Throwable error;
    T value;

    public c() {
        super(1);
    }

    void dispose() {
        this.cancelled = true;
        io.reactivex.disposables.b bVar = this.d;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void d(io.reactivex.disposables.b bVar) {
        this.d = bVar;
        if (this.cancelled) {
            bVar.dispose();
        }
    }

    public void onSuccess(T t) {
        this.value = t;
        countDown();
    }

    public void onError(Throwable th) {
        this.error = th;
        countDown();
    }

    public void onComplete() {
        countDown();
    }

    public T aWf() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.aXj();
                await();
            } catch (Throwable e) {
                dispose();
                throw ExceptionHelper.Z(e);
            }
        }
        Throwable e2 = this.error;
        if (e2 == null) {
            return this.value;
        }
        throw ExceptionHelper.Z(e2);
    }
}
