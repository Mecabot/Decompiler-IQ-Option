package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.f.a;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableSampleTimed<T> extends a<T, T> {
    final boolean ern;
    final long period;
    final n scheduler;
    final TimeUnit unit;

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements h<T>, Runnable, d {
        private static final long serialVersionUID = -3517602651313910099L;
        final c<? super T> actual;
        final long period;
        final AtomicLong requested = new AtomicLong();
        d s;
        final n scheduler;
        final SequentialDisposable timer = new SequentialDisposable();
        final TimeUnit unit;

        abstract void complete();

        SampleTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, n nVar) {
            this.actual = cVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = nVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
                this.timer.h(this.scheduler.c(this, this.period, this.period, this.unit));
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void e(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            aCX();
            this.actual.onError(th);
        }

        public void onComplete() {
            aCX();
            complete();
        }

        void aCX() {
            DisposableHelper.dispose(this.timer);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
            }
        }

        public void cancel() {
            aCX();
            this.s.cancel();
        }

        void aWD() {
            Object andSet = getAndSet(null);
            if (andSet == null) {
                return;
            }
            if (this.requested.get() != 0) {
                this.actual.e(andSet);
                b.c(this.requested, 1);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);

        SampleTimedEmitLast(c<? super T> cVar, long j, TimeUnit timeUnit, n nVar) {
            super(cVar, j, timeUnit, nVar);
        }

        void complete() {
            aWD();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                aWD();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(c<? super T> cVar, long j, TimeUnit timeUnit, n nVar) {
            super(cVar, j, timeUnit, nVar);
        }

        void complete() {
            this.actual.onComplete();
        }

        public void run() {
            aWD();
        }
    }

    public FlowableSampleTimed(e<T> eVar, long j, TimeUnit timeUnit, n nVar, boolean z) {
        super(eVar);
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = nVar;
        this.ern = z;
    }

    protected void a(c<? super T> cVar) {
        c aVar = new a(cVar);
        if (this.ern) {
            this.eqM.a(new SampleTimedEmitLast(aVar, this.period, this.unit, this.scheduler));
        } else {
            this.eqM.a(new SampleTimedNoLast(aVar, this.period, this.unit, this.scheduler));
        }
    }
}
