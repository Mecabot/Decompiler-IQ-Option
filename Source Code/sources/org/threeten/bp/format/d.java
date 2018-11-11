package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.c;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.a;
import org.threeten.bp.chrono.e;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;

/* compiled from: DateTimePrintContext */
final class d {
    private b fgl;
    private f fgm;
    private int fgn;
    private Locale locale;

    d(b bVar, b bVar2) {
        this.fgl = a(bVar, bVar2);
        this.locale = bVar2.getLocale();
        this.fgm = bVar2.bCV();
    }

    private static b a(final b bVar, b bVar2) {
        e bCs = bVar2.bCs();
        ZoneId bCB = bVar2.bCB();
        if (bCs == null && bCB == null) {
            return bVar;
        }
        e eVar = (e) bVar.query(f.bDr());
        ZoneId zoneId = (ZoneId) bVar.query(f.bDq());
        a aVar = null;
        if (org.threeten.bp.a.d.equals(eVar, bCs)) {
            bCs = null;
        }
        if (org.threeten.bp.a.d.equals(zoneId, bCB)) {
            bCB = null;
        }
        if (bCs == null && bCB == null) {
            return bVar;
        }
        StringBuilder stringBuilder;
        final e eVar2 = bCs != null ? bCs : eVar;
        if (bCB != null) {
            zoneId = bCB;
        }
        if (bCB != null) {
            if (bVar.isSupported(ChronoField.INSTANT_SECONDS)) {
                if (eVar2 == null) {
                    eVar2 = IsoChronology.feQ;
                }
                return eVar2.d(Instant.c(bVar), bCB);
            }
            ZoneId bCA = bCB.bCA();
            ZoneOffset zoneOffset = (ZoneOffset) bVar.query(f.bDu());
            if (!(!(bCA instanceof ZoneOffset) || zoneOffset == null || bCA.equals(zoneOffset))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid override zone for temporal: ");
                stringBuilder.append(bCB);
                stringBuilder.append(" ");
                stringBuilder.append(bVar);
                throw new DateTimeException(stringBuilder.toString());
            }
        }
        if (bCs != null) {
            if (bVar.isSupported(ChronoField.EPOCH_DAY)) {
                aVar = eVar2.C(bVar);
            } else if (!(bCs == IsoChronology.feQ && eVar == null)) {
                for (org.threeten.bp.temporal.e eVar3 : ChronoField.values()) {
                    if (eVar3.isDateBased() && bVar.isSupported(eVar3)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid override chronology for temporal: ");
                        stringBuilder.append(bCs);
                        stringBuilder.append(" ");
                        stringBuilder.append(bVar);
                        throw new DateTimeException(stringBuilder.toString());
                    }
                }
            }
        }
        return new c() {
            public boolean isSupported(org.threeten.bp.temporal.e eVar) {
                if (aVar == null || !eVar.isDateBased()) {
                    return bVar.isSupported(eVar);
                }
                return aVar.isSupported(eVar);
            }

            public ValueRange range(org.threeten.bp.temporal.e eVar) {
                if (aVar == null || !eVar.isDateBased()) {
                    return bVar.range(eVar);
                }
                return aVar.range(eVar);
            }

            public long getLong(org.threeten.bp.temporal.e eVar) {
                if (aVar == null || !eVar.isDateBased()) {
                    return bVar.getLong(eVar);
                }
                return aVar.getLong(eVar);
            }

            public <R> R query(g<R> gVar) {
                if (gVar == f.bDr()) {
                    return eVar2;
                }
                if (gVar == f.bDq()) {
                    return zoneId;
                }
                if (gVar == f.bDs()) {
                    return bVar.query(gVar);
                }
                return gVar.b(this);
            }
        };
    }

    b bDi() {
        return this.fgl;
    }

    Locale getLocale() {
        return this.locale;
    }

    f bDj() {
        return this.fgm;
    }

    void bDk() {
        this.fgn++;
    }

    void bDl() {
        this.fgn--;
    }

    <R> R a(g<R> gVar) {
        R query = this.fgl.query(gVar);
        if (query != null || this.fgn != 0) {
            return query;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to extract value: ");
        stringBuilder.append(this.fgl.getClass());
        throw new DateTimeException(stringBuilder.toString());
    }

    Long c(org.threeten.bp.temporal.e eVar) {
        try {
            return Long.valueOf(this.fgl.getLong(eVar));
        } catch (DateTimeException e) {
            if (this.fgn > 0) {
                return null;
            }
            throw e;
        }
    }

    public String toString() {
        return this.fgl.toString();
    }
}
