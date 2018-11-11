package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapMaybe<T, R> extends i<R> {
    final f<? super T, ? extends k<? extends R>> mapper;
    final s<? extends T> source;

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<b> implements b, q<T> {
        private static final long serialVersionUID = -5843758257109742742L;
        final j<? super R> actual;
        final f<? super T, ? extends k<? extends R>> mapper;

        FlatMapSingleObserver(j<? super R> jVar, f<? super T, ? extends k<? extends R>> fVar) {
            this.actual = jVar;
            this.mapper = fVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void d(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.d(this);
            }
        }

        public void onSuccess(T t) {
            try {
                k kVar = (k) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    kVar.a(new a(this, this.actual));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }

    static final class a<R> implements j<R> {
        final j<? super R> actual;
        final AtomicReference<b> eqD;

        a(AtomicReference<b> atomicReference, j<? super R> jVar) {
            this.eqD = atomicReference;
            this.actual = jVar;
        }

        public void d(b bVar) {
            DisposableHelper.replace(this.eqD, bVar);
        }

        public void onSuccess(R r) {
            this.actual.onSuccess(r);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public SingleFlatMapMaybe(s<? extends T> sVar, f<? super T, ? extends k<? extends R>> fVar) {
        this.mapper = fVar;
        this.source = sVar;
    }

    protected void b(j<? super R> jVar) {
        this.source.a(new FlatMapSingleObserver(jVar, this.mapper));
    }
}
