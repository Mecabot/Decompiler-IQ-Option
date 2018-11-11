package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.h;

abstract class ChronoDateImpl<D extends a> extends a implements Serializable, a, c {
    private static final long serialVersionUID = 6282433883239719096L;

    abstract ChronoDateImpl<D> dM(long j);

    abstract ChronoDateImpl<D> dN(long j);

    abstract ChronoDateImpl<D> dO(long j);

    ChronoDateImpl() {
    }

    /* renamed from: A */
    public ChronoDateImpl<D> h(long j, h hVar) {
        if (!(hVar instanceof ChronoUnit)) {
            return (ChronoDateImpl) bCs().a(hVar.addTo(this, j));
        }
        switch ((ChronoUnit) hVar) {
            case DAYS:
                return dO(j);
            case WEEKS:
                return dO(d.j(j, 7));
            case MONTHS:
                return dN(j);
            case YEARS:
                return dM(j);
            case DECADES:
                return dM(d.j(j, 10));
            case CENTURIES:
                return dM(d.j(j, 100));
            case MILLENNIA:
                return dM(d.j(j, 1000));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(hVar);
                stringBuilder.append(" not valid for chronology ");
                stringBuilder.append(bCs().getId());
                throw new DateTimeException(stringBuilder.toString());
        }
    }

    public b<?> b(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.a((a) this, localTime);
    }

    public long a(a aVar, h hVar) {
        aVar = bCs().C(aVar);
        if (hVar instanceof ChronoUnit) {
            return LocalDate.e(this).a(aVar, hVar);
        }
        return hVar.between(this, aVar);
    }
}
