package jumio.nv.nfc;

import java.io.ByteArrayInputStream;

/* compiled from: PktHeaderBitReader */
public class cd {
    df a;
    ByteArrayInputStream b;
    boolean c = true;
    int d;
    int e;
    int f;

    cd(df dfVar) {
        this.a = dfVar;
    }

    cd(ByteArrayInputStream byteArrayInputStream) {
        this.b = byteArrayInputStream;
    }

    final int a() {
        if (this.e == 0) {
            if (this.d != 255) {
                if (this.c) {
                    this.d = this.b.read();
                } else {
                    this.d = this.a.g();
                }
                this.e = 8;
                if (this.d == 255) {
                    if (this.c) {
                        this.f = this.b.read();
                    } else {
                        this.f = this.a.g();
                    }
                }
            } else {
                this.d = this.f;
                this.e = 7;
            }
        }
        int i = this.d;
        int i2 = this.e - 1;
        this.e = i2;
        return (i >> i2) & 1;
    }

    final int a(int i) {
        int i2;
        int i3;
        if (i <= this.e) {
            i2 = this.d;
            i3 = this.e - i;
            this.e = i3;
            return ((1 << i) - 1) & (i2 >> i3);
        }
        i2 = 0;
        do {
            i -= this.e;
            i2 = (i2 << this.e) | a(this.e);
            if (this.d != 255) {
                if (this.c) {
                    this.d = this.b.read();
                } else {
                    this.d = this.a.g();
                }
                this.e = 8;
                if (this.d == 255) {
                    if (this.c) {
                        this.f = this.b.read();
                    } else {
                        this.f = this.a.g();
                    }
                }
            } else {
                this.d = this.f;
                this.e = 7;
            }
        } while (i > this.e);
        i2 <<= i;
        i3 = this.d;
        int i4 = this.e - i;
        this.e = i4;
        return (((1 << i) - 1) & (i3 >> i4)) | i2;
    }

    void b() {
        this.d = 0;
        this.e = 0;
    }
}
