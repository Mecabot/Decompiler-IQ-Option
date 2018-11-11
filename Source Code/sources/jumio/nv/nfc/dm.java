package jumio.nv.nfc;

/* compiled from: StdDequantizer */
public class dm extends dk {
    private di f;
    private dh g;
    private dg h;
    private cx i;
    private int j;

    public int h(int i) {
        return 0;
    }

    public dm(dj djVar, int[] iArr, cg cgVar) {
        super(djVar, iArr, cgVar);
        if (iArr.length != djVar.c()) {
            throw new IllegalArgumentException("Invalid rb argument");
        }
        this.g = cgVar.d;
        this.f = cgVar.c;
        this.h = cgVar.e;
    }

    public final cv a(int i, int i2, int i3, eg egVar, cv cvVar) {
        int i4 = i;
        eg egVar2 = egVar;
        boolean d = this.f.d(this.d, i4);
        boolean c = this.f.c(this.d, i4);
        dn dnVar = (dn) this.g.a(this.d, i4);
        ((Integer) this.h.a(this.d, i4)).intValue();
        this.j = cvVar.a();
        if (!d || this.j == 3) {
            float[] fArr;
            cv cvVar2;
            int[] iArr;
            int[] iArr2 = null;
            switch (this.j) {
                case 3:
                    cv a = this.a.a(i4, i2, i3, egVar2, cvVar);
                    fArr = null;
                    iArr2 = (int[]) a.b();
                    cvVar2 = a;
                    iArr = fArr;
                    break;
                case 4:
                    this.i = (cx) this.a.b(i4, i2, i3, egVar2, this.i);
                    iArr = this.i.c();
                    cvVar2 = cvVar == null ? new cw() : cvVar;
                    cvVar2.a = this.i.a;
                    cvVar2.b = this.i.b;
                    cvVar2.c = this.i.c;
                    cvVar2.d = this.i.d;
                    cvVar2.e = 0;
                    cvVar2.f = cvVar2.c;
                    cvVar2.g = this.i.g;
                    fArr = (float[]) cvVar2.b();
                    if (fArr == null || fArr.length < cvVar2.c * cvVar2.d) {
                        fArr = new float[(cvVar2.c * cvVar2.d)];
                        cvVar2.a(fArr);
                        break;
                    }
                default:
                    cvVar2 = cvVar;
                    iArr = null;
                    fArr = iArr;
                    break;
            }
            int i5 = egVar2.r;
            int length;
            int i6;
            if (!d) {
                float f;
                if (c) {
                    f = dnVar.b[0][0] * ((float) (1 << (((this.b[i4] + egVar2.f) + this.a.e(d(), i4).d) - egVar2.c)));
                } else {
                    f = dnVar.b[egVar2.d][egVar2.g] * ((float) (1 << (this.b[i4] + egVar2.f)));
                }
                f /= (float) (1 << (31 - i5));
                switch (this.j) {
                    case 3:
                        for (length = iArr2.length - 1; length >= 0; length--) {
                            i6 = iArr2[length];
                            if (i6 < 0) {
                                i6 = -(i6 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                            }
                            iArr2[length] = (int) (((float) i6) * f);
                        }
                        break;
                    case 4:
                        i5 = cvVar2.c;
                        i4 = cvVar2.d;
                        int i7 = (i5 * i4) - 1;
                        i4--;
                        int i8 = ((this.i.e + (this.i.f * i4)) + i5) - 1;
                        i4 *= i5;
                        while (i7 >= 0) {
                            while (i7 >= i4) {
                                int i9 = iArr[i8];
                                if (i9 < 0) {
                                    i9 = -(i9 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                                }
                                fArr[i7] = ((float) i9) * f;
                                i8--;
                                i7--;
                            }
                            i8 -= this.i.f - i5;
                            i4 -= i5;
                        }
                        break;
                }
            }
            length = 31 - i5;
            for (i6 = iArr2.length - 1; i6 >= 0; i6--) {
                i5 = iArr2[i6];
                iArr2[i6] = i5 >= 0 ? i5 >> length : -((i5 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) >> length);
            }
            return cvVar2;
        }
        throw new IllegalArgumentException("Reversible quantizations must use int data");
    }
}
