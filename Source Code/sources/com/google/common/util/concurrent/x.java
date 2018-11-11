package com.google.common.util.concurrent;

import com.google.common.base.i;
import com.google.common.base.l;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: RateLimiter */
public abstract class x {
    private final a Xa;
    private volatile Object Xb;

    /* compiled from: RateLimiter */
    static abstract class a {
        protected abstract void K(long j);

        protected abstract long vZ();

        protected a() {
        }

        public static final a wa() {
            return new a() {
                final l OL = l.pX();

                protected long vZ() {
                    return this.OL.a(TimeUnit.MICROSECONDS);
                }

                protected void K(long j) {
                    if (j > 0) {
                        ab.c(j, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }
    }

    abstract long J(long j);

    abstract void a(double d, long j);

    abstract long d(int i, long j);

    abstract double vX();

    public static x d(double d) {
        return a(d, a.wa());
    }

    static x a(double d, a aVar) {
        x aVar2 = new a(aVar, 1.0d);
        aVar2.setRate(d);
        return aVar2;
    }

    public static x a(double d, long j, TimeUnit timeUnit) {
        i.a(j >= 0, "warmupPeriod must not be negative: %s", j);
        return a(d, j, timeUnit, 3.0d, a.wa());
    }

    static x a(double d, long j, TimeUnit timeUnit, double d2, a aVar) {
        x bVar = new b(aVar, j, timeUnit, d2);
        bVar.setRate(d);
        return bVar;
    }

    private Object vW() {
        Object obj = this.Xb;
        if (obj == null) {
            synchronized (this) {
                obj = this.Xb;
                if (obj == null) {
                    obj = new Object();
                    this.Xb = obj;
                }
            }
        }
        return obj;
    }

    x(a aVar) {
        this.Xa = (a) i.checkNotNull(aVar);
    }

    public final void setRate(double d) {
        boolean z = d > 0.0d && !Double.isNaN(d);
        i.checkArgument(z, "rate must be positive");
        synchronized (vW()) {
            a(d, this.Xa.vZ());
        }
    }

    public final double getRate() {
        double vX;
        synchronized (vW()) {
            vX = vX();
        }
        return vX;
    }

    public double vY() {
        return by(1);
    }

    public double by(int i) {
        long bz = bz(i);
        this.Xa.K(bz);
        return (((double) bz) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    final long bz(int i) {
        long c;
        bA(i);
        synchronized (vW()) {
            c = c(i, this.Xa.vZ());
        }
        return c;
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
        j = Math.max(timeUnit.toMicros(j), 0);
        bA(i);
        synchronized (vW()) {
            long vZ = this.Xa.vZ();
            if (h(vZ, j)) {
                long c = c(i, vZ);
                this.Xa.K(c);
                return true;
            }
            return false;
        }
    }

    private boolean h(long j, long j2) {
        return J(j) - j2 <= j;
    }

    final long c(int i, long j) {
        return Math.max(d(i, j) - j, 0);
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    private static void bA(int i) {
        i.a(i > 0, "Requested permits (%s) must be positive", i);
    }
}
