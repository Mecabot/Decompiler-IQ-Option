package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;

public final class HijrahChronology extends e implements Serializable {
    public static final HijrahChronology fei = new HijrahChronology();
    private static final HashMap<String, String[]> fej = new HashMap();
    private static final HashMap<String, String[]> fek = new HashMap();
    private static final HashMap<String, String[]> fel = new HashMap();
    private static final long serialVersionUID = 3127340209035924785L;

    public String getCalendarType() {
        return "islamic-umalqura";
    }

    public String getId() {
        return "Hijrah-umalqura";
    }

    static {
        fej.put("en", new String[]{"BH", "HE"});
        fek.put("en", new String[]{"B.H.", "H.E."});
        fel.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private HijrahChronology() {
    }

    private Object readResolve() {
        return fei;
    }

    public HijrahDate K(int i, int i2, int i3) {
        return HijrahDate.L(i, i2, i3);
    }

    /* renamed from: G */
    public HijrahDate C(b bVar) {
        if (bVar instanceof HijrahDate) {
            return (HijrahDate) bVar;
        }
        return HijrahDate.dU(bVar.getLong(ChronoField.EPOCH_DAY));
    }

    public b<HijrahDate> D(b bVar) {
        return super.D(bVar);
    }

    public d<HijrahDate> E(b bVar) {
        return super.E(bVar);
    }

    public d<HijrahDate> d(Instant instant, ZoneId zoneId) {
        return super.d(instant, zoneId);
    }

    public boolean isLeapYear(long j) {
        return HijrahDate.isLeapYear(j);
    }

    /* renamed from: mS */
    public HijrahEra mR(int i) {
        switch (i) {
            case 0:
                return HijrahEra.BEFORE_AH;
            case 1:
                return HijrahEra.AH;
            default:
                throw new DateTimeException("invalid Hijrah era");
        }
    }

    public ValueRange a(ChronoField chronoField) {
        return chronoField.range();
    }
}
