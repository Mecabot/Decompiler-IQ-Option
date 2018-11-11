package org.jmrtd.lds;

import java.math.BigInteger;
import java.security.PublicKey;
import org.jmrtd.d;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DLSequence;

public class ChipAuthenticationPublicKeyInfo extends SecurityInfo {
    private static final long serialVersionUID = 5687291829854501771L;
    private BigInteger keyId;
    private String oid;
    private PublicKey publicKey;

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey) {
        this(str, publicKey, null);
    }

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey, BigInteger bigInteger) {
        this.oid = str;
        this.publicKey = d.c(publicKey);
        this.keyId = bigInteger;
        bAN();
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(d.b(this.publicKey).toASN1Primitive());
        if (this.keyId != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.keyId));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String bAL() {
        return this.oid;
    }

    public PublicKey getSubjectPublicKey() {
        return this.publicKey;
    }

    protected void bAN() {
        try {
            if (!nu(this.oid)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong identifier: ");
                stringBuilder.append(this.oid);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Malformed ChipAuthenticationInfo", e);
        }
    }

    public static boolean nu(String str) {
        return fcF.equals(str) || fcG.equals(str);
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChipAuthenticationPublicKeyInfo [protocol: ");
        stringBuilder.append(nv(this.oid));
        stringBuilder.append(", ");
        stringBuilder.append("chipAuthenticationPublicKey: ");
        stringBuilder.append(d.a(getSubjectPublicKey()));
        stringBuilder.append(", ");
        stringBuilder.append("keyId: ");
        if (this.keyId == null) {
            str = "-";
        } else {
            str = this.keyId.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 111;
        int hashCode = this.oid.hashCode() + (this.keyId == null ? 111 : this.keyId.hashCode());
        if (this.publicKey != null) {
            i = this.publicKey.hashCode();
        }
        return ((hashCode + i) * 1337) + 123;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ChipAuthenticationPublicKeyInfo.class.equals(obj.getClass())) {
            return false;
        }
        ChipAuthenticationPublicKeyInfo chipAuthenticationPublicKeyInfo = (ChipAuthenticationPublicKeyInfo) obj;
        if (this.oid.equals(chipAuthenticationPublicKeyInfo.oid) && (((this.keyId == null && chipAuthenticationPublicKeyInfo.keyId == null) || (this.keyId != null && this.keyId.equals(chipAuthenticationPublicKeyInfo.keyId))) && this.publicKey.equals(chipAuthenticationPublicKeyInfo.publicKey))) {
            z = true;
        }
        return z;
    }

    private static String nv(String str) {
        if (fcF.equals(str)) {
            return "id-PK-DH";
        }
        return fcG.equals(str) ? "id-PK-ECDH" : str;
    }
}
