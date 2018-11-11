package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.a.a;
import java.util.Random;

/* compiled from: RandomBackoff */
class u implements a {
    final Random random;
    final a sH;
    final double sI;

    public u(a aVar, double d) {
        this(aVar, d, new Random());
    }

    public u(a aVar, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.sH = aVar;
            this.sI = d;
            this.random = random;
        }
    }

    public long r(int i) {
        return (long) (gH() * ((double) this.sH.r(i)));
    }

    double gH() {
        double d = 1.0d - this.sI;
        return d + (((this.sI + 1.0d) - d) * this.random.nextDouble());
    }
}
