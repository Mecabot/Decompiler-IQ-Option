package io.reactivex.internal.operators.single;

import io.reactivex.d.a;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCreate<T> extends o<T> {
    final r<T> ery;

    static final class Emitter<T> extends AtomicReference<b> implements b, p<T> {
        private static final long serialVersionUID = -2467358622224974244L;
        final q<? super T> actual;

        Emitter(q<? super T> qVar) {
            this.actual = qVar;
        }

        public void onSuccess(T t) {
            if (get() != DisposableHelper.DISPOSED) {
                b bVar = (b) getAndSet(DisposableHelper.DISPOSED);
                if (bVar != DisposableHelper.DISPOSED) {
                    if (t == null) {
                        try {
                            this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (bVar != null) {
                                bVar.dispose();
                            }
                        }
                    } else {
                        this.actual.onSuccess(t);
                    }
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (!W(th)) {
                a.onError(th);
            }
        }

        public boolean W(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() != DisposableHelper.DISPOSED) {
                b bVar = (b) getAndSet(DisposableHelper.DISPOSED);
                if (bVar != DisposableHelper.DISPOSED) {
                    try {
                        this.actual.onError(th);
                        return true;
                    } finally {
                        if (bVar != null) {
                            bVar.dispose();
                        }
                    }
                }
            }
            return false;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    public SingleCreate(r<T> rVar) {
        this.ery = rVar;
    }

    protected void b(q<? super T> qVar) {
        Emitter emitter = new Emitter(qVar);
        qVar.d(emitter);
        try {
            this.ery.a(emitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            emitter.onError(th);
        }
    }
}
