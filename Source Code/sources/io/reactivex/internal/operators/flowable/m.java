package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import org.a.c;

/* compiled from: FlowableMap */
public final class m<T, U> extends a<T, U> {
    final f<? super T, ? extends U> mapper;

    /* compiled from: FlowableMap */
    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {
        final f<? super T, ? extends U> mapper;

        a(io.reactivex.internal.b.a<? super U> aVar, f<? super T, ? extends U> fVar) {
            super(aVar);
            this.mapper = fVar;
        }

        public void e(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.e(null);
                    return;
                }
                try {
                    this.actual.e(io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    N(th);
                }
            }
        }

        public boolean cf(T t) {
            if (this.done) {
                return false;
            }
            try {
                return this.actual.cf(io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                N(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public U poll() {
            Object poll = this.qs.poll();
            return poll != null ? io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.") : null;
        }
    }

    /* compiled from: FlowableMap */
    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {
        final f<? super T, ? extends U> mapper;

        b(c<? super U> cVar, f<? super T, ? extends U> fVar) {
            super(cVar);
            this.mapper = fVar;
        }

        public void e(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.e(null);
                    return;
                }
                try {
                    this.actual.e(io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    N(th);
                }
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public U poll() {
            Object poll = this.qs.poll();
            return poll != null ? io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.") : null;
        }
    }

    public m(e<T> eVar, f<? super T, ? extends U> fVar) {
        super(eVar);
        this.mapper = fVar;
    }

    protected void a(c<? super U> cVar) {
        if (cVar instanceof io.reactivex.internal.b.a) {
            this.eqM.a(new a((io.reactivex.internal.b.a) cVar, this.mapper));
        } else {
            this.eqM.a(new b(cVar, this.mapper));
        }
    }
}
