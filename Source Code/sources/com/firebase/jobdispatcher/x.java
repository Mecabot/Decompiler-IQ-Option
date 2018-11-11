package com.firebase.jobdispatcher;

import com.iqoption.dto.ChartTimeInterval;

/* compiled from: RetryStrategy */
public final class x {
    public static final x KK = new x(1, 30, ChartTimeInterval.CANDLE_1H);
    public static final x KL = new x(2, 30, ChartTimeInterval.CANDLE_1H);
    private final int KO;
    private final int KQ;
    private final int KS;

    /* compiled from: RetryStrategy */
    static final class a {
        private final ValidationEnforcer JN;

        public x f(int i, int i2, int i3) {
            x xVar = new x(i, i2, i3);
            this.JN.d(xVar);
            return xVar;
        }
    }

    x(int i, int i2, int i3) {
        this.KO = i;
        this.KQ = i2;
        this.KS = i3;
    }

    public int oU() {
        return this.KO;
    }

    public int oV() {
        return this.KQ;
    }

    public int oW() {
        return this.KS;
    }
}
