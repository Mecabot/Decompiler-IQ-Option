package com.google.android.gms.internal;

public final class zzflj {
    private final byte[] buffer;
    private int zzpoc;
    private int zzpod = 64;
    private int zzpoe = 67108864;
    private int zzpoh;
    private int zzpoj;
    private int zzpok = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final int zzpom;
    private final int zzpvi;
    private int zzpvj;
    private int zzpvk;

    private zzflj(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzpvi = i;
        i2 += i;
        this.zzpvj = i2;
        this.zzpom = i2;
        this.zzpvk = i;
    }

    public static zzflj zzbe(byte[] bArr) {
        return zzo(bArr, 0, bArr.length);
    }

    private final void zzcyu() {
        this.zzpvj += this.zzpoh;
        int i = this.zzpvj;
        if (i > this.zzpok) {
            this.zzpoh = i - this.zzpok;
            this.zzpvj -= this.zzpoh;
            return;
        }
        this.zzpoh = 0;
    }

    private final byte zzcyv() {
        if (this.zzpvk == this.zzpvj) {
            throw zzflr.zzdcn();
        }
        byte[] bArr = this.buffer;
        int i = this.zzpvk;
        this.zzpvk = i + 1;
        return bArr[i];
    }

    private final void zzlk(int i) {
        if (i < 0) {
            throw zzflr.zzdco();
        } else if (this.zzpvk + i > this.zzpok) {
            zzlk(this.zzpok - this.zzpvk);
            throw zzflr.zzdcn();
        } else if (i <= this.zzpvj - this.zzpvk) {
            this.zzpvk += i;
        } else {
            throw zzflr.zzdcn();
        }
    }

