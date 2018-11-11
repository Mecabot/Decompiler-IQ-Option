package jumio.nv.nfc;

/* compiled from: ICCXYZType */
public class bk extends bg {
    public final long a;
    public final long b;
    public final long c;

    public static double a(long j) {
        return ((double) j) / 65536.0d;
    }

    protected bk(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.a = (long) an.e(bArr, i2 + 8);
        this.b = (long) an.e(bArr, i2 + 12);
        this.c = (long) an.e(bArr, i2 + 16);
    }
}
