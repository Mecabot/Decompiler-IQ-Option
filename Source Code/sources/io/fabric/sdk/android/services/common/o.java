package io.fabric.sdk.android.services.common;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.WritableByteChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class o implements Closeable {
    private static final Logger LOGGER = Logger.getLogger(o.class.getName());
    private final byte[] buffer = new byte[16];
    private int elementCount;
    private final RandomAccessFile enp;
    int enq;
    private a enr;
    private a ens;

    /* compiled from: QueueFile */
    static class a {
        static final a env = new a(0, 0);
        final int length;
        final int position;

        a(int i, int i2) {
            this.position = i;
            this.length = i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("[position = ");
            stringBuilder.append(this.position);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.length);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: QueueFile */
    private final class b extends InputStream {
        private int Rc;
        private int position;

        /* synthetic */ b(o oVar, a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private b(a aVar) {
            this.position = o.this.iV(aVar.position + 4);
            this.Rc = aVar.length;
        }

        public int read(byte[] bArr, int i, int i2) {
            o.b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.Rc <= 0) {
                return -1;
            } else {
                if (i2 > this.Rc) {
                    i2 = this.Rc;
                }
                o.this.d(this.position, bArr, i, i2);
                this.position = o.this.iV(this.position + i2);
                this.Rc -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.Rc == 0) {
                return -1;
            }
            o.this.enp.seek((long) this.position);
            int read = o.this.enp.read();
            this.position = o.this.iV(this.position + 1);
            this.Rc--;
            return read;
        }
    }

    /* compiled from: QueueFile */
    public interface c {
        void a(InputStream inputStream, int i);
    }

    public o(File file) {
        if (!file.exists()) {
            w(file);
        }
        this.enp = x(file);
        readHeader();
    }

    private static void j(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int j : iArr) {
            j(bArr, i, j);
            i += 4;
        }
    }

    private static int readInt(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void readHeader() {
        this.enp.seek(0);
        this.enp.readFully(this.buffer);
        this.enq = readInt(this.buffer, 0);
        if (((long) this.enq) > this.enp.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File is truncated. Expected length: ");
            stringBuilder.append(this.enq);
            stringBuilder.append(", Actual length: ");
            stringBuilder.append(this.enp.length());
            throw new IOException(stringBuilder.toString());
        }
        this.elementCount = readInt(this.buffer, 4);
        int readInt = readInt(this.buffer, 8);
        int readInt2 = readInt(this.buffer, 12);
        this.enr = iU(readInt);
        this.ens = iU(readInt2);
    }

    private void k(int i, int i2, int i3, int i4) {
        a(this.buffer, i, i2, i3, i4);
        this.enp.seek(0);
        this.enp.write(this.buffer);
    }

    private a iU(int i) {
        if (i == 0) {
            return a.env;
        }
        this.enp.seek((long) i);
        return new a(i, this.enp.readInt());
    }

    private static void w(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".tmp");
        File file2 = new File(stringBuilder.toString());
        RandomAccessFile x = x(file2);
        try {
            x.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            x.seek(0);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            x.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            x.close();
        }
    }

    private static RandomAccessFile x(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int iV(int i) {
        return i < this.enq ? i : (i + 16) - this.enq;
    }

    private void c(int i, byte[] bArr, int i2, int i3) {
        i = iV(i);
        if (i + i3 <= this.enq) {
            this.enp.seek((long) i);
            this.enp.write(bArr, i2, i3);
            return;
        }
        int i4 = this.enq - i;
        this.enp.seek((long) i);
        this.enp.write(bArr, i2, i4);
        this.enp.seek(16);
        this.enp.write(bArr, i2 + i4, i3 - i4);
    }

    private void d(int i, byte[] bArr, int i2, int i3) {
        i = iV(i);
        if (i + i3 <= this.enq) {
            this.enp.seek((long) i);
            this.enp.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.enq - i;
        this.enp.seek((long) i);
        this.enp.readFully(bArr, i2, i4);
        this.enp.seek(16);
        this.enp.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void aa(byte[] bArr) {
        k(bArr, 0, bArr.length);
    }

    public synchronized void k(byte[] bArr, int i, int i2) {
        b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        iW(i2);
        boolean isEmpty = isEmpty();
        if (isEmpty) {
            i3 = 16;
        } else {
            i3 = iV((this.ens.position + 4) + this.ens.length);
        }
        a aVar = new a(i3, i2);
        j(this.buffer, 0, i2);
        c(aVar.position, this.buffer, 0, 4);
        c(aVar.position + 4, bArr, i, i2);
        k(this.enq, this.elementCount + 1, isEmpty ? aVar.position : this.enr.position, aVar.position);
        this.ens = aVar;
        this.elementCount++;
        if (isEmpty) {
            this.enr = this.ens;
        }
    }

    public int aUP() {
        if (this.elementCount == 0) {
            return 16;
        }
        if (this.ens.position >= this.enr.position) {
            return (((this.ens.position - this.enr.position) + 4) + this.ens.length) + 16;
        }
        return (((this.ens.position + 4) + this.ens.length) + this.enq) - this.enr.position;
    }

    private int aUQ() {
        return this.enq - aUP();
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    private void iW(int i) {
        i += 4;
        int aUQ = aUQ();
        if (aUQ < i) {
            int i2 = this.enq;
            do {
                aUQ += i2;
                i2 <<= 1;
            } while (aUQ < i);
            setLength(i2);
            i = iV((this.ens.position + 4) + this.ens.length);
            if (i < this.enr.position) {
                WritableByteChannel channel = this.enp.getChannel();
                channel.position((long) this.enq);
                long j = (long) (i - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.ens.position < this.enr.position) {
                i = (this.enq + this.ens.position) - 16;
                k(i2, this.elementCount, this.enr.position, i);
                this.ens = new a(i, this.ens.length);
            } else {
                k(i2, this.elementCount, this.enr.position, this.ens.position);
            }
            this.enq = i2;
        }
    }

    private void setLength(int i) {
        this.enp.setLength((long) i);
        this.enp.getChannel().force(true);
    }

    public synchronized void a(c cVar) {
        int i = this.enr.position;
        for (int i2 = 0; i2 < this.elementCount; i2++) {
            a iU = iU(i);
            cVar.a(new b(this, iU, null), iU.length);
            i = iV((iU.position + 4) + iU.length);
        }
    }

    private static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.elementCount == 1) {
            clear();
        } else {
            int iV = iV((this.enr.position + 4) + this.enr.length);
            d(iV, this.buffer, 0, 4);
            int readInt = readInt(this.buffer, 0);
            k(this.enq, this.elementCount - 1, iV, this.ens.position);
            this.elementCount--;
            this.enr = new a(iV, readInt);
        }
    }

    public synchronized void clear() {
        k(4096, 0, 0, 0);
        this.elementCount = 0;
        this.enr = a.env;
        this.ens = a.env;
        if (this.enq > 4096) {
            setLength(4096);
        }
        this.enq = 4096;
    }

    public synchronized void close() {
        this.enp.close();
    }

    public boolean aW(int i, int i2) {
        return (aUP() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.enq);
        stringBuilder.append(", size=");
        stringBuilder.append(this.elementCount);
        stringBuilder.append(", first=");
        stringBuilder.append(this.enr);
        stringBuilder.append(", last=");
        stringBuilder.append(this.ens);
        stringBuilder.append(", element lengths=[");
        try {
            a(new c() {
                boolean ent = true;

                public void a(InputStream inputStream, int i) {
                    if (this.ent) {
                        this.ent = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
