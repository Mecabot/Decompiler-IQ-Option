package jumio.nv.nfc;

/* compiled from: InvCompTransf */
public class db extends cz implements cs {
    private static final String[][] a = ((String[][]) null);
    private cs b;
    private ct c;
    private em d;
    private int e = 0;
    private int[][] f = new int[3][];
    private cv g;
    private cv h;
    private cv i;
    private cx j = new cx();
    private int[] k;
    private boolean l = false;

    public db(cs csVar, cg cgVar, int[] iArr, dt dtVar) {
        super(csVar);
        this.c = cgVar.k;
        this.d = cgVar.f;
        this.b = csVar;
        this.k = iArr;
        this.l = dtVar.b("comp_transf") ^ 1;
    }

    public static String[][] a() {
        return a;
    }

    public int a(int i) {
        return this.b.a(i);
    }

    public static int[] a(int[] iArr, int i, int[] iArr2) {
        if (iArr.length >= 3 || i == 0) {
            Object iArr22;
            if (iArr22 == null) {
                iArr22 = new int[iArr.length];
            }
            switch (i) {
                case 0:
                    System.arraycopy(iArr, 0, iArr22, 0, iArr.length);
                    break;
                case 1:
                    if (iArr.length > 3) {
                        System.arraycopy(iArr, 3, iArr22, 3, iArr.length - 3);
                    }
                    iArr22[0] = (ds.a((((1 << iArr[0]) + (2 << iArr[1])) + (1 << iArr[2])) - 1) - 2) + 1;
                    iArr22[1] = ds.a(((1 << iArr[2]) + (1 << iArr[1])) - 1) + 1;
                    iArr22[2] = ds.a(((1 << iArr[0]) + (1 << iArr[1])) - 1) + 1;
                    break;
                case 2:
                    if (iArr.length > 3) {
                        System.arraycopy(iArr, 3, iArr22, 3, iArr.length - 3);
                    }
                    iArr22[0] = ds.a(((int) Math.floor(((((double) (1 << iArr[0])) * 0.299072d) + (((double) (1 << iArr[1])) * 0.586914d)) + (((double) (1 << iArr[2])) * 0.114014d))) - 1) + 1;
                    iArr22[1] = ds.a(((int) Math.floor(((((double) (1 << iArr[0])) * 0.168701d) + (((double) (1 << iArr[1])) * 0.331299d)) + (((double) (1 << iArr[2])) * 0.5d))) - 1) + 1;
                    iArr22[2] = ds.a(((int) Math.floor(((((double) (1 << iArr[0])) * 0.5d) + (((double) (1 << iArr[1])) * 0.418701d)) + (((double) (1 << iArr[2])) * 0.081299d))) - 1) + 1;
                    break;
            }
            return iArr22;
        }
        throw new IllegalArgumentException();
    }

    public int b(int i) {
        return this.k[i];
    }

    public cv a(cv cvVar, int i) {
        if (i >= 3 || this.e == 0 || this.l) {
            return this.b.a(cvVar, i);
        }
        return b(cvVar, i);
    }

    public cv b(cv cvVar, int i) {
        if (this.l) {
            return this.b.b(cvVar, i);
        }
        switch (this.e) {
            case 0:
                return this.b.b(cvVar, i);
            case 1:
                return c(cvVar, i);
            case 2:
                return d(cvVar, i);
            default:
                throw new IllegalArgumentException("Non JPEG 2000 part I component transformation");
        }
    }