    public static zzflj zzo(byte[] bArr, int i, int i2) {
        return new zzflj(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzpvk - this.zzpvi;
    }

    public final byte[] readBytes() {
        int zzcym = zzcym();
        if (zzcym < 0) {
            throw zzflr.zzdco();
        } else if (zzcym == 0) {
            return zzflv.zzpwe;
        } else {
            if (zzcym > this.zzpvj - this.zzpvk) {
                throw zzflr.zzdcn();
            }
            Object obj = new byte[zzcym];
            System.arraycopy(this.buffer, this.zzpvk, obj, 0, zzcym);
            this.zzpvk += zzcym;
            return obj;
        }
    }

    public final String readString() {
        int zzcym = zzcym();
        if (zzcym < 0) {
            throw zzflr.zzdco();
        } else if (zzcym > this.zzpvj - this.zzpvk) {
            throw zzflr.zzdcn();
        } else {
            String str = new String(this.buffer, this.zzpvk, zzcym, zzflq.UTF_8);
            this.zzpvk += zzcym;
            return str;
        }
    }

    public final void zza(zzfls zzfls) {
        int zzcym = zzcym();
        if (this.zzpoc >= this.zzpod) {
            throw zzflr.zzdcq();
        }
        zzcym = zzli(zzcym);
        this.zzpoc++;
        zzfls.zza(this);
        zzlf(0);
        this.zzpoc--;
        zzlj(zzcym);
    }

    public final void zza(zzfls zzfls, int i) {
        if (this.zzpoc >= this.zzpod) {
            throw zzflr.zzdcq();
        }
        this.zzpoc++;
        zzfls.zza(this);
        zzlf((i << 3) | 4);
        this.zzpoc--;
    }

    public final byte[] zzao(int i, int i2) {
        if (i2 == 0) {
            return zzflv.zzpwe;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzpvi + i, obj, 0, i2);
        return obj;
    }

    final void zzap(int i, int i2) {
        if (i > this.zzpvk - this.zzpvi) {
            int i3 = this.zzpvk - this.zzpvi;
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is beyond current ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder(24);
            stringBuilder2.append("Bad position ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            this.zzpvk = this.zzpvi + i;
            this.zzpoj = i2;
        }
    }

    public final int zzcxx() {
        if (this.zzpvk == this.zzpvj) {
            this.zzpoj = 0;
            return 0;
        }
        this.zzpoj = zzcym();
        if (this.zzpoj != 0) {
            return this.zzpoj;
        }
        throw new zzflr("Protocol message contained an invalid tag (zero).");
    }

    public final long zzcxz() {
        return zzcyr();
    }

    public final int zzcya() {
        return zzcym();
    }

    public final boolean zzcyd() {
        return zzcym() != 0;
    }

    public final long zzcyl() {
        long zzcyr = zzcyr();
        return (zzcyr >>> 1) ^ (-(zzcyr & 1));
    }

    public final int zzcym() {
        byte zzcyv = zzcyv();
        if (zzcyv >= (byte) 0) {
            return zzcyv;
        }
        int i;
        int i2 = zzcyv & 127;
        byte zzcyv2 = zzcyv();
        if (zzcyv2 >= (byte) 0) {
            i = zzcyv2 << 7;
        } else {
            i2 |= (zzcyv2 & 127) << 7;
            zzcyv2 = zzcyv();
            if (zzcyv2 >= (byte) 0) {
                i = zzcyv2 << 14;
            } else {
                i2 |= (zzcyv2 & 127) << 14;
                zzcyv2 = zzcyv();
                if (zzcyv2 >= (byte) 0) {
                    i = zzcyv2 << 21;
                } else {
                    i2 |= (zzcyv2 & 127) << 21;
                    zzcyv2 = zzcyv();
                    i2 |= zzcyv2 << 28;
                    if (zzcyv2 >= (byte) 0) {
                        return i2;
                    }
                    for (i = 0; i < 5; i++) {
                        if (zzcyv() >= (byte) 0) {
                            return i2;
                        }
                    }
                    throw zzflr.zzdcp();
                }
            }
        }
        return i2 | i;
    }

    public final int zzcyo() {
        if (this.zzpok == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.zzpok - this.zzpvk;
    }

    public final long zzcyr() {
        int i = 0;
        long j = 0;
        while (i < 64) {
            byte zzcyv = zzcyv();
            long j2 = j | (((long) (zzcyv & 127)) << i);
            if ((zzcyv & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw zzflr.zzdcp();
    }

    public final int zzcys() {
        return (((zzcyv() & 255) | ((zzcyv() & 255) << 8)) | ((zzcyv() & 255) << 16)) | ((zzcyv() & 255) << 24);
    }

    public final long zzcyt() {
        return (((((((((long) zzcyv()) & 255) | ((((long) zzcyv()) & 255) << 8)) | ((((long) zzcyv()) & 255) << 16)) | ((((long) zzcyv()) & 255) << 24)) | ((((long) zzcyv()) & 255) << 32)) | ((((long) zzcyv()) & 255) << 40)) | ((((long) zzcyv()) & 255) << 48)) | ((((long) zzcyv()) & 255) << 56);
    }

    public final void zzlf(int i) {
        if (this.zzpoj != i) {
            throw new zzflr("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzlg(int i) {
        switch (i & 7) {
            case 0:
                zzcym();
                return true;
            case 1:
                zzcyt();
                return true;
            case 2:
                zzlk(zzcym());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzcys();
                return true;
            default:
                throw new zzflr("Protocol message tag had invalid wire type.");
        }
        int zzcxx;
        do {
            zzcxx = zzcxx();
            if (zzcxx != 0) {
            }
            zzlf(((i >>> 3) << 3) | 4);
            return true;
        } while (zzlg(zzcxx));
        zzlf(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzli(int i) {
        if (i < 0) {
            throw zzflr.zzdco();
        }
        i += this.zzpvk;
        int i2 = this.zzpok;
        if (i > i2) {
            throw zzflr.zzdcn();
        }
        this.zzpok = i;
        zzcyu();
        return i2;
    }

    public final void zzlj(int i) {
        this.zzpok = i;
        zzcyu();
    }

    public final void zzmw(int i) {
        zzap(i, this.zzpoj);
    }
}
