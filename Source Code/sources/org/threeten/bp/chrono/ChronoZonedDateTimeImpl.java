package org.threeten.bp.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.h;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

final class ChronoZonedDateTimeImpl<D extends a> extends d<D> implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    static <R extends a> d<R> a(ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        d.requireNonNull(chronoLocalDateTimeImpl, "localDateTime");
        d.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl2;
        ZoneRules bCz = zoneId.bCz();
        LocalDateTime g = LocalDateTime.g(chronoLocalDateTimeImpl2);
        List d = bCz.d(g);
        if (d.size() == 1) {
            zoneOffset = (ZoneOffset) d.get(0);
        } else if (d.size() == 0) {
            ZoneOffsetTransition e = bCz.e(g);
            chronoLocalDateTimeImpl2 = chronoLocalDateTimeImpl2.dS(e.getDuration().getSeconds());
            zoneOffset = e.bDB();
        } else if (zoneOffset == null || !d.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) d.get(0);
        }
        d.requireNonNull(zoneOffset, "offset");
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl2, zoneOffset, zoneId);
    }

    static <R extends a> ChronoZonedDateTimeImpl<R> a(e eVar, Instant instant, ZoneId zoneId) {
        ZoneOffset d = zoneId.bCz().d(instant);
        d.requireNonNull(d, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) eVar.D(LocalDateTime.a(instant.getEpochSecond(), instant.getNano(), d)), d, zoneId);
    }

    private ChronoZonedDateTimeImpl<D> c(Instant instant, ZoneId zoneId) {
        return a(bCv().bCs(), instant, zoneId);
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = (ChronoLocalDateTimeImpl) d.requireNonNull(chronoLocalDateTimeImpl, "dateTime");
        this.offset = (ZoneOffset) d.requireNonNull(zoneOffset, "offset");
        this.zone = (ZoneId) d.requireNonNull(zoneId, "zone");
    }

    public ZoneOffset bCw() {
        return this.offset;
    }

    public b<D> bCD() {
        return this.dateTime;
    }

    public ZoneId bCB() {
        return this.zone;
    }

    public d<D> f(ZoneId zoneId) {
        return a(this.dateTime, zoneId, this.offset);
    }

    public d<D> e(ZoneId zoneId) {
        d.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : c(this.dateTime.f(this.offset), zoneId);
    }

    public boolean isSupported(e eVar) {
        return (eVar instanceof ChronoField) || (eVar != null && eVar.isSupportedBy(this));
    }

    /* renamed from: m */
    public d<D> b(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return bCv().bCs().c(eVar.adjustInto(this, j));
        }
        ChronoField chronoField = (ChronoField) eVar;
        switch (chronoField) {
            case INSTANT_SECONDS:
                return d(j - toEpochSecond(), ChronoUnit.SECONDS);
            case OFFSET_SECONDS:
                return c(this.dateTime.f(ZoneOffset.mP(chronoField.checkValidIntValue(j))), this.zone);
            default:
                return a(this.dateTime.f(eVar, j), this.zone, this.offset);
        }
    }

    /* renamed from: z */
    public d<D> d(long j, h hVar) {
        if (hVar instanceof ChronoUnit) {
            return b(this.dateTime.l(j, hVar));
        }
        return bCv().bCs().c(hVar.addTo(this, j));
    }

    public long a(a aVar, h hVar) {
        aVar = bCv().bCs().E(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        return this.dateTime.a(aVar.e(this.offset).bCD(), hVar);
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.dateTime);
        objectOutput.writeObject(this.offset);
        objectOutput.writeObject(this.zone);
    }

    static d<?> b(ObjectInput objectInput) {
        b bVar = (b) objectInput.readObject();
        ZoneId zoneId = (ZoneOffset) objectInput.readObject();
        return bVar.b(zoneId).f((ZoneId) objectInput.readObject());
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
