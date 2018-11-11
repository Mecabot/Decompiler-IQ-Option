package jumio.nv.nfc;

/* compiled from: ColorSpace */
public class y {
    public static final String a = System.getProperty("line.separator");
    public static final c d = new c("profiled");
    public static final c e = new c("enumerated");
    public static final a f = new a("sRGB");
    public static final a g = new a("GreyScale");
    public static final a h = new a("sYCC");
    public static final a i = new a("Illegal");
    public static final a j = new a("Unknown");
    public dt b;
    public cb c;
    private ak k = null;
    private ah l = null;
    private ag m = null;
    private af n = null;
    private ai o = null;
    private df p = null;

    /* compiled from: ColorSpace */
    public static class b {
        public final String a;

        public b(String str) {
            this.a = str;
        }
    }

    /* compiled from: ColorSpace */
    public static class a extends b {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: ColorSpace */
    public static class c extends b {
        public c(String str) {
            super(str);
        }
    }

    public byte[] a() {
        return this.m.c();
    }

    public y(df dfVar, cb cbVar, dt dtVar) {
        this.b = dtVar;
        this.p = dfVar;
        this.c = cbVar;
        b();
    }

    protected final void b() {
        int i = 16;
        byte[] bArr = new byte[16];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            this.p.a(i2);
            this.p.a(bArr, 0, i);
            long e = (long) an.e(bArr, 0);
            if (e == 1) {
                e = an.f(bArr, 8);
            }
            int e2 = an.e(bArr, 4);
            if (i3 == 0 && e2 != 1783636000) {
                throw new z("first box in image not signature");
            } else if (i3 == 1 && e2 != 1718909296) {
                throw new z("second box in image not file");
            } else if (e2 == 1785737827) {
                throw new z("header box not found in image");
            } else if (e2 == 1785737832) {
                long j = ((long) i2) + e;
                if (e == 1) {
                    i2 += 8;
                }
                i2 += 8;
                while (true) {
                    long j2 = (long) i2;
                    if (j2 < j) {
                        this.p.a(i2);
                        this.p.a(bArr, 0, i);
                        long e3 = (long) an.e(bArr, 0);
                        if (e3 == 1) {
                            throw new z("Extended length boxes not supported");
                        }
                        switch (an.e(bArr, 4)) {
                            case 1667523942:
                                this.n = new af(this.p, i2);
                                break;
                            case 1668112752:
                                this.l = new ah(this.p, i2);
                                break;
                            case 1668246642:
                                this.m = new ag(this.p, i2);
                                break;
                            case 1768449138:
                                this.o = new ai(this.p, i2);
                                break;
                            case 1885564018:
                                this.k = new ak(this.p, i2);
                                break;
                            default:
                                break;
                        }
                        i2 = (int) (j2 + e3);
                        bArr = bArr;
                        i = 16;
                    } else if (this.o == null) {
                        throw new z("image header box not found");
                    } else if ((this.k == null && this.l != null) || (this.k != null && this.l == null)) {
                        throw new z("palette box and component mapping box inconsistency");
                    } else {
                        return;
                    }
                }
            } else {
                i3++;
                i2 = (int) (((long) i2) + e);
                bArr = bArr;
                i = 16;
            }
        }
    }

    public int a(int i) {
        if (this.n == null) {
            return i;
        }
        return this.n.a(i + 1);
    }

    public c c() {
        return this.m.a();
    }

    public a d() {
        return this.m.b();
    }

    public ak e() {
        return this.k;
    }
}
