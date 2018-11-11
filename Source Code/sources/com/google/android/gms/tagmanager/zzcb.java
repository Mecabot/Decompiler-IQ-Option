package com.google.android.gms.tagmanager;

final class zzcb implements Runnable {
    private /* synthetic */ String zzcrd;
    private /* synthetic */ zzbz zzkqa;
    private /* synthetic */ long zzkqb;
    private /* synthetic */ zzca zzkqc;

    zzcb(zzca zzca, zzbz zzbz, long j, String str) {
        this.zzkqc = zzca;
        this.zzkqa = zzbz;
        this.zzkqb = j;
        this.zzcrd = str;
    }

    public final void run() {
        if (this.zzkqc.zzkpz == null) {
            zzfo zzbhz = zzfo.zzbhz();
            zzbhz.zza(this.zzkqc.mContext, this.zzkqa);
            this.zzkqc.zzkpz = zzbhz.zzbia();
        }
        this.zzkqc.zzkpz.zzb(this.zzkqb, this.zzcrd);
    }
}
