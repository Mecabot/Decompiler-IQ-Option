package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;

public final class CodedOutputStream {
    private final byte[] buffer;
    private int eNL = 0;
    private final int limit;
    private int position;
    private final OutputStream tw;

    public static class OutOfSpaceException extends IOException {
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

    public static int aa(double d) {
        return 8;
    }

    public static int df(long j) {
        return 8;
    }

    public static int dg(long j) {
        return 8;
    }

    public static long dj(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int l(float f) {
        return 4;
    }

    static int lD(int i) {
        return i > 4096 ? 4096 : i;
    }

    public static int lG(int i) {
        return 4;
    }

    public static int lH(int i) {
        return 4;
    }

    public static int q(long j) {
        return (j & -128) == 0 ? 1 : (j & -16384) == 0 ? 2 : (j & -2097152) == 0 ? 3 : (j & -268435456) == 0 ? 4 : (j & -34359738368L) == 0 ? 5 : (j & -4398046511104L) == 0 ? 6 : (j & -562949953421312L) == 0 ? 7 : (j & -72057594037927936L) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.tw = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public static CodedOutputStream b(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void f(int i, double d) {
        p(i, 1);
        Z(d);
    }

    public void a(int i, float f) {
        p(i, 5);
        k(f);
    }

    public void bg(int i, int i2) {
        p(i, 0);
        s(i2);
    }

    public void c(int i, boolean z) {
        p(i, 0);
        D(z);
    }

    public void a(int i, n nVar) {
        p(i, 3);
        c(nVar);
        p(i, 4);
    }

    public void b(int i, n nVar) {
        p(i, 2);
        d(nVar);
    }

    public void a(int i, d dVar) {
        p(i, 2);
        b(dVar);
    }

    public void j(int i, int i2) {
        p(i, 0);
        t(i2);
    }

    public void k(int i, int i2) {
        p(i, 0);
        u(i2);
    }

    public void x(int i, long j) {
        p(i, 0);
        dd(j);
    }

    public void c(int i, n nVar) {
        p(1, 3);
        j(2, i);
        b(3, nVar);
        p(1, 4);
    }

    public void Z(double d) {
        di(Double.doubleToRawLongBits(d));
    }

    public void k(float f) {
        E(Float.floatToRawIntBits(f));
    }

    public void n(long j) {
        p(j);
    }

    public void da(long j) {
        p(j);
    }

    public void s(int i) {
        if (i >= 0) {
            C(i);
        } else {
            p((long) i);
        }
    }

    public void db(long j) {
        di(j);
    }

    public void lE(int i) {
        E(i);
    }

    public void D(boolean z) {
        A(z);
    }

    public void mJ(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        C(bytes.length);
        j(bytes);
    }

    public void c(n nVar) {
        nVar.a(this);
    }

    public void d(n nVar) {
        C(nVar.bjb());
        nVar.a(this);
    }

    public void b(d dVar) {
        C(dVar.size());
        d(dVar);
    }

    public void af(byte[] bArr) {
        C(bArr.length);
        j(bArr);
    }

    public void t(int i) {
        C(i);
    }

    public void u(int i) {
        s(i);
    }

    public void lF(int i) {
        E(i);
    }

    public void dc(long j) {
        di(j);
    }

    public void v(int i) {
        C(F(i));
    }

    public void dd(long j) {
        p(dj(j));
    }

    public static int g(int i, double d) {
        return B(i) + aa(d);
    }

    public static int b(int i, float f) {
        return B(i) + l(f);
    }

    public static int bh(int i, int i2) {
        return B(i) + w(i2);
    }

    public static int d(int i, boolean z) {
        return B(i) + E(z);
    }

    public static int d(int i, n nVar) {
        return B(i) + f(nVar);
    }

    public static int b(int i, d dVar) {
        return B(i) + c(dVar);
    }

    public static int n(int i, int i2) {
        return B(i) + y(i2);
    }

    public static int y(int i, long j) {
        return B(i) + dh(j);
    }

    public static int o(long j) {
        return q(j);
    }

    public static int de(long j) {
        return q(j);
    }

    public static int w(int i) {
        return i >= 0 ? D(i) : 10;
    }

    public static int mK(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return D(bytes.length) + bytes.length;
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int e(n nVar) {
        return nVar.bjb();
    }

    public static int f(n nVar) {
        int bjb = nVar.bjb();
        return D(bjb) + bjb;
    }

    public static int a(j jVar) {
        int bjb = jVar.bjb();
        return D(bjb) + bjb;
    }

    public static int c(d dVar) {
        return D(dVar.size()) + dVar.size();
    }

    public static int ag(byte[] bArr) {
        return D(bArr.length) + bArr.length;
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

    public static int dh(long j) {
        return q(dj(j));
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
        this.eNL++;
    }

    public void A(int i) {
        a((byte) i);
    }

    public void d(d dVar) {
        a(dVar, 0, dVar.size());
    }

    public void j(byte[] bArr) {
        d(bArr, 0, bArr.length);
    }

    public void d(byte[] bArr, int i, int i2) {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            this.eNL += i2;
            return;
        }
        int i3 = this.limit - this.position;
        System.arraycopy(bArr, i, this.buffer, this.position, i3);
        i += i3;
        i2 -= i3;
        this.position = this.limit;
        this.eNL += i3;
        gR();
        if (i2 <= this.limit) {
            System.arraycopy(bArr, i, this.buffer, 0, i2);
            this.position = i2;
        } else {
            this.tw.write(bArr, i, i2);
        }
        this.eNL += i2;
    }

    public void a(d dVar, int i, int i2) {
        if (this.limit - this.position >= i2) {
            dVar.a(this.buffer, i, this.position, i2);
            this.position += i2;
            this.eNL += i2;
            return;
        }
        int i3 = this.limit - this.position;
        dVar.a(this.buffer, i, this.position, i3);
        i += i3;
        i2 -= i3;
        this.position = this.limit;
        this.eNL += i3;
        gR();
        if (i2 <= this.limit) {
            dVar.a(this.buffer, i, 0, i2);
            this.position = i2;
        } else {
            dVar.a(this.tw, i, i2);
        }
        this.eNL += i2;
    }

    public void p(int i, int i2) {
        C(WireFormat.q(i, i2));
    }

    public static int B(int i) {
        return D(WireFormat.q(i, 0));
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

    public void di(long j) {
        A(((int) j) & 255);
        A(((int) (j >> 8)) & 255);
        A(((int) (j >> 16)) & 255);
        A(((int) (j >> 24)) & 255);
        A(((int) (j >> 32)) & 255);
        A(((int) (j >> 40)) & 255);
        A(((int) (j >> 48)) & 255);
        A(((int) (j >> 56)) & 255);
    }
}
