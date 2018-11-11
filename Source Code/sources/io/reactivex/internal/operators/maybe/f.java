package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;

/* compiled from: MaybeMap */
public final class f<T, R> extends a<T, R> {
    final io.reactivex.c.f<? super T, ? extends R> mapper;

    /* compiled from: MaybeMap */
    static final class a<T, R> implements b, j<T> {
        final j<? super R> actual;
        b d;
        final io.reactivex.c.f<? super T, ? extends R> mapper;

        a(j<? super R> jVar, io.reactivex.c.f<? super T, ? extends R> fVar) {
            this.actual = jVar;
            this.mapper = fVar;
        }

        public void dispose() {
            b bVar = this.d;
            this.d = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        public void d(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.d(this);
            }
        }

        public void onSuccess(T t) {
            try {
                this.actual.onSuccess(io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                this.actual.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public f(k<T> kVar, io.reactivex.c.f<? super T, ? extends R> fVar) {
        super(kVar);
        this.mapper = fVar;
    }

    protected void b(j<? super R> jVar) {
        this.err.a(new a(jVar, this.mapper));
    }
}
