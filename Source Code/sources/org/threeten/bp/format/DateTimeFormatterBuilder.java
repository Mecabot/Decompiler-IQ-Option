package org.threeten.bp.format;

import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.ToastEntity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.ValueRange;

public final class DateTimeFormatterBuilder {
    private static final org.threeten.bp.temporal.g<ZoneId> ffF = new org.threeten.bp.temporal.g<ZoneId>() {
        /* renamed from: w */
        public ZoneId b(org.threeten.bp.temporal.b bVar) {
            ZoneId zoneId = (ZoneId) bVar.query(org.threeten.bp.temporal.f.bDq());
            return (zoneId == null || (zoneId instanceof ZoneOffset)) ? null : zoneId;
        }
    };
    private static final Map<Character, org.threeten.bp.temporal.e> ffM = new HashMap();
    static final Comparator<String> ffN = new Comparator<String>() {
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    };
    private DateTimeFormatterBuilder ffG;
    private final DateTimeFormatterBuilder ffH;
    private final List<c> ffI;
    private int ffJ;
    private char ffK;
    private int ffL;
    private final boolean optional;

    interface c {
        boolean print(d dVar, StringBuilder stringBuilder);
    }

    enum SettingsParser implements c {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        public boolean print(d dVar, StringBuilder stringBuilder) {
            return true;
        }

        public int parse(c cVar, CharSequence charSequence, int i) {
            switch (ordinal()) {
                case 0:
                    cVar.setCaseSensitive(true);
                    break;
                case 1:
                    cVar.setCaseSensitive(false);
                    break;
                case 2:
                    cVar.setStrict(true);
                    break;
                case 3:
                    cVar.setStrict(false);
                    break;
            }
            return i;
        }

        public String toString() {
            switch (ordinal()) {
                case 0:
                    return "ParseCaseSensitive(true)";
                case 1:
                    return "ParseCaseSensitive(false)";
                case 2:
                    return "ParseStrict(true)";
                case 3:
                    return "ParseStrict(false)";
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }
    }

    static final class a implements c {
        private final char ffR;

        a(char c) {
            this.ffR = c;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            stringBuilder.append(this.ffR);
            return true;
        }

