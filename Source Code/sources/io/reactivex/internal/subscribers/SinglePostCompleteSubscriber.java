package io.reactivex.internal.subscribers;

import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements h<T>, d {
    private static final long serialVersionUID = 7917814472626990048L;
    protected final c<? super R> actual;
    protected long produced;
    protected d s;
    protected R value;

    protected void cj(R r) {
    }

    public SinglePostCompleteSubscriber(c<? super R> cVar) {
        this.actual = cVar;
    }

    public void a(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.a(this);
        }
    }

    protected final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            b.c(this, j);
        }
        while (true) {
            j = get();
            if ((j & Long.MIN_VALUE) != 0) {
                cj(r);
                return;
            } else if ((j & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.e(r);
                this.actual.onComplete();
                return;
            } else {
                this.value = r;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.value = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            long j2;
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.e(this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, b.y(j2, j)));
            this.s.request(j);
        }
    }

    public void cancel() {
        this.s.cancel();
    }
}
