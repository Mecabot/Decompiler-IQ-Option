package jumio.nv.nfc;

/* compiled from: PalettizedColorSpaceMapper */
public class ac extends aa {
    int[] s;
    int t = 0;
    private ak u;

    public static cs a(cs csVar, y yVar) {
        return new ac(csVar, yVar);
    }

    protected ac(cs csVar, y yVar) {
        super(csVar, yVar);
        this.u = yVar.e();
        h();
    }

    private void h() {
        if (this.o == 1 || this.o == 3) {
            int b = b();
            this.s = new int[b];
            for (int i = 0; i < b; i++) {
                this.s[i] = 1 << (b(i) - 1);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wrong number of components (");
        stringBuilder.append(this.o);
        stringBuilder.append(") for palettized image");
        throw new z(stringBuilder.toString());
    }

    public cv a(cv cvVar, int i) {
        if (this.u == null) {
            return this.p.a(cvVar, i);
        }
        if (this.o != 1) {
            return this.p.a(cvVar, i);
        }
        aa.a(cvVar);
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        switch (cvVar.a()) {
            case 3:
                aa.a(this.b[0], cvVar);
                this.b[0] = (cx) this.p.b(this.b[0], 0);
                this.f[0] = (int[]) this.b[0].b();
                int[] c = ((cx) cvVar).c();
                for (i2 = 0; i2 < cvVar.d; i2++) {
                    i3 = this.b[0].e + (this.b[0].f * i2);
                    i4 = this.b[0].c + i3;
                    i5 = cvVar.e + (cvVar.f * i2);
                    i6 = cvVar.c;
                    while (i3 < i4) {
                        c[i5] = this.u.a(i, this.f[0][i3] + this.j[0]) - this.s[i];
                        i3++;
                        i5++;
                    }
                }
                cvVar.g = this.b[0].g;
                break;
            case 4:
                aa.a(this.c[0], cvVar);
                this.c[0] = (cw) this.p.b(this.c[0], 0);
                this.g[0] = (float[]) this.c[0].b();
                float[] c2 = ((cw) cvVar).c();
                for (i2 = 0; i2 < cvVar.d; i2++) {
                    i3 = this.c[0].e + (this.c[0].f * i2);
                    i4 = this.c[0].c + i3;
                    i5 = cvVar.e + (cvVar.f * i2);
                    i6 = cvVar.c;
                    while (i3 < i4) {
                        c2[i5] = (float) (this.u.a(i, ((int) this.g[0][i3]) + this.j[0]) - this.s[i]);
                        i3++;
                        i5++;
                    }
                }
                cvVar.g = this.c[0].g;
                break;
            default:
                throw new IllegalArgumentException("invalid source datablock type");
        }
        cvVar.e = 0;
        cvVar.f = cvVar.c;
        return cvVar;
    }

    public cv b(cv cvVar, int i) {
        return a(cvVar, i);
    }

    public int b(int i) {
        if (this.u == null) {
            return this.p.b(i);
        }
        return this.u.b(i);
    }

    public int b() {
        return this.u == null ? this.p.b() : this.u.b();
    }

    public int e(int i) {
        return this.C.e(this.t);
    }

    public int f(int i) {
        return this.C.f(this.t);
    }

    public int b(int i, int i2) {
        return this.C.b(i, this.t);
    }

    public int a(int i, int i2) {
        return this.C.a(i, this.t);
    }

    public int d(int i) {
        return this.C.d(this.t);
    }

    public int c(int i) {
        return this.C.c(this.t);
    }

    public int g(int i) {
        return this.C.g(this.t);
    }

    public int h(int i) {
        return this.C.h(this.t);
    }
}
