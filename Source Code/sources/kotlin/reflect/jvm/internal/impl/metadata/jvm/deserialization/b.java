package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* compiled from: BitEncoding */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean eMA;

    static {
        Object property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            property = null;
        }
        eMA = "true".equals(property);
    }

    private b() {
    }

    private static void m(byte[] bArr, int i) {
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((bArr[i2] + i) & 127);
        }
    }

    public static byte[] k(String[] strArr) {
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                return n.n(l(strArr));
            }
            if (charAt == 65535) {
                strArr = l(strArr);
            }
        }
        byte[] m = m(strArr);
        m(m, 127);
        return ad(m);
    }

    private static String[] l(String[] strArr) {
        strArr = (String[]) strArr.clone();
        strArr[0] = strArr[0].substring(1);
        return strArr;
    }

    private static byte[] m(String[] strArr) {
        int i = 0;
        for (String length : strArr) {
            i += length.length();
        }
        byte[] bArr = new byte[i];
        int length2 = strArr.length;
        i = 0;
        int i2 = 0;
        while (i < length2) {
            String str = strArr[i];
            int length3 = str.length();
            int i3 = i2;
            i2 = 0;
            while (i2 < length3) {
                int i4 = i3 + 1;
                bArr[i3] = (byte) str.charAt(i2);
                i2++;
                i3 = i4;
            }
            i++;
            i2 = i3;
        }
        return bArr;
    }

    private static byte[] ad(byte[] bArr) {
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i++;
            int i4 = i2 + 1;
            bArr2[i3] = (byte) (((bArr[i] & 255) >>> i2) + ((bArr[i] & ((1 << i4) - 1)) << (7 - i2)));
            if (i2 == 6) {
                i++;
                i2 = 0;
            } else {
                i2 = i4;
            }
        }
        return bArr2;
    }
}
