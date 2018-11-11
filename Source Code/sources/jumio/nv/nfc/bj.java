package jumio.nv.nfc;

/* compiled from: ICCTextType */
public class bj extends bg {
    public final int a;
    public final int b;
    public final byte[] c;

    protected bj(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.a = an.e(bArr, i2);
        i2 += 4;
        this.b = an.e(bArr, i2);
        i2 += 4;
        i3 = 0;
        while (bArr[i2 + i3] != (byte) 0) {
            i3++;
        }
        this.c = new byte[i3];
        System.arraycopy(bArr, i2, this.c, 0, i3);
    }
}
