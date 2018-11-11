package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

public enum MinguoEra implements f {
    BEFORE_ROC,
    ROC;

    public static MinguoEra of(int i) {
        switch (i) {
            case 0:
                return BEFORE_ROC;
            case 1:
                return ROC;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid era: ");
                stringBuilder.append(i);
                throw new DateTimeException(stringBuilder.toString());
        }
    }

    public int getValue() {
        return ordinal();
    }

    public boolean isSupported(e eVar) {
        boolean z = false;
        if (eVar instanceof ChronoField) {
            if (eVar == ChronoField.ERA) {
                z = true;
            }
            return z;
        }
        if (eVar != null && eVar.isSupportedBy(this)) {
            z = true;
        }
        return z;
    }

    public ValueRange range(e eVar) {
        if (eVar == ChronoField.ERA) {
            return eVar.range();
        }
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public int get(e eVar) {
        if (eVar == ChronoField.ERA) {
            return getValue();
        }
        return range(eVar).b(getLong(eVar), eVar);
    }

    public long getLong(e eVar) {
        if (eVar == ChronoField.ERA) {
            return (long) getValue();
        }
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.ERA, (long) getValue());
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDs()) {
            return ChronoUnit.ERAS;
        }
        return (gVar == f.bDr() || gVar == f.bDt() || gVar == f.bDq() || gVar == f.bDu() || gVar == f.bDv() || gVar == f.bDw()) ? null : gVar.b(this);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().a(ChronoField.ERA, textStyle).b(locale).N(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(getValue());
    }

    static MinguoEra readExternal(DataInput dataInput) {
        return of(dataInput.readByte());
    }
}
