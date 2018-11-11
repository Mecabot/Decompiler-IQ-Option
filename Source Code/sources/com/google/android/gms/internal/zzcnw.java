package com.google.android.gms.internal;

public final class zzcnw extends zzflm<zzcnw> {
    public Integer zzjtp;
    public String zzjtq;
    public Boolean zzjtr;
    public String[] zzjts;

    public zzcnw() {
        this.zzjtp = null;
        this.zzjtq = null;
        this.zzjtr = null;
        this.zzjts = zzflv.EMPTY_STRING_ARRAY;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final zzcnw zzad(zzflj zzflj) {
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
                        case 5:
                        case 6:
                            this.zzjtp = Integer.valueOf(zzcym);
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(41);
                            stringBuilder.append(zzcym);
                            stringBuilder.append(" is not a valid enum MatchType");
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                } catch (IllegalArgumentException unused) {
                    zzflj.zzmw(zzflj.getPosition());
                    zza(zzflj, zzcxx);
                }
            } else if (zzcxx == 18) {
                this.zzjtq = zzflj.readString();
            } else if (zzcxx == 24) {
                this.zzjtr = Boolean.valueOf(zzflj.zzcyd());
            } else if (zzcxx == 34) {
                zzcxx = zzflv.zzb(zzflj, 34);
                int length = this.zzjts == null ? 0 : this.zzjts.length;
                Object obj = new String[(zzcxx + length)];
                if (length != 0) {
                    System.arraycopy(this.zzjts, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = zzflj.readString();
                    zzflj.zzcxx();
                    length++;
                }
                obj[length] = zzflj.readString();
                this.zzjts = obj;
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcnw)) {
            return false;
        }
        zzcnw zzcnw = (zzcnw) obj;
        if (this.zzjtp == null) {
            if (zzcnw.zzjtp != null) {
                return false;
            }
        } else if (!this.zzjtp.equals(zzcnw.zzjtp)) {
            return false;
        }
        if (this.zzjtq == null) {
            if (zzcnw.zzjtq != null) {
                return false;
            }
        } else if (!this.zzjtq.equals(zzcnw.zzjtq)) {
            return false;
        }
        if (this.zzjtr == null) {
            if (zzcnw.zzjtr != null) {
                return false;
            }
        } else if (!this.zzjtr.equals(zzcnw.zzjtr)) {
            return false;
        }
        return !zzflq.equals(this.zzjts, zzcnw.zzjts) ? false : (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzcnw.zzpvl == null || zzcnw.zzpvl.isEmpty() : this.zzpvl.equals(zzcnw.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzjtp == null ? 0 : this.zzjtp.intValue())) * 31) + (this.zzjtq == null ? 0 : this.zzjtq.hashCode())) * 31) + (this.zzjtr == null ? 0 : this.zzjtr.hashCode())) * 31) + zzflq.hashCode(this.zzjts)) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjtp != null) {
            zzflk.zzad(1, this.zzjtp.intValue());
        }
        if (this.zzjtq != null) {
            zzflk.zzp(2, this.zzjtq);
        }
        if (this.zzjtr != null) {
            zzflk.zzl(3, this.zzjtr.booleanValue());
        }
        if (this.zzjts != null && this.zzjts.length > 0) {
            for (String str : this.zzjts) {
                if (str != null) {
                    zzflk.zzp(4, str);
                }
            }
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjtp != null) {
            zzq += zzflk.zzag(1, this.zzjtp.intValue());
        }
        if (this.zzjtq != null) {
            zzq += zzflk.zzq(2, this.zzjtq);
        }
        if (this.zzjtr != null) {
            this.zzjtr.booleanValue();
            zzq += zzflk.zzlw(3) + 1;
        }
        if (this.zzjts == null || this.zzjts.length <= 0) {
            return zzq;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.zzjts) {
            if (str != null) {
                i2++;
                i += zzflk.zztx(str);
            }
        }
        return (zzq + i) + (i2 * 1);
    }
}
