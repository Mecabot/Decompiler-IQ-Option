package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;

/* compiled from: ICCCurveType */
public class be extends bg {
    private static final String j = System.getProperty("line.separator");
    public final int a;
    public final int b;
    public final int c;
    public final int[] d = new int[this.c];

    public static double a(int i) {
        return ((double) i) / 65535.0d;
    }

    public static double b(int i) {
        return ((double) i) / 256.0d;
    }

    protected be(int i, byte[] bArr, int i2, int i3) {
        i3 = i2 + 8;
        super(i, bArr, i2, i3);
        this.a = an.e(bArr, i2);
        this.b = an.e(bArr, i2 + 4);
        this.c = an.e(bArr, i3);
        for (i = 0; i < this.c; i++) {
            this.d[i] = an.d(bArr, (i2 + 12) + (i * 2)) & SupportMenu.USER_MASK;
        }
    }

    public final int c(int i) {
        return this.d[i];
    }
}
