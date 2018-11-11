package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.q;
import io.reactivex.s;

/* compiled from: MaybeFromSingle */
public final class d<T> extends i<T> {
    final s<T> source;

    /* compiled from: MaybeFromSingle */
    static final class a<T> implements b, q<T> {
        final j<? super T> actual;
        b d;

        a(j<? super T> jVar) {
            this.actual = jVar;
        }

        public void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
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
            this.d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }
    }

    public d(s<T> sVar) {
        this.source = sVar;
    }

    protected void b(j<? super T> jVar) {
        this.source.a(new a(jVar));
    }
}
