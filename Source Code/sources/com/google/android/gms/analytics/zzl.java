package com.google.android.gms.analytics;

final class zzl implements Runnable {
    private /* synthetic */ zzg zzdvq;
    private /* synthetic */ zzk zzdvr;

    zzl(zzk zzk, zzg zzg) {
        this.zzdvr = zzk;
        this.zzdvq = zzg;
    }

    public final void run() {
        this.zzdvq.zzwd().zza(this.zzdvq);
        for (zzn zza : this.zzdvr.zzdvl) {
            zza.zza(this.zzdvq);
        }
        zzk.zzb(this.zzdvq);
    }
}
