package org.jmrtd;

import org.jmrtd.protocol.d;

public class PACEKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -7113246293247012560L;
    private byte[] key;
    private byte keyReference;

    public PACEKeySpec(byte[] bArr, byte b) {
        this.keyReference = b;
        this.key = bArr;
    }

    public static PACEKeySpec a(BACKeySpec bACKeySpec) {
        return new PACEKeySpec(d.a(bACKeySpec), (byte) 1);
    }

    public byte bAy() {
        return this.keyReference;
    }

    public byte[] getKey() {
        return this.key;
    }
}
