package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

public final class ZonedDateTime extends d<LocalDate> implements Serializable, a {
    public static final g<ZonedDateTime> FROM = new g<ZonedDateTime>() {
        /* renamed from: A */
        public ZonedDateTime b(b bVar) {
            return ZonedDateTime.z(bVar);
        }
    };
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public static ZonedDateTime a(LocalDateTime localDateTime, ZoneId zoneId) {
        return a(localDateTime, zoneId, null);
    }

    public static ZonedDateTime a(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        org.threeten.bp.a.d.requireNonNull(localDateTime, "localDateTime");
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules bCz = zoneId.bCz();
        List d = bCz.d(localDateTime);
        if (d.size() == 1) {
            zoneOffset = (ZoneOffset) d.get(0);
        } else if (d.size() == 0) {
            ZoneOffsetTransition e = bCz.e(localDateTime);
            localDateTime = localDateTime.dB(e.getDuration().getSeconds());
            zoneOffset = e.bDB();
        } else if (zoneOffset == null || !d.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) org.threeten.bp.a.d.requireNonNull(d.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime b(Instant instant, ZoneId zoneId) {
        org.threeten.bp.a.d.requireNonNull(instant, "instant");
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        return a(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    public static ZonedDateTime a(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        org.threeten.bp.a.d.requireNonNull(localDateTime, "localDateTime");
        org.threeten.bp.a.d.requireNonNull(zoneOffset, "offset");
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        return a(localDateTime.g(zoneOffset), localDateTime.getNano(), zoneId);
    }

    private static ZonedDateTime a(long j, int i, ZoneId zoneId) {
        ZoneOffset d = zoneId.bCz().d(Instant.A(j, (long) i));
        return new ZonedDateTime(LocalDateTime.a(j, i, d), d, zoneId);
    }

    private static ZonedDateTime b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        org.threeten.bp.a.d.requireNonNull(localDateTime, "localDateTime");
        org.threeten.bp.a.d.requireNonNull(zoneOffset, "offset");
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime z(b bVar) {
        if (bVar instanceof ZonedDateTime) {
            return (ZonedDateTime) bVar;
        }
        try {
            ZoneId v = ZoneId.v(bVar);
            if (bVar.isSupported(ChronoField.INSTANT_SECONDS)) {
                return a(bVar.getLong(ChronoField.INSTANT_SECONDS), bVar.get(ChronoField.NANO_OF_SECOND), v);
            }
            try {
            } catch (DateTimeException unused) {
                return a(LocalDateTime.g(bVar), v);
            }
        } catch (DateTimeException unused2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain ZonedDateTime from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private ZonedDateTime b(LocalDateTime localDateTime) {
        return a(localDateTime, this.zone, this.offset);
    }

    private ZonedDateTime c(LocalDateTime localDateTime) {
        return a(localDateTime, this.offset, this.zone);
    }

    private ZonedDateTime e(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.bCz().c(this.dateTime, zoneOffset)) ? this : new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
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

    public ZoneId bCB() {
        return this.zone;
    }

    /* renamed from: c */
    public ZonedDateTime f(ZoneId zoneId) {
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : a(this.dateTime, zoneId, this.offset);
    }

    /* renamed from: d */
    public ZonedDateTime e(ZoneId zoneId) {
        org.threeten.bp.a.d.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : a(this.dateTime.g(this.offset), this.dateTime.getNano(), zoneId);
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    /* renamed from: l */
    public ZonedDateTime m(c cVar) {
        if (cVar instanceof LocalDate) {
            return b(LocalDateTime.a((LocalDate) cVar, this.dateTime.bCu()));
        }
        if (cVar instanceof LocalTime) {
            return b(LocalDateTime.a(this.dateTime.bCv(), (LocalTime) cVar));
        }
        if (cVar instanceof LocalDateTime) {
            return b((LocalDateTime) cVar);
        }
        if (cVar instanceof Instant) {
            Instant instant = (Instant) cVar;
            return a(instant.getEpochSecond(), instant.getNano(), this.zone);
        } else if (cVar instanceof ZoneOffset) {
            return e((ZoneOffset) cVar);
        } else {
            return (ZonedDateTime) cVar.adjustInto(this);
        }
    }

    /* renamed from: l */
    public ZonedDateTime m(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (ZonedDateTime) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        switch (chronoField) {
            case INSTANT_SECONDS:
                return a(j, getNano(), this.zone);
            case OFFSET_SECONDS:
                return e(ZoneOffset.mP(chronoField.checkValidIntValue(j)));
            default:
                return b(this.dateTime.f(eVar, j));
        }
    }

    /* renamed from: w */
    public ZonedDateTime z(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (ZonedDateTime) hVar.addTo(this, j);
        }
        if (hVar.isDateBased()) {
            return b(this.dateTime.l(j, hVar));
        }
        return c(this.dateTime.l(j, hVar));
    }

    /* renamed from: x */
    public ZonedDateTime y(long j, h hVar) {
        return j == Long.MIN_VALUE ? z(Long.MAX_VALUE, hVar).z(1, hVar) : z(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDv()) {
            return bCv();
        }
        return super.query(gVar);
    }

    public long a(a aVar, h hVar) {
        aVar = z(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        ZonedDateTime d = aVar.e(this.zone);
        if (hVar.isDateBased()) {
            return this.dateTime.a(d.dateTime, hVar);
        }
        return bCC().a(d.bCC(), hVar);
    }

    /* renamed from: bCx */
    public LocalDateTime bCD() {
        return this.dateTime;
    }

    /* renamed from: bCt */
    public LocalDate bCv() {
        return this.dateTime.bCv();
    }

    public LocalTime bCu() {
        return this.dateTime.bCu();
    }

    public OffsetDateTime bCC() {
        return OffsetDateTime.a(this.dateTime, this.offset);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        if (!(this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dateTime.toString());
        stringBuilder.append(this.offset.toString());
        String stringBuilder2 = stringBuilder.toString();
        if (this.offset == this.zone) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append('[');
        stringBuilder3.append(this.zone.toString());
        stringBuilder3.append(']');
        return stringBuilder3.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
        this.zone.write(dataOutput);
    }

    static ZonedDateTime n(DataInput dataInput) {
        return b(LocalDateTime.d(dataInput), ZoneOffset.l(dataInput), (ZoneId) Ser.i(dataInput));
    }
}
