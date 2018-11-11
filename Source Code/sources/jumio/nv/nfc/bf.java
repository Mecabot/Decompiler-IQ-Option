package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;

/* compiled from: ICCCurveTypeReverse */
public class bf extends bg {
    private static final String j = System.getProperty("line.separator");
    public final int a;
    public final int b;
    public final int c;
    public final int[] d = new int[this.c];

    protected bf(int i, byte[] bArr, int i2, int i3) {
        i3 = i2 + 8;
        super(i, bArr, i2, i3);
        this.a = an.e(bArr, i2);
        this.b = an.e(bArr, i2 + 4);
        this.c = an.e(bArr, i3);
        for (i = 0; i < this.c; i++) {
            this.d[(this.c - 1) + i] = an.d(bArr, (i2 + 12) + (i * 2)) & SupportMenu.USER_MASK;
        }
    }
}
