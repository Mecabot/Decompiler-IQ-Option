package com.google.android.gms.internal;

public final class zzcny extends zzflm<zzcny> {
    public String zzjfl;
    public Long zzjtx;
    private Integer zzjty;
    public zzcnz[] zzjtz;
    public zzcnx[] zzjua;
    public zzcnr[] zzjub;

    public zzcny() {
        this.zzjtx = null;
        this.zzjfl = null;
        this.zzjty = null;
        this.zzjtz = zzcnz.zzbcx();
        this.zzjua = zzcnx.zzbcw();
        this.zzjub = zzcnr.zzbcs();
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcny)) {
            return false;
        }
        zzcny zzcny = (zzcny) obj;
        if (this.zzjtx == null) {
            if (zzcny.zzjtx != null) {
                return false;
            }
        } else if (!this.zzjtx.equals(zzcny.zzjtx)) {
            return false;
        }
        if (this.zzjfl == null) {
            if (zzcny.zzjfl != null) {
                return false;
            }
        } else if (!this.zzjfl.equals(zzcny.zzjfl)) {
            return false;
        }
        if (this.zzjty == null) {
            if (zzcny.zzjty != null) {
                return false;
            }
        } else if (!this.zzjty.equals(zzcny.zzjty)) {
            return false;
        }
        return (zzflq.equals(this.zzjtz, zzcny.zzjtz) && zzflq.equals(this.zzjua, zzcny.zzjua) && zzflq.equals(this.zzjub, zzcny.zzjub)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcny.zzpvl == null || zzcny.zzpvl.isEmpty() : this.zzpvl.equals(zzcny.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzjtx == null ? 0 : this.zzjtx.hashCode())) * 31) + (this.zzjfl == null ? 0 : this.zzjfl.hashCode())) * 31) + (this.zzjty == null ? 0 : this.zzjty.hashCode())) * 31) + zzflq.hashCode(this.zzjtz)) * 31) + zzflq.hashCode(this.zzjua)) * 31) + zzflq.hashCode(this.zzjub)) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjtx != null) {
            zzflk.zzf(1, this.zzjtx.longValue());
        }
        if (this.zzjfl != null) {
            zzflk.zzp(2, this.zzjfl);
        }
        if (this.zzjty != null) {
            zzflk.zzad(3, this.zzjty.intValue());
        }
        if (this.zzjtz != null && this.zzjtz.length > 0) {
            for (zzfls zzfls : this.zzjtz) {
                if (zzfls != null) {
                    zzflk.zza(4, zzfls);
                }
            }
        }
        if (this.zzjua != null && this.zzjua.length > 0) {
            for (zzfls zzfls2 : this.zzjua) {
                if (zzfls2 != null) {
                    zzflk.zza(5, zzfls2);
                }
            }
        }
        if (this.zzjub != null && this.zzjub.length > 0) {
            for (zzfls zzfls3 : this.zzjub) {
                if (zzfls3 != null) {
                    zzflk.zza(6, zzfls3);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        if (this.zzjtx != null) {
            zzq += zzflk.zzc(1, this.zzjtx.longValue());
        }
        if (this.zzjfl != null) {
            zzq += zzflk.zzq(2, this.zzjfl);
        }
        if (this.zzjty != null) {
            zzq += zzflk.zzag(3, this.zzjty.intValue());
        }
        if (this.zzjtz != null && this.zzjtz.length > 0) {
            i = zzq;
            for (zzfls zzfls : this.zzjtz) {
                if (zzfls != null) {
                    i += zzflk.zzb(4, zzfls);
                }
            }
            zzq = i;
        }
        if (this.zzjua != null && this.zzjua.length > 0) {
            i = zzq;
            for (zzfls zzfls2 : this.zzjua) {
                if (zzfls2 != null) {
                    i += zzflk.zzb(5, zzfls2);
                }
            }
            zzq = i;
        }
        if (this.zzjub != null && this.zzjub.length > 0) {
            for (zzfls zzfls3 : this.zzjub) {
                if (zzfls3 != null) {
                    zzq += zzflk.zzb(6, zzfls3);
                }
            }
        }
        return zzq;
    }
}
