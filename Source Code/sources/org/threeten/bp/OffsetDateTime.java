package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.a.b;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

public final class OffsetDateTime extends b implements Serializable, Comparable<OffsetDateTime>, a, c {
    public static final g<OffsetDateTime> FROM = new g<OffsetDateTime>() {
        /* renamed from: o */
        public OffsetDateTime b(org.threeten.bp.temporal.b bVar) {
            return OffsetDateTime.n(bVar);
        }
    };
    public static final OffsetDateTime fdR = LocalDateTime.fdI.a(ZoneOffset.feb);
    public static final OffsetDateTime fdS = LocalDateTime.fdJ.a(ZoneOffset.fea);
    private static final Comparator<OffsetDateTime> fdT = new Comparator<OffsetDateTime>() {
        /* renamed from: a */
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int C = d.C(offsetDateTime.toEpochSecond(), offsetDateTime2.toEpochSecond());
            return C == 0 ? d.C((long) offsetDateTime.getNano(), (long) offsetDateTime2.getNano()) : C;
        }
    };
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    public static OffsetDateTime a(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime a(Instant instant, ZoneId zoneId) {
        d.requireNonNull(instant, "instant");
        d.requireNonNull(zoneId, "zone");
        ZoneOffset d = zoneId.bCz().d(instant);
        return new OffsetDateTime(LocalDateTime.a(instant.getEpochSecond(), instant.getNano(), d), d);
    }

    /* JADX WARNING: Missing block: B:11:0x001c, code:
            return a(org.threeten.bp.Instant.c(r3), r0);
     */
    public static org.threeten.bp.OffsetDateTime n(org.threeten.bp.temporal.b r3) {
        /*
        r0 = r3 instanceof org.threeten.bp.OffsetDateTime;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r3 = (org.threeten.bp.OffsetDateTime) r3;
        return r3;
    L_0x0007:
        r0 = org.threeten.bp.ZoneOffset.x(r3);	 Catch:{ DateTimeException -> 0x001d }
        r1 = org.threeten.bp.LocalDateTime.g(r3);	 Catch:{ DateTimeException -> 0x0014 }
        r1 = a(r1, r0);	 Catch:{ DateTimeException -> 0x0014 }
        return r1;
    L_0x0014:
        r1 = org.threeten.bp.Instant.c(r3);	 Catch:{ DateTimeException -> 0x001d }
        r0 = a(r1, r0);	 Catch:{ DateTimeException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unable to obtain OffsetDateTime from TemporalAccessor: ";
        r1.append(r2);
        r1.append(r3);
        r2 = ", type ";
        r1.append(r2);
        r3 = r3.getClass();
        r3 = r3.getName();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetDateTime.n(org.threeten.bp.temporal.b):org.threeten.bp.OffsetDateTime");
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.dateTime = (LocalDateTime) d.requireNonNull(localDateTime, "dateTime");
        this.offset = (ZoneOffset) d.requireNonNull(zoneOffset, "offset");
    }

    private OffsetDateTime b(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.dateTime == localDateTime && this.offset.equals(zoneOffset)) {
            return this;
        }
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public boolean isSupported(e eVar) {
        return (eVar instanceof ChronoField) || (eVar != null && eVar.isSupportedBy(this));
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (eVar == ChronoField.INSTANT_SECONDS || eVar == ChronoField.OFFSET_SECONDS) {
            return eVar.range();
        }
        return this.dateTime.range(eVar);
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
                throw new DateTimeException(stringBuilder.toString());
            case OFFSET_SECONDS:
                return bCw().getTotalSeconds();
            default:
                return this.dateTime.get(eVar);
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
                return this.dateTime.getLong(eVar);
        }
    }

    public ZoneOffset bCw() {
        return this.offset;
    }

    public OffsetDateTime c(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset)) {
            return this;
        }
        return new OffsetDateTime(this.dateTime.dB((long) (zoneOffset.getTotalSeconds() - this.offset.getTotalSeconds())), zoneOffset);
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    /* renamed from: h */
    public OffsetDateTime b(c cVar) {
        if ((cVar instanceof LocalDate) || (cVar instanceof LocalTime) || (cVar instanceof LocalDateTime)) {
            return b(this.dateTime.f(cVar), this.offset);
        }
        if (cVar instanceof Instant) {
            return a((Instant) cVar, this.offset);
        }
        if (cVar instanceof ZoneOffset) {
            return b(this.dateTime, (ZoneOffset) cVar);
        }
        if (cVar instanceof OffsetDateTime) {
            return (OffsetDateTime) cVar;
        }
        return (OffsetDateTime) cVar.adjustInto(this);
    }

    /* renamed from: h */
    public OffsetDateTime b(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (OffsetDateTime) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        switch (chronoField) {
            case INSTANT_SECONDS:
                return a(Instant.A(j, (long) getNano()), this.offset);
            case OFFSET_SECONDS:
                return b(this.dateTime, ZoneOffset.mP(chronoField.checkValidIntValue(j)));
            default:
                return b(this.dateTime.f(eVar, j), this.offset);
        }
    }

    /* renamed from: o */
    public OffsetDateTime d(long j, h hVar) {
        if (hVar instanceof ChronoUnit) {
            return b(this.dateTime.l(j, hVar), this.offset);
        }
        return (OffsetDateTime) hVar.addTo(this, j);
    }

    /* renamed from: p */
    public OffsetDateTime c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDr()) {
            return IsoChronology.feQ;
        }
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        if (gVar == f.bDu() || gVar == f.bDt()) {
            return bCw();
        }
        if (gVar == f.bDv()) {
            return bCt();
        }
        if (gVar == f.bDw()) {
            return bCu();
        }
        if (gVar == f.bDq()) {
            return null;
        }
        return super.query(gVar);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.EPOCH_DAY, bCt().toEpochDay()).b(ChronoField.NANO_OF_DAY, bCu().toNanoOfDay()).b(ChronoField.OFFSET_SECONDS, (long) bCw().getTotalSeconds());
    }

    public long a(a aVar, h hVar) {
        aVar = n(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        return this.dateTime.a(aVar.c(this.offset).dateTime, hVar);
    }

    public LocalDateTime bCx() {
        return this.dateTime;
    }

    public LocalDate bCt() {
        return this.dateTime.bCv();
    }

    public LocalTime bCu() {
        return this.dateTime.bCu();
    }

    public long toEpochSecond() {
        return this.dateTime.g(this.offset);
    }

    /* renamed from: a */
    public int compareTo(OffsetDateTime offsetDateTime) {
        if (bCw().equals(offsetDateTime.bCw())) {
            return bCx().compareTo(offsetDateTime.bCx());
        }
        int C = d.C(toEpochSecond(), offsetDateTime.toEpochSecond());
        if (C == 0) {
            C = bCu().getNano() - offsetDateTime.bCu().getNano();
            if (C == 0) {
                C = bCx().compareTo(offsetDateTime.bCx());
            }
        }
        return C;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        if (!(this.dateTime.equals(offsetDateTime.dateTime) && this.offset.equals(offsetDateTime.offset))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dateTime.toString());
        stringBuilder.append(this.offset.toString());
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    static OffsetDateTime g(DataInput dataInput) {
        return a(LocalDateTime.d(dataInput), ZoneOffset.l(dataInput));
    }
}
