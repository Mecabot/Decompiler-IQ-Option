package io.reactivex.internal.operators.completable;

import io.reactivex.c;
import io.reactivex.c.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletablePeek */
public final class f extends io.reactivex.a {
    final io.reactivex.c.a eqI;
    final io.reactivex.c.a eqJ;
    final io.reactivex.c.a eqK;
    final io.reactivex.c.a onComplete;
    final e<? super Throwable> onError;
    final e<? super b> onSubscribe;
    final c source;

    /* compiled from: CompletablePeek */
    final class a implements io.reactivex.b, b {
        final io.reactivex.b actual;
        b d;

        a(io.reactivex.b bVar) {
            this.actual = bVar;
        }

        public void d(b bVar) {
            try {
                f.this.onSubscribe.accept(bVar);
                if (DisposableHelper.validate(this.d, bVar)) {
                    this.d = bVar;
                    this.actual.d(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                bVar.dispose();
                this.d = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.actual);
            }
        }

        public void onError(Throwable th) {
            if (this.d == DisposableHelper.DISPOSED) {
                io.reactivex.d.a.onError(th);
                return;
            }
            try {
                f.this.onError.accept(th);
                f.this.eqI.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.V(th2);
                th = new CompositeException(th, th2);
            }
            this.actual.onError(th);
            aWw();
        }

        public void onComplete() {
            if (this.d != DisposableHelper.DISPOSED) {
                try {
                    f.this.onComplete.run();
                    f.this.eqI.run();
                    this.actual.onComplete();
                    aWw();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.V(th);
                    this.actual.onError(th);
                }
            }
        }

        void aWw() {
            try {
                f.this.eqJ.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                io.reactivex.d.a.onError(th);
            }
        }

        public void dispose() {
            try {
                f.this.eqK.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.V(th);
                io.reactivex.d.a.onError(th);
            }
            this.d.dispose();
        }

        public boolean isDisposed() {
            return this.d.isDisposed();
        }
    }

    public f(c cVar, e<? super b> eVar, e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3, io.reactivex.c.a aVar4) {
        this.source = cVar;
        this.onSubscribe = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.eqI = aVar2;
        this.eqJ = aVar3;
        this.eqK = aVar4;
    }

    protected void b(io.reactivex.b bVar) {
        this.source.a(new a(bVar));
    }
}
