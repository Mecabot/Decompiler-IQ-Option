package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.c;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;

public final class OffsetTime extends c implements Serializable, Comparable<OffsetTime>, a, org.threeten.bp.temporal.c {
    public static final g<OffsetTime> FROM = new g<OffsetTime>() {
        /* renamed from: q */
        public OffsetTime b(b bVar) {
            return OffsetTime.p(bVar);
        }
    };
    public static final OffsetTime fdU = LocalTime.fdK.b(ZoneOffset.feb);
    public static final OffsetTime fdV = LocalTime.fdL.b(ZoneOffset.fea);
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    public static OffsetTime a(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    public static OffsetTime p(b bVar) {
        if (bVar instanceof OffsetTime) {
            return (OffsetTime) bVar;
        }
        try {
            return new OffsetTime(LocalTime.i(bVar), ZoneOffset.x(bVar));
        } catch (DateTimeException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain OffsetTime from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        this.time = (LocalTime) d.requireNonNull(localTime, "time");
        this.offset = (ZoneOffset) d.requireNonNull(zoneOffset, "offset");
    }

    private OffsetTime b(LocalTime localTime, ZoneOffset zoneOffset) {
        if (this.time == localTime && this.offset.equals(zoneOffset)) {
            return this;
        }
        return new OffsetTime(localTime, zoneOffset);
    }

    public boolean isSupported(e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar.isTimeBased() || eVar == ChronoField.OFFSET_SECONDS)) {
                z = false;
            }
            return z;
        }
        if (eVar == null || !eVar.isSupportedBy(this)) {
            z = false;
        }
        return z;
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (eVar == ChronoField.OFFSET_SECONDS) {
            return eVar.range();
        }
        return this.time.range(eVar);
    }

    public int get(e eVar) {
        return super.get(eVar);
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        if (eVar == ChronoField.OFFSET_SECONDS) {
            return (long) bCw().getTotalSeconds();
        }
        return this.time.getLong(eVar);
    }

    public ZoneOffset bCw() {
        return this.offset;
    }

    /* renamed from: i */
    public OffsetTime b(org.threeten.bp.temporal.c cVar) {
        if (cVar instanceof LocalTime) {
            return b((LocalTime) cVar, this.offset);
        }
        if (cVar instanceof ZoneOffset) {
            return b(this.time, (ZoneOffset) cVar);
        }
        if (cVar instanceof OffsetTime) {
            return (OffsetTime) cVar;
        }
        return (OffsetTime) cVar.adjustInto(this);
    }

    /* renamed from: i */
    public OffsetTime b(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (OffsetTime) eVar.adjustInto(this, j);
        }
        if (eVar != ChronoField.OFFSET_SECONDS) {
            return b(this.time.b(eVar, j), this.offset);
        }
        return b(this.time, ZoneOffset.mP(((ChronoField) eVar).checkValidIntValue(j)));
    }

    /* renamed from: q */
    public OffsetTime d(long j, h hVar) {
        if (hVar instanceof ChronoUnit) {
            return b(this.time.d(j, hVar), this.offset);
        }
        return (OffsetTime) hVar.addTo(this, j);
    }

    /* renamed from: r */
    public OffsetTime c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        if (gVar == f.bDu() || gVar == f.bDt()) {
            return bCw();
        }
        if (gVar == f.bDw()) {
            return this.time;
        }
        if (gVar == f.bDr() || gVar == f.bDv() || gVar == f.bDq()) {
            return null;
        }
        return super.query(gVar);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).b(ChronoField.OFFSET_SECONDS, (long) bCw().getTotalSeconds());
    }

    public long a(a aVar, h hVar) {
        aVar = p(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        long bCy = aVar.bCy() - bCy();
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return bCy;
            case MICROS:
                return bCy / 1000;
            case MILLIS:
                return bCy / 1000000;
            case SECONDS:
                return bCy / 1000000000;
            case MINUTES:
                return bCy / 60000000000L;
            case HOURS:
                return bCy / 3600000000000L;
            case HALF_DAYS:
                return bCy / 43200000000000L;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private long bCy() {
        return this.time.toNanoOfDay() - (((long) this.offset.getTotalSeconds()) * 1000000000);
    }

    /* renamed from: a */
    public int compareTo(OffsetTime offsetTime) {
        if (this.offset.equals(offsetTime.offset)) {
            return this.time.compareTo(offsetTime.time);
        }
        int C = d.C(bCy(), offsetTime.bCy());
        if (C == 0) {
            C = this.time.compareTo(offsetTime.time);
        }
        return C;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetTime)) {
            return false;
        }
        OffsetTime offsetTime = (OffsetTime) obj;
        if (!(this.time.equals(offsetTime.time) && this.offset.equals(offsetTime.offset))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.time.hashCode() ^ this.offset.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.time.toString());
        stringBuilder.append(this.offset.toString());
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        this.time.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    static OffsetTime h(DataInput dataInput) {
        return a(LocalTime.e(dataInput), ZoneOffset.l(dataInput));
    }
}
