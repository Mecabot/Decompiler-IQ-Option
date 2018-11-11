package com.crashlytics.android.core;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class CodedOutputStream implements Flushable {
    private final byte[] buffer;
    private final int limit;
    private int position = 0;
    private final OutputStream tw;

    static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public static int D(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public static int E(boolean z) {
        return 1;
    }

    public static int F(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int l(float f) {
        return 4;
    }

    public static int q(long j) {
        return (j & -128) == 0 ? 1 : (j & -16384) == 0 ? 2 : (j & -2097152) == 0 ? 3 : (j & -268435456) == 0 ? 4 : (j & -34359738368L) == 0 ? 5 : (j & -4398046511104L) == 0 ? 6 : (j & -562949953421312L) == 0 ? 7 : (j & -72057594037927936L) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.tw = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static CodedOutputStream a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static CodedOutputStream a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void a(int i, float f) {
        p(i, 5);
        k(f);
    }

    public void a(int i, long j) {
        p(i, 0);
        n(j);
    }

    public void c(int i, boolean z) {
        p(i, 0);
        D(z);
    }

    public void a(int i, d dVar) {
        p(i, 2);
        a(dVar);
    }

    public void j(int i, int i2) {
        p(i, 0);
        t(i2);
    }

    public void k(int i, int i2) {
        p(i, 0);
        u(i2);
    }

    public void l(int i, int i2) {
        p(i, 0);
        v(i2);
    }

    public void k(float f) {
        E(Float.floatToRawIntBits(f));
    }

    public void n(long j) {
        p(j);
    }

    public void s(int i) {
        if (i >= 0) {
            C(i);
        } else {
            p((long) i);
        }
    }

    public void D(boolean z) {
        A(z);
    }

    public void a(d dVar) {
        C(dVar.size());
        c(dVar);
    }

    public void t(int i) {
        C(i);
    }

    public void u(int i) {
        s(i);
    }

    public void v(int i) {
        C(F(i));
    }

    public static int b(int i, float f) {
        return B(i) + l(f);
    }

    public static int b(int i, long j) {
        return B(i) + o(j);
    }

    public static int d(int i, boolean z) {
        return B(i) + E(z);
    }

    public static int b(int i, d dVar) {
        return B(i) + b(dVar);
    }

    public static int m(int i, int i2) {
        return B(i) + x(i2);
    }

    public static int n(int i, int i2) {
        return B(i) + y(i2);
    }

    public static int o(int i, int i2) {
        return B(i) + z(i2);
    }

    public static int o(long j) {
        return q(j);
    }

    public static int w(int i) {
        return i >= 0 ? D(i) : 10;
    }

    public static int b(d dVar) {
        return D(dVar.size()) + dVar.size();
    }

    public static int x(int i) {
        return D(i);
    }

    public static int y(int i) {
        return w(i);
    }

    public static int z(int i) {
        return D(F(i));
    }

    private void gR() {
        if (this.tw == null) {
            throw new OutOfSpaceException();
        }
        this.tw.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void flush() {
        if (this.tw != null) {
            gR();
        }
    }

    public void a(byte b) {
        if (this.position == this.limit) {
            gR();
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void A(int i) {
        a((byte) i);
    }

    public void c(d dVar) {
        a(dVar, 0, dVar.size());
    }

    public void j(byte[] bArr) {
        d(bArr, 0, bArr.length);
    }

    public void d(byte[] bArr, int i, int i2) {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        int i3 = this.limit - this.position;
        System.arraycopy(bArr, i, this.buffer, this.position, i3);
        i += i3;
        i2 -= i3;
        this.position = this.limit;
        gR();
        if (i2 <= this.limit) {
            System.arraycopy(bArr, i, this.buffer, 0, i2);
            this.position = i2;
            return;
        }
        this.tw.write(bArr, i, i2);
    }

    public void a(d dVar, int i, int i2) {
        if (this.limit - this.position >= i2) {
            dVar.a(this.buffer, i, this.position, i2);
            this.position += i2;
            return;
        }
        int i3 = this.limit - this.position;
        dVar.a(this.buffer, i, this.position, i3);
        i += i3;
        i2 -= i3;
        this.position = this.limit;
        gR();
        if (i2 <= this.limit) {
            dVar.a(this.buffer, i, 0, i2);
            this.position = i2;
            return;
        }
        InputStream gP = dVar.gP();
        long j = (long) i;
        if (j != gP.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i2 > 0) {
            i = Math.min(i2, this.limit);
            i3 = gP.read(this.buffer, 0, i);
            if (i3 != i) {
                throw new IllegalStateException("Read failed.");
            }
            this.tw.write(this.buffer, 0, i3);
            i2 -= i3;
        }
    }

    public void p(int i, int i2) {
        C(ax.q(i, i2));
    }

    public static int B(int i) {
        return D(ax.q(i, 0));
    }

    public void C(int i) {
        while ((i & -128) != 0) {
            A((i & 127) | 128);
            i >>>= 7;
        }
        A(i);
    }

    public void p(long j) {
        while ((j & -128) != 0) {
            A((((int) j) & 127) | 128);
            j >>>= 7;
        }
        A((int) j);
    }

    public void E(int i) {
        A(i & 255);
        A((i >> 8) & 255);
        A((i >> 16) & 255);
        A((i >> 24) & 255);
    }
}
