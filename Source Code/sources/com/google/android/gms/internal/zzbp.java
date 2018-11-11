package com.google.android.gms.internal;

public final class zzbp extends zzflm<zzbp> {
    public String version;
    private String[] zzwu;
    public String[] zzwv;
    public zzbt[] zzww;
    public zzbo[] zzwx;
    public zzbl[] zzwy;
    public zzbl[] zzwz;
    public zzbl[] zzxa;
    public zzbq[] zzxb;
    private String zzxc;
    private String zzxd;
    private String zzxe;
    private zzbk zzxf;
    private float zzxg;
    private boolean zzxh;
    private String[] zzxi;
    public int zzxj;

    public zzbp() {
        this.zzwu = zzflv.EMPTY_STRING_ARRAY;
        this.zzwv = zzflv.EMPTY_STRING_ARRAY;
        this.zzww = zzbt.zzx();
        this.zzwx = zzbo.zzu();
        this.zzwy = zzbl.zzs();
        this.zzwz = zzbl.zzs();
        this.zzxa = zzbl.zzs();
        this.zzxb = zzbq.zzv();
        this.zzxc = "";
        this.zzxd = "";
        this.zzxe = "0";
        this.version = "";
        this.zzxf = null;
        this.zzxg = 0.0f;
        this.zzxh = false;
        this.zzxi = zzflv.EMPTY_STRING_ARRAY;
        this.zzxj = 0;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbp)) {
            return false;
        }
        zzbp zzbp = (zzbp) obj;
        if (!zzflq.equals(this.zzwu, zzbp.zzwu) || !zzflq.equals(this.zzwv, zzbp.zzwv) || !zzflq.equals(this.zzww, zzbp.zzww) || !zzflq.equals(this.zzwx, zzbp.zzwx) || !zzflq.equals(this.zzwy, zzbp.zzwy) || !zzflq.equals(this.zzwz, zzbp.zzwz) || !zzflq.equals(this.zzxa, zzbp.zzxa) || !zzflq.equals(this.zzxb, zzbp.zzxb)) {
            return false;
        }
        if (this.zzxc == null) {
            if (zzbp.zzxc != null) {
                return false;
            }
        } else if (!this.zzxc.equals(zzbp.zzxc)) {
            return false;
        }
        if (this.zzxd == null) {
            if (zzbp.zzxd != null) {
                return false;
            }
        } else if (!this.zzxd.equals(zzbp.zzxd)) {
            return false;
        }
        if (this.zzxe == null) {
            if (zzbp.zzxe != null) {
                return false;
            }
        } else if (!this.zzxe.equals(zzbp.zzxe)) {
            return false;
        }
        if (this.version == null) {
            if (zzbp.version != null) {
                return false;
            }
        } else if (!this.version.equals(zzbp.version)) {
            return false;
        }
        if (this.zzxf == null) {
            if (zzbp.zzxf != null) {
                return false;
            }
        } else if (!this.zzxf.equals(zzbp.zzxf)) {
            return false;
        }
        return (Float.floatToIntBits(this.zzxg) == Float.floatToIntBits(zzbp.zzxg) && this.zzxh == zzbp.zzxh && zzflq.equals(this.zzxi, zzbp.zzxi) && this.zzxj == zzbp.zzxj) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbp.zzpvl == null || zzbp.zzpvl.isEmpty() : this.zzpvl.equals(zzbp.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzwu)) * 31) + zzflq.hashCode(this.zzwv)) * 31) + zzflq.hashCode(this.zzww)) * 31) + zzflq.hashCode(this.zzwx)) * 31) + zzflq.hashCode(this.zzwy)) * 31) + zzflq.hashCode(this.zzwz)) * 31) + zzflq.hashCode(this.zzxa)) * 31) + zzflq.hashCode(this.zzxb)) * 31) + (this.zzxc == null ? 0 : this.zzxc.hashCode())) * 31) + (this.zzxd == null ? 0 : this.zzxd.hashCode())) * 31) + (this.zzxe == null ? 0 : this.zzxe.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode());
        zzbk zzbk = this.zzxf;
        hashCode = ((((((((((hashCode * 31) + (zzbk == null ? 0 : zzbk.hashCode())) * 31) + Float.floatToIntBits(this.zzxg)) * 31) + (this.zzxh ? 1231 : 1237)) * 31) + zzflq.hashCode(this.zzxi)) * 31) + this.zzxj) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzwv != null && this.zzwv.length > 0) {
            for (String str : this.zzwv) {
                if (str != null) {
                    zzflk.zzp(1, str);
                }
            }
        }
        if (this.zzww != null && this.zzww.length > 0) {
            for (zzfls zzfls : this.zzww) {
                if (zzfls != null) {
                    zzflk.zza(2, zzfls);
                }
            }
        }
        if (this.zzwx != null && this.zzwx.length > 0) {
            for (zzfls zzfls2 : this.zzwx) {
                if (zzfls2 != null) {
                    zzflk.zza(3, zzfls2);
                }
            }
        }
        if (this.zzwy != null && this.zzwy.length > 0) {
            for (zzfls zzfls22 : this.zzwy) {
                if (zzfls22 != null) {
                    zzflk.zza(4, zzfls22);
                }
            }
        }
        if (this.zzwz != null && this.zzwz.length > 0) {
            for (zzfls zzfls222 : this.zzwz) {
                if (zzfls222 != null) {
                    zzflk.zza(5, zzfls222);
                }
            }
        }
        if (this.zzxa != null && this.zzxa.length > 0) {
            for (zzfls zzfls2222 : this.zzxa) {
                if (zzfls2222 != null) {
                    zzflk.zza(6, zzfls2222);
                }
            }
        }
        if (this.zzxb != null && this.zzxb.length > 0) {
            for (zzfls zzfls22222 : this.zzxb) {
                if (zzfls22222 != null) {
                    zzflk.zza(7, zzfls22222);
                }
            }
        }
        if (!(this.zzxc == null || this.zzxc.equals(""))) {
            zzflk.zzp(9, this.zzxc);
        }
        if (!(this.zzxd == null || this.zzxd.equals(""))) {
            zzflk.zzp(10, this.zzxd);
        }
        if (!(this.zzxe == null || this.zzxe.equals("0"))) {
            zzflk.zzp(12, this.zzxe);
        }
        if (!(this.version == null || this.version.equals(""))) {
            zzflk.zzp(13, this.version);
        }
        if (this.zzxf != null) {
            zzflk.zza(14, this.zzxf);
        }
        if (Float.floatToIntBits(this.zzxg) != Float.floatToIntBits(0.0f)) {
            zzflk.zzd(15, this.zzxg);
        }
        if (this.zzxi != null && this.zzxi.length > 0) {
            for (String str2 : this.zzxi) {
                if (str2 != null) {
                    zzflk.zzp(16, str2);
                }
            }
        }
        if (this.zzxj != 0) {
            zzflk.zzad(17, this.zzxj);
        }
        if (this.zzxh) {
            zzflk.zzl(18, this.zzxh);
        }
        if (this.zzwu != null && this.zzwu.length > 0) {
            for (String str3 : this.zzwu) {
                if (str3 != null) {
                    zzflk.zzp(19, str3);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int i2;
        int zzq = super.zzq();
        if (this.zzwv != null && this.zzwv.length > 0) {
            int i3 = 0;
            i = 0;
            for (String str : this.zzwv) {
                if (str != null) {
                    i++;
                    i3 += zzflk.zztx(str);
                }
            }
            zzq = (zzq + i3) + (i * 1);
        }
        if (this.zzww != null && this.zzww.length > 0) {
            i2 = zzq;
            for (zzfls zzfls : this.zzww) {
                if (zzfls != null) {
                    i2 += zzflk.zzb(2, zzfls);
                }
            }
            zzq = i2;
        }
        if (this.zzwx != null && this.zzwx.length > 0) {
            i2 = zzq;
            for (zzfls zzfls2 : this.zzwx) {
                if (zzfls2 != null) {
                    i2 += zzflk.zzb(3, zzfls2);
                }
            }
            zzq = i2;
        }
        if (this.zzwy != null && this.zzwy.length > 0) {
            i2 = zzq;
            for (zzfls zzfls3 : this.zzwy) {
                if (zzfls3 != null) {
                    i2 += zzflk.zzb(4, zzfls3);
                }
            }
            zzq = i2;
        }
        if (this.zzwz != null && this.zzwz.length > 0) {
            i2 = zzq;
            for (zzfls zzfls32 : this.zzwz) {
                if (zzfls32 != null) {
                    i2 += zzflk.zzb(5, zzfls32);
                }
            }
            zzq = i2;
        }
        if (this.zzxa != null && this.zzxa.length > 0) {
            i2 = zzq;
            for (zzfls zzfls322 : this.zzxa) {
                if (zzfls322 != null) {
                    i2 += zzflk.zzb(6, zzfls322);
                }
            }
            zzq = i2;
        }
        if (this.zzxb != null && this.zzxb.length > 0) {
            i2 = zzq;
            for (zzfls zzfls3222 : this.zzxb) {
                if (zzfls3222 != null) {
                    i2 += zzflk.zzb(7, zzfls3222);
                }
            }
            zzq = i2;
        }
        if (!(this.zzxc == null || this.zzxc.equals(""))) {
            zzq += zzflk.zzq(9, this.zzxc);
        }
        if (!(this.zzxd == null || this.zzxd.equals(""))) {
            zzq += zzflk.zzq(10, this.zzxd);
        }
        if (!(this.zzxe == null || this.zzxe.equals("0"))) {
            zzq += zzflk.zzq(12, this.zzxe);
        }
        if (!(this.version == null || this.version.equals(""))) {
            zzq += zzflk.zzq(13, this.version);
        }
        if (this.zzxf != null) {
            zzq += zzflk.zzb(14, this.zzxf);
        }
        if (Float.floatToIntBits(this.zzxg) != Float.floatToIntBits(0.0f)) {
            zzq += zzflk.zzlw(15) + 4;
        }
        if (this.zzxi != null && this.zzxi.length > 0) {
            i = 0;
            int i4 = 0;
            for (String str2 : this.zzxi) {
                if (str2 != null) {
                    i4++;
                    i += zzflk.zztx(str2);
                }
            }
            zzq = (zzq + i) + (i4 * 2);
        }
        if (this.zzxj != 0) {
            zzq += zzflk.zzag(17, this.zzxj);
        }
        if (this.zzxh) {
            zzq += zzflk.zzlw(18) + 1;
        }
        if (this.zzwu == null || this.zzwu.length <= 0) {
            return zzq;
        }
        i2 = 0;
        i = 0;
        for (String str3 : this.zzwu) {
            if (str3 != null) {
                i++;
                i2 += zzflk.zztx(str3);
            }
        }
        return (zzq + i2) + (i * 2);
    }
}
