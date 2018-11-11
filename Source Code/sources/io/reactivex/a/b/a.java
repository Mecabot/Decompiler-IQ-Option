package io.reactivex.a.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.n;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers */
public final class a {
    private static final n eqi = io.reactivex.a.a.a.i(new Callable<n>() {
        /* renamed from: aWn */
        public n call() {
            return a.eqj;
        }
    });

    /* compiled from: AndroidSchedulers */
    private static final class a {
        static final n eqj = new b(new Handler(Looper.getMainLooper()));
    }

    public static n aWm() {
        return io.reactivex.a.a.a.i(eqi);
    }
}
