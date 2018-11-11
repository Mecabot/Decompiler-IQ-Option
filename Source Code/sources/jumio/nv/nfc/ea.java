package jumio.nv.nfc;

/* compiled from: InvWTAdapter */
public abstract class ea implements dz {
    protected cg a;
    protected ee b;
    protected int c;
    protected int d;

    protected ea(ee eeVar, cg cgVar) {
        this.b = eeVar;
        this.a = cgVar;
        this.d = cgVar.g.a();
    }

    public void i(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Resolution level index cannot be negative.");
        }
        this.c = i;
    }

    public int c() {
        return this.b.c(this.c);
    }

    public int d() {
        return this.b.d(this.c);
    }

    public int b() {
        return this.b.c();
    }

    public int e(int i) {
        return this.b.a(i);
    }

    public int f(int i) {
        return this.b.b(i);
    }

    public int b(int i, int i2) {
        return this.b.a(i, i2, this.b.e(i, i2).d);
    }

    public int a(int i, int i2) {
        return this.b.b(i, i2, this.b.e(i, i2).d);
    }

    public int d(int i) {
        return this.b.a(i, this.a.g.a(i));
    }

    public int c(int i) {
        return this.b.b(i, this.a.g.a(i));
    }

    public void c(int i, int i2) {
        this.b.f(i, i2);
    }

    public int e() {
        return this.b.d();
    }

    public int g(int i) {
        return this.b.c(i, this.b.e(e(), i).d);
    }

    public int h(int i) {
        return this.b.d(i, this.b.e(e(), i).d);
    }

    public int f() {
        return this.b.e(this.c);
    }

    public int g() {
        return this.b.f(this.c);
    }

    public cu a(cu cuVar) {
        return this.b.b(cuVar);
    }
}
