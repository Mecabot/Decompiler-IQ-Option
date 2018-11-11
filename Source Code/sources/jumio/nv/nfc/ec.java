package jumio.nv.nfc;

/* compiled from: InvWTFull */
public class ec extends ed {
    private int e = 0;
    private dy f;
    private int g;
    private cv[] h;
    private int[] i;

    public ec(dy dyVar, cg cgVar) {
        super(dyVar, cgVar);
        this.f = dyVar;
        int c = dyVar.c();
        this.h = new cv[c];
        this.i = new int[c];
    }

    public int b(int i) {
        return this.f.g(i);
    }

    public int a(int i) {
        return this.f.h(i);
    }

    public final cv b(cv cvVar, int i) {
        int e = e();
        if (this.f.e(e, i).g() == null) {
            this.g = 3;
        } else {
            this.g = this.f.e(e, i).g().a();
        }
        if (this.h[i] == null) {
            switch (this.g) {
                case 3:
                    this.h[i] = new cx(0, 0, b(e, i), a(e, i));
                    break;
                case 4:
                    this.h[i] = new cw(0, 0, b(e, i), a(e, i));
                    break;
            }
            b(this.h[i], this.f.e(e, i), i);
        }
        cv cxVar = cvVar.a() != this.g ? this.g == 3 ? new cx(cvVar.a, cvVar.b, cvVar.c, cvVar.d) : new cw(cvVar.a, cvVar.b, cvVar.c, cvVar.d) : cvVar;
        cxVar.a(this.h[i].b());
        cxVar.e = (this.h[i].c * cxVar.b) + cxVar.a;
        cxVar.f = this.h[i].c;
        cxVar.g = false;
        return cxVar;
    }

    public cv a(cv cvVar, int i) {
        Object obj;
        switch (cvVar.a()) {
            case 3:
                obj = (int[]) cvVar.b();
                if (obj == null || obj.length < cvVar.c * cvVar.d) {
                    obj = new int[(cvVar.c * cvVar.d)];
                    break;
                }
            case 4:
                obj = (float[]) cvVar.b();
                if (obj == null || obj.length < cvVar.c * cvVar.d) {
                    obj = new float[(cvVar.c * cvVar.d)];
                    break;
                }
            default:
                obj = null;
                break;
        }
        cvVar = b(cvVar, i);
        cvVar.a(obj);
        cvVar.e = 0;
        cvVar.f = cvVar.c;
        return cvVar;
    }

    private void a(cv cvVar, eg egVar, int i) {
        cv cvVar2 = cvVar;
        eg egVar2 = egVar;
        if (egVar2.l != 0 && egVar2.m != 0) {
            int i2;
            int i3;
            int i4;
            Object obj;
            int i5;
            int i6;
            int i7;
            Object b = cvVar.b();
            int i8 = egVar2.j;
            int i9 = egVar2.k;
            int i10 = egVar2.l;
            int i11 = egVar2.m;
            Object obj2 = null;
            switch (egVar.g().a()) {
                case 3:
                    obj2 = new int[(i10 >= i11 ? i10 : i11)];
                    break;
                case 4:
                    obj2 = new float[(i10 >= i11 ? i10 : i11)];
                    break;
            }
            Object obj3 = obj2;
            int i12 = (((i9 - cvVar2.b) * cvVar2.c) + i8) - cvVar2.a;
            int i13 = 0;
            Object obj4;
            int i14;
            if (egVar2.h % 2 == 0) {
                int i15 = i12;
                i2 = 0;
                while (i2 < i11) {
                    System.arraycopy(b, i15, obj3, i13, i10);
                    i3 = (i10 + 1) / 2;
                    int i16 = i15;
                    i4 = i2;
                    obj4 = obj3;
                    int i17 = i11;
                    i14 = i10;
                    i3 = i9;
                    egVar2.p.a(obj3, 0, i3, 1, obj3, i3, i10 / 2, 1, b, i16, 1);
                    i2 = i4 + 1;
                    i15 = i16 + cvVar2.c;
                    i9 = i3;
                    obj3 = obj4;
                    i11 = i17;
                    i10 = i14;
                    i13 = 0;
                }
                i3 = i9;
                obj = obj3;
                i5 = i11;
                i6 = i10;
            } else {
                obj4 = obj3;
                i14 = i10;
                i3 = i9;
                i9 = i11;
                i10 = 0;
                i11 = i12;
                while (i10 < i9) {
                    Object obj5 = obj4;
                    int i18 = i14;
                    System.arraycopy(b, i11, obj5, 0, i18);
                    int i19 = i18 / 2;
                    i2 = i19;
                    obj = obj5;
                    i6 = i18;
                    i7 = i11;
                    int i20 = i10;
                    i5 = i9;
                    egVar2.p.b(obj5, 0, i19, 1, obj5, i2, (i18 + 1) / 2, 1, b, i7, 1);
                    i10 = i20 + 1;
                    i11 = i7 + cvVar2.c;
                    obj4 = obj;
                    i9 = i5;
                    i14 = i6;
                }
                i5 = i9;
                obj = obj4;
                i6 = i14;
            }
            i9 = (((i3 - cvVar2.b) * cvVar2.c) + i8) - cvVar2.a;
            Object obj6;
            int i21;
            switch (egVar.h().a()) {
                case 3:
                    obj6 = b;
                    i21 = i6;
                    int[] iArr = (int[]) obj6;
                    int[] iArr2 = (int[]) obj;
                    if (egVar2.i % 2 != 0) {
                        i7 = i9;
                        i9 = 0;
                        while (i9 < i21) {
                            i11 = i5 - 1;
                            i12 = i7 + (cvVar2.c * i11);
                            while (i11 >= 0) {
                                iArr2[i11] = iArr[i12];
                                i11--;
                                i12 -= cvVar2.c;
                            }
                            i2 = i5 / 2;
                            i4 = i9;
                            egVar2.q.b(obj, 0, i2, 1, obj, i2, (i5 + 1) / 2, 1, obj6, i7, cvVar2.c);
                            i9 = i4 + 1;
                            i7++;
                        }
                        break;
                    }
                    i7 = i9;
                    i9 = 0;
                    while (i9 < i21) {
                        i11 = i5 - 1;
                        i12 = i7 + (cvVar2.c * i11);
                        while (i11 >= 0) {
                            iArr2[i11] = iArr[i12];
                            i11--;
                            i12 -= cvVar2.c;
                        }
                        i2 = (i5 + 1) / 2;
                        i4 = i9;
                        egVar2.q.a(obj, 0, i2, 1, obj, i2, i5 / 2, 1, obj6, i7, cvVar2.c);
                        i9 = i4 + 1;
                        i7++;
                    }
                    break;
                case 4:
                    float[] fArr = (float[]) b;
                    float[] fArr2 = (float[]) obj;
                    if (egVar2.i % 2 != 0) {
                        obj6 = b;
                        i21 = i6;
                        i7 = i9;
                        i9 = 0;
                        while (i9 < i21) {
                            i11 = i5 - 1;
                            i12 = i7 + (cvVar2.c * i11);
                            while (i11 >= 0) {
                                fArr2[i11] = fArr[i12];
                                i11--;
                                i12 -= cvVar2.c;
                            }
                            i2 = i5 / 2;
                            i4 = i9;
                            egVar2.q.b(obj, 0, i2, 1, obj, i2, (i5 + 1) / 2, 1, obj6, i7, cvVar2.c);
                            i9 = i4 + 1;
                            i7++;
                        }
                        break;
                    }
                    i7 = i9;
                    i9 = i6;
                    i10 = 0;
                    while (i10 < i9) {
                        i11 = i5 - 1;
                        i12 = i7 + (cvVar2.c * i11);
                        while (i11 >= 0) {
                            fArr2[i11] = fArr[i12];
                            i11--;
                            i12 -= cvVar2.c;
                        }
                        i2 = (i5 + 1) / 2;
                        i4 = i10;
                        obj6 = b;
                        i21 = i9;
                        egVar2.q.a(obj, 0, i2, 1, obj, i2, i5 / 2, 1, b, i7, cvVar2.c);
                        i10 = i4 + 1;
                        i7++;
                        i9 = i21;
                        b = obj6;
                    }
                    break;
            }
        }
    }

