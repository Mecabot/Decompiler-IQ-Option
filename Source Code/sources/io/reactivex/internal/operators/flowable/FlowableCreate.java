package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.d.a;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.f;
import io.reactivex.g;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableCreate<T> extends e<T> {
    final g<T> eqQ;
    final BackpressureStrategy eqR;

    static abstract class BaseEmitter<T> extends AtomicLong implements f<T>, d {
        private static final long serialVersionUID = 7326289992464377023L;
        final c<? super T> actual;
        final SequentialDisposable serial = new SequentialDisposable();

        void aWA() {
        }

        void aWB() {
        }

        BaseEmitter(c<? super T> cVar) {
            this.actual = cVar;
        }

        protected void complete() {
            if (!isCancelled()) {
                try {
                    this.actual.onComplete();
                } finally {
                    this.serial.dispose();
                }
            }
        }

        public final void onError(Throwable th) {
            if (!W(th)) {
                a.onError(th);
            }
        }

        public boolean W(Throwable th) {
            return X(th);
        }

        protected boolean X(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.actual.onError(th);
                return true;
            } finally {
                this.serial.dispose();
            }
        }

        public final void cancel() {
            this.serial.dispose();
            aWA();
        }

        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this, j);
                aWB();
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicInteger wip = new AtomicInteger();

        BufferAsyncEmitter(c<? super T> cVar, int i) {
            super(cVar);
            this.queue = new io.reactivex.internal.queue.a(i);
        }

        public void e(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.offer(t);
                drain();
            }
        }

        public boolean W(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        void aWB() {
            drain();
        }

        void aWA() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                c cVar = this.actual;
                io.reactivex.internal.queue.a aVar = this.queue;
                int i = 1;
                do {
                    Throwable th;
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (isCancelled()) {
                            aVar.clear();
                            return;
                        }
                        boolean z = this.done;
                        Object poll = aVar.poll();
                        Object obj = poll == null ? 1 : null;
                        if (z && obj != null) {
                            th = this.error;
                            if (th != null) {
                                X(th);
                            } else {
                                complete();
                            }
                            return;
                        } else if (obj != null) {
                            break;
                        } else {
                            cVar.e(poll);
                            j2++;
                        }
                    }
                    if (j2 == j) {
                        if (isCancelled()) {
                            aVar.clear();
                            return;
                        }
                        boolean z2 = this.done;
                        boolean isEmpty = aVar.isEmpty();
                        if (z2 && isEmpty) {
                            th = this.error;
                            if (th != null) {
                                X(th);
                            } else {
                                complete();
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        b.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue = new AtomicReference();
        final AtomicInteger wip = new AtomicInteger();

        LatestAsyncEmitter(c<? super T> cVar) {
            super(cVar);
        }

        public void e(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.set(t);
                drain();
            }
        }

        public boolean W(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        void aWB() {
            drain();
        }

        void aWA() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                c cVar = this.actual;
                AtomicReference atomicReference = this.queue;
                int i = 1;
                do {
                    Object obj;
                    Throwable th;
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        obj = null;
                        if (j2 == j) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z = this.done;
                            Object andSet = atomicReference.getAndSet(null);
                            Object obj2 = andSet == null ? 1 : null;
                            if (z && obj2 != null) {
                                th = this.error;
                                if (th != null) {
                                    X(th);
                                } else {
                                    complete();
                                }
                                return;
                            } else if (obj2 != null) {
                                break;
                            } else {
                                cVar.e(andSet);
                                j2++;
                            }
                        }
                    }
                    if (j2 == j) {
                        if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z2 = this.done;
                        if (atomicReference.get() == null) {
                            obj = 1;
                        }
                        if (z2 && obj != null) {
                            th = this.error;
                            if (th != null) {
                                X(th);
                            } else {
                                complete();
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        b.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(c<? super T> cVar) {
            super(cVar);
        }

        public void e(T t) {
            if (!isCancelled()) {
                if (t != null) {
                    this.actual.e(t);
                    long j;
                    do {
                        j = get();
                        if (j == 0) {
                            break;
                        }
                    } while (!compareAndSet(j, j - 1));
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void aWC();

        NoOverflowBaseAsyncEmitter(c<? super T> cVar) {
            super(cVar);
        }

        public final void e(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() != 0) {
                    this.actual.e(t);
                    b.c(this, 1);
                } else {
                    aWC();
                }
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        void aWC() {
        }

        DropAsyncEmitter(c<? super T> cVar) {
            super(cVar);
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(c<? super T> cVar) {
            super(cVar);
        }

        void aWC() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public FlowableCreate(g<T> gVar, BackpressureStrategy backpressureStrategy) {
        this.eqQ = gVar;
        this.eqR = backpressureStrategy;
    }

    public void a(c<? super T> cVar) {
        BaseEmitter missingEmitter;
        switch (this.eqR) {
            case MISSING:
                missingEmitter = new MissingEmitter(cVar);
                break;
            case ERROR:
                missingEmitter = new ErrorAsyncEmitter(cVar);
                break;
            case DROP:
                missingEmitter = new DropAsyncEmitter(cVar);
                break;
            case LATEST:
                missingEmitter = new LatestAsyncEmitter(cVar);
                break;
            default:
                missingEmitter = new BufferAsyncEmitter(cVar, e.aVT());
                break;
        }
        cVar.a(missingEmitter);
        try {
            this.eqQ.a(missingEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            missingEmitter.onError(th);
        }
    }
}
