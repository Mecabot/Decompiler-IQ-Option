package com.google.android.gms.internal;

import com.iqoption.dto.ChartTimeInterval;
import java.util.Arrays;

public final class zzfmr extends zzflm<zzfmr> implements Cloneable {
    private String tag;
    private int zzaky;
    private boolean zznet;
    private zzfmt zzorb;
    public long zzpyu;
    public long zzpyv;
    private long zzpyw;
    private int zzpyx;
    private zzfms[] zzpyy;
    private byte[] zzpyz;
    private zzfmp zzpza;
    public byte[] zzpzb;
    private String zzpzc;
    private String zzpzd;
    private zzfmo zzpze;
    private String zzpzf;
    public long zzpzg;
    private zzfmq zzpzh;
    public byte[] zzpzi;
    private String zzpzj;
    private int zzpzk;
    private int[] zzpzl;
    private long zzpzm;
    private boolean zzpzn;

    public zzfmr() {
        this.zzpyu = 0;
        this.zzpyv = 0;
        this.zzpyw = 0;
        this.tag = "";
        this.zzpyx = 0;
        this.zzaky = 0;
        this.zznet = false;
        this.zzpyy = zzfms.zzddf();
        this.zzpyz = zzflv.zzpwe;
        this.zzpza = null;
        this.zzpzb = zzflv.zzpwe;
        this.zzpzc = "";
        this.zzpzd = "";
        this.zzpze = null;
        this.zzpzf = "";
        this.zzpzg = 180000;
        this.zzpzh = null;
        this.zzpzi = zzflv.zzpwe;
        this.zzpzj = "";
        this.zzpzk = 0;
        this.zzpzl = zzflv.zzpvy;
        this.zzpzm = 0;
        this.zzorb = null;
        this.zzpzn = false;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final zzfmr zzbn(zzflj zzflj) {
        while (true) {
            zzfls zzfls;
            int zzcxx = zzflj.zzcxx();
            int length;
            Object obj;
            switch (zzcxx) {
                case 0:
                    return this;
                case 8:
                    this.zzpyu = zzflj.zzcxz();
                    continue;
                case 18:
                    this.tag = zzflj.readString();
                    continue;
                case 26:
                    zzcxx = zzflv.zzb(zzflj, 26);
                    length = this.zzpyy == null ? 0 : this.zzpyy.length;
                    obj = new zzfms[(zzcxx + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpyy, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new zzfms();
                        zzflj.zza(obj[length]);
                        zzflj.zzcxx();
                        length++;
                    }
                    obj[length] = new zzfms();
                    zzflj.zza(obj[length]);
                    this.zzpyy = obj;
                    continue;
                case 34:
                    this.zzpyz = zzflj.readBytes();
                    continue;
                case 50:
                    this.zzpzb = zzflj.readBytes();
                    continue;
                case 58:
                    if (this.zzpze == null) {
                        this.zzpze = new zzfmo();
                    }
                    zzfls = this.zzpze;
                    break;
                case 66:
                    this.zzpzc = zzflj.readString();
                    continue;
                case 74:
                    if (this.zzpza == null) {
                        this.zzpza = new zzfmp();
                    }
                    zzfls = this.zzpza;
                    break;
                case 80:
                    this.zznet = zzflj.zzcyd();
                    continue;
                case 88:
                    this.zzpyx = zzflj.zzcya();
                    continue;
                case 96:
                    this.zzaky = zzflj.zzcya();
                    continue;
                case 106:
                    this.zzpzd = zzflj.readString();
                    continue;
                case 114:
                    this.zzpzf = zzflj.readString();
                    continue;
                case ChartTimeInterval.CANDLE_2m /*120*/:
                    this.zzpzg = zzflj.zzcyl();
                    continue;
                case 130:
                    if (this.zzpzh == null) {
                        this.zzpzh = new zzfmq();
                    }
                    zzfls = this.zzpzh;
                    break;
                case 136:
                    this.zzpyv = zzflj.zzcxz();
                    continue;
                case 146:
                    this.zzpzi = zzflj.readBytes();
                    continue;
                case 152:
                    try {
                        length = zzflj.zzcya();
                        switch (length) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzpzk = length;
                                continue;
                            default:
                                StringBuilder stringBuilder = new StringBuilder(45);
                                stringBuilder.append(length);
                                stringBuilder.append(" is not a valid enum InternalEvent");
                                throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    } catch (IllegalArgumentException unused) {
                        zzflj.zzmw(zzflj.getPosition());
                        zza(zzflj, zzcxx);
                        break;
                    }
                case 160:
                    zzcxx = zzflv.zzb(zzflj, 160);
                    length = this.zzpzl == null ? 0 : this.zzpzl.length;
                    obj = new int[(zzcxx + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpzl, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = zzflj.zzcya();
                        zzflj.zzcxx();
                        length++;
                    }
                    obj[length] = zzflj.zzcya();
                    this.zzpzl = obj;
                    continue;
                case 162:
                    zzcxx = zzflj.zzli(zzflj.zzcym());
                    length = zzflj.getPosition();
                    int i = 0;
                    while (zzflj.zzcyo() > 0) {
                        zzflj.zzcya();
                        i++;
                    }
                    zzflj.zzmw(length);
                    length = this.zzpzl == null ? 0 : this.zzpzl.length;
                    Object obj2 = new int[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpzl, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = zzflj.zzcya();
                        length++;
                    }
                    this.zzpzl = obj2;
                    zzflj.zzlj(zzcxx);
                    continue;
                case 168:
                    this.zzpyw = zzflj.zzcxz();
                    continue;
                case 176:
                    this.zzpzm = zzflj.zzcxz();
                    continue;
                case 186:
                    if (this.zzorb == null) {
                        this.zzorb = new zzfmt();
                    }
                    zzfls = this.zzorb;
                    break;
                case 194:
                    this.zzpzj = zzflj.readString();
                    continue;
                case 200:
                    this.zzpzn = zzflj.zzcyd();
                    continue;
                default:
                    if (!super.zza(zzflj, zzcxx)) {
                        return this;
                    }
                    continue;
            }
            zzflj.zza(zzfls);
        }
    }

    private final zzfmr zzdde() {
        try {
            zzfmr zzfmr = (zzfmr) super.clone();
            if (this.zzpyy != null && this.zzpyy.length > 0) {
                zzfmr.zzpyy = new zzfms[this.zzpyy.length];
                for (int i = 0; i < this.zzpyy.length; i++) {
                    if (this.zzpyy[i] != null) {
                        zzfmr.zzpyy[i] = (zzfms) this.zzpyy[i].clone();
                    }
                }
            }
            if (this.zzpza != null) {
                zzfmr.zzpza = (zzfmp) this.zzpza.clone();
            }
            if (this.zzpze != null) {
                zzfmr.zzpze = (zzfmo) this.zzpze.clone();
            }
            if (this.zzpzh != null) {
                zzfmr.zzpzh = (zzfmq) this.zzpzh.clone();
            }
            if (this.zzpzl != null && this.zzpzl.length > 0) {
                zzfmr.zzpzl = (int[]) this.zzpzl.clone();
            }
            if (this.zzorb != null) {
                zzfmr.zzorb = (zzfmt) this.zzorb.clone();
            }
            return zzfmr;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmr)) {
            return false;
        }
        zzfmr zzfmr = (zzfmr) obj;
        if (this.zzpyu != zzfmr.zzpyu || this.zzpyv != zzfmr.zzpyv || this.zzpyw != zzfmr.zzpyw) {
            return false;
        }
        if (this.tag == null) {
            if (zzfmr.tag != null) {
                return false;
            }
        } else if (!this.tag.equals(zzfmr.tag)) {
            return false;
        }
        if (this.zzpyx != zzfmr.zzpyx || this.zzaky != zzfmr.zzaky || this.zznet != zzfmr.zznet || !zzflq.equals(this.zzpyy, zzfmr.zzpyy) || !Arrays.equals(this.zzpyz, zzfmr.zzpyz)) {
            return false;
        }
        if (this.zzpza == null) {
            if (zzfmr.zzpza != null) {
                return false;
            }
        } else if (!this.zzpza.equals(zzfmr.zzpza)) {
            return false;
        }
        if (!Arrays.equals(this.zzpzb, zzfmr.zzpzb)) {
            return false;
        }
        if (this.zzpzc == null) {
            if (zzfmr.zzpzc != null) {
                return false;
            }
        } else if (!this.zzpzc.equals(zzfmr.zzpzc)) {
            return false;
        }
        if (this.zzpzd == null) {
            if (zzfmr.zzpzd != null) {
                return false;
            }
        } else if (!this.zzpzd.equals(zzfmr.zzpzd)) {
            return false;
        }
        if (this.zzpze == null) {
            if (zzfmr.zzpze != null) {
                return false;
            }
        } else if (!this.zzpze.equals(zzfmr.zzpze)) {
            return false;
        }
        if (this.zzpzf == null) {
            if (zzfmr.zzpzf != null) {
                return false;
            }
        } else if (!this.zzpzf.equals(zzfmr.zzpzf)) {
            return false;
        }
        if (this.zzpzg != zzfmr.zzpzg) {
            return false;
        }
        if (this.zzpzh == null) {
            if (zzfmr.zzpzh != null) {
                return false;
            }
        } else if (!this.zzpzh.equals(zzfmr.zzpzh)) {
            return false;
        }
        if (!Arrays.equals(this.zzpzi, zzfmr.zzpzi)) {
            return false;
        }
        if (this.zzpzj == null) {
            if (zzfmr.zzpzj != null) {
                return false;
            }
        } else if (!this.zzpzj.equals(zzfmr.zzpzj)) {
            return false;
        }
        if (this.zzpzk != zzfmr.zzpzk || !zzflq.equals(this.zzpzl, zzfmr.zzpzl) || this.zzpzm != zzfmr.zzpzm) {
            return false;
        }
        if (this.zzorb == null) {
            if (zzfmr.zzorb != null) {
                return false;
            }
        } else if (!this.zzorb.equals(zzfmr.zzorb)) {
            return false;
        }
        return this.zzpzn != zzfmr.zzpzn ? false : (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzfmr.zzpvl == null || zzfmr.zzpvl.isEmpty() : this.zzpvl.equals(zzfmr.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 1237;
        int hashCode = ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzpyu ^ (this.zzpyu >>> 32)))) * 31) + ((int) (this.zzpyv ^ (this.zzpyv >>> 32)))) * 31) + ((int) (this.zzpyw ^ (this.zzpyw >>> 32)))) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + this.zzpyx) * 31) + this.zzaky) * 31) + (this.zznet ? 1231 : 1237)) * 31) + zzflq.hashCode(this.zzpyy)) * 31) + Arrays.hashCode(this.zzpyz);
        zzfmp zzfmp = this.zzpza;
        hashCode = (((((((hashCode * 31) + (zzfmp == null ? 0 : zzfmp.hashCode())) * 31) + Arrays.hashCode(this.zzpzb)) * 31) + (this.zzpzc == null ? 0 : this.zzpzc.hashCode())) * 31) + (this.zzpzd == null ? 0 : this.zzpzd.hashCode());
        zzfmo zzfmo = this.zzpze;
        hashCode = (((((hashCode * 31) + (zzfmo == null ? 0 : zzfmo.hashCode())) * 31) + (this.zzpzf == null ? 0 : this.zzpzf.hashCode())) * 31) + ((int) (this.zzpzg ^ (this.zzpzg >>> 32)));
        zzfmq zzfmq = this.zzpzh;
        hashCode = (((((((((((hashCode * 31) + (zzfmq == null ? 0 : zzfmq.hashCode())) * 31) + Arrays.hashCode(this.zzpzi)) * 31) + (this.zzpzj == null ? 0 : this.zzpzj.hashCode())) * 31) + this.zzpzk) * 31) + zzflq.hashCode(this.zzpzl)) * 31) + ((int) (this.zzpzm ^ (this.zzpzm >>> 32)));
        zzfmt zzfmt = this.zzorb;
        hashCode = ((hashCode * 31) + (zzfmt == null ? 0 : zzfmt.hashCode())) * 31;
        if (this.zzpzn) {
            i2 = 1231;
        }
        hashCode = (hashCode + i2) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzpyu != 0) {
            zzflk.zzf(1, this.zzpyu);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            zzflk.zzp(2, this.tag);
        }
        if (this.zzpyy != null && this.zzpyy.length > 0) {
            for (zzfls zzfls : this.zzpyy) {
                if (zzfls != null) {
                    zzflk.zza(3, zzfls);
                }
            }
        }
        if (!Arrays.equals(this.zzpyz, zzflv.zzpwe)) {
            zzflk.zzc(4, this.zzpyz);
        }
        if (!Arrays.equals(this.zzpzb, zzflv.zzpwe)) {
            zzflk.zzc(6, this.zzpzb);
        }
        if (this.zzpze != null) {
            zzflk.zza(7, this.zzpze);
        }
        if (!(this.zzpzc == null || this.zzpzc.equals(""))) {
            zzflk.zzp(8, this.zzpzc);
        }
        if (this.zzpza != null) {
            zzflk.zza(9, this.zzpza);
        }
        if (this.zznet) {
            zzflk.zzl(10, this.zznet);
        }
        if (this.zzpyx != 0) {
            zzflk.zzad(11, this.zzpyx);
        }
        if (this.zzaky != 0) {
            zzflk.zzad(12, this.zzaky);
        }
        if (!(this.zzpzd == null || this.zzpzd.equals(""))) {
            zzflk.zzp(13, this.zzpzd);
        }
        if (!(this.zzpzf == null || this.zzpzf.equals(""))) {
            zzflk.zzp(14, this.zzpzf);
        }
        if (this.zzpzg != 180000) {
            zzflk.zzg(15, this.zzpzg);
        }
        if (this.zzpzh != null) {
            zzflk.zza(16, this.zzpzh);
        }
        if (this.zzpyv != 0) {
            zzflk.zzf(17, this.zzpyv);
        }
        if (!Arrays.equals(this.zzpzi, zzflv.zzpwe)) {
            zzflk.zzc(18, this.zzpzi);
        }
        if (this.zzpzk != 0) {
            zzflk.zzad(19, this.zzpzk);
        }
        if (this.zzpzl != null && this.zzpzl.length > 0) {
            for (int zzad : this.zzpzl) {
                zzflk.zzad(20, zzad);
            }
        }
        if (this.zzpyw != 0) {
            zzflk.zzf(21, this.zzpyw);
        }
        if (this.zzpzm != 0) {
            zzflk.zzf(22, this.zzpzm);
        }
        if (this.zzorb != null) {
            zzflk.zza(23, this.zzorb);
        }
        if (!(this.zzpzj == null || this.zzpzj.equals(""))) {
            zzflk.zzp(24, this.zzpzj);
        }
        if (this.zzpzn) {
            zzflk.zzl(25, this.zzpzn);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmr) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmr) clone();
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        if (this.zzpyu != 0) {
            zzq += zzflk.zzc(1, this.zzpyu);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            zzq += zzflk.zzq(2, this.tag);
        }
        if (this.zzpyy != null && this.zzpyy.length > 0) {
            i = zzq;
            for (zzfls zzfls : this.zzpyy) {
                if (zzfls != null) {
                    i += zzflk.zzb(3, zzfls);
                }
            }
            zzq = i;
        }
        if (!Arrays.equals(this.zzpyz, zzflv.zzpwe)) {
            zzq += zzflk.zzd(4, this.zzpyz);
        }
        if (!Arrays.equals(this.zzpzb, zzflv.zzpwe)) {
            zzq += zzflk.zzd(6, this.zzpzb);
        }
        if (this.zzpze != null) {
            zzq += zzflk.zzb(7, this.zzpze);
        }
        if (!(this.zzpzc == null || this.zzpzc.equals(""))) {
            zzq += zzflk.zzq(8, this.zzpzc);
        }
        if (this.zzpza != null) {
            zzq += zzflk.zzb(9, this.zzpza);
        }
        if (this.zznet) {
            zzq += zzflk.zzlw(10) + 1;
        }
        if (this.zzpyx != 0) {
            zzq += zzflk.zzag(11, this.zzpyx);
        }
        if (this.zzaky != 0) {
            zzq += zzflk.zzag(12, this.zzaky);
        }
        if (!(this.zzpzd == null || this.zzpzd.equals(""))) {
            zzq += zzflk.zzq(13, this.zzpzd);
        }
        if (!(this.zzpzf == null || this.zzpzf.equals(""))) {
            zzq += zzflk.zzq(14, this.zzpzf);
        }
        if (this.zzpzg != 180000) {
            zzq += zzflk.zzh(15, this.zzpzg);
        }
        if (this.zzpzh != null) {
            zzq += zzflk.zzb(16, this.zzpzh);
        }
        if (this.zzpyv != 0) {
            zzq += zzflk.zzc(17, this.zzpyv);
        }
        if (!Arrays.equals(this.zzpzi, zzflv.zzpwe)) {
            zzq += zzflk.zzd(18, this.zzpzi);
        }
        if (this.zzpzk != 0) {
            zzq += zzflk.zzag(19, this.zzpzk);
        }
        if (this.zzpzl != null && this.zzpzl.length > 0) {
            i = 0;
            for (int zzlx : this.zzpzl) {
                i += zzflk.zzlx(zzlx);
            }
            zzq = (zzq + i) + (this.zzpzl.length * 2);
        }
        if (this.zzpyw != 0) {
            zzq += zzflk.zzc(21, this.zzpyw);
        }
        if (this.zzpzm != 0) {
            zzq += zzflk.zzc(22, this.zzpzm);
        }
        if (this.zzorb != null) {
            zzq += zzflk.zzb(23, this.zzorb);
        }
        if (!(this.zzpzj == null || this.zzpzj.equals(""))) {
            zzq += zzflk.zzq(24, this.zzpzj);
        }
        return this.zzpzn ? zzq + (zzflk.zzlw(25) + 1) : zzq;
    }
}
