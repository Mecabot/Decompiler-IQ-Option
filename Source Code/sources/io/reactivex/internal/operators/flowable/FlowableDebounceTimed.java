package io.reactivex.internal.operators.flowable;

import io.reactivex.d.a;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableDebounceTimed<T> extends a<T, T> {
    final n scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class DebounceEmitter<T> extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedSubscriber<T> parent;
        final T value;

        DebounceEmitter(T t, long j, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedSubscriber;
        }

        public void run() {
            aWD();
        }

        void aWD() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void i(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements h<T>, d {
        private static final long serialVersionUID = -9102637559663639004L;
        final c<? super T> actual;
        boolean done;
        volatile long index;
        d s;
        final long timeout;
        b timer;
        final TimeUnit unit;
        final n.c worker;

        DebounceTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, n.c cVar2) {
            this.actual = cVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void e(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                b bVar = this.timer;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
                this.timer = debounceEmitter;
                debounceEmitter.i(this.worker.c(debounceEmitter, this.timeout, this.unit));
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                a.onError(th);
                return;
            }
            this.done = true;
            b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            this.actual.onError(th);
            this.worker.dispose();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                b bVar = this.timer;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
                if (debounceEmitter != null) {
                    debounceEmitter.aWD();
                }
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        public void cancel() {
            this.s.cancel();
            this.worker.dispose();
        }

        void a(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j != this.index) {
                return;
            }
            if (get() != 0) {
                this.actual.e(t);
                io.reactivex.internal.util.b.c(this, 1);
                debounceEmitter.dispose();
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public FlowableDebounceTimed(e<T> eVar, long j, TimeUnit timeUnit, n nVar) {
        super(eVar);
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = nVar;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new DebounceTimedSubscriber(new io.reactivex.f.a(cVar), this.timeout, this.unit, this.scheduler.aWg()));
    }
}
