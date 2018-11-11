package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.List;

@Hide
public class zzj<T extends zzj> {
    private final zzk zzdvh;
    @Hide
    protected final zzg zzdvi;
    private final List<zzh> zzdvj = new ArrayList();

    protected zzj(zzk zzk, zze zze) {
        zzbq.checkNotNull(zzk);
        this.zzdvh = zzk;
        zzg zzg = new zzg(this, zze);
        zzg.zzwf();
        this.zzdvi = zzg;
    }

    @Hide
    protected void zza(zzg zzg) {
    }

    @Hide
    protected final void zzd(zzg zzg) {
        for (zzh zza : this.zzdvj) {
            zza.zza(this, zzg);
        }
    }

    @Hide
    public zzg zzvs() {
        zzg zzvx = this.zzdvi.zzvx();
        zzd(zzvx);
        return zzvx;
    }

    @Hide
    protected final zzk zzwg() {
        return this.zzdvh;
    }
}
