package io.reactivex.internal.operators.flowable;

import io.reactivex.c.e;
import io.reactivex.c.j;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.d;

/* compiled from: FlowableDoOnLifecycle */
public final class c<T> extends a<T, T> {
    private final j eqS;
    private final io.reactivex.c.a eqT;
    private final e<? super d> onSubscribe;

    /* compiled from: FlowableDoOnLifecycle */
    static final class a<T> implements h<T>, d {
        final org.a.c<? super T> actual;
        final j eqS;
        final io.reactivex.c.a eqT;
        final e<? super d> onSubscribe;
        d s;

        a(org.a.c<? super T> cVar, e<? super d> eVar, j jVar, io.reactivex.c.a aVar) {
            this.actual = cVar;
            this.onSubscribe = eVar;
            this.eqT = aVar;
            this.eqS = jVar;
        }

        public void a(d dVar) {
            try {
                this.onSubscribe.accept(dVar);
                if (SubscriptionHelper.validate(this.s, dVar)) {
                    this.s = dVar;
                    this.actual.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                dVar.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.actual);
            }
        }

        public void e(T t) {
            this.actual.e(t);
        }

        public void onError(Throwable th) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onError(th);
            } else {
                io.reactivex.d.a.onError(th);
            }
        }

        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            try {
                this.eqS.accept(j);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                io.reactivex.d.a.onError(th);
            }
            this.s.request(j);
        }

        public void cancel() {
            try {
                this.eqT.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                io.reactivex.d.a.onError(th);
            }
            this.s.cancel();
        }
    }

    public c(io.reactivex.e<T> eVar, e<? super d> eVar2, j jVar, io.reactivex.c.a aVar) {
        super(eVar);
        this.onSubscribe = eVar2;
        this.eqS = jVar;
        this.eqT = aVar;
    }

    protected void a(org.a.c<? super T> cVar) {
        this.eqM.a(new a(cVar, this.onSubscribe, this.eqS, this.eqT));
    }
}
