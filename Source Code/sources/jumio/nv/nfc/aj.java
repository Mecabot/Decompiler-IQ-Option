package jumio.nv.nfc;

/* compiled from: JP2Box */
public abstract class aj {
    public static final String h = System.getProperty("line.separator");
    public static int i;
    public int j;
    protected df k;
    protected int l;
    protected int m;
    protected int n;

    public aj(df dfVar, int i) {
        byte[] bArr = new byte[16];
        this.k = dfVar;
        this.l = i;
        this.k.a(this.l);
        this.k.a(bArr, 0, 8);
        this.n = i + 8;
        this.j = an.e(bArr, 0);
        this.m = i + this.j;
        if (this.j == 1) {
            throw new z("extended length boxes not supported");
        }
    }
}
