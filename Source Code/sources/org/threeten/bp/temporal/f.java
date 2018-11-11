package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.e;

/* compiled from: TemporalQueries */
public final class f {
    static final g<ZoneId> fgL = new g<ZoneId>() {
        /* renamed from: w */
        public ZoneId b(b bVar) {
            return (ZoneId) bVar.query(this);
        }
    };
    static final g<e> fgM = new g<e>() {
        /* renamed from: F */
        public e b(b bVar) {
            return (e) bVar.query(this);
        }
    };
    static final g<h> fgN = new g<h>() {
        /* renamed from: Q */
        public h b(b bVar) {
            return (h) bVar.query(this);
        }
    };
    static final g<ZoneId> fgO = new g<ZoneId>() {
        /* renamed from: w */
        public ZoneId b(b bVar) {
            ZoneId zoneId = (ZoneId) bVar.query(f.fgL);
            return zoneId != null ? zoneId : (ZoneId) bVar.query(f.fgP);
        }
    };
    static final g<ZoneOffset> fgP = new g<ZoneOffset>() {
        /* renamed from: y */
        public ZoneOffset b(b bVar) {
            return bVar.isSupported(ChronoField.OFFSET_SECONDS) ? ZoneOffset.mP(bVar.get(ChronoField.OFFSET_SECONDS)) : null;
        }
    };
    static final g<LocalDate> fgQ = new g<LocalDate>() {
        /* renamed from: f */
        public LocalDate b(b bVar) {
            return bVar.isSupported(ChronoField.EPOCH_DAY) ? LocalDate.dr(bVar.getLong(ChronoField.EPOCH_DAY)) : null;
        }
    };
    static final g<LocalTime> fgR = new g<LocalTime>() {
        /* renamed from: j */
        public LocalTime b(b bVar) {
            return bVar.isSupported(ChronoField.NANO_OF_DAY) ? LocalTime.dE(bVar.getLong(ChronoField.NANO_OF_DAY)) : null;
        }
    };

    public static final g<ZoneId> bDq() {
        return fgL;
    }

    public static final g<e> bDr() {
        return fgM;
    }

    public static final g<h> bDs() {
        return fgN;
    }

    public static final g<ZoneId> bDt() {
        return fgO;
    }

    public static final g<ZoneOffset> bDu() {
        return fgP;
    }

    public static final g<LocalDate> bDv() {
        return fgQ;
    }

    public static final g<LocalTime> bDw() {
        return fgR;
    }
}
