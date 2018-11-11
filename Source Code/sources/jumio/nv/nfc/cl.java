package jumio.nv.nfc;

/* compiled from: ByteToBitInput */
public class cl {
    ck a;
    int b;
    int c = -1;

    public cl(ck ckVar) {
        this.a = ckVar;
    }

    public final int a() {
        if (this.c < 0) {
            if ((this.b & 255) != 255) {
                this.b = this.a.a();
                this.c = 7;
            } else {
                this.b = this.a.a();
                this.c = 6;
            }
        }
        int i = this.b;
        int i2 = this.c;
        this.c = i2 - 1;
        return (i >> i2) & 1;
    }

    public boolean b() {
        if (this.c < 0 && (this.b & 255) == 255) {
            this.b = this.a.a();
            this.c = 6;
        }
        if (this.c >= 0 && (this.b & ((1 << (this.c + 1)) - 1)) != (85 >> (7 - this.c))) {
            return true;
        }
        if (this.b != -1) {
            if (this.b == 255 && this.c == 0) {
                if ((this.a.a() & 255) >= 128) {
                    return true;
                }
            } else if (this.a.a() != -1) {
                return true;
            }
        }
        return false;
    }

    final void a(byte[] bArr, int i, int i2) {
        this.a.a(bArr, i, i2);
        this.b = 0;
        this.c = -1;
    }
}
