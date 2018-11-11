package com.google.android.gms.internal;

public final class zzcnu extends zzflm<zzcnu> {
    public Integer zzjth;
    public Boolean zzjti;
    public String zzjtj;
    public String zzjtk;
    public String zzjtl;

    public zzcnu() {
        this.zzjth = null;
        this.zzjti = null;
        this.zzjtj = null;
        this.zzjtk = null;
        this.zzjtl = null;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final zzcnu zzac(zzflj zzflj) {
        while (true) {
            int zzcxx = zzflj.zzcxx();
            if (zzcxx == 0) {
                return this;
            }
            if (zzcxx == 8) {
                try {
                    int zzcym = zzflj.zzcym();
                    switch (zzcym) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.zzjth = Integer.valueOf(zzcym);
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(46);
                            stringBuilder.append(zzcym);
                            stringBuilder.append(" is not a valid enum ComparisonType");
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                } catch (IllegalArgumentException unused) {
                    zzflj.zzmw(zzflj.getPosition());
                    zza(zzflj, zzcxx);
                }
            } else if (zzcxx == 16) {
                this.zzjti = Boolean.valueOf(zzflj.zzcyd());
            } else if (zzcxx == 26) {
                this.zzjtj = zzflj.readString();
            } else if (zzcxx == 34) {
                this.zzjtk = zzflj.readString();
            } else if (zzcxx == 42) {
                this.zzjtl = zzflj.readString();
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcnu)) {
            return false;
        }
        zzcnu zzcnu = (zzcnu) obj;
        if (this.zzjth == null) {
            if (zzcnu.zzjth != null) {
                return false;
            }
        } else if (!this.zzjth.equals(zzcnu.zzjth)) {
            return false;
        }
        if (this.zzjti == null) {
            if (zzcnu.zzjti != null) {
                return false;
            }
        } else if (!this.zzjti.equals(zzcnu.zzjti)) {
            return false;
        }
        if (this.zzjtj == null) {
            if (zzcnu.zzjtj != null) {
                return false;
            }
        } else if (!this.zzjtj.equals(zzcnu.zzjtj)) {
            return false;
        }
        if (this.zzjtk == null) {
            if (zzcnu.zzjtk != null) {
                return false;
            }
        } else if (!this.zzjtk.equals(zzcnu.zzjtk)) {
            return false;
        }
        if (this.zzjtl == null) {
            if (zzcnu.zzjtl != null) {
                return false;
            }
        } else if (!this.zzjtl.equals(zzcnu.zzjtl)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcnu.zzpvl == null || zzcnu.zzpvl.isEmpty() : this.zzpvl.equals(zzcnu.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzjth == null ? 0 : this.zzjth.intValue())) * 31) + (this.zzjti == null ? 0 : this.zzjti.hashCode())) * 31) + (this.zzjtj == null ? 0 : this.zzjtj.hashCode())) * 31) + (this.zzjtk == null ? 0 : this.zzjtk.hashCode())) * 31) + (this.zzjtl == null ? 0 : this.zzjtl.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjth != null) {
            zzflk.zzad(1, this.zzjth.intValue());
        }
        if (this.zzjti != null) {
            zzflk.zzl(2, this.zzjti.booleanValue());
        }
        if (this.zzjtj != null) {
            zzflk.zzp(3, this.zzjtj);
        }
        if (this.zzjtk != null) {
            zzflk.zzp(4, this.zzjtk);
        }
        if (this.zzjtl != null) {
            zzflk.zzp(5, this.zzjtl);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjth != null) {
            zzq += zzflk.zzag(1, this.zzjth.intValue());
        }
        if (this.zzjti != null) {
            this.zzjti.booleanValue();
            zzq += zzflk.zzlw(2) + 1;
        }
        if (this.zzjtj != null) {
            zzq += zzflk.zzq(3, this.zzjtj);
        }
        if (this.zzjtk != null) {
            zzq += zzflk.zzq(4, this.zzjtk);
        }
        return this.zzjtl != null ? zzq + zzflk.zzq(5, this.zzjtl) : zzq;
    }
}
