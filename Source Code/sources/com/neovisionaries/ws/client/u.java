package com.neovisionaries.ws.client;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: PeriodicalFrameSender */
abstract class u {
    private final af dpy;
    private final String eaa;
    private Timer eab;
    private boolean eac;
    private long ead;
    private r eae;

    /* compiled from: PeriodicalFrameSender */
    private final class a extends TimerTask {
        private a() {
        }

        public void run() {
            u.this.aQp();
        }
    }

    protected abstract aj A(byte[] bArr);

    public u(af afVar, String str, r rVar) {
        this.dpy = afVar;
        this.eaa = str;
        this.eae = rVar;
    }

    public void start() {
        setInterval(getInterval());
    }

    public void stop() {
        synchronized (this) {
            if (this.eab == null) {
                return;
            }
            this.eac = false;
            this.eab.cancel();
        }
    }

    public long getInterval() {
        long j;
        synchronized (this) {
            j = this.ead;
        }
        return j;
    }

    public void setInterval(long j) {
        if (j < 0) {
            j = 0;
        }
        synchronized (this) {
            this.ead = j;
        }
        if (j != 0 && this.dpy.isOpen()) {
            synchronized (this) {
                if (this.eab == null) {
                    this.eab = new Timer(this.eaa);
                }
                if (!this.eac) {
                    this.eac = a(this.eab, new a(), j);
                }
            }
        }
    }

    private void aQp() {
        synchronized (this) {
            if (this.ead == 0 || !this.dpy.isOpen()) {
                this.eac = false;
                return;
            }
            this.dpy.C(aQq());
            this.eac = a(this.eab, new a(), this.ead);
        }
    }

    private aj aQq() {
        return A(aQr());
    }

    private byte[] aQr() {
        if (this.eae == null) {
            return null;
        }
        try {
            return this.eae.aQe();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a(Timer timer, a aVar, long j) {
        try {
            timer.schedule(aVar, j);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
