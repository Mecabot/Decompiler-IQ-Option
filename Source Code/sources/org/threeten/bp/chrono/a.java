package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.a.b;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

/* compiled from: ChronoLocalDate */
public abstract class a extends b implements Comparable<a>, org.threeten.bp.temporal.a, c {
    private static final Comparator<a> fed = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return d.C(aVar.toEpochDay(), aVar2.toEpochDay());
        }
    };

    public abstract e bCs();

    /* renamed from: d */
    public abstract a b(e eVar, long j);

    /* renamed from: h */
    public abstract a d(long j, h hVar);

    public f bCp() {
        return bCs().mR(get(ChronoField.ERA));
    }

    public boolean isLeapYear() {
        return bCs().isLeapYear(getLong(ChronoField.YEAR));
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isSupported(e eVar) {
        if (eVar instanceof ChronoField) {
            return eVar.isDateBased();
        }
        boolean z = eVar != null && eVar.isSupportedBy(this);
        return z;
    }

    /* renamed from: d */
    public a b(c cVar) {
        return bCs().a(super.b(cVar));
    }

    /* renamed from: g */
    public a c(long j, h hVar) {
        return bCs().a(super.c(j, hVar));
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return bCs();
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.DAYS;
        }
        if (gVar == f.bDv()) {
            return LocalDate.dr(toEpochDay());
        }
        return (gVar == f.bDw() || gVar == f.bDt() || gVar == f.bDq() || gVar == f.bDu()) ? null : super.query(gVar);
    }

    public org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a aVar) {
        return aVar.b(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public b<?> b(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.a(this, localTime);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        int C = d.C(toEpochDay(), aVar.toEpochDay());
        return C == 0 ? bCs().compareTo(aVar.bCs()) : C;
    }

    public boolean b(a aVar) {
        return toEpochDay() > aVar.toEpochDay();
    }

    public boolean c(a aVar) {
        return toEpochDay() < aVar.toEpochDay();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        if (compareTo((a) obj) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long toEpochDay = toEpochDay();
        return ((int) (toEpochDay ^ (toEpochDay >>> 32))) ^ bCs().hashCode();
    }

    public String toString() {
        long j = getLong(ChronoField.YEAR_OF_ERA);
        long j2 = getLong(ChronoField.MONTH_OF_YEAR);
        long j3 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append(bCs().toString());
        stringBuilder.append(" ");
        stringBuilder.append(bCp());
        stringBuilder.append(" ");
        stringBuilder.append(j);
        stringBuilder.append(j2 < 10 ? "-0" : "-");
        stringBuilder.append(j2);
        stringBuilder.append(j3 < 10 ? "-0" : "-");
        stringBuilder.append(j3);
        return stringBuilder.toString();
    }
}
