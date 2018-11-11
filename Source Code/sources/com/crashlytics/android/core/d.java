package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteString */
final class d {
    public static final d tp = new d(new byte[0]);
    private final byte[] bytes;
    private volatile int hash = 0;

    private d(byte[] bArr) {
        this.bytes = bArr;
    }

    public int size() {
        return this.bytes.length;
    }

    public static d c(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new d(obj);
    }

    public static d aS(String str) {
        try {
            return new d(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        int length = this.bytes.length;
        if (length != dVar.bytes.length) {
            return false;
        }
        byte[] bArr = this.bytes;
        byte[] bArr2 = dVar.bytes;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            byte[] bArr = this.bytes;
            int length = this.bytes.length;
            int i2 = length;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + bArr[i3];
            }
            i = i2 == 0 ? 1 : i2;
            this.hash = i;
        }
        return i;
    }

    public InputStream gP() {
        return new ByteArrayInputStream(this.bytes);
    }
}
