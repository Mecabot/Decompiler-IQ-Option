package com.google.common.hash;

import com.google.common.base.i;
import java.io.Serializable;

public abstract class HashCode {
    private static final char[] Uk = "0123456789abcdef".toCharArray();

    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) i.checkNotNull(bArr);
        }

        public int vd() {
            return this.bytes.length * 8;
        }

        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int ve() {
            i.b(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            return (((this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8)) | ((this.bytes[2] & 255) << 16)) | ((this.bytes[3] & 255) << 24);
        }

        public long vf() {
            i.b(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return vh();
        }

        public long vh() {
            long j = (long) (this.bytes[0] & 255);
            int i = 1;
            while (i < Math.min(this.bytes.length, 8)) {
                i++;
                j |= (((long) this.bytes[i]) & 255) << (i * 8);
            }
            return j;
        }

        byte[] vg() {
            return this.bytes;
        }

        boolean a(HashCode hashCode) {
            if (this.bytes.length != hashCode.vg().length) {
                return false;
            }
            boolean z = true;
            for (int i = 0; i < this.bytes.length; i++) {
                z &= this.bytes[i] == hashCode.vg()[i] ? 1 : 0;
            }
            return z;
        }
    }

    abstract boolean a(HashCode hashCode);

    public abstract byte[] asBytes();

    public abstract int vd();

    public abstract int ve();

    public abstract long vf();

    HashCode() {
    }

    byte[] vg() {
        return asBytes();
    }

    static HashCode m(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode cI(String str) {
        boolean z = true;
        i.a(str.length() >= 2, "input string (%s) must have at least 2 characters", (Object) str);
        if (str.length() % 2 != 0) {
            z = false;
        }
        i.a(z, "input string (%s) must have an even number of characters", (Object) str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((g(str.charAt(i)) << 4) + g(str.charAt(i + 1)));
        }
        return m(bArr);
    }

    private static int g(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal hexadecimal character: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (vd() == hashCode.vd() && a(hashCode)) {
            z = true;
        }
        return z;
    }

    public final int hashCode() {
        if (vd() >= 32) {
            return ve();
        }
        byte[] vg = vg();
        int i = vg[0] & 255;
        for (int i2 = 1; i2 < vg.length; i2++) {
            i |= (vg[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] vg = vg();
        StringBuilder stringBuilder = new StringBuilder(vg.length * 2);
        for (byte b : vg) {
            stringBuilder.append(Uk[(b >> 4) & 15]);
            stringBuilder.append(Uk[b & 15]);
        }
        return stringBuilder.toString();
    }
}
