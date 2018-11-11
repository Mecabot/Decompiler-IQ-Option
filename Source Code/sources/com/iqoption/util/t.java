package com.iqoption.util;

import com.iqoption.core.d.a;

/* compiled from: DelayedCommand */
public final class t {
    private final Runnable dvd;
    private boolean dve;

    public t(Runnable runnable) {
        this.dvd = new u(this, runnable);
    }

    final /* synthetic */ void l(Runnable runnable) {
        this.dve = false;
        runnable.run();
    }

    public void ch(long j) {
        if (!this.dve) {
            a.aSe.postDelayed(this.dvd, j);
            this.dve = true;
        }
    }

    public void cancel() {
        if (this.dve) {
            a.aSe.removeCallbacks(this.dvd);
            this.dve = false;
        }
    }

    public void execute() {
        this.dvd.run();
    }
}
