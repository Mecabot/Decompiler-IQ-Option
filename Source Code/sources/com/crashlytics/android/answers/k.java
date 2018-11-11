package com.crashlytics.android.answers;

import io.fabric.sdk.android.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BackgroundManager */
class k {
    private final List<a> ln = new ArrayList();
    private final ScheduledExecutorService sk;
    private volatile boolean sl = true;
    final AtomicReference<ScheduledFuture<?>> sm = new AtomicReference();
    boolean sn = true;

    /* compiled from: BackgroundManager */
    public interface a {
        void gy();
    }

    public k(ScheduledExecutorService scheduledExecutorService) {
        this.sk = scheduledExecutorService;
    }

    public void C(boolean z) {
        this.sl = z;
    }

    private void gv() {
        for (a gy : this.ln) {
            gy.gy();
        }
    }

    public void a(a aVar) {
        this.ln.add(aVar);
    }

    public void gw() {
        this.sn = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.sm.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void gx() {
        if (this.sl && !this.sn) {
            this.sn = true;
            try {
                this.sm.compareAndSet(null, this.sk.schedule(new Runnable() {
                    public void run() {
                        k.this.sm.set(null);
                        k.this.gv();
                    }
                }, 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                c.aUg().d("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
