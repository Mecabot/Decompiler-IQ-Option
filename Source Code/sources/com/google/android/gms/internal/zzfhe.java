package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzfhe extends zzfhb {
    private final byte[] buffer;
    private int pos;
    private int zzpoh;
    private int zzpoj;
    private int zzpok;
    private final InputStream zzpol;
    private int zzpom;
    private int zzpon;
    private zzfhf zzpoo;

    private zzfhe(InputStream inputStream, int i) {
        super();
        this.zzpok = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzpoo = null;
        zzfhz.zzc(inputStream, "input");
        this.zzpol = inputStream;
        this.buffer = new byte[i];
        this.zzpom = 0;
        this.pos = 0;
        this.zzpon = 0;
    }

    private final long zzcyr() {
        int i = this.pos;
        if (this.zzpom != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.pos = i2;
                return (long) b;
            } else if (this.zzpom - i2 >= 9) {
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
        if (this.zzpom - i < 4) {
            zzlm(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcyt() {
        int i = this.pos;
        if (this.zzpom - i < 8) {
            zzlm(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48)) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private final void zzcyu() {
        this.zzpom += this.zzpoh;
        int i = this.zzpon + this.zzpom;
        if (i > this.zzpok) {
            this.zzpoh = i - this.zzpok;
            this.zzpom -= this.zzpoh;
            return;
        }
        this.zzpoh = 0;
    }

    private final byte zzcyv() {
        if (this.pos == this.zzpom) {
            zzlm(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzlm(int i) {
        if (!zzln(i)) {
            if (i > (this.zzpoe - this.zzpon) - this.pos) {
                throw zzfie.zzdal();
            }
            throw zzfie.zzdae();
        }
    }

    private final boolean zzln(int i) {
        StringBuilder stringBuilder;
        while (this.pos + i > this.zzpom) {
            if (i > (this.zzpoe - this.zzpon) - this.pos || (this.zzpon + this.pos) + i > this.zzpok) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzpom > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzpom - i2);
                }
                this.zzpon += i2;
                this.zzpom -= i2;
                this.pos = 0;
            }
            i2 = this.zzpol.read(this.buffer, this.zzpom, Math.min(this.buffer.length - this.zzpom, (this.zzpoe - this.zzpon) - this.zzpom));
            if (i2 == 0 || i2 < -1 || i2 > this.buffer.length) {
                stringBuilder = new StringBuilder(102);
                stringBuilder.append("InputStream#read(byte[]) returned invalid result: ");
                stringBuilder.append(i2);
                stringBuilder.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (i2 <= 0) {
                return false;
            } else {
                this.zzpom += i2;
                zzcyu();
                if (this.zzpom >= i) {
                    return true;
                }
            }
        }
        stringBuilder = new StringBuilder(77);
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes were already available in buffer");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private final byte[] zzlo(int i) {
        byte[] zzlp = zzlp(i);
        if (zzlp != null) {
            return zzlp;
        }
        int i2 = this.pos;
        int i3 = this.zzpom - this.pos;
        this.zzpon += this.zzpom;
        this.pos = 0;
        this.zzpom = 0;
        List<byte[]> zzlq = zzlq(i - i3);
        Object obj = new byte[i];
        System.arraycopy(this.buffer, i2, obj, 0, i3);
        for (byte[] bArr : zzlq) {
            System.arraycopy(bArr, 0, obj, i3, bArr.length);
            i3 += bArr.length;
        }
        return obj;
    }

    private final byte[] zzlp(int i) {
        if (i == 0) {
            return zzfhz.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzfie.zzdaf();
        }
        int i2 = (this.zzpon + this.pos) + i;
        if (i2 - this.zzpoe > 0) {
            throw zzfie.zzdal();
        } else if (i2 > this.zzpok) {
            zzlk((this.zzpok - this.zzpon) - this.pos);
            throw zzfie.zzdae();
        } else {
            i2 = this.zzpom - this.pos;
            int i3 = i - i2;
            if (i3 >= 4096 && i3 > this.zzpol.available()) {
                return null;
            }
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.pos, obj, 0, i2);
            this.zzpon += this.zzpom;
            this.pos = 0;
            this.zzpom = 0;
            while (i2 < obj.length) {
                int read = this.zzpol.read(obj, i2, i - i2);
                if (read == -1) {
                    throw zzfie.zzdae();
                }
                this.zzpon += read;
                i2 += read;
            }
            return obj;
        }
    }

    private final List<byte[]> zzlq(int i) {
        List<byte[]> arrayList = new ArrayList();
        while (i > 0) {
            Object obj = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < obj.length) {
                int read = this.zzpol.read(obj, i2, obj.length - i2);
                if (read == -1) {
                    throw zzfie.zzdae();
                }
                this.zzpon += read;
                i2 += read;
            }
            i -= obj.length;
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzcyt());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzcys());
    }

    public final String readString() {
        int zzcym = zzcym();
        String str;
        if (zzcym > 0 && zzcym <= this.zzpom - this.pos) {
            str = new String(this.buffer, this.pos, zzcym, zzfhz.UTF_8);
            this.pos += zzcym;
            return str;
        } else if (zzcym == 0) {
            return "";
        } else {
            if (zzcym > this.zzpom) {
                return new String(zzlo(zzcym), zzfhz.UTF_8);
            }
            zzlm(zzcym);
            str = new String(this.buffer, this.pos, zzcym, zzfhz.UTF_8);
            this.pos += zzcym;
            return str;
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
        byte[] bArr;
        int zzcym = zzcym();
        int i = this.pos;
        int i2 = 0;
        if (zzcym <= this.zzpom - i && zzcym > 0) {
            bArr = this.buffer;
            this.pos = i + zzcym;
            i2 = i;
        } else if (zzcym == 0) {
            return "";
        } else {
            if (zzcym <= this.zzpom) {
                zzlm(zzcym);
                bArr = this.buffer;
                this.pos = zzcym;
            } else {
                bArr = zzlo(zzcym);
            }
        }
        if (zzfks.zzl(bArr, i2, i2 + zzcym)) {
            return new String(bArr, i2, zzcym, zzfhz.UTF_8);
        }
        throw zzfie.zzdam();
    }

    public final zzfgs zzcyf() {
        int zzcym = zzcym();
        if (zzcym <= this.zzpom - this.pos && zzcym > 0) {
            zzfgs zzf = zzfgs.zzf(this.buffer, this.pos, zzcym);
            this.pos += zzcym;
            return zzf;
        } else if (zzcym == 0) {
            return zzfgs.zzpnw;
        } else {
            byte[] zzlp = zzlp(zzcym);
            if (zzlp != null) {
                return zzfgs.zzba(zzlp);
            }
            int i = this.pos;
            int i2 = this.zzpom - this.pos;
            this.zzpon += this.zzpom;
            this.pos = 0;
            this.zzpom = 0;
            List<byte[]> zzlq = zzlq(zzcym - i2);
            Iterable arrayList = new ArrayList(zzlq.size() + 1);
            arrayList.add(zzfgs.zzf(this.buffer, i, i2));
            for (byte[] zzlp2 : zzlq) {
                arrayList.add(zzfgs.zzba(zzlp2));
            }
            return zzfgs.zzg(arrayList);
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
        r1 = r5.zzpom;
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
        r3 = r5.zzpom;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhe.zzcym():int");
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
        if (this.zzpok == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.zzpok - (this.zzpon + this.pos);
    }

    public final boolean zzcyp() {
        return this.pos == this.zzpom && !zzln(1);
    }

    public final int zzcyq() {
        return this.zzpon + this.pos;
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
                if (this.zzpom - this.pos >= 10) {
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
        i += this.zzpon + this.pos;
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
        if (i <= this.zzpom - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfie.zzdaf();
        } else if ((this.zzpon + this.pos) + i > this.zzpok) {
            zzlk((this.zzpok - this.zzpon) - this.pos);
            throw zzfie.zzdae();
        } else {
            int i2 = this.zzpom - this.pos;
            this.pos = this.zzpom;
            while (true) {
                zzlm(1);
                int i3 = i - i2;
                if (i3 > this.zzpom) {
                    i2 += this.zzpom;
                    this.pos = this.zzpom;
                } else {
                    this.pos = i3;
                    return;
                }
            }
        }
    }
}
