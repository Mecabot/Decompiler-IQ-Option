package jumio.nv.nfc;

/* compiled from: ICCTextDescriptionType */
public class bi extends bg {
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d = new byte[(this.c - 1)];

    protected bi(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.a = an.e(bArr, i2);
        i2 += 4;
        this.b = an.e(bArr, i2);
        i2 += 4;
        this.c = an.e(bArr, i2);
        i2 += 4;
        System.arraycopy(bArr, i2, this.d, 0, this.c - 1);
    }
}
