package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.processors.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class FlowableRepeatWhen<T> extends a<T, T> {
    final f<? super e<Object>, ? extends b<?>> erm;

    static final class WhenReceiver<T, U> extends AtomicInteger implements h<Object>, d {
        private static final long serialVersionUID = 2827772011130406689L;
        final AtomicLong requested = new AtomicLong();
        final b<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<d> subscription = new AtomicReference();

        WhenReceiver(b<T> bVar) {
            this.source = bVar;
        }

        public void a(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.subscription, this.requested, dVar);
        }

        public void e(Object obj) {
            if (getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled((d) this.subscription.get())) {
                    this.source.b(this.subscriber);
                    if (decrementAndGet() == 0) {
                    }
                }
            }
        }

        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.actual.onError(th);
        }

        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.actual.onComplete();
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.subscription, this.requested, j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.subscription);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements h<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final c<? super T> actual;
        protected final a<U> processor;
        private long produced;
        protected final d receiver;

        WhenSourceSubscriber(c<? super T> cVar, a<U> aVar, d dVar) {
            this.actual = cVar;
            this.processor = aVar;
            this.receiver = dVar;
        }

        public final void a(d dVar) {
            b(dVar);
        }

        public final void e(T t) {
            this.produced++;
            this.actual.e(t);
        }

        protected final void ch(U u) {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0;
                cX(j);
            }
            this.receiver.request(1);
            this.processor.e(u);
        }

        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }
    }

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(c<? super T> cVar, a<Object> aVar, d dVar) {
            super(cVar, aVar, dVar);
        }

        public void onError(Throwable th) {
            this.receiver.cancel();
            this.actual.onError(th);
        }

        public void onComplete() {
            ch(Integer.valueOf(0));
        }
    }

    public FlowableRepeatWhen(e<T> eVar, f<? super e<Object>, ? extends b<?>> fVar) {
        super(eVar);
        this.erm = fVar;
    }

    public void a(c<? super T> cVar) {
        c aVar = new io.reactivex.f.a(cVar);
        a aXp = UnicastProcessor.jl(8).aXp();
        try {
            b bVar = (b) io.reactivex.internal.a.b.requireNonNull(this.erm.apply(aXp), "handler returned a null Publisher");
            Object whenReceiver = new WhenReceiver(this.eqM);
            d repeatWhenSubscriber = new RepeatWhenSubscriber(aVar, aXp, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            cVar.a(repeatWhenSubscriber);
            bVar.b(whenReceiver);
            whenReceiver.e(Integer.valueOf(0));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            EmptySubscription.error(th, cVar);
        }
    }
}
