package com.google.android.gms.internal;

public final class zzcoa extends zzflm<zzcoa> {
    private static volatile zzcoa[] zzjud;
    public Integer zzjst;
    public zzcof zzjue;
    public zzcof zzjuf;
    public Boolean zzjug;

    public zzcoa() {
        this.zzjst = null;
        this.zzjue = null;
        this.zzjuf = null;
        this.zzjug = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzcoa[] zzbcy() {
        if (zzjud == null) {
            synchronized (zzflq.zzpvt) {
                if (zzjud == null) {
                    zzjud = new zzcoa[0];
                }
            }
        }
        return zzjud;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcoa)) {
            return false;
        }
        zzcoa zzcoa = (zzcoa) obj;
        if (this.zzjst == null) {
            if (zzcoa.zzjst != null) {
                return false;
            }
        } else if (!this.zzjst.equals(zzcoa.zzjst)) {
            return false;
        }
        if (this.zzjue == null) {
            if (zzcoa.zzjue != null) {
                return false;
            }
        } else if (!this.zzjue.equals(zzcoa.zzjue)) {
            return false;
        }
        if (this.zzjuf == null) {
            if (zzcoa.zzjuf != null) {
                return false;
            }
        } else if (!this.zzjuf.equals(zzcoa.zzjuf)) {
            return false;
        }
        if (this.zzjug == null) {
            if (zzcoa.zzjug != null) {
                return false;
            }
        } else if (!this.zzjug.equals(zzcoa.zzjug)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcoa.zzpvl == null || zzcoa.zzpvl.isEmpty() : this.zzpvl.equals(zzcoa.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.zzjst == null ? 0 : this.zzjst.hashCode());
        zzcof zzcof = this.zzjue;
        hashCode = (hashCode * 31) + (zzcof == null ? 0 : zzcof.hashCode());
        zzcof = this.zzjuf;
        hashCode = ((((hashCode * 31) + (zzcof == null ? 0 : zzcof.hashCode())) * 31) + (this.zzjug == null ? 0 : this.zzjug.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjst != null) {
            zzflk.zzad(1, this.zzjst.intValue());
        }
        if (this.zzjue != null) {
            zzflk.zza(2, this.zzjue);
        }
        if (this.zzjuf != null) {
            zzflk.zza(3, this.zzjuf);
        }
        if (this.zzjug != null) {
            zzflk.zzl(4, this.zzjug.booleanValue());
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjst != null) {
            zzq += zzflk.zzag(1, this.zzjst.intValue());
        }
        if (this.zzjue != null) {
            zzq += zzflk.zzb(2, this.zzjue);
        }
        if (this.zzjuf != null) {
            zzq += zzflk.zzb(3, this.zzjuf);
        }
        if (this.zzjug == null) {
            return zzq;
        }
        this.zzjug.booleanValue();
        return zzq + (zzflk.zzlw(4) + 1);
    }
}
