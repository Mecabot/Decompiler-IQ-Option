package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    public static ValueRange G(long j, long j2) {
        if (j <= j2) {
            return new ValueRange(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange a(long j, long j2, long j3) {
        return b(j, j, j2, j3);
    }

    public static ValueRange b(long j, long j2, long j3, long j4) {
        if (j > j2) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j3 > j4) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j2 <= j4) {
            return new ValueRange(j, j2, j3, j4);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    private ValueRange(long j, long j2, long j3, long j4) {
        this.minSmallest = j;
        this.minLargest = j2;
        this.maxSmallest = j3;
        this.maxLargest = j4;
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= 2147483647L;
    }

    public boolean isValidValue(long j) {
        return j >= getMinimum() && j <= getMaximum();
    }

    public boolean isValidIntValue(long j) {
        return isIntValue() && isValidValue(j);
    }

    public long a(long j, e eVar) {
        if (isValidValue(j)) {
            return j;
        }
        if (eVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value for ");
            stringBuilder.append(eVar);
            stringBuilder.append(" (valid values ");
            stringBuilder.append(this);
            stringBuilder.append("): ");
            stringBuilder.append(j);
            throw new DateTimeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Invalid value (valid values ");
        stringBuilder2.append(this);
        stringBuilder2.append("): ");
        stringBuilder2.append(j);
        throw new DateTimeException(stringBuilder2.toString());
    }

    public int b(long j, e eVar) {
        if (isValidIntValue(j)) {
            return (int) j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid int value for ");
        stringBuilder.append(eVar);
        stringBuilder.append(": ");
        stringBuilder.append(j);
        throw new DateTimeException(stringBuilder.toString());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        if (!(this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = ((((((this.minSmallest + this.minLargest) << ((int) (this.minLargest + 16))) >> ((int) (this.maxSmallest + 48))) << ((int) (this.maxSmallest + 32))) >> ((int) (this.maxLargest + 32))) << ((int) (this.maxLargest + 48))) >> 16;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            stringBuilder.append('/');
            stringBuilder.append(this.minLargest);
        }
        stringBuilder.append(" - ");
        stringBuilder.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            stringBuilder.append('/');
            stringBuilder.append(this.maxLargest);
        }
        return stringBuilder.toString();
    }
}
