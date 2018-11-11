package io.reactivex.internal.subscribers;

import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.a.d;

/* compiled from: BlockingBaseSubscriber */
public abstract class c<T> extends CountDownLatch implements h<T> {
    volatile boolean cancelled;
    Throwable error;
    d s;
    T value;

    public c() {
        super(1);
    }

    public final void a(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (!this.cancelled) {
                dVar.request(Long.MAX_VALUE);
                if (this.cancelled) {
                    this.s = SubscriptionHelper.CANCELLED;
                    dVar.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final T aWf() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.aXj();
                await();
            } catch (Throwable e) {
                d dVar = this.s;
                this.s = SubscriptionHelper.CANCELLED;
                if (dVar != null) {
                    dVar.cancel();
                }
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
