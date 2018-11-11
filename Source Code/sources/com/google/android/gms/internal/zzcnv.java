package com.google.android.gms.internal;

public final class zzcnv extends zzflm<zzcnv> {
    private static volatile zzcnv[] zzjtm;
    public Integer zzjsx;
    public String zzjtn;
    public zzcnt zzjto;

    public zzcnv() {
        this.zzjsx = null;
        this.zzjtn = null;
        this.zzjto = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzcnv[] zzbcv() {
        if (zzjtm == null) {
            synchronized (zzflq.zzpvt) {
                if (zzjtm == null) {
                    zzjtm = new zzcnv[0];
                }
            }
        }
        return zzjtm;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcnv)) {
            return false;
        }
        zzcnv zzcnv = (zzcnv) obj;
        if (this.zzjsx == null) {
            if (zzcnv.zzjsx != null) {
                return false;
            }
        } else if (!this.zzjsx.equals(zzcnv.zzjsx)) {
            return false;
        }
        if (this.zzjtn == null) {
            if (zzcnv.zzjtn != null) {
                return false;
            }
        } else if (!this.zzjtn.equals(zzcnv.zzjtn)) {
            return false;
        }
        if (this.zzjto == null) {
            if (zzcnv.zzjto != null) {
                return false;
            }
        } else if (!this.zzjto.equals(zzcnv.zzjto)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcnv.zzpvl == null || zzcnv.zzpvl.isEmpty() : this.zzpvl.equals(zzcnv.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((getClass().getName().hashCode() + 527) * 31) + (this.zzjsx == null ? 0 : this.zzjsx.hashCode())) * 31) + (this.zzjtn == null ? 0 : this.zzjtn.hashCode());
        zzcnt zzcnt = this.zzjto;
        hashCode = ((hashCode * 31) + (zzcnt == null ? 0 : zzcnt.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjsx != null) {
            zzflk.zzad(1, this.zzjsx.intValue());
        }
        if (this.zzjtn != null) {
            zzflk.zzp(2, this.zzjtn);
        }
        if (this.zzjto != null) {
            zzflk.zza(3, this.zzjto);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjsx != null) {
            zzq += zzflk.zzag(1, this.zzjsx.intValue());
        }
        if (this.zzjtn != null) {
            zzq += zzflk.zzq(2, this.zzjtn);
        }
        return this.zzjto != null ? zzq + zzflk.zzb(3, this.zzjto) : zzq;
    }
}
