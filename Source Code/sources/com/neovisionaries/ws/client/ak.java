package com.neovisionaries.ws.client;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: WebSocketInputStream */
class ak extends FilterInputStream {
    public ak(InputStream inputStream) {
        super(inputStream);
    }

    public String readLine() {
        return p.a((InputStream) this, "UTF-8");
    }

    public aj aQA() {
        byte[] bArr = new byte[8];
        try {
            k(bArr, 2);
            boolean z = (bArr[0] & 128) != 0;
            boolean z2 = (bArr[0] & 64) != 0;
            boolean z3 = (bArr[0] & 32) != 0;
            boolean z4 = (bArr[0] & 16) != 0;
            int i = bArr[0] & 15;
            boolean z5 = (bArr[1] & 128) != 0;
            long j = (long) (bArr[1] & 127);
            if (j == 126) {
                k(bArr, 2);
                j = (long) (((bArr[0] & 255) << 8) | (bArr[1] & 255));
            } else if (j == 127) {
                k(bArr, 8);
                if ((bArr[0] & 128) != 0) {
                    throw new WebSocketException(WebSocketError.INVALID_PAYLOAD_LENGTH, "The payload length of a frame is invalid.");
                }
                j = (long) ((((bArr[6] & 255) << 8) | ((((((bArr[2] & 255) << 40) | (((bArr[0] & 255) << 56) | ((bArr[1] & 255) << 48))) | ((bArr[3] & 255) << 32)) | ((bArr[4] & 255) << 24)) | ((bArr[5] & 255) << 16))) | (bArr[7] & 255));
            }
            byte[] bArr2 = null;
            if (z5) {
                bArr2 = new byte[4];
                k(bArr2, 4);
            }
            if (2147483647L < j) {
                cG(j);
                throw new WebSocketException(WebSocketError.TOO_LONG_PAYLOAD, "The payload length of a frame exceeds the maximum array size in Java.");
            }
            return new aj().fS(z).fT(z2).fU(z3).fV(z4).ik(i).fW(z5).C(a(j, z5, bArr2));
        } catch (InsufficientDataException e) {
            if (e.aQn() == 0) {
                throw new NoMoreFrameException();
            }
            throw e;
        }
    }

    void k(byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int read = read(bArr, i2, i - i2);
            if (read <= 0) {
                throw new InsufficientDataException(i, i2);
            }
            i2 += read;
        }
    }

    private void cG(long j) {
        try {
            skip(j);
        } catch (IOException unused) {
        }
    }

    private byte[] a(long j, boolean z, byte[] bArr) {
        if (j == 0) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[((int) j)];
            k(bArr2, bArr2.length);
            if (z) {
                aj.a(bArr, bArr2);
            }
            return bArr2;
        } catch (Throwable e) {
            cG(j);
            WebSocketError webSocketError = WebSocketError.INSUFFICIENT_MEMORY_FOR_PAYLOAD;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OutOfMemoryError occurred during a trial to allocate a memory area for a frame's payload: ");
            stringBuilder.append(e.getMessage());
            throw new WebSocketException(webSocketError, stringBuilder.toString(), e);
        }
    }
}
