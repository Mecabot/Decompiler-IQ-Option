package com.google.android.gms.internal;

public final class zzfmv extends zzflm<zzfmv> {
    public long zzgoc;
    public String zzpzs;
    public String zzpzt;
    public long zzpzu;
    public String zzpzv;
    public long zzpzw;
    public String zzpzx;
    public String zzpzy;
    public String zzpzz;
    public String zzqaa;
    public String zzqab;
    public int zzqac;
    public zzfmu[] zzqad;

    public zzfmv() {
        this.zzpzs = "";
        this.zzpzt = "";
        this.zzpzu = 0;
        this.zzpzv = "";
        this.zzpzw = 0;
        this.zzgoc = 0;
        this.zzpzx = "";
        this.zzpzy = "";
        this.zzpzz = "";
        this.zzqaa = "";
        this.zzqab = "";
        this.zzqac = 0;
        this.zzqad = zzfmu.zzddi();
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    public static zzfmv zzbi(byte[] bArr) {
        return (zzfmv) zzfls.zza(new zzfmv(), bArr);
    }

    public final void zza(zzflk zzflk) {
        if (!(this.zzpzs == null || this.zzpzs.equals(""))) {
            zzflk.zzp(1, this.zzpzs);
        }
        if (!(this.zzpzt == null || this.zzpzt.equals(""))) {
            zzflk.zzp(2, this.zzpzt);
        }
        if (this.zzpzu != 0) {
            zzflk.zzf(3, this.zzpzu);
        }
        if (!(this.zzpzv == null || this.zzpzv.equals(""))) {
            zzflk.zzp(4, this.zzpzv);
        }
        if (this.zzpzw != 0) {
            zzflk.zzf(5, this.zzpzw);
        }
        if (this.zzgoc != 0) {
            zzflk.zzf(6, this.zzgoc);
        }
        if (!(this.zzpzx == null || this.zzpzx.equals(""))) {
            zzflk.zzp(7, this.zzpzx);
        }
        if (!(this.zzpzy == null || this.zzpzy.equals(""))) {
            zzflk.zzp(8, this.zzpzy);
        }
        if (!(this.zzpzz == null || this.zzpzz.equals(""))) {
            zzflk.zzp(9, this.zzpzz);
        }
        if (!(this.zzqaa == null || this.zzqaa.equals(""))) {
            zzflk.zzp(10, this.zzqaa);
        }
        if (!(this.zzqab == null || this.zzqab.equals(""))) {
            zzflk.zzp(11, this.zzqab);
        }
        if (this.zzqac != 0) {
            zzflk.zzad(12, this.zzqac);
        }
        if (this.zzqad != null && this.zzqad.length > 0) {
            for (zzfls zzfls : this.zzqad) {
                if (zzfls != null) {
                    zzflk.zza(13, zzfls);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!(this.zzpzs == null || this.zzpzs.equals(""))) {
            zzq += zzflk.zzq(1, this.zzpzs);
        }
        if (!(this.zzpzt == null || this.zzpzt.equals(""))) {
            zzq += zzflk.zzq(2, this.zzpzt);
        }
        if (this.zzpzu != 0) {
            zzq += zzflk.zzc(3, this.zzpzu);
        }
        if (!(this.zzpzv == null || this.zzpzv.equals(""))) {
            zzq += zzflk.zzq(4, this.zzpzv);
        }
        if (this.zzpzw != 0) {
            zzq += zzflk.zzc(5, this.zzpzw);
        }
        if (this.zzgoc != 0) {
            zzq += zzflk.zzc(6, this.zzgoc);
        }
        if (!(this.zzpzx == null || this.zzpzx.equals(""))) {
            zzq += zzflk.zzq(7, this.zzpzx);
        }
        if (!(this.zzpzy == null || this.zzpzy.equals(""))) {
            zzq += zzflk.zzq(8, this.zzpzy);
        }
        if (!(this.zzpzz == null || this.zzpzz.equals(""))) {
            zzq += zzflk.zzq(9, this.zzpzz);
        }
        if (!(this.zzqaa == null || this.zzqaa.equals(""))) {
            zzq += zzflk.zzq(10, this.zzqaa);
        }
        if (!(this.zzqab == null || this.zzqab.equals(""))) {
            zzq += zzflk.zzq(11, this.zzqab);
        }
        if (this.zzqac != 0) {
            zzq += zzflk.zzag(12, this.zzqac);
        }
        if (this.zzqad != null && this.zzqad.length > 0) {
            for (zzfls zzfls : this.zzqad) {
                if (zzfls != null) {
                    zzq += zzflk.zzb(13, zzfls);
                }
            }
        }
        return zzq;
    }
}
