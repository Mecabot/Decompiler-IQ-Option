package com.iqoption.app.managers.b;

import android.os.SystemClock;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import java.util.Objects;

/* compiled from: MarkupCalculator */
public class a {
    private final int activeId;
    private boolean aoH;
    private double aoI;
    private double aoJ;
    private double aoK;
    private double aoL;
    private double aoM;
    private InstrumentType instrumentType;
    private int leverage;
    private final int precision;

    public a(int i, int i2) {
        this.activeId = i;
        this.precision = i2;
    }

    public void b(int i, InstrumentType instrumentType) {
        this.leverage = i;
        this.instrumentType = instrumentType;
        this.aoH = false;
    }

    public double c(double d, double d2) {
        if (!this.aoH && e(d, d2)) {
            Ii();
        }
        return this.aoK;
    }

    public double d(double d, double d2) {
        if (!this.aoH && e(d, d2)) {
            Ii();
        }
        return this.aoL;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public int getLeverage() {
        return this.leverage;
    }

    public void reset() {
        this.aoH = false;
    }

    private boolean e(double d, double d2) {
        double a = b.aoQ.a(this.instrumentType, (long) this.activeId, this.leverage);
        if (Double.compare(this.aoI, d) == 0 && Double.compare(this.aoJ, d2) == 0 && Double.compare(this.aoM, a) == 0) {
            return false;
        }
        this.aoI = d;
        this.aoJ = d2;
        this.aoM = a;
        return true;
    }

    private void Ii() {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (this.aoM == 0.0d) {
            this.aoK = this.aoI;
            this.aoL = this.aoJ;
            return;
        }
        double d = (this.aoI + this.aoJ) / 2.0d;
        double d2 = (this.aoM * d) / 200.0d;
        double d3 = this.aoI - d2;
        d2 += this.aoJ;
        if (d3 > d2) {
            d2 = d;
        } else {
            d = d3;
        }
        d3 = Math.pow(10.0d, (double) Math.max(0, this.precision - 1));
        this.aoK = Math.floor((d * d3) + 1.0E-6d) / d3;
        this.aoL = Math.ceil((d2 * d3) - 1.0E-6d) / d3;
        this.aoH = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("testmarup 2 = ");
        stringBuilder.append(SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos);
        i.d(stringBuilder.toString());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!(Double.compare(aVar.aoI, this.aoI) == 0 && Double.compare(aVar.aoJ, this.aoJ) == 0 && this.leverage == aVar.leverage && this.activeId == aVar.activeId && this.instrumentType == aVar.instrumentType)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Double.valueOf(this.aoI), Double.valueOf(this.aoJ), Integer.valueOf(this.leverage), this.instrumentType, Integer.valueOf(this.activeId)});
    }
}
