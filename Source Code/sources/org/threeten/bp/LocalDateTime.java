package org.threeten.bp;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.b;
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

public final class LocalDateTime extends b<LocalDate> implements Serializable, a, c {
    public static final g<LocalDateTime> FROM = new g<LocalDateTime>() {
        /* renamed from: h */
        public LocalDateTime b(org.threeten.bp.temporal.b bVar) {
            return LocalDateTime.g(bVar);
        }
    };
    public static final LocalDateTime fdI = a(LocalDate.fdG, LocalTime.fdK);
    public static final LocalDateTime fdJ = a(LocalDate.fdH, LocalTime.fdL);
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;

    public static LocalDateTime a(LocalDate localDate, LocalTime localTime) {
        d.requireNonNull(localDate, "date");
        d.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime a(long j, int i, ZoneOffset zoneOffset) {
        d.requireNonNull(zoneOffset, "offset");
        long totalSeconds = j + ((long) zoneOffset.getTotalSeconds());
        return new LocalDateTime(LocalDate.dr(d.floorDiv(totalSeconds, 86400)), LocalTime.h((long) d.k(totalSeconds, ChartTimeInterval.CANDLE_1D), i));
    }

    public static LocalDateTime g(org.threeten.bp.temporal.b bVar) {
        if (bVar instanceof LocalDateTime) {
            return (LocalDateTime) bVar;
        }
        if (bVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) bVar).bCD();
        }
        try {
            return new LocalDateTime(LocalDate.e(bVar), LocalTime.i(bVar));
        } catch (DateTimeException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            stringBuilder.append(bVar);
            stringBuilder.append(", type ");
            stringBuilder.append(bVar.getClass().getName());
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private LocalDateTime b(LocalDate localDate, LocalTime localTime) {
        if (this.date == localDate && this.time == localTime) {
            return this;
        }
        return new LocalDateTime(localDate, localTime);
    }

    public boolean isSupported(e eVar) {
        boolean z = true;
        if (eVar instanceof ChronoField) {
            if (!(eVar.isDateBased() || eVar.isTimeBased())) {
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
        return eVar.isTimeBased() ? this.time.range(eVar) : this.date.range(eVar);
    }

    public int get(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return super.get(eVar);
        }
        return eVar.isTimeBased() ? this.time.get(eVar) : this.date.get(eVar);
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        return eVar.isTimeBased() ? this.time.getLong(eVar) : this.date.getLong(eVar);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getNano() {
        return this.time.getNano();
    }

    /* renamed from: e */
    public LocalDateTime f(c cVar) {
        if (cVar instanceof LocalDate) {
            return b((LocalDate) cVar, this.time);
        }
        if (cVar instanceof LocalTime) {
            return b(this.date, (LocalTime) cVar);
        }
        if (cVar instanceof LocalDateTime) {
            return (LocalDateTime) cVar;
        }
        return (LocalDateTime) cVar.adjustInto(this);
    }

    /* renamed from: e */
    public LocalDateTime f(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (LocalDateTime) eVar.adjustInto(this, j);
        }
        if (eVar.isTimeBased()) {
            return b(this.date, this.time.b(eVar, j));
        }
        return b(this.date.d(eVar, j), this.time);
    }

    /* renamed from: i */
    public LocalDateTime l(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (LocalDateTime) hVar.addTo(this, j);
        }
        switch ((ChronoUnit) hVar) {
            case NANOS:
                return dC(j);
            case MICROS:
                return dy(j / 86400000000L).dC((j % 86400000000L) * 1000);
            case MILLIS:
                return dy(j / 86400000).dC((j % 86400000) * 1000000);
            case SECONDS:
                return dB(j);
            case MINUTES:
                return dA(j);
            case HOURS:
                return dz(j);
            case HALF_DAYS:
                return dy(j / 256).dz((j % 256) * 12);
            default:
                return b(this.date.h(j, hVar), this.time);
        }
    }

    public LocalDateTime dy(long j) {
        return b(this.date.dv(j), this.time);
    }

    public LocalDateTime dz(long j) {
        return a(this.date, j, 0, 0, 0, 1);
    }

    public LocalDateTime dA(long j) {
        return a(this.date, 0, j, 0, 0, 1);
    }

    public LocalDateTime dB(long j) {
        return a(this.date, 0, 0, j, 0, 1);
    }

    public LocalDateTime dC(long j) {
        return a(this.date, 0, 0, 0, j, 1);
    }

    /* renamed from: j */
    public LocalDateTime k(long j, h hVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, hVar).l(1, hVar) : l(-j, hVar);
    }

