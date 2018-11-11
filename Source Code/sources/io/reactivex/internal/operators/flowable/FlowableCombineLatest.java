package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class FlowableCombineLatest<T, R> extends e<R> {
    final int bufferSize;
    final f<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final b<? extends T>[] eqN;
    final Iterable<? extends b<? extends T>> eqO;

    final class a implements f<T, R> {
        a() {
        }

        public R apply(T t) {
            return FlowableCombineLatest.this.combiner.apply(new Object[]{t});
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<d> implements h<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public void a(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, (long) this.prefetch);
        }

        public void e(T t) {
            this.parent.c(this.index, t);
        }

        public void onError(Throwable th) {
            this.parent.b(this.index, th);
        }

        public void onComplete() {
            this.parent.jd(this.index);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void aWz() {
            int i = this.produced + 1;
            if (i == this.limit) {
                this.produced = 0;
                ((d) get()).request((long) i);
                return;
            }
            this.produced = i;
        }
    }

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final c<? super R> actual;
        volatile boolean cancelled;
        final f<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(c<? super R> cVar, f<? super Object[], ? extends R> fVar, int i, int i2, boolean z) {
            this.actual = cVar;
            this.combiner = fVar;
            CombineLatestInnerSubscriber[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new io.reactivex.internal.queue.a(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference();
            this.delayErrors = z;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void a(b<? extends T>[] bVarArr, int i) {
            CombineLatestInnerSubscriber[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                bVarArr[i2].b(combineLatestInnerSubscriberArr[i2]);
            }
        }

        void c(int i, T t) {
            Object obj;
            synchronized (this) {
                Object obj2 = this.latest;
                int i2 = this.nonEmptySources;
                if (obj2[i] == null) {
                    i2++;
                    this.nonEmptySources = i2;
                }
                obj2[i] = t;
                if (obj2.length == i2) {
                    this.queue.offer(this.subscribers[i], obj2.clone());
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.subscribers[i].aWz();
            } else {
                drain();
            }
        }

        /* JADX WARNING: Missing block: B:12:0x0018, code:
            drain();
     */
        /* JADX WARNING: Missing block: B:13:0x001b, code:
            return;
     */
        void jd(int r3) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.latest;	 Catch:{ all -> 0x001c }
            r3 = r0[r3];	 Catch:{ all -> 0x001c }
            r1 = 1;
            if (r3 == 0) goto L_0x0015;
        L_0x0008:
            r3 = r2.completedSources;	 Catch:{ all -> 0x001c }
            r3 = r3 + r1;
            r0 = r0.length;	 Catch:{ all -> 0x001c }
            if (r3 != r0) goto L_0x0011;
        L_0x000e:
            r2.done = r1;	 Catch:{ all -> 0x001c }
            goto L_0x0017;
        L_0x0011:
            r2.completedSources = r3;	 Catch:{ all -> 0x001c }
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            return;
        L_0x0015:
            r2.done = r1;	 Catch:{ all -> 0x001c }
        L_0x0017:
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            r2.drain();
            return;
        L_0x001c:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCombineLatest.CombineLatestCoordinator.jd(int):void");
        }

        void b(int i, Throwable th) {
            if (!ExceptionHelper.a(this.error, th)) {
                io.reactivex.d.a.onError(th);
            } else if (this.delayErrors) {
                jd(i);
            } else {
                cancelAll();
                this.done = true;
                drain();
            }
        }

        void aWx() {
            c cVar = this.actual;
            io.reactivex.internal.queue.a aVar = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = (Throwable) this.error.get();
                if (th != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean isEmpty = aVar.isEmpty();
                if (!isEmpty) {
                    cVar.e(null);
                }
                if (z && isEmpty) {
                    cVar.onComplete();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            aVar.clear();
        }

        void aWy() {
            c cVar = this.actual;
            io.reactivex.internal.queue.a aVar = this.queue;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = aVar.poll();
                    boolean z2 = poll == null;
                    if (!a(z, z2, cVar, aVar)) {
                        if (z2) {
                            break;
                        }
                        try {
                            cVar.e(io.reactivex.internal.a.b.requireNonNull(this.combiner.apply((Object[]) aVar.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).aWz();
                            j2++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.V(th);
                            cancelAll();
                            ExceptionHelper.a(this.error, th);
                            cVar.onError(ExceptionHelper.a(this.error));
                            return;
                        }
                    }
                    return;
                }
                if (j2 != j || !a(this.done, aVar.isEmpty(), cVar, aVar)) {
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j2);
                    }
                    i = addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    aWx();
                } else {
                    aWy();
                }
            }
        }

        boolean a(boolean z, boolean z2, c<?> cVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                cancelAll();
                aVar.clear();
                return true;
            }
            if (z) {
                Throwable a;
                if (!this.delayErrors) {
                    a = ExceptionHelper.a(this.error);
                    if (a != null && a != ExceptionHelper.esW) {
                        cancelAll();
                        aVar.clear();
                        cVar.onError(a);
                        return true;
                    } else if (z2) {
                        cancelAll();
                        cVar.onComplete();
                        return true;
                    }
                } else if (z2) {
                    cancelAll();
                    a = ExceptionHelper.a(this.error);
                    if (a == null || a == ExceptionHelper.esW) {
                        cVar.onComplete();
                    } else {
                        cVar.onError(a);
                    }
                    return true;
                }
            }
            return false;
        }

        void cancelAll() {
            for (CombineLatestInnerSubscriber cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        public int requestFusion(int i) {
            boolean z = false;
            if ((i & 4) != 0) {
                return 0;
            }
            i &= 2;
            if (i != 0) {
                z = true;
            }
            this.outputFused = z;
            return i;
        }

        public R poll() {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R requireNonNull = io.reactivex.internal.a.b.requireNonNull(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).aWz();
            return requireNonNull;
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public FlowableCombineLatest(b<? extends T>[] bVarArr, f<? super Object[], ? extends R> fVar, int i, boolean z) {
        this.eqN = bVarArr;
        this.eqO = null;
        this.combiner = fVar;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public FlowableCombineLatest(Iterable<? extends b<? extends T>> iterable, f<? super Object[], ? extends R> fVar, int i, boolean z) {
        this.eqN = null;
        this.eqO = iterable;
        this.combiner = fVar;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public void a(c<? super R> cVar) {
        int i;
        b[] bVarArr = this.eqN;
        if (bVarArr == null) {
            bVarArr = new b[8];
            try {
                Iterator it = (Iterator) io.reactivex.internal.a.b.requireNonNull(this.eqO.iterator(), "The iterator returned is null");
                i = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            b bVar = (b) io.reactivex.internal.a.b.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (i == bVarArr.length) {
                                Object obj = new b[((i >> 2) + i)];
                                System.arraycopy(bVarArr, 0, obj, 0, i);
                                bVarArr = obj;
                            }
                            int i2 = i + 1;
                            bVarArr[i] = bVar;
                            i = i2;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.V(th);
                            EmptySubscription.error(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.V(th2);
                        EmptySubscription.error(th2, cVar);
                        return;
                    }
                }
            } catch (Throwable th22) {
                io.reactivex.exceptions.a.V(th22);
                EmptySubscription.error(th22, cVar);
                return;
            }
        }
        i = bVarArr.length;
        if (i == 0) {
            EmptySubscription.complete(cVar);
        } else if (i == 1) {
            bVarArr[0].b(new b(cVar, new a()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(cVar, this.combiner, i, this.bufferSize, this.delayErrors);
            cVar.a(combineLatestCoordinator);
            combineLatestCoordinator.a(bVarArr, i);
        }
    }
}
