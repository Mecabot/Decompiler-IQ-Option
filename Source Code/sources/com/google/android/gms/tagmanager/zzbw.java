package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

final class zzbw extends zzbr {
    private static final String ID = zzbh.HASH.toString();
    private static final String zzkpn = zzbi.ARG0.toString();
    private static final String zzkpp = zzbi.INPUT_FORMAT.toString();
    private static final String zzkpt = zzbi.ALGORITHM.toString();

    public zzbw() {
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
        byte[] bytes;
        String valueOf;
        String zzd = zzgk.zzd(zzbt);
        zzbt zzbt2 = (zzbt) map.get(zzkpt);
        String zzd2 = zzbt2 == null ? "MD5" : zzgk.zzd(zzbt2);
        zzbt zzbt3 = (zzbt) map.get(zzkpp);
        Object zzd3 = zzbt3 == null ? "text" : zzgk.zzd(zzbt3);
        if ("text".equals(zzd3)) {
            bytes = zzd.getBytes();
        } else if ("base16".equals(zzd3)) {
            bytes = zzo.decode(zzd);
        } else {
            zzd = "Hash: unknown input format: ";
            valueOf = String.valueOf(zzd3);
            valueOf = valueOf.length() != 0 ? zzd.concat(valueOf) : new String(zzd);
            zzdj.e(valueOf);
            return zzgk.zzbil();
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(zzd2);
            instance.update(bytes);
            return zzgk.zzam(zzo.zzj(instance.digest()));
        } catch (NoSuchAlgorithmException unused) {
            valueOf = "Hash: unknown algorithm: ";
            zzd = String.valueOf(zzd2);
            valueOf = zzd.length() != 0 ? valueOf.concat(zzd) : new String(valueOf);
        }
    }
}
