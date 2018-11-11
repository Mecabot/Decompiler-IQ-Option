package io.fabric.sdk.android.services.a;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class a<T> implements c<T> {
    private final c<T> emF;

    protected abstract T cx(Context context);

    protected abstract void e(Context context, T t);

    public a(c<T> cVar) {
        this.emF = cVar;
    }

    public final synchronized T a(Context context, d<T> dVar) {
        T cx;
        cx = cx(context);
        if (cx == null) {
            cx = this.emF != null ? this.emF.a(context, dVar) : dVar.cy(context);
            f(context, cx);
        }
        return cx;
    }

    private void f(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        e(context, t);
    }
}
