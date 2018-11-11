package com.google.android.gms.analytics;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzatc;

@Hide
public final class zzd {
    public static String zzai(int i) {
        return zzc("&cd", i);
    }

    public static String zzaj(int i) {
        return zzc("cd", i);
    }

    public static String zzak(int i) {
        return zzc("&cm", i);
    }

    public static String zzal(int i) {
        return zzc("cm", i);
    }

    public static String zzam(int i) {
        return zzc("&pr", i);
    }

    public static String zzan(int i) {
        return zzc("pr", i);
    }

    public static String zzao(int i) {
        return zzc("&promo", i);
    }

    public static String zzap(int i) {
        return zzc(NotificationCompat.CATEGORY_PROMO, i);
    }

    public static String zzaq(int i) {
        return zzc("pi", i);
    }

    public static String zzar(int i) {
        return zzc("&il", i);
    }

    public static String zzas(int i) {
        return zzc("il", i);
    }

    public static String zzat(int i) {
        return zzc("cd", i);
    }

    public static String zzau(int i) {
        return zzc("cm", i);
    }

    private static String zzc(String str, int i) {
        if (i <= 0) {
            zzatc.zzf("index out of range for prefix", str);
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 11);
        stringBuilder.append(str);
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
