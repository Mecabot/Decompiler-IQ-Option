package com.google.android.gms.internal;

public final class zzcof extends zzflm<zzcof> {
    public long[] zzjvo;
    public long[] zzjvp;

    public zzcof() {
        this.zzjvo = zzflv.zzpvz;
        this.zzjvp = zzflv.zzpvz;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcof)) {
            return false;
        }
        zzcof zzcof = (zzcof) obj;
        return (zzflq.equals(this.zzjvo, zzcof.zzjvo) && zzflq.equals(this.zzjvp, zzcof.zzjvp)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcof.zzpvl == null || zzcof.zzpvl.isEmpty() : this.zzpvl.equals(zzcof.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzjvo)) * 31) + zzflq.hashCode(this.zzjvp)) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjvo != null && this.zzjvo.length > 0) {
            for (long zza : this.zzjvo) {
                zzflk.zza(1, zza);
            }
        }
        if (this.zzjvp != null && this.zzjvp.length > 0) {
            for (long zza2 : this.zzjvp) {
                zzflk.zza(2, zza2);
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        if (this.zzjvo != null && this.zzjvo.length > 0) {
            int i2 = 0;
            for (long zzdj : this.zzjvo) {
                i2 += zzflk.zzdj(zzdj);
            }
            zzq = (zzq + i2) + (this.zzjvo.length * 1);
        }
        if (this.zzjvp == null || this.zzjvp.length <= 0) {
            return zzq;
        }
        i = 0;
        for (long zzdj2 : this.zzjvp) {
            i += zzflk.zzdj(zzdj2);
        }
        return (zzq + i) + (this.zzjvp.length * 1);
    }
}
