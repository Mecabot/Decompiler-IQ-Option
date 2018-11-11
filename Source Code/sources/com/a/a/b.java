package com.a.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class b implements Closeable {
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.US_ASCII)) {
            this.in = inputStream;
            this.charset = charset;
            this.buf = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0032, code:
            if (r7.buf[r3] == (byte) 13) goto L_0x0036;
     */
    public java.lang.String readLine() {
        /*
        r7 = this;
        r0 = r7.in;
        monitor-enter(r0);
        r1 = r7.buf;	 Catch:{ all -> 0x0097 }
        if (r1 != 0) goto L_0x000f;
    L_0x0007:
        r1 = new java.io.IOException;	 Catch:{ all -> 0x0097 }
        r2 = "LineReader is closed";
        r1.<init>(r2);	 Catch:{ all -> 0x0097 }
        throw r1;	 Catch:{ all -> 0x0097 }
    L_0x000f:
        r1 = r7.pos;	 Catch:{ all -> 0x0097 }
        r2 = r7.end;	 Catch:{ all -> 0x0097 }
        if (r1 < r2) goto L_0x0018;
    L_0x0015:
        r7.aOB();	 Catch:{ all -> 0x0097 }
    L_0x0018:
        r1 = r7.pos;	 Catch:{ all -> 0x0097 }
    L_0x001a:
        r2 = r7.end;	 Catch:{ all -> 0x0097 }
        r3 = 10;
        if (r1 == r2) goto L_0x0051;
    L_0x0020:
        r2 = r7.buf;	 Catch:{ all -> 0x0097 }
        r2 = r2[r1];	 Catch:{ all -> 0x0097 }
        if (r2 != r3) goto L_0x004e;
    L_0x0026:
        r2 = r7.pos;	 Catch:{ all -> 0x0097 }
        if (r1 == r2) goto L_0x0035;
    L_0x002a:
        r2 = r7.buf;	 Catch:{ all -> 0x0097 }
        r3 = r1 + -1;
        r2 = r2[r3];	 Catch:{ all -> 0x0097 }
        r4 = 13;
        if (r2 != r4) goto L_0x0035;
    L_0x0034:
        goto L_0x0036;
    L_0x0035:
        r3 = r1;
    L_0x0036:
        r2 = new java.lang.String;	 Catch:{ all -> 0x0097 }
        r4 = r7.buf;	 Catch:{ all -> 0x0097 }
        r5 = r7.pos;	 Catch:{ all -> 0x0097 }
        r6 = r7.pos;	 Catch:{ all -> 0x0097 }
        r3 = r3 - r6;
        r6 = r7.charset;	 Catch:{ all -> 0x0097 }
        r6 = r6.name();	 Catch:{ all -> 0x0097 }
        r2.<init>(r4, r5, r3, r6);	 Catch:{ all -> 0x0097 }
        r1 = r1 + 1;
        r7.pos = r1;	 Catch:{ all -> 0x0097 }
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        return r2;
    L_0x004e:
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x0051:
        r1 = new com.a.a.b$1;	 Catch:{ all -> 0x0097 }
        r2 = r7.end;	 Catch:{ all -> 0x0097 }
        r4 = r7.pos;	 Catch:{ all -> 0x0097 }
        r2 = r2 - r4;
        r2 = r2 + 80;
        r1.<init>(r2);	 Catch:{ all -> 0x0097 }
    L_0x005d:
        r2 = r7.buf;	 Catch:{ all -> 0x0097 }
        r4 = r7.pos;	 Catch:{ all -> 0x0097 }
        r5 = r7.end;	 Catch:{ all -> 0x0097 }
        r6 = r7.pos;	 Catch:{ all -> 0x0097 }
        r5 = r5 - r6;
        r1.write(r2, r4, r5);	 Catch:{ all -> 0x0097 }
        r2 = -1;
        r7.end = r2;	 Catch:{ all -> 0x0097 }
        r7.aOB();	 Catch:{ all -> 0x0097 }
        r2 = r7.pos;	 Catch:{ all -> 0x0097 }
    L_0x0071:
        r4 = r7.end;	 Catch:{ all -> 0x0097 }
        if (r2 == r4) goto L_0x005d;
    L_0x0075:
        r4 = r7.buf;	 Catch:{ all -> 0x0097 }
        r4 = r4[r2];	 Catch:{ all -> 0x0097 }
        if (r4 != r3) goto L_0x0094;
    L_0x007b:
        r3 = r7.pos;	 Catch:{ all -> 0x0097 }
        if (r2 == r3) goto L_0x008a;
    L_0x007f:
        r3 = r7.buf;	 Catch:{ all -> 0x0097 }
        r4 = r7.pos;	 Catch:{ all -> 0x0097 }
        r5 = r7.pos;	 Catch:{ all -> 0x0097 }
        r5 = r2 - r5;
        r1.write(r3, r4, r5);	 Catch:{ all -> 0x0097 }
    L_0x008a:
        r2 = r2 + 1;
        r7.pos = r2;	 Catch:{ all -> 0x0097 }
        r1 = r1.toString();	 Catch:{ all -> 0x0097 }
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        return r1;
    L_0x0094:
        r2 = r2 + 1;
        goto L_0x0071;
    L_0x0097:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.readLine():java.lang.String");
    }

    private void aOB() {
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }
}
