package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.n;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler */
public final class j extends n {
    private static final j esO = new j();

    /* compiled from: TrampolineScheduler */
    static final class a implements Runnable {
        private final Runnable eqb;
        private final c esP;
        private final long esQ;

        a(Runnable runnable, c cVar, long j) {
            this.eqb = runnable;
            this.esP = cVar;
            this.esQ = j;
        }

        public void run() {
            if (!this.esP.disposed) {
                long c = this.esP.c(TimeUnit.MILLISECONDS);
                if (this.esQ > c) {
                    try {
                        Thread.sleep(this.esQ - c);
                    } catch (Throwable e) {
                        Thread.currentThread().interrupt();
                        io.reactivex.d.a.onError(e);
                        return;
                    }
                }
                if (!this.esP.disposed) {
                    this.eqb.run();
                }
            }
        }
    }

    /* compiled from: TrampolineScheduler */
    static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable eqb;
        final long esQ;

        b(Runnable runnable, Long l, int i) {
            this.eqb = runnable;
            this.esQ = l.longValue();
            this.count = i;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int compare = io.reactivex.internal.a.b.compare(this.esQ, bVar.esQ);
            return compare == 0 ? io.reactivex.internal.a.b.compare(this.count, bVar.count) : compare;
        }
    }

    /* compiled from: TrampolineScheduler */
    static final class c extends io.reactivex.n.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> esR = new PriorityBlockingQueue();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger xR = new AtomicInteger();

        /* compiled from: TrampolineScheduler */
        final class a implements Runnable {
            final b esS;

            a(b bVar) {
                this.esS = bVar;
            }

            public void run() {
                this.esS.disposed = true;
                c.this.esR.remove(this.esS);
            }
        }

        c() {
        }

        public io.reactivex.disposables.b r(Runnable runnable) {
            return c(runnable, c(TimeUnit.MILLISECONDS));
        }

        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long c = c(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return c(new a(runnable, this, c), c);
        }

        io.reactivex.disposables.b c(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.xR.incrementAndGet());
            this.esR.add(bVar);
            if (this.wip.getAndIncrement() != 0) {
                return io.reactivex.disposables.c.s(new a(bVar));
            }
            int i = 1;
            while (!this.disposed) {
                b bVar2 = (b) this.esR.poll();
                if (bVar2 == null) {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!bVar2.disposed) {
                    bVar2.eqb.run();
                }
            }
            this.esR.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static j aXf() {
        return esO;
    }

    public io.reactivex.n.c aWg() {
        return new c();
    }

    j() {
    }

    public io.reactivex.disposables.b q(Runnable runnable) {
        io.reactivex.d.a.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.d.a.u(runnable).run();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            io.reactivex.d.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
