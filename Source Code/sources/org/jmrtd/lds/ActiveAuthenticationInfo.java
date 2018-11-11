package org.jmrtd.lds;

import java.security.NoSuchAlgorithmException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DLSequence;

public class ActiveAuthenticationInfo extends SecurityInfo {
    private static final long serialVersionUID = 6830847342039845308L;
    private String oid;
    private String signatureAlgorithmOID;
    private int version;

    ActiveAuthenticationInfo(String str, int i, String str2) {
        this.oid = str;
        this.version = i;
        this.signatureAlgorithmOID = str2;
        bAN();
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.signatureAlgorithmOID != null) {
            aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.signatureAlgorithmOID));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String bAL() {
        return this.oid;
    }

    public String bAM() {
        return this.signatureAlgorithmOID;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActiveAuthenticationInfo");
        stringBuilder.append(" [");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("protocol: ");
        stringBuilder2.append(nv(this.oid));
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(", ");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("version: ");
        stringBuilder2.append(this.version);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(", ");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("signatureAlgorithmOID: ");
        stringBuilder2.append(nw(bAM()));
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ActiveAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        return bAK().equals(((ActiveAuthenticationInfo) obj).bAK());
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.oid == null) {
            i = 0;
        } else {
            i = this.oid.hashCode();
        }
        i = ((i * 3) + 12345) + (this.version * 5);
        if (this.signatureAlgorithmOID == null) {
            i2 = 1;
        } else {
            i2 = this.signatureAlgorithmOID.hashCode();
        }
        return i + (i2 * 11);
    }

    public static String nt(String str) {
        if ("0.4.0.127.0.7.1.1.4.1.1".equals(str)) {
            return "SHA1withECDSA";
        }
        if ("0.4.0.127.0.7.1.1.4.1.2".equals(str)) {
            return "SHA224withECDSA";
        }
        if ("0.4.0.127.0.7.1.1.4.1.3".equals(str)) {
            return "SHA256withECDSA";
        }
        if ("0.4.0.127.0.7.1.1.4.1.4".equals(str)) {
            return "SHA384withECDSA";
        }
        if ("0.4.0.127.0.7.1.1.4.1.5".equals(str)) {
            return "SHA512withECDSA";
        }
        if ("0.4.0.127.0.7.1.1.4.1.6".equals(str)) {
            return "RIPEMD160withECDSA";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID ");
        stringBuilder.append(str);
        throw new NoSuchAlgorithmException(stringBuilder.toString());
    }

    static boolean nu(String str) {
        return "2.23.136.1.1.5".equals(str);
    }

    private void bAN() {
        try {
            StringBuilder stringBuilder;
            if (!nu(this.oid)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong identifier: ");
                stringBuilder.append(this.oid);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.version != 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong version: ");
                stringBuilder.append(this.version);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (!"0.4.0.127.0.7.1.1.4.1.1".equals(this.signatureAlgorithmOID) && !"0.4.0.127.0.7.1.1.4.1.2".equals(this.signatureAlgorithmOID) && !"0.4.0.127.0.7.1.1.4.1.3".equals(this.signatureAlgorithmOID) && !"0.4.0.127.0.7.1.1.4.1.4".equals(this.signatureAlgorithmOID) && !"0.4.0.127.0.7.1.1.4.1.5".equals(this.signatureAlgorithmOID) && !"0.4.0.127.0.7.1.1.4.1.6".equals(this.signatureAlgorithmOID)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong signature algorithm OID: ");
                stringBuilder.append(this.signatureAlgorithmOID);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Malformed ActiveAuthenticationInfo", e);
        }
    }

    private String nv(String str) {
        return "2.23.136.1.1.5".equals(str) ? "id-AA" : str;
    }

    public static String nw(String str) {
        if ("0.4.0.127.0.7.1.1.4.1.1".equals(str)) {
            return "ecdsa-plain-SHA224";
        }
        if ("0.4.0.127.0.7.1.1.4.1.2".equals(str)) {
            return "ecdsa-plain-SHA224";
        }
        if ("0.4.0.127.0.7.1.1.4.1.3".equals(str)) {
            return "ecdsa-plain-SHA256";
        }
        if ("0.4.0.127.0.7.1.1.4.1.4".equals(str)) {
            return "ecdsa-plain-SHA384";
        }
        if ("0.4.0.127.0.7.1.1.4.1.5".equals(str)) {
            return "ecdsa-plain-SHA512";
        }
        return "0.4.0.127.0.7.1.1.4.1.6".equals(str) ? "ecdsa-plain-RIPEMD160" : str;
    }
}
