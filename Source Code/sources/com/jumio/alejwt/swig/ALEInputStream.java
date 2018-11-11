package com.jumio.alejwt.swig;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALEInputStream extends FilterInputStream {
    private ALERequest aleRequest = null;
    private boolean done = false;
    private byte[] ibuffer = new byte[512];
    private InputStream input;
    private byte[] obuffer;
    private int ofinish = 0;
    private int ostart = 0;

    public boolean markSupported() {
        return false;
    }

    private int getMoreData() {
        if (this.done) {
            return -1;
        }
        int read = this.input.read(this.ibuffer);
        if (read == -1) {
            this.done = true;
            try {
                this.aleRequest.finishResponse();
                return read;
            } catch (Throwable e) {
                throw new IOException(e);
            }
        }
        try {
            if (read != this.ibuffer.length) {
                Object obj = new byte[read];
                System.arraycopy(this.ibuffer, 0, obj, 0, read);
                this.obuffer = new byte[(obj.length + 32)];
                read = this.aleRequest.updateResponse(obj, this.obuffer);
            } else {
                this.obuffer = new byte[(this.ibuffer.length + 32)];
                read = this.aleRequest.updateResponse(this.ibuffer, this.obuffer);
            }
            this.ostart = 0;
            if (this.obuffer == null) {
                this.ofinish = 0;
            } else {
                this.ofinish = read;
            }
            return this.ofinish;
        } catch (Throwable e2) {
            this.obuffer = null;
            throw new IOException(e2);
        }
    }

    public ALEInputStream(InputStream inputStream, ALERequest aLERequest) {
        super(inputStream);
        this.input = inputStream;
        this.aleRequest = aLERequest;
        aLERequest.initResponse();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        if (this.ostart >= this.ofinish) {
            i3 = 0;
            while (i3 == 0) {
                i3 = getMoreData();
            }
            if (i3 == -1) {
                return -1;
            }
        }
        if (i2 <= 0) {
            return 0;
        }
        i3 = this.ofinish - this.ostart;
        if (i2 >= i3) {
            i2 = i3;
        }
        if (bArr != null) {
            System.arraycopy(this.obuffer, this.ostart, bArr, i, i2);
        }
        this.ostart += i2;
        return i2;
    }

    public long skip(long j) {
        long j2 = (long) (this.ofinish - this.ostart);
        if (j > j2) {
            j = j2;
        }
        if (j < 0) {
            return 0;
        }
        this.ostart = (int) (((long) this.ostart) + j);
        return j;
    }

    public int available() {
        return this.ofinish - this.ostart;
    }

    public void close() {
        this.input.close();
        try {
            if (!this.done) {
                this.aleRequest.finishResponse();
            }
            this.ostart = 0;
            this.ofinish = 0;
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
