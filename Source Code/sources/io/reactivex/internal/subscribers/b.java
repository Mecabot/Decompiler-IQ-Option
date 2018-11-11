package io.reactivex.internal.subscribers;

import io.reactivex.d.a;
import io.reactivex.h;
import io.reactivex.internal.b.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.c;
import org.a.d;

/* compiled from: BasicFuseableSubscriber */
public abstract class b<T, R> implements h<T>, f<R> {
    protected final c<? super R> actual;
    protected boolean done;
    protected f<T> qs;
    protected d s;
    protected int sourceMode;

    protected boolean aXg() {
        return true;
    }

    protected void aXh() {
    }

    public b(c<? super R> cVar) {
        this.actual = cVar;
    }

    public final void a(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof f) {
                this.qs = (f) dVar;
            }
            if (aXg()) {
                this.actual.a(this);
                aXh();
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            a.onError(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    protected final void N(Throwable th) {
        io.reactivex.exceptions.a.V(th);
        this.s.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    protected final int ji(int i) {
        f fVar = this.qs;
        if (fVar == null || (i & 4) != 0) {
            return 0;
        }
        i = fVar.requestFusion(i);
        if (i != 0) {
            this.sourceMode = i;
        }
        return i;
    }

    public void request(long j) {
        this.s.request(j);
    }

    public void cancel() {
        this.s.cancel();
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public void clear() {
        this.qs.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
