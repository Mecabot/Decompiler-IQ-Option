package jumio.nv.nfc;

/* compiled from: ColorSpaceMapper */
public abstract class aa extends cz implements cs {
    protected static final String a = System.getProperty("line.separator");
    private static final String[][] s = ((String[][]) null);
    protected cx[] b;
    protected cw[] c;
    protected cx[] d;
    protected cw[] e;
    protected int[][] f;
    protected float[][] g;
    protected float[][] h;
    protected int[][] i;
    protected int[] j = null;
    protected int[] k = null;
    protected int[] l = null;
    protected dt m = null;
    protected y n = null;
    protected int o = 0;
    protected cs p = null;
    protected cv[] q = null;
    protected a r = new a();

    /* compiled from: ColorSpaceMapper */
    public class a {
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private int f = -1;
        private int g = -1;
        private int h = -1;

        public a() {
            a();
        }

        public void a() {
            this.h = -1;
            this.g = -1;
            this.f = -1;
            this.e = -1;
            this.d = -1;
            this.c = -1;
        }
    }

    public static String[][] a() {
        return s;
    }

    protected static void a(cv cvVar) {
        switch (cvVar.a()) {
            case 3:
                if (cvVar.b() == null || ((int[]) cvVar.b()).length < cvVar.c * cvVar.d) {
                    cvVar.a(new int[(cvVar.c * cvVar.d)]);
                    return;
                }
                return;
            case 4:
                if (cvVar.b() == null || ((float[]) cvVar.b()).length < cvVar.c * cvVar.d) {
                    cvVar.a(new float[(cvVar.c * cvVar.d)]);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("Invalid output datablock type");
        }
    }

    protected static void a(cv cvVar, cv cvVar2) {
        cvVar.e = 0;
        cvVar.d = cvVar2.d;
        cvVar.c = cvVar2.c;
        cvVar.a = cvVar2.a;
        cvVar.b = cvVar2.b;
        cvVar.f = cvVar2.c;
        a(cvVar);
    }

    public static cs b(cs csVar, y yVar) {
        dt dtVar = yVar.b;
        dt dtVar2 = yVar.b;
        dtVar.a('I', dt.a(s));
        if (yVar.c() == y.d) {
            return aq.a(csVar, yVar);
        }
        jumio.nv.nfc.y.a d = yVar.d();
        if (d == y.f) {
            return ab.a(csVar, yVar);
        }
        if (d == y.g) {
            return ab.a(csVar, yVar);
        }
        if (d == y.h) {
            return ae.a(csVar, yVar);
        }
        if (d == y.j) {
            return null;
        }
        throw new z("Bad color space specification in image");
    }

    protected aa(cs csVar, y yVar) {
        super(csVar);
        this.p = csVar;
        this.n = yVar;
        h();
    }

    private void h() {
        this.m = this.n.b;
        this.o = this.p.b();
        this.j = new int[this.o];
        this.k = new int[this.o];
        this.l = new int[this.o];
        this.q = new cv[this.o];
        this.b = new cx[this.o];
        this.c = new cw[this.o];
        this.d = new cx[this.o];
        this.e = new cw[this.o];
        this.f = new int[this.o][];
        this.g = new float[this.o][];
        this.i = new int[this.o][];
        this.h = new float[this.o][];
        this.f = new int[this.o][];
        this.g = new float[this.o][];
        for (int i = 0; i < this.o; i++) {
            this.j[i] = 1 << (this.p.b(i) - 1);
            this.k[i] = (1 << this.p.b(i)) - 1;
            this.l[i] = this.p.a(i);
            this.b[i] = new cx();
            this.c[i] = new cw();
            this.d[i] = new cx();
            this.d[i].g = this.b[i].g;
            this.e[i] = new cw();
            this.e[i].g = this.c[i].g;
        }
    }

    public int a(int i) {
        return this.p.a(i);
    }

    public cv a(cv cvVar, int i) {
        return this.p.a(cvVar, i);
    }

    public cv b(cv cvVar, int i) {
        return this.p.b(cvVar, i);
    }
}
