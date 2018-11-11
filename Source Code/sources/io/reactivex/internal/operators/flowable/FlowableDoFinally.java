package io.reactivex.internal.operators.flowable;

import io.reactivex.c.a;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.b.f;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.c;
import org.a.d;

public final class FlowableDoFinally<T> extends a<T, T> {
    final a onFinally;

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.internal.b.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.internal.b.a<? super T> actual;
        final a onFinally;
        f<T> qs;
        d s;
        boolean syncFused;

        DoFinallyConditionalSubscriber(io.reactivex.internal.b.a<? super T> aVar, a aVar2) {
            this.actual = aVar;
            this.onFinally = aVar2;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof f) {
                    this.qs = (f) dVar;
                }
                this.actual.a(this);
            }
        }

        public void e(T t) {
            this.actual.e(t);
        }

        public boolean cf(T t) {
            return this.actual.cf(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            aWE();
        }

        public void onComplete() {
            this.actual.onComplete();
            aWE();
        }

        public void cancel() {
            this.s.cancel();
            aWE();
        }

        public void request(long j) {
            this.s.request(j);
        }

        public int requestFusion(int i) {
            f fVar = this.qs;
            if (fVar == null || (i & 4) != 0) {
                return 0;
            }
            i = fVar.requestFusion(i);
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                this.syncFused = z;
            }
            return i;
        }

        public void clear() {
            this.qs.clear();
        }

        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public T poll() {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                aWE();
            }
            return poll;
        }

        void aWE() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.V(th);
                    io.reactivex.d.a.onError(th);
                }
            }
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements h<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final c<? super T> actual;
        final a onFinally;
        f<T> qs;
        d s;
        boolean syncFused;

        DoFinallySubscriber(c<? super T> cVar, a aVar) {
            this.actual = cVar;
            this.onFinally = aVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof f) {
                    this.qs = (f) dVar;
                }
                this.actual.a(this);
            }
        }

        public void e(T t) {
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            aWE();
        }

        public void onComplete() {
            this.actual.onComplete();
            aWE();
        }

        public void cancel() {
            this.s.cancel();
            aWE();
        }

        public void request(long j) {
            this.s.request(j);
        }

        public int requestFusion(int i) {
            f fVar = this.qs;
            if (fVar == null || (i & 4) != 0) {
                return 0;
            }
            i = fVar.requestFusion(i);
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                this.syncFused = z;
            }
            return i;
        }

        public void clear() {
            this.qs.clear();
        }

        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        public T poll() {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                aWE();
            }
            return poll;
        }

        void aWE() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.V(th);
                    io.reactivex.d.a.onError(th);
                }
            }
        }
    }

    public FlowableDoFinally(e<T> eVar, a aVar) {
        super(eVar);
        this.onFinally = aVar;
    }

    protected void a(c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.b.a) {
            this.eqM.a(new DoFinallyConditionalSubscriber((io.reactivex.internal.b.a) cVar, this.onFinally));
        } else {
            this.eqM.a(new DoFinallySubscriber(cVar, this.onFinally));
        }
    }
}
