package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        zzbq.zzgv(str);
        String str2 = zzb(bool) ? "https" : "http";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 3) + String.valueOf(str).length());
        stringBuilder.append(str2);
        stringBuilder.append("://");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append('=');
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
        }
        if (zzb(bool)) {
            stringBuilder.append(";HttpOnly");
        }
        if (zzb(bool2)) {
            stringBuilder.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(";Domain=");
            stringBuilder.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            stringBuilder.append(";Path=");
            stringBuilder.append(str4);
        }
        if (l != null && l.longValue() > 0) {
            stringBuilder.append(";Max-Age=");
            stringBuilder.append(l);
        }
        return stringBuilder.toString();
    }

    private static boolean zzb(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
