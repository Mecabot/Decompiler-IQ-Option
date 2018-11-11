package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzam extends zzbr {
    private static final String ID = zzbh.FUNCTION_CALL.toString();
    private static final String zzkmw = zzbi.ADDITIONAL_PARAMS.toString();
    private static final String zzkoh = zzbi.FUNCTION_CALL_NAME.toString();
    private final zzan zzkoi;

    public zzam(zzan zzan) {
        super(ID, zzkoh);
        this.zzkoi = zzan;
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String str;
        String zzd = zzgk.zzd((zzbt) map.get(zzkoh));
        Map hashMap = new HashMap();
        zzbt zzbt = (zzbt) map.get(zzkmw);
        if (zzbt != null) {
            Object zzi = zzgk.zzi(zzbt);
            if (zzi instanceof Map) {
                for (Entry entry : ((Map) zzi).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                str = "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.";
                zzdj.zzcz(str);
                return zzgk.zzbil();
            }
        }
        try {
            return zzgk.zzam(this.zzkoi.zze(zzd, hashMap));
        } catch (Exception e) {
            str = e.getMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzd).length() + 34) + String.valueOf(str).length());
            stringBuilder.append("Custom macro/tag ");
            stringBuilder.append(zzd);
            stringBuilder.append(" threw exception ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
    }
}
