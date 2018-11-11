package com.google.android.gms.internal;

public final class zzfmt extends zzflm<zzfmt> implements Cloneable {
    private int zzpzp;
    private int zzpzq;

    public zzfmt() {
        this.zzpzp = -1;
        this.zzpzq = 0;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final zzfmt zzbo(zzflj zzflj) {
        int position;
        while (true) {
            int zzcxx = zzflj.zzcxx();
            if (zzcxx == 0) {
                return this;
            }
            int zzcya;
            StringBuilder stringBuilder;
            if (zzcxx == 8) {
                position = zzflj.getPosition();
                zzcya = zzflj.zzcya();
                switch (zzcya) {
                    case -1:
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        this.zzpzp = zzcya;
                        break;
                    default:
                        stringBuilder = new StringBuilder(43);
                        stringBuilder.append(zzcya);
                        stringBuilder.append(" is not a valid enum NetworkType");
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            } else if (zzcxx == 16) {
                position = zzflj.getPosition();
                try {
                    zzcya = zzflj.zzcya();
                    if (zzcya != 100) {
                        switch (zzcya) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                                break;
                            default:
                                stringBuilder = new StringBuilder(45);
                                stringBuilder.append(zzcya);
                                stringBuilder.append(" is not a valid enum MobileSubtype");
                                throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    this.zzpzq = zzcya;
                } catch (IllegalArgumentException unused) {
                    zzflj.zzmw(position);
                    zza(zzflj, zzcxx);
                }
            } else if (!super.zza(zzflj, zzcxx)) {
                return this;
            }
        }
    }

    private zzfmt zzddh() {
        try {
            return (zzfmt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmt)) {
            return false;
        }
        zzfmt zzfmt = (zzfmt) obj;
        return (this.zzpzp == zzfmt.zzpzp && this.zzpzq == zzfmt.zzpzq) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzfmt.zzpvl == null || zzfmt.zzpvl.isEmpty() : this.zzpvl.equals(zzfmt.zzpvl) : false;
    }

    public final int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.zzpzp) * 31) + this.zzpzq) * 31;
        int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
        return hashCode + hashCode2;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzpzp != -1) {
            zzflk.zzad(1, this.zzpzp);
        }
        if (this.zzpzq != 0) {
            zzflk.zzad(2, this.zzpzq);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmt) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmt) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzpzp != -1) {
            zzq += zzflk.zzag(1, this.zzpzp);
        }
        return this.zzpzq != 0 ? zzq + zzflk.zzag(2, this.zzpzq) : zzq;
    }
}
