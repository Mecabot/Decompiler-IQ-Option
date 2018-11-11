package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.b;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* compiled from: ChronoZonedDateTime */
public abstract class d<D extends a> extends b implements Comparable<d<?>>, a {
    private static Comparator<d<?>> fdT = new Comparator<d<?>>() {
        /* renamed from: a */
        public int compare(d<?> dVar, d<?> dVar2) {
            int C = org.threeten.bp.a.d.C(dVar.toEpochSecond(), dVar2.toEpochSecond());
            return C == 0 ? org.threeten.bp.a.d.C(dVar.bCu().toNanoOfDay(), dVar2.bCu().toNanoOfDay()) : C;
        }
    };

    public abstract ZoneId bCB();

    public abstract b<D> bCD();

    public abstract ZoneOffset bCw();

    public abstract d<D> e(ZoneId zoneId);

    public abstract d<D> f(ZoneId zoneId);

    /* renamed from: m */
    public abstract d<D> b(e eVar, long j);

    /* renamed from: z */
    public abstract d<D> d(long j, h hVar);

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (eVar == ChronoField.INSTANT_SECONDS || eVar == ChronoField.OFFSET_SECONDS) {
            return eVar.range();
        }
        return bCD().range(eVar);
    }

    public int get(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return super.get(eVar);
        }
        switch ((ChronoField) eVar) {
            case INSTANT_SECONDS:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Field too large for an int: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
            case OFFSET_SECONDS:
                return bCw().getTotalSeconds();
            default:
                return bCD().get(eVar);
        }
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        switch ((ChronoField) eVar) {
            case INSTANT_SECONDS:
                return toEpochSecond();
            case OFFSET_SECONDS:
                return (long) bCw().getTotalSeconds();
            default:
                return bCD().getLong(eVar);
        }
    }

    public D bCv() {
        return bCD().bCv();
    }

    public LocalTime bCu() {
        return bCD().bCu();
    }

    /* renamed from: m */
    public d<D> b(c cVar) {
        return bCv().bCs().c(super.b(cVar));
    }

    /* renamed from: y */
    public d<D> c(long j, h hVar) {
        return bCv().bCs().c(super.c(j, hVar));
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDq() || gVar == f.bDt()) {
            return bCB();
        }
        if (gVar == f.bDr()) {
            return bCv().bCs();
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        if (gVar == f.bDu()) {
            return bCw();
        }
        if (gVar == f.bDv()) {
            return LocalDate.dr(bCv().toEpochDay());
        }
        if (gVar == f.bDw()) {
            return bCu();
        }
        return super.query(gVar);
    }

    public long toEpochSecond() {
        return ((bCv().toEpochDay() * 86400) + ((long) bCu().toSecondOfDay())) - ((long) bCw().getTotalSeconds());
    }

    /* renamed from: a */
    public int compareTo(d<?> dVar) {
        int C = org.threeten.bp.a.d.C(toEpochSecond(), dVar.toEpochSecond());
        if (C != 0) {
            return C;
        }
        C = bCu().getNano() - dVar.bCu().getNano();
        if (C != 0) {
            return C;
        }
        C = bCD().compareTo(dVar.bCD());
        if (C != 0) {
            return C;
        }
        C = bCB().getId().compareTo(dVar.bCB().getId());
        return C == 0 ? bCv().bCs().compareTo(dVar.bCv().bCs()) : C;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        if (compareTo((d) obj) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (bCD().hashCode() ^ bCw().hashCode()) ^ Integer.rotateLeft(bCB().hashCode(), 3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bCD().toString());
        stringBuilder.append(bCw().toString());
        String stringBuilder2 = stringBuilder.toString();
        if (bCw() == bCB()) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append('[');
        stringBuilder3.append(bCB().toString());
        stringBuilder3.append(']');
        return stringBuilder3.toString();
    }
}
