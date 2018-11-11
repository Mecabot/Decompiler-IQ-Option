package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.zzd;

final class zzg implements zzd {
    zzg() {
    }

    public final zzj zza(Context context, String str, zzi zzi) {
        zzj zzj = new zzj();
        zzj.zzhds = zzi.zzx(context, str);
        zzj.zzhdt = zzj.zzhds != 0 ? zzi.zzc(context, str, false) : zzi.zzc(context, str, true);
        if (zzj.zzhds == 0 && zzj.zzhdt == 0) {
            zzj.zzhdu = 0;
            return zzj;
        } else if (zzj.zzhdt >= zzj.zzhds) {
            zzj.zzhdu = 1;
            return zzj;
        } else {
            zzj.zzhdu = -1;
            return zzj;
        }
    }
}
