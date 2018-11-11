package jumio.nv.nfc;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: ICCTagTable */
public class bh extends Hashtable {
    private static final String a = System.getProperty("line.separator");
    private final Vector b = new Vector();
    private int c;

    /* compiled from: ICCTagTable */
    static class a {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static bh a(byte[] bArr) {
        return new bh(bArr);
    }

    protected bh(byte[] bArr) {
        this.c = an.e(bArr, 128);
        int i = 132;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.addElement(new a(an.e(bArr, i), an.e(bArr, i + 4), an.e(bArr, i + 8)));
            i += 12;
        }
        Enumeration elements = this.b.elements();
        while (elements.hasMoreElements()) {
            a aVar = (a) elements.nextElement();
            bg a = bg.a(aVar.a, bArr, aVar.b, aVar.c);
            put(new Integer(a.e), a);
        }
    }
}
