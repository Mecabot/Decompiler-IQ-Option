package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzf extends zzbr {
    private static final String ID = zzbh.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzkmt;

    public zzf(Context context) {
        this(zza.zzeg(context));
    }

    private zzf(zza zza) {
        super(ID, new String[0]);
        this.zzkmt = zza;
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return zzgk.zzam(Boolean.valueOf(this.zzkmt.isLimitAdTrackingEnabled() ^ 1));
    }
}
