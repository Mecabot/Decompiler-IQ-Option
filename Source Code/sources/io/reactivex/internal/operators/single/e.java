package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;

/* compiled from: SingleMap */
public final class e<T, R> extends o<R> {
    final f<? super T, ? extends R> mapper;
    final s<? extends T> source;

    /* compiled from: SingleMap */
    static final class a<T, R> implements q<T> {
        final q<? super R> erC;
        final f<? super T, ? extends R> mapper;

        a(q<? super R> qVar, f<? super T, ? extends R> fVar) {
            this.erC = qVar;
            this.mapper = fVar;
        }

        public void d(b bVar) {
            this.erC.d(bVar);
        }

        public void onSuccess(T t) {
            try {
                this.erC.onSuccess(io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.erC.onError(th);
        }
    }

    public e(s<? extends T> sVar, f<? super T, ? extends R> fVar) {
        this.source = sVar;
        this.mapper = fVar;
    }

    protected void b(q<? super R> qVar) {
        this.source.a(new a(qVar, this.mapper));
    }
}
