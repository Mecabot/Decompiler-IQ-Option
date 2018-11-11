package com.google.android.gms.internal;

public final class zzdkf extends zzflm<zzdkf> {
    public long zzldl;
    public zzbs zzldm;
    public zzbp zzyi;

    public zzdkf() {
        this.zzldl = 0;
        this.zzyi = null;
        this.zzldm = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdkf)) {
            return false;
        }
        zzdkf zzdkf = (zzdkf) obj;
        if (this.zzldl != zzdkf.zzldl) {
            return false;
        }
        if (this.zzyi == null) {
            if (zzdkf.zzyi != null) {
                return false;
            }
        } else if (!this.zzyi.equals(zzdkf.zzyi)) {
            return false;
        }
        if (this.zzldm == null) {
            if (zzdkf.zzldm != null) {
                return false;
            }
        } else if (!this.zzldm.equals(zzdkf.zzldm)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzdkf.zzpvl == null || zzdkf.zzpvl.isEmpty() : this.zzpvl.equals(zzdkf.zzpvl);
    }

    public final int hashCode() {
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzldl ^ (this.zzldl >>> 32)));
        zzbp zzbp = this.zzyi;
        int i = 0;
        hashCode = (hashCode * 31) + (zzbp == null ? 0 : zzbp.hashCode());
        zzbs zzbs = this.zzldm;
        hashCode = ((hashCode * 31) + (zzbs == null ? 0 : zzbs.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        zzflk.zzf(1, this.zzldl);
        if (this.zzyi != null) {
            zzflk.zza(2, this.zzyi);
        }
        if (this.zzldm != null) {
            zzflk.zza(3, this.zzldm);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq() + zzflk.zzc(1, this.zzldl);
        if (this.zzyi != null) {
            zzq += zzflk.zzb(2, this.zzyi);
        }
        return this.zzldm != null ? zzq + zzflk.zzb(3, this.zzldm) : zzq;
    }
}
