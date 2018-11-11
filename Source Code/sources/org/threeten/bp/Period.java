package org.threeten.bp;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.c;

public final class Period extends c implements Serializable {
    private static final Pattern fdA = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    public static final Period fdW = new Period(0, 0, 0);
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    private Period(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    private Object readResolve() {
        return ((this.years | this.months) | this.days) == 0 ? fdW : this;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        if (!(this.years == period.years && this.months == period.months && this.days == period.days)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.years + Integer.rotateLeft(this.months, 8)) + Integer.rotateLeft(this.days, 16);
    }

    public String toString() {
        if (this == fdW) {
            return "P0D";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('P');
        if (this.years != 0) {
            stringBuilder.append(this.years);
            stringBuilder.append('Y');
        }
        if (this.months != 0) {
            stringBuilder.append(this.months);
            stringBuilder.append('M');
        }
        if (this.days != 0) {
            stringBuilder.append(this.days);
            stringBuilder.append('D');
        }
        return stringBuilder.toString();
    }
}
