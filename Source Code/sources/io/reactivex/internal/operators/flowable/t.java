package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.a.b;
import org.a.c;
import org.a.d;

/* compiled from: FlowableSwitchIfEmpty */
public final class t<T> extends a<T, T> {
    final b<? extends T> erq;

    /* compiled from: FlowableSwitchIfEmpty */
    static final class a<T> implements h<T> {
        final c<? super T> actual;
        boolean empty = true;
        final SubscriptionArbiter erg = new SubscriptionArbiter();
        final b<? extends T> erq;

        a(c<? super T> cVar, b<? extends T> bVar) {
            this.actual = cVar;
            this.erq = bVar;
        }

        public void a(d dVar) {
            this.erg.b(dVar);
        }

        public void e(T t) {
            if (this.empty) {
                this.empty = false;
            }
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            if (this.empty) {
                this.empty = false;
                this.erq.b(this);
                return;
            }
            this.actual.onComplete();
        }
    }

    public t(e<T> eVar, b<? extends T> bVar) {
        super(eVar);
        this.erq = bVar;
    }

    protected void a(c<? super T> cVar) {
        h aVar = new a(cVar, this.erq);
        cVar.a(aVar.erg);
        this.eqM.a(aVar);
    }
}
