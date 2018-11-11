package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbk extends zzbr {
    private static final String ID = zzbh.ENCODE.toString();
    private static final String zzkpn = zzbi.ARG0.toString();
    private static final String zzkpo = zzbi.NO_PADDING.toString();
    private static final String zzkpp = zzbi.INPUT_FORMAT.toString();
    private static final String zzkpq = zzbi.OUTPUT_FORMAT.toString();

    public zzbk() {
        super(ID, zzkpn);
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        zzbt zzbt = (zzbt) map.get(zzkpn);
        if (zzbt == null || zzbt == zzgk.zzbil()) {
            return zzgk.zzbil();
        }
        String zzd = zzgk.zzd(zzbt);
        zzbt zzbt2 = (zzbt) map.get(zzkpp);
        Object zzd2 = zzbt2 == null ? "text" : zzgk.zzd(zzbt2);
        zzbt zzbt3 = (zzbt) map.get(zzkpq);
        Object zzd3 = zzbt3 == null ? "base16" : zzgk.zzd(zzbt3);
        int i = 2;
        zzbt zzbt4 = (zzbt) map.get(zzkpo);
        if (zzbt4 != null && zzgk.zzh(zzbt4).booleanValue()) {
            i = 3;
        }
        String str;
        try {
            byte[] bytes;
            Object zzj;
            if ("text".equals(zzd2)) {
                bytes = zzd.getBytes();
            } else if ("base16".equals(zzd2)) {
                bytes = zzo.decode(zzd);
            } else if ("base64".equals(zzd2)) {
                bytes = Base64.decode(zzd, i);
            } else if ("base64url".equals(zzd2)) {
                bytes = Base64.decode(zzd, i | 8);
            } else {
                str = "Encode: unknown input format: ";
                zzd = String.valueOf(zzd2);
                zzdj.e(zzd.length() != 0 ? str.concat(zzd) : new String(str));
                return zzgk.zzbil();
            }
            if ("base16".equals(zzd3)) {
                zzj = zzo.zzj(bytes);
            } else if ("base64".equals(zzd3)) {
                zzj = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(zzd3)) {
                zzj = Base64.encodeToString(bytes, i | 8);
            } else {
                str = "Encode: unknown output format: ";
                zzd = String.valueOf(zzd3);
                str = zzd.length() != 0 ? str.concat(zzd) : new String(str);
                zzdj.e(str);
                return zzgk.zzbil();
            }
            return zzgk.zzam(zzj);
        } catch (IllegalArgumentException unused) {
            str = "Encode: invalid input:";
        }
    }
}
