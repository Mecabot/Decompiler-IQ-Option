package com.google.android.gms.internal;

import java.util.Arrays;

final class zzfhd extends zzfhb {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzpoh;
    private int zzpoi;
    private int zzpoj;
    private int zzpok;

    private zzfhd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzpok = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzpoi = this.pos;
        this.immutable = z;
    }

    private final long zzcyr() {
        int i = this.pos;
        if (this.limit != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.pos = i2;
                return (long) b;
            } else if (this.limit - i2 >= 9) {
                long j;
                long j2;
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (i < 0) {
                    i ^= -128;
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (i >= 0) {
                        j = (long) (i ^ 16256);
                        i = i2;
                        j2 = j;
                        this.pos = i;
                        return j2;
                    }
                    i3 = i2 + 1;
                    i ^= bArr[i2] << 21;
                    if (i < 0) {
                        i ^= -2080896;
                    } else {
                        long j3;
                        long j4 = (long) i;
                        i = i3 + 1;
                        long j5 = j4 ^ (((long) bArr[i3]) << 28);
                        if (j5 >= 0) {
                            j3 = 266354560;
                        } else {
                            long j6;
                            int i4 = i + 1;
                            long j7 = j5 ^ (((long) bArr[i]) << 35);
                            if (j7 < 0) {
                                j6 = -34093383808L;
                            } else {
                                i = i4 + 1;
                                j5 = j7 ^ (((long) bArr[i4]) << 42);
                                if (j5 >= 0) {
                                    j3 = 4363953127296L;
                                } else {
                                    i4 = i + 1;
                                    j7 = j5 ^ (((long) bArr[i]) << 49);
                                    if (j7 < 0) {
                                        j6 = -558586000294016L;
                                    } else {
                                        i = i4 + 1;
                                        long j8 = (j7 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                        if (j8 < 0) {
                                            i4 = i + 1;
                                            if (((long) bArr[i]) >= 0) {
                                                i = i4;
                                            }
                                        }
                                        j2 = j8;
                                        this.pos = i;
                                        return j2;
                                    }
                                }
                            }
                            j2 = j7 ^ j6;
                            i = i4;
                            this.pos = i;
                            return j2;
                        }
                        j2 = j5 ^ j3;
                        this.pos = i;
                        return j2;
                    }
                }
                j = (long) i;
                i = i3;
                j2 = j;
                this.pos = i;
                return j2;
            }
        }
        return zzcyn();
    }

    private final int zzcys() {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcyt() {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48)) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private final void zzcyu() {
        this.limit += this.zzpoh;
        int i = this.limit - this.zzpoi;
        if (i > this.zzpok) {
            this.zzpoh = i - this.zzpok;
            this.limit -= this.zzpoh;
            return;
        }
        this.zzpoh = 0;
    }

    private final byte zzcyv() {
        if (this.pos == this.limit) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzcyt());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzcys());
    }

    public final String readString() {
        int zzcym = zzcym();
        if (zzcym > 0 && zzcym <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzcym, zzfhz.UTF_8);
            this.pos += zzcym;
            return str;
        } else if (zzcym == 0) {
            return "";
        } else {
            if (zzcym < 0) {
                throw zzfie.zzdaf();
            }
            throw zzfie.zzdae();
        }
    }

    public final <T extends zzfhu<T, ?>> T zza(T t, zzfhm zzfhm) {
        int zzcym = zzcym();
        if (this.zzpoc >= this.zzpod) {
            throw zzfie.zzdak();
        }
        zzcym = zzli(zzcym);
        this.zzpoc++;
        t = zzfhu.zza((zzfhu) t, (zzfhb) this, zzfhm);
        zzlf(0);
        this.zzpoc--;
        zzlj(zzcym);
        return t;
    }

    public final void zza(zzfjd zzfjd, zzfhm zzfhm) {
        int zzcym = zzcym();
        if (this.zzpoc >= this.zzpod) {
            throw zzfie.zzdak();
        }
        zzcym = zzli(zzcym);
        this.zzpoc++;
        zzfjd.zzb(this, zzfhm);
        zzlf(0);
        this.zzpoc--;
        zzlj(zzcym);
    }

    public final int zzcxx() {
        if (zzcyp()) {
            this.zzpoj = 0;
            return 0;
        }
        this.zzpoj = zzcym();
        if ((this.zzpoj >>> 3) != 0) {
            return this.zzpoj;
        }
        throw zzfie.zzdah();
    }

    public final long zzcxy() {
        return zzcyr();
    }

    public final long zzcxz() {
        return zzcyr();
    }

    public final int zzcya() {
        return zzcym();
    }

    public final long zzcyb() {
        return zzcyt();
    }

    public final int zzcyc() {
        return zzcys();
    }

    public final boolean zzcyd() {
        return zzcyr() != 0;
    }

    public final String zzcye() {
        int zzcym = zzcym();
        if (zzcym <= 0 || zzcym > this.limit - this.pos) {
            if (zzcym == 0) {
                return "";
            }
            if (zzcym <= 0) {
                throw zzfie.zzdaf();
            }
            throw zzfie.zzdae();
        } else if (zzfks.zzl(this.buffer, this.pos, this.pos + zzcym)) {
            int i = this.pos;
            this.pos += zzcym;
            return new String(this.buffer, i, zzcym, zzfhz.UTF_8);
        } else {
            throw zzfie.zzdam();
        }
    }

    public final zzfgs zzcyf() {
        int zzcym = zzcym();
        if (zzcym > 0 && zzcym <= this.limit - this.pos) {
            zzfgs zzf = zzfgs.zzf(this.buffer, this.pos, zzcym);
            this.pos += zzcym;
            return zzf;
        } else if (zzcym == 0) {
            return zzfgs.zzpnw;
        } else {
            byte[] copyOfRange;
            if (zzcym > 0 && zzcym <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzcym;
                copyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzcym > 0) {
                throw zzfie.zzdae();
            } else if (zzcym == 0) {
                copyOfRange = zzfhz.EMPTY_BYTE_ARRAY;
            } else {
                throw zzfie.zzdaf();
            }
            return zzfgs.zzba(copyOfRange);
        }
    }

    public final int zzcyg() {
        return zzcym();
    }

    public final int zzcyh() {
        return zzcym();
    }

    public final int zzcyi() {
        return zzcys();
    }

    public final long zzcyj() {
        return zzcyt();
    }

    public final int zzcyk() {
        return zzfhb.zzll(zzcym());
    }

    public final long zzcyl() {
        return zzfhb.zzct(zzcyr());
    }

    /* JADX WARNING: Missing block: B:29:0x0068, code:
            if (r1[r2] >= (byte) 0) goto L_0x006a;
     */
    public final int zzcym() {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.limit;
        if (r1 == r0) goto L_0x006d;
    L_0x0006:
        r1 = r5.buffer;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r2;
        return r0;
    L_0x0011:
        r3 = r5.limit;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 < r4) goto L_0x006d;
    L_0x0018:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0024;
    L_0x0021:
        r0 = r0 ^ -128;
        goto L_0x006a;
    L_0x0024:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        if (r0 < 0) goto L_0x0031;
    L_0x002d:
        r0 = r0 ^ 16256;
    L_0x002f:
        r3 = r2;
        goto L_0x006a;
    L_0x0031:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x003f;
    L_0x003a:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        goto L_0x006a;
    L_0x003f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r3 >= 0) goto L_0x002f;
    L_0x004c:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x0052:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0058:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x005e:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0064:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 < 0) goto L_0x006d;
    L_0x006a:
        r5.pos = r3;
        return r0;
    L_0x006d:
        r0 = r5.zzcyn();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhd.zzcym():int");
    }

    final long zzcyn() {
        long j = 0;
        int i = 0;
        while (i < 64) {
            byte zzcyv = zzcyv();
            long j2 = j | (((long) (zzcyv & 127)) << i);
            if ((zzcyv & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw zzfie.zzdag();
    }

    public final int zzcyo() {
        return this.zzpok == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : this.zzpok - zzcyq();
    }

    public final boolean zzcyp() {
        return this.pos == this.limit;
    }

    public final int zzcyq() {
        return this.pos - this.zzpoi;
    }

    public final void zzlf(int i) {
        if (this.zzpoj != i) {
            throw zzfie.zzdai();
        }
    }

    public final boolean zzlg(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < (byte) 0) {
                            i2++;
                        }
                    }
                    throw zzfie.zzdag();
                }
                while (i2 < 10) {
                    if (zzcyv() < (byte) 0) {
                        i2++;
                    }
                }
                throw zzfie.zzdag();
                return true;
            case 1:
                zzlk(8);
                return true;
            case 2:
                zzlk(zzcym());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzlk(4);
                return true;
            default:
                throw zzfie.zzdaj();
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
            throw zzfie.zzdaf();
        }
        i += zzcyq();
        int i2 = this.zzpok;
        if (i > i2) {
            throw zzfie.zzdae();
        }
        this.zzpok = i;
        zzcyu();
        return i2;
    }

    public final void zzlj(int i) {
        this.zzpok = i;
        zzcyu();
    }

    public final void zzlk(int i) {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfie.zzdaf();
        } else {
            throw zzfie.zzdae();
        }
    }
}
