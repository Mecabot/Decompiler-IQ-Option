package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.n;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler */
public final class a extends n {
    static final b erT = new b(0, erU);
    static final RxThreadFactory erU = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    static final int erV = aZ(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c erW = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory eny;
    final AtomicReference<b> erX;

    /* compiled from: ComputationScheduler */
    static final class b {
        long erp;
        final int esc;
        final c[] esd;

        b(int i, ThreadFactory threadFactory) {
            this.esc = i;
            this.esd = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.esd[i2] = new c(threadFactory);
            }
        }

        public c aXa() {
            int i = this.esc;
            if (i == 0) {
                return a.erW;
            }
            c[] cVarArr = this.esd;
            long j = this.erp;
            this.erp = j + 1;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void shutdown() {
            for (c dispose : this.esd) {
                dispose.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler */
    static final class a extends io.reactivex.n.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b erY = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a erZ = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b esa = new io.reactivex.internal.disposables.b();
        private final c esb;

        a(c cVar) {
            this.esb = cVar;
            this.esa.e(this.erY);
            this.esa.e(this.erZ);
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.esa.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public io.reactivex.disposables.b r(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.esb.a(runnable, 0, TimeUnit.MILLISECONDS, this.erY);
        }

        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.esb.a(runnable, j, timeUnit, this.erZ);
        }
    }

    /* compiled from: ComputationScheduler */
    static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static int aZ(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        erW.dispose();
        erT.shutdown();
    }

    public a() {
        this(erU);
    }

    public a(ThreadFactory threadFactory) {
        this.eny = threadFactory;
        this.erX = new AtomicReference(erT);
        start();
    }

    public io.reactivex.n.c aWg() {
        return new a(((b) this.erX.get()).aXa());
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return ((b) this.erX.get()).aXa().b(runnable, j, timeUnit);
    }

    public io.reactivex.disposables.b c(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((b) this.erX.get()).aXa().c(runnable, j, j2, timeUnit);
    }

    public void start() {
        b bVar = new b(erV, this.eny);
        if (!this.erX.compareAndSet(erT, bVar)) {
            bVar.shutdown();
        }
    }
}
