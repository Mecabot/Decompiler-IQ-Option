package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;

public final class ThaiBuddhistChronology extends e implements Serializable {
    private static final HashMap<String, String[]> fej = new HashMap();
    private static final HashMap<String, String[]> fek = new HashMap();
    private static final HashMap<String, String[]> fel = new HashMap();
    public static final ThaiBuddhistChronology fff = new ThaiBuddhistChronology();
    private static final long serialVersionUID = 2775954514031616474L;

    public String getCalendarType() {
        return "buddhist";
    }

    public String getId() {
        return "ThaiBuddhist";
    }

    static {
        fej.put("en", new String[]{"BB", "BE"});
        fej.put("th", new String[]{"BB", "BE"});
        fek.put("en", new String[]{"B.B.", "B.E."});
        fek.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        fel.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        fel.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private ThaiBuddhistChronology() {
    }

    private Object readResolve() {
        return fff;
    }

    public ThaiBuddhistDate S(int i, int i2, int i3) {
        return new ThaiBuddhistDate(LocalDate.F(i - 543, i2, i3));
    }

    /* renamed from: M */
    public ThaiBuddhistDate C(b bVar) {
        if (bVar instanceof ThaiBuddhistDate) {
            return (ThaiBuddhistDate) bVar;
        }
        return new ThaiBuddhistDate(LocalDate.e(bVar));
    }

    public b<ThaiBuddhistDate> D(b bVar) {
        return super.D(bVar);
    }

    public d<ThaiBuddhistDate> E(b bVar) {
        return super.E(bVar);
    }

    public d<ThaiBuddhistDate> d(Instant instant, ZoneId zoneId) {
        return super.d(instant, zoneId);
    }

    public boolean isLeapYear(long j) {
        return IsoChronology.feQ.isLeapYear(j - 543);
    }

    /* renamed from: nj */
    public ThaiBuddhistEra mR(int i) {
        return ThaiBuddhistEra.of(i);
    }

    public ValueRange a(ChronoField chronoField) {
        ValueRange range;
        switch (chronoField) {
            case PROLEPTIC_MONTH:
                range = ChronoField.PROLEPTIC_MONTH.range();
                return ValueRange.G(range.getMinimum() + 6516, range.getMaximum() + 6516);
            case YEAR_OF_ERA:
                range = ChronoField.YEAR.range();
                return ValueRange.a(1, (-(range.getMinimum() + 543)) + 1, range.getMaximum() + 543);
            case YEAR:
                range = ChronoField.YEAR.range();
                return ValueRange.G(range.getMinimum() + 543, range.getMaximum() + 543);
            default:
                return chronoField.range();
        }
    }
}