    private cv c(cv cvVar, int i) {
        cv cvVar2 = cvVar;
        int i2 = i;
        if (i2 >= 3 && i2 < b()) {
            return this.b.b(cvVar2, i2);
        }
        if (this.f[i2] == null || this.j.a > cvVar2.a || this.j.b > cvVar2.b || this.j.a + this.j.c < cvVar2.a + cvVar2.c || this.j.b + this.j.d < cvVar2.b + cvVar2.d) {
            int i3 = cvVar2.c;
            int i4 = cvVar2.d;
            this.f[i2] = (int[]) cvVar.b();
            if (this.f[i2] == null || this.f[i2].length != i4 * i3) {
                this.f[i2] = new int[(i4 * i3)];
                cvVar2.a(this.f[i2]);
            }
            this.f[(i2 + 1) % 3] = new int[this.f[i2].length];
            this.f[(i2 + 2) % 3] = new int[this.f[i2].length];
            if (this.g == null || this.g.a() != 3) {
                this.g = new cx();
            }
            if (this.h == null || this.h.a() != 3) {
                this.h = new cx();
            }
            if (this.i == null || this.i.a() != 3) {
                this.i = new cx();
            }
            cv cvVar3 = this.g;
            cv cvVar4 = this.h;
            cv cvVar5 = this.i;
            int i5 = cvVar2.c;
            cvVar5.c = i5;
            cvVar4.c = i5;
            cvVar3.c = i5;
            cvVar3 = this.g;
            cvVar4 = this.h;
            cvVar5 = this.i;
            i5 = cvVar2.d;
            cvVar5.d = i5;
            cvVar4.d = i5;
            cvVar3.d = i5;
            cvVar3 = this.g;
            cvVar4 = this.h;
            cvVar5 = this.i;
            i5 = cvVar2.a;
            cvVar5.a = i5;
            cvVar4.a = i5;
            cvVar3.a = i5;
            cvVar3 = this.g;
            cvVar4 = this.h;
            cvVar5 = this.i;
            i5 = cvVar2.b;
            cvVar5.b = i5;
            cvVar4.b = i5;
            cvVar3.b = i5;
            this.g = (cx) this.b.b(this.g, 0);
            int[] iArr = (int[]) this.g.b();
            this.h = (cx) this.b.b(this.h, 1);
            int[] iArr2 = (int[]) this.h.b();
            this.i = (cx) this.b.b(this.i, 2);
            int[] iArr3 = (int[]) this.i.b();
            boolean z = this.g.g || this.h.g || this.i.g;
            cvVar2.g = z;
            cvVar2.e = 0;
            cvVar2.f = i3;
            this.j.g = cvVar2.g;
            this.j.a = cvVar2.a;
            this.j.b = cvVar2.b;
            this.j.c = cvVar2.c;
            this.j.d = cvVar2.d;
            int i6 = (i3 * i4) - 1;
            i4--;
            int i7 = ((this.g.e + (this.g.f * i4)) + i3) - 1;
            int i8 = ((this.h.e + (this.h.f * i4)) + i3) - 1;
            int i9 = ((this.i.e + (this.i.f * i4)) + i3) - 1;
            while (i4 >= 0) {
                int i10 = i6 - i3;
                while (i6 > i10) {
                    this.f[1][i6] = iArr[i7] - ((iArr2[i8] + iArr3[i9]) >> 2);
                    this.f[0][i6] = iArr3[i9] + this.f[1][i6];
                    this.f[2][i6] = iArr2[i8] + this.f[1][i6];
                    i6--;
                    i7--;
                    i8--;
                    i9--;
                }
                i7 -= this.g.f - i3;
                i8 -= this.h.f - i3;
                i9 -= this.i.f - i3;
                i4--;
            }
            this.f[i2] = null;
        } else if (i2 < 0 || i2 >= 3) {
            throw new IllegalArgumentException();
        } else {
            cvVar2.a(this.f[i2]);
            cvVar2.g = this.j.g;
            cvVar2.e = (((cvVar2.b - this.j.b) * this.j.c) + cvVar2.a) - this.j.a;
            cvVar2.f = this.j.c;
            this.f[i2] = null;
        }
        return cvVar2;
    }

