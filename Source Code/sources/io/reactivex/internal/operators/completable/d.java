package io.reactivex.internal.operators.completable;

import io.reactivex.b;
import io.reactivex.q;
import io.reactivex.s;

/* compiled from: CompletableFromSingle */
public final class d<T> extends io.reactivex.a {
    final s<T> eqG;

    /* compiled from: CompletableFromSingle */
    static final class a<T> implements q<T> {
        final b eqH;

        a(b bVar) {
            this.eqH = bVar;
        }

        public void onError(Throwable th) {
            this.eqH.onError(th);
        }

        public void d(io.reactivex.disposables.b bVar) {
            this.eqH.d(bVar);
        }

        public void onSuccess(T t) {
            this.eqH.onComplete();
        }
    }

    public d(s<T> sVar) {
        this.eqG = sVar;
    }

    protected void b(b bVar) {
        this.eqG.a(new a(bVar));
    }
}
