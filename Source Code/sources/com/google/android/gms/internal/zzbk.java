package com.google.android.gms.internal;

public final class zzbk extends zzflm<zzbk> {
    private int level;
    private int zzwe;
    private int zzwf;

    public zzbk() {
        this.level = 1;
        this.zzwe = 0;
        this.zzwf = 0;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final zzbk zze(zzflj zzflj) {
        while (true) {
            int zzcxx = zzflj.zzcxx();
            if (zzcxx == 0) {
                return this;
            }
            if (zzcxx == 8) {
                try {
                    int zzcym = zzflj.zzcym();
                    switch (zzcym) {
                        case 1:
                        case 2:
                        case 3:
                            this.level = zzcym;
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(42);
                            stringBuilder.append(zzcym);
                            stringBuilder.append(" is not a valid enum CacheLevel");
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                } catch (IllegalArgumentException unused) {
                    zzflj.zzmw(zzflj.getPosition());
                    zza(zzflj, zzcxx);
                }
            } else if (zzcxx == 16) {
                this.zzwe = zzflj.zzcym();
            } else if (zzcxx == 24) {
                this.zzwf = zzflj.zzcym();
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbk)) {
            return false;
        }
        zzbk zzbk = (zzbk) obj;
        return (this.level == zzbk.level && this.zzwe == zzbk.zzwe && this.zzwf == zzbk.zzwf) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbk.zzpvl == null || zzbk.zzpvl.isEmpty() : this.zzpvl.equals(zzbk.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzwe) * 31) + this.zzwf) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.level != 1) {
            zzflk.zzad(1, this.level);
        }
        if (this.zzwe != 0) {
            zzflk.zzad(2, this.zzwe);
        }
        if (this.zzwf != 0) {
            zzflk.zzad(3, this.zzwf);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.level != 1) {
            zzq += zzflk.zzag(1, this.level);
        }
        if (this.zzwe != 0) {
            zzq += zzflk.zzag(2, this.zzwe);
        }
        return this.zzwf != 0 ? zzq + zzflk.zzag(3, this.zzwf) : zzq;
    }
}
