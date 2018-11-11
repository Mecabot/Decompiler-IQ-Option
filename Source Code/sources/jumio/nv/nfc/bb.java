package jumio.nv.nfc;

import java.lang.reflect.Array;

/* compiled from: MatrixBasedTransformTosRGB */
public class bb {
    private static final String a = System.getProperty("line.separator");
    private final double[] b;
    private ax[] c = new ax[3];
    private aw d;
    private final int[] e;
    private final int[] f;
    private int g = 0;
    private int h = 0;
    private float[][] i = ((float[][]) null);

    public bb(at atVar, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        if (atVar.a() != 1) {
            throw new IllegalArgumentException("MatrixBasedTransformTosRGB: wrong type ICCProfile supplied");
        }
        this.e = iArr3;
        this.f = iArr2;
        for (int i = 0; i < 3; i++) {
            this.c[i] = ax.a(atVar.b[i], iArr3[i] + 1);
        }
        at atVar2 = atVar;
        this.b = a(atVar, iArr);
        this.d = aw.a(iArr3[0], iArr3[0], 0.0031308d, 12.92d, 1.055d, 0.4166666666666667d, 0.055d);
    }

    private double[] a(at atVar, int[] iArr) {
        at atVar2 = atVar;
        double a = bk.a(atVar2.c[0].a);
        double a2 = bk.a(atVar2.c[1].a);
        double a3 = bk.a(atVar2.c[2].a);
        double a4 = bk.a(atVar2.c[0].b);
        double a5 = bk.a(atVar2.c[1].b);
        double d = a3;
        double a6 = bk.a(atVar2.c[2].b);
        double d2 = a;
        double a7 = bk.a(atVar2.c[0].c);
        a = bk.a(atVar2.c[1].c);
        double d3 = a2;
        double a8 = bk.a(atVar2.c[2].c);
        r0 = new double[9];
        double d4 = a6;
        r0[0] = ((double) iArr[0]) * (((d2 * 3.1337d) + (a4 * -1.6173d)) + (a7 * -0.4907d));
        r0[1] = ((double) iArr[0]) * (((d3 * 3.1337d) + (a5 * -1.6173d)) + (a * -0.4907d));
        r0[2] = ((double) iArr[0]) * (((3.1337d * d) + (d4 * -1.6173d)) + (-0.4907d * a8));
        r0[3] = ((double) iArr[1]) * (((d2 * -0.9785d) + (a4 * 1.9162d)) + (a7 * 0.0334d));
        r0[4] = ((double) iArr[1]) * (((d3 * -0.9785d) + (a5 * 1.9162d)) + (a * 0.0334d));
        r0[5] = ((double) iArr[1]) * (((-0.9785d * d) + (d4 * 1.9162d)) + (0.0334d * a8));
        r0[6] = ((double) iArr[2]) * (((d2 * 0.072d) + (a4 * -0.229d)) + (a7 * 1.4056d));
        r0[7] = ((double) iArr[2]) * (((d3 * 0.072d) + (a5 * -0.229d)) + (a * 1.4056d));
        r0[8] = ((double) iArr[2]) * (((0.072d * d) + (d4 * -0.229d)) + (a8 * 1.4056d));
        return r0;
    }

    public void a(cx[] cxVarArr, cx[] cxVarArr2) {
        int[][] iArr = new int[3][];
        int[][] iArr2 = new int[3][];
        int i = 0;
        int i2 = cxVarArr[0].d;
        int i3 = cxVarArr[0].c;
        if (this.i == null || this.i[0].length < i3 * i2) {
            this.i = (float[][]) Array.newInstance(float.class, new int[]{3, i3 * i2});
        }
        i2 = 0;
        while (i2 < 3) {
            iArr[i2] = (int[]) cxVarArr[i2].b();
            iArr2[i2] = (int[]) cxVarArr2[i2].b();
            if (iArr2[i2] == null || iArr2[i2].length < iArr[i2].length) {
                iArr2[i2] = new int[iArr[i2].length];
                cxVarArr2[i2].a(iArr2[i2]);
            }
            a(cxVarArr[i2], this.i[i2], this.e[i2], this.c[i2]);
            i2++;
        }
        float[] fArr = this.i[0];
        float[] fArr2 = this.i[1];
        float[] fArr3 = this.i[2];
        int[] iArr3 = iArr2[0];
        int[] iArr4 = iArr2[1];
        int[] iArr5 = iArr2[2];
        int[] iArr6 = this.d.e;
        int i4 = 0;
        int i5 = 0;
        while (i4 < cxVarArr[i].d) {
            int[] iArr7;
            float[] fArr4;
            int[] iArr8;
            int i6 = cxVarArr[i].c + i5;
            while (i5 < i6) {
                iArr7 = iArr3;
                double d = (double) fArr[i5];
                double d2 = (double) fArr2[i5];
                float[] fArr5 = fArr;
                double d3 = (double) fArr3[i5];
                fArr4 = fArr2;
                int i7 = (int) ((((this.b[0] * d) + (this.b[1] * d2)) + (this.b[2] * d3)) + 0.5d);
                if (i7 < 0) {
                    iArr7[i5] = iArr6[0];
                } else if (i7 >= iArr6.length) {
                    iArr7[i5] = iArr6[iArr6.length - 1];
                } else {
                    iArr7[i5] = iArr6[i7];
                }
                iArr8 = iArr5;
                i7 = (int) ((((this.b[3] * d) + (this.b[4] * d2)) + (this.b[5] * d3)) + 0.5d);
                if (i7 < 0) {
                    iArr4[i5] = iArr6[0];
                } else if (i7 >= iArr6.length) {
                    iArr4[i5] = iArr6[iArr6.length - 1];
                } else {
                    iArr4[i5] = iArr6[i7];
                }
                int i8 = (int) ((((this.b[6] * d) + (this.b[7] * d2)) + (this.b[8] * d3)) + 0.5d);
                if (i8 < 0) {
                    iArr8[i5] = iArr6[0];
                } else if (i8 >= iArr6.length) {
                    iArr8[i5] = iArr6[iArr6.length - 1];
                } else {
                    iArr8[i5] = iArr6[i8];
                }
                i5++;
                iArr3 = iArr7;
                fArr = fArr5;
                fArr2 = fArr4;
                iArr5 = iArr8;
            }
            fArr4 = fArr2;
            iArr8 = iArr5;
            iArr7 = iArr3;
            i4++;
            fArr = fArr;
            i = 0;
        }
    }