    private void b(cv cvVar, eg egVar, int i) {
        if (egVar.a) {
            if (egVar.a) {
                b(cvVar, (eg) egVar.b(), i);
                if (egVar.d <= (this.c - this.d) + this.i[i]) {
                    b(cvVar, (eg) egVar.c(), i);
                    b(cvVar, (eg) egVar.d(), i);
                    b(cvVar, (eg) egVar.e(), i);
                    a(cvVar, egVar, i);
                }
            }
        } else if (egVar.l != 0 && egVar.m != 0) {
            cv cxVar;
            if (this.g == 3) {
                cxVar = new cx();
            } else {
                cxVar = new cw();
            }
            cu cuVar = egVar.e;
            Object b = cvVar.b();
            cv cvVar2 = cxVar;
            int i2 = 0;
            while (i2 < cuVar.b) {
                cv cvVar3 = cvVar2;
                for (int i3 = 0; i3 < cuVar.a; i3++) {
                    cvVar3 = this.f.a(i, i2, i3, egVar, cvVar3);
                    Object b2 = cvVar3.b();
                    for (int i4 = cvVar3.d - 1; i4 >= 0; i4--) {
                        System.arraycopy(b2, cvVar3.e + (cvVar3.f * i4), b, ((cvVar3.b + i4) * cvVar.c) + cvVar3.a, cvVar3.c);
                    }
                }
                i2++;
                cvVar2 = cvVar3;
            }
        }
    }

    public void c(int i, int i2) {
        int i3;
        super.c(i, i2);
        i = this.f.c();
        i2 = this.f.d();
        for (i3 = 0; i3 < i; i3++) {
            this.i[i3] = this.f.e(i2, i3).d;
        }
        if (this.h != null) {
            for (i3 = this.h.length - 1; i3 >= 0; i3--) {
                this.h[i3] = null;
            }
        }
        this.e = 0;
        for (i3 = 0; i3 < i; i3++) {
            eg e = this.f.e(i2, i3);
            for (int i4 = 0; i4 <= (this.c - this.d) + e.d; i4++) {
                eg egVar;
                if (i4 == 0) {
                    egVar = (eg) e.a(0, 0);
                    if (egVar != null) {
                        this.e += egVar.e.a * egVar.e.b;
                    }
                } else {
                    egVar = (eg) e.a(i4, 1);
                    if (egVar != null) {
                        this.e += egVar.e.a * egVar.e.b;
                    }
                    egVar = (eg) e.a(i4, 2);
                    if (egVar != null) {
                        this.e += egVar.e.a * egVar.e.b;
                    }
                    egVar = (eg) e.a(i4, 3);
                    if (egVar != null) {
                        this.e += egVar.e.a * egVar.e.b;
                    }
                }
            }
        }
    }
}
