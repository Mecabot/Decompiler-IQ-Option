package org.jmrtd.protocol;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.Arrays;
import net.sf.scuba.util.Hex;
import org.jmrtd.d;

public class AAResult implements Serializable {
    private static final long serialVersionUID = 8800803919646625713L;
    private byte[] challenge;
    private String digestAlgorithm;
    private PublicKey publicKey;
    private byte[] response;
    private String signatureAlgorithm;

    public AAResult(PublicKey publicKey, String str, String str2, byte[] bArr, byte[] bArr2) {
        this.publicKey = publicKey;
        this.digestAlgorithm = str;
        this.signatureAlgorithm = str2;
        this.challenge = bArr;
        this.response = bArr2;
    }

    public byte[] bBO() {
        return this.response;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AAResult [");
        stringBuilder.append("publicKey: ");
        stringBuilder.append(d.a(this.publicKey));
        stringBuilder.append(", digestAlgorithm: ");
        stringBuilder.append(this.digestAlgorithm);
        stringBuilder.append(", signatureAlgorithm: ");
        stringBuilder.append(this.signatureAlgorithm);
        stringBuilder.append(", challenge: ");
        stringBuilder.append(Hex.bytesToHexString(this.challenge));
        stringBuilder.append(", response: ");
        stringBuilder.append(Hex.bytesToHexString(this.response));
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((1303377669 + Arrays.hashCode(this.challenge)) * 1991) + (this.digestAlgorithm == null ? 0 : this.digestAlgorithm.hashCode())) * 1991) + (this.publicKey == null ? 0 : this.publicKey.hashCode())) * 1991) + Arrays.hashCode(this.response)) * 1991;
        if (this.signatureAlgorithm != null) {
            i = this.signatureAlgorithm.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AAResult aAResult = (AAResult) obj;
        if (!Arrays.equals(this.challenge, aAResult.challenge)) {
            return false;
        }
        if (this.digestAlgorithm == null) {
            if (aAResult.digestAlgorithm != null) {
                return false;
            }
        } else if (!this.digestAlgorithm.equals(aAResult.digestAlgorithm)) {
            return false;
        }
        if (this.publicKey == null) {
            if (aAResult.publicKey != null) {
                return false;
            }
        } else if (!this.publicKey.equals(aAResult.publicKey)) {
            return false;
        }
        if (!Arrays.equals(this.response, aAResult.response)) {
            return false;
        }
        if (this.signatureAlgorithm == null) {
            if (aAResult.signatureAlgorithm != null) {
                return false;
            }
        } else if (!this.signatureAlgorithm.equals(aAResult.signatureAlgorithm)) {
            return false;
        }
        return true;
    }
}
