package com.airbnb.lottie.e;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import com.airbnb.lottie.a.b.a;

/* compiled from: LottieValueCallback */
public class c<T> {
    private final b<T> lP = new b();
    @Nullable
    a<?, ?> pa;
    @Nullable
    protected T value = null;

    public c(@Nullable T t) {
        this.value = t;
    }

    public T a(b<T> bVar) {
        return this.value;
    }

    @RestrictTo({Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.lP.a(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({Scope.LIBRARY})
    public final void b(@Nullable a<?, ?> aVar) {
        this.pa = aVar;
    }
}
