package io.reactivex.internal.operators.flowable;

import io.reactivex.c.b;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.c;
import org.a.d;

/* compiled from: FlowableScan */
public final class q<T> extends a<T, T> {
    final b<T, T, T> ero;

    /* compiled from: FlowableScan */
    static final class a<T> implements h<T>, d {
        final c<? super T> actual;
        boolean done;
        final b<T, T, T> ero;
        d s;
        T value;

        a(c<? super T> cVar, b<T, T, T> bVar) {
            this.actual = cVar;
            this.ero = bVar;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.a(this);
            }
        }

        public void e(T t) {
            if (!this.done) {
                c cVar = this.actual;
                Object obj = this.value;
                if (obj == null) {
                    this.value = t;
                    cVar.e(t);
                } else {
                    try {
                        Object requireNonNull = io.reactivex.internal.a.b.requireNonNull(this.ero.apply(obj, t), "The value returned by the accumulator is null");
                        this.value = requireNonNull;
                        cVar.e(requireNonNull);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        this.s.cancel();
                        onError(th);
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            this.s.request(j);
        }

        public void cancel() {
            this.s.cancel();
        }
    }

    public q(e<T> eVar, b<T, T, T> bVar) {
        super(eVar);
        this.ero = bVar;
    }

    protected void a(c<? super T> cVar) {
        this.eqM.a(new a(cVar, this.ero));
    }
}
