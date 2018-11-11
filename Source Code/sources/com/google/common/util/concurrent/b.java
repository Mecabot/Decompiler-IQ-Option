package com.google.common.util.concurrent;

import com.google.common.base.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: AbstractFuture */
public abstract class b<V> extends k<V> {
    private static final Object NULL = new Object();
    private static final boolean VR = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final a VS;
    private static final Logger log = Logger.getLogger(b.class.getName());
    private volatile d VT;
    private volatile j VV;
    private volatile Object value;

    /* compiled from: AbstractFuture */
    private static abstract class a {
        abstract void a(j jVar, j jVar2);

        abstract void a(j jVar, Thread thread);

        abstract boolean a(b<?> bVar, d dVar, d dVar2);

        abstract boolean a(b<?> bVar, j jVar, j jVar2);

        abstract boolean a(b<?> bVar, Object obj, Object obj2);

        private a() {
        }
    }

    /* compiled from: AbstractFuture */
    private static final class b {
        static final b VW;
        static final b VX;
        final boolean VY;
        final Throwable cause;

        static {
            if (b.VR) {
                VX = null;
                VW = null;
                return;
            }
            VX = new b(false, null);
            VW = new b(true, null);
        }

        b(boolean z, Throwable th) {
            this.VY = z;
            this.cause = th;
        }
    }

    /* compiled from: AbstractFuture */
    private static final class c {
        static final c VZ = new c(new AbstractFuture$Failure$1("Failure occurred while trying to finish a future."));
        final Throwable Wa;

        c(Throwable th) {
            this.Wa = (Throwable) com.google.common.base.i.checkNotNull(th);
        }
    }

    /* compiled from: AbstractFuture */
    private static final class d {
        static final d Wb = new d(null, null);
        final Runnable Wc;
        d Wd;
        final Executor executor;

        d(Runnable runnable, Executor executor) {
            this.Wc = runnable;
            this.executor = executor;
        }
    }

    /* compiled from: AbstractFuture */
    private static final class f<V> implements Runnable {
        final b<V> Wj;
        final s<? extends V> Wk;

        f(b<V> bVar, s<? extends V> sVar) {
            this.Wj = bVar;
            this.Wk = sVar;
        }

        public void run() {
            if (this.Wj.value == this) {
                if (b.VS.a(this.Wj, (Object) this, b.b(this.Wk))) {
                    b.a(this.Wj);
                }
            }
        }
    }

    /* compiled from: AbstractFuture */
    private static final class j {
        static final j Wq = new j(false);
        volatile Thread Wr;
        volatile j Ws;

        j(boolean z) {
        }

        j() {
            b.VS.a(this, Thread.currentThread());
        }

        void b(j jVar) {
            b.VS.a(this, jVar);
        }

