package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.l;
import io.reactivex.m;
import org.a.c;
import org.a.d;

/* compiled from: FlowableFromObservable */
public final class j<T> extends e<T> {
    private final l<T> erb;

    /* compiled from: FlowableFromObservable */
    static class a<T> implements m<T>, d {
        private b d;
        private final c<? super T> erc;

        public void request(long j) {
        }

        a(c<? super T> cVar) {
            this.erc = cVar;
        }

        public void onComplete() {
            this.erc.onComplete();
        }

        public void onError(Throwable th) {
            this.erc.onError(th);
        }

        public void e(T t) {
            this.erc.e(t);
        }

        public void d(b bVar) {
            this.d = bVar;
            this.erc.a(this);
        }

        public void cancel() {
            this.d.dispose();
        }
    }

    public j(l<T> lVar) {
        this.erb = lVar;
    }

    protected void a(c<? super T> cVar) {
        this.erb.a(new a(cVar));
    }
}
