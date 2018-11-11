package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.Map;
import org.threeten.bp.ZoneId;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

/* compiled from: DateTimeParseContext */
final class c {
    private boolean caseSensitive;
    private final ArrayList<a> fgk;
    private boolean strict;

    /* compiled from: DateTimeParseContext */
    final class a extends org.threeten.bp.a.c {
        final Map<e, Long> ffg;
        org.threeten.bp.chrono.e ffh;
        ZoneId zone;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.ffg.toString());
            stringBuilder.append(",");
            stringBuilder.append(this.ffh);
            stringBuilder.append(",");
            stringBuilder.append(this.zone);
            return stringBuilder.toString();
        }

        public boolean isSupported(e eVar) {
            return this.ffg.containsKey(eVar);
        }

        public int get(e eVar) {
            if (this.ffg.containsKey(eVar)) {
                return d.ek(((Long) this.ffg.get(eVar)).longValue());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append(eVar);
            throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }

        public long getLong(e eVar) {
            if (this.ffg.containsKey(eVar)) {
                return ((Long) this.ffg.get(eVar)).longValue();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append(eVar);
            throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }

        public <R> R query(g<R> gVar) {
            if (gVar == f.bDr()) {
                return this.ffh;
            }
            if (gVar == f.bDq() || gVar == f.bDt()) {
                return this.zone;
            }
            return super.query(gVar);
        }
    }

    void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    void setStrict(boolean z) {
        this.strict = z;
    }

    private a bDh() {
        return (a) this.fgk.get(this.fgk.size() - 1);
    }

    public String toString() {
        return bDh().toString();
    }
}
