package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzcw extends zzbr {
    private static final String ID = zzbh.INSTALL_REFERRER.toString();
    private static final String zzkmu = zzbi.COMPONENT.toString();
    private final Context zzaiq;

    public zzcw(Context context) {
        super(ID, new String[0]);
        this.zzaiq = context;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String zzaf = zzcx.zzaf(this.zzaiq, ((zzbt) map.get(zzkmu)) != null ? zzgk.zzd((zzbt) map.get(zzkmu)) : null);
        return zzaf != null ? zzgk.zzam(zzaf) : zzgk.zzbil();
    }
}
