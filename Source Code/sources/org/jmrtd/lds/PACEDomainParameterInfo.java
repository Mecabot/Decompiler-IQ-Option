package org.jmrtd.lds;

import java.math.BigInteger;
import java.util.logging.Logger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PACEDomainParameterInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -5851251908152594728L;
    private transient AlgorithmIdentifier fcp;
    private String oid;
    private BigInteger parameterId;

    public PACEDomainParameterInfo(String str, AlgorithmIdentifier algorithmIdentifier) {
        this(str, algorithmIdentifier, null);
    }

    public PACEDomainParameterInfo(String str, AlgorithmIdentifier algorithmIdentifier, BigInteger bigInteger) {
        if (nu(str)) {
            this.oid = str;
            this.fcp = algorithmIdentifier;
            this.parameterId = bigInteger;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid protocol id: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String bAL() {
        return this.oid;
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(this.fcp);
        if (this.parameterId != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.parameterId));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PACEDomainParameterInfo");
        stringBuilder.append("[");
        stringBuilder.append("protocol: ");
        stringBuilder.append(nv(this.oid));
        stringBuilder.append(", ");
        stringBuilder.append("domainParameter: [");
        stringBuilder.append("algorithm: ");
        stringBuilder.append(this.fcp.getAlgorithm().getId());
        stringBuilder.append(", ");
        stringBuilder.append("parameters: ");
        stringBuilder.append(this.fcp.getParameters());
        if (this.parameterId == null) {
            str = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", parameterId: ");
            stringBuilder2.append(this.parameterId);
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i;
        int hashCode = ((this.oid.hashCode() * 7) + 111111111) + (this.fcp.hashCode() * 5);
        if (this.parameterId == null) {
            i = 333;
        } else {
            i = this.parameterId.hashCode();
        }
        return hashCode + (i * 3);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!PACEDomainParameterInfo.class.equals(obj.getClass())) {
            return false;
        }
        return bAK().equals(((PACEDomainParameterInfo) obj).bAK());
    }

    public static boolean nu(String str) {
        return "0.4.0.127.0.7.2.2.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6".equals(str);
    }

    private static String nv(String str) {
        if ("0.4.0.127.0.7.2.2.4.1".equals(str)) {
            return "id-PACE-DH-GM";
        }
        if ("0.4.0.127.0.7.2.2.4.2".equals(str)) {
            return "id-PACE-ECDH-GM";
        }
        if ("0.4.0.127.0.7.2.2.4.3".equals(str)) {
            return "id-PACE-DH-IM";
        }
        if ("0.4.0.127.0.7.2.2.4.4".equals(str)) {
            return "id-PACE-ECDH-IM";
        }
        return "0.4.0.127.0.7.2.2.4.6".equals(str) ? "id-PACE-ECDH-CAM" : str;
    }
}
