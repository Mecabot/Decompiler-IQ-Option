package jumio.nv.nfc;

/* compiled from: ByteInputBuffer */
public class ck {
    private byte[] a;
    private int b;
    private int c;

    public ck(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i2 >= 0) {
                i2 += i;
                if (i2 <= bArr.length) {
                    this.a = bArr;
                    this.b = i2;
                    this.c = i;
                    return;
                }
            }
            throw new IllegalArgumentException();
        } else if (i2 < 0 || this.b + i2 > this.a.length) {
            throw new IllegalArgumentException();
        } else if (i < 0) {
            this.c = this.b;
            this.b += i2;
        } else {
            this.b = i2 + i;
            this.c = i;
        }
    }

    public int a() {
        if (this.c >= this.b) {
            return -1;
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i] & 255;
    }
}
