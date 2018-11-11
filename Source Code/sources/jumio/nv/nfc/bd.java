package jumio.nv.nfc;

/* compiled from: MonochromeTransformTosRGB */
public class bd {
    private static final String a = System.getProperty("line.separator");
    private short[] b = null;
    private int c;
    private ax d;

    public bd(at atVar, int i, int i2) {
        int i3 = 0;
        this.c = 0;
        this.d = null;
        if (atVar.a() != 0) {
            throw new IllegalArgumentException("MonochromeTransformTosRGB: wrong type ICCProfile supplied");
        }
        this.c = i;
        int i4 = i + 1;
        this.b = new short[i4];
        this.d = ax.a(atVar.b[0], i4);
        while (i3 <= i && ((double) this.d.d[i3]) <= 0.0031308d) {
            this.b[i3] = (short) ((int) (Math.floor((((double) this.d.d[i3]) * 3294.6d) + 0.5d) - ((double) i2)));
            i3++;
        }
        while (i3 <= i) {
            this.b[i3] = (short) ((int) (Math.floor(((Math.pow((double) this.d.d[i3], 0.4166666666666667d) * 269.025d) - 14.025d) + 0.5d) - ((double) i2)));
            i3++;
        }
    }

    public void a(cx cxVar, cx cxVar2) {
        int[] iArr = (int[]) cxVar.b();
        int[] iArr2 = (int[]) cxVar2.b();
        if (iArr2 == null || iArr2.length < iArr.length) {
            iArr2 = new int[iArr.length];
            cxVar2.a(iArr2);
        }
        cxVar2.b = cxVar.b;
        cxVar2.a = cxVar.a;
        cxVar2.d = cxVar.d;
        cxVar2.c = cxVar.c;
        cxVar2.e = cxVar.e;
        cxVar2.f = cxVar.f;
        int i = cxVar.e;
        for (int i2 = 0; i2 < cxVar.d * cxVar.c; i2++) {
            int i3 = iArr[i2];
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > this.c) {
                i3 = this.c;
            }
            iArr2[i2] = this.b[i3];
        }
    }

    public void a(cw cwVar, cw cwVar2) {
        float[] fArr = (float[]) cwVar.b();
        float[] fArr2 = (float[]) cwVar2.b();
        if (fArr2 == null || fArr2.length < fArr.length) {
            fArr2 = new float[fArr.length];
            cwVar2.a(fArr2);
            cwVar2.b = cwVar.b;
            cwVar2.a = cwVar.a;
            cwVar2.d = cwVar.d;
            cwVar2.c = cwVar.c;
            cwVar2.e = cwVar.e;
            cwVar2.f = cwVar.f;
        }
        int i = cwVar.e;
        for (int i2 = 0; i2 < cwVar.d * cwVar.c; i2++) {
            int i3 = (int) fArr[i2];
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > this.c) {
                i3 = this.c;
            }
            fArr2[i2] = (float) this.b[i3];
        }
    }
}
