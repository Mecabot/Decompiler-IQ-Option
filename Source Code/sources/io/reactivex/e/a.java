package io.reactivex.e;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import io.reactivex.n;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers */
public final class a {
    static final n etI = io.reactivex.d.a.n(new h());
    static final n etJ = io.reactivex.d.a.k(new b());
    static final n etK = io.reactivex.d.a.l(new c());
    static final n etL = j.aXf();
    static final n etM = io.reactivex.d.a.m(new f());

    /* compiled from: Schedulers */
    static final class a {
        static final n eqj = new io.reactivex.internal.schedulers.a();
    }

    /* compiled from: Schedulers */
    static final class b implements Callable<n> {
        b() {
        }

        /* renamed from: aWn */
        public n call() {
            return a.eqj;
        }
    }

    /* compiled from: Schedulers */
    static final class c implements Callable<n> {
        c() {
        }

        /* renamed from: aWn */
        public n call() {
            return d.eqj;
        }
    }

    /* compiled from: Schedulers */
    static final class d {
        static final n eqj = new io.reactivex.internal.schedulers.d();
    }

    /* compiled from: Schedulers */
    static final class e {
        static final n eqj = new io.reactivex.internal.schedulers.e();
    }

    /* compiled from: Schedulers */
    static final class f implements Callable<n> {
        f() {
        }

        /* renamed from: aWn */
        public n call() {
            return e.eqj;
        }
    }

    /* compiled from: Schedulers */
    static final class g {
        static final n eqj = new i();
    }

    /* compiled from: Schedulers */
    static final class h implements Callable<n> {
        h() {
        }

        /* renamed from: aWn */
        public n call() {
            return g.eqj;
        }
    }

    public static n aXs() {
        return io.reactivex.d.a.j(etJ);
    }

    public static n aXt() {
        return io.reactivex.d.a.k(etK);
    }

    public static n aXu() {
        return etL;
    }

    public static n aXv() {
        return io.reactivex.d.a.l(etI);
    }

    public static n a(Executor executor) {
        return new ExecutorScheduler(executor);
    }
}
