package io.reactivex.internal.operators.single;

import io.reactivex.disposables.c;
import io.reactivex.o;
import io.reactivex.q;

/* compiled from: SingleJust */
public final class d<T> extends o<T> {
    final T value;

    public d(T t) {
        this.value = t;
    }

    protected void b(q<? super T> qVar) {
        qVar.d(c.aWp());
        qVar.onSuccess(this.value);
    }
}
