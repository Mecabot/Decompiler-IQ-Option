package com.google.android.gms.internal;

public final class zzcnr extends zzflm<zzcnr> {
    private static volatile zzcnr[] zzjss;
    public Integer zzjst;
    public zzcnv[] zzjsu;
    public zzcns[] zzjsv;

    public zzcnr() {
        this.zzjst = null;
        this.zzjsu = zzcnv.zzbcv();
        this.zzjsv = zzcns.zzbct();
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzcnr[] zzbcs() {
        if (zzjss == null) {
            synchronized (zzflq.zzpvt) {
                if (zzjss == null) {
                    zzjss = new zzcnr[0];
                }
            }
        }
        return zzjss;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcnr)) {
            return false;
        }
        zzcnr zzcnr = (zzcnr) obj;
        if (this.zzjst == null) {
            if (zzcnr.zzjst != null) {
                return false;
            }
        } else if (!this.zzjst.equals(zzcnr.zzjst)) {
            return false;
        }
        return (zzflq.equals(this.zzjsu, zzcnr.zzjsu) && zzflq.equals(this.zzjsv, zzcnr.zzjsv)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcnr.zzpvl == null || zzcnr.zzpvl.isEmpty() : this.zzpvl.equals(zzcnr.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + (this.zzjst == null ? 0 : this.zzjst.hashCode())) * 31) + zzflq.hashCode(this.zzjsu)) * 31) + zzflq.hashCode(this.zzjsv)) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjst != null) {
            zzflk.zzad(1, this.zzjst.intValue());
        }
        if (this.zzjsu != null && this.zzjsu.length > 0) {
            for (zzfls zzfls : this.zzjsu) {
                if (zzfls != null) {
                    zzflk.zza(2, zzfls);
                }
            }
        }
        if (this.zzjsv != null && this.zzjsv.length > 0) {
            for (zzfls zzfls2 : this.zzjsv) {
                if (zzfls2 != null) {
                    zzflk.zza(3, zzfls2);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjst != null) {
            zzq += zzflk.zzag(1, this.zzjst.intValue());
        }
        if (this.zzjsu != null && this.zzjsu.length > 0) {
            int i = zzq;
            for (zzfls zzfls : this.zzjsu) {
                if (zzfls != null) {
                    i += zzflk.zzb(2, zzfls);
                }
            }
            zzq = i;
        }
        if (this.zzjsv != null && this.zzjsv.length > 0) {
            for (zzfls zzfls2 : this.zzjsv) {
                if (zzfls2 != null) {
                    zzq += zzflk.zzb(3, zzfls2);
                }
            }
        }
        return zzq;
    }
}
