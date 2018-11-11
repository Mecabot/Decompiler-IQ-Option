package org.jmrtd.io;

import java.io.InputStream;
import org.jmrtd.io.a.a;

/* compiled from: SplittableInputStream */
public class c extends InputStream {
    private a fcm;
    private a fcn = this.fcm.bAF();

    public c(InputStream inputStream, int i) {
        this.fcm = new a(inputStream, i);
    }

    public InputStream hI(int i) {
        try {
            InputStream bAF = this.fcm.bAF();
            long j = 0;
            while (true) {
                long j2 = (long) i;
                if (j >= j2) {
                    return bAF;
                }
                j += bAF.skip(j2 - j);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public int read() {
        return this.fcn.read();
    }

    public long skip(long j) {
        return this.fcn.skip(j);
    }

    public int available() {
        return this.fcn.available();
    }

    public void close() {
        this.fcn.close();
    }

    public synchronized void mark(int i) {
        this.fcn.mark(i);
    }

    public synchronized void reset() {
        this.fcn.reset();
    }

    public boolean markSupported() {
        return this.fcn.markSupported();
    }

    public int getLength() {
        return this.fcm.getLength();
    }
}
