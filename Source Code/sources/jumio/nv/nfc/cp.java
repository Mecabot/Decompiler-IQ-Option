package jumio.nv.nfc;

import android.support.v4.view.MotionEventCompat;

/* compiled from: MQDecoder */
public class cp {
    static final int[] a = new int[]{22017, 13313, 6145, 2753, 1313, 545, 22017, 21505, 18433, 14337, 12289, 9217, 7169, 5633, 22017, 21505, 20737, 18433, 14337, 13313, 12289, 10241, 9217, 8705, 7169, 6145, 5633, 5121, 4609, 4353, 2753, 2497, 2209, 1313, 1089, 673, 545, 321, 273, 133, 73, 37, 21, 9, 5, 1, 22017};
    static final int[] b = new int[]{1, 2, 3, 4, 5, 38, 7, 8, 9, 10, 11, 12, 13, 29, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 45, 46};
    static final int[] c = new int[]{1, 6, 9, 12, 29, 33, 6, 14, 14, 14, 17, 18, 20, 21, 14, 14, 15, 16, 17, 18, 19, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 46};
    static final int[] d = new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    ck e;
    int[] f;
    int[] g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    final int[] m;

    public cp(ck ckVar, int i, int[] iArr) {
        this.e = ckVar;
        this.g = new int[i];
        this.f = new int[i];
        this.m = iArr;
        e();
        b();
    }

    public final int a(int i) {
        int i2 = this.g[i];
        int i3 = a[i2];
        this.j -= i3;
        int i4;
        if ((this.h >>> 16) >= this.j) {
            i4 = this.j;
            this.h -= i4 << 16;
            if (i4 < i3) {
                i4 = this.f[i];
                this.g[i] = b[i2];
                if (this.i == 0) {
                    d();
                }
                i = i3 << 1;
                this.h <<= 1;
                this.i--;
            } else {
                i4 = 1 - this.f[i];
                if (d[i2] == 1) {
                    this.f[i] = 1 - this.f[i];
                }
                this.g[i] = c[i2];
                do {
                    if (this.i == 0) {
                        d();
                    }
                    i3 <<= 1;
                    this.h <<= 1;
                    this.i--;
                } while (i3 < 32768);
                i = i3;
            }
            this.j = i;
            return i4;
        } else if (this.j >= 32768) {
            return this.f[i];
        } else {
            i4 = this.j;
            if (i4 >= i3) {
                i3 = this.f[i];
                this.g[i] = b[i2];
                if (this.i == 0) {
                    d();
                }
                i = i4 << 1;
                this.h <<= 1;
                this.i--;
            } else {
                int i5 = 1 - this.f[i];
                if (d[i2] == 1) {
                    this.f[i] = 1 - this.f[i];
                }
                this.g[i] = c[i2];
                do {
                    if (this.i == 0) {
                        d();
                    }
                    i4 <<= 1;
                    this.h <<= 1;
                    this.i--;
                } while (i4 < 32768);
                i = i4;
                i3 = i5;
            }
            this.j = i;
            return i3;
        }
    }

    public boolean a() {
        if (this.k != 255 && !this.l) {
            return true;
        }
        if (this.i != 0 && !this.l) {
            return true;
        }
        if (this.i == 1) {
            return false;
        }
        if (this.i == 0) {
            if (!this.l) {
                this.k = this.e.a() & 255;
                if (this.k <= 143) {
                    return true;
                }
            }
            this.i = 8;
        }
        int i = 32768 >> (this.i - 1);
        this.j -= i;
        if ((this.h >>> 16) < this.j) {
            return true;
        }
        this.h -= this.j << 16;
        this.j = i;
        do {
            if (this.i == 0) {
                d();
            }
            this.j <<= 1;
            this.h <<= 1;
            this.i--;
        } while (this.j < 32768);
        return false;
    }

    private void d() {
        if (this.l) {
            this.i = 8;
        } else if (this.k == 255) {
            this.k = this.e.a() & 255;
            if (this.k > 143) {
                this.l = true;
                this.i = 8;
                return;
            }
            this.h += 65024 - (this.k << 9);
            this.i = 7;
        } else {
            this.k = this.e.a() & 255;
            this.h += MotionEventCompat.ACTION_POINTER_INDEX_MASK - (this.k << 8);
            this.i = 8;
        }
    }

    public final void b() {
        System.arraycopy(this.m, 0, this.g, 0, this.g.length);
        dq.a(this.f, 0);
    }

    public final void a(byte[] bArr, int i, int i2) {
        this.e.a(bArr, i, i2);
        e();
    }

    public ck c() {
        return this.e;
    }

    private void e() {
        this.l = false;
        this.k = this.e.a() & 255;
        this.h = (this.k ^ 255) << 16;
        d();
        this.h <<= 7;
        this.i -= 7;
        this.j = 32768;
    }
}
