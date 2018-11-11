package io.reactivex.internal.subscribers;

import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public class StrictSubscriber<T> extends AtomicInteger implements h<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    final c<? super T> actual;
    volatile boolean done;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<d> s = new AtomicReference();

    public StrictSubscriber(c<? super T> cVar) {
        this.actual = cVar;
    }

    public void request(long j) {
        if (j <= 0) {
            cancel();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("§3.9 violated: positive request amount required but it was ");
            stringBuilder.append(j);
            onError(new IllegalArgumentException(stringBuilder.toString()));
            return;
        }
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }

    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.s);
        }
    }

    public void a(d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.a(this);
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void e(T t) {
        io.reactivex.internal.util.d.a(this.actual, (Object) t, (AtomicInteger) this, this.error);
    }

    public void onError(Throwable th) {
        this.done = true;
        io.reactivex.internal.util.d.a(this.actual, th, (AtomicInteger) this, this.error);
    }

    public void onComplete() {
        this.done = true;
        io.reactivex.internal.util.d.a(this.actual, this, this.error);
    }
}
