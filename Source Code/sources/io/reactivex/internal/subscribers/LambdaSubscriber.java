package io.reactivex.internal.subscribers;

import io.reactivex.c.a;
import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

public final class LambdaSubscriber<T> extends AtomicReference<d> implements b, h<T>, d {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super d> onSubscribe;

    public LambdaSubscriber(e<? super T> eVar, e<? super Throwable> eVar2, a aVar, e<? super d> eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
    }

    public void a(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    public void e(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                ((d) get()).cancel();
                onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.V(th2);
                io.reactivex.d.a.onError(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.d.a.onError(th);
    }

    public void onComplete() {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                io.reactivex.d.a.onError(th);
            }
        }
    }

    public void dispose() {
        cancel();
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void request(long j) {
        ((d) get()).request(j);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }
}
