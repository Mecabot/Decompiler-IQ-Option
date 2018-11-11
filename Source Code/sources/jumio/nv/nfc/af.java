package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;
import java.util.Enumeration;
import java.util.Hashtable;

/* compiled from: ChannelDefinitionBox */
public final class af extends aj {
    private int a;
    private Hashtable b = new Hashtable();

    static {
        i = 1667523942;
    }

    public af(df dfVar, int i) {
        super(dfVar, i);
        a();
    }

    private void a() {
        byte[] bArr = new byte[8];
        this.k.a(this.n);
        this.k.a(bArr, 0, 2);
        this.a = an.d(bArr, 0) & SupportMenu.USER_MASK;
        this.k.a(this.n + 2);
        for (int i = 0; i < this.a; i++) {
            this.k.a(bArr, 0, 6);
            an.d(bArr, 0);
            Object obj = new int[]{a(bArr), b(bArr), c(bArr)};
            this.b.put(new Integer(obj[0]), obj);
        }
    }

    public int a(int i) {
        Enumeration keys = this.b.keys();
        while (keys.hasMoreElements()) {
            int[] iArr = (int[]) this.b.get(keys.nextElement());
            if (i == b(iArr)) {
                return a(iArr);
            }
        }
        return i;
    }

    private int a(byte[] bArr) {
        return an.d(bArr, 0);
    }

    private int b(byte[] bArr) {
        return an.d(bArr, 2);
    }

    private int c(byte[] bArr) {
        return an.d(bArr, 4);
    }

    private int a(int[] iArr) {
        return iArr[0];
    }

    private int b(int[] iArr) {
        return iArr[2];
    }
}
