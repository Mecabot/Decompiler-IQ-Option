package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.jvm.internal.h;

/* compiled from: capitalizeDecapitalize.kt */
public final class a {
    public static final String A(String str, boolean z) {
        h.e(str, "$receiver");
        CapitalizeDecapitalizeKt$decapitalizeSmart$1 capitalizeDecapitalizeKt$decapitalizeSmart$1 = new CapitalizeDecapitalizeKt$decapitalizeSmart$1(str, z);
        CharSequence charSequence = str;
        if ((charSequence.length() == 0 ? 1 : null) != null || !capitalizeDecapitalizeKt$decapitalizeSmart$1.mb(0)) {
            return str;
        }
        if (str.length() == 1 || !capitalizeDecapitalizeKt$decapitalizeSmart$1.mb(1)) {
            return z ? na(str) : u.decapitalize(str);
        }
        CapitalizeDecapitalizeKt$decapitalizeSmart$2 capitalizeDecapitalizeKt$decapitalizeSmart$2 = new CapitalizeDecapitalizeKt$decapitalizeSmart$2(z);
        for (Object next : v.N(charSequence)) {
            if ((capitalizeDecapitalizeKt$decapitalizeSmart$1.mb(((Number) next).intValue()) ^ 1) != 0) {
                break;
            }
        }
        Object next2 = null;
        Integer num = (Integer) next2;
        if (num == null) {
            return capitalizeDecapitalizeKt$decapitalizeSmart$2.invoke(str);
        }
        int intValue = num.intValue() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(0, intValue);
        h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        stringBuilder.append(capitalizeDecapitalizeKt$decapitalizeSmart$2.invoke(substring));
        str = str.substring(intValue);
        h.d(str, "(this as java.lang.String).substring(startIndex)");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static final String mZ(String str) {
        h.e(str, "$receiver");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && 'z' >= charAt) {
            charAt = Character.toUpperCase(charAt);
            str = str.substring(1);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(charAt));
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static final String na(String str) {
        h.e(str, "$receiver");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && 'Z' >= charAt) {
            charAt = Character.toLowerCase(charAt);
            str = str.substring(1);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(charAt));
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static final String nb(String str) {
        h.e(str, "$receiver");
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && 'Z' >= charAt) {
                charAt = Character.toLowerCase(charAt);
            }
            stringBuilder.append(charAt);
        }
        str = stringBuilder.toString();
        h.d(str, "builder.toString()");
        return str;
    }
}
