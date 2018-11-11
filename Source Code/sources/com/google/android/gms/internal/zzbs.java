package com.google.android.gms.internal;

public final class zzbs extends zzflm<zzbs> {
    public zzbr[] zzyh;
    public zzbp zzyi;
    public String zzyj;

    public zzbs() {
        this.zzyh = zzbr.zzw();
        this.zzyi = null;
        this.zzyj = "";
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbs)) {
            return false;
        }
        zzbs zzbs = (zzbs) obj;
        if (!zzflq.equals(this.zzyh, zzbs.zzyh)) {
            return false;
        }
        if (this.zzyi == null) {
            if (zzbs.zzyi != null) {
                return false;
            }
        } else if (!this.zzyi.equals(zzbs.zzyi)) {
            return false;
        }
        if (this.zzyj == null) {
            if (zzbs.zzyj != null) {
                return false;
            }
        } else if (!this.zzyj.equals(zzbs.zzyj)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbs.zzpvl == null || zzbs.zzpvl.isEmpty() : this.zzpvl.equals(zzbs.zzpvl);
    }

    public final int hashCode() {
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzyh);
        zzbp zzbp = this.zzyi;
        int i = 0;
        hashCode = ((((hashCode * 31) + (zzbp == null ? 0 : zzbp.hashCode())) * 31) + (this.zzyj == null ? 0 : this.zzyj.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzyh != null && this.zzyh.length > 0) {
            for (zzfls zzfls : this.zzyh) {
                if (zzfls != null) {
                    zzflk.zza(1, zzfls);
                }
            }
        }
        if (this.zzyi != null) {
            zzflk.zza(2, this.zzyi);
        }
        if (!(this.zzyj == null || this.zzyj.equals(""))) {
            zzflk.zzp(3, this.zzyj);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzyh != null && this.zzyh.length > 0) {
            for (zzfls zzfls : this.zzyh) {
                if (zzfls != null) {
                    zzq += zzflk.zzb(1, zzfls);
                }
            }
        }
        if (this.zzyi != null) {
            zzq += zzflk.zzb(2, this.zzyi);
        }
        return (this.zzyj == null || this.zzyj.equals("")) ? zzq : zzq + zzflk.zzq(3, this.zzyj);
    }
}
