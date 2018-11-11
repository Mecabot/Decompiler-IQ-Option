package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* compiled from: ChronoLocalDateTime */
public abstract class b<D extends a> extends org.threeten.bp.a.b implements Comparable<b<?>>, a, c {
    private static final Comparator<b<?>> fee = new Comparator<b<?>>() {
        /* renamed from: a */
        public int compare(b<?> bVar, b<?> bVar2) {
            int C = d.C(bVar.bCv().toEpochDay(), bVar2.bCv().toEpochDay());
            return C == 0 ? d.C(bVar.bCu().toNanoOfDay(), bVar2.bCu().toNanoOfDay()) : C;
        }
    };

    public abstract d<D> b(ZoneId zoneId);

    public abstract LocalTime bCu();

    public abstract D bCv();

    /* renamed from: f */
    public abstract b<D> b(e eVar, long j);

    /* renamed from: l */
    public abstract b<D> d(long j, h hVar);

    public e bCs() {
        return bCv().bCs();
    }

    /* renamed from: f */
    public b<D> b(c cVar) {
        return bCv().bCs().b(super.b(cVar));
    }

    /* renamed from: k */
    public b<D> c(long j, h hVar) {
        return bCv().bCs().b(super.c(j, hVar));
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return bCs();
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        if (gVar == f.bDv()) {
            return LocalDate.dr(bCv().toEpochDay());
        }
        if (gVar == f.bDw()) {
            return bCu();
        }
        return (gVar == f.bDt() || gVar == f.bDq() || gVar == f.bDu()) ? null : super.query(gVar);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.EPOCH_DAY, bCv().toEpochDay()).b(ChronoField.NANO_OF_DAY, bCu().toNanoOfDay());
    }

    public Instant f(ZoneOffset zoneOffset) {
        return Instant.A(g(zoneOffset), (long) bCu().getNano());
    }

    public long g(ZoneOffset zoneOffset) {
        d.requireNonNull(zoneOffset, "offset");
        return ((bCv().toEpochDay() * 86400) + ((long) bCu().toSecondOfDay())) - ((long) zoneOffset.getTotalSeconds());
    }

    /* renamed from: a */
    public int compareTo(b<?> bVar) {
        int a = bCv().compareTo(bVar.bCv());
        if (a != 0) {
            return a;
        }
        a = bCu().compareTo(bVar.bCu());
        return a == 0 ? bCs().compareTo(bVar.bCs()) : a;
    }

    public boolean b(b<?> bVar) {
        long toEpochDay = bCv().toEpochDay();
        long toEpochDay2 = bVar.bCv().toEpochDay();
        return toEpochDay > toEpochDay2 || (toEpochDay == toEpochDay2 && bCu().toNanoOfDay() > bVar.bCu().toNanoOfDay());
    }

    public boolean c(b<?> bVar) {
        long toEpochDay = bCv().toEpochDay();
        long toEpochDay2 = bVar.bCv().toEpochDay();
        return toEpochDay < toEpochDay2 || (toEpochDay == toEpochDay2 && bCu().toNanoOfDay() < bVar.bCu().toNanoOfDay());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        if (compareTo((b) obj) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return bCv().hashCode() ^ bCu().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bCv().toString());
        stringBuilder.append('T');
        stringBuilder.append(bCu().toString());
        return stringBuilder.toString();
    }
}
