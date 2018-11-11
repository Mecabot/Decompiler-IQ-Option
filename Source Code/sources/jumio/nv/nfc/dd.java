package jumio.nv.nfc;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;

/* compiled from: ImgWriterBitmapPPM */
public class dd extends dc {
    private int[] d = new int[3];
    private int[] e;
    private int[] f = new int[3];
    private int[] g = new int[3];
    private cx h = new cx();
    private byte[] i;

    public dd(cs csVar, int i, int i2, int i3) {
        if (i < 0 || i >= csVar.b() || i2 < 0 || i2 >= csVar.b() || i3 < 0 || i3 >= csVar.b() || csVar.b(i) > 8 || csVar.b(i2) > 8 || csVar.b(i3) > 8) {
            throw new IllegalArgumentException("Invalid component indexes");
        }
        this.b = csVar.d(i);
        this.c = csVar.c(i);
        if (this.b == csVar.d(i2) && this.b == csVar.d(i3) && this.c == csVar.c(i2) && this.c == csVar.c(i3)) {
            this.b = csVar.c();
            this.c = csVar.d();
            this.a = csVar;
            this.f[0] = i;
            this.f[1] = i2;
            this.f[2] = i3;
            this.g[0] = csVar.a(i);
            this.g[1] = csVar.a(i2);
            this.g[2] = csVar.a(i3);
            this.d[0] = 1 << (csVar.b(i) - 1);
            this.d[1] = 1 << (csVar.b(i2) - 1);
            this.d[2] = 1 << (csVar.b(i3) - 1);
            this.e = new int[(this.b * this.c)];
            return;
        }
        throw new IllegalArgumentException("All components must have the same dimensions and no subsampling");
    }

    public Bitmap a() {
        try {
            return Bitmap.createBitmap(this.e, this.b, this.c, Config.ARGB_8888);
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        int g = this.a.g(this.f[0]) - ((int) Math.ceil(((double) this.a.f()) / ((double) this.a.e(this.f[0]))));
        int h = this.a.h(this.f[0]) - ((int) Math.ceil(((double) this.a.g()) / ((double) this.a.f(this.f[0]))));
        if (this.h.h != null && this.h.h.length < i6) {
            this.h.h = null;
        }
        if (this.i == null || this.i.length < i6 * 3) {
            this.i = new byte[(i6 * 3)];
        }
        int i7 = i4;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9;
            int i10;
            while (0 < 3) {
                int b = (1 << this.a.b(this.f[0])) - 1;
                int i11 = this.d[0];
                this.h.a = i5;
                this.h.b = i2 + i8;
                this.h.c = i6;
                this.h.d = 1;
                do {
                    this.h = (cx) this.a.b(this.h, this.f[0]);
                } while (this.h.g);
                int i12 = this.g[0];
                int i13;
                if (i12 == 0) {
                    i12 = (this.h.e + i6) - 1;
                    i13 = (((i6 * 3) - 1) + 0) - 2;
                    while (i13 >= 0) {
                        i9 = this.h.h[i12] + i11;
                        byte[] bArr = this.i;
                        if (i9 < 0) {
                            i9 = 0;
                        } else if (i9 > b) {
                            i9 = b;
                        }
                        bArr[i13] = (byte) i9;
                        i13 -= 3;
                        i12--;
                    }
                } else {
                    i13 = (this.h.e + i6) - 1;
                    int i14 = (((i6 * 3) - 1) + 0) - 2;
                    while (i14 >= 0) {
                        i9 = (this.h.h[i13] >>> i12) + i11;
                        byte[] bArr2 = this.i;
                        if (i9 < 0) {
                            i9 = 0;
                        } else if (i9 > b) {
                            i9 = b;
                        }
                        bArr2[i14] = (byte) i9;
                        i14 -= 3;
                        i13--;
                    }
                }
                i10 = 0 + 1;
            }
            i10 = ((this.b * ((i2 + h) + i8)) + i5) + g;
            int i15 = 0;
            while (i15 < i6 * 3) {
                i9 = i10 + 1;
                this.e[i10] = Color.rgb(this.i[i15 + 0] & 255, this.i[i15 + 1] & 255, this.i[i15 + 2] & 255);
                i15 += 3;
                i10 = i9;
            }
        }
    }

    public void b() {
        int e = this.a.e();
        int b = this.a.b(e, 0);
        e = this.a.a(e, 0);
        for (int i = 0; i < e; i += 64) {
            int i2 = e - i;
            if (i2 >= 64) {
                i2 = 64;
            }
            a(0, i, b, i2);
        }
    }
}
