package org.threeten.bp.zone;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;

public final class ZoneOffsetTransitionRule implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;
    private final boolean timeEndOfDay;

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            switch (this) {
                case UTC:
                    return localDateTime.dB((long) (zoneOffset2.getTotalSeconds() - ZoneOffset.fdZ.getTotalSeconds()));
                case STANDARD:
                    return localDateTime.dB((long) (zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()));
                default:
                    return localDateTime;
            }
        }
    }

    public static ZoneOffsetTransitionRule a(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        int i2 = i;
        LocalTime localTime2 = localTime;
        Month month2 = month;
        d.requireNonNull(month2, "month");
        d.requireNonNull(localTime2, "time");
        TimeDefinition timeDefinition2 = timeDefinition;
        d.requireNonNull(timeDefinition2, "timeDefnition");
        ZoneOffset zoneOffset4 = zoneOffset;
        d.requireNonNull(zoneOffset4, "standardOffset");
        ZoneOffset zoneOffset5 = zoneOffset2;
        d.requireNonNull(zoneOffset5, "offsetBefore");
        ZoneOffset zoneOffset6 = zoneOffset3;
        d.requireNonNull(zoneOffset6, "offsetAfter");
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (!z || localTime2.equals(LocalTime.fdM)) {
            return new ZoneOffsetTransitionRule(month2, i2, dayOfWeek, localTime2, z, timeDefinition2, zoneOffset4, zoneOffset5, zoneOffset6);
        } else {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
    }

    ZoneOffsetTransitionRule(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month;
        this.dom = (byte) i;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.timeEndOfDay = z;
        this.timeDefinition = timeDefinition;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    void writeExternal(DataOutput dataOutput) {
        int toSecondOfDay = this.timeEndOfDay ? ChartTimeInterval.CANDLE_1D : this.time.toSecondOfDay();
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        int hour = toSecondOfDay % ChartTimeInterval.CANDLE_1H == 0 ? this.timeEndOfDay ? 24 : this.time.getHour() : 31;
        int i = totalSeconds % ChartTimeInterval.CANDLE_15m == 0 ? (totalSeconds / ChartTimeInterval.CANDLE_15m) + 128 : 255;
        if (totalSeconds2 == 0 || totalSeconds2 == ChartTimeInterval.CANDLE_30m || totalSeconds2 == ChartTimeInterval.CANDLE_1H) {
            totalSeconds2 /= ChartTimeInterval.CANDLE_30m;
        } else {
            totalSeconds2 = 3;
        }
        if (totalSeconds3 == 0 || totalSeconds3 == ChartTimeInterval.CANDLE_30m || totalSeconds3 == ChartTimeInterval.CANDLE_1H) {
            totalSeconds3 /= ChartTimeInterval.CANDLE_30m;
        } else {
            totalSeconds3 = 3;
        }
        dataOutput.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + ((this.dow == null ? 0 : this.dow.getValue()) << 19)) + (hour << 14)) + (this.timeDefinition.ordinal() << 12)) + (i << 4)) + (totalSeconds2 << 2)) + totalSeconds3);
        if (hour == 31) {
            dataOutput.writeInt(toSecondOfDay);
        }
        if (i == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (totalSeconds2 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (totalSeconds3 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }

    static ZoneOffsetTransitionRule v(DataInput dataInput) {
        DayOfWeek dayOfWeek;
        int readInt = dataInput.readInt();
        Month of = Month.of(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        if (i2 == 0) {
            dayOfWeek = null;
        } else {
            dayOfWeek = DayOfWeek.of(i2);
        }
        DayOfWeek dayOfWeek2 = dayOfWeek;
        i2 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i3 = (readInt & 4080) >>> 4;
        int i4 = (readInt & 12) >>> 2;
        readInt &= 3;
        LocalTime dD = i2 == 31 ? LocalTime.dD((long) dataInput.readInt()) : LocalTime.bn(i2 % 24, 0);
        ZoneOffset mP = ZoneOffset.mP(i3 == 255 ? dataInput.readInt() : (i3 - 128) * ChartTimeInterval.CANDLE_15m);
        return a(of, i, dayOfWeek2, dD, i2 == 24, timeDefinition, mP, ZoneOffset.mP(i4 == 3 ? dataInput.readInt() : mP.getTotalSeconds() + (i4 * ChartTimeInterval.CANDLE_30m)), ZoneOffset.mP(readInt == 3 ? dataInput.readInt() : mP.getTotalSeconds() + (readInt * ChartTimeInterval.CANDLE_30m)));
    }

    public ZoneOffsetTransition nm(int i) {
        LocalDate a;
        if (this.dom < (byte) 0) {
            a = LocalDate.a(i, this.month, (this.month.length(IsoChronology.feQ.isLeapYear((long) i)) + 1) + this.dom);
            if (this.dow != null) {
                a = a.d(org.threeten.bp.temporal.d.b(this.dow));
            }
        } else {
            a = LocalDate.a(i, this.month, this.dom);
            if (this.dow != null) {
                a = a.d(org.threeten.bp.temporal.d.a(this.dow));
            }
        }
        if (this.timeEndOfDay) {
            a = a.dv(1);
        }
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.a(a, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        if (!(this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.time.equals(zoneOffsetTransitionRule.time) && this.timeEndOfDay == zoneOffsetTransitionRule.timeEndOfDay && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((this.time.toSecondOfDay() + this.timeEndOfDay) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5)) + ((this.dow == null ? 7 : this.dow.ordinal()) << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransitionRule[");
        stringBuilder.append(this.offsetBefore.compareTo(this.offsetAfter) > 0 ? "Gap " : "Overlap ");
        stringBuilder.append(this.offsetBefore);
        stringBuilder.append(" to ");
        stringBuilder.append(this.offsetAfter);
        stringBuilder.append(", ");
        if (this.dow == null) {
            stringBuilder.append(this.month.name());
            stringBuilder.append(' ');
            stringBuilder.append(this.dom);
        } else if (this.dom == (byte) -1) {
            stringBuilder.append(this.dow.name());
            stringBuilder.append(" on or before last day of ");
            stringBuilder.append(this.month.name());
        } else if (this.dom < (byte) 0) {
            stringBuilder.append(this.dow.name());
            stringBuilder.append(" on or before last day minus ");
            stringBuilder.append((-this.dom) - 1);
            stringBuilder.append(" of ");
            stringBuilder.append(this.month.name());
        } else {
            stringBuilder.append(this.dow.name());
            stringBuilder.append(" on or after ");
            stringBuilder.append(this.month.name());
            stringBuilder.append(' ');
            stringBuilder.append(this.dom);
        }
        stringBuilder.append(" at ");
        stringBuilder.append(this.timeEndOfDay ? "24:00" : this.time.toString());
        stringBuilder.append(" ");
        stringBuilder.append(this.timeDefinition);
        stringBuilder.append(", standard offset ");
        stringBuilder.append(this.standardOffset);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
