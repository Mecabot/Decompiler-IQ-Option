package jumio.nv.nfc;

/* compiled from: BitstreamReaderAgent */
public abstract class by implements cm {
    private static final String[][] D = ((String[][]) null);
    protected int A;
    protected int B;
    protected float C;
    protected cg a;
    protected boolean[] b = null;
    protected int[] c = null;
    protected dn[] d = null;
    protected int[] e;
    protected final int f;
    protected int g;
    protected eg[] h;
    protected final int i;
    protected final int j;
    protected final int k;
    protected final int l;
    protected final int m;
    protected final int n;
    protected final int[] o;
    protected final int[] p;
    protected final int[] q;
    protected final int[] r;
    protected final int s;
    protected final int t;
    protected final int u;
    protected final int v;
    protected final int w;
    protected int x;
    protected int y;
    protected final cb z;

    protected by(cb cbVar, cg cgVar) {
        this.a = cgVar;
        this.z = cbVar;
        this.f = cbVar.i();
        this.o = new int[this.f];
        this.p = new int[this.f];
        this.q = new int[this.f];
        this.r = new int[this.f];
        this.i = cbVar.c();
        this.j = cbVar.d();
        this.k = cbVar.e();
        this.l = cbVar.f();
        cu a = cbVar.a(null);
        this.m = a.a;
        this.n = a.b;
        this.s = cbVar.g();
        this.t = cbVar.h();
        this.u = ((((this.k + this.i) - this.m) + this.s) - 1) / this.s;
        this.v = ((((this.l + this.j) - this.n) + this.t) - 1) / this.t;
        this.w = this.u * this.v;
    }

    public final int a() {
        return this.z.j();
    }

    public int b() {
        return this.z.k();
    }

    public final int c() {
        return this.f;
    }

    public final int a(int i) {
        return this.z.b(i);
    }

    public int b(int i) {
        return this.z.c(i);
    }

    public int c(int i) {
        int a = this.a.g.a();
        if (i > a) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        a = 1 << (a - i);
        return ((((this.k + this.i) + a) - 1) / a) - (((this.k + a) - 1) / a);
    }

    public int d(int i) {
        int a = this.a.g.a();
        if (i > a) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        a = 1 << (a - i);
        return ((((this.l + this.j) + a) - 1) / a) - (((this.l + a) - 1) / a);
    }

    public int e(int i) {
        int a = this.a.g.a();
        if (i > a) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        a = 1 << (a - i);
        return ((this.k + a) - 1) / a;
    }

    public int f(int i) {
        int a = this.a.g.a();
        if (i > a) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        a = 1 << (a - i);
        return ((this.l + a) - 1) / a;
    }

    public final int a(int i, int i2, int i3) {
        if (i != d()) {
            throw new Error("Asking the tile-component width of a tile different  from the current one.");
        }
        int i4;
        i = this.e[i2] - i3;
        if (this.x < this.u - 1) {
            i3 = this.m;
            i4 = (this.x + 1) * this.s;
        } else {
            i3 = this.k;
            i4 = this.i;
        }
        i = 1 << i;
        return (((((((i3 + i4) + this.z.b(i2)) - 1) / this.z.b(i2)) + i) - 1) / i) - (((this.q[i2] + i) - 1) / i);
    }

    public final int b(int i, int i2, int i3) {
        if (i != d()) {
            throw new Error("Asking the tile-component width of a tile different  from the current one.");
        }
        int i4;
        i = this.e[i2] - i3;
        if (this.y < this.v - 1) {
            i3 = this.n;
            i4 = (this.y + 1) * this.t;
        } else {
            i3 = this.l;
            i4 = this.j;
        }
        i = 1 << i;
        return (((((((i3 + i4) + this.z.c(i2)) - 1) / this.z.c(i2)) + i) - 1) / i) - (((this.r[i2] + i) - 1) / i);
    }

    public final int a(int i, int i2) {
        int a = this.a.g.a(i) - i2;
        i2 = ((this.k + this.z.b(i)) - 1) / this.z.b(i);
        int b = (((this.k + this.i) + this.z.b(i)) - 1) / this.z.b(i);
        i = 1 << a;
        return (((b + i) - 1) / i) - (((i2 + i) - 1) / i);
    }

    public final int b(int i, int i2) {
        int a = this.a.g.a(i) - i2;
        i2 = ((this.l + this.z.c(i)) - 1) / this.z.c(i);
        int c = (((this.l + this.j) + this.z.c(i)) - 1) / this.z.c(i);
        i = 1 << a;
        return (((c + i) - 1) / i) - (((i2 + i) - 1) / i);
    }

    public final cu a(cu cuVar) {
        if (cuVar == null) {
            return new cu(this.x, this.y);
        }
        cuVar.a = this.x;
        cuVar.b = this.y;
        return cuVar;
    }

    public final int d() {
        return (this.y * this.u) + this.x;
    }

