package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbt;
import java.net.URLEncoder;

final class zzgo {
    private static zzea<zzbt> zza(zzea<zzbt> zzea) {
        try {
            return new zzea(zzgk.zzam(zzmm(zzgk.zzd((zzbt) zzea.getObject()))), zzea.zzbhd());
        } catch (Throwable e) {
            zzdj.zzb("Escape URI: unsupported encoding", e);
            return zzea;
        }
    }

    static zzea<zzbt> zza(zzea<zzbt> zzea, int... iArr) {
        for (int i : iArr) {
            String str;
            if (!(zzgk.zzi((zzbt) zzea.getObject()) instanceof String)) {
                str = "Escaping can only be applied to strings.";
            } else if (i != 12) {
                StringBuilder stringBuilder = new StringBuilder(39);
                stringBuilder.append("Unsupported Value Escaping: ");
                stringBuilder.append(i);
                str = stringBuilder.toString();
            } else {
                zzea = zza(zzea);
            }
            zzdj.e(str);
        }
        return zzea;
    }

    static String zzmm(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }
}
