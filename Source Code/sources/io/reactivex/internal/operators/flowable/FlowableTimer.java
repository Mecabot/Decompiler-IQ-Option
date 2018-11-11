package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableTimer extends e<Long> {
    final long aPv;
    final n scheduler;
    final TimeUnit unit;

    static final class TimerSubscriber extends AtomicReference<b> implements Runnable, d {
        private static final long serialVersionUID = -2809475196591179431L;
        final c<? super Long> actual;
        volatile boolean requested;

        TimerSubscriber(c<? super Long> cVar) {
            this.actual = cVar;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.requested = true;
            }
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.requested) {
                this.actual.e(Long.valueOf(0));
                lazySet(EmptyDisposable.INSTANCE);
                this.actual.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.actual.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void i(b bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }

    public FlowableTimer(long j, TimeUnit timeUnit, n nVar) {
        this.aPv = j;
        this.unit = timeUnit;
        this.scheduler = nVar;
    }

    public void a(c<? super Long> cVar) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(cVar);
        cVar.a(timerSubscriber);
        timerSubscriber.i(this.scheduler.b(timerSubscriber, this.aPv, this.unit));
    }
}
