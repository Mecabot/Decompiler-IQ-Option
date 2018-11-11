package com.google.android.gms.internal;

public final class zzbr extends zzflm<zzbr> {
    private static volatile zzbr[] zzye;
    public String name;
    private zzbt zzyf;
    public zzbn zzyg;

    public zzbr() {
        this.name = "";
        this.zzyf = null;
        this.zzyg = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzbr[] zzw() {
        if (zzye == null) {
            synchronized (zzflq.zzpvt) {
                if (zzye == null) {
                    zzye = new zzbr[0];
                }
            }
        }
        return zzye;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbr)) {
            return false;
        }
        zzbr zzbr = (zzbr) obj;
        if (this.name == null) {
            if (zzbr.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzbr.name)) {
            return false;
        }
        if (this.zzyf == null) {
            if (zzbr.zzyf != null) {
                return false;
            }
        } else if (!this.zzyf.equals(zzbr.zzyf)) {
            return false;
        }
        if (this.zzyg == null) {
            if (zzbr.zzyg != null) {
                return false;
            }
        } else if (!this.zzyg.equals(zzbr.zzyg)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbr.zzpvl == null || zzbr.zzpvl.isEmpty() : this.zzpvl.equals(zzbr.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode());
        zzbt zzbt = this.zzyf;
        hashCode = (hashCode * 31) + (zzbt == null ? 0 : zzbt.hashCode());
        zzbn zzbn = this.zzyg;
        hashCode = ((hashCode * 31) + (zzbn == null ? 0 : zzbn.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (!(this.name == null || this.name.equals(""))) {
            zzflk.zzp(1, this.name);
        }
        if (this.zzyf != null) {
            zzflk.zza(2, this.zzyf);
        }
        if (this.zzyg != null) {
            zzflk.zza(3, this.zzyg);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!(this.name == null || this.name.equals(""))) {
            zzq += zzflk.zzq(1, this.name);
        }
        if (this.zzyf != null) {
            zzq += zzflk.zzb(2, this.zzyf);
        }
        return this.zzyg != null ? zzq + zzflk.zzb(3, this.zzyg) : zzq;
    }
}
