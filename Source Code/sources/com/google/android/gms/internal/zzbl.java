package com.google.android.gms.internal;

public final class zzbl extends zzflm<zzbl> {
    private static volatile zzbl[] zzwg;
    private int name;
    public int[] zzwh;
    private int zzwi;
    private boolean zzwj;
    private boolean zzwk;

    public zzbl() {
        this.zzwh = zzflv.zzpvy;
        this.zzwi = 0;
        this.name = 0;
        this.zzwj = false;
        this.zzwk = false;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzbl[] zzs() {
        if (zzwg == null) {
            synchronized (zzflq.zzpvt) {
                if (zzwg == null) {
                    zzwg = new zzbl[0];
                }
            }
        }
        return zzwg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbl)) {
            return false;
        }
        zzbl zzbl = (zzbl) obj;
        return (zzflq.equals(this.zzwh, zzbl.zzwh) && this.zzwi == zzbl.zzwi && this.name == zzbl.name && this.zzwj == zzbl.zzwj && this.zzwk == zzbl.zzwk) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbl.zzpvl == null || zzbl.zzpvl.isEmpty() : this.zzpvl.equals(zzbl.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzwh)) * 31) + this.zzwi) * 31) + this.name) * 31) + (this.zzwj ? 1231 : 1237)) * 31;
        if (this.zzwk) {
            i = 1231;
        }
        hashCode = (hashCode + i) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzwk) {
            zzflk.zzl(1, this.zzwk);
        }
        zzflk.zzad(2, this.zzwi);
        if (this.zzwh != null && this.zzwh.length > 0) {
            for (int zzad : this.zzwh) {
                zzflk.zzad(3, zzad);
            }
        }
        if (this.name != 0) {
            zzflk.zzad(4, this.name);
        }
        if (this.zzwj) {
            zzflk.zzl(6, this.zzwj);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzwk) {
            zzq += zzflk.zzlw(1) + 1;
        }
        zzq += zzflk.zzag(2, this.zzwi);
        if (this.zzwh != null && this.zzwh.length > 0) {
            int i = 0;
            for (int zzlx : this.zzwh) {
                i += zzflk.zzlx(zzlx);
            }
            zzq = (zzq + i) + (this.zzwh.length * 1);
        }
        if (this.name != 0) {
            zzq += zzflk.zzag(4, this.name);
        }
        return this.zzwj ? zzq + (zzflk.zzlw(6) + 1) : zzq;
    }
}
