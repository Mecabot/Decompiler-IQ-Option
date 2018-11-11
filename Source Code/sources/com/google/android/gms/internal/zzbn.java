package com.google.android.gms.internal;

public final class zzbn extends zzflm<zzbn> {
    public zzbt[] zzwq;
    public zzbt[] zzwr;
    public zzbm[] zzws;

    public zzbn() {
        this.zzwq = zzbt.zzx();
        this.zzwr = zzbt.zzx();
        this.zzws = zzbm.zzt();
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbn)) {
            return false;
        }
        zzbn zzbn = (zzbn) obj;
        return (zzflq.equals(this.zzwq, zzbn.zzwq) && zzflq.equals(this.zzwr, zzbn.zzwr) && zzflq.equals(this.zzws, zzbn.zzws)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbn.zzpvl == null || zzbn.zzpvl.isEmpty() : this.zzpvl.equals(zzbn.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzwq)) * 31) + zzflq.hashCode(this.zzwr)) * 31) + zzflq.hashCode(this.zzws)) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzwq != null && this.zzwq.length > 0) {
            for (zzfls zzfls : this.zzwq) {
                if (zzfls != null) {
                    zzflk.zza(1, zzfls);
                }
            }
        }
        if (this.zzwr != null && this.zzwr.length > 0) {
            for (zzfls zzfls2 : this.zzwr) {
                if (zzfls2 != null) {
                    zzflk.zza(2, zzfls2);
                }
            }
        }
        if (this.zzws != null && this.zzws.length > 0) {
            for (zzfls zzfls3 : this.zzws) {
                if (zzfls3 != null) {
                    zzflk.zza(3, zzfls3);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        if (this.zzwq != null && this.zzwq.length > 0) {
            i = zzq;
            for (zzfls zzfls : this.zzwq) {
                if (zzfls != null) {
                    i += zzflk.zzb(1, zzfls);
                }
            }
            zzq = i;
        }
        if (this.zzwr != null && this.zzwr.length > 0) {
            i = zzq;
            for (zzfls zzfls2 : this.zzwr) {
                if (zzfls2 != null) {
                    i += zzflk.zzb(2, zzfls2);
                }
            }
            zzq = i;
        }
        if (this.zzws != null && this.zzws.length > 0) {
            for (zzfls zzfls3 : this.zzws) {
                if (zzfls3 != null) {
                    zzq += zzflk.zzb(3, zzfls3);
                }
            }
        }
        return zzq;
    }
}
