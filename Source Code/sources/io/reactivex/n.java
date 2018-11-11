package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.f;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
public abstract class n {
    static final long epY = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler */
    static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable epZ;
        final c eqa;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.epZ = runnable;
            this.eqa = cVar;
        }

        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.epZ.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.eqa instanceof f)) {
                ((f) this.eqa).shutdown();
            } else {
                this.eqa.dispose();
            }
        }

        public boolean isDisposed() {
            return this.eqa.isDisposed();
        }
    }

    /* compiled from: Scheduler */
    static final class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable eqb;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.eqb = runnable;
            this.worker = cVar;
        }

        public void run() {
            if (!this.disposed) {
                try {
                    this.eqb.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.V(th);
                    this.worker.dispose();
                    RuntimeException Z = ExceptionHelper.Z(th);
                }
            }
        }

        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* compiled from: Scheduler */
    public static abstract class c implements io.reactivex.disposables.b {

        /* compiled from: Scheduler */
        final class a implements Runnable {
            long count;
            final Runnable epZ;
            final long eqc;
            long eqd;
            long eqe;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.epZ = runnable;
                this.sd = sequentialDisposable;
                this.eqc = j3;
                this.eqd = j2;
                this.eqe = j;
            }

            public void run() {
                this.epZ.run();
                if (!this.sd.isDisposed()) {
                    long j;
                    long c = c.this.c(TimeUnit.NANOSECONDS);
                    long j2;
                    if (c + n.epY < this.eqd || c >= (this.eqd + this.eqc) + n.epY) {
                        long j3 = c + this.eqc;
                        j2 = this.eqc;
                        long j4 = this.count + 1;
                        this.count = j4;
                        this.eqe = j3 - (j2 * j4);
                        j = j3;
                    } else {
                        j2 = this.eqe;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j2 + (j5 * this.eqc);
                    }
                    this.eqd = c;
                    this.sd.h(c.this.c(this, j - c, TimeUnit.NANOSECONDS));
                }
            }
        }

        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b r(Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            io.reactivex.disposables.b sequentialDisposable = new SequentialDisposable();
            io.reactivex.disposables.b sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable u = io.reactivex.d.a.u(runnable);
            long toNanos = timeUnit2.toNanos(j2);
            long c = c(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b bVar = sequentialDisposable;
            a aVar = r0;
            a aVar2 = new a(c + timeUnit2.toNanos(j3), u, c, sequentialDisposable2, toNanos);
            io.reactivex.disposables.b c2 = c(aVar, j3, timeUnit2);
            if (c2 == EmptyDisposable.INSTANCE) {
                return c2;
            }
            bVar.h(c2);
            return sequentialDisposable2;
        }

        public long c(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract c aWg();

    public void start() {
    }

    public io.reactivex.disposables.b q(Runnable runnable) {
        return b(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c aWg = aWg();
        Object aVar = new a(io.reactivex.d.a.u(runnable), aWg);
        aWg.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b c(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c aWg = aWg();
        io.reactivex.disposables.b bVar = new b(io.reactivex.d.a.u(runnable), aWg);
        io.reactivex.disposables.b d = aWg.d(bVar, j, j2, timeUnit);
        return d == EmptyDisposable.INSTANCE ? d : bVar;
    }
}
