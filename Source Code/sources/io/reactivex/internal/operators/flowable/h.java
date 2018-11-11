package io.reactivex.internal.operators.flowable;

import io.reactivex.c.k;
import io.reactivex.e;
import io.reactivex.internal.b.f;
import org.a.c;

/* compiled from: FlowableFilter */
public final class h<T> extends a<T, T> {
    final k<? super T> eqW;

    /* compiled from: FlowableFilter */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final k<? super T> eqX;

        a(io.reactivex.internal.b.a<? super T> aVar, k<? super T> kVar) {
            super(aVar);
            this.eqX = kVar;
        }

        public void e(T t) {
            if (!cf(t)) {
                this.s.request(1);
            }
        }

        public boolean cf(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.actual.cf(null);
            }
            boolean z = true;
            try {
                if (!(this.eqX.test(t) && this.actual.cf(t))) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                N(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public T poll() {
            f fVar = this.qs;
            k kVar = this.eqX;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (kVar.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    fVar.request(1);
                }
            }
        }
    }

    /* compiled from: FlowableFilter */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> implements io.reactivex.internal.b.a<T> {
        final k<? super T> eqX;

        b(c<? super T> cVar, k<? super T> kVar) {
            super(cVar);
            this.eqX = kVar;
        }

        public void e(T t) {
            if (!cf(t)) {
                this.s.request(1);
            }
        }

        public boolean cf(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.actual.e(null);
                return true;
            }
            try {
                boolean test = this.eqX.test(t);
                if (test) {
                    this.actual.e(t);
                }
                return test;
            } catch (Throwable th) {
                N(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public T poll() {
            f fVar = this.qs;
            k kVar = this.eqX;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (kVar.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    fVar.request(1);
                }
            }
        }
    }

    public h(e<T> eVar, k<? super T> kVar) {
        super(eVar);
        this.eqW = kVar;
    }

    protected void a(c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.b.a) {
            this.eqM.a(new a((io.reactivex.internal.b.a) cVar, this.eqW));
        } else {
            this.eqM.a(new b(cVar, this.eqW));
        }
    }
}
