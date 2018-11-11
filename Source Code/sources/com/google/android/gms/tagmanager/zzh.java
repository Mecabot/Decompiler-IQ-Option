package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzh extends zzbr {
    private static final String ID = zzbh.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzkmu = zzbi.COMPONENT.toString();
    private static final String zzkmv = zzbi.CONVERSION_ID.toString();
    private final Context zzaiq;

    public zzh(Context context) {
        super(ID, zzkmv);
        this.zzaiq = context;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        zzbt zzbt = (zzbt) map.get(zzkmv);
        if (zzbt == null) {
            return zzgk.zzbil();
        }
        String zzd = zzgk.zzd(zzbt);
        zzbt zzbt2 = (zzbt) map.get(zzkmu);
        String zzd2 = zzbt2 != null ? zzgk.zzd(zzbt2) : null;
        Context context = this.zzaiq;
        String str = (String) zzcx.zzkqe.get(zzd);
        if (str == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str = sharedPreferences != null ? sharedPreferences.getString(zzd, "") : "";
            zzcx.zzkqe.put(zzd, str);
        }
        zzd2 = zzcx.zzaw(str, zzd2);
        return zzd2 != null ? zzgk.zzam(zzd2) : zzgk.zzbil();
    }
}
