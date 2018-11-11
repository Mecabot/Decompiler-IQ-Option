package com.google.android.gms.dynamite;

import android.content.Context;

final class zzd implements com.google.android.gms.dynamite.DynamiteModule.zzd {
    zzd() {
    }

    public final zzj zza(Context context, String str, zzi zzi) {
        int i;
        zzj zzj = new zzj();
        zzj.zzhds = zzi.zzx(context, str);
        zzj.zzhdt = zzi.zzc(context, str, true);
        if (zzj.zzhds == 0 && zzj.zzhdt == 0) {
            i = 0;
        } else if (zzj.zzhds >= zzj.zzhdt) {
            i = -1;
        } else {
            zzj.zzhdu = 1;
            return zzj;
        }
        zzj.zzhdu = i;
        return zzj;
    }
}
