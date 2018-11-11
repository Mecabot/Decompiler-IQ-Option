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

public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final LocalDate isoDate;

    MinguoDate(LocalDate localDate) {
        d.requireNonNull(localDate, "date");
        this.isoDate = localDate;
    }

    /* renamed from: bCQ */
    public MinguoChronology bCs() {
        return MinguoChronology.ffe;
    }

    /* renamed from: bCR */
    public MinguoEra bCp() {
        return (MinguoEra) super.bCp();
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
                    return ValueRange.G(1, bCS() <= 0 ? ((-range.getMinimum()) + 1) + 1911 : range.getMaximum() - 1911);
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
        return this.isoDate.getYear() - 1911;
    }

    /* renamed from: q */
    public MinguoDate d(c cVar) {
        return (MinguoDate) super.b(cVar);
    }

    /* renamed from: q */
    public MinguoDate d(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (MinguoDate) eVar.adjustInto(this, j);
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
                            return f(this.isoDate.mE(b + 1911));
                        case 7:
                            return f(this.isoDate.mE((1 - bCS()) + 1911));
                    }
                }
                return f(this.isoDate.mE(bCS() >= 1 ? b + 1911 : (1 - b) + 1911));
                break;
            case PROLEPTIC_MONTH:
                bCs().a(chronoField).a(j, chronoField);
                return dN(j - bCn());
        }
        return f(this.isoDate.d(eVar, j));
    }

    /* renamed from: G */
    public MinguoDate h(long j, h hVar) {
        return (MinguoDate) super.h(j, hVar);
    }

    /* renamed from: H */
    public MinguoDate g(long j, h hVar) {
        return (MinguoDate) super.c(j, hVar);
    }

    /* renamed from: ed */
    MinguoDate dM(long j) {
        return f(this.isoDate.ds(j));
    }

    /* renamed from: ee */
    MinguoDate dN(long j) {
        return f(this.isoDate.dt(j));
    }

    /* renamed from: ef */
    MinguoDate dO(long j) {
        return f(this.isoDate.dv(j));
    }

    private MinguoDate f(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new MinguoDate(localDate);
    }

    public final b<MinguoDate> b(LocalTime localTime) {
        return super.b(localTime);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MinguoDate)) {
            return false;
        }
        return this.isoDate.equals(((MinguoDate) obj).isoDate);
    }

    public int hashCode() {
        return bCs().getId().hashCode() ^ this.isoDate.hashCode();
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static a p(DataInput dataInput) {
        return MinguoChronology.ffe.R(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
