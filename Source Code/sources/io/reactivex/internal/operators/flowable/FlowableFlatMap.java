package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import io.reactivex.h;
import io.reactivex.internal.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class FlowableFlatMap<T, U> extends a<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final f<? super T, ? extends b<? extends U>> mapper;
    final int maxConcurrency;

    static final class InnerSubscriber<T, U> extends AtomicReference<d> implements io.reactivex.disposables.b, h<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit = (this.bufferSize >> 2);
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile i<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            this.bufferSize = mergeSubscriber.bufferSize;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.internal.b.f) {
                    io.reactivex.internal.b.f fVar = (io.reactivex.internal.b.f) dVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = fVar;
                    }
                }
                dVar.request((long) this.bufferSize);
            }
        }

        public void e(U u) {
            if (this.fusionMode != 2) {
                this.parent.a((Object) u, this);
            } else {
                this.parent.drain();
            }
        }

        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.a(this, th);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void cR(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((d) get()).request(j2);
                    return;
                }
                this.produced = j2;
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements h<T>, d {
        static final InnerSubscriber<?, ?>[] eqY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] eqZ = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final c<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable errs = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final f<? super T, ? extends b<? extends U>> mapper;
        final int maxConcurrency;
        volatile io.reactivex.internal.b.h<U> queue;
        final AtomicLong requested = new AtomicLong();
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers = new AtomicReference();
        long uniqueId;
        d upstream;

        MergeSubscriber(c<? super U> cVar, f<? super T, ? extends b<? extends U>> fVar, boolean z, int i, int i2) {
            this.actual = cVar;
            this.mapper = fVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            this.subscribers.lazySet(eqY);
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.a(this);
                if (!this.cancelled) {
                    if (this.maxConcurrency == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        dVar.request(Long.MAX_VALUE);
                    } else {
                        dVar.request((long) this.maxConcurrency);
                    }
                }
            }
        }

        public void e(T t) {
            if (!this.done) {
                try {
                    b bVar = (b) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                    if (bVar instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar).call();
                            if (call != null) {
                                cg(call);
                            } else if (!(this.maxConcurrency == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || this.cancelled)) {
                                int i = this.scalarEmitted + 1;
                                this.scalarEmitted = i;
                                if (i == this.scalarLimit) {
                                    this.scalarEmitted = 0;
                                    this.upstream.request((long) this.scalarLimit);
                                }
                            }
                        } catch (Throwable th) {
                            a.V(th);
                            this.errs.Y(th);
                            drain();
                            return;
                        }
                    }
                    long j = this.uniqueId;
                    this.uniqueId = j + 1;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    if (a(innerSubscriber)) {
                        bVar.b(innerSubscriber);
                    }
                } catch (Throwable th2) {
                    a.V(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == eqZ) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                obj = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, obj, 0, length);
                obj[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
            return true;
        }

        void b(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerSubscriberArr[i2] == innerSubscriber) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = eqY;
                        } else {
                            Object obj2 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, obj2, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
        }

        i<U> aWF() {
            i<U> iVar = this.queue;
            if (iVar == null) {
                if (this.maxConcurrency == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    iVar = new io.reactivex.internal.queue.a(this.bufferSize);
                } else {
                    iVar = new SpscArrayQueue(this.maxConcurrency);
                }
                this.queue = iVar;
            }
            return iVar;
        }

        void cg(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                i iVar = this.queue;
                if (j == 0 || !(iVar == null || iVar.isEmpty())) {
                    if (iVar == null) {
                        iVar = aWF();
                    }
                    if (!iVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                this.actual.e(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                if (!(this.maxConcurrency == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED || this.cancelled)) {
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    if (i == this.scalarLimit) {
                        this.scalarEmitted = 0;
                        this.upstream.request((long) this.scalarLimit);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!aWF().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            aWG();
        }

        i<U> c(InnerSubscriber<T, U> innerSubscriber) {
            i<U> iVar = innerSubscriber.queue;
            if (iVar != null) {
                return iVar;
            }
            iVar = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = iVar;
            return iVar;
        }

        void a(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                i iVar = innerSubscriber.queue;
                if (j == 0 || !(iVar == null || iVar.isEmpty())) {
                    if (iVar == null) {
                        iVar = c(innerSubscriber);
                    }
                    if (!iVar.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                this.actual.e(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                innerSubscriber.cR(1);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            i iVar2 = innerSubscriber.queue;
            if (iVar2 == null) {
                iVar2 = new SpscArrayQueue(this.bufferSize);
                innerSubscriber.queue = iVar2;
            }
            if (!iVar2.offer(u)) {
                onError(new MissingBackpressureException("Inner queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            aWG();
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            if (this.errs.Y(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.d.a.onError(th);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                aWJ();
                if (getAndIncrement() == 0) {
                    i iVar = this.queue;
                    if (iVar != null) {
                        iVar.clear();
                    }
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                aWG();
            }
        }

        void aWG() {
            int i;
            c cVar = this.actual;
            int i2 = 1;
            while (!aWH()) {
                long j;
                io.reactivex.internal.b.h hVar = this.queue;
                long j2 = this.requested.get();
                Object obj = j2 == Long.MAX_VALUE ? 1 : null;
                if (hVar != null) {
                    j = 0;
                    while (true) {
                        long j3 = 0;
                        Object obj2 = null;
                        while (j2 != 0) {
                            Object poll = hVar.poll();
                            if (!aWH()) {
                                if (poll == null) {
                                    obj2 = poll;
                                    break;
                                }
                                cVar.e(poll);
                                j2--;
                                j3++;
                                j++;
                                obj2 = poll;
                            } else {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            if (obj != null) {
                                j2 = Long.MAX_VALUE;
                            } else {
                                j2 = this.requested.addAndGet(-j3);
                            }
                        }
                        if (j2 == 0 || r19 == null) {
                            break;
                        }
                    }
                } else {
                    j = 0;
                }
                boolean z = this.done;
                io.reactivex.internal.b.h hVar2 = this.queue;
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (z && ((hVar2 == null || hVar2.isEmpty()) && length == 0)) {
                    Throwable aXi = this.errs.aXi();
                    if (aXi != ExceptionHelper.esW) {
                        if (aXi == null) {
                            cVar.onComplete();
                        } else {
                            cVar.onError(aXi);
                        }
                    }
                    return;
                }
                int i3;
                Object obj3;
                c cVar2;
                long addAndGet;
                if (length != 0) {
                    int i4;
                    i3 = i2;
                    long j4 = this.lastId;
                    int i5 = this.lastIndex;
                    if (length <= i5 || innerSubscriberArr[i5].id != j4) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        i4 = i5;
                        for (i5 = 0; i5 < length && innerSubscriberArr[i4].id != j4; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr[i4].id;
                        i5 = i4;
                    }
                    int i6 = 0;
                    obj3 = null;
                    while (i6 < length) {
                        if (!aWH()) {
                            InnerSubscriber innerSubscriber = innerSubscriberArr[i5];
                            Object obj4 = null;
                            while (!aWH()) {
                                int i7;
                                i iVar = innerSubscriber.queue;
                                if (iVar == null) {
                                    cVar2 = cVar;
                                    i7 = i6;
                                    i = length;
                                } else {
                                    i = length;
                                    Object obj5 = obj4;
                                    long j5 = 0;
                                    while (j2 != 0) {
                                        try {
                                            obj5 = iVar.poll();
                                            if (obj5 == null) {
                                                break;
                                            }
                                            cVar.e(obj5);
                                            if (!aWH()) {
                                                j5++;
                                                j2--;
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            a.V(th);
                                            innerSubscriber.dispose();
                                            this.errs.Y(th);
                                            if (!this.delayErrors) {
                                                this.upstream.cancel();
                                            }
                                            if (!aWH()) {
                                                b(innerSubscriber);
                                                cVar2 = cVar;
                                                i7 = i6 + 1;
                                                i4 = i;
                                                obj3 = 1;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    if (j5 != 0) {
                                        if (obj == null) {
                                            cVar2 = cVar;
                                            i7 = i6;
                                            addAndGet = this.requested.addAndGet(-j5);
                                        } else {
                                            cVar2 = cVar;
                                            i7 = i6;
                                            addAndGet = Long.MAX_VALUE;
                                        }
                                        innerSubscriber.cR(j5);
                                        j2 = addAndGet;
                                    } else {
                                        cVar2 = cVar;
                                        i7 = i6;
                                    }
                                    if (!(j2 == 0 || obj5 == null)) {
                                        obj4 = obj5;
                                        length = i;
                                        cVar = cVar2;
                                        i6 = i7;
                                    }
                                }
                                boolean z2 = innerSubscriber.done;
                                i iVar2 = innerSubscriber.queue;
                                if (z2 && (iVar2 == null || iVar2.isEmpty())) {
                                    b(innerSubscriber);
                                    if (!aWH()) {
                                        j++;
                                        obj3 = 1;
                                    } else {
                                        return;
                                    }
                                }
                                if (j2 == 0) {
                                    break;
                                }
                                length = i5 + 1;
                                i4 = i;
                                i5 = length == i4 ? 0 : length;
                                length = i4;
                                i6 = i7 + 1;
                                cVar = cVar2;
                            }
                            return;
                        }
                        return;
                    }
                    cVar2 = cVar;
                    this.lastIndex = i5;
                    this.lastId = innerSubscriberArr[i5].id;
                    addAndGet = j;
                } else {
                    cVar2 = cVar;
                    i3 = i2;
                    addAndGet = j;
                    obj3 = null;
                }
                if (!(addAndGet == 0 || this.cancelled)) {
                    this.upstream.request(addAndGet);
                }
                if (obj3 != null) {
                    i2 = i3;
                } else {
                    i2 = addAndGet(-i3);
                    if (i2 == 0) {
                        return;
                    }
                }
                cVar = cVar2;
            }
        }

        boolean aWH() {
            if (this.cancelled) {
                aWI();
                return true;
            } else if (this.delayErrors || this.errs.get() == null) {
                return false;
            } else {
                aWI();
                Throwable aXi = this.errs.aXi();
                if (aXi != ExceptionHelper.esW) {
                    this.actual.onError(aXi);
                }
                return true;
            }
        }

        void aWI() {
            i iVar = this.queue;
            if (iVar != null) {
                iVar.clear();
            }
        }

        void aWJ() {
            if (((InnerSubscriber[]) this.subscribers.get()) != eqZ) {
                InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(eqZ);
                if (innerSubscriberArr != eqZ) {
                    for (InnerSubscriber dispose : innerSubscriberArr) {
                        dispose.dispose();
                    }
                    Throwable aXi = this.errs.aXi();
                    if (aXi != null && aXi != ExceptionHelper.esW) {
                        io.reactivex.d.a.onError(aXi);
                    }
                }
            }
        }

        void a(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.errs.Y(th)) {
                innerSubscriber.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber dispose : (InnerSubscriber[]) this.subscribers.getAndSet(eqZ)) {
                        dispose.dispose();
                    }
                }
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }
    }

    public FlowableFlatMap(e<T> eVar, f<? super T, ? extends b<? extends U>> fVar, boolean z, int i, int i2) {
        super(eVar);
        this.mapper = fVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    protected void a(c<? super U> cVar) {
        if (!p.a(this.eqM, cVar, this.mapper)) {
            this.eqM.a(a(cVar, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
        }
    }

    public static <T, U> h<T> a(c<? super U> cVar, f<? super T, ? extends b<? extends U>> fVar, boolean z, int i, int i2) {
        return new MergeSubscriber(cVar, fVar, z, i, i2);
    }
}
