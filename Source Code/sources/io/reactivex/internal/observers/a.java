package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.c;
import io.reactivex.m;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseObserver */
public abstract class a<T> extends CountDownLatch implements b, m<T> {
    volatile boolean cancelled;
    b d;
    Throwable error;
    T value;

    public a() {
        super(1);
    }

    public final void d(b bVar) {
        this.d = bVar;
        if (this.cancelled) {
            bVar.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.cancelled = true;
        b bVar = this.d;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.cancelled;
    }

    public final T aWf() {
        if (getCount() != 0) {
            try {
                c.aXj();
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