    public final int c(int i, int i2) {
        int i3 = this.e[i] - i2;
        if (i3 >= 0) {
            return (int) Math.ceil(((double) ((int) Math.ceil(((double) Math.max(this.m + (this.x * this.s), this.k)) / ((double) a(i))))) / ((double) (1 << i3)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested resolution level is not available for, at least, one component in tile: ");
        stringBuilder.append(this.x);
        stringBuilder.append("x");
        stringBuilder.append(this.y);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final int d(int i, int i2) {
        int i3 = this.e[i] - i2;
        if (i3 >= 0) {
            return (int) Math.ceil(((double) ((int) Math.ceil(((double) Math.max(this.n + (this.y * this.t), this.l)) / ((double) b(i))))) / ((double) (1 << i3)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested resolution level is not available for, at least, one component in tile: ");
        stringBuilder.append(this.x);
        stringBuilder.append("x");
        stringBuilder.append(this.y);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final cu b(cu cuVar) {
        if (cuVar == null) {
            return new cu(this.u, this.v);
        }
        cuVar.a = this.u;
        cuVar.b = this.v;
        return cuVar;
    }

    public final int e() {
        return this.u * this.v;
    }

    public final eg e(int i, int i2) {
        if (i != d()) {
            throw new IllegalArgumentException("Can not request subband tree of a different tile than the current one");
        } else if (i2 >= 0 && i2 < this.f) {
            return this.h[i2];
        } else {
            throw new IllegalArgumentException("Component index out of range");
        }
    }

    public static by a(df dfVar, cb cbVar, dt dtVar, cg cgVar, boolean z, bw bwVar) {
        dtVar.a('B', dt.a(f()));
        return new ca(cbVar, dfVar, cgVar, dtVar, z, bwVar);
    }

    public static String[][] f() {
        return D;
    }

    public final int c(int i, int i2, int i3) {
        return this.a.n.a(i, i2, i3);
    }

    public final int d(int i, int i2, int i3) {
        return this.a.n.b(i, i2, i3);
    }

    /* JADX WARNING: Missing block: B:36:0x0097, code:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:39:0x009d, code:
            if ((r9.h - r0) < 0) goto L_0x00d2;
     */
    /* JADX WARNING: Missing block: B:41:0x00a2, code:
            if ((r9.i - r2) >= 0) goto L_0x00a5;
     */
    /* JADX WARNING: Missing block: B:42:0x00a5, code:
            r3 = (r9.h - r0) + r9.n;
            r9.e.a = (((r9.l + r3) - 1) / r9.n) - ((r3 / r9.n) - 1);
            r0 = (r9.i - r2) + r9.o;
            r9.e.b = (((r9.m + r0) - 1) / r9.o) - ((r0 / r9.o) - 1);
     */
    /* JADX WARNING: Missing block: B:44:0x00d9, code:
            throw new java.lang.IllegalArgumentException("Invalid code-blocks partition origin or image offset in the reference grid.");
     */
    protected void a(int r8, jumio.nv.nfc.eg r9) {
        /*
        r7 = this;
        r0 = r7.d();
        r1 = r9.d;
        r2 = r7.a;
        r2 = r2.q;
        r3 = 3;
        r2 = r2.a(r3, r0, r8);
        r4 = r7.a;
        r4 = r4.q;
        r3 = r4.b(r3, r0, r8);
        r4 = r9.a;
        if (r4 != 0) goto L_0x011a;
    L_0x001b:
        r4 = r7.z;
        r4 = r4.l();
        r5 = 1;
        if (r4 == 0) goto L_0x0068;
    L_0x0024:
        r4 = r7.c(r0, r8, r1);
        r4 = jumio.nv.nfc.ds.a(r4);
        r0 = r7.d(r0, r8, r1);
        r0 = jumio.nv.nfc.ds.a(r0);
        r1 = jumio.nv.nfc.ds.a(r2);
        r2 = jumio.nv.nfc.ds.a(r3);
        r3 = r9.d;
        if (r3 == 0) goto L_0x0055;
    L_0x0040:
        r4 = r4 - r5;
        if (r1 >= r4) goto L_0x0046;
    L_0x0043:
        r1 = r5 << r1;
        goto L_0x0048;
    L_0x0046:
        r1 = r5 << r4;
    L_0x0048:
        r9.n = r1;
        r0 = r0 - r5;
        if (r2 >= r0) goto L_0x0050;
    L_0x004d:
        r0 = r5 << r2;
        goto L_0x0052;
    L_0x0050:
        r0 = r5 << r0;
    L_0x0052:
        r9.o = r0;
        goto L_0x006c;
    L_0x0055:
        if (r1 >= r4) goto L_0x005a;
    L_0x0057:
        r1 = r5 << r1;
        goto L_0x005c;
    L_0x005a:
        r1 = r5 << r4;
    L_0x005c:
        r9.n = r1;
        if (r2 >= r0) goto L_0x0063;
    L_0x0060:
        r0 = r5 << r2;
        goto L_0x0065;
    L_0x0063:
        r0 = r5 << r0;
    L_0x0065:
        r9.o = r0;
        goto L_0x006c;
    L_0x0068:
        r9.n = r2;
        r9.o = r3;
    L_0x006c:
        r0 = r9.e;
        if (r0 != 0) goto L_0x0077;
    L_0x0070:
        r0 = new jumio.nv.nfc.cu;
        r0.<init>();
        r9.e = r0;
    L_0x0077:
        r0 = r9.l;
        r1 = 0;
        if (r0 == 0) goto L_0x00da;
    L_0x007c:
        r0 = r9.m;
        if (r0 != 0) goto L_0x0081;
    L_0x0080:
        goto L_0x00da;
    L_0x0081:
        r0 = r7.a();
        r2 = r7.b();
        r3 = r9.g;
        switch(r3) {
            case 0: goto L_0x009a;
            case 1: goto L_0x0099;
            case 2: goto L_0x0097;
            case 3: goto L_0x0096;
            default: goto L_0x008e;
        };
    L_0x008e:
        r8 = new java.lang.Error;
        r9 = "Internal JJ2000 error";
        r8.<init>(r9);
        throw r8;
    L_0x0096:
        r0 = 0;
    L_0x0097:
        r2 = 0;
        goto L_0x009a;
    L_0x0099:
        r0 = 0;
    L_0x009a:
        r3 = r9.h;
        r3 = r3 - r0;
        if (r3 < 0) goto L_0x00d2;
    L_0x009f:
        r3 = r9.i;
        r3 = r3 - r2;
        if (r3 >= 0) goto L_0x00a5;
    L_0x00a4:
        goto L_0x00d2;
    L_0x00a5:
        r3 = r9.h;
        r3 = r3 - r0;
        r0 = r9.n;
        r3 = r3 + r0;
        r0 = r9.e;
        r4 = r9.l;
        r4 = r4 + r3;
        r4 = r4 - r5;
        r6 = r9.n;
        r4 = r4 / r6;
        r6 = r9.n;
        r3 = r3 / r6;
        r3 = r3 - r5;
        r4 = r4 - r3;
        r0.a = r4;
        r0 = r9.i;
        r0 = r0 - r2;
        r2 = r9.o;
        r0 = r0 + r2;
        r2 = r9.e;
        r3 = r9.m;
        r3 = r3 + r0;
        r3 = r3 - r5;
        r4 = r9.o;
        r3 = r3 / r4;
        r4 = r9.o;
        r0 = r0 / r4;
        r0 = r0 - r5;
        r3 = r3 - r0;
        r2.b = r3;
        goto L_0x00e2;
    L_0x00d2:
        r8 = new java.lang.IllegalArgumentException;
        r9 = "Invalid code-blocks partition origin or image offset in the reference grid.";
        r8.<init>(r9);
        throw r8;
    L_0x00da:
        r0 = r9.e;
        r0.a = r1;
        r0 = r9.e;
        r0.b = r1;
    L_0x00e2:
        r0 = r7.b;
        r0 = r0[r8];
        if (r0 == 0) goto L_0x0103;
    L_0x00e8:
        r0 = r7.c;
        r0 = r0[r8];
        r2 = r7.d;
        r2 = r2[r8];
        r2 = r2.a;
        r2 = r2[r1];
        r1 = r2[r1];
        r2 = r7.e;
        r8 = r2[r8];
        r2 = r9.c;
        r8 = r8 - r2;
        r1 = r1 - r8;
        r0 = r0 + r1;
        r0 = r0 - r5;
        r9.r = r0;
        goto L_0x013e;
    L_0x0103:
        r0 = r7.c;
        r0 = r0[r8];
        r1 = r7.d;
        r8 = r1[r8];
        r8 = r8.a;
        r1 = r9.d;
        r8 = r8[r1];
        r1 = r9.g;
        r8 = r8[r1];
        r0 = r0 + r8;
        r0 = r0 - r5;
        r9.r = r0;
        goto L_0x013e;
    L_0x011a:
        r0 = r9.b();
        r0 = (jumio.nv.nfc.eg) r0;
        r7.a(r8, r0);
        r0 = r9.c();
        r0 = (jumio.nv.nfc.eg) r0;
        r7.a(r8, r0);
        r0 = r9.d();
        r0 = (jumio.nv.nfc.eg) r0;
        r7.a(r8, r0);
        r9 = r9.e();
        r9 = (jumio.nv.nfc.eg) r9;
        r7.a(r8, r9);
    L_0x013e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.by.a(int, jumio.nv.nfc.eg):void");
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.z.a(null).a;
    }

    public int i() {
        return this.z.a(null).b;
    }

    public int j() {
        return this.z.g();
    }

    public int k() {
        return this.z.h();
    }
}
