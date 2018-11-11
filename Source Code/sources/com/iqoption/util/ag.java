package com.iqoption.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.Predicates;
import com.google.common.base.j;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.h;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: FutureUtils */
public final class ag {

    /* compiled from: FutureUtils */
    public interface a {
        void n(@NonNull Throwable th);
    }

    /* compiled from: FutureUtils */
    public interface b<T> {
        void d(@NonNull T t, @NonNull Throwable th);
    }

    /* compiled from: FutureUtils */
    public static class d {
        public final long dvC;
        public final long dvE;
        public final long dvN;
        public final String tag;

        public d(long j, long j2, long j3, String str) {
            this.dvC = j;
            this.dvN = j2;
            this.dvE = j3;
            this.tag = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TIMEOUT ");
            stringBuilder.append(this.tag);
            stringBuilder.append(" retry ");
            stringBuilder.append(this.dvC);
            stringBuilder.append('/');
            stringBuilder.append(this.dvN);
            return stringBuilder.toString();
        }
    }

    /* compiled from: FutureUtils */
    public interface e<T> {
        void aU(@NonNull T t);
    }

    /* compiled from: FutureUtils */
    public interface f<T, V> {
        void C(@NonNull T t, @NonNull V v);
    }

    /* compiled from: FutureUtils */
    public static class c<V> implements n<V> {
        private static final String TAG = "com.iqoption.util.ag$c";
        public static final long dvB = TimeUnit.MINUTES.toMillis(10);
        private String bak;
        private long dvC;
        private long dvD;
        private long dvE;
        private int dvF;
        private long dvG;
        private final com.google.common.base.n<s<V>> dvH;
        private final j<V> dvI;
        private final ScheduledExecutorService dvJ;
        private final n<V> dvK;

        /* synthetic */ c(com.google.common.base.n nVar, j jVar, ScheduledExecutorService scheduledExecutorService, n nVar2, AnonymousClass1 anonymousClass1) {
            this(nVar, jVar, scheduledExecutorService, nVar2);
        }

        private c(com.google.common.base.n<s<V>> nVar, j<V> jVar, ScheduledExecutorService scheduledExecutorService, n<V> nVar2) {
            this.dvE = (long) (new Random().nextInt(150) + 50);
            this.dvF = 10;
            this.dvG = dvB;
            this.dvH = nVar;
            this.dvI = jVar;
            this.dvJ = scheduledExecutorService;
            this.dvK = nVar2;
        }

        public void onSuccess(@Nullable V v) {
            try {
                if (this.dvI.apply(v) || !retry()) {
                    this.dvK.onSuccess(v);
                }
            } catch (Throwable e) {
                this.dvK.l(e);
            }
        }

        public void l(Throwable th) {
            if (!retry()) {
                this.dvK.l(th);
            }
        }

        public c<V> gF(int i) {
            this.dvF = i;
            return this;
        }

        public void gG(int i) {
            this.dvE = (long) i;
        }

        public void ci(long j) {
            this.dvG = j;
        }

        public void jL(String str) {
            this.bak = str;
        }

        private boolean retry() {
            if (this.dvC == ((long) this.dvF)) {
                return false;
            }
            Object valueOf;
            this.dvC++;
            long j = this.dvD + this.dvE;
            this.dvD = this.dvE;
            this.dvE = Math.min(j, this.dvG);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TIMEOUT ");
            if (this.bak == null) {
                valueOf = Character.valueOf(' ');
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(' ');
                stringBuilder2.append(this.bak);
                valueOf = stringBuilder2.toString();
            }
            stringBuilder.append(valueOf);
            stringBuilder.append(" retry ");
            stringBuilder.append(this.dvC);
            stringBuilder.append('/');
            stringBuilder.append(this.dvF);
            stringBuilder.append(" with delay:");
            stringBuilder.append(this.dvE);
            i.i(TAG, stringBuilder.toString());
            if (!(this.bak == null || this.bak.contains("api/appsflyer/link"))) {
                IQApp.Dn().aE(new d(this.dvC, (long) this.dvF, this.dvE, this.bak));
            }
            if (this.dvE > 0) {
                this.dvJ.schedule(new Runnable() {
                    public void run() {
                        o.a((s) c.this.dvH.get(), this);
                    }
                }, this.dvE, TimeUnit.MILLISECONDS);
            }
            return true;
        }
    }

    public static <V> void b(s<V> sVar, n<? super V> nVar) {
        o.a(sVar, nVar, com.iqoption.core.d.a.aSe);
    }

