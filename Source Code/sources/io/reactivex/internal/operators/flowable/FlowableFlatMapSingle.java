package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

public final class FlowableFlatMapSingle<T, R> extends a<T, R> {
    final boolean delayErrors;
    final f<? super T, ? extends s<? extends R>> mapper;
    final int maxConcurrency;

    static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements h<T>, d {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        final c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final AtomicThrowable errors = new AtomicThrowable();
        final f<? super T, ? extends s<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<R>> queue = new AtomicReference();
        final AtomicLong requested = new AtomicLong();
        d s;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        final class InnerObserver extends AtomicReference<b> implements b, q<R> {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            public void d(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            public void onSuccess(R r) {
                FlatMapSingleSubscriber.this.a(this, (Object) r);
            }

            public void onError(Throwable th) {
                FlatMapSingleSubscriber.this.a(this, th);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((b) get());
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        FlatMapSingleSubscriber(c<? super R> cVar, f<? super T, ? extends s<? extends R>> fVar, boolean z, int i) {
            this.actual = cVar;
            this.mapper = fVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
                if (this.maxConcurrency == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request((long) this.maxConcurrency);
                }
            }
        }

        public void e(T t) {
            try {
                s sVar = (s) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                Object innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.e(innerObserver)) {
                    sVar.a(innerObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                this.s.cancel();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.Y(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        void a(InnerObserver innerObserver, R r) {
            a aWK;
            this.set.g(innerObserver);
            if (get() == 0) {
                int i = 1;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() != 0) {
                        i = 0;
                    }
                    if (this.requested.get() != 0) {
                        this.actual.e(r);
                        a aVar = (a) this.queue.get();
                        if (i == 0 || !(aVar == null || aVar.isEmpty())) {
                            io.reactivex.internal.util.b.c(this.requested, 1);
                            if (this.maxConcurrency != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                                this.s.request(1);
                            }
                        } else {
                            Throwable aXi = this.errors.aXi();
                            if (aXi != null) {
                                this.actual.onError(aXi);
                            } else {
                                this.actual.onComplete();
                            }
                            return;
                        }
                    }
                    aWK = aWK();
                    synchronized (aWK) {
                        aWK.offer(r);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    aWG();
                }
            }
            aWK = aWK();
            synchronized (aWK) {
                aWK.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            aWG();
        }

        a<R> aWK() {
            a<R> aVar;
            do {
                aVar = (a) this.queue.get();
                if (aVar != null) {
                    return aVar;
                }
                aVar = new a(e.aVT());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        void a(InnerObserver innerObserver, Throwable th) {
            this.set.g(innerObserver);
            if (this.errors.Y(th)) {
                if (!this.delayErrors) {
                    this.s.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    this.s.request(1);
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                aWG();
            }
        }

        void clear() {
            a aVar = (a) this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        void aWG() {
            c cVar = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference atomicReference = this.queue;
            int i = 1;
            do {
                Object obj;
                Throwable aXi;
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    obj = null;
                    if (j2 == j) {
                        break;
                    } else if (this.cancelled) {
                        clear();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        Object obj2 = atomicInteger.get() == 0 ? 1 : null;
                        a aVar = (a) atomicReference.get();
                        Object poll = aVar != null ? aVar.poll() : null;
                        Object obj3 = poll == null ? 1 : null;
                        if (obj2 != null && obj3 != null) {
                            aXi = this.errors.aXi();
                            if (aXi != null) {
                                cVar.onError(aXi);
                            } else {
                                cVar.onComplete();
                            }
                            return;
                        } else if (obj3 != null) {
                            break;
                        } else {
                            cVar.e(poll);
                            j2++;
                        }
                    } else {
                        aXi = this.errors.aXi();
                        clear();
                        cVar.onError(aXi);
                        return;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        clear();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        Object obj4 = atomicInteger.get() == 0 ? 1 : null;
                        a aVar2 = (a) atomicReference.get();
                        if (aVar2 == null || aVar2.isEmpty()) {
                            obj = 1;
                        }
                        if (!(obj4 == null || obj == null)) {
                            aXi = this.errors.aXi();
                            if (aXi != null) {
                                cVar.onError(aXi);
                            } else {
                                cVar.onComplete();
                            }
                            return;
                        }
                    } else {
                        aXi = this.errors.aXi();
                        clear();
                        cVar.onError(aXi);
                        return;
                    }
                }
                if (j2 != 0) {
                    io.reactivex.internal.util.b.c(this.requested, j2);
                    if (this.maxConcurrency != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        this.s.request(j2);
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    public FlowableFlatMapSingle(e<T> eVar, f<? super T, ? extends s<? extends R>> fVar, boolean z, int i) {
        super(eVar);
        this.mapper = fVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    protected void a(c<? super R> cVar) {
        this.eqM.a(new FlatMapSingleSubscriber(cVar, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
