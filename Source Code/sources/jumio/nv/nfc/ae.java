package jumio.nv.nfc;

/* compiled from: SYccColorSpaceMapper */
public class ae extends aa {
    protected static float A = 0.0f;
    protected static float s = 1.0f;
    protected static float t = 0.0f;
    protected static float u = 1.402f;
    protected static float v = 1.0f;
    protected static float w = -0.34413f;
    protected static float x = -0.71414f;
    protected static float y = 1.0f;
    protected static float z = 1.772f;

    public static cs a(cs csVar, y yVar) {
        return new ae(csVar, yVar);
    }

    protected ae(cs csVar, y yVar) {
        super(csVar, yVar);
        h();
    }

    private void h() {
        if (this.o != 1 && this.o != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SYccColorSpaceMapper: ycc transformation _not_ applied to ");
            stringBuilder.append(this.o);
            stringBuilder.append(" component image");
            throw new z(stringBuilder.toString());
        }
    }

    public cv a(cv cvVar, int i) {
        int a = cvVar.a();
        for (int i2 = 0; i2 < this.o; i2++) {
            aa.a(this.d[i2], cvVar);
            aa.a(this.e[i2], cvVar);
            aa.a(this.b[i2], cvVar);
            aa.a(this.c[i2], cvVar);
            this.b[i2] = (cx) this.p.b(this.b[i2], i2);
        }
        if (a == 3) {
            if (this.o == 1) {
                this.d[i] = this.b[i];
            } else {
                this.d = a(this.b);
            }
            cvVar.g = this.b[i].g;
            cvVar.a(this.d[i].b());
        }
        if (a == 4) {
            if (this.o == 1) {
                this.e[i] = this.c[i];
            } else {
                this.e = a(this.c);
            }
            cvVar.g = this.c[i].g;
            cvVar.a(this.e[i].b());
        }
        cvVar.e = 0;
        cvVar.f = cvVar.c;
        return cvVar;
    }

    public cv b(cv cvVar, int i) {
        return a(cvVar, i);
    }

    private static cw[] a(cw[] cwVarArr) {
        if (cwVarArr.length != 3) {
            throw new IllegalArgumentException("bad input array size");
        }
        int i = cwVarArr[0].d * cwVarArr[0].c;
        cw[] cwVarArr2 = new cw[3];
        float[][] fArr = new float[3][];
        float[][] fArr2 = new float[3][];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr2[i2] = cwVarArr[i2].c();
            cwVarArr2[i2] = new cw();
            aa.a(cwVarArr2[i2], cwVarArr[i2]);
            cwVarArr2[i2].e = cwVarArr[i2].e;
            fArr[i2] = new float[i];
            cwVarArr2[i2].a(fArr[i2]);
        }
        for (int i3 = 0; i3 < i; i3++) {
            fArr[0][i3] = ((s * fArr2[0][cwVarArr[0].e + i3]) + (t * fArr2[1][cwVarArr[1].e + i3])) + (u * fArr2[2][cwVarArr[2].e + i3]);
            fArr[1][i3] = ((v * fArr2[0][cwVarArr[0].e + i3]) + (w * fArr2[1][cwVarArr[1].e + i3])) + (x * fArr2[2][cwVarArr[2].e + i3]);
            fArr[2][i3] = ((y * fArr2[0][cwVarArr[0].e + i3]) + (z * fArr2[1][cwVarArr[1].e + i3])) + (A * fArr2[2][cwVarArr[2].e + i3]);
        }
        return cwVarArr2;
    }

    private static cx[] a(cx[] cxVarArr) {
        if (cxVarArr.length != 3) {
            throw new IllegalArgumentException("bad input array size");
        }
        int i = cxVarArr[0].d * cxVarArr[0].c;
        cx[] cxVarArr2 = new cx[3];
        int[][] iArr = new int[3][];
        int[][] iArr2 = new int[3][];
        for (int i2 = 0; i2 < 3; i2++) {
            iArr2[i2] = cxVarArr[i2].c();
            cxVarArr2[i2] = new cx();
            aa.a(cxVarArr2[i2], cxVarArr[i2]);
            cxVarArr2[i2].e = cxVarArr[i2].e;
            iArr[i2] = new int[i];
            cxVarArr2[i2].a(iArr[i2]);
        }
        for (int i3 = 0; i3 < i; i3++) {
            iArr[0][i3] = (int) (((s * ((float) iArr2[0][cxVarArr[0].e + i3])) + (t * ((float) iArr2[1][cxVarArr[1].e + i3]))) + (u * ((float) iArr2[2][cxVarArr[2].e + i3])));
            iArr[1][i3] = (int) (((v * ((float) iArr2[0][cxVarArr[0].e + i3])) + (w * ((float) iArr2[1][cxVarArr[1].e + i3]))) + (x * ((float) iArr2[2][cxVarArr[2].e + i3])));
            iArr[2][i3] = (int) (((y * ((float) iArr2[0][cxVarArr[0].e + i3])) + (z * ((float) iArr2[1][cxVarArr[1].e + i3]))) + (A * ((float) iArr2[2][cxVarArr[2].e + i3])));
        }
        return cxVarArr2;
    }
}
