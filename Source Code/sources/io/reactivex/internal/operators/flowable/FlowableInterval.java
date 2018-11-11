package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableInterval extends e<Long> {
    final long gs;
    final long period;
    final n scheduler;
    final TimeUnit unit;

    static final class IntervalSubscriber extends AtomicLong implements Runnable, d {
        private static final long serialVersionUID = -2809475196591179431L;
        final c<? super Long> actual;
        long count;
        final AtomicReference<b> resource = new AtomicReference();

        IntervalSubscriber(c<? super Long> cVar) {
            this.actual = cVar;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        public void run() {
            if (this.resource.get() == DisposableHelper.DISPOSED) {
                return;
            }
            c cVar;
            if (get() != 0) {
                cVar = this.actual;
                long j = this.count;
                this.count = j + 1;
                cVar.e(Long.valueOf(j));
                io.reactivex.internal.util.b.c(this, 1);
                return;
            }
            cVar = this.actual;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't deliver value ");
            stringBuilder.append(this.count);
            stringBuilder.append(" due to lack of requests");
            cVar.onError(new MissingBackpressureException(stringBuilder.toString()));
            DisposableHelper.dispose(this.resource);
        }

        public void i(b bVar) {
            DisposableHelper.setOnce(this.resource, bVar);
        }
    }

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, n nVar) {
        this.gs = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = nVar;
    }

    public void a(c<? super Long> cVar) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(cVar);
        cVar.a(intervalSubscriber);
        n nVar = this.scheduler;
        if (nVar instanceof j) {
            Object aWg = nVar.aWg();
            intervalSubscriber.i(aWg);
            aWg.d(intervalSubscriber, this.gs, this.period, this.unit);
            return;
        }
        intervalSubscriber.i(nVar.c(intervalSubscriber, this.gs, this.period, this.unit));
    }
}
