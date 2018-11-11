package jumio.nv.nfc;

/* compiled from: DecoderSpecs */
public class cg implements Cloneable {
    public br a;
    public do b;
    public di c;
    public dh d;
    public dg e;
    public em f;
    public bq g;
    public bq h;
    public bq i;
    public br j;
    public ct k;
    public br l;
    public br m;
    public cj n;
    public br o;
    public br p;
    public ch q;
    public br r;

    public cg(int i, int i2) {
        this.c = new di(i, i2, (byte) 2);
        this.d = new dh(i, i2, (byte) 2);
        this.e = new dg(i, i2, (byte) 2);
        this.f = new em(i, i2, (byte) 2);
        this.g = new bq(i, i2, (byte) 2);
        this.k = new ct(i, i2, (byte) 2);
        this.j = new br(i, i2, (byte) 2);
        this.m = new br(i, i2, (byte) 2);
        this.q = new ch(i, i2, (byte) 2);
        this.n = new cj(i, i2, (byte) 2, this.g);
        this.h = new bq(i, i2, (byte) 1);
        this.i = new bq(i, i2, (byte) 1);
        this.l = new br(i, i2, (byte) 1);
        this.o = new br(i, i2, (byte) 1);
        this.p = new br(i, i2, (byte) 1);
        this.r = new br(i, i2, (byte) 1);
        this.a = new br(i, i2, (byte) 1);
        this.r.a(new Boolean(false));
    }
}
