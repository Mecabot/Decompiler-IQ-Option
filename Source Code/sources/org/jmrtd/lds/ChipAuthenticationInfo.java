package org.jmrtd.lds;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DLSequence;

public class ChipAuthenticationInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 5591988305059068535L;
    private BigInteger keyId;
    private String oid;
    private int version;

    public ChipAuthenticationInfo(String str, int i) {
        this(str, i, null);
    }

    public ChipAuthenticationInfo(String str, int i, BigInteger bigInteger) {
        this.oid = str;
        this.version = i;
        this.keyId = bigInteger;
        bAN();
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.keyId != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.keyId));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String bAL() {
        return this.oid;
    }

    protected void bAN() {
        try {
            StringBuilder stringBuilder;
            if (!nu(this.oid)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong identifier: ");
                stringBuilder.append(this.oid);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.version != 1 && this.version != 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong version. Was expecting 1 or 2, found ");
                stringBuilder.append(this.version);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e);
            throw new IllegalArgumentException("Malformed ChipAuthenticationInfo.");
        }
    }

    static boolean nu(String str) {
        return fcH.equals(str) || fcI.equals(str) || "0.4.0.127.0.7.2.2.3.1.2".equals(str) || "0.4.0.127.0.7.2.2.3.1.3".equals(str) || "0.4.0.127.0.7.2.2.3.1.4".equals(str) || "0.4.0.127.0.7.2.2.3.2.2".equals(str) || "0.4.0.127.0.7.2.2.3.2.3".equals(str) || "0.4.0.127.0.7.2.2.3.2.4".equals(str);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChipAuthenticationInfo [protocol: ");
        stringBuilder.append(nv(this.oid));
        stringBuilder.append(", version: ");
        stringBuilder.append(this.version);
        stringBuilder.append(", keyId: ");
        stringBuilder.append(this.keyId == null ? "-" : this.keyId);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return ((((this.oid == null ? 0 : this.oid.hashCode()) * 11) + 3) + (this.version * 61)) + ((this.keyId == null ? 111 : this.keyId.hashCode()) * 1991);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ChipAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        ChipAuthenticationInfo chipAuthenticationInfo = (ChipAuthenticationInfo) obj;
        if (this.oid.equals(chipAuthenticationInfo.oid) && this.version == chipAuthenticationInfo.version && ((this.keyId == null && chipAuthenticationInfo.keyId == null) || (this.keyId != null && this.keyId.equals(chipAuthenticationInfo.keyId)))) {
            z = true;
        }
        return z;
    }

    private static String nv(String str) {
        if (fcH.equals(str)) {
            return "id-CA-DH-3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.3.1.2".equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.3.1.3".equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-192";
        }
        if ("0.4.0.127.0.7.2.2.3.1.4".equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-256";
        }
        if (fcI.equals(str)) {
            return "id-CA-ECDH-3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.3.2.2".equals(str)) {
            return "id-CA-ECDH-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.3.2.3".equals(str)) {
            return "id-CA-ECDH-AES-CBC-CMAC-192";
        }
        return "0.4.0.127.0.7.2.2.3.2.4".equals(str) ? "id-CA-ECDH-AES-CBC-CMAC-256" : str;
    }
}
