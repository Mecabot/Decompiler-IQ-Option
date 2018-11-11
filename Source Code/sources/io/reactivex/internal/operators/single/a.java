package io.reactivex.internal.operators.single;

import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;

/* compiled from: SingleDoOnSuccess */
public final class a<T> extends o<T> {
    final e<? super T> onSuccess;
    final s<T> source;

    /* compiled from: SingleDoOnSuccess */
    final class a implements q<T> {
        private final q<? super T> erA;

        a(q<? super T> qVar) {
            this.erA = qVar;
        }

        public void d(b bVar) {
            this.erA.d(bVar);
        }

        public void onSuccess(T t) {
            try {
                a.this.onSuccess.accept(t);
                this.erA.onSuccess(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                this.erA.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.erA.onError(th);
        }
    }

    public a(s<T> sVar, e<? super T> eVar) {
        this.source = sVar;
        this.onSuccess = eVar;
    }

    protected void b(q<? super T> qVar) {
        this.source.a(new a(qVar));
    }
}
