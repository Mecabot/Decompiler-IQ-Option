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

public final class Year extends c implements Serializable, Comparable<Year>, a, org.threeten.bp.temporal.c {
    public static final g<Year> FROM = new g<Year>() {
        /* renamed from: s */
        public Year b(b bVar) {
            return Year.r(bVar);
        }
    };
    private static final org.threeten.bp.format.b fdQ = new DateTimeFormatterBuilder().a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).bDe();
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    public static Year mM(int i) {
        ChronoField.YEAR.checkValidValue((long) i);
        return new Year(i);
    }

    public static Year r(b bVar) {
        if (bVar instanceof Year) {
            return (Year) bVar;
        }
        try {
            if (!IsoChronology.feQ.equals(e.B(bVar))) {
                bVar = LocalDate.e(bVar);
            }
            return mM(bVar.get(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain Year from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private Year(int i) {
        this.year = i;
    }

    public boolean isSupported(org.threeten.bp.temporal.e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar == ChronoField.YEAR || eVar == ChronoField.YEAR_OF_ERA || eVar == ChronoField.ERA)) {
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
        return ValueRange.G(1, this.year <= 0 ? 1000000000 : 999999999);
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

    /* renamed from: j */
    public Year b(org.threeten.bp.temporal.c cVar) {
        return (Year) cVar.adjustInto(this);
    }

    /* renamed from: j */
    public Year b(org.threeten.bp.temporal.e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (Year) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        switch (chronoField) {
            case YEAR_OF_ERA:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return mM((int) j);
            case YEAR:
                return mM((int) j);
            case ERA:
                return getLong(ChronoField.ERA) == j ? this : mM(1 - this.year);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    /* renamed from: s */
    public Year d(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (Year) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case YEARS:
                return dJ(j);
            case DECADES:
                return dJ(d.j(j, 10));
            case CENTURIES:
                return dJ(d.j(j, 100));
            case MILLENNIA:
                return dJ(d.j(j, 1000));
            case ERAS:
                return b(ChronoField.ERA, d.D(getLong(ChronoField.ERA), j));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public Year dJ(long j) {
        return j == 0 ? this : mM(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j));
    }

    /* renamed from: t */
    public Year c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return IsoChronology.feQ;
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.YEARS;
        }
        return (gVar == f.bDv() || gVar == f.bDw() || gVar == f.bDt() || gVar == f.bDq() || gVar == f.bDu()) ? null : super.query(gVar);
    }

    public a adjustInto(a aVar) {
        if (e.B(aVar).equals(IsoChronology.feQ)) {
            return aVar.b(ChronoField.YEAR, (long) this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public long a(a aVar, h hVar) {
        aVar = r(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        long j = ((long) aVar.year) - ((long) this.year);
        switch ((ChronoUnit) hVar) {
            case YEARS:
                return j;
            case DECADES:
                return j / 10;
            case CENTURIES:
                return j / 100;
            case MILLENNIA:
                return j / 1000;
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
    public int compareTo(Year year) {
        return this.year - year.year;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Year)) {
            return false;
        }
        if (this.year != ((Year) obj).year) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.year;
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
    }

    static Year j(DataInput dataInput) {
        return mM(dataInput.readInt());
    }
}
