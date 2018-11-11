package org.threeten.bp;

import com.iqoption.dto.ToastEntity;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.c;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

public final class YearMonth extends c implements Serializable, Comparable<YearMonth>, a, org.threeten.bp.temporal.c {
    public static final g<YearMonth> FROM = new g<YearMonth>() {
        /* renamed from: u */
        public YearMonth b(b bVar) {
            return YearMonth.t(bVar);
        }
    };
    private static final org.threeten.bp.format.b fdQ = new DateTimeFormatterBuilder().a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).F('-').a(ChronoField.MONTH_OF_YEAR, 2).bDe();
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    public static YearMonth bp(int i, int i2) {
        ChronoField.YEAR.checkValidValue((long) i);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i2);
        return new YearMonth(i, i2);
    }

    public static YearMonth t(b bVar) {
        if (bVar instanceof YearMonth) {
            return (YearMonth) bVar;
        }
        try {
            if (!IsoChronology.feQ.equals(e.B(bVar))) {
                bVar = LocalDate.e(bVar);
            }
            return bp(bVar.get(ChronoField.YEAR), bVar.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain YearMonth from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private YearMonth(int i, int i2) {
        this.year = i;
        this.month = i2;
    }

    private YearMonth bq(int i, int i2) {
        if (this.year == i && this.month == i2) {
            return this;
        }
        return new YearMonth(i, i2);
    }

    public boolean isSupported(org.threeten.bp.temporal.e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar == ChronoField.YEAR || eVar == ChronoField.MONTH_OF_YEAR || eVar == ChronoField.PROLEPTIC_MONTH || eVar == ChronoField.YEAR_OF_ERA || eVar == ChronoField.ERA)) {
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
        if (eVar != ChronoField.YEAR_OF_ERA) {
            return super.range(eVar);
        }
        return ValueRange.G(1, getYear() <= 0 ? 1000000000 : 999999999);
    }

    public int get(org.threeten.bp.temporal.e eVar) {
        return range(eVar).b(getLong(eVar), eVar);
    }

    public long getLong(org.threeten.bp.temporal.e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        int i = 1;
        switch ((ChronoField) eVar) {
            case MONTH_OF_YEAR:
                return (long) this.month;
            case PROLEPTIC_MONTH:
                return bCn();
            case YEAR_OF_ERA:
                return (long) (this.year < 1 ? 1 - this.year : this.year);
            case YEAR:
                return (long) this.year;
            case ERA:
                if (this.year < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private long bCn() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public int getYear() {
        return this.year;
    }

    /* renamed from: k */
    public YearMonth b(org.threeten.bp.temporal.c cVar) {
        return (YearMonth) cVar.adjustInto(this);
    }

    /* renamed from: k */
    public YearMonth b(org.threeten.bp.temporal.e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (YearMonth) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        switch (chronoField) {
            case MONTH_OF_YEAR:
                return mO((int) j);
            case PROLEPTIC_MONTH:
                return dL(j - getLong(ChronoField.PROLEPTIC_MONTH));
            case YEAR_OF_ERA:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return mN((int) j);
            case YEAR:
                return mN((int) j);
            case ERA:
                return getLong(ChronoField.ERA) == j ? this : mN(1 - this.year);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public YearMonth mN(int i) {
        ChronoField.YEAR.checkValidValue((long) i);
        return bq(i, this.month);
    }

    public YearMonth mO(int i) {
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i);
        return bq(this.year, i);
    }

    /* renamed from: u */
    public YearMonth d(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (YearMonth) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case MONTHS:
                return dL(j);
            case YEARS:
                return dK(j);
            case DECADES:
                return dK(d.j(j, 10));
            case CENTURIES:
                return dK(d.j(j, 100));
            case MILLENNIA:
                return dK(d.j(j, 1000));
            case ERAS:
                return b(ChronoField.ERA, d.D(getLong(ChronoField.ERA), j));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public YearMonth dK(long j) {
        if (j == 0) {
            return this;
        }
        return bq(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j), this.month);
    }

    public YearMonth dL(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + j;
        return bq(ChronoField.YEAR.checkValidIntValue(d.floorDiv(j2, 12)), d.k(j2, 12) + 1);
    }

    /* renamed from: v */
    public YearMonth c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return IsoChronology.feQ;
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.MONTHS;
        }
        return (gVar == f.bDv() || gVar == f.bDw() || gVar == f.bDt() || gVar == f.bDq() || gVar == f.bDu()) ? null : super.query(gVar);
    }

    public a adjustInto(a aVar) {
        if (e.B(aVar).equals(IsoChronology.feQ)) {
            return aVar.b(ChronoField.PROLEPTIC_MONTH, bCn());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public long a(a aVar, h hVar) {
        aVar = t(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        long bCn = aVar.bCn() - bCn();
        switch ((ChronoUnit) hVar) {
            case MONTHS:
                return bCn;
            case YEARS:
                return bCn / 12;
            case DECADES:
                return bCn / 120;
            case CENTURIES:
                return bCn / 1200;
            case MILLENNIA:
                return bCn / 12000;
            case ERAS:
                return aVar.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public int compareTo(YearMonth yearMonth) {
        int i = this.year - yearMonth.year;
        return i == 0 ? this.month - yearMonth.month : i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        if (!(this.year == yearMonth.year && this.month == yearMonth.month)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.year ^ (this.month << 27);
    }

    public String toString() {
        int abs = Math.abs(this.year);
        StringBuilder stringBuilder = new StringBuilder(9);
        if (abs >= 1000) {
            stringBuilder.append(this.year);
        } else if (this.year < 0) {
            stringBuilder.append(this.year - 10000);
            stringBuilder.deleteCharAt(1);
        } else {
            stringBuilder.append(this.year + ToastEntity.ALERT_TOAST_DURATION);
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.append(this.month < 10 ? "-0" : "-");
        stringBuilder.append(this.month);
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    static YearMonth k(DataInput dataInput) {
        return bp(dataInput.readInt(), dataInput.readByte());
    }
}
