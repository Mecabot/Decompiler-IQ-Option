package com.google.android.gms.internal;

public final class zzbo extends zzflm<zzbo> {
    private static volatile zzbo[] zzwt;
    public int key;
    public int value;

    public zzbo() {
        this.key = 0;
        this.value = 0;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzbo[] zzu() {
        if (zzwt == null) {
            synchronized (zzflq.zzpvt) {
                if (zzwt == null) {
                    zzwt = new zzbo[0];
                }
            }
        }
        return zzwt;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbo)) {
            return false;
        }
        zzbo zzbo = (zzbo) obj;
        return (this.key == zzbo.key && this.value == zzbo.value) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbo.zzpvl == null || zzbo.zzpvl.isEmpty() : this.zzpvl.equals(zzbo.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        zzflk.zzad(1, this.key);
        zzflk.zzad(2, this.value);
        super.zza(zzflk);
    }

    protected final int zzq() {
        return (super.zzq() + zzflk.zzag(1, this.key)) + zzflk.zzag(2, this.value);
    }
}
