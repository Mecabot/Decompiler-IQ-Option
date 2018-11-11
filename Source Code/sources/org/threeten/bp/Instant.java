package org.threeten.bp;

import com.iqoption.dto.ChartTimeInterval;
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

public final class Instant extends c implements Serializable, Comparable<Instant>, a, org.threeten.bp.temporal.c {
    public static final g<Instant> FROM = new g<Instant>() {
        /* renamed from: d */
        public Instant b(b bVar) {
            return Instant.c(bVar);
        }
    };
    public static final Instant fdB = new Instant(0, 0);
    public static final Instant fdC = A(-31557014167219200L, 0);
    public static final Instant fdD = A(31556889864403199L, 999999999);
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    public static Instant A(long j, long j2) {
        return g(d.D(j, d.floorDiv(j2, 1000000000)), d.k(j2, 1000000000));
    }

    public static Instant c(b bVar) {
        try {
            return A(bVar.getLong(ChronoField.INSTANT_SECONDS), (long) bVar.get(ChronoField.NANO_OF_SECOND));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain Instant from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString(), e);
        }
    }

    private static Instant g(long j, int i) {
        if ((j | ((long) i)) == 0) {
            return fdB;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    private Instant(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public boolean isSupported(e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar == ChronoField.INSTANT_SECONDS || eVar == ChronoField.NANO_OF_SECOND || eVar == ChronoField.MICRO_OF_SECOND || eVar == ChronoField.MILLI_OF_SECOND)) {
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
        return super.range(eVar);
    }

    public int get(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return range(eVar).b(eVar.getFrom(this), eVar);
        }
        switch ((ChronoField) eVar) {
            case NANO_OF_SECOND:
                return this.nanos;
            case MICRO_OF_SECOND:
                return this.nanos / 1000;
            case MILLI_OF_SECOND:
                return this.nanos / 1000000;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        switch ((ChronoField) eVar) {
            case NANO_OF_SECOND:
                return (long) this.nanos;
            case MICRO_OF_SECOND:
                return (long) (this.nanos / 1000);
            case MILLI_OF_SECOND:
                return (long) (this.nanos / 1000000);
            case INSTANT_SECONDS:
                return this.seconds;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    /* renamed from: a */
    public Instant b(org.threeten.bp.temporal.c cVar) {
        return (Instant) cVar.adjustInto(this);
    }

    /* renamed from: a */
    public Instant b(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (Instant) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        int i;
        switch (chronoField) {
            case NANO_OF_SECOND:
                return j != ((long) this.nanos) ? g(this.seconds, (int) j) : this;
            case MICRO_OF_SECOND:
                i = ((int) j) * 1000;
                return i != this.nanos ? g(this.seconds, i) : this;
            case MILLI_OF_SECOND:
                i = ((int) j) * 1000000;
                return i != this.nanos ? g(this.seconds, i) : this;
            case INSTANT_SECONDS:
                return j != this.seconds ? g(j, this.nanos) : this;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public Instant d(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (Instant) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return dq(j);
            case MICROS:
                return B(j / 1000000, (j % 1000000) * 1000);
            case MILLIS:
                return dp(j);
            case SECONDS:
                return do(j);
            case MINUTES:
                return do(d.j(j, 60));
            case HOURS:
                return do(d.j(j, ChartTimeInterval.CANDLE_1H));
            case HALF_DAYS:
                return do(d.j(j, ChartTimeInterval.CANDLE_12H));
            case DAYS:
                return do(d.j(j, ChartTimeInterval.CANDLE_1D));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public Instant do(long j) {
        return B(j, 0);
    }

    public Instant dp(long j) {
        return B(j / 1000, (j % 1000) * 1000000);
    }

    public Instant dq(long j) {
        return B(0, j);
    }

    private Instant B(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return A(d.D(d.D(this.seconds, j), j2 / 1000000000), ((long) this.nanos) + (j2 % 1000000000));
    }

    /* renamed from: b */
    public Instant c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDs()) {
            return ChronoUnit.NANOS;
        }
        return (gVar == f.bDv() || gVar == f.bDw() || gVar == f.bDr() || gVar == f.bDq() || gVar == f.bDt() || gVar == f.bDu()) ? null : gVar.b(this);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.INSTANT_SECONDS, this.seconds).b(ChronoField.NANO_OF_SECOND, (long) this.nanos);
    }

    public long a(a aVar, h hVar) {
        Instant c = c((b) aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, c);
        }
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return a(c);
            case MICROS:
                return a(c) / 1000;
            case MILLIS:
                return d.E(c.toEpochMilli(), toEpochMilli());
            case SECONDS:
                return b(c);
            case MINUTES:
                return b(c) / 60;
            case HOURS:
                return b(c) / 3600;
            case HALF_DAYS:
                return b(c) / 43200;
            case DAYS:
                return b(c) / 86400;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append(hVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private long a(Instant instant) {
        return d.D(d.j(d.E(instant.seconds, this.seconds), 1000000000), (long) (instant.nanos - this.nanos));
    }

    private long b(Instant instant) {
        long E = d.E(instant.seconds, this.seconds);
        long j = (long) (instant.nanos - this.nanos);
        if (E <= 0 || j >= 0) {
            return (E >= 0 || j <= 0) ? E : E + 1;
        } else {
            return E - 1;
        }
    }

    public long toEpochMilli() {
        if (this.seconds >= 0) {
            return d.D(d.F(this.seconds, 1000), (long) (this.nanos / 1000000));
        }
        return d.E(d.F(this.seconds + 1, 1000), 1000 - ((long) (this.nanos / 1000000)));
    }

    /* renamed from: c */
    public int compareTo(Instant instant) {
        int C = d.C(this.seconds, instant.seconds);
        if (C != 0) {
            return C;
        }
        return this.nanos - instant.nanos;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        if (!(this.seconds == instant.seconds && this.nanos == instant.nanos)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((int) (this.seconds ^ (this.seconds >>> 32))) + (this.nanos * 51);
    }

    public String toString() {
        return org.threeten.bp.format.b.ffw.N(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    static Instant b(DataInput dataInput) {
        return A(dataInput.readLong(), (long) dataInput.readInt());
    }
}
