package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.h;

public final class ThaiBuddhistDate extends ChronoDateImpl<ThaiBuddhistDate> implements Serializable {
    private static final long serialVersionUID = -8722293800195731463L;
    private final LocalDate isoDate;

    ThaiBuddhistDate(LocalDate localDate) {
        d.requireNonNull(localDate, "date");
        this.isoDate = localDate;
    }

    /* renamed from: bCT */
    public ThaiBuddhistChronology bCs() {
        return ThaiBuddhistChronology.fff;
    }

    /* renamed from: bCU */
    public ThaiBuddhistEra bCp() {
        return (ThaiBuddhistEra) super.bCp();
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (isSupported(eVar)) {
            ChronoField chronoField = (ChronoField) eVar;
            switch (chronoField) {
                case DAY_OF_MONTH:
                case DAY_OF_YEAR:
                case ALIGNED_WEEK_OF_MONTH:
                    return this.isoDate.range(eVar);
                case YEAR_OF_ERA:
                    ValueRange range = ChronoField.YEAR.range();
                    return ValueRange.G(1, bCS() <= 0 ? (-(range.getMinimum() + 543)) + 1 : range.getMaximum() + 543);
                default:
                    return bCs().a(chronoField);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        int i = 1;
        switch ((ChronoField) eVar) {
            case YEAR_OF_ERA:
                int bCS = bCS();
                if (bCS < 1) {
                    bCS = 1 - bCS;
                }
                return (long) bCS;
            case PROLEPTIC_MONTH:
                return bCn();
            case YEAR:
                return (long) bCS();
            case ERA:
                if (bCS() < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                return this.isoDate.getLong(eVar);
        }
    }

    private long bCn() {
        return ((((long) bCS()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    }

    private int bCS() {
        return this.isoDate.getYear() + 543;
    }

    /* renamed from: r */
    public ThaiBuddhistDate d(c cVar) {
        return (ThaiBuddhistDate) super.b(cVar);
    }

    /* renamed from: r */
    public ThaiBuddhistDate d(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (ThaiBuddhistDate) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        if (getLong(chronoField) == j) {
            return this;
        }
        switch (chronoField) {
            case YEAR_OF_ERA:
            case YEAR:
            case ERA:
                int b = bCs().a(chronoField).b(j, chronoField);
                int i = AnonymousClass1.fdE[chronoField.ordinal()];
                if (i != 4) {
                    switch (i) {
                        case 6:
                            return g(this.isoDate.mE(b - 543));
                        case 7:
                            return g(this.isoDate.mE((1 - bCS()) - 543));
                    }
                }
                LocalDate localDate = this.isoDate;
                if (bCS() < 1) {
                    b = 1 - b;
                }
                return g(localDate.mE(b - 543));
                break;
            case PROLEPTIC_MONTH:
                bCs().a(chronoField).a(j, chronoField);
                return dN(j - bCn());
        }
        return g(this.isoDate.d(eVar, j));
    }

    /* renamed from: I */
    public ThaiBuddhistDate h(long j, h hVar) {
        return (ThaiBuddhistDate) super.h(j, hVar);
    }

    /* renamed from: J */
    public ThaiBuddhistDate g(long j, h hVar) {
        return (ThaiBuddhistDate) super.c(j, hVar);
    }

    /* renamed from: eg */
    ThaiBuddhistDate dM(long j) {
        return g(this.isoDate.ds(j));
    }

    /* renamed from: eh */
    ThaiBuddhistDate dN(long j) {
        return g(this.isoDate.dt(j));
    }

    /* renamed from: ei */
    ThaiBuddhistDate dO(long j) {
        return g(this.isoDate.dv(j));
    }

    private ThaiBuddhistDate g(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new ThaiBuddhistDate(localDate);
    }

    public final b<ThaiBuddhistDate> b(LocalTime localTime) {
        return super.b(localTime);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThaiBuddhistDate)) {
            return false;
        }
        return this.isoDate.equals(((ThaiBuddhistDate) obj).isoDate);
    }

    public int hashCode() {
        return bCs().getId().hashCode() ^ this.isoDate.hashCode();
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static a p(DataInput dataInput) {
        return ThaiBuddhistChronology.fff.S(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
