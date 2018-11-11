package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.a.c;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

/* compiled from: DateTimeBuilder */
final class a extends c implements Cloneable, b {
    org.threeten.bp.chrono.a date;
    final Map<e, Long> ffg = new HashMap();
    org.threeten.bp.chrono.e ffh;
    boolean ffi;
    Period ffj;
    LocalTime time;
    ZoneId zone;

    private Long b(e eVar) {
        return (Long) this.ffg.get(eVar);
    }

    public boolean isSupported(e eVar) {
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        if (this.ffg.containsKey(eVar) || ((this.date != null && this.date.isSupported(eVar)) || (this.time != null && this.time.isSupported(eVar)))) {
            z = true;
        }
        return z;
    }

    public long getLong(e eVar) {
        d.requireNonNull(eVar, "field");
        Long b = b(eVar);
        if (b != null) {
            return b.longValue();
        }
        if (this.date != null && this.date.isSupported(eVar)) {
            return this.date.getLong(eVar);
        }
        if (this.time != null && this.time.isSupported(eVar)) {
            return this.time.getLong(eVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field not found: ");
        stringBuilder.append(eVar);
        throw new DateTimeException(stringBuilder.toString());
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDq()) {
            return this.zone;
        }
        if (gVar == f.bDr()) {
            return this.ffh;
        }
        R r = null;
        if (gVar == f.bDv()) {
            if (this.date != null) {
                r = LocalDate.e(this.date);
            }
            return r;
        } else if (gVar == f.bDw()) {
            return this.time;
        } else {
            if (gVar == f.bDt() || gVar == f.bDu()) {
                return gVar.b(this);
            }
            if (gVar == f.bDs()) {
                return null;
            }
            return gVar.b(this);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("DateTimeBuilder[");
        if (this.ffg.size() > 0) {
            stringBuilder.append("fields=");
            stringBuilder.append(this.ffg);
        }
        stringBuilder.append(", ");
        stringBuilder.append(this.ffh);
        stringBuilder.append(", ");
        stringBuilder.append(this.zone);
        stringBuilder.append(", ");
        stringBuilder.append(this.date);
        stringBuilder.append(", ");
        stringBuilder.append(this.time);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
