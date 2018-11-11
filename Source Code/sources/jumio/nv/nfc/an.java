package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;

/* compiled from: ICCProfile */
public abstract class an {
    public static final int a = e(new String("acsp").getBytes(), 0);
    public static final int b = e(new String("psca").getBytes(), 0);
    public static final int c = e(new String("scnr").getBytes(), 0);
    public static final int d = e(new String("mntr").getBytes(), 0);
    public static final int e = e(new String("RGB ").getBytes(), 0);
    public static final int f = e(new String("GRAY").getBytes(), 0);
    public static final int g = e(new String("XYZ ").getBytes(), 0);
    public static final int h = e(new String("kTRC").getBytes(), 0);
    public static final int i = e(new String("rXYZ").getBytes(), 0);
    public static final int j = e(new String("gXYZ").getBytes(), 0);
    public static final int k = e(new String("bXYZ").getBytes(), 0);
    public static final int l = e(new String("rTRC").getBytes(), 0);
    public static final int m = e(new String("gTRC").getBytes(), 0);
    public static final int n = e(new String("bTRC").getBytes(), 0);
    public static final int o = e(new String("cprt").getBytes(), 0);
    public static final int p = e(new String("wtpt").getBytes(), 0);
    public static final int q = e(new String("desc").getBytes(), 0);
    private static final String r = System.getProperty("line.separator");
    private bn s = null;
    private bh t = null;
    private byte[] u = null;

    public static bp a(byte[] bArr, int i) {
        return new bp(e(bArr, i), e(bArr, i + 4), e(bArr, i + 8));
    }

    public static bo b(byte[] bArr, int i) {
        return new bo(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
    }

    public static bm c(byte[] bArr, int i) {
        return new bm(d(bArr, i), d(bArr, i + 2), d(bArr, i + 4), d(bArr, i + 6), d(bArr, i + 8), d(bArr, i + 10));
    }

    public static short d(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static int e(byte[] bArr, int i) {
        return (d(bArr, i + 2) & SupportMenu.USER_MASK) | ((d(bArr, i) & SupportMenu.USER_MASK) << 16);
    }

    public static long f(byte[] bArr, int i) {
        return (((long) (e(bArr, i) & -1)) << 32) | ((long) (e(bArr, i + 4) & -1));
    }

    private int b() {
        return this.s.e;
    }

    private int c() {
        return this.s.g;
    }

    private int d() {
        return this.s.h;
    }

    protected an(y yVar) {
        this.u = yVar.a();
        a(this.u);
    }

    private void a(byte[] bArr) {
        this.s = new bn(bArr);
        this.t = bh.a(bArr);
        if (d() != a || ((b() != c && b() != d) || c() != g)) {
            throw new ap();
        }
    }

    public at a() {
        be beVar = (be) this.t.get(new Integer(h));
        if (beVar != null) {
            return at.b(beVar);
        }
        be beVar2 = (be) this.t.get(new Integer(l));
        if (beVar2 != null) {
            return at.b(beVar2, (be) this.t.get(new Integer(m)), (be) this.t.get(new Integer(n)), (bk) this.t.get(new Integer(i)), (bk) this.t.get(new Integer(j)), (bk) this.t.get(new Integer(k)));
        }
        throw new ap("curve data not found in profile");
    }
}
