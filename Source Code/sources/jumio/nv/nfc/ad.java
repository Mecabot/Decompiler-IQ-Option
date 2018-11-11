package jumio.nv.nfc;

/* compiled from: Resampler */
public class ad extends aa {
    final int s = 0;
    final int t = 0;

    public int e(int i) {
        return 1;
    }

    public int f(int i) {
        return 1;
    }

    public static cs a(cs csVar, y yVar) {
        return new ad(csVar, yVar);
    }

    protected ad(cs csVar, y yVar) {
        super(csVar, yVar);
        int e = csVar.e(0);
        int f = csVar.f(0);
        int i = f;
        int i2 = e;
        for (int i3 = 1; i3 < this.o; i3++) {
            e = Math.min(e, csVar.e(i3));
            f = Math.min(f, csVar.f(i3));
            i2 = Math.max(i2, csVar.e(i3));
            i = Math.max(i, csVar.f(i3));
        }
        if ((i2 != 1 && i2 != 2) || (i != 1 && i != 2)) {
            throw new z("Upsampling by other than 2:1 not supported");
        }
    }

    public cv b(cv cvVar, int i) {
        cv cvVar2 = cvVar;
        int i2 = i;
        if (this.p.e(i2) == 1 && this.p.f(i2) == 1) {
            return this.p.b(cvVar2, i2);
        }
        int e = this.p.e(i2);
        int f = this.p.f(i2);
        if ((e == 2 || e == 1) && (f == 2 || f == 1)) {
            int i3 = cvVar2.b;
            int i4 = (cvVar2.d + i3) - 1;
            int i5 = cvVar2.a;
            int i6 = (cvVar2.c + i5) - 1;
            int i7 = i3 / f;
            int i8 = i5 / e;
            e = ((i6 / e) - i8) + 1;
            int i9 = ((i4 / f) - i7) + 1;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            switch (cvVar.a()) {
                case 3:
                    i10 = i3;
                    cx cxVar = (cx) this.p.b(new cx(i8, i7, e, i9), i2);
                    this.f[i2] = cxVar.c();
                    int[] iArr = (int[]) cvVar.b();
                    if (iArr == null || iArr.length != cvVar2.c * cvVar2.d) {
                        iArr = new int[(cvVar2.d * cvVar2.c)];
                        cvVar2.a(iArr);
                    }
                    for (i3 = i10; i3 <= i4; i3++) {
                        i8 = cxVar.e + (((i3 / f) - i7) * cxVar.f);
                        i9 = cxVar.c;
                        i9 = cvVar2.e + ((i3 - i10) * cvVar2.f);
                        i11 = cvVar2.c + i9;
                        if ((i5 & 1) == 1) {
                            i12 = i9 + 1;
                            i13 = i8 + 1;
                            iArr[i9] = this.f[i2][i8];
                            i9 = i12;
                            i8 = i13;
                        }
                        i12 = i6 & 1;
                        if (i12 == 0) {
                            i11--;
                        }
                        while (i9 < i11) {
                            i13 = i9 + 1;
                            iArr[i9] = this.f[i2][i8];
                            i9 = i13 + 1;
                            i14 = i8 + 1;
                            iArr[i13] = this.f[i2][i8];
                            i8 = i14;
                        }
                        if (i12 == 0) {
                            iArr[i9] = this.f[i2][i8];
                        }
                    }
                    cvVar2.g = cxVar.g;
                    break;
                case 4:
                    cw cwVar = (cw) this.p.b(new cw(i8, i7, e, i9), i2);
                    this.g[i2] = cwVar.c();
                    float[] fArr = (float[]) cvVar.b();
                    if (fArr == null || fArr.length != cvVar2.c * cvVar2.d) {
                        fArr = new float[(cvVar2.d * cvVar2.c)];
                        cvVar2.a(fArr);
                    }
                    i8 = i3;
                    while (i8 <= i4) {
                        int i15 = cwVar.e + (((i8 / f) - i7) * cwVar.f);
                        i11 = cwVar.c;
                        i11 = cvVar2.e + ((i8 - i3) * cvVar2.f);
                        int i16 = cvVar2.c + i11;
                        i10 = i3;
                        if ((i5 & 1) == 1) {
                            i3 = i11 + 1;
                            i13 = i15 + 1;
                            fArr[i11] = this.g[i2][i15];
                            i11 = i3;
                            i15 = i13;
                        }
                        i12 = i6 & 1;
                        if (i12 == 0) {
                            i16--;
                        }
                        while (i11 < i16) {
                            i3 = i11 + 1;
                            int i17 = i16;
                            fArr[i11] = this.g[i2][i15];
                            i11 = i3 + 1;
                            i14 = i15 + 1;
                            fArr[i3] = this.g[i2][i15];
                            i15 = i14;
                            i16 = i17;
                        }
                        if (i12 == 0) {
                            fArr[i11] = this.g[i2][i15];
                        }
                        i8++;
                        i3 = i10;
                    }
                    cvVar2.g = cwVar.g;
                    break;
                default:
                    throw new IllegalArgumentException("invalid source datablock type");
            }
            return cvVar2;
        }
        throw new IllegalArgumentException("Upsampling by other than 2:1 not supported");
    }

    public cv a(cv cvVar, int i) {
        return b(cvVar, i);
    }

    public int c(int i) {
        return this.p.c(i) * this.p.f(i);
    }

    public int d(int i) {
        return this.p.d(i) * this.p.e(i);
    }

    public int a(int i, int i2) {
        return this.p.a(i, i2) * this.p.f(i2);
    }

    public int b(int i, int i2) {
        return this.p.b(i, i2) * this.p.e(i2);
    }
}
