package com.neovisionaries.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* compiled from: DeflateCompressor */
class e {
    public static byte[] t(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater aQg = aQg();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, aQg);
        deflaterOutputStream.write(bArr, 0, bArr.length);
        deflaterOutputStream.close();
        aQg.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static Deflater aQg() {
        return new Deflater(-1, true);
    }
}
