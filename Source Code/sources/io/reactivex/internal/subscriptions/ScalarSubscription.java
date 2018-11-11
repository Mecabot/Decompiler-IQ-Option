package io.reactivex.internal.subscriptions;

import io.reactivex.internal.b.f;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.c;

public final class ScalarSubscription<T> extends AtomicInteger implements f<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public int requestFusion(int i) {
        return i & 1;
    }

    public ScalarSubscription(c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            c cVar = this.subscriber;
            cVar.e(this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    public void cancel() {
        lazySet(2);
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public void clear() {
        lazySet(1);
    }
}
