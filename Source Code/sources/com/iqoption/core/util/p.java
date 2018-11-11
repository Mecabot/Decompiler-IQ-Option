package com.iqoption.core.util;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001dH\u0007J\u0017\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0017\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%J\u0017\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010 J$\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\b\b\u0003\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020)H\u0007J\u0017\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010 J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0017\u0010+\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%J\u0017\u0010+\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010 J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001dH\u0007J.\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010-\u001a\u00020\u00042\b\b\u0003\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020)H\u0007J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001dH\u0007J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020)2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u000207H\u0003J>\u00108\u001a\u00020\u0004\"\u0004\b\u0000\u00109\"\u0004\b\u0001\u0010:2\u0006\u0010;\u001a\u00020\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H90=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H:0?H\u0007J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0007J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0007J\u0010\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u000200H\u0007J\u0010\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006I"}, aXE = {"Lcom/iqoption/core/util/StringUtil;", "", "()V", "BRACKETS_MASK", "", "CONCAT_EQUALLY_MASK", "CONCAT_MASK", "EMAIL_PATTERN", "EMPTY_MASK", "JSON_PATTERN", "NEGATIVE_MASK", "PERCENT_DOUBLE_MASK", "PERCENT_MASK", "PERCENT_NEGATIVE_DOUBLE_MASK", "PERCENT_NEGATIVE_MASK", "PERCENT_POSITIVE_DOUBLE_MASK", "PERCENT_POSITIVE_MASK", "PERCENT_STRING_MASK", "POSITIVE_MASK", "clearLineSeparator", "text", "emptyIfNull", "s", "extractJsonFromString", "str", "token", "firstUpperLetterTransform", "formatMultiplier", "multiplier", "", "formatedBrackets", "value", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatedNegative", "formatedNegativePercent", "percent", "", "(Ljava/lang/Double;)Ljava/lang/String;", "formatedPercent", "precision", "isHard", "", "formatedPositive", "formatedPositivePercent", "formatedSignPercent", "sign", "getNumbers", "cc", "", "getSign", "val", "", "isEmpty", "isNumber", "c", "", "join", "T", "S", "delimiter", "collection", "", "function", "Lcom/google/common/base/Function;", "toUpperCamelWithSpace", "src", "transformMask", "mask", "transformation", "validateEmail", "email", "validatePhone", "number", "core_release"})
/* compiled from: StringUtil.kt */
public final class p {
    public static final p bhf = new p();

    private static final boolean B(char c) {
        return '0' <= c && '9' >= c;
    }

    public static final String a(double d, String str, @IntRange(from = 0, to = 4) int i) {
        return a(d, str, i, false, 8, null);
    }

    public static final String b(double d, String str) {
        return a(d, str, 0, false, 12, null);
    }

    public static final String e(double d, @IntRange(from = 0, to = 4) int i) {
        return a(d, i, false, 4, null);
    }

    public static final String ha(String str) {
        return str != null ? str : "";
    }

    public static final String n(double d) {
        return a(d, null, 0, false, 14, null);
    }

    public static final String o(double d) {
        return a(d, 0, false, 6, null);
    }

    private p() {
    }

    public static final boolean u(CharSequence charSequence) {
        h.e(charSequence, "email");
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(charSequence).matches();
    }

    public static final boolean isEmpty(String str) {
        if (str != null) {
            if (!((((CharSequence) str).length() == 0 ? 1 : null) != null || h.E(str, "null") || h.E(str, "Null"))) {
                return false;
            }
        }
        return true;
    }

    public static final String ae(String str, String str2) {
        h.e(str, "str");
        int a = str2 == null ? 0 : v.a((CharSequence) str, str2, 0, false, 6, null);
        if (a != -1) {
            Pattern compile = Pattern.compile("\\{# Match an opening brace.       \n(?:           # Match either...                                      \n \"           #  a quoted string,                                    \n (?:          #  which may contain either...                         \n  \\\\.       #   escaped characters                                 \n |            #  or                                                  \n  [^\"\\\\]   #   any other characters except quotes and backslashes \n )*           #  any number of times,                                \n \"           #  and ends with a quote.                              \n|             # Or match...                                          \n [^\"{}]*     #  any number of characters besides quotes and braces. \n)*            # Repeat as needed.                                    \n\\}           # Then match a closing brace.", 4);
            str = str.substring(a);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            Matcher matcher = compile.matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
        }
        return null;
    }

    public static final String b(Double d) {
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{d};
        String format = String.format(locale, "+%.1f%%", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final String c(Double d) {
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{d};
        String format = String.format(locale, "-%.1f%%", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final String gX(String str) {
        h.e(str, "str");
        m mVar = m.euz;
        Object[] objArr = new Object[]{str};
        str = String.format("+%s", Arrays.copyOf(objArr, objArr.length));
        h.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String gY(String str) {
        h.e(str, "str");
        m mVar = m.euz;
        Object[] objArr = new Object[]{str};
        str = String.format("-%s", Arrays.copyOf(objArr, objArr.length));
        h.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    private final String b(Number number) {
        if (number.doubleValue() > 0.01d) {
            return "+";
        }
        return number.doubleValue() < -0.01d ? "-" : "";
    }

    public static final String dZ(int i) {
        return a((double) i, bhf.b((Number) Integer.valueOf(i)), 0, false, 8, null);
    }

    public static final String d(double d, int i) {
        return a(d, bhf.b((Number) Double.valueOf(d)), i, false, 8, null);
    }

    public static /* synthetic */ String a(double d, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = bhf.b((Number) Double.valueOf(d));
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return a(d, str, i, z);
    }

    public static final String a(double d, String str, @IntRange(from = 0, to = 4) int i, boolean z) {
        h.e(str, "sign");
        String format = (z ? d.dY(i) : d.dX(i)).format(Math.abs(d));
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("%s%%");
        str = stringBuilder.toString();
        Object[] objArr = new Object[]{format};
        format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static /* bridge */ /* synthetic */ String a(double d, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(d, i, z);
    }

    public static final String a(double d, @IntRange(from = 0, to = 4) int i, boolean z) {
        String format = (z ? d.dY(i) : d.dX(i)).format(d);
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{format};
        format = String.format(locale, "%s%%", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final String v(CharSequence charSequence) {
        h.e(charSequence, "cc");
        StringBuilder stringBuilder = new StringBuilder(16);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (B(charAt)) {
                stringBuilder.append(charAt);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }

    public static final String ea(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('x');
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public static final String af(String str, String str2) {
        h.e(str, "mask");
        h.e(str2, "transformation");
        m mVar = m.euz;
        Object[] objArr = new Object[]{str2};
        str = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String gZ(String str) {
        h.e(str, "text");
        CharSequence charSequence = str;
        String property = System.getProperty("line.separator");
        h.d(property, "System.getProperty(\"line.separator\")");
        return new Regex(property).c(charSequence, "");
    }
}
