package io.reactivex.internal.operators.maybe;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends a {
    final k<T> err;
    final f<? super T, ? extends c> mapper;

    static final class FlatMapCompletableObserver<T> extends AtomicReference<b> implements io.reactivex.b, b, j<T> {
        private static final long serialVersionUID = -2177128922851101253L;
        final io.reactivex.b actual;
        final f<? super T, ? extends c> mapper;

        FlatMapCompletableObserver(io.reactivex.b bVar, f<? super T, ? extends c> fVar) {
            this.actual = bVar;
            this.mapper = fVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void d(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        public void onSuccess(T t) {
            try {
                c cVar = (c) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    cVar.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public MaybeFlatMapCompletable(k<T> kVar, f<? super T, ? extends c> fVar) {
        this.err = kVar;
        this.mapper = fVar;
    }

    protected void b(io.reactivex.b bVar) {
        Object flatMapCompletableObserver = new FlatMapCompletableObserver(bVar, this.mapper);
        bVar.d(flatMapCompletableObserver);
        this.err.a(flatMapCompletableObserver);
    }
}
