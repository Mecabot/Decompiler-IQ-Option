package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;

public final class JapaneseChronology extends e implements Serializable {
    static final Locale feR = new Locale("ja", "JP", "JP");
    public static final JapaneseChronology feS = new JapaneseChronology();
    private static final Map<String, String[]> feT = new HashMap();
    private static final Map<String, String[]> feU = new HashMap();
    private static final Map<String, String[]> feV = new HashMap();
    private static final long serialVersionUID = 459996390165777884L;

    public String getCalendarType() {
        return "japanese";
    }

    public String getId() {
        return "Japanese";
    }

    static {
        feT.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        feT.put("ja", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        feU.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        feU.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        feV.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        feV.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return feS;
    }

    public JapaneseDate Q(int i, int i2, int i3) {
        return new JapaneseDate(LocalDate.F(i, i2, i3));
    }

    /* renamed from: K */
    public JapaneseDate C(b bVar) {
        if (bVar instanceof JapaneseDate) {
            return (JapaneseDate) bVar;
        }
        return new JapaneseDate(LocalDate.e(bVar));
    }

    public b<JapaneseDate> D(b bVar) {
        return super.D(bVar);
    }

    public d<JapaneseDate> E(b bVar) {
        return super.E(bVar);
    }

    public d<JapaneseDate> d(Instant instant, ZoneId zoneId) {
        return super.d(instant, zoneId);
    }

    public boolean isLeapYear(long j) {
        return IsoChronology.feQ.isLeapYear(j);
    }

    public int a(f fVar, int i) {
        if (fVar instanceof JapaneseEra) {
            JapaneseEra japaneseEra = (JapaneseEra) fVar;
            int year = (japaneseEra.bCO().getYear() + i) - 1;
            ValueRange.G(1, (long) ((japaneseEra.bCP().getYear() - japaneseEra.bCO().getYear()) + 1)).a((long) i, ChronoField.YEAR_OF_ERA);
            return year;
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    /* renamed from: nd */
    public JapaneseEra mR(int i) {
        return JapaneseEra.ng(i);
    }

    public ValueRange a(ChronoField chronoField) {
        switch (chronoField) {
            case DAY_OF_MONTH:
            case DAY_OF_WEEK:
            case MICRO_OF_DAY:
            case MICRO_OF_SECOND:
            case HOUR_OF_DAY:
            case HOUR_OF_AMPM:
            case MINUTE_OF_DAY:
            case MINUTE_OF_HOUR:
            case SECOND_OF_DAY:
            case SECOND_OF_MINUTE:
            case MILLI_OF_DAY:
            case MILLI_OF_SECOND:
            case NANO_OF_DAY:
            case NANO_OF_SECOND:
            case CLOCK_HOUR_OF_DAY:
            case CLOCK_HOUR_OF_AMPM:
            case EPOCH_DAY:
            case PROLEPTIC_MONTH:
                return chronoField.range();
            default:
                Calendar instance = Calendar.getInstance(feR);
                int i = 0;
                JapaneseEra[] bCN;
                int year;
                switch (chronoField) {
                    case ERA:
                        bCN = JapaneseEra.bCN();
                        return ValueRange.G((long) bCN[0].getValue(), (long) bCN[bCN.length - 1].getValue());
                    case YEAR:
                        bCN = JapaneseEra.bCN();
                        return ValueRange.G((long) JapaneseDate.feW.getYear(), (long) bCN[bCN.length - 1].bCP().getYear());
                    case YEAR_OF_ERA:
                        bCN = JapaneseEra.bCN();
                        year = (bCN[bCN.length - 1].bCP().getYear() - bCN[bCN.length - 1].bCO().getYear()) + 1;
                        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        while (i < bCN.length) {
                            i2 = Math.min(i2, (bCN[i].bCP().getYear() - bCN[i].bCO().getYear()) + 1);
                            i++;
                        }
                        return ValueRange.b(1, 6, (long) i2, (long) year);
                    case MONTH_OF_YEAR:
                        return ValueRange.b((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    case DAY_OF_YEAR:
                        bCN = JapaneseEra.bCN();
                        year = 366;
                        while (i < bCN.length) {
                            year = Math.min(year, (bCN[i].bCO().lengthOfYear() - bCN[i].bCO().getDayOfYear()) + 1);
                            i++;
                        }
                        return ValueRange.a(1, (long) year, 366);
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unimplementable field: ");
                        stringBuilder.append(chronoField);
                        throw new UnsupportedOperationException(stringBuilder.toString());
                }
        }
    }
}
