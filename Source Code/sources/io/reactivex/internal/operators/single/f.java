package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;

/* compiled from: SingleOnErrorReturn */
public final class f<T> extends o<T> {
    final s<? extends T> source;
    final T value;
    final io.reactivex.c.f<? super Throwable, ? extends T> valueSupplier;

    /* compiled from: SingleOnErrorReturn */
    final class a implements q<T> {
        private final q<? super T> erD;

        a(q<? super T> qVar) {
            this.erD = qVar;
        }

        public void onError(Throwable th) {
            Object apply;
            Throwable th2;
            if (f.this.valueSupplier != null) {
                try {
                    apply = f.this.valueSupplier.apply(th);
                } catch (Throwable th22) {
                    io.reactivex.exceptions.a.V(th22);
                    this.erD.onError(new CompositeException(th, th22));
                    return;
                }
            }
            apply = f.this.value;
            if (apply == null) {
                th22 = new NullPointerException("Value supplied was null");
                th22.initCause(th);
                this.erD.onError(th22);
                return;
            }
            this.erD.onSuccess(apply);
        }

        public void d(b bVar) {
            this.erD.d(bVar);
        }

        public void onSuccess(T t) {
            this.erD.onSuccess(t);
        }
    }

    public f(s<? extends T> sVar, io.reactivex.c.f<? super Throwable, ? extends T> fVar, T t) {
        this.source = sVar;
        this.valueSupplier = fVar;
        this.value = t;
    }

    protected void b(q<? super T> qVar) {
        this.source.a(new a(qVar));
    }
}
