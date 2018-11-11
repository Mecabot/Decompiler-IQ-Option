package org.threeten.bp.a;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

/* compiled from: DefaultInterfaceTemporalAccessor */
public abstract class c implements b {
    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (isSupported(eVar)) {
            return eVar.range();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public int get(e eVar) {
        return range(eVar).b(getLong(eVar), eVar);
    }

    public <R> R query(g<R> gVar) {
        return (gVar == f.bDq() || gVar == f.bDr() || gVar == f.bDs()) ? null : gVar.b(this);
    }
}
