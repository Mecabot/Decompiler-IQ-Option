package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.c;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

public final class MonthDay extends c implements Serializable, Comparable<MonthDay>, b, org.threeten.bp.temporal.c {
    public static final g<MonthDay> FROM = new g<MonthDay>() {
        /* renamed from: m */
        public MonthDay b(b bVar) {
            return MonthDay.l(bVar);
        }
    };
    private static final org.threeten.bp.format.b fdQ = new DateTimeFormatterBuilder().nP("--").a(ChronoField.MONTH_OF_YEAR, 2).F('-').a(ChronoField.DAY_OF_MONTH, 2).bDe();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    public static MonthDay a(Month month, int i) {
        d.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i);
        if (i <= month.maxLength()) {
            return new MonthDay(month.getValue(), i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal value for DayOfMonth field, value ");
        stringBuilder.append(i);
        stringBuilder.append(" is not valid for month ");
        stringBuilder.append(month.name());
        throw new DateTimeException(stringBuilder.toString());
    }

    public static MonthDay bo(int i, int i2) {
        return a(Month.of(i), i2);
    }

    public static MonthDay l(b bVar) {
        if (bVar instanceof MonthDay) {
            return (MonthDay) bVar;
        }
        try {
            if (!IsoChronology.feQ.equals(e.B(bVar))) {
                bVar = LocalDate.e(bVar);
            }
            return bo(bVar.get(ChronoField.MONTH_OF_YEAR), bVar.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain MonthDay from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private MonthDay(int i, int i2) {
        this.month = i;
        this.day = i2;
    }

    public boolean isSupported(org.threeten.bp.temporal.e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar == ChronoField.MONTH_OF_YEAR || eVar == ChronoField.DAY_OF_MONTH)) {
                z = false;
            }
            return z;
        }
        if (eVar == null || !eVar.isSupportedBy(this)) {
            z = false;
        }
        return z;
    }

    public ValueRange range(org.threeten.bp.temporal.e eVar) {
        if (eVar == ChronoField.MONTH_OF_YEAR) {
            return eVar.range();
        }
        if (eVar == ChronoField.DAY_OF_MONTH) {
            return ValueRange.a(1, (long) bCq().minLength(), (long) bCq().maxLength());
        }
        return super.range(eVar);
    }

    public int get(org.threeten.bp.temporal.e eVar) {
        return range(eVar).b(getLong(eVar), eVar);
    }

    public long getLong(org.threeten.bp.temporal.e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        switch ((ChronoField) eVar) {
            case DAY_OF_MONTH:
                return (long) this.day;
            case MONTH_OF_YEAR:
                return (long) this.month;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public Month bCq() {
        return Month.of(this.month);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return IsoChronology.feQ;
        }
        return super.query(gVar);
    }

    public a adjustInto(a aVar) {
        if (e.B(aVar).equals(IsoChronology.feQ)) {
            aVar = aVar.b(ChronoField.MONTH_OF_YEAR, (long) this.month);
            return aVar.b(ChronoField.DAY_OF_MONTH, Math.min(aVar.range(ChronoField.DAY_OF_MONTH).getMaximum(), (long) this.day));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    /* renamed from: a */
    public int compareTo(MonthDay monthDay) {
        int i = this.month - monthDay.month;
        return i == 0 ? this.day - monthDay.day : i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        if (!(this.month == monthDay.month && this.day == monthDay.day)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.append("--");
        stringBuilder.append(this.month < 10 ? "0" : "");
        stringBuilder.append(this.month);
        stringBuilder.append(this.day < 10 ? "-0" : "-");
        stringBuilder.append(this.day);
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    static MonthDay f(DataInput dataInput) {
        return bo(dataInput.readByte(), dataInput.readByte());
    }
}
