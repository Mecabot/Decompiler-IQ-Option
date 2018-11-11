package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;

public final class MinguoChronology extends e implements Serializable {
    public static final MinguoChronology ffe = new MinguoChronology();
    private static final long serialVersionUID = 1039765215346859963L;

    public String getCalendarType() {
        return "roc";
    }

    public String getId() {
        return "Minguo";
    }

    private MinguoChronology() {
    }

    private Object readResolve() {
        return ffe;
    }

    public MinguoDate R(int i, int i2, int i3) {
        return new MinguoDate(LocalDate.F(i + 1911, i2, i3));
    }

    /* renamed from: L */
    public MinguoDate C(b bVar) {
        if (bVar instanceof MinguoDate) {
            return (MinguoDate) bVar;
        }
        return new MinguoDate(LocalDate.e(bVar));
    }

    public b<MinguoDate> D(b bVar) {
        return super.D(bVar);
    }

    public d<MinguoDate> E(b bVar) {
        return super.E(bVar);
    }

    public d<MinguoDate> d(Instant instant, ZoneId zoneId) {
        return super.d(instant, zoneId);
    }

    public boolean isLeapYear(long j) {
        return IsoChronology.feQ.isLeapYear(j + 1911);
    }

    /* renamed from: ni */
    public MinguoEra mR(int i) {
        return MinguoEra.of(i);
    }

    public ValueRange a(ChronoField chronoField) {
        ValueRange range;
        switch (chronoField) {
            case PROLEPTIC_MONTH:
                range = ChronoField.PROLEPTIC_MONTH.range();
                return ValueRange.G(range.getMinimum() - 22932, range.getMaximum() - 22932);
            case YEAR_OF_ERA:
                range = ChronoField.YEAR.range();
                return ValueRange.a(1, range.getMaximum() - 1911, ((-range.getMinimum()) + 1) + 1911);
            case YEAR:
                range = ChronoField.YEAR.range();
                return ValueRange.G(range.getMinimum() - 1911, range.getMaximum() - 1911);
            default:
                return chronoField.range();
        }
    }
}
