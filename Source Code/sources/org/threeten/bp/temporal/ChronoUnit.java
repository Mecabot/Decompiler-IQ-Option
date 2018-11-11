package org.threeten.bp.temporal;

import org.threeten.bp.Duration;
import org.threeten.bp.chrono.a;
import org.threeten.bp.chrono.b;
import org.threeten.bp.chrono.d;

public enum ChronoUnit implements h {
    NANOS("Nanos", Duration.dm(1)),
    MICROS("Micros", Duration.dm(1000)),
    MILLIS("Millis", Duration.dm(1000000)),
    SECONDS("Seconds", Duration.dl(1)),
    MINUTES("Minutes", Duration.dl(60)),
    HOURS("Hours", Duration.dl(3600)),
    HALF_DAYS("HalfDays", Duration.dl(43200)),
    DAYS("Days", Duration.dl(86400)),
    WEEKS("Weeks", Duration.dl(604800)),
    MONTHS("Months", Duration.dl(2629746)),
    YEARS("Years", Duration.dl(31556952)),
    DECADES("Decades", Duration.dl(315569520)),
    CENTURIES("Centuries", Duration.dl(3155695200L)),
    MILLENNIA("Millennia", Duration.dl(31556952000L)),
    ERAS("Eras", Duration.dl(31556952000000000L)),
    FOREVER("Forever", Duration.z(Long.MAX_VALUE, 999999999));
    
    private final Duration duration;
    private final String name;

    private ChronoUnit(String str, Duration duration) {
        this.name = str;
        this.duration = duration;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public boolean isDurationEstimated() {
        return isDateBased() || this == FOREVER;
    }

    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public boolean isTimeBased() {
        return compareTo(DAYS) < 0;
    }

    public boolean isSupportedBy(a aVar) {
        if (this == FOREVER) {
            return false;
        }
        if (aVar instanceof a) {
            return isDateBased();
        }
        if ((aVar instanceof b) || (aVar instanceof d)) {
            return true;
        }
        try {
            aVar.d(1, this);
            return true;
        } catch (RuntimeException unused) {
            try {
                aVar.d(-1, this);
                return true;
            } catch (RuntimeException unused2) {
                return false;
            }
        }
    }

    public <R extends a> R addTo(R r, long j) {
        return r.d(j, this);
    }

    public long between(a aVar, a aVar2) {
        return aVar.a(aVar2, this);
    }

    public String toString() {
        return this.name;
    }
}