        void vJ() {
            Thread thread = this.Wr;
            if (thread != null) {
                this.Wr = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* compiled from: AbstractFuture */
    private static final class e extends a {
        final AtomicReferenceFieldUpdater<j, Thread> We;
        final AtomicReferenceFieldUpdater<j, j> Wf;
        final AtomicReferenceFieldUpdater<b, j> Wg;
        final AtomicReferenceFieldUpdater<b, d> Wh;
        final AtomicReferenceFieldUpdater<b, Object> Wi;

        e(AtomicReferenceFieldUpdater<j, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<j, j> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, j> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super();
            this.We = atomicReferenceFieldUpdater;
            this.Wf = atomicReferenceFieldUpdater2;
            this.Wg = atomicReferenceFieldUpdater3;
            this.Wh = atomicReferenceFieldUpdater4;
            this.Wi = atomicReferenceFieldUpdater5;
        }

        void a(j jVar, Thread thread) {
            this.We.lazySet(jVar, thread);
        }

        void a(j jVar, j jVar2) {
            this.Wf.lazySet(jVar, jVar2);
        }

        boolean a(b<?> bVar, j jVar, j jVar2) {
            return this.Wg.compareAndSet(bVar, jVar, jVar2);
        }

        boolean a(b<?> bVar, d dVar, d dVar2) {
            return this.Wh.compareAndSet(bVar, dVar, dVar2);
        }

        boolean a(b<?> bVar, Object obj, Object obj2) {
            return this.Wi.compareAndSet(bVar, obj, obj2);
        }
    }

    /* compiled from: AbstractFuture */
    private static final class g extends a {
        private g() {
            super();
        }

        void a(j jVar, Thread thread) {
            jVar.Wr = thread;
        }

        void a(j jVar, j jVar2) {
            jVar.Ws = jVar2;
        }

        boolean a(b<?> bVar, j jVar, j jVar2) {
            synchronized (bVar) {
                if (bVar.VV == jVar) {
                    bVar.VV = jVar2;
                    return true;
                }
                return false;
            }
        }

        boolean a(b<?> bVar, d dVar, d dVar2) {
            synchronized (bVar) {
                if (bVar.VT == dVar) {
                    bVar.VT = dVar2;
                    return true;
                }
                return false;
            }
        }

        boolean a(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (bVar.value == obj) {
                    bVar.value = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* compiled from: AbstractFuture */
    private static final class i extends a {
        static final Unsafe Pm;
        static final long Wl;
        static final long Wm;
        static final long Wn;
        static final long Wo;
        static final long Wp;

        private i() {
            super();
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:3:?, code:
            r0 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.b.i.AnonymousClass1());
     */
        /* JADX WARNING: Missing block: B:5:?, code:
            r1 = com.google.common.util.concurrent.b.class;
            Wm = r0.objectFieldOffset(r1.getDeclaredField("waiters"));
            Wl = r0.objectFieldOffset(r1.getDeclaredField("listeners"));
            Wn = r0.objectFieldOffset(r1.getDeclaredField(com.google.firebase.analytics.FirebaseAnalytics.b.VALUE));
            Wo = r0.objectFieldOffset(com.google.common.util.concurrent.b.j.class.getDeclaredField("Wr"));
            Wp = r0.objectFieldOffset(com.google.common.util.concurrent.b.j.class.getDeclaredField("Ws"));
            Pm = r0;
     */
        /* JADX WARNING: Missing block: B:6:0x0054, code:
            return;
     */
        /* JADX WARNING: Missing block: B:7:0x0055, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:8:0x0056, code:
            com.google.common.base.o.e(r0);
     */
        /* JADX WARNING: Missing block: B:9:0x005e, code:
            throw new java.lang.RuntimeException(r0);
     */
        static {
            /*
            r0 = sun.misc.Unsafe.getUnsafe();	 Catch:{ SecurityException -> 0x0005 }
            goto L_0x0010;
        L_0x0005:
            r0 = new com.google.common.util.concurrent.b$i$1;	 Catch:{ PrivilegedActionException -> 0x005f }
            r0.<init>();	 Catch:{ PrivilegedActionException -> 0x005f }
            r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ PrivilegedActionException -> 0x005f }
            r0 = (sun.misc.Unsafe) r0;	 Catch:{ PrivilegedActionException -> 0x005f }
        L_0x0010:
            r1 = com.google.common.util.concurrent.b.class;
            r2 = "waiters";
            r2 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r2 = r0.objectFieldOffset(r2);	 Catch:{ Exception -> 0x0055 }
            Wm = r2;	 Catch:{ Exception -> 0x0055 }
            r2 = "listeners";
            r2 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r2 = r0.objectFieldOffset(r2);	 Catch:{ Exception -> 0x0055 }
            Wl = r2;	 Catch:{ Exception -> 0x0055 }
            r2 = "value";
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            Wn = r1;	 Catch:{ Exception -> 0x0055 }
            r1 = com.google.common.util.concurrent.b.j.class;
            r2 = "Wr";
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            Wo = r1;	 Catch:{ Exception -> 0x0055 }
            r1 = com.google.common.util.concurrent.b.j.class;
            r2 = "Ws";
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            Wp = r1;	 Catch:{ Exception -> 0x0055 }
            Pm = r0;	 Catch:{ Exception -> 0x0055 }
            return;
        L_0x0055:
            r0 = move-exception;
            com.google.common.base.o.e(r0);
            r1 = new java.lang.RuntimeException;
            r1.<init>(r0);
            throw r1;
        L_0x005f:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "Could not initialize intrinsics";
            r0 = r0.getCause();
            r1.<init>(r2, r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.b.i.<clinit>():void");
        }

        void a(j jVar, Thread thread) {
            Pm.putObject(jVar, Wo, thread);
        }

        void a(j jVar, j jVar2) {
            Pm.putObject(jVar, Wp, jVar2);
        }

        boolean a(b<?> bVar, j jVar, j jVar2) {
            return Pm.compareAndSwapObject(bVar, Wm, jVar, jVar2);
        }

        boolean a(b<?> bVar, d dVar, d dVar2) {
            return Pm.compareAndSwapObject(bVar, Wl, dVar, dVar2);
        }

        boolean a(b<?> bVar, Object obj, Object obj2) {
            return Pm.compareAndSwapObject(bVar, Wn, obj, obj2);
        }
    }

    /* compiled from: AbstractFuture */
    static abstract class h<V> extends b<V> {
        h() {
        }

        public final V get() {
            return super.get();
        }

        public final V get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }

        public final boolean isDone() {
            return super.isDone();
        }

        public final boolean isCancelled() {
            return super.isCancelled();
        }

        public final void a(Runnable runnable, Executor executor) {
            super.a(runnable, executor);
        }

        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    protected void vC() {
    }

    protected void vD() {
    }

    static {
        a iVar;
        Throwable th;
        Throwable th2 = null;
        try {
            iVar = new i();
            th = null;
        } catch (Throwable th3) {
            th2 = th3;
            th3 = th;
            iVar = new g();
        }
        VS = iVar;
        Class cls = LockSupport.class;
        if (th2 != null) {
            log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th3);
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    private void a(j jVar) {
        jVar.Wr = null;
        while (true) {
            jVar = this.VV;
            if (jVar != j.Wq) {
                j jVar2 = null;
                while (jVar != null) {
                    j jVar3 = jVar.Ws;
                    if (jVar.Wr != null) {
                        jVar2 = jVar;
                    } else if (jVar2 != null) {
                        jVar2.Ws = jVar3;
                        if (jVar2.Wr == null) {
                        }
                    } else if (VS.a(this, jVar, jVar3)) {
                    }
                    jVar = jVar3;
                }
                return;
            }
            return;
        }
    }

    protected b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0  */
    public V get(long r18, java.util.concurrent.TimeUnit r20) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r3 = r20;
        r4 = r3.toNanos(r1);
        r6 = java.lang.Thread.interrupted();
        if (r6 == 0) goto L_0x0016;
    L_0x0010:
        r1 = new java.lang.InterruptedException;
        r1.<init>();
        throw r1;
    L_0x0016:
        r6 = r0.value;
        r8 = 1;
        if (r6 == 0) goto L_0x001d;
    L_0x001b:
        r9 = 1;
        goto L_0x001e;
    L_0x001d:
        r9 = 0;
    L_0x001e:
        r10 = r6 instanceof com.google.common.util.concurrent.b.f;
        if (r10 != 0) goto L_0x0024;
    L_0x0022:
        r10 = 1;
        goto L_0x0025;
    L_0x0024:
        r10 = 0;
    L_0x0025:
        r9 = r9 & r10;
        if (r9 == 0) goto L_0x002d;
    L_0x0028:
        r1 = r0.aO(r6);
        return r1;
    L_0x002d:
        r9 = 0;
        r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r6 <= 0) goto L_0x003a;
    L_0x0033:
        r11 = java.lang.System.nanoTime();
        r13 = r11 + r4;
        goto L_0x003b;
    L_0x003a:
        r13 = r9;
    L_0x003b:
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r6 < 0) goto L_0x009c;
    L_0x0041:
        r6 = r0.VV;
        r15 = com.google.common.util.concurrent.b.j.Wq;
        if (r6 == r15) goto L_0x0095;
    L_0x0047:
        r15 = new com.google.common.util.concurrent.b$j;
        r15.<init>();
    L_0x004c:
        r15.b(r6);
        r7 = VS;
        r6 = r7.a(r0, r6, r15);
        if (r6 == 0) goto L_0x008f;
    L_0x0057:
        java.util.concurrent.locks.LockSupport.parkNanos(r0, r4);
        r4 = java.lang.Thread.interrupted();
        if (r4 == 0) goto L_0x0069;
    L_0x0060:
        r0.a(r15);
        r1 = new java.lang.InterruptedException;
        r1.<init>();
        throw r1;
    L_0x0069:
        r4 = r0.value;
        if (r4 == 0) goto L_0x006f;
    L_0x006d:
        r5 = 1;
        goto L_0x0070;
    L_0x006f:
        r5 = 0;
    L_0x0070:
        r6 = r4 instanceof com.google.common.util.concurrent.b.f;
        if (r6 != 0) goto L_0x0076;
    L_0x0074:
        r6 = 1;
        goto L_0x0077;
    L_0x0076:
        r6 = 0;
    L_0x0077:
        r5 = r5 & r6;
        if (r5 == 0) goto L_0x007f;
    L_0x007a:
        r1 = r0.aO(r4);
        return r1;
    L_0x007f:
        r4 = java.lang.System.nanoTime();
        r6 = r13 - r4;
        r4 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r4 >= 0) goto L_0x008d;
    L_0x0089:
        r0.a(r15);
        goto L_0x00c8;
    L_0x008d:
        r4 = r6;
        goto L_0x0057;
    L_0x008f:
        r6 = r0.VV;
        r7 = com.google.common.util.concurrent.b.j.Wq;
        if (r6 != r7) goto L_0x004c;
    L_0x0095:
        r1 = r0.value;
        r1 = r0.aO(r1);
        return r1;
    L_0x009c:
        r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r6 <= 0) goto L_0x00ca;
    L_0x00a0:
        r4 = r0.value;
        if (r4 == 0) goto L_0x00a6;
    L_0x00a4:
        r5 = 1;
        goto L_0x00a7;
    L_0x00a6:
        r5 = 0;
    L_0x00a7:
        r6 = r4 instanceof com.google.common.util.concurrent.b.f;
        if (r6 != 0) goto L_0x00ad;
    L_0x00ab:
        r6 = 1;
        goto L_0x00ae;
    L_0x00ad:
        r6 = 0;
    L_0x00ae:
        r5 = r5 & r6;
        if (r5 == 0) goto L_0x00b6;
    L_0x00b1:
        r1 = r0.aO(r4);
        return r1;
    L_0x00b6:
        r4 = java.lang.Thread.interrupted();
        if (r4 == 0) goto L_0x00c2;
    L_0x00bc:
        r1 = new java.lang.InterruptedException;
        r1.<init>();
        throw r1;
    L_0x00c2:
        r4 = java.lang.System.nanoTime();
        r6 = r13 - r4;
    L_0x00c8:
        r4 = r6;
        goto L_0x009c;
    L_0x00ca:
        r4 = r17.toString();
        r5 = r17.isDone();
        if (r5 == 0) goto L_0x0100;
    L_0x00d4:
        r4 = new java.util.concurrent.TimeoutException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Waited ";
        r5.append(r6);
        r5.append(r1);
        r1 = " ";
        r5.append(r1);
        r1 = r20.toString();
        r1 = com.google.common.base.a.toLowerCase(r1);
        r5.append(r1);
        r1 = " but future completed as timeout expired";
        r5.append(r1);
        r1 = r5.toString();
        r4.<init>(r1);
        throw r4;
    L_0x0100:
        r5 = new java.util.concurrent.TimeoutException;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Waited ";
        r6.append(r7);
        r6.append(r1);
        r1 = " ";
        r6.append(r1);
        r1 = r20.toString();
        r1 = com.google.common.base.a.toLowerCase(r1);
        r6.append(r1);
        r1 = " for ";
        r6.append(r1);
        r6.append(r4);
        r1 = r6.toString();
        r5.<init>(r1);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.b.get(long, java.util.concurrent.TimeUnit):V");
    }

    public V get() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if (((obj != null ? 1 : 0) & (!(obj instanceof f) ? 1 : 0)) != 0) {
            return aO(obj);
        }
        j jVar = this.VV;
        if (jVar != j.Wq) {
            j jVar2 = new j();
            do {
                jVar2.b(jVar);
                if (VS.a(this, jVar, jVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(jVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (((obj != null ? 1 : 0) & (!(obj instanceof f) ? 1 : 0)) == 0);
                    return aO(obj);
                }
                jVar = this.VV;
            } while (jVar != j.Wq);
        }
        return aO(this.value);
    }

    private V aO(Object obj) {
        if (obj instanceof b) {
            throw c("Task was cancelled.", ((b) obj).cause);
        } else if (!(obj instanceof c)) {
            return obj == NULL ? null : obj;
        } else {
            throw new ExecutionException(((c) obj).Wa);
        }
    }

    public boolean isDone() {
        Object obj = this.value;
        int i = 0;
        int i2 = obj != null ? 1 : 0;
        if (!(obj instanceof f)) {
            i = 1;
        }
        return i2 & i;
    }

    public boolean isCancelled() {
        return this.value instanceof b;
    }

    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (((obj == null ? 1 : 0) | (obj instanceof f)) == 0) {
            return false;
        }
        Object bVar = VR ? new b(z, new CancellationException("Future.cancel() was called.")) : z ? b.VW : b.VX;
        Object obj2 = obj;
        boolean z2 = false;
        b bVar2 = this;
        while (true) {
            if (VS.a(bVar2, obj2, bVar)) {
                if (z) {
                    bVar2.vD();
                }
                a(bVar2);
                if (!(obj2 instanceof f)) {
                    return true;
                }
                s sVar = ((f) obj2).Wk;
                if (sVar instanceof h) {
                    bVar2 = (b) sVar;
                    obj2 = bVar2.value;
                    if (((obj2 == null ? 1 : 0) | (obj2 instanceof f)) == 0) {
                        return true;
                    }
                    z2 = true;
                } else {
                    sVar.cancel(z);
                    return true;
                }
            }
            obj2 = bVar2.value;
            if (!(obj2 instanceof f)) {
                return z2;
            }
        }
    }

    protected final boolean vE() {
        Object obj = this.value;
        return (obj instanceof b) && ((b) obj).VY;
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.i.checkNotNull(runnable, "Runnable was null.");
        com.google.common.base.i.checkNotNull(executor, "Executor was null.");
        d dVar = this.VT;
        if (dVar != d.Wb) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.Wd = dVar;
                if (!VS.a(this, dVar, dVar2)) {
                    dVar = this.VT;
                } else {
                    return;
                }
            } while (dVar != d.Wb);
        }
        b(runnable, executor);
    }

    /* renamed from: P */
    protected boolean a(V v) {
        Object v2;
        if (v2 == null) {
            v2 = NULL;
        }
        if (!VS.a(this, null, v2)) {
            return false;
        }
        a(this);
        return true;
    }

    /* renamed from: h */
    protected boolean a(Throwable th) {
        if (!VS.a(this, null, new c((Throwable) com.google.common.base.i.checkNotNull(th)))) {
            return false;
        }
        a(this);
        return true;
    }

    protected boolean a(s<? extends V> sVar) {
        Object cVar;
        com.google.common.base.i.checkNotNull(sVar);
        Object obj = this.value;
        if (obj == null) {
            if (sVar.isDone()) {
                if (!VS.a(this, null, b((s) sVar))) {
                    return false;
                }
                a(this);
                return true;
            }
            obj = new f(this, sVar);
            if (VS.a(this, null, obj)) {
                try {
                    sVar.a(obj, MoreExecutors.vV());
                } catch (Throwable unused) {
                    cVar = c.VZ;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof b) {
            sVar.cancel(((b) obj).VY);
        }
        return false;
        VS.a(this, obj, cVar);
        return true;
    }

    private static Object b(s<?> sVar) {
        Object obj;
        if (sVar instanceof h) {
            obj = ((b) sVar).value;
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.VY) {
                    obj = bVar.cause != null ? new b(false, bVar.cause) : b.VX;
                }
            }
            return obj;
        }
        Object obj2;
        try {
            obj = o.b((Future) sVar);
            if (obj == null) {
                obj = NULL;
            }
            obj2 = obj;
        } catch (ExecutionException e) {
            obj2 = new c(e.getCause());
        } catch (Throwable e2) {
            obj2 = new b(false, e2);
        } catch (Throwable e22) {
            obj2 = new c(e22);
        }
        return obj2;
    }

    private static void a(b<?> bVar) {
        d dVar = null;
        while (true) {
            b bVar2;
            bVar2.vG();
            bVar2.vC();
            d a = bVar2.a(dVar);
            while (a != null) {
                dVar = a.Wd;
                Runnable runnable = a.Wc;
                if (runnable instanceof f) {
                    Object obj = (f) runnable;
                    bVar2 = obj.Wj;
                    if (bVar2.value == obj) {
                        if (VS.a(bVar2, obj, b(obj.Wk))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    b(runnable, a.executor);
                }
                a = dVar;
            }
            return;
        }
    }

    final Throwable vF() {
        return ((c) this.value).Wa;
    }

    final void a(Future<?> future) {
        if (((future != null ? 1 : 0) & isCancelled()) != 0) {
            future.cancel(vE());
        }
    }

    private void vG() {
        j jVar;
        do {
            jVar = this.VV;
        } while (!VS.a(this, jVar, j.Wq));
        while (jVar != null) {
            jVar.vJ();
            jVar = jVar.Ws;
        }
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.VT;
        } while (!VS.a(this, dVar2, d.Wb));
        d dVar3 = dVar2;
        dVar2 = dVar;
        dVar = dVar3;
        while (dVar != null) {
            d dVar4 = dVar.Wd;
            dVar.Wd = dVar2;
            dVar2 = dVar;
            dVar = dVar4;
        }
        return dVar2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=");
        if (isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else if (isDone()) {
            j(stringBuilder);
        } else {
            String vB;
            try {
                vB = vB();
            } catch (RuntimeException e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Exception thrown from implementation: ");
                stringBuilder2.append(e.getClass());
                vB = stringBuilder2.toString();
            }
            if (!m.bc(vB)) {
                stringBuilder.append("PENDING, info=[");
                stringBuilder.append(vB);
                stringBuilder.append("]");
            } else if (isDone()) {
                j(stringBuilder);
            } else {
                stringBuilder.append("PENDING");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected String vB() {
        Object obj = this.value;
        if (obj instanceof f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setFuture=[");
            stringBuilder.append(((f) obj).Wk);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("remaining delay=[");
            stringBuilder2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            stringBuilder2.append(" ms]");
            return stringBuilder2.toString();
        }
    }

    private void j(StringBuilder stringBuilder) {
        try {
            Object b = o.b((Future) this);
            stringBuilder.append("SUCCESS, result=[");
            stringBuilder.append(b);
            stringBuilder.append("]");
        } catch (ExecutionException e) {
            stringBuilder.append("FAILURE, cause=[");
            stringBuilder.append(e.getCause());
            stringBuilder.append("]");
        } catch (CancellationException unused) {
            stringBuilder.append("CANCELLED");
        } catch (RuntimeException e2) {
            stringBuilder.append("UNKNOWN, cause=[");
            stringBuilder.append(e2.getClass());
            stringBuilder.append(" thrown from get()]");
        }
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RuntimeException while executing runnable ");
            stringBuilder.append(runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            logger.log(level, stringBuilder.toString(), e);
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
