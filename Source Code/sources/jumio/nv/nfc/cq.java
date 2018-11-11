package jumio.nv.nfc;

import android.support.v4.app.FrameMetricsAggregator;

/* compiled from: StdEntropyDecoder */
public class cq extends co {
    private static final int[] i = new int[256];
    private static final int[] j = new int[256];
    private static final int[] k = new int[256];
    private static final int[] l = new int[512];
    private static final int[] m = new int[512];
    private static final int[] n = new int[]{46, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private cl b;
    private cp c;
    private cg f;
    private int g;
    private final boolean h;
    private final int[] o;
    private cn p;
    private int q;

    static {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        i[0] = 2;
        int i8 = 1;
        for (i = 1; i < 16; i++) {
            i[i] = 4;
        }
        for (i = 0; i < 4; i++) {
            i[1 << i] = 3;
        }
        for (i = 0; i < 16; i++) {
            i[i | 32] = 5;
            i[i | 16] = 5;
            i[i | 48] = 6;
        }
        i[128] = 7;
        i[64] = 7;
        for (i = 1; i < 16; i++) {
            i[i | 128] = 8;
            i[i | 64] = 8;
        }
        for (i = 1; i < 4; i++) {
            for (i2 = 0; i2 < 16; i2++) {
                i3 = i << 4;
                i[(i3 | 128) | i2] = 9;
                i[(i3 | 64) | i2] = 9;
            }
        }
        for (i3 = 0; i3 < 64; i3++) {
            i[i3 | 192] = 10;
        }
        j[0] = 2;
        for (i3 = 1; i3 < 16; i3++) {
            j[i3] = 4;
        }
        for (i3 = 0; i3 < 4; i3++) {
            j[1 << i3] = 3;
        }
        for (i3 = 0; i3 < 16; i3++) {
            j[i3 | 128] = 5;
            j[i3 | 64] = 5;
            j[i3 | 192] = 6;
        }
        j[32] = 7;
        j[16] = 7;
        for (i3 = 1; i3 < 16; i3++) {
            j[i3 | 32] = 8;
            j[i3 | 16] = 8;
        }
        for (i3 = 1; i3 < 4; i3++) {
            for (i4 = 0; i4 < 16; i4++) {
                i2 = i3 << 6;
                j[(i2 | 32) | i4] = 9;
                j[(i2 | 16) | i4] = 9;
            }
        }
        for (i3 = 0; i3 < 4; i3++) {
            for (i4 = 0; i4 < 16; i4++) {
                j[(((i3 << 6) | 32) | 16) | i4] = 10;
            }
        }
        int[] iArr = new int[]{3, 5, 6, 9, 10, 12};
        int[] iArr2 = new int[]{1, 2, 4, 8};
        int[] iArr3 = new int[]{3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};
        int[] iArr4 = new int[]{7, 11, 13, 14, 15};
        k[0] = 2;
        for (int i9 : iArr2) {
            k[i9 << 4] = 3;
        }
        for (int i92 : iArr3) {
            k[i92 << 4] = 4;
        }
        for (int i922 : iArr2) {
            k[i922] = 5;
        }
        for (int i9222 : iArr2) {
            for (int i10 : iArr2) {
                k[(i9222 << 4) | i10] = 6;
            }
        }
        for (int i11 : iArr3) {
            for (int i92222 : iArr2) {
                k[(i11 << 4) | i92222] = 7;
            }
        }
        for (int i62 : iArr) {
            k[i62] = 8;
        }
        for (int i42 : iArr) {
            for (i7 = 1; i7 < 16; i7++) {
                k[(i7 << 4) | i42] = 9;
            }
        }
        for (i3 = 0; i3 < 16; i3++) {
            for (int i52 : iArr4) {
                k[(i3 << 4) | i52] = 10;
            }
        }
        iArr = new int[36];
        iArr[18] = 15;
        iArr[17] = 14;
        iArr[16] = 13;
        iArr[10] = 12;
        iArr[9] = 11;
        iArr[8] = -2147483636;
        iArr[2] = -2147483635;
        iArr[1] = -2147483634;
        iArr[0] = -2147483633;
        for (i = 0; i < FrameMetricsAggregator.EVERY_DURATION; i++) {
            i7 = i & 1;
            i62 = (i >> 1) & 1;
            int i12 = (i >> 5) & 1;
            int i13 = (i >> 6) & 1;
            i42 = (((i >> 3) & 1) * (1 - (((i >> 8) & 1) * 2))) + (((i >> 2) & 1) * (1 - (((i >> 7) & 1) * 2)));
            i52 = i42 >= -1 ? i42 : -1;
            if (i52 > 1) {
                i52 = 1;
            }
            i62 = (i62 * (1 - (i13 * 2))) + (i7 * (1 - (i12 * 2)));
            i7 = i62 >= -1 ? i62 : -1;
            if (i7 > 1) {
                i7 = 1;
            }
            l[i] = iArr[(i7 + 1) | ((i52 + 1) << 3)];
        }
        m[0] = 16;
        while (i8 < 256) {
            m[i8] = 17;
            i8++;
        }
        while (i8 < 512) {
            m[i8] = 18;
            i8++;
        }
    }

    public cq(cm cmVar, cg cgVar, boolean z, boolean z2, int i) {
        super(cmVar);
        this.f = cgVar;
        this.h = z;
        this.q = i;
        this.o = new int[((cgVar.q.a() + 2) * (((cgVar.q.c() + 1) / 2) + 2))];
    }

    public cv a(int i, int i2, int i3, eg egVar, cv cvVar) {
        this.p = this.a.a(i, i2, i3, egVar, 1, -1, this.p);
        this.g = ((Integer) this.f.j.a(this.d, i)).intValue();
        dq.a(this.o, 0);
        cv cxVar = cvVar == null ? new cx() : cvVar;
        cxVar.g = this.p.j;
        cxVar.a = this.p.e;
        cxVar.b = this.p.f;
        cxVar.c = this.p.g;
        cxVar.d = this.p.h;
        cxVar.e = 0;
        cxVar.f = cxVar.c;
        int[] iArr = (int[]) cxVar.b();
        if (iArr == null || iArr.length < this.p.g * this.p.h) {
            cxVar.a(new int[(this.p.g * this.p.h)]);
        } else {
            dq.a(iArr, 0);
        }
        if (this.p.k <= 0 || this.p.m <= 0) {
            return cxVar;
        }
        ck ckVar;
        boolean z;
        boolean z2;
        int i4 = this.p.n == null ? this.p.i : this.p.n[0];
        int i5 = this.p.m;
        if (this.c == null) {
            ckVar = new ck(this.p.d, 0, i4);
            this.c = new cp(ckVar, 19, n);
        } else {
            this.c.a(this.p.d, 0, i4);
            this.c.b();
            ckVar = null;
        }
        if ((this.g & 1) != 0 && this.b == null) {
            if (ckVar == null) {
                ckVar = this.c.c();
            }
            this.b = new cl(ckVar);
        }
        switch (egVar.b) {
            case 0:
            case 2:
                iArr = i;
                break;
            case 1:
                iArr = j;
                break;
            case 3:
                iArr = k;
                break;
            default:
                throw new Error("JJ2000 internal error");
        }
        int[] iArr2 = iArr;
        int i6 = 30 - this.p.c;
        if (this.q != -1 && (this.q * 3) - 2 < i5) {
            i5 = (this.q * 3) - 2;
        }
        int i7 = i5;
        if (i6 < 0 || i7 <= 0) {
            z = false;
        } else {
            z2 = (this.g & 4) != 0 || ((this.g & 1) != 0 && 27 - this.p.c >= i6);
            z = b(cxVar, this.c, i6, this.o, iArr2, z2);
            i7--;
            if (!(z && this.h)) {
                i6--;
            }
        }
        if (!(z && this.h)) {
            boolean z3 = z;
            i4 = 0;
            while (i6 >= 0 && i7 > 0) {
                int i8;
                int i9;
                boolean z4;
                if ((this.g & 1) == 0 || i6 >= 27 - this.p.c) {
                    if ((this.g & 4) != 0) {
                        i4++;
                        this.c.a(null, -1, this.p.n[i4]);
                    }
                    i8 = i4;
                    z = a(cxVar, this.c, i6, this.o, iArr2, (this.g & 4) != 0);
                    i7--;
                    if (i7 > 0 && !(z && this.h)) {
                        if ((this.g & 4) != 0) {
                            i8++;
                            this.c.a(null, -1, this.p.n[i8]);
                        }
                        i9 = i8;
                        z4 = (this.g & 4) != 0 || ((this.g & 1) != 0 && 27 - this.p.c > i6);
                        z = a(cxVar, this.c, i6, this.o, z4);
                    }
                } else {
                    i9 = i4 + 1;
                    this.b.a(null, -1, this.p.n[i9]);
                    z = a(cxVar, this.b, i6, this.o, (this.g & 4) != 0);
                    i7--;
                    if (i7 > 0 && !(z && this.h)) {
                        if ((this.g & 4) != 0) {
                            i9++;
                            this.b.a(null, -1, this.p.n[i9]);
                        }
                        z4 = (this.g & 4) != 0 || ((this.g & 1) != 0 && 27 - this.p.c > i6);
                        z = b(cxVar, this.b, i6, this.o, z4);
                    }
                }
                i7--;
                if (i7 > 0 && !(r0 && this.h)) {
                    if ((this.g & 4) != 0 || ((this.g & 1) != 0 && i6 < 27 - this.p.c)) {
                        i9++;
                        this.c.a(null, -1, this.p.n[i9]);
                    }
                    i8 = i9;
                    z2 = (this.g & 4) != 0 || ((this.g & 1) != 0 && 27 - this.p.c >= i6);
                    z3 = b(cxVar, this.c, i6, this.o, iArr2, z2);
                    i7--;
                    if (!z3 || !this.h) {
                        i6--;
                        i4 = i8;
                    }
                }
            }
            z = z3;
        }
        if (z && this.h) {
            a(cxVar, i6);
        }
        return cxVar;
    }

    public cv b(int i, int i2, int i3, eg egVar, cv cvVar) {
        return a(i, i2, i3, egVar, cvVar);
    }

    private boolean a(cv cvVar, cp cpVar, int i, int[] iArr, int[] iArr2, boolean z) {
        cq thisR;
        cv cvVar2 = cvVar;
        cp cpVar2 = cpVar;
        int i2 = cvVar2.f;
        int i3 = cvVar2.c + 2;
        int i4 = ((i3 * 4) / 2) - cvVar2.c;
        int i5 = (i2 * 4) - cvVar2.c;
        int i6 = (3 << i) >> 1;
        int[] iArr3 = (int[]) cvVar.b();
        int i7 = ((cvVar2.d + 4) - 1) / 4;
        boolean z2 = false;
        Object obj = (this.g & 8) != 0 ? 1 : null;
        int i8 = -i3;
        int i9 = i8 - 1;
        i8++;
        int i10 = i3 + 1;
        int i11 = i3 - 1;
        i7--;
        int i12 = cvVar2.e;
        int i13 = i7;
        int i14 = i10;
        while (i13 >= 0) {
            int i15;
            int i16;
            Object obj2;
            if (i13 != 0) {
                i15 = i7;
                i16 = 4;
            } else {
                i16 = cvVar2.d - (i7 * 4);
                i15 = i7;
            }
            i7 = cvVar2.c + i12;
            while (i12 < i7) {
                int i17;
                int i18;
                int i19 = iArr[i14];
                int i20 = i7;
                if ((((i19 ^ -1) & (i19 << 2)) & -2147450880) != 0) {
                    i17 = i4;
                    if ((i19 & 40960) == 8192) {
                        if (cpVar2.a(iArr2[i19 & 255]) != 0) {
                            i4 = l[(i19 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                            i4 = (i4 >>> 31) ^ cpVar2.a(i4 & 15);
                            iArr3[i12] = (i4 << 31) | i6;
                            if (obj == null) {
                                i7 = i14 + i9;
                                iArr[i7] = iArr[i7] | 536936448;
                                i7 = i14 + i8;
                                iArr[i7] = iArr[i7] | 537001984;
                            }
                            if (i4 != 0) {
                                i19 |= 606126080;
                                if (obj == null) {
                                    i4 = i14 - i3;
                                    iArr[i4] = iArr[i4] | 571473920;
                                }
                                i4 = i14 + 1;
                                iArr[i4] = iArr[i4] | 537407616;
                                i4 = i14 - 1;
                                iArr[i4] = iArr[i4] | 537143360;
                            } else {
                                i19 |= 539017216;
                                if (obj == null) {
                                    i4 = i14 - i3;
                                    iArr[i4] = iArr[i4] | 537919488;
                                }
                                i4 = i14 + 1;
                                iArr[i4] = iArr[i4] | 537403520;
                                i4 = i14 - 1;
                                iArr[i4] = iArr[i4] | 537141312;
                            }
                        } else {
                            i19 |= 16384;
                        }
                    }
                    if (i16 < 2) {
                        iArr[i14] = i19;
                        i18 = i5;
                        obj2 = obj;
                        i12++;
                        i14++;
                        i7 = i20;
                        i4 = i17;
                        obj = obj2;
                        i5 = i18;
                        cvVar2 = cvVar;
                    } else {
                        if ((-1610612736 & i19) == 536870912) {
                            i4 = i12 + i2;
                            if (cpVar2.a(iArr2[(i19 >>> 16) & 255]) != 0) {
                                obj2 = obj;
                                i7 = l[(i19 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                i7 = (i7 >>> 31) ^ cpVar2.a(i7 & 15);
                                iArr3[i4] = (i7 << 31) | i6;
                                i4 = i14 + i11;
                                iArr[i4] = iArr[i4] | 8196;
                                i4 = i14 + i10;
                                iArr[i4] = iArr[i4] | 8200;
                                if (i7 != 0) {
                                    i19 |= -1073733104;
                                    i4 = i14 + i3;
                                    iArr[i4] = iArr[i4] | 9248;
                                    i4 = i14 + 1;
                                    iArr[i4] = iArr[i4] | 813703170;
                                    i4 = i14 - 1;
                                    iArr[i4] = iArr[i4] | 675291137;
                                } else {
                                    i19 |= -1073733616;
                                    i4 = i14 + i3;
                                    iArr[i4] = iArr[i4] | 8224;
                                    i4 = i14 + 1;
                                    iArr[i4] = iArr[i4] | 545267714;
                                    i4 = i14 - 1;
                                    iArr[i4] = iArr[i4] | 541073409;
                                }
                            } else {
                                obj2 = obj;
                                i19 |= 1073741824;
                            }
                        } else {
                            obj2 = obj;
                        }
                        iArr[i14] = i19;
                    }
                } else {
                    i17 = i4;
                    obj2 = obj;
                }
                if (i16 >= 3) {
                    i4 = i14 + i3;
                    i7 = iArr[i4];
                    if ((((i7 ^ -1) & (i7 << 2)) & -2147450880) != 0) {
                        int i21 = (i2 << 1) + i12;
                        i18 = i5;
                        if ((i7 & 40960) == 8192) {
                            if (cpVar2.a(iArr2[i7 & 255]) != 0) {
                                i19 = l[(i7 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                i19 = (i19 >>> 31) ^ cpVar2.a(i19 & 15);
                                iArr3[i21] = (i19 << 31) | i6;
                                i5 = i4 + i9;
                                iArr[i5] = iArr[i5] | 536936448;
                                i5 = i4 + i8;
                                iArr[i5] = iArr[i5] | 537001984;
                                if (i19 != 0) {
                                    i7 |= 606126080;
                                    i19 = i4 - i3;
                                    iArr[i19] = iArr[i19] | 571473920;
                                    i19 = i4 + 1;
                                    iArr[i19] = iArr[i19] | 537407616;
                                    i19 = i4 - 1;
                                    iArr[i19] = iArr[i19] | 537143360;
                                } else {
                                    i7 |= 539017216;
                                    i19 = i4 - i3;
                                    iArr[i19] = iArr[i19] | 537919488;
                                    i19 = i4 + 1;
                                    iArr[i19] = iArr[i19] | 537403520;
                                    i19 = i4 - 1;
                                    iArr[i19] = iArr[i19] | 537141312;
                                }
                            } else {
                                i7 |= 16384;
                            }
                        }
                        if (i16 < 4) {
                            iArr[i4] = i7;
                        } else {
                            if ((-1610612736 & i7) == 536870912) {
                                i21 += i2;
                                if (cpVar2.a(iArr2[(i7 >>> 16) & 255]) != 0) {
                                    i19 = l[(i7 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                    i19 = (i19 >>> 31) ^ cpVar2.a(i19 & 15);
                                    iArr3[i21] = (i19 << 31) | i6;
                                    i5 = i4 + i11;
                                    iArr[i5] = iArr[i5] | 8196;
                                    i5 = i4 + i10;
                                    iArr[i5] = iArr[i5] | 8200;
                                    if (i19 != 0) {
                                        i7 |= -1073733104;
                                        i19 = i4 + i3;
                                        iArr[i19] = iArr[i19] | 9248;
                                        i19 = i4 + 1;
                                        iArr[i19] = iArr[i19] | 813703170;
                                        i19 = i4 - 1;
                                        iArr[i19] = iArr[i19] | 675291137;
                                    } else {
                                        i7 |= -1073733616;
                                        i19 = i4 + i3;
                                        iArr[i19] = iArr[i19] | 8224;
                                        i19 = i4 + 1;
                                        iArr[i19] = iArr[i19] | 545267714;
                                        i19 = i4 - 1;
                                        iArr[i19] = iArr[i19] | 541073409;
                                    }
                                } else {
                                    i7 |= 1073741824;
                                }
                            }
                            iArr[i4] = i7;
                        }
                        i12++;
                        i14++;
                        i7 = i20;
                        i4 = i17;
                        obj = obj2;
                        i5 = i18;
                        cvVar2 = cvVar;
                    }
                }
                i18 = i5;
                i12++;
                i14++;
                i7 = i20;
                i4 = i17;
                obj = obj2;
                i5 = i18;
                cvVar2 = cvVar;
            }
            obj2 = obj;
            i13--;
            i12 += i5;
            i14 += i4;
            i7 = i15;
            cvVar2 = cvVar;
        }
        if (z) {
            thisR = this;
            if ((thisR.g & 16) != 0) {
                z2 = cpVar.a();
            }
        } else {
            thisR = this;
        }
        if ((thisR.g & 2) != 0) {
            cpVar.b();
        }
        return z2;
    }

    private boolean a(cv cvVar, cl clVar, int i, int[] iArr, boolean z) {
        cv cvVar2 = cvVar;
        int i2 = cvVar2.f;
        int i3 = cvVar2.c + 2;
        int i4 = ((i3 * 4) / 2) - cvVar2.c;
        int i5 = (i2 * 4) - cvVar2.c;
        int i6 = (3 << i) >> 1;
        int[] iArr2 = (int[]) cvVar.b();
        int i7 = ((cvVar2.d + 4) - 1) / 4;
        Object obj = (this.g & 8) != 0 ? 1 : null;
        int i8 = -i3;
        int i9 = i8 - 1;
        i8++;
        int i10 = i3 + 1;
        int i11 = i3 - 1;
        int i12 = cvVar2.e;
        i7--;
        int i13 = i7;
        int i14 = i10;
        while (i13 >= 0) {
            int i15;
            int i16;
            Object obj2;
            if (i13 != 0) {
                i15 = 4;
            } else {
                i15 = cvVar2.d - (i7 * 4);
            }
            int i17 = cvVar2.c + i12;
            while (i12 < i17) {
                int i18 = iArr[i14];
                int i19 = i17;
                if ((((i18 ^ -1) & (i18 << 2)) & -2147450880) != 0) {
                    i16 = i7;
                    if ((i18 & 40960) == 8192) {
                        if (clVar.a() != 0) {
                            i7 = clVar.a();
                            iArr2[i12] = (i7 << 31) | i6;
                            if (obj == null) {
                                int i20 = i14 + i9;
                                iArr[i20] = iArr[i20] | 536936448;
                                i20 = i14 + i8;
                                iArr[i20] = iArr[i20] | 537001984;
                            }
                            if (i7 != 0) {
                                i18 |= 606126080;
                                if (obj == null) {
                                    i7 = i14 - i3;
                                    iArr[i7] = iArr[i7] | 571473920;
                                }
                                i7 = i14 + 1;
                                iArr[i7] = iArr[i7] | 537407616;
                                i7 = i14 - 1;
                                iArr[i7] = iArr[i7] | 537143360;
                            } else {
                                i18 |= 539017216;
                                if (obj == null) {
                                    i7 = i14 - i3;
                                    iArr[i7] = iArr[i7] | 537919488;
                                }
                                i7 = i14 + 1;
                                iArr[i7] = iArr[i7] | 537403520;
                                i7 = i14 - 1;
                                iArr[i7] = iArr[i7] | 537141312;
                            }
                        } else {
                            i18 |= 16384;
                        }
                    }
                    if (i15 < 2) {
                        iArr[i14] = i18;
                        obj2 = obj;
                        i12++;
                        i14++;
                        i17 = i19;
                        i7 = i16;
                        obj = obj2;
                        cvVar2 = cvVar;
                    } else {
                        if ((i18 & -1610612736) == 536870912) {
                            i17 = i12 + i2;
                            if (clVar.a() != 0) {
                                i7 = clVar.a();
                                iArr2[i17] = (i7 << 31) | i6;
                                i17 = i14 + i11;
                                obj2 = obj;
                                iArr[i17] = iArr[i17] | 8196;
                                i17 = i14 + i10;
                                iArr[i17] = iArr[i17] | 8200;
                                if (i7 != 0) {
                                    i18 |= -1073733104;
                                    i17 = i14 + i3;
                                    iArr[i17] = iArr[i17] | 9248;
                                    i17 = i14 + 1;
                                    iArr[i17] = iArr[i17] | 813703170;
                                    i17 = i14 - 1;
                                    iArr[i17] = iArr[i17] | 675291137;
                                } else {
                                    i18 |= -1073733616;
                                    i17 = i14 + i3;
                                    iArr[i17] = iArr[i17] | 8224;
                                    i17 = i14 + 1;
                                    iArr[i17] = iArr[i17] | 545267714;
                                    i17 = i14 - 1;
                                    iArr[i17] = iArr[i17] | 541073409;
                                }
                            } else {
                                obj2 = obj;
                                i18 |= 1073741824;
                            }
                        } else {
                            obj2 = obj;
                        }
                        iArr[i14] = i18;
                    }
                } else {
                    i16 = i7;
                    obj2 = obj;
                }
                if (i15 >= 3) {
                    i17 = i14 + i3;
                    i7 = iArr[i17];
                    if ((((i7 ^ -1) & (i7 << 2)) & -2147450880) != 0) {
                        int a;
                        int i21 = (i2 << 1) + i12;
                        if ((i7 & 40960) == 8192) {
                            if (clVar.a() != 0) {
                                a = clVar.a();
                                iArr2[i21] = (a << 31) | i6;
                                i18 = i17 + i9;
                                iArr[i18] = iArr[i18] | 536936448;
                                i18 = i17 + i8;
                                iArr[i18] = iArr[i18] | 537001984;
                                if (a != 0) {
                                    i7 |= 606126080;
                                    a = i17 - i3;
                                    iArr[a] = iArr[a] | 571473920;
                                    a = i17 + 1;
                                    iArr[a] = iArr[a] | 537407616;
                                    a = i17 - 1;
                                    iArr[a] = iArr[a] | 537143360;
                                } else {
                                    i7 |= 539017216;
                                    a = i17 - i3;
                                    iArr[a] = iArr[a] | 537919488;
                                    a = i17 + 1;
                                    iArr[a] = iArr[a] | 537403520;
                                    a = i17 - 1;
                                    iArr[a] = iArr[a] | 537141312;
                                }
                            } else {
                                i7 |= 16384;
                            }
                        }
                        if (i15 < 4) {
                            iArr[i17] = i7;
                        } else {
                            if ((-1610612736 & i7) == 536870912) {
                                i21 += i2;
                                if (clVar.a() != 0) {
                                    a = clVar.a();
                                    iArr2[i21] = (a << 31) | i6;
                                    i18 = i17 + i11;
                                    iArr[i18] = iArr[i18] | 8196;
                                    i18 = i17 + i10;
                                    iArr[i18] = iArr[i18] | 8200;
                                    if (a != 0) {
                                        i7 |= -1073733104;
                                        a = i17 + i3;
                                        iArr[a] = iArr[a] | 9248;
                                        a = i17 + 1;
                                        iArr[a] = iArr[a] | 813703170;
                                        a = i17 - 1;
                                        iArr[a] = iArr[a] | 675291137;
                                    } else {
                                        i7 |= -1073733616;
                                        a = i17 + i3;
                                        iArr[a] = iArr[a] | 8224;
                                        a = i17 + 1;
                                        iArr[a] = iArr[a] | 545267714;
                                        a = i17 - 1;
                                        iArr[a] = iArr[a] | 541073409;
                                    }
                                } else {
                                    i7 |= 1073741824;
                                }
                            }
                            iArr[i17] = i7;
                        }
                    }
                }
                i12++;
                i14++;
                i17 = i19;
                i7 = i16;
                obj = obj2;
                cvVar2 = cvVar;
            }
            i16 = i7;
            obj2 = obj;
            i13--;
            i12 += i5;
            i14 += i4;
            cvVar2 = cvVar;
        }
        if (!z) {
        } else if ((this.g & 16) != 0) {
            return clVar.b();
        }
        return false;
    }

    private boolean a(cv cvVar, cp cpVar, int i, int[] iArr, boolean z) {
        cq cqVar;
        cv cvVar2 = cvVar;
        cp cpVar2 = cpVar;
        int i2 = cvVar2.f;
        int i3 = cvVar2.c + 2;
        int i4 = ((i3 * 4) / 2) - cvVar2.c;
        int i5 = (i2 * 4) - cvVar2.c;
        int i6 = (1 << i) >> 1;
        int i7 = -1 << (i + 1);
        int[] iArr2 = (int[]) cvVar.b();
        int i8 = ((cvVar2.d + 4) - 1) / 4;
        int i9 = cvVar2.e;
        int i10 = i3 + 1;
        i8--;
        int i11 = i8;
        while (i11 >= 0) {
            int i12;
            int i13;
            int i14;
            if (i11 != 0) {
                i12 = i8;
                i13 = 4;
            } else {
                i13 = cvVar2.d - (i8 * 4);
                i12 = i8;
            }
            i8 = cvVar2.c + i9;
            while (i9 < i8) {
                int a;
                int i15;
                int i16 = iArr[i10];
                int i17 = i8;
                if ((((i16 >>> 1) & (i16 ^ -1)) & 1073758208) != 0) {
                    if ((i16 & 49152) == 32768) {
                        a = cpVar2.a(m[i16 & FrameMetricsAggregator.EVERY_DURATION]);
                        iArr2[i9] = iArr2[i9] & i7;
                        iArr2[i9] = ((a << i) | i6) | iArr2[i9];
                        i16 |= 256;
                    }
                    if (i13 < 2) {
                        iArr[i10] = i16;
                        i14 = i3;
                        i15 = i4;
                        i9++;
                        i10++;
                        i8 = i17;
                        i4 = i15;
                        i3 = i14;
                        cvVar2 = cvVar;
                    } else {
                        if ((i16 & -1073741824) == Integer.MIN_VALUE) {
                            a = i9 + i2;
                            i15 = i4;
                            i4 = cpVar2.a(m[(i16 >>> 16) & FrameMetricsAggregator.EVERY_DURATION]);
                            iArr2[a] = iArr2[a] & i7;
                            iArr2[a] = ((i4 << i) | i6) | iArr2[a];
                            i16 |= 16777216;
                        } else {
                            i15 = i4;
                        }
                        iArr[i10] = i16;
                    }
                } else {
                    i15 = i4;
                }
                if (i13 >= 3) {
                    a = i10 + i3;
                    i16 = iArr[a];
                    if ((((i16 >>> 1) & (i16 ^ -1)) & 1073758208) != 0) {
                        i4 = (i2 << 1) + i9;
                        i14 = i3;
                        if ((i16 & 49152) == 32768) {
                            i3 = cpVar2.a(m[i16 & FrameMetricsAggregator.EVERY_DURATION]);
                            iArr2[i4] = iArr2[i4] & i7;
                            iArr2[i4] = ((i3 << i) | i6) | iArr2[i4];
                            i16 |= 256;
                        }
                        if (i13 < 4) {
                            iArr[a] = i16;
                        } else {
                            if ((iArr[a] & -1073741824) == Integer.MIN_VALUE) {
                                i4 += i2;
                                i3 = cpVar2.a(m[(i16 >>> 16) & FrameMetricsAggregator.EVERY_DURATION]);
                                iArr2[i4] = iArr2[i4] & i7;
                                iArr2[i4] = ((i3 << i) | i6) | iArr2[i4];
                                i16 |= 16777216;
                            }
                            iArr[a] = i16;
                        }
                        i9++;
                        i10++;
                        i8 = i17;
                        i4 = i15;
                        i3 = i14;
                        cvVar2 = cvVar;
                    }
                }
                i14 = i3;
                i9++;
                i10++;
                i8 = i17;
                i4 = i15;
                i3 = i14;
                cvVar2 = cvVar;
            }
            i14 = i3;
            i11--;
            i9 += i5;
            i10 += i4;
            i8 = i12;
            cvVar2 = cvVar;
        }
        boolean z2 = false;
        if (z) {
            cqVar = this;
            if ((cqVar.g & 16) != 0) {
                z2 = cpVar.a();
            }
        } else {
            cqVar = this;
        }
        if ((cqVar.g & 2) != 0) {
            cpVar.b();
        }
        return z2;
    }

    private boolean b(cv cvVar, cl clVar, int i, int[] iArr, boolean z) {
        cv cvVar2 = cvVar;
        int i2 = cvVar2.f;
        int i3 = cvVar2.c + 2;
        int i4 = ((i3 * 4) / 2) - cvVar2.c;
        int i5 = (i2 * 4) - cvVar2.c;
        int i6 = (1 << i) >> 1;
        int i7 = -1 << (i + 1);
        int[] iArr2 = (int[]) cvVar.b();
        int i8 = 4;
        int i9 = ((cvVar2.d + 4) - 1) / 4;
        int i10 = cvVar2.e;
        int i11 = i3 + 1;
        i9--;
        int i12 = i9;
        while (i12 >= 0) {
            if (i12 == 0) {
                i8 = cvVar2.d - (i9 * 4);
            }
            int i13 = cvVar2.c + i10;
            while (i10 < i13) {
                int i14;
                int i15;
                int i16;
                int i17 = iArr[i11];
                if ((((i17 >>> 1) & (i17 ^ -1)) & 1073758208) != 0) {
                    i14 = i13;
                    if ((i17 & 49152) == 32768) {
                        i13 = clVar.a();
                        iArr2[i10] = iArr2[i10] & i7;
                        iArr2[i10] = iArr2[i10] | ((i13 << i) | i6);
                    }
                    if (i8 >= 2) {
                        if ((i17 & -1073741824) == Integer.MIN_VALUE) {
                            i15 = i10 + i2;
                            i13 = clVar.a();
                            iArr2[i15] = iArr2[i15] & i7;
                            iArr2[i15] = iArr2[i15] | ((i13 << i) | i6);
                        }
                    }
                    i16 = i3;
                    i10++;
                    i11++;
                    i13 = i14;
                    i3 = i16;
                    cvVar2 = cvVar;
                } else {
                    i14 = i13;
                }
                if (i8 >= 3) {
                    i15 = i11 + i3;
                    i13 = iArr[i15];
                    if ((((i13 >>> 1) & (i13 ^ -1)) & 1073758208) != 0) {
                        i17 = i10 + (i2 << 1);
                        i16 = i3;
                        if ((i13 & 49152) == 32768) {
                            i3 = clVar.a();
                            iArr2[i17] = iArr2[i17] & i7;
                            iArr2[i17] = ((i3 << i) | i6) | iArr2[i17];
                        }
                        if (i8 >= 4 && (iArr[i15] & -1073741824) == Integer.MIN_VALUE) {
                            i17 += i2;
                            i15 = clVar.a();
                            iArr2[i17] = iArr2[i17] & i7;
                            iArr2[i17] = ((i15 << i) | i6) | iArr2[i17];
                        }
                        i10++;
                        i11++;
                        i13 = i14;
                        i3 = i16;
                        cvVar2 = cvVar;
                    }
                }
                i16 = i3;
                i10++;
                i11++;
                i13 = i14;
                i3 = i16;
                cvVar2 = cvVar;
            }
            i12--;
            i10 += i5;
            i11 += i4;
            i3 = i3;
            cvVar2 = cvVar;
            i8 = 4;
        }
        if (!z) {
            return false;
        } else if ((this.g & 16) != 0) {
            return clVar.b();
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03df A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x043a  */
    private boolean b(jumio.nv.nfc.cv r36, jumio.nv.nfc.cp r37, int r38, int[] r39, int[] r40, boolean r41) {
        /*
        r35 = this;
        r0 = r35;
        r1 = r36;
        r2 = r37;
        r5 = r1.f;
        r6 = r1.c;
        r7 = 2;
        r6 = r6 + r7;
        r8 = r6 * 4;
        r8 = r8 / r7;
        r9 = r1.c;
        r8 = r8 - r9;
        r9 = r5 * 4;
        r10 = r1.c;
        r9 = r9 - r10;
        r10 = 3;
        r11 = r10 << r38;
        r12 = 1;
        r11 = r11 >> r12;
        r13 = r36.b();
        r13 = (int[]) r13;
        r14 = r1.d;
        r15 = 4;
        r14 = r14 + r15;
        r14 = r14 - r12;
        r14 = r14 / r15;
        r10 = r0.g;
        r10 = r10 & 8;
        if (r10 == 0) goto L_0x0030;
    L_0x002e:
        r10 = 1;
        goto L_0x0031;
    L_0x0030:
        r10 = 0;
    L_0x0031:
        r7 = -r6;
        r17 = r7 + -1;
        r7 = r7 + r12;
        r18 = r6 + 1;
        r19 = r6 + -1;
        r15 = r1.e;
        r14 = r14 - r12;
        r20 = r15;
        r21 = r18;
        r15 = r14;
    L_0x0041:
        if (r15 < 0) goto L_0x0400;
    L_0x0043:
        if (r15 == 0) goto L_0x0049;
    L_0x0045:
        r24 = r14;
        r12 = 4;
        goto L_0x0051;
    L_0x0049:
        r12 = r1.d;
        r23 = r14 * 4;
        r12 = r12 - r23;
        r24 = r14;
    L_0x0051:
        r14 = r1.c;
        r14 = r20 + r14;
        r1 = r20;
    L_0x0057:
        if (r1 >= r14) goto L_0x03ed;
    L_0x0059:
        r20 = r39[r21];
        r23 = 571473920; // 0x22100000 float:1.951564E-18 double:2.823456314E-315;
        r25 = 606126080; // 0x2420c000 float:3.48571E-17 double:2.99466073E-315;
        r26 = 537001984; // 0x20020000 float:1.1011428E-19 double:2.65314232E-315;
        r27 = 536936448; // 0x20010000 float:1.0926725E-19 double:2.65281853E-315;
        r28 = -1073758209; // 0xffffffffbfffbfff float:-1.9980468 double:NaN;
        r29 = r14;
        if (r20 != 0) goto L_0x01ab;
    L_0x006b:
        r30 = r21 + r6;
        r31 = r39[r30];
        if (r31 != 0) goto L_0x01ab;
    L_0x0071:
        r14 = 4;
        if (r12 != r14) goto L_0x01ab;
    L_0x0074:
        r14 = 1;
        r22 = r2.a(r14);
        if (r22 == 0) goto L_0x01a5;
    L_0x007b:
        r0 = 0;
        r16 = r2.a(r0);
        r22 = r16 << 1;
        r31 = r2.a(r0);
        r0 = r22 | r31;
        r22 = r0 * r5;
        r31 = r1 + r22;
        if (r0 <= r14) goto L_0x0091;
    L_0x008e:
        r20 = r39[r30];
        goto L_0x0093;
    L_0x0091:
        r30 = r21;
    L_0x0093:
        r14 = r0 & 1;
        if (r14 != 0) goto L_0x0124;
    L_0x0097:
        r14 = l;
        r32 = r8;
        r8 = r20 >> 4;
        r8 = r8 & 511;
        r8 = r14[r8];
        r14 = r8 & 15;
        r14 = r2.a(r14);
        r8 = r8 >>> 31;
        r8 = r8 ^ r14;
        r14 = r8 << 31;
        r14 = r14 | r11;
        r13[r31] = r14;
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        if (r10 != 0) goto L_0x00c3;
    L_0x00b3:
        r14 = r30 + r17;
        r31 = r39[r14];
        r31 = r31 | r27;
        r39[r14] = r31;
        r14 = r30 + r7;
        r31 = r39[r14];
        r31 = r31 | r26;
        r39[r14] = r31;
    L_0x00c3:
        if (r8 == 0) goto L_0x00ec;
    L_0x00c5:
        r8 = r20 | r25;
        if (r0 != 0) goto L_0x00cb;
    L_0x00c9:
        if (r10 != 0) goto L_0x00d3;
    L_0x00cb:
        r14 = r30 - r6;
        r20 = r39[r14];
        r20 = r20 | r23;
        r39[r14] = r20;
    L_0x00d3:
        r14 = r30 + 1;
        r20 = r39[r14];
        r31 = 537407616; // 0x20083080 float:1.1535695E-19 double:2.65514641E-315;
        r20 = r20 | r31;
        r39[r14] = r20;
        r14 = r30 + -1;
        r20 = r39[r14];
        r31 = 537143360; // 0x20042840 float:1.1194153E-19 double:2.65384081E-315;
        r20 = r20 | r31;
        r39[r14] = r20;
    L_0x00e9:
        r20 = r8;
        goto L_0x0116;
    L_0x00ec:
        r8 = 539017216; // 0x2020c000 float:1.3616055E-19 double:2.66309889E-315;
        r8 = r20 | r8;
        if (r0 != 0) goto L_0x00f5;
    L_0x00f3:
        if (r10 != 0) goto L_0x00ff;
    L_0x00f5:
        r14 = r30 - r6;
        r20 = r39[r14];
        r31 = 537919488; // 0x20100000 float:1.2197274E-19 double:2.657675392E-315;
        r20 = r20 | r31;
        r39[r14] = r20;
    L_0x00ff:
        r14 = r30 + 1;
        r20 = r39[r14];
        r31 = 537403520; // 0x20082080 float:1.1530401E-19 double:2.65512617E-315;
        r20 = r20 | r31;
        r39[r14] = r20;
        r14 = r30 + -1;
        r20 = r39[r14];
        r31 = 537141312; // 0x20042040 float:1.1191506E-19 double:2.65383069E-315;
        r20 = r20 | r31;
        r39[r14] = r20;
        goto L_0x00e9;
    L_0x0116:
        r0 = r0 >> 1;
        if (r0 == 0) goto L_0x011e;
    L_0x011a:
        r33 = r9;
        goto L_0x02cc;
    L_0x011e:
        r33 = r9;
        r0 = r20;
        goto L_0x01b3;
    L_0x0124:
        r32 = r8;
        r8 = l;
        r14 = r20 >> 20;
        r14 = r14 & 511;
        r8 = r8[r14];
        r14 = r8 & 15;
        r14 = r2.a(r14);
        r8 = r8 >>> 31;
        r8 = r8 ^ r14;
        r14 = r8 << 31;
        r14 = r14 | r11;
        r13[r31] = r14;
        r14 = r30 + r19;
        r33 = r9;
        r9 = r39[r14];
        r9 = r9 | 8196;
        r39[r14] = r9;
        r9 = r30 + r18;
        r14 = r39[r9];
        r14 = r14 | 8200;
        r39[r9] = r14;
        if (r8 == 0) goto L_0x0174;
    L_0x0150:
        r8 = -2147474928; // 0xffffffff80002210 float:-1.222E-41 double:NaN;
        r8 = r20 | r8;
        r9 = r30 + r6;
        r14 = r39[r9];
        r14 = r14 | 9248;
        r39[r9] = r14;
        r9 = r30 + 1;
        r14 = r39[r9];
        r20 = 813703170; // 0x30802002 float:9.322323E-10 double:4.02022782E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        r9 = r30 + -1;
        r14 = r39[r9];
        r20 = 675291137; // 0x28402001 float:1.0665081E-14 double:3.336381517E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        goto L_0x0197;
    L_0x0174:
        r8 = -2147475440; // 0xffffffff80002010 float:-1.1502E-41 double:NaN;
        r8 = r20 | r8;
        r9 = r30 + r6;
        r14 = r39[r9];
        r14 = r14 | 8224;
        r39[r9] = r14;
        r9 = r30 + 1;
        r14 = r39[r9];
        r20 = 545267714; // 0x20802002 float:2.1705224E-19 double:2.693980453E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        r9 = r30 + -1;
        r14 = r39[r9];
        r20 = 541073409; // 0x20402001 float:1.6273622E-19 double:2.673257833E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
    L_0x0197:
        r39[r30] = r8;
        r0 = r0 >> 1;
        if (r0 == 0) goto L_0x019f;
    L_0x019d:
        goto L_0x03df;
    L_0x019f:
        r30 = r30 + r6;
        r20 = r39[r30];
        goto L_0x02cc;
    L_0x01a5:
        r32 = r8;
        r33 = r9;
        goto L_0x03df;
    L_0x01ab:
        r32 = r8;
        r33 = r9;
        r0 = r20;
        r30 = r21;
    L_0x01b3:
        r8 = r0 >> 1;
        r8 = r8 | r0;
        r9 = 1073758208; // 0x40004000 float:2.0039062 double:5.305070425E-315;
        r8 = r8 & r9;
        if (r8 == r9) goto L_0x02bf;
    L_0x01bc:
        r8 = 49152; // 0xc000 float:6.8877E-41 double:2.42843E-319;
        r8 = r8 & r0;
        if (r8 != 0) goto L_0x023a;
    L_0x01c2:
        r8 = r0 & 255;
        r8 = r40[r8];
        r8 = r2.a(r8);
        if (r8 == 0) goto L_0x023a;
    L_0x01cc:
        r8 = l;
        r9 = r0 >>> 4;
        r9 = r9 & 511;
        r8 = r8[r9];
        r9 = r8 & 15;
        r9 = r2.a(r9);
        r8 = r8 >>> 31;
        r8 = r8 ^ r9;
        r9 = r8 << 31;
        r9 = r9 | r11;
        r13[r1] = r9;
        if (r10 != 0) goto L_0x01f4;
    L_0x01e4:
        r9 = r30 + r17;
        r14 = r39[r9];
        r14 = r14 | r27;
        r39[r9] = r14;
        r9 = r30 + r7;
        r14 = r39[r9];
        r14 = r14 | r26;
        r39[r9] = r14;
    L_0x01f4:
        if (r8 == 0) goto L_0x0217;
    L_0x01f6:
        r0 = r0 | r25;
        if (r10 != 0) goto L_0x0202;
    L_0x01fa:
        r8 = r30 - r6;
        r9 = r39[r8];
        r9 = r9 | r23;
        r39[r8] = r9;
    L_0x0202:
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 537407616; // 0x20083080 float:1.1535695E-19 double:2.65514641E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 537143360; // 0x20042840 float:1.1194153E-19 double:2.65384081E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        goto L_0x023a;
    L_0x0217:
        r8 = 539017216; // 0x2020c000 float:1.3616055E-19 double:2.66309889E-315;
        r0 = r0 | r8;
        if (r10 != 0) goto L_0x0226;
    L_0x021d:
        r8 = r30 - r6;
        r9 = r39[r8];
        r14 = 537919488; // 0x20100000 float:1.2197274E-19 double:2.657675392E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
    L_0x0226:
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 537403520; // 0x20082080 float:1.1530401E-19 double:2.65512617E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 537141312; // 0x20042040 float:1.1191506E-19 double:2.65383069E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
    L_0x023a:
        r8 = 2;
        if (r12 >= r8) goto L_0x0243;
    L_0x023d:
        r0 = r0 & r28;
        r39[r30] = r0;
        goto L_0x03df;
    L_0x0243:
        r8 = -1073741824; // 0xffffffffc0000000 float:-2.0 double:NaN;
        r8 = r8 & r0;
        if (r8 != 0) goto L_0x02bf;
    L_0x0248:
        r8 = r1 + r5;
        r9 = r0 >>> 16;
        r9 = r9 & 255;
        r9 = r40[r9];
        r9 = r2.a(r9);
        if (r9 == 0) goto L_0x02bf;
    L_0x0256:
        r9 = l;
        r14 = r0 >>> 20;
        r14 = r14 & 511;
        r9 = r9[r14];
        r14 = r9 & 15;
        r14 = r2.a(r14);
        r9 = r9 >>> 31;
        r9 = r9 ^ r14;
        r14 = r9 << 31;
        r14 = r14 | r11;
        r13[r8] = r14;
        r8 = r30 + r19;
        r14 = r39[r8];
        r14 = r14 | 8196;
        r39[r8] = r14;
        r8 = r30 + r18;
        r14 = r39[r8];
        r14 = r14 | 8200;
        r39[r8] = r14;
        if (r9 == 0) goto L_0x029f;
    L_0x027e:
        r8 = -1073733104; // 0xffffffffc0002210 float:-2.002079 double:NaN;
        r0 = r0 | r8;
        r8 = r30 + r6;
        r9 = r39[r8];
        r9 = r9 | 9248;
        r39[r8] = r9;
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 813703170; // 0x30802002 float:9.322323E-10 double:4.02022782E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 675291137; // 0x28402001 float:1.0665081E-14 double:3.336381517E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        goto L_0x02bf;
    L_0x029f:
        r8 = -1073733616; // 0xffffffffc0002010 float:-2.001957 double:NaN;
        r0 = r0 | r8;
        r8 = r30 + r6;
        r9 = r39[r8];
        r9 = r9 | 8224;
        r39[r8] = r9;
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 545267714; // 0x20802002 float:2.1705224E-19 double:2.693980453E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 541073409; // 0x20402001 float:1.6273622E-19 double:2.673257833E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
    L_0x02bf:
        r0 = r0 & r28;
        r39[r30] = r0;
        r0 = 3;
        if (r12 >= r0) goto L_0x02c8;
    L_0x02c6:
        goto L_0x03df;
    L_0x02c8:
        r30 = r30 + r6;
        r20 = r39[r30];
    L_0x02cc:
        r0 = r20;
        r8 = r0 >> 1;
        r8 = r8 | r0;
        r9 = 1073758208; // 0x40004000 float:2.0039062 double:5.305070425E-315;
        r8 = r8 & r9;
        if (r8 == r9) goto L_0x03db;
    L_0x02d7:
        r8 = r5 << 1;
        r8 = r8 + r1;
        r9 = 49152; // 0xc000 float:6.8877E-41 double:2.42843E-319;
        r9 = r9 & r0;
        if (r9 != 0) goto L_0x0357;
    L_0x02e0:
        r9 = r0 & 255;
        r9 = r40[r9];
        r9 = r2.a(r9);
        if (r9 == 0) goto L_0x0357;
    L_0x02ea:
        r9 = l;
        r14 = r0 >> 4;
        r14 = r14 & 511;
        r9 = r9[r14];
        r14 = r9 & 15;
        r14 = r2.a(r14);
        r9 = r9 >>> 31;
        r9 = r9 ^ r14;
        r14 = r9 << 31;
        r14 = r14 | r11;
        r13[r8] = r14;
        r14 = r30 + r17;
        r20 = r39[r14];
        r20 = r20 | r27;
        r39[r14] = r20;
        r14 = r30 + r7;
        r20 = r39[r14];
        r20 = r20 | r26;
        r39[r14] = r20;
        if (r9 == 0) goto L_0x0333;
    L_0x0312:
        r0 = r0 | r25;
        r9 = r30 - r6;
        r14 = r39[r9];
        r14 = r14 | r23;
        r39[r9] = r14;
        r9 = r30 + 1;
        r14 = r39[r9];
        r20 = 537407616; // 0x20083080 float:1.1535695E-19 double:2.65514641E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        r9 = r30 + -1;
        r14 = r39[r9];
        r20 = 537143360; // 0x20042840 float:1.1194153E-19 double:2.65384081E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        goto L_0x0357;
    L_0x0333:
        r9 = 539017216; // 0x2020c000 float:1.3616055E-19 double:2.66309889E-315;
        r0 = r0 | r9;
        r9 = r30 - r6;
        r14 = r39[r9];
        r20 = 537919488; // 0x20100000 float:1.2197274E-19 double:2.657675392E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        r9 = r30 + 1;
        r14 = r39[r9];
        r20 = 537403520; // 0x20082080 float:1.1530401E-19 double:2.65512617E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
        r9 = r30 + -1;
        r14 = r39[r9];
        r20 = 537141312; // 0x20042040 float:1.1191506E-19 double:2.65383069E-315;
        r14 = r14 | r20;
        r39[r9] = r14;
    L_0x0357:
        r9 = 4;
        if (r12 >= r9) goto L_0x0360;
    L_0x035a:
        r0 = r0 & r28;
        r39[r30] = r0;
        goto L_0x03df;
    L_0x0360:
        r14 = -1073741824; // 0xffffffffc0000000 float:-2.0 double:NaN;
        r14 = r14 & r0;
        if (r14 != 0) goto L_0x03db;
    L_0x0365:
        r8 = r8 + r5;
        r14 = r0 >>> 16;
        r14 = r14 & 255;
        r14 = r40[r14];
        r14 = r2.a(r14);
        if (r14 == 0) goto L_0x03db;
    L_0x0372:
        r14 = l;
        r9 = r0 >>> 20;
        r9 = r9 & 511;
        r9 = r14[r9];
        r14 = r9 & 15;
        r14 = r2.a(r14);
        r9 = r9 >>> 31;
        r9 = r9 ^ r14;
        r14 = r9 << 31;
        r14 = r14 | r11;
        r13[r8] = r14;
        r8 = r30 + r19;
        r14 = r39[r8];
        r14 = r14 | 8196;
        r39[r8] = r14;
        r8 = r30 + r18;
        r14 = r39[r8];
        r14 = r14 | 8200;
        r39[r8] = r14;
        if (r9 == 0) goto L_0x03bb;
    L_0x039a:
        r8 = -1073733104; // 0xffffffffc0002210 float:-2.002079 double:NaN;
        r0 = r0 | r8;
        r8 = r30 + r6;
        r9 = r39[r8];
        r9 = r9 | 9248;
        r39[r8] = r9;
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 813703170; // 0x30802002 float:9.322323E-10 double:4.02022782E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 675291137; // 0x28402001 float:1.0665081E-14 double:3.336381517E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        goto L_0x03db;
    L_0x03bb:
        r8 = -1073733616; // 0xffffffffc0002010 float:-2.001957 double:NaN;
        r0 = r0 | r8;
        r8 = r30 + r6;
        r9 = r39[r8];
        r9 = r9 | 8224;
        r39[r8] = r9;
        r8 = r30 + 1;
        r9 = r39[r8];
        r14 = 545267714; // 0x20802002 float:2.1705224E-19 double:2.693980453E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
        r8 = r30 + -1;
        r9 = r39[r8];
        r14 = 541073409; // 0x20402001 float:1.6273622E-19 double:2.673257833E-315;
        r9 = r9 | r14;
        r39[r8] = r9;
    L_0x03db:
        r0 = r0 & r28;
        r39[r30] = r0;
    L_0x03df:
        r1 = r1 + 1;
        r21 = r21 + 1;
        r14 = r29;
        r8 = r32;
        r9 = r33;
        r0 = r35;
        goto L_0x0057;
    L_0x03ed:
        r32 = r8;
        r33 = r9;
        r15 = r15 + -1;
        r20 = r1 + r33;
        r21 = r21 + r32;
        r14 = r24;
        r0 = r35;
        r1 = r36;
        r12 = 1;
        goto L_0x0041;
    L_0x0400:
        r1 = r0.g;
        r1 = r1 & 32;
        if (r1 == 0) goto L_0x0426;
    L_0x0406:
        r1 = 0;
        r3 = r2.a(r1);
        r4 = 3;
        r3 = r3 << r4;
        r4 = r2.a(r1);
        r5 = 2;
        r4 = r4 << r5;
        r3 = r3 | r4;
        r4 = r2.a(r1);
        r5 = 1;
        r4 = r4 << r5;
        r3 = r3 | r4;
        r4 = r2.a(r1);
        r3 = r3 | r4;
        r4 = 10;
        if (r3 == r4) goto L_0x0427;
    L_0x0424:
        r7 = 1;
        goto L_0x0428;
    L_0x0426:
        r1 = 0;
    L_0x0427:
        r7 = 0;
    L_0x0428:
        if (r41 == 0) goto L_0x0434;
    L_0x042a:
        r1 = r0.g;
        r1 = r1 & 16;
        if (r1 == 0) goto L_0x0434;
    L_0x0430:
        r7 = r37.a();
    L_0x0434:
        r1 = r0.g;
        r3 = 2;
        r1 = r1 & r3;
        if (r1 == 0) goto L_0x043d;
    L_0x043a:
        r37.b();
    L_0x043d:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.cq.b(jumio.nv.nfc.cv, jumio.nv.nfc.cp, int, int[], int[], boolean):boolean");
    }

    private void a(cv cvVar, int i) {
        int i2 = 1 << i;
        i = -1 << i;
        int[] iArr = (int[]) cvVar.b();
        int i3 = cvVar.e;
        for (int i4 = cvVar.d - 1; i4 >= 0; i4--) {
            int i5 = cvVar.c + i3;
            while (i3 < i5) {
                int i6 = iArr[i3] & i;
                if ((ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i6) != 0) {
                    iArr[i3] = i6 | i2;
                } else {
                    iArr[i3] = 0;
                }
                i3++;
            }
            i3 += cvVar.f - cvVar.c;
        }
    }
}
