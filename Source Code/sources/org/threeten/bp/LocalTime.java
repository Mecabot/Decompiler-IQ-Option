package org.threeten.bp;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.c;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

public final class LocalTime extends c implements Serializable, Comparable<LocalTime>, a, org.threeten.bp.temporal.c {
    public static final g<LocalTime> FROM = new g<LocalTime>() {
        /* renamed from: j */
        public LocalTime b(b bVar) {
            return LocalTime.i(bVar);
        }
    };
    public static final LocalTime fdK = fdO[0];
    public static final LocalTime fdL = new LocalTime(23, 59, 59, 999999999);
    public static final LocalTime fdM = fdO[0];
    public static final LocalTime fdN = fdO[12];
    private static final LocalTime[] fdO = new LocalTime[24];
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    static {
        for (int i = 0; i < fdO.length; i++) {
            fdO[i] = new LocalTime(i, 0, 0, 0);
        }
    }

    public static LocalTime bn(int i, int i2) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        if (i2 == 0) {
            return fdO[i];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i2);
        return new LocalTime(i, i2, 0, 0);
    }

    public static LocalTime l(int i, int i2, int i3, int i4) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i2);
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i3);
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i4);
        return m(i, i2, i3, i4);
    }

    public static LocalTime dD(long j) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j);
        int i = (int) (j / 3600);
        long j2 = j - ((long) (i * ChartTimeInterval.CANDLE_1H));
        int i2 = (int) (j2 / 60);
        return m(i, i2, (int) (j2 - ((long) (i2 * 60))), 0);
    }

    static LocalTime h(long j, int i) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j);
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i);
        int i2 = (int) (j / 3600);
        long j2 = j - ((long) (i2 * ChartTimeInterval.CANDLE_1H));
        int i3 = (int) (j2 / 60);
        return m(i2, i3, (int) (j2 - ((long) (i3 * 60))), i);
    }

    public static LocalTime dE(long j) {
        ChronoField.NANO_OF_DAY.checkValidValue(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        j = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j / 1000000000);
        return m(i, i2, i3, (int) (j - (((long) i3) * 1000000000)));
    }

    public static LocalTime i(b bVar) {
        LocalTime localTime = (LocalTime) bVar.query(f.bDw());
        if (localTime != null) {
            return localTime;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalTime from TemporalAccessor: ");
        stringBuilder.append(bVar);
        stringBuilder.append(", type ");
        stringBuilder.append(bVar.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    private static LocalTime m(int i, int i2, int i3, int i4) {
        if (((i2 | i3) | i4) == 0) {
            return fdO[i];
        }
        return new LocalTime(i, i2, i3, i4);
    }

    private LocalTime(int i, int i2, int i3, int i4) {
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    public boolean isSupported(e eVar) {
        if (eVar instanceof ChronoField) {
            return eVar.isTimeBased();
        }
        boolean z = eVar != null && eVar.isSupportedBy(this);
        return z;
    }

    public ValueRange range(e eVar) {
        return super.range(eVar);
    }

    public int get(e eVar) {
        if (eVar instanceof ChronoField) {
            return a(eVar);
        }
        return super.get(eVar);
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        if (eVar == ChronoField.NANO_OF_DAY) {
            return toNanoOfDay();
        }
        if (eVar == ChronoField.MICRO_OF_DAY) {
            return toNanoOfDay() / 1000;
        }
        return (long) a(eVar);
    }

    private int a(e eVar) {
        StringBuilder stringBuilder;
        switch ((ChronoField) eVar) {
            case NANO_OF_SECOND:
                return this.nano;
            case NANO_OF_DAY:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field too large for an int: ");
                stringBuilder.append(eVar);
                throw new DateTimeException(stringBuilder.toString());
            case MICRO_OF_SECOND:
                return this.nano / 1000;
            case MICRO_OF_DAY:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field too large for an int: ");
                stringBuilder.append(eVar);
                throw new DateTimeException(stringBuilder.toString());
            case MILLI_OF_SECOND:
                return this.nano / 1000000;
            case MILLI_OF_DAY:
                return (int) (toNanoOfDay() / 1000000);
            case SECOND_OF_MINUTE:
                return this.second;
            case SECOND_OF_DAY:
                return toSecondOfDay();
            case MINUTE_OF_HOUR:
                return this.minute;
            case MINUTE_OF_DAY:
                return (this.hour * 60) + this.minute;
            case HOUR_OF_AMPM:
                return this.hour % 12;
            case CLOCK_HOUR_OF_AMPM:
                int i = this.hour % 12;
                if (i % 12 == 0) {
                    i = 12;
                }
                return i;
            case HOUR_OF_DAY:
                return this.hour;
            case CLOCK_HOUR_OF_DAY:
                return this.hour == (byte) 0 ? 24 : this.hour;
            case AMPM_OF_DAY:
                return this.hour / 12;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getSecond() {
        return this.second;
    }

    public int getNano() {
        return this.nano;
    }

    /* renamed from: g */
    public LocalTime b(org.threeten.bp.temporal.c cVar) {
        if (cVar instanceof LocalTime) {
            return (LocalTime) cVar;
        }
        return (LocalTime) cVar.adjustInto(this);
    }

    /* renamed from: g */
    public LocalTime b(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (LocalTime) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        switch (chronoField) {
            case NANO_OF_SECOND:
                return mL((int) j);
            case NANO_OF_DAY:
                return dE(j);
            case MICRO_OF_SECOND:
                return mL(((int) j) * 1000);
            case MICRO_OF_DAY:
                return dE(j * 1000);
            case MILLI_OF_SECOND:
                return mL(((int) j) * 1000000);
            case MILLI_OF_DAY:
                return dE(j * 1000000);
            case SECOND_OF_MINUTE:
                return mK((int) j);
            case SECOND_OF_DAY:
                return dH(j - ((long) toSecondOfDay()));
            case MINUTE_OF_HOUR:
                return mJ((int) j);
            case MINUTE_OF_DAY:
                return dG(j - ((long) ((this.hour * 60) + this.minute)));
            case HOUR_OF_AMPM:
                return dF(j - ((long) (this.hour % 12)));
            case CLOCK_HOUR_OF_AMPM:
                if (j == 12) {
                    j = 0;
                }
                return dF(j - ((long) (this.hour % 12)));
            case HOUR_OF_DAY:
                return mI((int) j);
            case CLOCK_HOUR_OF_DAY:
                if (j == 24) {
                    j = 0;
                }
                return mI((int) j);
            case AMPM_OF_DAY:
                return dF((j - ((long) (this.hour / 12))) * 12);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public LocalTime mI(int i) {
        if (this.hour == i) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        return m(i, this.minute, this.second, this.nano);
    }

    public LocalTime mJ(int i) {
        if (this.minute == i) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i);
        return m(this.hour, i, this.second, this.nano);
    }

    public LocalTime mK(int i) {
        if (this.second == i) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i);
        return m(this.hour, this.minute, i, this.nano);
    }

    public LocalTime mL(int i) {
        if (this.nano == i) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i);
        return m(this.hour, this.minute, this.second, i);
    }

    /* renamed from: m */
    public LocalTime d(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (LocalTime) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return dI(j);
            case MICROS:
                return dI((j % 86400000000L) * 1000);
            case MILLIS:
                return dI((j % 86400000) * 1000000);
            case SECONDS:
                return dH(j);
            case MINUTES:
                return dG(j);
            case HOURS:
                return dF(j);
            case HALF_DAYS:
                return dF((j % 2) * 12);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public LocalTime dF(long j) {
        if (j == 0) {
            return this;
        }
        return m(((((int) (j % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime dG(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.hour * 60) + this.minute;
        int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
        if (i == i2) {
            return this;
        }
        return m(i2 / 60, i2 % 60, this.second, this.nano);
    }

    public LocalTime dH(long j) {
        if (j == 0) {
            return this;
        }
        int i = ((this.hour * ChartTimeInterval.CANDLE_1H) + (this.minute * 60)) + this.second;
        int i2 = ((((int) (j % 86400)) + i) + ChartTimeInterval.CANDLE_1D) % ChartTimeInterval.CANDLE_1D;
        if (i == i2) {
            return this;
        }
        return m(i2 / ChartTimeInterval.CANDLE_1H, (i2 / 60) % 60, i2 % 60, this.nano);
    }

    public LocalTime dI(long j) {
        if (j == 0) {
            return this;
        }
        long toNanoOfDay = toNanoOfDay();
        j = (((j % 86400000000000L) + toNanoOfDay) + 86400000000000L) % 86400000000000L;
        if (toNanoOfDay == j) {
            return this;
        }
        return m((int) (j / 3600000000000L), (int) ((j / 60000000000L) % 60), (int) ((j / 1000000000) % 60), (int) (j % 1000000000));
    }

    /* renamed from: n */
    public LocalTime c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        if (gVar == f.bDw()) {
            return this;
        }
        return (gVar == f.bDr() || gVar == f.bDq() || gVar == f.bDt() || gVar == f.bDu() || gVar == f.bDv()) ? null : gVar.b(this);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public long a(a aVar, h hVar) {
        aVar = i(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        long toNanoOfDay = aVar.toNanoOfDay() - toNanoOfDay();
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return toNanoOfDay;
            case MICROS:
                return toNanoOfDay / 1000;
            case MILLIS:
                return toNanoOfDay / 1000000;
            case SECONDS:
                return toNanoOfDay / 1000000000;
            case MINUTES:
                return toNanoOfDay / 60000000000L;
            case HOURS:
                return toNanoOfDay / 3600000000000L;
            case HALF_DAYS:
                return toNanoOfDay / 43200000000000L;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public OffsetTime b(ZoneOffset zoneOffset) {
        return OffsetTime.a(this, zoneOffset);
    }

    public int toSecondOfDay() {
        return ((this.hour * ChartTimeInterval.CANDLE_1H) + (this.minute * 60)) + this.second;
    }

    public long toNanoOfDay() {
        return (((((long) this.hour) * 3600000000000L) + (((long) this.minute) * 60000000000L)) + (((long) this.second) * 1000000000)) + ((long) this.nano);
    }

    /* renamed from: c */
    public int compareTo(LocalTime localTime) {
        int bu = d.bu(this.hour, localTime.hour);
        if (bu != 0) {
            return bu;
        }
        bu = d.bu(this.minute, localTime.minute);
        if (bu != 0) {
            return bu;
        }
        bu = d.bu(this.second, localTime.second);
        return bu == 0 ? d.bu(this.nano, localTime.nano) : bu;
    }

    public boolean d(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean e(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        if (!(this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long toNanoOfDay = toNanoOfDay();
        return (int) (toNanoOfDay ^ (toNanoOfDay >>> 32));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(18);
        byte b = this.hour;
        byte b2 = this.minute;
        byte b3 = this.second;
        int i = this.nano;
        stringBuilder.append(b < (byte) 10 ? "0" : "");
        stringBuilder.append(b);
        stringBuilder.append(b2 < (byte) 10 ? ":0" : ":");
        stringBuilder.append(b2);
        if (b3 > (byte) 0 || i > 0) {
            stringBuilder.append(b3 < (byte) 10 ? ":0" : ":");
            stringBuilder.append(b3);
            if (i > 0) {
                stringBuilder.append('.');
                if (i % 1000000 == 0) {
                    stringBuilder.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    stringBuilder.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    stringBuilder.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
        } else if (this.second != (byte) 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second ^ -1);
        } else if (this.minute == (byte) 0) {
            dataOutput.writeByte(this.hour ^ -1);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute ^ -1);
        }
    }

    static LocalTime e(DataInput dataInput) {
        int i;
        int i2;
        int readByte = dataInput.readByte();
        int i3 = 0;
        if (readByte < 0) {
            readByte ^= -1;
            i = 0;
            i2 = 0;
        } else {
            i2 = dataInput.readByte();
            if (i2 < 0) {
                i2 ^= -1;
            } else {
                byte readByte2 = dataInput.readByte();
                if (readByte2 < (byte) 0) {
                    i3 = readByte2 ^ -1;
                } else {
                    i = dataInput.readInt();
                    i3 = readByte2;
                }
            }
            i = 0;
        }
        return l(readByte, i2, i3, i);
    }
}
