package com.google.android.gms.internal;

public final class zzcnz extends zzflm<zzcnz> {
    private static volatile zzcnz[] zzjuc;
    public String key;
    public String value;

    public zzcnz() {
        this.key = null;
        this.value = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzcnz[] zzbcx() {
        if (zzjuc == null) {
            synchronized (zzflq.zzpvt) {
                if (zzjuc == null) {
                    zzjuc = new zzcnz[0];
                }
            }
        }
        return zzjuc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcnz)) {
            return false;
        }
        zzcnz zzcnz = (zzcnz) obj;
        if (this.key == null) {
            if (zzcnz.key != null) {
                return false;
            }
        } else if (!this.key.equals(zzcnz.key)) {
            return false;
        }
        if (this.value == null) {
            if (zzcnz.value != null) {
                return false;
            }
        } else if (!this.value.equals(zzcnz.value)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcnz.zzpvl == null || zzcnz.zzpvl.isEmpty() : this.zzpvl.equals(zzcnz.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.key != null) {
            zzflk.zzp(1, this.key);
        }
        if (this.value != null) {
            zzflk.zzp(2, this.value);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.key != null) {
            zzq += zzflk.zzq(1, this.key);
        }
        return this.value != null ? zzq + zzflk.zzq(2, this.value) : zzq;
    }
}
