package jumio.nv.nfc;

/* compiled from: ImgDataConverter */
public class da extends cz implements cs {
    private cv a = new cx();
    private cs b;
    private int c;

    public da(cs csVar, int i) {
        super(csVar);
        this.b = csVar;
        this.c = i;
    }

    public int a(int i) {
        return this.c;
    }

    public cv a(cv cvVar, int i) {
        return a(cvVar, i, false);
    }

    public final cv b(cv cvVar, int i) {
        return a(cvVar, i, true);
    }

    private cv a(cv cvVar, int i, boolean z) {
        cv cvVar2;
        int a = cvVar.a();
        if (a == this.a.a()) {
            cvVar2 = cvVar;
        } else {
            cvVar2 = this.a;
            cvVar2.a = cvVar.a;
            cvVar2.b = cvVar.b;
            cvVar2.c = cvVar.c;
            cvVar2.d = cvVar.d;
        }
        if (z) {
            this.a = this.b.b(cvVar2, i);
        } else {
            this.a = this.b.a(cvVar2, i);
        }
        if (this.a.a() == a) {
            return this.a;
        }
        int i2 = this.a.c;
        int i3 = this.a.d;
        float[] fArr;
        int i4;
        switch (a) {
            case 3:
                int[] iArr = (int[]) cvVar.b();
                if (iArr == null || iArr.length < i2 * i3) {
                    iArr = new int[(i2 * i3)];
                    cvVar.a(iArr);
                }
                cvVar.f = this.a.c;
                cvVar.e = 0;
                cvVar.g = this.a.g;
                fArr = (float[]) this.a.b();
                int i5;
                if (this.c == 0) {
                    int i6 = i3 - 1;
                    i3 = (i3 * i2) - 1;
                    i5 = ((this.a.e + (this.a.f * i6)) + i2) - 1;
                    while (i6 >= 0) {
                        i4 = i3 - i2;
                        while (i3 > i4) {
                            if (fArr[i5] > 0.0f) {
                                iArr[i3] = (int) (fArr[i5] + 0.5f);
                            } else {
                                iArr[i3] = (int) (fArr[i5] - 0.5f);
                            }
                            i3--;
                            i5--;
                        }
                        i5 -= this.a.f - i2;
                        i6--;
                    }
                    break;
                }
                float f = (float) (1 << this.c);
                i5 = i3 - 1;
                i3 = (i3 * i2) - 1;
                int i7 = ((this.a.e + (this.a.f * i5)) + i2) - 1;
                while (i5 >= 0) {
                    i4 = i3 - i2;
                    while (i3 > i4) {
                        if (fArr[i7] > 0.0f) {
                            iArr[i3] = (int) ((fArr[i7] * f) + 0.5f);
                        } else {
                            iArr[i3] = (int) ((fArr[i7] * f) - 0.5f);
                        }
                        i3--;
                        i7--;
                    }
                    i7 -= this.a.f - i2;
                    i5--;
                }
                break;
            case 4:
                fArr = (float[]) cvVar.b();
                if (fArr == null || fArr.length < i2 * i3) {
                    fArr = new float[(i2 * i3)];
                    cvVar.a(fArr);
                }
                cvVar.f = this.a.c;
                cvVar.e = 0;
                cvVar.g = this.a.g;
                int[] iArr2 = (int[]) this.a.b();
                this.c = this.b.a(i);
                int i8;
                if (this.c == 0) {
                    i = i3 - 1;
                    i3 = (i3 * i2) - 1;
                    i8 = ((this.a.e + (this.a.f * i)) + i2) - 1;
                    while (i >= 0) {
                        i4 = i3 - i2;
                        while (i3 > i4) {
                            fArr[i3] = (float) iArr2[i8];
                            i3--;
                            i8--;
                        }
                        i8 -= this.a.f - i2;
                        i--;
                    }
                    break;
                }
                float f2 = 1.0f / ((float) (1 << this.c));
                i8 = i3 - 1;
                i3 = (i3 * i2) - 1;
                int i9 = ((this.a.e + (this.a.f * i8)) + i2) - 1;
                while (i8 >= 0) {
                    i4 = i3 - i2;
                    while (i3 > i4) {
                        fArr[i3] = ((float) iArr2[i9]) * f2;
                        i3--;
                        i9--;
                    }
                    i9 -= this.a.f - i2;
                    i8--;
                }
                break;
            default:
                throw new IllegalArgumentException("Only integer and float data are supported by JJ2000");
        }
        return cvVar;
    }
}
