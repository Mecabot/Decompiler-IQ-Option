package com.google.common.util.concurrent;

import com.google.common.c.c;
import java.util.concurrent.TimeUnit;

/* compiled from: SmoothRateLimiter */
abstract class z extends x {
    double Xc;
    double Xd;
    double Xe;
    private long Xf;

    /* compiled from: SmoothRateLimiter */
    static final class a extends z {
        final double Xg;

        long b(double d, double d2) {
            return 0;
        }

        a(a aVar, double d) {
            super(aVar);
            this.Xg = d;
        }

        void a(double d, double d2) {
            d2 = this.Xd;
            this.Xd = this.Xg * d;
            if (d2 == Double.POSITIVE_INFINITY) {
                this.Xc = this.Xd;
                return;
            }
            d = 0.0d;
            if (d2 != 0.0d) {
                d = (this.Xc * this.Xd) / d2;
            }
            this.Xc = d;
        }

        double wc() {
            return this.Xe;
        }
    }

    /* compiled from: SmoothRateLimiter */
    static final class b extends z {
        private final long Xh;
        private double Xi;
        private double Xj;
        private double Xk;

        b(a aVar, long j, TimeUnit timeUnit, double d) {
            super(aVar);
            this.Xh = timeUnit.toMicros(j);
            this.Xk = d;
        }

        void a(double d, double d2) {
            d = this.Xd;
            double d3 = this.Xk * d2;
            this.Xj = (((double) this.Xh) * 0.5d) / d2;
            this.Xd = this.Xj + ((((double) this.Xh) * 2.0d) / (d2 + d3));
            this.Xi = (d3 - d2) / (this.Xd - this.Xj);
            if (d == Double.POSITIVE_INFINITY) {
                this.Xc = 0.0d;
            } else {
                this.Xc = d == 0.0d ? this.Xd : (this.Xc * this.Xd) / d;
            }
        }

        long b(double d, double d2) {
            long e;
            d -= this.Xj;
            if (d > 0.0d) {
                double min = Math.min(d, d2);
                e = (long) (((e(d) + e(d - min)) * min) / 2.0d);
                d2 -= min;
            } else {
                e = 0;
            }
            return e + ((long) (this.Xe * d2));
        }

        private double e(double d) {
            return this.Xe + (d * this.Xi);
        }

        double wc() {
            return ((double) this.Xh) / this.Xd;
        }
    }

    abstract void a(double d, double d2);

    abstract long b(double d, double d2);

    abstract double wc();

    private z(a aVar) {
        super(aVar);
        this.Xf = 0;
    }

    final void a(double d, long j) {
        L(j);
        double toMicros = ((double) TimeUnit.SECONDS.toMicros(1)) / d;
        this.Xe = toMicros;
        a(d, toMicros);
    }

    final double vX() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.Xe;
    }

    final long J(long j) {
        return this.Xf;
    }

    final long d(int i, long j) {
        L(j);
        j = this.Xf;
        double d = (double) i;
        double min = Math.min(d, this.Xc);
        this.Xf = c.g(this.Xf, b(this.Xc, min) + ((long) ((d - min) * this.Xe)));
        this.Xc -= min;
        return j;
    }

    void L(long j) {
        if (j > this.Xf) {
            this.Xc = Math.min(this.Xd, this.Xc + (((double) (j - this.Xf)) / wc()));
            this.Xf = j;
        }
    }
}
