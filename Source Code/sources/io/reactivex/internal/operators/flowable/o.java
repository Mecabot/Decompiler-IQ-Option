package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.a.b;
import org.a.c;
import org.a.d;

/* compiled from: FlowableOnErrorNext */
public final class o<T> extends a<T, T> {
    final f<? super Throwable, ? extends b<? extends T>> ere;
    final boolean erf;

    /* compiled from: FlowableOnErrorNext */
    static final class a<T> implements h<T> {
        final c<? super T> actual;
        boolean done;
        final f<? super Throwable, ? extends b<? extends T>> ere;
        final boolean erf;
        final SubscriptionArbiter erg = new SubscriptionArbiter();
        boolean once;

        a(c<? super T> cVar, f<? super Throwable, ? extends b<? extends T>> fVar, boolean z) {
            this.actual = cVar;
            this.ere = fVar;
            this.erf = z;
        }

        public void a(d dVar) {
            this.erg.b(dVar);
        }

        public void e(T t) {
            if (!this.done) {
                this.actual.e(t);
                if (!this.once) {
                    this.erg.cX(1);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.once) {
                this.once = true;
                if (!this.erf || (th instanceof Exception)) {
                    try {
                        b bVar = (b) this.ere.apply(th);
                        if (bVar == null) {
                            Throwable nullPointerException = new NullPointerException("Publisher is null");
                            nullPointerException.initCause(th);
                            this.actual.onError(nullPointerException);
                            return;
                        }
                        bVar.b(this);
                        return;
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.V(th2);
                        this.actual.onError(new CompositeException(th, th2));
                        return;
                    }
                }
                this.actual.onError(th);
            } else if (this.done) {
                io.reactivex.d.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.once = true;
                this.actual.onComplete();
            }
        }
    }

    public o(e<T> eVar, f<? super Throwable, ? extends b<? extends T>> fVar, boolean z) {
        super(eVar);
        this.ere = fVar;
        this.erf = z;
    }

    protected void a(c<? super T> cVar) {
        h aVar = new a(cVar, this.ere, this.erf);
        cVar.a(aVar.erg);
        this.eqM.a(aVar);
    }
}
