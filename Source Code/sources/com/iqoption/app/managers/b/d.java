package com.iqoption.app.managers.b;

import com.iqoption.core.data.model.InstrumentType;
import java.util.Objects;

/* compiled from: MarkupSpreadCalculator */
public class d {
    private final int activeId;
    private final double aoV;
    private final double aoW;
    private final InstrumentType instrumentType;
    private final int leverage;
    private final int precision;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!(Double.compare(dVar.aoV, this.aoV) == 0 && Double.compare(dVar.aoW, this.aoW) == 0 && this.leverage == dVar.leverage && this.activeId == dVar.activeId && this.precision == dVar.precision && this.instrumentType == dVar.instrumentType)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Double.valueOf(this.aoV), Double.valueOf(this.aoW), Integer.valueOf(this.leverage), this.instrumentType, Integer.valueOf(this.activeId), Integer.valueOf(this.precision)});
    }

    public static double a(double d, double d2, int i, InstrumentType instrumentType, int i2, int i3) {
        double a = b.aoQ.a(instrumentType, (long) i2, i);
        if (a == 0.0d) {
            return (d / d2) * 100.0d;
        }
        d += (a * d2) / 100.0d;
        if (d < 0.0d) {
            return 0.0d;
        }
        a = Math.pow(10.0d, (double) Math.max(0, i3 - 1));
        return ((((double) Math.round(d * a)) / a) / d2) * 100.0d;
    }
}
