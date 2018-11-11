package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.b;

public final class IsoChronology extends e implements Serializable {
    public static final IsoChronology feQ = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    public String getCalendarType() {
        return "iso8601";
    }

    public String getId() {
        return "ISO";
    }

    private IsoChronology() {
    }

    private Object readResolve() {
        return feQ;
    }

    /* renamed from: H */
    public LocalDate C(b bVar) {
        return LocalDate.e(bVar);
    }

    /* renamed from: I */
    public LocalDateTime D(b bVar) {
        return LocalDateTime.g(bVar);
    }

    /* renamed from: J */
    public ZonedDateTime E(b bVar) {
        return ZonedDateTime.z(bVar);
    }

    /* renamed from: e */
    public ZonedDateTime d(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.b(instant, zoneId);
    }

    public boolean isLeapYear(long j) {
        return (j & 3) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    /* renamed from: nc */
    public IsoEra mR(int i) {
        return IsoEra.of(i);
    }
}
