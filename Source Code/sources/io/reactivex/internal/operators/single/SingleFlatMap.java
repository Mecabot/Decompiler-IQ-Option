package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R> extends o<R> {
    final f<? super T, ? extends s<? extends R>> mapper;
    final s<? extends T> source;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<b> implements b, q<T> {
        private static final long serialVersionUID = 3258103020495908596L;
        final q<? super R> actual;
        final f<? super T, ? extends s<? extends R>> mapper;

        static final class a<R> implements q<R> {
            final q<? super R> actual;
            final AtomicReference<b> eqD;

            a(AtomicReference<b> atomicReference, q<? super R> qVar) {
                this.eqD = atomicReference;
                this.actual = qVar;
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
        }

        SingleFlatMapCallback(q<? super R> qVar, f<? super T, ? extends s<? extends R>> fVar) {
            this.actual = qVar;
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
                s sVar = (s) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    sVar.a(new a(this, this.actual));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                this.actual.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }

    public SingleFlatMap(s<? extends T> sVar, f<? super T, ? extends s<? extends R>> fVar) {
        this.mapper = fVar;
        this.source = sVar;
    }

    protected void b(q<? super R> qVar) {
        this.source.a(new SingleFlatMapCallback(qVar, this.mapper));
    }
}
