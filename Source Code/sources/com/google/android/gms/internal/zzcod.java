package com.google.android.gms.internal;

public final class zzcod extends zzflm<zzcod> {
    public zzcoe[] zzjun;

    public zzcod() {
        this.zzjun = zzcoe.zzbdb();
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcod)) {
            return false;
        }
        zzcod zzcod = (zzcod) obj;
        return !zzflq.equals(this.zzjun, zzcod.zzjun) ? false : (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcod.zzpvl == null || zzcod.zzpvl.isEmpty() : this.zzpvl.equals(zzcod.zzpvl);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzjun)) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjun != null && this.zzjun.length > 0) {
            for (zzfls zzfls : this.zzjun) {
                if (zzfls != null) {
                    zzflk.zza(1, zzfls);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjun != null && this.zzjun.length > 0) {
            for (zzfls zzfls : this.zzjun) {
                if (zzfls != null) {
                    zzq += zzflk.zzb(1, zzfls);
                }
            }
        }
        return zzq;
    }
}
