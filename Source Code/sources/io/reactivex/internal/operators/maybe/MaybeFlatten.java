package io.reactivex.internal.operators.maybe;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends a<T, R> {
    final f<? super T, ? extends k<? extends R>> mapper;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements b, j<T> {
        private static final long serialVersionUID = 4375739915521278546L;
        final j<? super R> actual;
        b d;
        final f<? super T, ? extends k<? extends R>> mapper;

        final class a implements j<R> {
            a() {
            }

            public void d(b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.actual.onSuccess(r);
            }

            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.actual.onError(th);
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.actual.onComplete();
            }
        }

        FlatMapMaybeObserver(j<? super R> jVar, f<? super T, ? extends k<? extends R>> fVar) {
            this.actual = jVar;
            this.mapper = fVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void d(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.d(this);
            }
        }

        public void onSuccess(T t) {
            try {
                k kVar = (k) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    kVar.a(new a());
                }
            } catch (Throwable e) {
                io.reactivex.exceptions.a.V(e);
                this.actual.onError(e);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public MaybeFlatten(k<T> kVar, f<? super T, ? extends k<? extends R>> fVar) {
        super(kVar);
        this.mapper = fVar;
    }

    protected void b(j<? super R> jVar) {
        this.err.a(new FlatMapMaybeObserver(jVar, this.mapper));
    }
}
