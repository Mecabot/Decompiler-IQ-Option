package jumio.nv.nfc;

/* compiled from: Subband */
public abstract class dv {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public cu e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public abstract dv a();

    protected abstract dv a(dw dwVar, dw dwVar2);

    public abstract dv b();

    public abstract dv c();

    public abstract dv d();

    public abstract dv e();

    protected void f() {
        dv b = b();
        dv c = c();
        dv d = d();
        dv e = e();
        b.c = this.c + 1;
        b.h = (this.h + 1) >> 1;
        b.i = (this.i + 1) >> 1;
        b.j = this.j;
        b.k = this.k;
        b.l = (((this.h + this.l) + 1) >> 1) - b.h;
        b.m = (((this.i + this.m) + 1) >> 1) - b.i;
        b.d = this.b == 0 ? this.d - 1 : this.d;
        b.f = this.f;
        b.g = this.g << 2;
        c.b = 1;
        c.c = b.c;
        c.h = this.h >> 1;
        c.i = b.i;
        c.j = this.j + b.l;
        c.k = this.k;
        c.l = ((this.h + this.l) >> 1) - c.h;
        c.m = b.m;
        c.d = this.d;
        c.f = this.f + 1;
        c.g = (this.g << 2) + 1;
        d.b = 2;
        d.c = b.c;
        d.h = b.h;
        d.i = this.i >> 1;
        d.j = this.j;
        d.k = this.k + b.m;
        d.l = b.l;
        d.m = ((this.i + this.m) >> 1) - d.i;
        d.d = this.d;
        d.f = this.f + 1;
        d.g = (this.g << 2) + 2;
        e.b = 3;
        e.c = b.c;
        e.h = c.h;
        e.i = d.i;
        e.j = c.j;
        e.k = d.k;
        e.l = c.l;
        e.m = d.m;
        e.d = this.d;
        e.f = this.f + 2;
        e.g = (this.g << 2) + 3;
    }

    public dv() {
        this.e = null;
        this.g = 0;
    }

    public dv(int i, int i2, int i3, int i4, int i5, dw[] dwVarArr, dw[] dwVarArr2) {
        this.e = null;
        int i6 = 0;
        this.g = 0;
        this.l = i;
        this.m = i2;
        this.h = i3;
        this.i = i4;
        this.d = i5;
        dv dvVar = this;
        while (i6 < i5) {
            dvVar = dvVar.a(dwVarArr[(dvVar.d <= dwVarArr.length ? dvVar.d : dwVarArr.length) - 1], dwVarArr2[(dvVar.d <= dwVarArr2.length ? dvVar.d : dwVarArr2.length) - 1]);
            i6++;
        }
    }

    public dv a(int i, int i2) {
        if (i > this.d || i < 0) {
            throw new IllegalArgumentException("Resolution level index out of range");
        } else if (i == this.d && i2 == this.g) {
            return this;
        } else {
            dv a = this.g != 0 ? a() : this;
            while (a.d > i) {
                a = a.b();
            }
            while (a.d < i) {
                a = a.a();
            }
            switch (i2) {
                case 1:
                    return a.c();
                case 2:
                    return a.d();
                case 3:
                    return a.e();
                default:
                    return a;
            }
        }
    }
}