    private cv d(cv cvVar, int i) {
        cv cvVar2 = cvVar;
        int i2 = i;
        int i3 = 0;
        int i4 = 1;
        int i5;
        if (i2 >= 3 && i2 < b()) {
            int i6 = cvVar2.c;
            i5 = cvVar2.d;
            int[] iArr = (int[]) cvVar.b();
            if (iArr == null) {
                iArr = new int[(i5 * i6)];
                cvVar2.a(iArr);
            }
            cv cwVar = new cw(cvVar2.a, cvVar2.b, i6, i5);
            this.b.b(cwVar, i2);
            float[] fArr = (float[]) cwVar.b();
            int i7 = (i6 * i5) - 1;
            i5--;
            int i8 = ((cwVar.e + (cwVar.f * i5)) + i6) - 1;
            while (i5 >= 0) {
                i4 = i7 - i6;
                while (i7 > i4) {
                    iArr[i7] = (int) fArr[i8];
                    i7--;
                    i8--;
                }
                i8 -= cwVar.f - i6;
                i5--;
            }
            cvVar2.g = cwVar.g;
            cvVar2.e = 0;
            cvVar2.f = i6;
        } else if (this.f[i2] == null || this.j.a > cvVar2.a || this.j.b > cvVar2.b || this.j.a + this.j.c < cvVar2.a + cvVar2.c || this.j.b + this.j.d < cvVar2.b + cvVar2.d) {
            i5 = cvVar2.c;
            int i9 = cvVar2.d;
            this.f[i2] = (int[]) cvVar.b();
            if (this.f[i2] == null || this.f[i2].length != i5 * i9) {
                this.f[i2] = new int[(i9 * i5)];
                cvVar2.a(this.f[i2]);
            }
            this.f[(i2 + 1) % 3] = new int[this.f[i2].length];
            this.f[(i2 + 2) % 3] = new int[this.f[i2].length];
            if (this.g == null || this.g.a() != 4) {
                this.g = new cw();
            }
            if (this.i == null || this.i.a() != 4) {
                this.i = new cw();
            }
            if (this.h == null || this.h.a() != 4) {
                this.h = new cw();
            }
            cv cvVar3 = this.g;
            cv cvVar4 = this.i;
            cv cvVar5 = this.h;
            int i10 = cvVar2.c;
            cvVar5.c = i10;
            cvVar4.c = i10;
            cvVar3.c = i10;
            cvVar3 = this.g;
            cvVar4 = this.i;
            cvVar5 = this.h;
            i10 = cvVar2.d;
            cvVar5.d = i10;
            cvVar4.d = i10;
            cvVar3.d = i10;
            cvVar3 = this.g;
            cvVar4 = this.i;
            cvVar5 = this.h;
            i10 = cvVar2.a;
            cvVar5.a = i10;
            cvVar4.a = i10;
            cvVar3.a = i10;
            cvVar3 = this.g;
            cvVar4 = this.i;
            cvVar5 = this.h;
            i10 = cvVar2.b;
            cvVar5.b = i10;
            cvVar4.b = i10;
            cvVar3.b = i10;
            this.g = (cw) this.b.b(this.g, 0);
            float[] fArr2 = (float[]) this.g.b();
            this.i = (cw) this.b.b(this.i, 1);
            float[] fArr3 = (float[]) this.i.b();
            this.h = (cw) this.b.b(this.h, 2);
            float[] fArr4 = (float[]) this.h.b();
            boolean z = this.g.g || this.h.g || this.i.g;
            cvVar2.g = z;
            cvVar2.e = 0;
            cvVar2.f = i5;
            this.j.g = cvVar2.g;
            this.j.a = cvVar2.a;
            this.j.b = cvVar2.b;
            this.j.c = cvVar2.c;
            this.j.d = cvVar2.d;
            i10 = (i5 * i9) - 1;
            i9--;
            int i11 = ((this.g.e + (this.g.f * i9)) + i5) - 1;
            int i12 = ((this.i.e + (this.i.f * i9)) + i5) - 1;
            int i13 = ((this.h.e + (this.h.f * i9)) + i5) - 1;
            while (i9 >= 0) {
                int i14 = i10 - i5;
                while (i10 > i14) {
                    this.f[i3][i10] = (int) ((fArr2[i11] + (fArr4[i13] * 1.402f)) + 0.5f);
                    this.f[i4][i10] = (int) (((fArr2[i11] - (fArr3[i12] * 0.34413f)) - (fArr4[i13] * 0.71414f)) + 0.5f);
                    this.f[2][i10] = (int) ((fArr2[i11] + (fArr3[i12] * 1.772f)) + 0.5f);
                    i10--;
                    i11--;
                    i12--;
                    i13--;
                    i3 = 0;
                    i4 = 1;
                }
                i11 -= this.g.f - i5;
                i12 -= this.i.f - i5;
                i13 -= this.h.f - i5;
                i9--;
                i3 = 0;
                i4 = 1;
            }
            this.f[i2] = null;
        } else if (i2 < 0 || i2 > 3) {
            throw new IllegalArgumentException();
        } else {
            cvVar2.a(this.f[i2]);
            cvVar2.g = this.j.g;
            cvVar2.e = (((cvVar2.b - this.j.b) * this.j.c) + cvVar2.a) - this.j.a;
            cvVar2.f = this.j.c;
            this.f[i2] = null;
        }
        return cvVar2;
    }

    public void c(int i, int i2) {
        this.b.c(i, i2);
        this.B = e();
        i2 = 0;
        if (((Integer) this.c.d(this.B)).intValue() == 0) {
            this.e = 0;
            return;
        }
        int i3 = 0;
        while (i2 < (this.b.b() > 3 ? 3 : this.b.b())) {
            i3 += this.d.e(this.B, i2);
            i2++;
        }
        if (i3 == 3) {
            this.e = 1;
        } else if (i3 == 0) {
            this.e = 2;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wavelet transformation and component transformation not coherent in tile");
            stringBuilder.append(this.B);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
