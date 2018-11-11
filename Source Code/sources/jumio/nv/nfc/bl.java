package jumio.nv.nfc;

/* compiled from: ICCXYZTypeReverse */
public class bl extends bk {
    public final long d;
    public final long j;
    public final long k;

    protected bl(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.k = (long) an.e(bArr, i2 + 8);
        this.j = (long) an.e(bArr, i2 + 12);
        this.d = (long) an.e(bArr, i2 + 16);
    }
}
