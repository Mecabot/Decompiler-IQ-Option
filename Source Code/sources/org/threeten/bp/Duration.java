package org.threeten.bp;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.a.d;
import org.threeten.bp.format.DateTimeParseException;

public final class Duration implements Serializable, Comparable<Duration> {
    private static final Pattern fdA = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    public static final Duration fdy = new Duration(0, 0);
    private static final BigInteger fdz = BigInteger.valueOf(1000000000);
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    public static Duration dl(long j) {
        return f(j, 0);
    }

    public static Duration z(long j, long j2) {
        return f(d.D(j, d.floorDiv(j2, 1000000000)), d.k(j2, 1000000000));
    }

    public static Duration dm(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i += 1000000000;
            j2--;
        }
        return f(j2, i);
    }

    public static Duration U(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        d.requireNonNull(charSequence2, "text");
        Matcher matcher = fdA.matcher(charSequence2);
        if (matcher.matches() && !"T".equals(matcher.group(3))) {
            int i = 1;
            boolean equals = "-".equals(matcher.group(1));
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            String group3 = matcher.group(5);
            String group4 = matcher.group(6);
            String group5 = matcher.group(7);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                long a = a(charSequence2, group, ChartTimeInterval.CANDLE_1D, "days");
                long a2 = a(charSequence2, group2, ChartTimeInterval.CANDLE_1H, "hours");
                long a3 = a(charSequence2, group3, 60, "minutes");
                long a4 = a(charSequence2, group4, 1, "seconds");
                Object obj = (group4 == null || group4.charAt(0) != '-') ? null : 1;
                if (obj != null) {
                    i = -1;
                }
                try {
                    return a(equals, a, a2, a3, a4, a(charSequence2, group5, i));
                } catch (Throwable e) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence2, 0).initCause(e));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence2, 0);
    }

    private static long a(CharSequence charSequence, String str, int i, String str2) {
        StringBuilder stringBuilder;
        if (str == null) {
            return 0;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return d.j(Long.parseLong(str), i);
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Text cannot be parsed to a Duration: ");
            stringBuilder.append(str2);
            throw ((DateTimeParseException) new DateTimeParseException(stringBuilder.toString(), charSequence, 0).initCause(e));
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Text cannot be parsed to a Duration: ");
            stringBuilder.append(str2);
            throw ((DateTimeParseException) new DateTimeParseException(stringBuilder.toString(), charSequence, 0).initCause(e2));
        }
    }

    private static int a(CharSequence charSequence, String str, int i) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("000000000");
            return Integer.parseInt(stringBuilder.toString().substring(0, 9)) * i;
        } catch (Throwable e) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e));
        } catch (Throwable e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e2));
        }
    }

    private static Duration a(boolean z, long j, long j2, long j3, long j4, int i) {
        j = d.D(j, d.D(j2, d.D(j3, j4)));
        if (z) {
            return z(j, (long) i).bCm();
        }
        return z(j, (long) i);
    }

    private static Duration f(long j, int i) {
        if ((j | ((long) i)) == 0) {
            return fdy;
        }
        return new Duration(j, i);
    }

    private Duration(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public Duration dn(long j) {
        if (j == 0) {
            return fdy;
        }
        if (j == 1) {
            return this;
        }
        return e(bCl().multiply(BigDecimal.valueOf(j)));
    }

    private BigDecimal bCl() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf((long) this.nanos, 9));
    }

    private static Duration e(BigDecimal bigDecimal) {
        BigInteger toBigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] divideAndRemainder = toBigIntegerExact.divideAndRemainder(fdz);
        if (divideAndRemainder[0].bitLength() <= 63) {
            return z(divideAndRemainder[0].longValue(), (long) divideAndRemainder[1].intValue());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exceeds capacity of Duration: ");
        stringBuilder.append(toBigIntegerExact);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public Duration bCm() {
        return dn(-1);
    }

    /* renamed from: a */
    public int compareTo(Duration duration) {
        int C = d.C(this.seconds, duration.seconds);
        if (C != 0) {
            return C;
        }
        return this.nanos - duration.nanos;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        if (!(this.seconds == duration.seconds && this.nanos == duration.nanos)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((int) (this.seconds ^ (this.seconds >>> 32))) + (this.nanos * 51);
    }

    public String toString() {
        if (this == fdy) {
            return "PT0S";
        }
        long j = this.seconds / 3600;
        int i = (int) ((this.seconds % 3600) / 60);
        int i2 = (int) (this.seconds % 60);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append("PT");
        if (j != 0) {
            stringBuilder.append(j);
            stringBuilder.append('H');
        }
        if (i != 0) {
            stringBuilder.append(i);
            stringBuilder.append('M');
        }
        if (i2 == 0 && this.nanos == 0 && stringBuilder.length() > 2) {
            return stringBuilder.toString();
        }
        if (i2 >= 0 || this.nanos <= 0) {
            stringBuilder.append(i2);
        } else if (i2 == -1) {
            stringBuilder.append("-0");
        } else {
            stringBuilder.append(i2 + 1);
        }
        if (this.nanos > 0) {
            int length = stringBuilder.length();
            if (i2 < 0) {
                stringBuilder.append(2000000000 - this.nanos);
            } else {
                stringBuilder.append(this.nanos + 1000000000);
            }
            while (stringBuilder.charAt(stringBuilder.length() - 1) == '0') {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            stringBuilder.setCharAt(length, '.');
        }
        stringBuilder.append('S');
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    static Duration a(DataInput dataInput) {
        return z(dataInput.readLong(), (long) dataInput.readInt());
    }
}
