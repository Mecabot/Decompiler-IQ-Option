package jumio.nv.nfc;

/* compiled from: ImageHeaderBox */
public final class ai extends aj {
    long a;
    long b;
    int c;
    short d;
    short e;
    boolean f;
    boolean g;

    static {
        i = 69686472;
    }

    public ai(df dfVar, int i) {
        super(dfVar, i);
        a();
    }

    void a() {
        byte[] bArr = new byte[14];
        this.k.a(this.n);
        this.k.a(bArr, 0, 14);
        this.a = (long) an.e(bArr, 0);
        this.b = (long) an.e(bArr, 4);
        this.c = an.d(bArr, 8);
        this.d = (short) (bArr[10] & 255);
        this.e = (short) (bArr[11] & 255);
        boolean z = true;
        this.f = bArr[12] == (byte) 0;
        if (bArr[13] != (byte) 1) {
            z = false;
        }
        this.g = z;
    }
}
