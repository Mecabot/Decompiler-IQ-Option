package jumio.nv.nfc;

/* compiled from: ICCProfileHeader */
public class bn {
    public static int a = an.e(new String("acsp").getBytes(), 0);
    public static int b = an.e(new String("psca").getBytes(), 0);
    private static final String u = System.getProperty("line.separator");
    public int c;
    public int d;
    public int e;
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
    public int p;
    public byte[] q;
    public bo r;
    public bm s;
    public bp t;
    private byte[] v;

    public bn() {
        this.v = null;
        this.q = new byte[44];
    }

    public bn(byte[] bArr) {
        this.v = null;
        this.q = new byte[44];
        int i = 0;
        this.c = an.e(bArr, 0);
        this.d = an.e(bArr, 4);
        this.e = an.e(bArr, 12);
        this.f = an.e(bArr, 16);
        this.g = an.e(bArr, 20);
        this.h = an.e(bArr, 36);
        this.i = an.e(bArr, 40);
        this.j = an.e(bArr, 44);
        this.k = an.e(bArr, 48);
        this.l = an.e(bArr, 52);
        this.m = an.e(bArr, 60);
        this.n = an.e(bArr, 60);
        this.o = an.e(bArr, 64);
        this.p = an.e(bArr, 80);
        this.r = an.b(bArr, 8);
        this.s = an.c(bArr, 24);
        this.t = an.a(bArr, 68);
        while (i < this.q.length) {
            this.q[i] = bArr[i + 84];
            i++;
        }
    }
}
