package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.h;

public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    static final LocalDate feW = LocalDate.F(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient int feK;
    private transient JapaneseEra feX;
    private final LocalDate isoDate;

    JapaneseDate(LocalDate localDate) {
        if (localDate.c(feW)) {
            throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
        }
        this.feX = JapaneseEra.e(localDate);
        this.feK = localDate.getYear() - (this.feX.bCO().getYear() - 1);
        this.isoDate = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.feX = JapaneseEra.e(this.isoDate);
        this.feK = this.isoDate.getYear() - (this.feX.bCO().getYear() - 1);
    }

    /* renamed from: bCK */
    public JapaneseChronology bCs() {
        return JapaneseChronology.feS;
    }

    /* renamed from: bCL */
    public JapaneseEra bCp() {
        return this.feX;
    }

    public int lengthOfYear() {
        Calendar instance = Calendar.getInstance(JapaneseChronology.feR);
        instance.set(0, this.feX.getValue() + 2);
        instance.set(this.feK, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return instance.getActualMaximum(6);
    }

    public boolean isSupported(e eVar) {
        return (eVar == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || eVar == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || eVar == ChronoField.ALIGNED_WEEK_OF_MONTH || eVar == ChronoField.ALIGNED_WEEK_OF_YEAR) ? false : super.isSupported(eVar);
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (isSupported(eVar)) {
            ChronoField chronoField = (ChronoField) eVar;
            switch (chronoField) {
                case DAY_OF_YEAR:
                    return ne(6);
                case YEAR_OF_ERA:
                    return ne(1);
                default:
                    return bCs().a(chronoField);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    private ValueRange ne(int i) {
        Calendar instance = Calendar.getInstance(JapaneseChronology.feR);
        instance.set(0, this.feX.getValue() + 2);
        instance.set(this.feK, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.G((long) instance.getActualMinimum(i), (long) instance.getActualMaximum(i));
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        switch ((ChronoField) eVar) {
            case DAY_OF_YEAR:
                return bCM();
            case YEAR_OF_ERA:
                return (long) this.feK;
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
            case ALIGNED_WEEK_OF_MONTH:
            case ALIGNED_WEEK_OF_YEAR:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
            case ERA:
                return (long) this.feX.getValue();
            default:
                return this.isoDate.getLong(eVar);
        }
    }

    private long bCM() {
        if (this.feK == 1) {
            return (long) ((this.isoDate.getDayOfYear() - this.feX.bCO().getDayOfYear()) + 1);
        }
        return (long) this.isoDate.getDayOfYear();
    }

    /* renamed from: p */
    public JapaneseDate d(c cVar) {
        return (JapaneseDate) super.b(cVar);
    }

    /* renamed from: p */
    public JapaneseDate d(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (JapaneseDate) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        if (getLong(chronoField) == j) {
            return this;
        }
        int i = AnonymousClass1.fdE[chronoField.ordinal()];
        if (i != 7) {
            switch (i) {
                case 1:
                case 2:
                    break;
            }
        }
        i = bCs().a(chronoField).b(j, chronoField);
        int i2 = AnonymousClass1.fdE[chronoField.ordinal()];
        if (i2 == 7) {
            return a(JapaneseEra.ng(i), this.feK);
        }
        switch (i2) {
            case 1:
                return d(this.isoDate.dv(((long) i) - bCM()));
            case 2:
                return nf(i);
        }
        return d(this.isoDate.d(eVar, j));
    }

    /* renamed from: E */
    public JapaneseDate h(long j, h hVar) {
        return (JapaneseDate) super.h(j, hVar);
    }

    /* renamed from: F */
    public JapaneseDate g(long j, h hVar) {
        return (JapaneseDate) super.c(j, hVar);
    }

    private JapaneseDate a(JapaneseEra japaneseEra, int i) {
        return d(this.isoDate.mE(JapaneseChronology.feS.a(japaneseEra, i)));
    }

    private JapaneseDate nf(int i) {
        return a(bCp(), i);
    }

    /* renamed from: ea */
    JapaneseDate dM(long j) {
        return d(this.isoDate.ds(j));
    }

    /* renamed from: eb */
    JapaneseDate dN(long j) {
        return d(this.isoDate.dt(j));
    }

    /* renamed from: ec */
    JapaneseDate dO(long j) {
        return d(this.isoDate.dv(j));
    }

    private JapaneseDate d(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }

    public final b<JapaneseDate> b(LocalTime localTime) {
        return super.b(localTime);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JapaneseDate)) {
            return false;
        }
        return this.isoDate.equals(((JapaneseDate) obj).isoDate);
    }

    public int hashCode() {
        return bCs().getId().hashCode() ^ this.isoDate.hashCode();
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static a p(DataInput dataInput) {
        return JapaneseChronology.feS.Q(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
