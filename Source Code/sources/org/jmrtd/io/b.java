package org.jmrtd.io;

import java.io.InputStream;
import java.util.logging.Logger;

/* compiled from: PositionInputStream */
public class b extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private InputStream fcj;
    private long fck = 0;
    private long fcl = -1;

    public b(InputStream inputStream) {
        this.fcj = inputStream;
    }

    public int read() {
        int read = this.fcj.read();
        if (read >= 0) {
            this.fck++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.fcj.read(bArr, i, i2);
        this.fck += (long) read;
        return read;
    }

    public long skip(long j) {
        long skip = this.fcj.skip(j);
        if (skip <= 0) {
            Logger logger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Carrier (");
            stringBuilder.append(this.fcj.getClass().getCanonicalName());
            stringBuilder.append(")'s skip(");
            stringBuilder.append(j);
            stringBuilder.append(") only skipped ");
            stringBuilder.append(skip);
            stringBuilder.append(", position = ");
            stringBuilder.append(this.fck);
            logger.warning(stringBuilder.toString());
        }
        this.fck += skip;
        return skip;
    }

    public void mark(int i) {
        this.fcj.mark(i);
        this.fcl = this.fck;
    }

    public void reset() {
        this.fcj.reset();
        this.fck = this.fcl;
    }

    public boolean markSupported() {
        return this.fcj.markSupported();
    }

    public long getPosition() {
        return this.fck;
    }
}
