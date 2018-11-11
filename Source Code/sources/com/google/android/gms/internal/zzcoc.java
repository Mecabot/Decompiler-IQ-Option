package com.google.android.gms.internal;

public final class zzcoc extends zzflm<zzcoc> {
    private static volatile zzcoc[] zzjul;
    public String name;
    public String zzgim;
    private Float zzjsk;
    public Double zzjsl;
    public Long zzjum;

    public zzcoc() {
        this.name = null;
        this.zzgim = null;
        this.zzjum = null;
        this.zzjsk = null;
        this.zzjsl = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzcoc[] zzbda() {
        if (zzjul == null) {
            synchronized (zzflq.zzpvt) {
                if (zzjul == null) {
                    zzjul = new zzcoc[0];
                }
            }
        }
        return zzjul;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcoc)) {
            return false;
        }
        zzcoc zzcoc = (zzcoc) obj;
        if (this.name == null) {
            if (zzcoc.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcoc.name)) {
            return false;
        }
        if (this.zzgim == null) {
            if (zzcoc.zzgim != null) {
                return false;
            }
        } else if (!this.zzgim.equals(zzcoc.zzgim)) {
            return false;
        }
        if (this.zzjum == null) {
            if (zzcoc.zzjum != null) {
                return false;
            }
        } else if (!this.zzjum.equals(zzcoc.zzjum)) {
            return false;
        }
        if (this.zzjsk == null) {
            if (zzcoc.zzjsk != null) {
                return false;
            }
        } else if (!this.zzjsk.equals(zzcoc.zzjsk)) {
            return false;
        }
        if (this.zzjsl == null) {
            if (zzcoc.zzjsl != null) {
                return false;
            }
        } else if (!this.zzjsl.equals(zzcoc.zzjsl)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcoc.zzpvl == null || zzcoc.zzpvl.isEmpty() : this.zzpvl.equals(zzcoc.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzgim == null ? 0 : this.zzgim.hashCode())) * 31) + (this.zzjum == null ? 0 : this.zzjum.hashCode())) * 31) + (this.zzjsk == null ? 0 : this.zzjsk.hashCode())) * 31) + (this.zzjsl == null ? 0 : this.zzjsl.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.name != null) {
            zzflk.zzp(1, this.name);
        }
        if (this.zzgim != null) {
            zzflk.zzp(2, this.zzgim);
        }
        if (this.zzjum != null) {
            zzflk.zzf(3, this.zzjum.longValue());
        }
        if (this.zzjsk != null) {
            zzflk.zzd(4, this.zzjsk.floatValue());
        }
        if (this.zzjsl != null) {
            zzflk.zza(5, this.zzjsl.doubleValue());
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.name != null) {
            zzq += zzflk.zzq(1, this.name);
        }
        if (this.zzgim != null) {
            zzq += zzflk.zzq(2, this.zzgim);
        }
        if (this.zzjum != null) {
            zzq += zzflk.zzc(3, this.zzjum.longValue());
        }
        if (this.zzjsk != null) {
            this.zzjsk.floatValue();
            zzq += zzflk.zzlw(4) + 4;
        }
        if (this.zzjsl == null) {
            return zzq;
        }
        this.zzjsl.doubleValue();
        return zzq + (zzflk.zzlw(5) + 8);
    }
}