    private LocalDateTime a(LocalDate localDate, long j, long j2, long j3, long j4, int i) {
        LocalDate localDate2 = localDate;
        if ((((j | j2) | j3) | j4) == 0) {
            return b(localDate2, this.time);
        }
        long j5 = (long) i;
        long j6 = ((((j4 / 86400000000000L) + (j3 / 86400)) + (j2 / 1440)) + (j / 24)) * j5;
        long j7 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000)) + ((j2 % 1440) * 60000000000L)) + ((j % 24) * 3600000000000L);
        long toNanoOfDay = this.time.toNanoOfDay();
        long j8 = (j7 * j5) + toNanoOfDay;
        long floorDiv = j6 + d.floorDiv(j8, 86400000000000L);
        j7 = d.floorMod(j8, 86400000000000L);
        return b(localDate2.dv(floorDiv), j7 == toNanoOfDay ? this.time : LocalTime.dE(j7));
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDv()) {
            return bCv();
        }
        return super.query(gVar);
    }

    public a adjustInto(a aVar) {
        return super.adjustInto(aVar);
    }

    public long a(a aVar, h hVar) {
        aVar = g(aVar);
        if (!(hVar instanceof ChronoUnit)) {
            return hVar.between(this, aVar);
        }
        ChronoUnit chronoUnit = (ChronoUnit) hVar;
        if (chronoUnit.isTimeBased()) {
            long j;
            long j2;
            long a = this.date.a(aVar.date);
            long toNanoOfDay = aVar.time.toNanoOfDay() - this.time.toNanoOfDay();
            if (a > 0 && toNanoOfDay < 0) {
                j = a - 1;
                j2 = toNanoOfDay + 86400000000000L;
            } else if (a >= 0 || toNanoOfDay <= 0) {
                j = a;
                j2 = toNanoOfDay;
            } else {
                j = a + 1;
                j2 = toNanoOfDay - 86400000000000L;
            }
            switch (chronoUnit) {
                case NANOS:
                    return d.D(d.F(j, 86400000000000L), j2);
                case MICROS:
                    return d.D(d.F(j, 86400000000L), j2 / 1000);
                case MILLIS:
                    return d.D(d.F(j, 86400000), j2 / 1000000);
                case SECONDS:
                    return d.D(d.j(j, ChartTimeInterval.CANDLE_1D), j2 / 1000000000);
                case MINUTES:
                    return d.D(d.j(j, 1440), j2 / 60000000000L);
                case HOURS:
                    return d.D(d.j(j, 24), j2 / 3600000000000L);
                case HALF_DAYS:
                    return d.D(d.j(j, 2), j2 / 43200000000000L);
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported unit: ");
                    stringBuilder.append(hVar);
                    throw new UnsupportedTemporalTypeException(stringBuilder.toString());
            }
        }
        a aVar2 = aVar.date;
        if (aVar2.b(this.date) && aVar.time.e(this.time)) {
            aVar2 = aVar2.dx(1);
        } else if (aVar2.c(this.date) && aVar.time.d(this.time)) {
            aVar2 = aVar2.dv(1);
        }
        return this.date.a(aVar2, hVar);
    }

    public OffsetDateTime a(ZoneOffset zoneOffset) {
        return OffsetDateTime.a(this, zoneOffset);
    }

    /* renamed from: a */
    public ZonedDateTime b(ZoneId zoneId) {
        return ZonedDateTime.a(this, zoneId);
    }

    /* renamed from: bCt */
    public LocalDate bCv() {
        return this.date;
    }

    public LocalTime bCu() {
        return this.time;
    }

    /* renamed from: a */
    public int compareTo(b<?> bVar) {
        if (bVar instanceof LocalDateTime) {
            return a((LocalDateTime) bVar);
        }
        return super.compareTo(bVar);
    }

    private int a(LocalDateTime localDateTime) {
        int c = this.date.c(localDateTime.bCv());
        return c == 0 ? this.time.compareTo(localDateTime.bCu()) : c;
    }

    public boolean b(b<?> bVar) {
        if (!(bVar instanceof LocalDateTime)) {
            return super.b((b) bVar);
        }
        return a((LocalDateTime) bVar) > 0;
    }

    public boolean c(b<?> bVar) {
        if (!(bVar instanceof LocalDateTime)) {
            return super.c(bVar);
        }
        return a((LocalDateTime) bVar) < 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        if (!(this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.date.toString());
        stringBuilder.append('T');
        stringBuilder.append(this.time.toString());
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput dataOutput) {
        this.date.writeExternal(dataOutput);
        this.time.writeExternal(dataOutput);
    }

    static LocalDateTime d(DataInput dataInput) {
        return a(LocalDate.c(dataInput), LocalTime.e(dataInput));
    }
}
