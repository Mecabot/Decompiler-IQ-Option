package jumio.nv.nfc;

/* compiled from: ArrayUtil */
public class dq {
    public static void a(int[] iArr, int i) {
        int length = iArr.length;
        if (length < 8) {
            for (length--; length >= 0; length--) {
                iArr[length] = i;
            }
            return;
        }
        int i2 = length >> 1;
        int i3 = 0;
        while (i3 < 4) {
            iArr[i3] = i;
            i3++;
        }
        while (i3 <= i2) {
            System.arraycopy(iArr, 0, iArr, i3, i3);
            i3 <<= 1;
        }
        if (i3 < length) {
            System.arraycopy(iArr, 0, iArr, i3, length - i3);
        }
    }
}
