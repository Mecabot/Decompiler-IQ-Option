package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbn;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbq {
    private static void zza(DataLayer dataLayer, zzbn zzbn) {
        for (zzbm zzbm : zzbn.zzws) {
            String str;
            if (zzbm.key == null) {
                str = "GaExperimentRandom: No key";
            } else {
                Object obj = dataLayer.get(zzbm.key);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = zzbm.zzwm;
                long j2 = zzbm.zzwn;
                if (!zzbm.zzwo || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        str = "GaExperimentRandom: random range invalid";
                    }
                }
                dataLayer.zzlm(zzbm.key);
                Map zzn = DataLayer.zzn(zzbm.key, obj);
                if (zzbm.zzwp > 0) {
                    if (zzn.containsKey("gtm")) {
                        Object obj2 = zzn.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(zzbm.zzwp));
                        } else {
                            zzdj.zzcz("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzn.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzbm.zzwp)));
                    }
                }
                dataLayer.push(zzn);
            }
            zzdj.zzcz(str);
        }
    }

    public static void zza(DataLayer dataLayer, zzbr zzbr) {
        if (zzbr.zzyg == null) {
            zzdj.zzcz("supplemental missing experimentSupplemental");
            return;
        }
        for (zzbt zzd : zzbr.zzyg.zzwr) {
            dataLayer.zzlm(zzgk.zzd(zzd));
        }
        for (zzbt zzi : zzbr.zzyg.zzwq) {
            Map map;
            Object zzi2 = zzgk.zzi(zzi);
            if (zzi2 instanceof Map) {
                map = (Map) zzi2;
            } else {
                String valueOf = String.valueOf(zzi2);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 36);
                stringBuilder.append("value: ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" is not a map value, ignored.");
                zzdj.zzcz(stringBuilder.toString());
                map = null;
            }
            if (map != null) {
                dataLayer.push(map);
            }
        }
        zza(dataLayer, zzbr.zzyg);
    }
}