    public static <V> void a(s<V> sVar, n<? super V> nVar) {
        o.a(sVar, nVar, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, e<V> eVar, a aVar) {
        a(sVar, eVar, aVar, com.iqoption.core.d.a.aSe);
    }

    public static <V> void b(s<V> sVar, e<V> eVar, a aVar) {
        a(sVar, eVar, aVar, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, Runnable runnable) {
        a((s) sVar, null, null, runnable, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, Runnable runnable, Executor executor) {
        a((s) sVar, null, null, runnable, executor);
    }

    public static <V> void a(s<V> sVar, e<V> eVar, a aVar, Executor executor) {
        a((s) sVar, (e) eVar, aVar, null, executor);
    }

    public static <V> void a(s<V> sVar, final e<V> eVar, final a aVar, final Runnable runnable, Executor executor) {
        o.a(sVar, new n<V>() {
            public void onSuccess(@Nullable V v) {
                if (v != null) {
                    if (eVar != null) {
                        eVar.aU(v);
                    }
                } else if (aVar != null) {
                    aVar.n(new RuntimeException("result is null"));
                }
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void l(@NonNull Throwable th) {
                if (aVar != null) {
                    aVar.n(th);
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, executor);
    }

    public static <T, V> void a(s<V> sVar, T t, final f<T, V> fVar, final b<T> bVar, Executor executor) {
        o.a(sVar, new com.iqoption.system.c.b<T, V>(t) {
            public void z(@NonNull T t, @NonNull V v) {
                super.z(t, v);
                if (fVar != null) {
                    fVar.C(t, v);
                }
            }

            public void c(@NonNull T t, Throwable th) {
                super.c(t, th);
                if (bVar != null) {
                    bVar.d(t, th);
                }
            }
        }, executor);
    }

    public static <V> void a(s<V> sVar, e<V> eVar, Executor executor) {
        a(sVar, eVar, null, executor);
    }

    public static <V> void a(s<V> sVar, e<V> eVar) {
        a(sVar, eVar, null, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, a aVar, Executor executor) {
        a(sVar, null, aVar, executor);
    }

    public static <I, O> s<O> a(s<I> sVar, g<? super I, ? extends O> gVar) {
        return o.b((s) sVar, (g) gVar, MoreExecutors.vV());
    }

    public static <I, O> s<O> a(s<I> sVar, com.google.common.base.d<? super I, ? extends O> dVar) {
        return o.b((s) sVar, (com.google.common.base.d) dVar, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, final String str, final String str2) {
        o.a(sVar, new n<V>() {
            public void onSuccess(@Nullable V v) {
                String str = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("success: ");
                stringBuilder.append(str2);
                stringBuilder.append(". Result: ");
                stringBuilder.append(v);
                i.d(str, stringBuilder.toString());
            }

            public void l(Throwable th) {
                String str = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error: ");
                stringBuilder.append(str2);
                stringBuilder.append(", exception: ");
                stringBuilder.append(th);
                i.e(str, stringBuilder.toString(), th);
            }
        }, MoreExecutors.vV());
    }

    public static <V> boolean j(s<V> sVar) {
        return (sVar == null || sVar.isCancelled() || sVar.isDone()) ? false : true;
    }

    public static <T> s<T> a(T t, long j, TimeUnit timeUnit) {
        return com.iqoption.core.d.a.aSd.a(h.aQ(t), j, timeUnit);
    }

    public static <V> s<V> a(com.google.common.base.n<s<V>> nVar, @Nullable String str) {
        return a(nVar, Predicates.pQ(), com.iqoption.core.d.a.aSd, 10, -1, str);
    }

    public static <V> s<V> a(com.google.common.base.n<s<V>> nVar, j<V> jVar, ScheduledExecutorService scheduledExecutorService, int i, int i2, @Nullable String str) {
        return a(nVar, jVar, scheduledExecutorService, i, i2, c.dvB, str);
    }

    public static <V> s<V> a(com.google.common.base.n<s<V>> nVar, j<V> jVar, ScheduledExecutorService scheduledExecutorService, int i, int i2, long j, @Nullable String str) {
        int i3 = i2;
        final s wb = y.wb();
        s sVar = (s) nVar.get();
        n gF = new c(nVar, jVar, scheduledExecutorService, new n<V>() {
            public void onSuccess(@Nullable V v) {
                wb.P(v);
            }

            public void l(@NonNull Throwable th) {
                wb.h(th);
            }
        }, null).gF(i);
        if (i3 != -1) {
            gF.gG(i3);
        }
        gF.ci(j);
        gF.jL(str);
        o.a(sVar, gF);
        return wb;
    }
}