    public void a(cw[] cwVarArr, cw[] cwVarArr2) {
        float[][] fArr = new float[3][];
        float[][] fArr2 = new float[3][];
        int i = cwVarArr[0].d;
        int i2 = cwVarArr[0].c;
        if (this.i == null || this.i[0].length < i2 * i) {
            this.i = (float[][]) Array.newInstance(float.class, new int[]{3, i2 * i});
        }
        i = 0;
        while (i < 3) {
            fArr[i] = (float[]) cwVarArr[i].b();
            fArr2[i] = (float[]) cwVarArr2[i].b();
            if (fArr2[i] == null || fArr2[i].length < fArr[i].length) {
                fArr2[i] = new float[fArr[i].length];
                cwVarArr2[i].a(fArr2[i]);
            }
            a(cwVarArr[i], this.i[i], (float) this.e[i], this.c[i]);
            i++;
        }
        int[] iArr = this.d.e;
        int i3 = 0;
        i = 0;
        while (i3 < cwVarArr[0].d) {
            float[][] fArr3;
            i2 = cwVarArr[0].c + i;
            while (i < i2) {
                int i4 = i3;
                fArr3 = fArr2;
                int i5 = (int) ((((this.b[0] * ((double) this.i[0][i])) + (this.b[1] * ((double) this.i[1][i]))) + (this.b[2] * ((double) this.i[2][i]))) + 0.5d);
                if (i5 < 0) {
                    fArr3[0][i] = (float) iArr[0];
                } else if (i5 >= iArr.length) {
                    fArr3[0][i] = (float) iArr[iArr.length - 1];
                } else {
                    fArr3[0][i] = (float) iArr[i5];
                }
                int i6 = (int) ((((this.b[3] * ((double) this.i[0][i])) + (this.b[4] * ((double) this.i[1][i]))) + (this.b[5] * ((double) this.i[2][i]))) + 0.5d);
                if (i6 < 0) {
                    fArr3[1][i] = (float) iArr[0];
                } else if (i6 >= iArr.length) {
                    fArr3[1][i] = (float) iArr[iArr.length - 1];
                } else {
                    fArr3[1][i] = (float) iArr[i6];
                }
                i6 = (int) ((((this.b[6] * ((double) this.i[0][i])) + (this.b[7] * ((double) this.i[1][i]))) + (this.b[8] * ((double) this.i[2][i]))) + 0.5d);
                if (i6 < 0) {
                    fArr3[2][i] = (float) iArr[0];
                } else if (i6 >= iArr.length) {
                    fArr3[2][i] = (float) iArr[iArr.length - 1];
                } else {
                    fArr3[2][i] = (float) iArr[i6];
                }
                i++;
                i3 = i4;
                fArr2 = fArr3;
            }
            fArr3 = fArr2;
            i3++;
        }
    }

    private static void a(cx cxVar, float[] fArr, int i, ax axVar) {
        int[] iArr = (int[]) cxVar.b();
        float[] fArr2 = axVar.d;
        int i2 = 0;
        for (int i3 = cxVar.b; i3 < cxVar.b + cxVar.d; i3++) {
            int i4 = cxVar.a;
            while (i4 < cxVar.a + cxVar.c) {
                int i5 = (cxVar.e + ((i3 - cxVar.b) * cxVar.f)) + (i4 - cxVar.a);
                if (iArr[i5] > i) {
                    i5 = i;
                } else if (iArr[i5] < 0) {
                    i5 = 0;
                } else {
                    i5 = iArr[i5];
                }
                int i6 = i2 + 1;
                fArr[i2] = fArr2[i5];
                i4++;
                i2 = i6;
            }
        }
    }

    private static void a(cw cwVar, float[] fArr, float f, ax axVar) {
        float[] fArr2 = (float[]) cwVar.b();
        float[] fArr3 = axVar.d;
        int i = 0;
        for (int i2 = cwVar.b; i2 < cwVar.b + cwVar.d; i2++) {
            int i3 = cwVar.a;
            while (i3 < cwVar.a + cwVar.c) {
                float f2;
                int i4 = (cwVar.e + ((i2 - cwVar.b) * cwVar.f)) + (i3 - cwVar.a);
                if (fArr2[i4] > f) {
                    f2 = f;
                } else if (fArr2[i4] < 0.0f) {
                    f2 = 0.0f;
                } else {
                    f2 = fArr2[i4];
                }
                int i5 = i + 1;
                fArr[i] = fArr3[(int) f2];
                i3++;
                i = i5;
            }
        }
    }
}
