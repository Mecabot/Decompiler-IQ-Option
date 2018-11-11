package com.google.android.gms.internal;

public final class zzbq extends zzflm<zzbq> {
    private static volatile zzbq[] zzxk;
    public int[] zzxl;
    public int[] zzxm;
    public int[] zzxn;
    public int[] zzxo;
    public int[] zzxp;
    public int[] zzxq;
    public int[] zzxr;
    public int[] zzxs;
    public int[] zzxt;
    public int[] zzxu;

    public zzbq() {
        this.zzxl = zzflv.zzpvy;
        this.zzxm = zzflv.zzpvy;
        this.zzxn = zzflv.zzpvy;
        this.zzxo = zzflv.zzpvy;
        this.zzxp = zzflv.zzpvy;
        this.zzxq = zzflv.zzpvy;
        this.zzxr = zzflv.zzpvy;
        this.zzxs = zzflv.zzpvy;
        this.zzxt = zzflv.zzpvy;
        this.zzxu = zzflv.zzpvy;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzbq[] zzv() {
        if (zzxk == null) {
            synchronized (zzflq.zzpvt) {
                if (zzxk == null) {
                    zzxk = new zzbq[0];
                }
            }
        }
        return zzxk;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbq)) {
            return false;
        }
        zzbq zzbq = (zzbq) obj;
        return (zzflq.equals(this.zzxl, zzbq.zzxl) && zzflq.equals(this.zzxm, zzbq.zzxm) && zzflq.equals(this.zzxn, zzbq.zzxn) && zzflq.equals(this.zzxo, zzbq.zzxo) && zzflq.equals(this.zzxp, zzbq.zzxp) && zzflq.equals(this.zzxq, zzbq.zzxq) && zzflq.equals(this.zzxr, zzbq.zzxr) && zzflq.equals(this.zzxs, zzbq.zzxs) && zzflq.equals(this.zzxt, zzbq.zzxt) && zzflq.equals(this.zzxu, zzbq.zzxu)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbq.zzpvl == null || zzbq.zzpvl.isEmpty() : this.zzpvl.equals(zzbq.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzxl)) * 31) + zzflq.hashCode(this.zzxm)) * 31) + zzflq.hashCode(this.zzxn)) * 31) + zzflq.hashCode(this.zzxo)) * 31) + zzflq.hashCode(this.zzxp)) * 31) + zzflq.hashCode(this.zzxq)) * 31) + zzflq.hashCode(this.zzxr)) * 31) + zzflq.hashCode(this.zzxs)) * 31) + zzflq.hashCode(this.zzxt)) * 31) + zzflq.hashCode(this.zzxu)) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzxl != null && this.zzxl.length > 0) {
            for (int zzad : this.zzxl) {
                zzflk.zzad(1, zzad);
            }
        }
        if (this.zzxm != null && this.zzxm.length > 0) {
            for (int zzad2 : this.zzxm) {
                zzflk.zzad(2, zzad2);
            }
        }
        if (this.zzxn != null && this.zzxn.length > 0) {
            for (int zzad22 : this.zzxn) {
                zzflk.zzad(3, zzad22);
            }
        }
        if (this.zzxo != null && this.zzxo.length > 0) {
            for (int zzad222 : this.zzxo) {
                zzflk.zzad(4, zzad222);
            }
        }
        if (this.zzxp != null && this.zzxp.length > 0) {
            for (int zzad2222 : this.zzxp) {
                zzflk.zzad(5, zzad2222);
            }
        }
        if (this.zzxq != null && this.zzxq.length > 0) {
            for (int zzad22222 : this.zzxq) {
                zzflk.zzad(6, zzad22222);
            }
        }
        if (this.zzxr != null && this.zzxr.length > 0) {
            for (int zzad222222 : this.zzxr) {
                zzflk.zzad(7, zzad222222);
            }
        }
        if (this.zzxs != null && this.zzxs.length > 0) {
            for (int zzad2222222 : this.zzxs) {
                zzflk.zzad(8, zzad2222222);
            }
        }
        if (this.zzxt != null && this.zzxt.length > 0) {
            for (int zzad22222222 : this.zzxt) {
                zzflk.zzad(9, zzad22222222);
            }
        }
        if (this.zzxu != null && this.zzxu.length > 0) {
            for (int zzad3 : this.zzxu) {
                zzflk.zzad(10, zzad3);
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int i2;
        int zzq = super.zzq();
        if (this.zzxl != null && this.zzxl.length > 0) {
            i = 0;
            for (int zzlx : this.zzxl) {
                i += zzflk.zzlx(zzlx);
            }
            zzq = (zzq + i) + (this.zzxl.length * 1);
        }
        if (this.zzxm != null && this.zzxm.length > 0) {
            i = 0;
            for (int zzlx2 : this.zzxm) {
                i += zzflk.zzlx(zzlx2);
            }
            zzq = (zzq + i) + (this.zzxm.length * 1);
        }
        if (this.zzxn != null && this.zzxn.length > 0) {
            i = 0;
            for (int zzlx22 : this.zzxn) {
                i += zzflk.zzlx(zzlx22);
            }
            zzq = (zzq + i) + (this.zzxn.length * 1);
        }
        if (this.zzxo != null && this.zzxo.length > 0) {
            i = 0;
            for (int zzlx222 : this.zzxo) {
                i += zzflk.zzlx(zzlx222);
            }
            zzq = (zzq + i) + (this.zzxo.length * 1);
        }
        if (this.zzxp != null && this.zzxp.length > 0) {
            i = 0;
            for (int zzlx2222 : this.zzxp) {
                i += zzflk.zzlx(zzlx2222);
            }
            zzq = (zzq + i) + (this.zzxp.length * 1);
        }
        if (this.zzxq != null && this.zzxq.length > 0) {
            i = 0;
            for (int zzlx22222 : this.zzxq) {
                i += zzflk.zzlx(zzlx22222);
            }
            zzq = (zzq + i) + (this.zzxq.length * 1);
        }
        if (this.zzxr != null && this.zzxr.length > 0) {
            i = 0;
            for (int zzlx222222 : this.zzxr) {
                i += zzflk.zzlx(zzlx222222);
            }
            zzq = (zzq + i) + (this.zzxr.length * 1);
        }
        if (this.zzxs != null && this.zzxs.length > 0) {
            i = 0;
            for (int zzlx2222222 : this.zzxs) {
                i += zzflk.zzlx(zzlx2222222);
            }
            zzq = (zzq + i) + (this.zzxs.length * 1);
        }
        if (this.zzxt != null && this.zzxt.length > 0) {
            i = 0;
            for (int zzlx22222222 : this.zzxt) {
                i += zzflk.zzlx(zzlx22222222);
            }
            zzq = (zzq + i) + (this.zzxt.length * 1);
        }
        if (this.zzxu == null || this.zzxu.length <= 0) {
            return zzq;
        }
        i2 = 0;
        for (int i3 : this.zzxu) {
            i2 += zzflk.zzlx(i3);
        }
        return (zzq + i2) + (this.zzxu.length * 1);
    }
}
