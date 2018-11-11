package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.n;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler */
public final class d extends n {
    static final RxThreadFactory eso;
    static final RxThreadFactory esp;
    private static final TimeUnit esq = TimeUnit.SECONDS;
    static final c esr = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a ess = new a(0, null, eso);
    final ThreadFactory eny;
    final AtomicReference<a> erX;

    /* compiled from: IoScheduler */
    static final class a implements Runnable {
        private final ThreadFactory eny;
        private final long est;
        private final ConcurrentLinkedQueue<c> esu;
        final io.reactivex.disposables.a esv;
        private final ScheduledExecutorService esw;
        private final Future<?> esx;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future scheduleWithFixedDelay;
            this.est = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.esu = new ConcurrentLinkedQueue();
            this.esv = new io.reactivex.disposables.a();
            this.eny = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.esp);
                scheduleWithFixedDelay = scheduledExecutorService.scheduleWithFixedDelay(this, this.est, this.est, TimeUnit.NANOSECONDS);
            } else {
                scheduleWithFixedDelay = null;
            }
            this.esw = scheduledExecutorService;
            this.esx = scheduleWithFixedDelay;
        }

        public void run() {
            aXc();
        }

        c aXb() {
            if (this.esv.isDisposed()) {
                return d.esr;
            }
            while (!this.esu.isEmpty()) {
                c cVar = (c) this.esu.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            Object cVar2 = new c(this.eny);
            this.esv.e(cVar2);
            return cVar2;
        }

        void a(c cVar) {
            cVar.cW(aXd() + this.est);
            this.esu.offer(cVar);
        }

        void aXc() {
            if (!this.esu.isEmpty()) {
                long aXd = aXd();
                Iterator it = this.esu.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.aXe() > aXd) {
                        return;
                    }
                    if (this.esu.remove(cVar)) {
                        this.esv.f(cVar);
                    }
                }
            }
        }

        long aXd() {
            return System.nanoTime();
        }

        void shutdown() {
            this.esv.dispose();
            if (this.esx != null) {
                this.esx.cancel(true);
            }
            if (this.esw != null) {
                this.esw.shutdownNow();
            }
        }
    }

    /* compiled from: IoScheduler */
    static final class b extends io.reactivex.n.c {
        private final io.reactivex.disposables.a esi;
        private final a esy;
        private final c esz;
        final AtomicBoolean once = new AtomicBoolean();

        b(a aVar) {
            this.esy = aVar;
            this.esi = new io.reactivex.disposables.a();
            this.esz = aVar.aXb();
        }

        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.esi.dispose();
                this.esy.a(this.esz);
            }
        }

        public boolean isDisposed() {
            return this.once.get();
        }

        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.esi.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.esz.a(runnable, j, timeUnit, this.esi);
        }
    }

    /* compiled from: IoScheduler */
    static final class c extends f {
        private long esA = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long aXe() {
            return this.esA;
        }

        public void cW(long j) {
            this.esA = j;
        }
    }

    static {
        esr.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        eso = new RxThreadFactory("RxCachedThreadScheduler", max);
        esp = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        ess.shutdown();
    }

    public d() {
        this(eso);
    }

    public d(ThreadFactory threadFactory) {
        this.eny = threadFactory;
        this.erX = new AtomicReference(ess);
        start();
    }

    public void start() {
        a aVar = new a(60, esq, this.eny);
        if (!this.erX.compareAndSet(ess, aVar)) {
            aVar.shutdown();
        }
    }

    public io.reactivex.n.c aWg() {
        return new b((a) this.erX.get());
    }
}
