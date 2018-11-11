package jumio.nv.nfc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ISRandomAccessIO */
public class dr implements df {
    private InputStream a;
    private int b;
    private int c;
    private byte[] d;
    private int e;
    private int f;
    private boolean g;

    public dr(InputStream inputStream, int i, int i2, int i3) {
        if (i < 0 || i2 <= 0 || i3 <= 0 || inputStream == null) {
            throw new IllegalArgumentException();
        }
        this.a = inputStream;
        if (i < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            i++;
        }
        this.d = new byte[i];
        this.c = i2;
        if (i3 < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            i3++;
        }
        this.b = i3;
        this.f = 0;
        this.e = 0;
        this.g = false;
    }

    public dr(InputStream inputStream) {
        this(inputStream, 262144, 262144, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private void h() {
        int i = this.c;
        if (this.d.length + i > this.b) {
            i = this.b - this.d.length;
        }
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reached maximum cache size (");
            stringBuilder.append(this.b);
            stringBuilder.append(")");
            throw new IOException(stringBuilder.toString());
        }
        try {
            Object obj = new byte[(this.d.length + this.c)];
            System.arraycopy(this.d, 0, obj, 0, this.e);
            this.d = obj;
        } catch (OutOfMemoryError unused) {
            throw new IOException("Out of memory to cache input data");
        }
    }

    private void i() {
        if (this.g) {
            throw new IllegalArgumentException("Already reached EOF");
        }
        int read;
        int available = this.a.available();
        if (available == 0) {
            available = 1;
        }
        while (this.e + available > this.d.length) {
            h();
        }
        do {
            read = this.a.read(this.d, this.e, available);
            if (read > 0) {
                this.e += read;
                available -= read;
            }
            if (available <= 0) {
                break;
            }
        } while (read > 0);
        if (read <= 0) {
            this.g = true;
            this.a.close();
            this.a = null;
        }
    }

    public int e() {
        return this.f;
    }

    public void a(int i) {
        if (!this.g || i <= this.e) {
            this.f = i;
            return;
        }
        throw new EOFException();
    }

    public int f() {
        while (!this.g) {
            i();
        }
        return this.e;
    }

    public int g() {
        byte[] bArr;
        int i;
        if (this.f < this.e) {
            bArr = this.d;
            i = this.f;
            this.f = i + 1;
            return bArr[i] & 255;
        }
        while (!this.g && this.f >= this.e) {
            i();
        }
        if (this.f == this.e) {
            throw new EOFException();
        } else if (this.f > this.e) {
            throw new IOException("Position beyond EOF");
        } else {
            bArr = this.d;
            i = this.f;
            this.f = i + 1;
            return bArr[i] & 255;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f + i2 <= this.e) {
            System.arraycopy(this.d, this.f, bArr, i, i2);
            this.f += i2;
            return;
        }
        while (!this.g && this.f + i2 > this.e) {
            i();
        }
        if (this.f + i2 > this.e) {
            throw new EOFException();
        }
        System.arraycopy(this.d, this.f, bArr, i, i2);
        this.f += i2;
    }

    public short a() {
        if (this.f + 1 >= this.e) {
            return (short) ((g() << 8) | g());
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        int i2 = bArr[i] << 8;
        byte[] bArr2 = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        return (short) (i2 | (bArr2[i3] & 255));
    }

    public int b() {
        if (this.f + 1 >= this.e) {
            return (g() << 8) | g();
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int c() {
        if (this.f + 3 >= this.e) {
            return (((g() << 24) | (g() << 16)) | (g() << 8)) | g();
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        int i2 = bArr[i] << 24;
        byte[] bArr2 = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.d;
        i3 = this.f;
        this.f = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.d;
        i3 = this.f;
        this.f = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public long d() {
        if (this.f + 7 >= this.e) {
            return (((((((((long) g()) << 56) | (((long) g()) << 48)) | (((long) g()) << 40)) | (((long) g()) << 32)) | (((long) g()) << 24)) | (((long) g()) << 16)) | (((long) g()) << 8)) | ((long) g());
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        long j = ((long) bArr[i]) << 56;
        byte[] bArr2 = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        long j2 = j | (((long) (bArr2[i2] & 255)) << 48);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        long j3 = j2 | (((long) (bArr[i] & 255)) << 40);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        long j4 = j3 | (((long) (bArr[i] & 255)) << 32);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        long j5 = j4 | (((long) (bArr[i] & 255)) << 24);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        j3 = j5 | (((long) (bArr[i] & 255)) << 16);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        long j6 = j3 | (((long) (bArr[i] & 255)) << 8);
        bArr = this.d;
        i = this.f;
        this.f = i + 1;
        return j6 | ((long) (bArr[i] & 255));
    }
}
