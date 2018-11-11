package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.g;

/* compiled from: DateTimeFormatter */
public final class b {
    private static final g<Boolean> ffA = new g<Boolean>() {
        /* renamed from: P */
        public Boolean b(org.threeten.bp.temporal.b bVar) {
            if (bVar instanceof a) {
                return Boolean.valueOf(((a) bVar).ffi);
            }
            return Boolean.FALSE;
        }
    };
    public static final b ffk = new DateTimeFormatterBuilder().a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).F('-').a(ChronoField.MONTH_OF_YEAR, 2).F('-').a(ChronoField.DAY_OF_MONTH, 2).b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffl = new DateTimeFormatterBuilder().bCX().a(ffk).bDa().b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffm = new DateTimeFormatterBuilder().bCX().a(ffk).bDc().bDa().b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffn = new DateTimeFormatterBuilder().a(ChronoField.HOUR_OF_DAY, 2).F(':').a(ChronoField.MINUTE_OF_HOUR, 2).bDc().F(':').a(ChronoField.SECOND_OF_MINUTE, 2).bDc().a(ChronoField.NANO_OF_SECOND, 0, 9, true).b(ResolverStyle.STRICT);
    public static final b ffo = new DateTimeFormatterBuilder().bCX().a(ffn).bDa().b(ResolverStyle.STRICT);
    public static final b ffp = new DateTimeFormatterBuilder().bCX().a(ffn).bDc().bDa().b(ResolverStyle.STRICT);
    public static final b ffq = new DateTimeFormatterBuilder().bCX().a(ffk).F('T').a(ffn).b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffr = new DateTimeFormatterBuilder().bCX().a(ffq).bDa().b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffs = new DateTimeFormatterBuilder().a(ffr).bDc().F('[').bCW().bDb().F(']').b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b fft = new DateTimeFormatterBuilder().a(ffq).bDc().bDa().bDc().F('[').bCW().bDb().F(']').b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffu = new DateTimeFormatterBuilder().bCX().a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).F('-').a(ChronoField.DAY_OF_YEAR, 3).bDc().bDa().b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffv = new DateTimeFormatterBuilder().bCX().a(IsoFields.fgF, 4, 10, SignStyle.EXCEEDS_PAD).nP("-W").a(IsoFields.fgE, 2).F('-').a(ChronoField.DAY_OF_WEEK, 1).bDc().bDa().b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffw = new DateTimeFormatterBuilder().bCX().bCZ().b(ResolverStyle.STRICT);
    public static final b ffx = new DateTimeFormatterBuilder().bCX().a(ChronoField.YEAR, 4).a(ChronoField.MONTH_OF_YEAR, 2).a(ChronoField.DAY_OF_MONTH, 2).bDc().bp("+HHMMss", "Z").b(ResolverStyle.STRICT).c(IsoChronology.feQ);
    public static final b ffy;
    private static final g<Period> ffz = new g<Period>() {
        /* renamed from: O */
        public Period b(org.threeten.bp.temporal.b bVar) {
            if (bVar instanceof a) {
                return ((a) bVar).ffj;
            }
            return Period.fdW;
        }
    };
    private final b ffB;
    private final f ffC;
    private final ResolverStyle ffD;
    private final Set<e> ffE;
    private final org.threeten.bp.chrono.e ffh;
    private final Locale locale;
    private final ZoneId zone;

    static {
        Map hashMap = new HashMap();
        hashMap.put(Long.valueOf(1), "Mon");
        hashMap.put(Long.valueOf(2), "Tue");
        hashMap.put(Long.valueOf(3), "Wed");
        hashMap.put(Long.valueOf(4), "Thu");
        hashMap.put(Long.valueOf(5), "Fri");
        hashMap.put(Long.valueOf(6), "Sat");
        hashMap.put(Long.valueOf(7), "Sun");
        Map hashMap2 = new HashMap();
        hashMap2.put(Long.valueOf(1), "Jan");
        hashMap2.put(Long.valueOf(2), "Feb");
        hashMap2.put(Long.valueOf(3), "Mar");
        hashMap2.put(Long.valueOf(4), "Apr");
        hashMap2.put(Long.valueOf(5), "May");
        hashMap2.put(Long.valueOf(6), "Jun");
        hashMap2.put(Long.valueOf(7), "Jul");
        hashMap2.put(Long.valueOf(8), "Aug");
        hashMap2.put(Long.valueOf(9), "Sep");
        hashMap2.put(Long.valueOf(10), "Oct");
        hashMap2.put(Long.valueOf(11), "Nov");
        hashMap2.put(Long.valueOf(12), "Dec");
        ffy = new DateTimeFormatterBuilder().bCX().bCY().bDc().a(ChronoField.DAY_OF_WEEK, hashMap).nP(", ").bDd().a(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE).F(' ').a(ChronoField.MONTH_OF_YEAR, hashMap2).F(' ').a(ChronoField.YEAR, 4).F(' ').a(ChronoField.HOUR_OF_DAY, 2).F(':').a(ChronoField.MINUTE_OF_HOUR, 2).bDc().F(':').a(ChronoField.SECOND_OF_MINUTE, 2).bDd().F(' ').bp("+HHMM", "GMT").b(ResolverStyle.SMART).c(IsoChronology.feQ);
    }

    b(b bVar, Locale locale, f fVar, ResolverStyle resolverStyle, Set<e> set, org.threeten.bp.chrono.e eVar, ZoneId zoneId) {
        this.ffB = (b) d.requireNonNull(bVar, "printerParser");
        this.locale = (Locale) d.requireNonNull(locale, "locale");
        this.ffC = (f) d.requireNonNull(fVar, "decimalStyle");
        this.ffD = (ResolverStyle) d.requireNonNull(resolverStyle, "resolverStyle");
        this.ffE = set;
        this.ffh = eVar;
        this.zone = zoneId;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public f bCV() {
        return this.ffC;
    }

    public org.threeten.bp.chrono.e bCs() {
        return this.ffh;
    }

    public b c(org.threeten.bp.chrono.e eVar) {
        if (d.equals(this.ffh, eVar)) {
            return this;
        }
        return new b(this.ffB, this.locale, this.ffC, this.ffD, this.ffE, eVar, this.zone);
    }

    public ZoneId bCB() {
        return this.zone;
    }

    public b a(ResolverStyle resolverStyle) {
        d.requireNonNull(resolverStyle, "resolverStyle");
        if (d.equals(this.ffD, resolverStyle)) {
            return this;
        }
        return new b(this.ffB, this.locale, this.ffC, resolverStyle, this.ffE, this.ffh, this.zone);
    }

    public String N(org.threeten.bp.temporal.b bVar) {
        Appendable stringBuilder = new StringBuilder(32);
        a(bVar, stringBuilder);
        return stringBuilder.toString();
    }

    public void a(org.threeten.bp.temporal.b bVar, Appendable appendable) {
        d.requireNonNull(bVar, "temporal");
        d.requireNonNull(appendable, "appendable");
        try {
            d dVar = new d(bVar, this);
            if (appendable instanceof StringBuilder) {
                this.ffB.print(dVar, (StringBuilder) appendable);
                return;
            }
            CharSequence stringBuilder = new StringBuilder(32);
            this.ffB.print(dVar, stringBuilder);
            appendable.append(stringBuilder);
        } catch (Throwable e) {
            throw new DateTimeException(e.getMessage(), e);
        }
    }

    b hs(boolean z) {
        return this.ffB.ht(z);
    }

    public String toString() {
        String bVar = this.ffB.toString();
        return bVar.startsWith("[") ? bVar : bVar.substring(1, bVar.length() - 1);
    }
}
