package io.reactivex.internal.a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: Functions */
public final class a {
    static final io.reactivex.c.e<Object> aBk = new f();
    public static final io.reactivex.c.a aBl = new e();
    static final io.reactivex.c.f<Object, Object> eqo = new l();
    public static final Runnable eqp = new h();
    public static final io.reactivex.c.e<Throwable> eqq = new i();
    public static final io.reactivex.c.e<Throwable> eqr = new q();
    public static final io.reactivex.c.j eqs = new g();
    static final io.reactivex.c.k<Object> eqt = new r();
    static final io.reactivex.c.k<Object> equ = new j();
    static final Callable<Object> eqv = new p();
    static final Comparator<Object> eqw = new o();
    public static final io.reactivex.c.e<org.a.d> eqx = new n();

    /* compiled from: Functions */
    static final class h implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        h() {
        }
    }

    /* compiled from: Functions */
    static final class o implements Comparator<Object> {
        o() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions */
    static final class p implements Callable<Object> {
        public Object call() {
            return null;
        }

        p() {
        }
    }

    /* compiled from: Functions */
    static final class a<T1, T2, R> implements io.reactivex.c.f<Object[], R> {
        final io.reactivex.c.b<? super T1, ? super T2, ? extends R> eqy;

        a(io.reactivex.c.b<? super T1, ? super T2, ? extends R> bVar) {
            this.eqy = bVar;
        }

        /* renamed from: u */
        public R apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.eqy.apply(objArr[0], objArr[1]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 2 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* compiled from: Functions */
    static final class b<T1, T2, T3, R> implements io.reactivex.c.f<Object[], R> {
        final io.reactivex.c.g<T1, T2, T3, R> eqz;

        b(io.reactivex.c.g<T1, T2, T3, R> gVar) {
            this.eqz = gVar;
        }

        /* renamed from: u */
        public R apply(Object[] objArr) {
            if (objArr.length == 3) {
                return this.eqz.b(objArr[0], objArr[1], objArr[2]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 3 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* compiled from: Functions */
    static final class c<T1, T2, T3, T4, R> implements io.reactivex.c.f<Object[], R> {
        final io.reactivex.c.h<T1, T2, T3, T4, R> eqA;

        c(io.reactivex.c.h<T1, T2, T3, T4, R> hVar) {
            this.eqA = hVar;
        }

        /* renamed from: u */
        public R apply(Object[] objArr) {
            if (objArr.length == 4) {
                return this.eqA.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 4 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* compiled from: Functions */
    static final class d<T1, T2, T3, T4, T5, R> implements io.reactivex.c.f<Object[], R> {
        private final io.reactivex.c.i<T1, T2, T3, T4, T5, R> eqB;

        d(io.reactivex.c.i<T1, T2, T3, T4, T5, R> iVar) {
            this.eqB = iVar;
        }

        /* renamed from: u */
        public R apply(Object[] objArr) {
            if (objArr.length == 5) {
                return this.eqB.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 5 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* compiled from: Functions */
    static final class e implements io.reactivex.c.a {
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        e() {
        }
    }

    /* compiled from: Functions */
    static final class f implements io.reactivex.c.e<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        f() {
        }
    }

    /* compiled from: Functions */
    static final class g implements io.reactivex.c.j {
        public void accept(long j) {
        }

        g() {
        }
    }

    /* compiled from: Functions */
    static final class i implements io.reactivex.c.e<Throwable> {
        i() {
        }

        /* renamed from: o */
        public void accept(Throwable th) {
            io.reactivex.d.a.onError(th);
        }
    }

    /* compiled from: Functions */
    static final class j implements io.reactivex.c.k<Object> {
        public boolean test(Object obj) {
            return false;
        }

        j() {
        }
    }

    /* compiled from: Functions */
    static final class k implements io.reactivex.c.a {
        final Future<?> future;

        k(Future<?> future) {
            this.future = future;
        }

        public void run() {
            this.future.get();
        }
    }

    /* compiled from: Functions */
    static final class l implements io.reactivex.c.f<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        l() {
        }
    }

    /* compiled from: Functions */
    static final class m<T, U> implements io.reactivex.c.f<T, U>, Callable<U> {
        final U value;

        m(U u) {
            this.value = u;
        }

        public U call() {
            return this.value;
        }

        public U apply(T t) {
            return this.value;
        }
    }

    /* compiled from: Functions */
    static final class n implements io.reactivex.c.e<org.a.d> {
        n() {
        }

        public void accept(org.a.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions */
    static final class q implements io.reactivex.c.e<Throwable> {
        q() {
        }

        /* renamed from: o */
        public void accept(Throwable th) {
            io.reactivex.d.a.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions */
    static final class r implements io.reactivex.c.k<Object> {
        public boolean test(Object obj) {
            return true;
        }

        r() {
        }
    }

    public static <T1, T2, R> io.reactivex.c.f<Object[], R> b(io.reactivex.c.b<? super T1, ? super T2, ? extends R> bVar) {
        b.requireNonNull(bVar, "f is null");
        return new a(bVar);
    }

    public static <T1, T2, T3, R> io.reactivex.c.f<Object[], R> a(io.reactivex.c.g<T1, T2, T3, R> gVar) {
        b.requireNonNull(gVar, "f is null");
        return new b(gVar);
    }

    public static <T1, T2, T3, T4, R> io.reactivex.c.f<Object[], R> a(io.reactivex.c.h<T1, T2, T3, T4, R> hVar) {
        b.requireNonNull(hVar, "f is null");
        return new c(hVar);
    }

    public static <T1, T2, T3, T4, T5, R> io.reactivex.c.f<Object[], R> a(io.reactivex.c.i<T1, T2, T3, T4, T5, R> iVar) {
        b.requireNonNull(iVar, "f is null");
        return new d(iVar);
    }

    public static <T> io.reactivex.c.f<T, T> aWs() {
        return eqo;
    }

    public static <T> io.reactivex.c.e<T> aWt() {
        return aBk;
    }

    public static io.reactivex.c.a g(Future<?> future) {
        return new k(future);
    }

    public static <T> Callable<T> cd(T t) {
        return new m(t);
    }

    public static <T, U> io.reactivex.c.f<T, U> ce(U u) {
        return new m(u);
    }
}
