package org.jmrtd.io;

import java.io.IOException;
import java.io.InputStream;
import org.jmrtd.io.FragmentBuffer.Fragment;

/* compiled from: InputStreamBuffer */
public class a {
    private b fce;
    private FragmentBuffer fcf;

    /* compiled from: InputStreamBuffer */
    public class a extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int fcg = -1;
        private Object fch;
        private int position = 0;

        public void close() {
        }

        public boolean markSupported() {
            return true;
        }

        static {
            Class cls = a.class;
        }

        public a(Object obj) {
            this.fch = obj;
        }

        public int read() {
            synchronized (this.fch) {
                int i;
                if (this.position >= a.this.fcf.getLength()) {
                    return -1;
                } else if (a.this.fcf.mm(this.position)) {
                    byte[] buffer = a.this.fcf.getBuffer();
                    int i2 = this.position;
                    this.position = i2 + 1;
                    i = buffer[i2] & 255;
                    return i;
                } else {
                    if (a.this.fce.markSupported()) {
                        mo(this.position);
                    }
                    try {
                        i = a.this.fce.read();
                        if (i < 0) {
                            return -1;
                        }
                        FragmentBuffer a = a.this.fcf;
                        int i3 = this.position;
                        this.position = i3 + 1;
                        a.a(i3, (byte) i);
                        return i;
                    } catch (IOException e) {
                        throw e;
                    }
                }
            }
        }

        public int read(byte[] bArr) {
            int read;
            synchronized (this.fch) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            synchronized (this.fch) {
                if (bArr == null) {
                    throw new NullPointerException();
                } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                    throw new IndexOutOfBoundsException();
                } else if (i2 == 0) {
                    return 0;
                } else {
                    if (i2 > a.this.fcf.getLength() - this.position) {
                        i2 = a.this.fcf.getLength() - this.position;
                    }
                    if (this.position >= a.this.fcf.getLength()) {
                        return -1;
                    }
                    if (a.this.fce.markSupported()) {
                        mo(this.position);
                    }
                    Fragment bk = a.this.fcf.bk(this.position, i2);
                    if (bk.getLength() > 0) {
                        i2 = bk.getOffset() - this.position;
                        int length = bk.getLength();
                        System.arraycopy(a.this.fcf.getBuffer(), this.position, bArr, i, i2);
                        this.position += i2;
                        if (a.this.fce.markSupported()) {
                            mo(this.position);
                        }
                        i += i2;
                        length = a.this.fce.read(bArr, i, length);
                        a.this.fcf.g(bk.getOffset(), bArr, i, length);
                        this.position += length;
                        i2 += length;
                        return i2;
                    }
                    i2 = Math.min(i2, a.this.fcf.getLength() - this.position);
                    System.arraycopy(a.this.fcf.getBuffer(), this.position, bArr, i, i2);
                    this.position += i2;
                    return i2;
                }
            }
        }

        public long skip(long j) {
            synchronized (this.fch) {
                int mn = a.this.fcf.mn(this.position);
                long j2 = (long) mn;
                if (j <= j2) {
                    this.position = (int) (((long) this.position) + j);
                    return j;
                }
                this.position += mn;
                if (a.this.fce.markSupported()) {
                    mo(this.position);
                    j = a.this.fce.skip(j - j2);
                    this.position += (int) j;
                } else {
                    j = super.skip(j - j2);
                }
                long j3 = j2 + j;
                return j3;
            }
        }

        public int available() {
            return a.this.fcf.mn(this.position);
        }

        public synchronized void mark(int i) {
            this.fcg = this.position;
        }

        public synchronized void reset() {
            if (this.fcg < 0) {
                throw new IOException("Invalid reset, was mark() called?");
            }
            this.position = this.fcg;
        }

        private void mo(int i) {
            long j = (long) i;
            if (j != a.this.fce.getPosition()) {
                a.this.fce.reset();
                int i2 = 0;
                while (i2 < i) {
                    long j2 = (long) i2;
                    i2 = (int) (j2 + a.this.fce.skip(j - j2));
                }
            }
        }
    }

    public a(InputStream inputStream, int i) {
        this.fce = new b(inputStream);
        this.fce.mark(i);
        this.fcf = new FragmentBuffer(i);
    }

    public a bAF() {
        a aVar;
        synchronized (this.fce) {
            aVar = new a(this.fce);
        }
        return aVar;
    }

    public int getLength() {
        return this.fcf.getLength();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InputStreamBuffer [");
        stringBuilder.append(this.fcf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
