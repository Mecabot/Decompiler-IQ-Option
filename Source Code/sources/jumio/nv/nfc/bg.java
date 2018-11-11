package jumio.nv.nfc;

/* compiled from: ICCTag */
public abstract class bg {
    private static final int a = an.e("cprt".getBytes(), 0);
    private static final int b = an.e("desc".getBytes(), 0);
    private static final int c = an.e("wtpt".getBytes(), 0);
    private static final int d = an.e("bkpt".getBytes(), 0);
    private static final int j = an.e("rXYZ".getBytes(), 0);
    private static final int k = an.e("gXYZ".getBytes(), 0);
    private static final int l = an.e("bXYZ".getBytes(), 0);
    private static final int m = an.e("kXYZ".getBytes(), 0);
    private static final int n = an.e("rTRC".getBytes(), 0);
    private static final int o = an.e("gTRC".getBytes(), 0);
    private static final int p = an.e("bTRC".getBytes(), 0);
    private static final int q = an.e("kTRC".getBytes(), 0);
    private static final int r = an.e("dmnd".getBytes(), 0);
    private static final int s = an.e("dmdd".getBytes(), 0);
    private static final int t = an.e("desc".getBytes(), 0);
    private static final int u = an.e("text".getBytes(), 0);
    private static final int v = an.e("curv".getBytes(), 0);
    private static final int w = an.e("vruc".getBytes(), 0);
    private static final int x = an.e("XYZ ".getBytes(), 0);
    private static final int y = an.e(" ZYX".getBytes(), 0);
    public final int e;
    public final int f;
    public final byte[] g;
    public final int h;
    public final int i;

    public static bg a(int i, byte[] bArr, int i2, int i3) {
        int e = an.e(bArr, i2);
        if (e == t) {
            return new bi(i, bArr, i2, i3);
        }
        if (e == u) {
            return new bj(i, bArr, i2, i3);
        }
        if (e == x) {
            return new bk(i, bArr, i2, i3);
        }
        if (e == y) {
            return new bl(i, bArr, i2, i3);
        }
        if (e == v) {
            return new be(i, bArr, i2, i3);
        }
        if (e == w) {
            return new bf(i, bArr, i2, i3);
        }
        throw new IllegalArgumentException("bad tag type");
    }

    protected bg(int i, byte[] bArr, int i2, int i3) {
        this.e = i;
        this.g = bArr;
        this.h = i2;
        this.i = i3;
        this.f = an.e(bArr, i2);
    }
}
