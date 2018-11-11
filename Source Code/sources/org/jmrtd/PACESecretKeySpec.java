package org.jmrtd;

import javax.crypto.spec.SecretKeySpec;

public class PACESecretKeySpec extends SecretKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -5181060361947453857L;
    private byte keyReference;

    public PACESecretKeySpec(byte[] bArr, String str, byte b) {
        super(bArr, str);
        this.keyReference = b;
    }

    public byte bAy() {
        return this.keyReference;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.keyReference;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.keyReference != ((PACESecretKeySpec) obj).keyReference) {
            z = false;
        }
        return z;
    }
}
