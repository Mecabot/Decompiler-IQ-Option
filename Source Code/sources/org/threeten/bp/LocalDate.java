package org.threeten.bp;

import com.iqoption.dto.ToastEntity;
import com.jumio.analytics.MobileEvents;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

public final class LocalDate extends a implements Serializable, org.threeten.bp.temporal.a, c {
    public static final g<LocalDate> FROM = new g<LocalDate>() {
        /* renamed from: f */
        public LocalDate b(b bVar) {
            return LocalDate.e(bVar);
        }
    };
    public static final LocalDate fdG = F(-999999999, 1, 1);
    public static final LocalDate fdH = F(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    public static LocalDate a(int i, Month month, int i2) {
        ChronoField.YEAR.checkValidValue((long) i);
        d.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i2);
        return b(i, month, i2);
    }

    public static LocalDate F(int i, int i2, int i3) {
        ChronoField.YEAR.checkValidValue((long) i);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i2);
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i3);
        return b(i, Month.of(i2), i3);
    }

    public static LocalDate bm(int i, int i2) {
        long j = (long) i;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.DAY_OF_YEAR.checkValidValue((long) i2);
        boolean isLeapYear = IsoChronology.feQ.isLeapYear(j);
        if (i2 != 366 || isLeapYear) {
            Month of = Month.of(((i2 - 1) / 31) + 1);
            if (i2 > (of.firstDayOfYear(isLeapYear) + of.length(isLeapYear)) - 1) {
                of = of.plus(1);
            }
            return b(i, of, (i2 - of.firstDayOfYear(isLeapYear)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid date 'DayOfYear 366' as '");
        stringBuilder.append(i);
        stringBuilder.append("' is not a leap year");
        throw new DateTimeException(stringBuilder.toString());
    }

    public static LocalDate dr(long j) {
        long j2;
        long j3;
        long j4 = j;
        ChronoField.EPOCH_DAY.checkValidValue(j4);
        long j5 = (j4 + 719528) - 60;
        if (j5 < 0) {
            long j6 = ((j5 + 1) / 146097) - 1;
            j2 = j6 * 400;
            j3 = j5 + ((-j6) * 146097);
        } else {
            j2 = 0;
            j3 = j5;
        }
        long j7 = ((j3 * 400) + 591) / 146097;
        long j8 = j3 - ((((j7 * 365) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        if (j8 < 0) {
            j4 = j7 - 1;
            j8 = j3 - ((((365 * j4) + (j4 / 4)) - (j4 / 100)) + (j4 / 400));
        } else {
            j4 = j7;
        }
        long j9 = j4 + j2;
        int i = (int) j8;
        int i2 = ((i * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j9 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * MobileEvents.EVENTTYPE_SDKPARAMETERS) + 5) / 10)) + 1);
    }

    public static LocalDate e(b bVar) {
        LocalDate localDate = (LocalDate) bVar.query(f.bDv());
        if (localDate != null) {
            return localDate;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalDate from TemporalAccessor: ");
        stringBuilder.append(bVar);
        stringBuilder.append(", type ");
        stringBuilder.append(bVar.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    private static LocalDate b(int i, Month month, int i2) {
        if (i2 <= 28 || i2 <= month.length(IsoChronology.feQ.isLeapYear((long) i))) {
            return new LocalDate(i, month.getValue(), i2);
        }
        if (i2 == 29) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid date 'February 29' as '");
            stringBuilder.append(i);
            stringBuilder.append("' is not a leap year");
            throw new DateTimeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Invalid date '");
        stringBuilder2.append(month.name());
        stringBuilder2.append(" ");
        stringBuilder2.append(i2);
        stringBuilder2.append("'");
        throw new DateTimeException(stringBuilder2.toString());
    }

    private static LocalDate G(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, IsoChronology.feQ.isLeapYear((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return F(i, i2, i3);
    }

    private LocalDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (short) i2;
        this.day = (short) i3;
    }

    public boolean isSupported(e eVar) {
        return super.isSupported(eVar);
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) eVar;
        if (chronoField.isDateBased()) {
            switch (chronoField) {
                case DAY_OF_MONTH:
                    return ValueRange.G(1, (long) lengthOfMonth());
                case DAY_OF_YEAR:
                    return ValueRange.G(1, (long) lengthOfYear());
                case ALIGNED_WEEK_OF_MONTH:
                    long j = (bCq() != Month.FEBRUARY || isLeapYear()) ? 5 : 4;
                    return ValueRange.G(1, j);
                case YEAR_OF_ERA:
                    return ValueRange.G(1, getYear() <= 0 ? 1000000000 : 999999999);
                default:
                    return eVar.range();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
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
        if (eVar == ChronoField.EPOCH_DAY) {
            return toEpochDay();
        }
        if (eVar == ChronoField.PROLEPTIC_MONTH) {
            return bCn();
        }
        return (long) a(eVar);
    }

    private int a(e eVar) {
        int i = 1;
        StringBuilder stringBuilder;
        switch ((ChronoField) eVar) {
            case DAY_OF_MONTH:
                return this.day;
            case DAY_OF_YEAR:
                return getDayOfYear();
            case ALIGNED_WEEK_OF_MONTH:
                return ((this.day - 1) / 7) + 1;
            case YEAR_OF_ERA:
                return this.year >= 1 ? this.year : 1 - this.year;
            case DAY_OF_WEEK:
                return bCr().getValue();
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return ((this.day - 1) % 7) + 1;
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return ((getDayOfYear() - 1) % 7) + 1;
            case EPOCH_DAY:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field too large for an int: ");
                stringBuilder.append(eVar);
                throw new DateTimeException(stringBuilder.toString());
            case ALIGNED_WEEK_OF_YEAR:
                return ((getDayOfYear() - 1) / 7) + 1;
            case MONTH_OF_YEAR:
                return this.month;
            case PROLEPTIC_MONTH:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field too large for an int: ");
                stringBuilder.append(eVar);
                throw new DateTimeException(stringBuilder.toString());
            case YEAR:
                return this.year;
            case ERA:
                if (this.year < 1) {
                    i = 0;
                }
                return i;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private long bCn() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    /* renamed from: bCo */
    public IsoChronology bCs() {
        return IsoChronology.feQ;
    }

    public org.threeten.bp.chrono.f bCp() {
        return super.bCp();
    }

    public int getYear() {
        return this.year;
    }

    public int getMonthValue() {
        return this.month;
    }

    public Month bCq() {
        return Month.of(this.month);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getDayOfYear() {
        return (bCq().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public DayOfWeek bCr() {
        return DayOfWeek.of(d.k(toEpochDay() + 3, 7) + 1);
    }

    public boolean isLeapYear() {
        return IsoChronology.feQ.isLeapYear((long) this.year);
    }

    public int lengthOfMonth() {
        short s = this.month;
        if (s != (short) 2) {
            return (s == (short) 4 || s == (short) 6 || s == (short) 9 || s == (short) 11) ? 30 : 31;
        } else {
            return isLeapYear() ? 29 : 28;
        }
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    /* renamed from: c */
    public LocalDate d(c cVar) {
        if (cVar instanceof LocalDate) {
            return (LocalDate) cVar;
        }
        return (LocalDate) cVar.adjustInto(this);
    }

    /* renamed from: c */
    public LocalDate d(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (LocalDate) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        switch (chronoField) {
            case DAY_OF_MONTH:
                return mG((int) j);
            case DAY_OF_YEAR:
                return mH((int) j);
            case ALIGNED_WEEK_OF_MONTH:
                return du(j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case YEAR_OF_ERA:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return mE((int) j);
            case DAY_OF_WEEK:
                return dv(j - ((long) bCr().getValue()));
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return dv(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return dv(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case EPOCH_DAY:
                return dr(j);
            case ALIGNED_WEEK_OF_YEAR:
                return du(j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case MONTH_OF_YEAR:
                return mF((int) j);
            case PROLEPTIC_MONTH:
                return dt(j - getLong(ChronoField.PROLEPTIC_MONTH));
            case YEAR:
                return mE((int) j);
            case ERA:
                return getLong(ChronoField.ERA) == j ? this : mE(1 - this.year);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public LocalDate mE(int i) {
        if (this.year == i) {
            return this;
        }
        ChronoField.YEAR.checkValidValue((long) i);
        return G(i, this.month, this.day);
    }

    public LocalDate mF(int i) {
        if (this.month == i) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i);
        return G(this.year, i, this.day);
    }

    public LocalDate mG(int i) {
        if (this.day == i) {
            return this;
        }
        return F(this.year, this.month, i);
    }

    public LocalDate mH(int i) {
        if (getDayOfYear() == i) {
            return this;
        }
        return bm(this.year, i);
    }

    /* renamed from: e */
    public LocalDate h(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (LocalDate) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case DAYS:
                return dv(j);
            case WEEKS:
                return du(j);
            case MONTHS:
                return dt(j);
            case YEARS:
                return ds(j);
            case DECADES:
                return ds(d.j(j, 10));
            case CENTURIES:
                return ds(d.j(j, 100));
            case MILLENNIA:
                return ds(d.j(j, 1000));
            case ERAS:
                return d(ChronoField.ERA, d.D(getLong(ChronoField.ERA), j));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public LocalDate ds(long j) {
        if (j == 0) {
            return this;
        }
        return G(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j), this.month, this.day);
    }

    public LocalDate dt(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + j;
        return G(ChronoField.YEAR.checkValidIntValue(d.floorDiv(j2, 12)), d.k(j2, 12) + 1, this.day);
    }

    public LocalDate du(long j) {
        return dv(d.j(j, 7));
    }

    public LocalDate dv(long j) {
        if (j == 0) {
            return this;
        }
        return dr(d.D(toEpochDay(), j));
    }

    /* renamed from: f */
    public LocalDate g(long j, h hVar) {
        return j == Long.MIN_VALUE ? h(Long.MAX_VALUE, hVar).h(1, hVar) : h(-j, hVar);
    }

    public LocalDate dw(long j) {
        return j == Long.MIN_VALUE ? ds(Long.MAX_VALUE).ds(1) : ds(-j);
    }

    public LocalDate dx(long j) {
        return j == Long.MIN_VALUE ? dv(Long.MAX_VALUE).dv(1) : dv(-j);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDv()) {
            return this;
        }
        return super.query(gVar);
    }

    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a aVar) {
        return super.adjustInto(aVar);
    }

    public long a(org.threeten.bp.temporal.a aVar, h hVar) {
        LocalDate e = e(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, e);
        }
        switch ((ChronoUnit) hVar) {
            case DAYS:
                return a(e);
            case WEEKS:
                return a(e) / 7;
            case MONTHS:
                return b(e);
            case YEARS:
                return b(e) / 12;
            case DECADES:
                return b(e) / 120;
            case CENTURIES:
                return b(e) / 1200;
            case MILLENNIA:
                return b(e) / 12000;
            case ERAS:
                return e.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    long a(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    private long b(LocalDate localDate) {
        return (((localDate.bCn() * 32) + ((long) localDate.getDayOfMonth())) - ((bCn() * 32) + ((long) getDayOfMonth()))) / 32;
    }

    /* renamed from: a */
    public LocalDateTime b(LocalTime localTime) {
        return LocalDateTime.a(this, localTime);
    }

    public long toEpochDay() {
        long j = (long) this.year;
        long j2 = (long) this.month;
        long j3 = (365 * j) + 0;
        if (j >= 0) {
            j = j3 + ((((j + 3) / 4) - ((j + 99) / 100)) + ((j + 399) / 400));
        } else {
            j = j3 - (((j / -4) - (j / -100)) + (j / -400));
        }
        long j4 = (j + (((367 * j2) - 362) / 12)) + ((long) (this.day - 1));
        if (j2 > 2) {
            j2 = j4 - 1;
            j4 = !isLeapYear() ? j2 - 1 : j2;
        }
        return j4 - 719528;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar instanceof LocalDate) {
            return c((LocalDate) aVar);
        }
        return super.compareTo(aVar);
    }

    int c(LocalDate localDate) {
        int i = this.year - localDate.year;
        if (i != 0) {
            return i;
        }
        i = this.month - localDate.month;
        return i == 0 ? this.day - localDate.day : i;
    }

    public boolean b(a aVar) {
        if (!(aVar instanceof LocalDate)) {
            return super.b(aVar);
        }
        return c((LocalDate) aVar) > 0;
    }

    public boolean c(a aVar) {
        if (!(aVar instanceof LocalDate)) {
            return super.c(aVar);
        }
        return c((LocalDate) aVar) < 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDate)) {
            return false;
        }
        if (c((LocalDate) obj) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.day) ^ (i & -2048);
    }

    public String toString() {
        int i = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(i);
        StringBuilder stringBuilder = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                stringBuilder.append('+');
            }
            stringBuilder.append(i);
        } else if (i < 0) {
            stringBuilder.append(i - 10000);
            stringBuilder.deleteCharAt(1);
        } else {
            stringBuilder.append(i + ToastEntity.ALERT_TOAST_DURATION);
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.append(s < (short) 10 ? "-0" : "-");
        stringBuilder.append(s);
        stringBuilder.append(s2 < (short) 10 ? "-0" : "-");
        stringBuilder.append(s2);
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    static LocalDate c(DataInput dataInput) {
        return F(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
