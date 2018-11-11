package com.google.android.gms.internal;

public final class zzbm extends zzflm<zzbm> {
    private static volatile zzbm[] zzwl;
    public String key;
    public long zzwm;
    public long zzwn;
    public boolean zzwo;
    public long zzwp;

    public zzbm() {
        this.key = "";
        this.zzwm = 0;
        this.zzwn = 2147483647L;
        this.zzwo = false;
        this.zzwp = 0;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzbm[] zzt() {
        if (zzwl == null) {
            synchronized (zzflq.zzpvt) {
                if (zzwl == null) {
                    zzwl = new zzbm[0];
                }
            }
        }
        return zzwl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbm)) {
            return false;
        }
        zzbm zzbm = (zzbm) obj;
        if (this.key == null) {
            if (zzbm.key != null) {
                return false;
            }
        } else if (!this.key.equals(zzbm.key)) {
            return false;
        }
        return (this.zzwm == zzbm.zzwm && this.zzwn == zzbm.zzwn && this.zzwo == zzbm.zzwo && this.zzwp == zzbm.zzwp) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbm.zzpvl == null || zzbm.zzpvl.isEmpty() : this.zzpvl.equals(zzbm.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + ((int) (this.zzwm ^ (this.zzwm >>> 32)))) * 31) + ((int) (this.zzwn ^ (this.zzwn >>> 32)))) * 31) + (this.zzwo ? 1231 : 1237)) * 31) + ((int) (this.zzwp ^ (this.zzwp >>> 32)))) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (!(this.key == null || this.key.equals(""))) {
            zzflk.zzp(1, this.key);
        }
        if (this.zzwm != 0) {
            zzflk.zzf(2, this.zzwm);
        }
        if (this.zzwn != 2147483647L) {
            zzflk.zzf(3, this.zzwn);
        }
        if (this.zzwo) {
            zzflk.zzl(4, this.zzwo);
        }
        if (this.zzwp != 0) {
            zzflk.zzf(5, this.zzwp);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!(this.key == null || this.key.equals(""))) {
            zzq += zzflk.zzq(1, this.key);
        }
        if (this.zzwm != 0) {
            zzq += zzflk.zzc(2, this.zzwm);
        }
        if (this.zzwn != 2147483647L) {
            zzq += zzflk.zzc(3, this.zzwn);
        }
        if (this.zzwo) {
            zzq += zzflk.zzlw(4) + 1;
        }
        return this.zzwp != 0 ? zzq + zzflk.zzc(5, this.zzwp) : zzq;
    }
}
