package com.google.common.io;

import com.google.common.base.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ByteStreams */
public final class c {
    private static final OutputStream Un = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i) {
        }

        public void write(byte[] bArr) {
            i.checkNotNull(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            i.checkNotNull(bArr);
        }
    };

    static byte[] vj() {
        return new byte[8192];
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        i.checkNotNull(inputStream);
        i.checkNotNull(outputStream);
        byte[] vj = vj();
        long j = 0;
        while (true) {
            int read = inputStream.read(vj);
            if (read == -1) {
                return j;
            }
            outputStream.write(vj, 0, read);
            j += (long) read;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, inputStream.available()));
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
