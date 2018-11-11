package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.a.d;
import org.threeten.bp.format.ResolverStyle;

public enum ChronoField implements e {
    NANO_OF_SECOND("NanoOfSecond", ChronoUnit.NANOS, ChronoUnit.SECONDS, ValueRange.G(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", ChronoUnit.NANOS, ChronoUnit.DAYS, ValueRange.G(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", ChronoUnit.MICROS, ChronoUnit.SECONDS, ValueRange.G(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", ChronoUnit.MICROS, ChronoUnit.DAYS, ValueRange.G(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", ChronoUnit.MILLIS, ChronoUnit.SECONDS, ValueRange.G(0, 999)),
    MILLI_OF_DAY("MilliOfDay", ChronoUnit.MILLIS, ChronoUnit.DAYS, ValueRange.G(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", ChronoUnit.SECONDS, ChronoUnit.MINUTES, ValueRange.G(0, 59)),
    SECOND_OF_DAY("SecondOfDay", ChronoUnit.SECONDS, ChronoUnit.DAYS, ValueRange.G(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", ChronoUnit.MINUTES, ChronoUnit.HOURS, ValueRange.G(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", ChronoUnit.MINUTES, ChronoUnit.DAYS, ValueRange.G(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", ChronoUnit.HOURS, ChronoUnit.HALF_DAYS, ValueRange.G(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", ChronoUnit.HOURS, ChronoUnit.HALF_DAYS, ValueRange.G(1, 12)),
    HOUR_OF_DAY("HourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.G(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.G(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", ChronoUnit.HALF_DAYS, ChronoUnit.DAYS, ValueRange.G(0, 1)),
    DAY_OF_WEEK("DayOfWeek", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.G(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.G(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.G(1, 7)),
    DAY_OF_MONTH("DayOfMonth", ChronoUnit.DAYS, ChronoUnit.MONTHS, ValueRange.a(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", ChronoUnit.DAYS, ChronoUnit.YEARS, ValueRange.a(1, 365, 366)),
    EPOCH_DAY("EpochDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, ValueRange.G(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", ChronoUnit.WEEKS, ChronoUnit.MONTHS, ValueRange.a(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", ChronoUnit.WEEKS, ChronoUnit.YEARS, ValueRange.G(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", ChronoUnit.MONTHS, ChronoUnit.YEARS, ValueRange.G(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", ChronoUnit.MONTHS, ChronoUnit.FOREVER, ValueRange.G(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.a(1, 999999999, 1000000000)),
    YEAR("Year", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.G(-999999999, 999999999)),
    ERA("Era", ChronoUnit.ERAS, ChronoUnit.FOREVER, ValueRange.G(0, 1)),
    INSTANT_SECONDS("InstantSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.G(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.G(-64800, 64800));
    
    private final h baseUnit;
    private final String name;
    private final ValueRange range;
    private final h rangeUnit;

    public b resolve(Map<e, Long> map, b bVar, ResolverStyle resolverStyle) {
        return null;
    }

    private ChronoField(String str, h hVar, h hVar2, ValueRange valueRange) {
        this.name = str;
        this.baseUnit = hVar;
        this.rangeUnit = hVar2;
        this.range = valueRange;
    }

    public h getBaseUnit() {
        return this.baseUnit;
    }

    public h getRangeUnit() {
        return this.rangeUnit;
    }

    public ValueRange range() {
        return this.range;
    }

    public boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public long checkValidValue(long j) {
        return range().a(j, this);
    }

    public int checkValidIntValue(long j) {
        return range().b(j, this);
    }

    public boolean isSupportedBy(b bVar) {
        return bVar.isSupported(this);
    }

    public ValueRange rangeRefinedBy(b bVar) {
        return bVar.range(this);
    }

    public long getFrom(b bVar) {
        return bVar.getLong(this);
    }

    public <R extends a> R adjustInto(R r, long j) {
        return r.b(this, j);
    }

    public String getDisplayName(Locale locale) {
        d.requireNonNull(locale, "locale");
        return toString();
    }

    public String toString() {
        return this.name;
    }
}
