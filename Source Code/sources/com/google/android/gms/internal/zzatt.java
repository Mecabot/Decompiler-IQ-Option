package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzo;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.ToastEntity;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Hide
public final class zzatt {
    private static final char[] zzeey = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static double zza(String str, double d) {
        if (str == null) {
            return 100.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 100.0d;
        }
    }

    public static zzaqm zza(zzatd zzatd, String str) {
        zzbq.checkNotNull(zzatd);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            String str2 = "?";
            str = String.valueOf(str);
            Map zza = zzo.zza(new URI(str.length() != 0 ? str2.concat(str) : new String(str2)), "UTF-8");
            zzaqm zzaqm = new zzaqm();
            zzaqm.zzdp((String) zza.get("utm_content"));
            zzaqm.zzdn((String) zza.get("utm_medium"));
            zzaqm.setName((String) zza.get("utm_campaign"));
            zzaqm.zzdm((String) zza.get("utm_source"));
            zzaqm.zzdo((String) zza.get("utm_term"));
            zzaqm.zzdq((String) zza.get("utm_id"));
            zzaqm.zzdr((String) zza.get("anid"));
            zzaqm.zzds((String) zza.get("gclid"));
            zzaqm.zzdt((String) zza.get("dclid"));
            zzaqm.zzdu((String) zza.get(b.ACLID));
            return zzaqm;
        } catch (URISyntaxException e) {
            zzatd.zzd("No valid campaign data found", e);
            return null;
        }
    }

    public static String zza(Locale locale) {
        if (locale == null) {
            return null;
        }
        Object language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-");
            stringBuilder.append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static void zza(Map<String, String> map, String str, Map<String, String> map2) {
        zzb((Map) map, str, (String) map2.get(str));
    }

    public static boolean zza(double d, String str) {
        if (d <= 0.0d || d >= 100.0d) {
            return false;
        }
        int i;
        if (TextUtils.isEmpty(str)) {
            i = 1;
        } else {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return ((double) (i % ToastEntity.ALERT_TOAST_DURATION)) >= d * 100.0d;
    }

    public static String zzao(boolean z) {
        return z ? "1" : "0";
    }

    public static void zzb(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void zzb(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? "1" : "0");
        }
    }

    public static boolean zzb(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (!z || receiverInfo.exported) {
                    return true;
                }
                return false;
            }
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static void zzc(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty((CharSequence) map.get(str))) {
            map.put(str, str2);
        }
    }

    public static boolean zzd(String str, boolean z) {
        if (str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) {
            return true;
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) {
            return false;
        }
        return true;
    }

    public static Map<String, String> zzen(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 3);
            Object obj = null;
            if (split2.length > 1) {
                hashMap.put(split2[0], TextUtils.isEmpty(split2[1]) ? null : split2[1]);
                if (!(split2.length != 3 || TextUtils.isEmpty(split2[1]) || hashMap.containsKey(split2[1]))) {
                    Object obj2 = split2[1];
                    if (!TextUtils.isEmpty(split2[2])) {
                        obj = split2[2];
                    }
                    hashMap.put(obj2, obj);
                }
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }

    public static long zzeo(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String zzep(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split;
        if (str.contains("?")) {
            split = str.split("[\\?]");
            if (split.length > 1) {
                str = split[1];
            }
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map zzen = zzen(str);
        split = new String[]{"dclid", "utm_source", "gclid", b.ACLID, "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "anid", "gmob_t"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            if (!TextUtils.isEmpty((CharSequence) zzen.get(split[i]))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(split[i]);
                stringBuilder.append("=");
                stringBuilder.append((String) zzen.get(split[i]));
            }
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing block: B:12:0x000b, code:
            continue;
     */
    public static java.security.MessageDigest zzeq(java.lang.String r2) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzatt.zzeq(java.lang.String):java.security.MessageDigest");
    }

    public static boolean zzer(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    public static boolean zzp(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException unused) {
            return false;
        }
    }
}