        public String toString() {
            if (this.ffR == '\'') {
                return "''";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(this.ffR);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class b implements c {
        private final c[] ffS;
        private final boolean optional;

        b(List<c> list, boolean z) {
            this((c[]) list.toArray(new c[list.size()]), z);
        }

        b(c[] cVarArr, boolean z) {
            this.ffS = cVarArr;
            this.optional = z;
        }

        public b ht(boolean z) {
            if (z == this.optional) {
                return this;
            }
            return new b(this.ffS, z);
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            int length = stringBuilder.length();
            if (this.optional) {
                dVar.bDk();
            }
            try {
                c[] cVarArr = this.ffS;
                int length2 = cVarArr.length;
                int i = 0;
                while (i < length2) {
                    if (cVarArr[i].print(dVar, stringBuilder)) {
                        i++;
                    } else {
                        stringBuilder.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dVar.bDl();
                }
                return true;
            } finally {
                if (this.optional) {
                    dVar.bDl();
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.ffS != null) {
                stringBuilder.append(this.optional ? "[" : "(");
                for (Object append : this.ffS) {
                    stringBuilder.append(append);
                }
                stringBuilder.append(this.optional ? "]" : ")");
            }
            return stringBuilder.toString();
        }
    }

    static final class d implements c {
        private final org.threeten.bp.temporal.e ffT;
        private final boolean ffU;
        private final int maxWidth;
        private final int minWidth;

        d(org.threeten.bp.temporal.e eVar, int i, int i2, boolean z) {
            org.threeten.bp.a.d.requireNonNull(eVar, "field");
            StringBuilder stringBuilder;
            if (!eVar.range().isFixed()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field must have a fixed set of values: ");
                stringBuilder.append(eVar);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i < 0 || i > 9) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Minimum width must be from 0 to 9 inclusive but was ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i2 < 1 || i2 > 9) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Maximum width must be from 1 to 9 inclusive but was ");
                stringBuilder2.append(i2);
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else if (i2 < i) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Maximum width must exceed or equal the minimum width but ");
                stringBuilder3.append(i2);
                stringBuilder3.append(" < ");
                stringBuilder3.append(i);
                throw new IllegalArgumentException(stringBuilder3.toString());
            } else {
                this.ffT = eVar;
                this.minWidth = i;
                this.maxWidth = i2;
                this.ffU = z;
            }
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            Long c = dVar.c(this.ffT);
            int i = 0;
            if (c == null) {
                return false;
            }
            f bDj = dVar.bDj();
            BigDecimal ej = ej(c.longValue());
            if (ej.scale() != 0) {
                String nR = bDj.nR(ej.setScale(Math.min(Math.max(ej.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.ffU) {
                    stringBuilder.append(bDj.getDecimalSeparator());
                }
                stringBuilder.append(nR);
            } else if (this.minWidth > 0) {
                if (this.ffU) {
                    stringBuilder.append(bDj.getDecimalSeparator());
                }
                while (i < this.minWidth) {
                    stringBuilder.append(bDj.getZeroDigit());
                    i++;
                }
            }
            return true;
        }

        private BigDecimal ej(long j) {
            ValueRange range = this.ffT.range();
            range.a(j, this.ffT);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(j).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            return divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        }

        public String toString() {
            String str = this.ffU ? ",DecimalPoint" : "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fraction(");
            stringBuilder.append(this.ffT);
            stringBuilder.append(",");
            stringBuilder.append(this.minWidth);
            stringBuilder.append(",");
            stringBuilder.append(this.maxWidth);
            stringBuilder.append(str);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class e implements c {
        private final int ffV;

        public String toString() {
            return "Instant()";
        }

        e(int i) {
            this.ffV = i;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            StringBuilder stringBuilder2 = stringBuilder;
            Long c = dVar.c(ChronoField.INSTANT_SECONDS);
            Long valueOf = Long.valueOf(0);
            if (dVar.bDi().isSupported(ChronoField.NANO_OF_SECOND)) {
                valueOf = Long.valueOf(dVar.bDi().getLong(ChronoField.NANO_OF_SECOND));
            }
            int i = 0;
            if (c == null) {
                return false;
            }
            long longValue = c.longValue();
            int checkValidIntValue = ChronoField.NANO_OF_SECOND.checkValidIntValue(valueOf.longValue());
            long j;
            long floorDiv;
            if (longValue >= -62167219200L) {
                j = (longValue - 315569520000L) + 62167219200L;
                floorDiv = org.threeten.bp.a.d.floorDiv(j, 315569520000L) + 1;
                LocalDateTime a = LocalDateTime.a(org.threeten.bp.a.d.floorMod(j, 315569520000L) - 62167219200L, 0, ZoneOffset.fdZ);
                if (floorDiv > 0) {
                    stringBuilder2.append('+');
                    stringBuilder2.append(floorDiv);
                }
                stringBuilder2.append(a);
                if (a.getSecond() == 0) {
                    stringBuilder2.append(":00");
                }
            } else {
                floorDiv = longValue + 62167219200L;
                j = floorDiv / 315569520000L;
                floorDiv %= 315569520000L;
                LocalDateTime a2 = LocalDateTime.a(floorDiv - 62167219200L, 0, ZoneOffset.fdZ);
                int length = stringBuilder.length();
                stringBuilder2.append(a2);
                if (a2.getSecond() == 0) {
                    stringBuilder2.append(":00");
                }
                if (j < 0) {
                    if (a2.getYear() == -10000) {
                        stringBuilder2.replace(length, length + 2, Long.toString(j - 1));
                    } else if (floorDiv == 0) {
                        stringBuilder2.insert(length, j);
                    } else {
                        stringBuilder2.insert(length + 1, Math.abs(j));
                    }
                }
            }
            if (this.ffV == -2) {
                if (checkValidIntValue != 0) {
                    stringBuilder2.append('.');
                    if (checkValidIntValue % 1000000 == 0) {
                        stringBuilder2.append(Integer.toString((checkValidIntValue / 1000000) + 1000).substring(1));
                    } else if (checkValidIntValue % 1000 == 0) {
                        stringBuilder2.append(Integer.toString((checkValidIntValue / 1000) + 1000000).substring(1));
                    } else {
                        stringBuilder2.append(Integer.toString(checkValidIntValue + 1000000000).substring(1));
                    }
                }
            } else if (this.ffV > 0 || (this.ffV == -1 && checkValidIntValue > 0)) {
                stringBuilder2.append('.');
                int i2 = 100000000;
                while (true) {
                    if ((this.ffV != -1 || checkValidIntValue <= 0) && i >= this.ffV) {
                        break;
                    }
                    int i3 = checkValidIntValue / i2;
                    stringBuilder2.append((char) (i3 + 48));
                    checkValidIntValue -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            stringBuilder2.append('Z');
            return true;
        }
    }

    static class f implements c {
        static final int[] ffW = new int[]{0, 10, 100, 1000, ToastEntity.ALERT_TOAST_DURATION, 100000, 1000000, 10000000, 100000000, 1000000000};
        final org.threeten.bp.temporal.e ffT;
        final SignStyle ffX;
        final int ffY;
        final int maxWidth;
        final int minWidth;

        long a(d dVar, long j) {
            return j;
        }

        f(org.threeten.bp.temporal.e eVar, int i, int i2, SignStyle signStyle) {
            this.ffT = eVar;
            this.minWidth = i;
            this.maxWidth = i2;
            this.ffX = signStyle;
            this.ffY = 0;
        }

        private f(org.threeten.bp.temporal.e eVar, int i, int i2, SignStyle signStyle, int i3) {
            this.ffT = eVar;
            this.minWidth = i;
            this.maxWidth = i2;
            this.ffX = signStyle;
            this.ffY = i3;
        }

        f bDf() {
            if (this.ffY == -1) {
                return this;
            }
            return new f(this.ffT, this.minWidth, this.maxWidth, this.ffX, -1);
        }

        f nk(int i) {
            return new f(this.ffT, this.minWidth, this.maxWidth, this.ffX, this.ffY + i);
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            Long c = dVar.c(this.ffT);
            int i = 0;
            if (c == null) {
                return false;
            }
            String str;
            long a = a(dVar, c.longValue());
            f bDj = dVar.bDj();
            if (a == Long.MIN_VALUE) {
                str = "9223372036854775808";
            } else {
                str = Long.toString(Math.abs(a));
            }
            if (str.length() > this.maxWidth) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Field ");
                stringBuilder.append(this.ffT);
                stringBuilder.append(" cannot be printed as the value ");
                stringBuilder.append(a);
                stringBuilder.append(" exceeds the maximum print width of ");
                stringBuilder.append(this.maxWidth);
                throw new DateTimeException(stringBuilder.toString());
            }
            str = bDj.nR(str);
            if (a >= 0) {
                switch (this.ffX) {
                    case EXCEEDS_PAD:
                        if (this.minWidth < 19 && a >= ((long) ffW[this.minWidth])) {
                            stringBuilder.append(bDj.getPositiveSign());
                            break;
                        }
                    case ALWAYS:
                        stringBuilder.append(bDj.getPositiveSign());
                        break;
                }
            }
            switch (this.ffX) {
                case EXCEEDS_PAD:
                case ALWAYS:
                case NORMAL:
                    stringBuilder.append(bDj.getNegativeSign());
                    break;
                case NOT_NEGATIVE:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field ");
                    stringBuilder.append(this.ffT);
                    stringBuilder.append(" cannot be printed as the value ");
                    stringBuilder.append(a);
                    stringBuilder.append(" cannot be negative according to the SignStyle");
                    throw new DateTimeException(stringBuilder.toString());
            }
            while (i < this.minWidth - str.length()) {
                stringBuilder.append(bDj.getZeroDigit());
                i++;
            }
            stringBuilder.append(str);
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.minWidth == 1 && this.maxWidth == 19 && this.ffX == SignStyle.NORMAL) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Value(");
                stringBuilder.append(this.ffT);
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else if (this.minWidth == this.maxWidth && this.ffX == SignStyle.NOT_NEGATIVE) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Value(");
                stringBuilder.append(this.ffT);
                stringBuilder.append(",");
                stringBuilder.append(this.minWidth);
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Value(");
                stringBuilder.append(this.ffT);
                stringBuilder.append(",");
                stringBuilder.append(this.minWidth);
                stringBuilder.append(",");
                stringBuilder.append(this.maxWidth);
                stringBuilder.append(",");
                stringBuilder.append(this.ffX);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        }
    }

    static final class g implements c {
        static final String[] ffZ = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final g fga = new g("Z", "+HH:MM:ss");
        private final String fgb;
        private final int type;

        g(String str, String str2) {
            org.threeten.bp.a.d.requireNonNull(str, "noOffsetText");
            org.threeten.bp.a.d.requireNonNull(str2, "pattern");
            this.fgb = str;
            this.type = nQ(str2);
        }

        private int nQ(String str) {
            for (int i = 0; i < ffZ.length; i++) {
                if (ffZ[i].equals(str)) {
                    return i;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid zone offset pattern: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            Long c = dVar.c(ChronoField.OFFSET_SECONDS);
            if (c == null) {
                return false;
            }
            int ek = org.threeten.bp.a.d.ek(c.longValue());
            if (ek == 0) {
                stringBuilder.append(this.fgb);
            } else {
                int abs = Math.abs((ek / ChartTimeInterval.CANDLE_1H) % 100);
                int abs2 = Math.abs((ek / 60) % 60);
                int abs3 = Math.abs(ek % 60);
                int length = stringBuilder.length();
                stringBuilder.append(ek < 0 ? "-" : "+");
                stringBuilder.append((char) ((abs / 10) + 48));
                stringBuilder.append((char) ((abs % 10) + 48));
                if (this.type >= 3 || (this.type >= 1 && abs2 > 0)) {
                    stringBuilder.append(this.type % 2 == 0 ? ":" : "");
                    stringBuilder.append((char) ((abs2 / 10) + 48));
                    stringBuilder.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    if (this.type >= 7 || (this.type >= 5 && abs3 > 0)) {
                        stringBuilder.append(this.type % 2 == 0 ? ":" : "");
                        stringBuilder.append((char) ((abs3 / 10) + 48));
                        stringBuilder.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    stringBuilder.setLength(length);
                    stringBuilder.append(this.fgb);
                }
            }
            return true;
        }

        public String toString() {
            String replace = this.fgb.replace("'", "''");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Offset(");
            stringBuilder.append(ffZ[this.type]);
            stringBuilder.append(",'");
            stringBuilder.append(replace);
            stringBuilder.append("')");
            return stringBuilder.toString();
        }
    }

    static final class h implements c {
        private final c fgc;
        private final int fgd;
        private final char fge;

        h(c cVar, int i, char c) {
            this.fgc = cVar;
            this.fgd = i;
            this.fge = c;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            int length = stringBuilder.length();
            int i = 0;
            if (!this.fgc.print(dVar, stringBuilder)) {
                return false;
            }
            int length2 = stringBuilder.length() - length;
            if (length2 > this.fgd) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Cannot print as output of ");
                stringBuilder2.append(length2);
                stringBuilder2.append(" characters exceeds pad width of ");
                stringBuilder2.append(this.fgd);
                throw new DateTimeException(stringBuilder2.toString());
            }
            while (i < this.fgd - length2) {
                stringBuilder.insert(length, this.fge);
                i++;
            }
            return true;
        }

        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pad(");
            stringBuilder.append(this.fgc);
            stringBuilder.append(",");
            stringBuilder.append(this.fgd);
            if (this.fge == ' ') {
                str = ")";
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(",'");
                stringBuilder2.append(this.fge);
                stringBuilder2.append("')");
                str = stringBuilder2.toString();
            }
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    static final class i implements c {
        private final String fgf;

        i(String str) {
            this.fgf = str;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            stringBuilder.append(this.fgf);
            return true;
        }

        public String toString() {
            String replace = this.fgf.replace("'", "''");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(replace);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class j implements c {
        private final org.threeten.bp.temporal.e ffT;
        private final TextStyle fgg;
        private final e fgh;
        private volatile f fgi;

        j(org.threeten.bp.temporal.e eVar, TextStyle textStyle, e eVar2) {
            this.ffT = eVar;
            this.fgg = textStyle;
            this.fgh = eVar2;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            Long c = dVar.c(this.ffT);
            if (c == null) {
                return false;
            }
            String a = this.fgh.a(this.ffT, c.longValue(), this.fgg, dVar.getLocale());
            if (a == null) {
                return bDg().print(dVar, stringBuilder);
            }
            stringBuilder.append(a);
            return true;
        }

        private f bDg() {
            if (this.fgi == null) {
                this.fgi = new f(this.ffT, 1, 19, SignStyle.NORMAL);
            }
            return this.fgi;
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.fgg == TextStyle.FULL) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Text(");
                stringBuilder.append(this.ffT);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Text(");
            stringBuilder.append(this.ffT);
            stringBuilder.append(",");
            stringBuilder.append(this.fgg);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class k implements c {
        private final String description;
        private final org.threeten.bp.temporal.g<ZoneId> fgj;

        k(org.threeten.bp.temporal.g<ZoneId> gVar, String str) {
            this.fgj = gVar;
            this.description = str;
        }

        public boolean print(d dVar, StringBuilder stringBuilder) {
            ZoneId zoneId = (ZoneId) dVar.a(this.fgj);
            if (zoneId == null) {
                return false;
            }
            stringBuilder.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    static {
        ffM.put(Character.valueOf('G'), ChronoField.ERA);
        ffM.put(Character.valueOf('y'), ChronoField.YEAR_OF_ERA);
        ffM.put(Character.valueOf('u'), ChronoField.YEAR);
        ffM.put(Character.valueOf('Q'), IsoFields.fgD);
        ffM.put(Character.valueOf('q'), IsoFields.fgD);
        ffM.put(Character.valueOf('M'), ChronoField.MONTH_OF_YEAR);
        ffM.put(Character.valueOf('L'), ChronoField.MONTH_OF_YEAR);
        ffM.put(Character.valueOf('D'), ChronoField.DAY_OF_YEAR);
        ffM.put(Character.valueOf('d'), ChronoField.DAY_OF_MONTH);
        ffM.put(Character.valueOf('F'), ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ffM.put(Character.valueOf('E'), ChronoField.DAY_OF_WEEK);
        ffM.put(Character.valueOf('c'), ChronoField.DAY_OF_WEEK);
        ffM.put(Character.valueOf('e'), ChronoField.DAY_OF_WEEK);
        ffM.put(Character.valueOf('a'), ChronoField.AMPM_OF_DAY);
        ffM.put(Character.valueOf('H'), ChronoField.HOUR_OF_DAY);
        ffM.put(Character.valueOf('k'), ChronoField.CLOCK_HOUR_OF_DAY);
        ffM.put(Character.valueOf('K'), ChronoField.HOUR_OF_AMPM);
        ffM.put(Character.valueOf('h'), ChronoField.CLOCK_HOUR_OF_AMPM);
        ffM.put(Character.valueOf('m'), ChronoField.MINUTE_OF_HOUR);
        ffM.put(Character.valueOf('s'), ChronoField.SECOND_OF_MINUTE);
        ffM.put(Character.valueOf('S'), ChronoField.NANO_OF_SECOND);
        ffM.put(Character.valueOf('A'), ChronoField.MILLI_OF_DAY);
        ffM.put(Character.valueOf('n'), ChronoField.NANO_OF_SECOND);
        ffM.put(Character.valueOf('N'), ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.ffG = this;
        this.ffI = new ArrayList();
        this.ffL = -1;
        this.ffH = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.ffG = this;
        this.ffI = new ArrayList();
        this.ffL = -1;
        this.ffH = dateTimeFormatterBuilder;
        this.optional = z;
    }

    public DateTimeFormatterBuilder bCW() {
        a(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder bCX() {
        a(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder bCY() {
        a(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder a(org.threeten.bp.temporal.e eVar, int i) {
        org.threeten.bp.a.d.requireNonNull(eVar, "field");
        if (i < 1 || i > 19) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The width must be from 1 to 19 inclusive but was ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        a(new f(eVar, i, i, SignStyle.NOT_NEGATIVE));
        return this;
    }

    public DateTimeFormatterBuilder a(org.threeten.bp.temporal.e eVar, int i, int i2, SignStyle signStyle) {
        if (i == i2 && signStyle == SignStyle.NOT_NEGATIVE) {
            return a(eVar, i2);
        }
        org.threeten.bp.a.d.requireNonNull(eVar, "field");
        org.threeten.bp.a.d.requireNonNull(signStyle, "signStyle");
        if (i < 1 || i > 19) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The minimum width must be from 1 to 19 inclusive but was ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 < 1 || i2 > 19) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The maximum width must be from 1 to 19 inclusive but was ");
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else if (i2 < i) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("The maximum width must exceed or equal the minimum width but ");
            stringBuilder3.append(i2);
            stringBuilder3.append(" < ");
            stringBuilder3.append(i);
            throw new IllegalArgumentException(stringBuilder3.toString());
        } else {
            a(new f(eVar, i, i2, signStyle));
            return this;
        }
    }

    private DateTimeFormatterBuilder a(f fVar) {
        if (this.ffG.ffL < 0 || !(this.ffG.ffI.get(this.ffG.ffL) instanceof f)) {
            this.ffG.ffL = a((c) fVar);
        } else {
            Object nk;
            int i = this.ffG.ffL;
            f fVar2 = (f) this.ffG.ffI.get(i);
            if (fVar.minWidth == fVar.maxWidth && fVar.ffX == SignStyle.NOT_NEGATIVE) {
                nk = fVar2.nk(fVar.maxWidth);
                a(fVar.bDf());
                this.ffG.ffL = i;
            } else {
                nk = fVar2.bDf();
                this.ffG.ffL = a((c) fVar);
            }
            this.ffG.ffI.set(i, nk);
        }
        return this;
    }

    public DateTimeFormatterBuilder a(org.threeten.bp.temporal.e eVar, int i, int i2, boolean z) {
        a(new d(eVar, i, i2, z));
        return this;
    }

    public DateTimeFormatterBuilder a(org.threeten.bp.temporal.e eVar, TextStyle textStyle) {
        org.threeten.bp.a.d.requireNonNull(eVar, "field");
        org.threeten.bp.a.d.requireNonNull(textStyle, "textStyle");
        a(new j(eVar, textStyle, e.bDm()));
        return this;
    }

    public DateTimeFormatterBuilder a(org.threeten.bp.temporal.e eVar, Map<Long, String> map) {
        org.threeten.bp.a.d.requireNonNull(eVar, "field");
        org.threeten.bp.a.d.requireNonNull(map, "textLookup");
        final a aVar = new a(Collections.singletonMap(TextStyle.FULL, new LinkedHashMap(map)));
        a(new j(eVar, TextStyle.FULL, new e() {
            public String a(org.threeten.bp.temporal.e eVar, long j, TextStyle textStyle, Locale locale) {
                return aVar.a(j, textStyle);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder bCZ() {
        a(new e(-2));
        return this;
    }

    public DateTimeFormatterBuilder bDa() {
        a(g.fga);
        return this;
    }

    public DateTimeFormatterBuilder bp(String str, String str2) {
        a(new g(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder bDb() {
        a(new k(ffF, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder F(char c) {
        a(new a(c));
        return this;
    }

    public DateTimeFormatterBuilder nP(String str) {
        org.threeten.bp.a.d.requireNonNull(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                a(new a(str.charAt(0)));
            } else {
                a(new i(str));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder a(b bVar) {
        org.threeten.bp.a.d.requireNonNull(bVar, "formatter");
        a(bVar.hs(false));
        return this;
    }

    public DateTimeFormatterBuilder bDc() {
        this.ffG.ffL = -1;
        this.ffG = new DateTimeFormatterBuilder(this.ffG, true);
        return this;
    }

    public DateTimeFormatterBuilder bDd() {
        if (this.ffG.ffH == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (this.ffG.ffI.size() > 0) {
            c bVar = new b(this.ffG.ffI, this.ffG.optional);
            this.ffG = this.ffG.ffH;
            a(bVar);
        } else {
            this.ffG = this.ffG.ffH;
        }
        return this;
    }

    private int a(c cVar) {
        Object hVar;
        org.threeten.bp.a.d.requireNonNull(cVar, "pp");
        if (this.ffG.ffJ > 0) {
            if (cVar != null) {
                hVar = new h(cVar, this.ffG.ffJ, this.ffG.ffK);
            }
            this.ffG.ffJ = 0;
            this.ffG.ffK = 0;
        }
        this.ffG.ffI.add(hVar);
        this.ffG.ffL = -1;
        return this.ffG.ffI.size() - 1;
    }

    public b bDe() {
        return b(Locale.getDefault());
    }

    public b b(Locale locale) {
        org.threeten.bp.a.d.requireNonNull(locale, "locale");
        while (this.ffG.ffH != null) {
            bDd();
        }
        return new b(new b(this.ffI, false), locale, f.fgu, ResolverStyle.SMART, null, null, null);
    }

    b b(ResolverStyle resolverStyle) {
        return bDe().a(resolverStyle);
    }
}
