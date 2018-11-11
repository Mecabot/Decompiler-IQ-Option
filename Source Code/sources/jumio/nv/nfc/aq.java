package jumio.nv.nfc;

/* compiled from: ICCProfiler */
public class aq extends aa {
    protected static final String s = System.getProperty("line.separator");
    at t = null;
    an u = null;
    private cx[] v;
    private cw[] w;
    private Object x = null;
    private at y = null;

    public static cs a(cs csVar, y yVar) {
        return new aq(csVar, yVar);
    }

    protected aq(cs csVar, y yVar) {
        super(csVar, yVar);
        h();
        this.y = a(yVar);
        if (this.o == 1) {
            this.x = new bd(this.y, this.k[0], this.j[0]);
        } else {
            this.x = new bb(this.y, this.k, this.j);
        }
    }

    private void h() {
        this.v = new cx[this.o];
        this.w = new cw[this.o];
        for (int i = 0; i < this.o; i++) {
            this.v[i] = new cx();
            this.w[i] = new cw();
        }
    }

    private at a(y yVar) {
        int i = this.o;
        if (i == 1) {
            this.u = am.a(yVar);
            this.t = this.u.a();
            if (this.t.a() != 0) {
                throw new IllegalArgumentException("wrong ICCProfile type for image");
            }
        } else if (i != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("illegal number of components (");
            stringBuilder.append(this.o);
            stringBuilder.append(") in image");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            this.u = al.a(yVar);
            this.t = this.u.a();
            if (this.t.a() != 1) {
                throw new IllegalArgumentException("wrong ICCProfile type for image");
            }
        }
        return this.t;
    }

    public cv a(cv cvVar, int i) {
        cv cvVar2 = cvVar;
        int i2 = i;
        try {
            if (this.o != 1 && this.o != 3) {
                return this.p.a(cvVar2, i2);
            }
            int a = cvVar.a();
            for (int i3 = 0; i3 < this.o; i3++) {
                int a2 = this.p.a(i3);
                int i4 = this.j[i3];
                int i5 = this.k[i3];
                int i6;
                int i7;
                int i8;
                switch (a) {
                    case 3:
                        aa.a(this.d[i3], cvVar2);
                        aa.a(this.v[i3], cvVar2);
                        aa.a(this.b[i3], cvVar2);
                        aa.a(cvVar);
                        this.i[i3] = (int[]) this.d[i3].b();
                        this.b[i3] = (cx) this.p.b(this.b[i3], i3);
                        this.f[i3] = this.b[i3].c();
                        for (int i9 = 0; i9 < cvVar2.d; i9++) {
                            int i10 = this.b[i3].e + (this.b[i3].f * i9);
                            i6 = this.b[i3].c + i10;
                            i7 = cvVar2.e + (cvVar2.f * i9);
                            i8 = cvVar2.c;
                            while (i10 < i6) {
                                i8 = (this.f[i3][i10] >> a2) + i4;
                                int[] iArr = this.i[i3];
                                if (i8 < 0) {
                                    i8 = 0;
                                } else if (i8 > i5) {
                                    i8 = i5;
                                }
                                iArr[i7] = i8;
                                i10++;
                                i7++;
                            }
                        }
                        break;
                    case 4:
                        aa.a(this.e[i3], cvVar2);
                        aa.a(this.w[i3], cvVar2);
                        aa.a(this.c[i3], cvVar2);
                        aa.a(cvVar);
                        this.h[i3] = (float[]) this.e[i3].b();
                        this.c[i3] = (cw) this.p.b(this.c[i3], i3);
                        this.g[i3] = this.c[i3].c();
                        for (i6 = 0; i6 < cvVar2.d; i6++) {
                            i7 = this.c[i3].e + (this.c[i3].f * i6);
                            i8 = this.c[i3].c + i7;
                            int i11 = cvVar2.e + (cvVar2.f * i6);
                            int i12 = cvVar2.c;
                            while (i7 < i8) {
                                float f = (this.g[i3][i7] / ((float) (1 << a2))) + ((float) i4);
                                float[] fArr = this.h[i3];
                                if (f < 0.0f) {
                                    f = 0.0f;
                                } else {
                                    float f2 = (float) i5;
                                    if (f > f2) {
                                        f = f2;
                                    }
                                }
                                fArr[i11] = f;
                                i7++;
                                i11++;
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid source datablock type");
                }
            }
            switch (a) {
                case 3:
                    if (this.o == 1) {
                        ((bd) this.x).a(this.d[i2], this.v[i2]);
                    } else {
                        ((bb) this.x).a(this.d, this.v);
                    }
                    cvVar2.g = this.b[i2].g;
                    cvVar2.a(this.v[i2].b());
                    break;
                case 4:
                    if (this.o == 1) {
                        ((bd) this.x).a(this.e[i2], this.w[i2]);
                    } else {
                        ((bb) this.x).a(this.e, this.w);
                    }
                    cvVar2.g = this.c[i2].g;
                    cvVar2.a(this.w[i2].b());
                    break;
                default:
                    throw new IllegalArgumentException("invalid source datablock type");
            }
            cvVar2.e = 0;
            cvVar2.f = cvVar2.c;
            return cvVar2;
        } catch (ba unused) {
            return null;
        } catch (bc unused2) {
            return null;
        }
    }

    public cv b(cv cvVar, int i) {
        return a(cvVar, i);
    }
}
