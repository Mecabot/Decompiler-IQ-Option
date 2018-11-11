package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzdkf;

final class zzad implements zzdi<zzdkf> {
    private /* synthetic */ zzy zzkod;

    private zzad(zzy zzy) {
        this.zzkod = zzy;
    }

    /* synthetic */ zzad(zzy zzy, zzz zzz) {
        this(zzy);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbs zzbs;
        zzdkf zzdkf = (zzdkf) obj;
        if (zzdkf.zzldm != null) {
            zzbs = zzdkf.zzldm;
        } else {
            zzbp zzbp = zzdkf.zzyi;
            zzbs zzbs2 = new zzbs();
            zzbs2.zzyi = zzbp;
            zzbs2.zzyh = null;
            zzbs2.zzyj = zzbp.version;
            zzbs = zzbs2;
        }
        this.zzkod.zza(zzbs, zzdkf.zzldl, true);
    }

    public final void zzbfu() {
    }

    public final void zzex(int i) {
        if (!this.zzkod.zzkny) {
            this.zzkod.zzbg(0);
        }
    }
}
