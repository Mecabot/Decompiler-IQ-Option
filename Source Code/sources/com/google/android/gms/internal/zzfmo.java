package com.google.android.gms.internal;

public final class zzfmo extends zzflm<zzfmo> implements Cloneable {
    private String[] zzpyk;
    private String[] zzpyl;
    private int[] zzpym;
    private long[] zzpyn;
    private long[] zzpyo;

    public zzfmo() {
        this.zzpyk = zzflv.EMPTY_STRING_ARRAY;
        this.zzpyl = zzflv.EMPTY_STRING_ARRAY;
        this.zzpym = zzflv.zzpvy;
        this.zzpyn = zzflv.zzpvz;
        this.zzpyo = zzflv.zzpvz;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private zzfmo zzddb() {
        try {
            zzfmo zzfmo = (zzfmo) super.clone();
            if (this.zzpyk != null && this.zzpyk.length > 0) {
                zzfmo.zzpyk = (String[]) this.zzpyk.clone();
            }
            if (this.zzpyl != null && this.zzpyl.length > 0) {
                zzfmo.zzpyl = (String[]) this.zzpyl.clone();
            }
            if (this.zzpym != null && this.zzpym.length > 0) {
                zzfmo.zzpym = (int[]) this.zzpym.clone();
            }
            if (this.zzpyn != null && this.zzpyn.length > 0) {
                zzfmo.zzpyn = (long[]) this.zzpyn.clone();
            }
            if (this.zzpyo != null && this.zzpyo.length > 0) {
                zzfmo.zzpyo = (long[]) this.zzpyo.clone();
            }
            return zzfmo;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmo)) {
            return false;
        }
        zzfmo zzfmo = (zzfmo) obj;
        return (zzflq.equals(this.zzpyk, zzfmo.zzpyk) && zzflq.equals(this.zzpyl, zzfmo.zzpyl) && zzflq.equals(this.zzpym, zzfmo.zzpym) && zzflq.equals(this.zzpyn, zzfmo.zzpyn) && zzflq.equals(this.zzpyo, zzfmo.zzpyo)) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzfmo.zzpvl == null || zzfmo.zzpvl.isEmpty() : this.zzpvl.equals(zzfmo.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzpyk)) * 31) + zzflq.hashCode(this.zzpyl)) * 31) + zzflq.hashCode(this.zzpym)) * 31) + zzflq.hashCode(this.zzpyn)) * 31) + zzflq.hashCode(this.zzpyo)) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzpyk != null && this.zzpyk.length > 0) {
            for (String str : this.zzpyk) {
                if (str != null) {
                    zzflk.zzp(1, str);
                }
            }
        }
        if (this.zzpyl != null && this.zzpyl.length > 0) {
            for (String str2 : this.zzpyl) {
                if (str2 != null) {
                    zzflk.zzp(2, str2);
                }
            }
        }
        if (this.zzpym != null && this.zzpym.length > 0) {
            for (int zzad : this.zzpym) {
                zzflk.zzad(3, zzad);
            }
        }
        if (this.zzpyn != null && this.zzpyn.length > 0) {
            for (long zzf : this.zzpyn) {
                zzflk.zzf(4, zzf);
            }
        }
        if (this.zzpyo != null && this.zzpyo.length > 0) {
            for (long zzf2 : this.zzpyo) {
                zzflk.zzf(5, zzf2);
            }
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmo) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmo) clone();
    }

    protected final int zzq() {
        int i;
        int i2;
        int i3;
        int zzq = super.zzq();
        if (this.zzpyk != null && this.zzpyk.length > 0) {
            i = 0;
            i2 = 0;
            for (String str : this.zzpyk) {
                if (str != null) {
                    i2++;
                    i += zzflk.zztx(str);
                }
            }
            zzq = (zzq + i) + (i2 * 1);
        }
        if (this.zzpyl != null && this.zzpyl.length > 0) {
            i = 0;
            i2 = 0;
            for (String str2 : this.zzpyl) {
                if (str2 != null) {
                    i2++;
                    i += zzflk.zztx(str2);
                }
            }
            zzq = (zzq + i) + (i2 * 1);
        }
        if (this.zzpym != null && this.zzpym.length > 0) {
            i = 0;
            for (int i22 : this.zzpym) {
                i += zzflk.zzlx(i22);
            }
            zzq = (zzq + i) + (this.zzpym.length * 1);
        }
        if (this.zzpyn != null && this.zzpyn.length > 0) {
            i = 0;
            for (long zzdj : this.zzpyn) {
                i += zzflk.zzdj(zzdj);
            }
            zzq = (zzq + i) + (this.zzpyn.length * 1);
        }
        if (this.zzpyo == null || this.zzpyo.length <= 0) {
            return zzq;
        }
        i3 = 0;
        for (long zzdj2 : this.zzpyo) {
            i3 += zzflk.zzdj(zzdj2);
        }
        return (zzq + i3) + (this.zzpyo.length * 1);
    }
}
