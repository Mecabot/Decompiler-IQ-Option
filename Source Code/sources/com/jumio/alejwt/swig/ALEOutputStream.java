package com.jumio.alejwt.swig;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ALEOutputStream extends FilterOutputStream {
    private ALERequest aleRequest;
    private boolean closed;
    private byte[] obuffer;
    private int obufferLen;
    private OutputStream outputStream;

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, int i) {
        this(outputStream, aLERequest, null, i);
    }

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, ALEHeader aLEHeader, int i) {
        super(outputStream);
        this.aleRequest = null;
        this.obufferLen = 0;
        this.closed = false;
        this.outputStream = outputStream;
        this.aleRequest = aLERequest;
        this.obuffer = new byte[aLERequest.calculateRequestInit(aLEHeader, i)];
        this.obufferLen = aLERequest.initRequest(aLEHeader, i, this.obuffer);
        outputStream.write(this.obuffer, 0, this.obufferLen);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i == 0 && i2 == bArr.length) {
            write(bArr);
            return;
        }
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        write(obj);
    }

    public void write(byte[] bArr) {
        this.obuffer = new byte[this.aleRequest.calculateRequestUpdate(bArr.length)];
        try {
            this.obufferLen = this.aleRequest.updateRequest(bArr, this.obuffer);
            if (this.obuffer != null) {
                this.outputStream.write(this.obuffer, 0, this.obufferLen);
                this.obuffer = null;
                this.obufferLen = 0;
            }
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    public void flush() {
        if (this.obuffer != null) {
            this.outputStream.write(this.obuffer, 0, this.obufferLen);
            this.obuffer = null;
        }
        this.outputStream.flush();
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            try {
                this.obuffer = new byte[this.aleRequest.calculateRequestFinish()];
                this.obufferLen = this.aleRequest.finishRequest(this.obuffer);
            } catch (Exception unused) {
                this.obuffer = null;
                this.obufferLen = 0;
            }
            try {
                flush();
            } catch (IOException unused2) {
                this.outputStream.close();
            }
        }
    }
}
