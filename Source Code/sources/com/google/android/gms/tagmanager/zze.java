package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zze extends zzbr {
    private static final String ID = zzbh.ADVERTISER_ID.toString();
    private final zza zzkmt;

    public zze(Context context) {
        this(zza.zzeg(context));
    }

    private zze(zza zza) {
        super(ID, new String[0]);
        this.zzkmt = zza;
        this.zzkmt.zzbfb();
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String zzbfb = this.zzkmt.zzbfb();
        return zzbfb == null ? zzgk.zzbil() : zzgk.zzam(zzbfb);
    }
}
