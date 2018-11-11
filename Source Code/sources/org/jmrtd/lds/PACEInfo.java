package org.jmrtd.lds;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.jmrtd.d;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.crypto.agreement.DHStandardGroups;
import org.spongycastle.jce.ECNamedCurveTable;

public class PACEInfo extends SecurityInfo {
    private static final ECParameterSpec fcA = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp256r1"));
    private static final ECParameterSpec fcB = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp320r1"));
    private static final ECParameterSpec fcC = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp384r1"));
    private static final ECParameterSpec fcD = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp512r1"));
    private static final DHParameterSpec fcq = d.a(DHStandardGroups.rfc5114_1024_160);
    private static final DHParameterSpec fcr = d.a(DHStandardGroups.rfc5114_2048_224);
    private static final DHParameterSpec fcs = d.a(DHStandardGroups.rfc5114_2048_256);
    private static final ECParameterSpec fct = d.a(ECNamedCurveTable.getParameterSpec("secp192r1"));
    private static final ECParameterSpec fcu = d.a(ECNamedCurveTable.getParameterSpec("secp224r1"));
    private static final ECParameterSpec fcv = d.a(ECNamedCurveTable.getParameterSpec("secp256r1"));
    private static final ECParameterSpec fcw = d.a(ECNamedCurveTable.getParameterSpec("secp384r1"));
    private static final ECParameterSpec fcx = d.a(ECNamedCurveTable.getParameterSpec("secp521r1"));
    private static final ECParameterSpec fcy = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp192r1"));
    private static final ECParameterSpec fcz = d.a(ECNamedCurveTable.getParameterSpec("brainpoolp224r1"));
    private static final long serialVersionUID = 7960925013249578359L;
    private BigInteger parameterId;
    private String protocolOID;
    private int version;

    public enum MappingType {
        GM,
        IM,
        CAM
    }

    public static class a extends DHParameterSpec {
        private BigInteger q;

        public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            super(bigInteger, bigInteger2);
            this.q = bigInteger3;
        }

        public BigInteger getQ() {
            return this.q;
        }
    }

    public PACEInfo(String str, int i, int i2) {
        this(str, i, BigInteger.valueOf((long) i2));
    }

    public PACEInfo(String str, int i, BigInteger bigInteger) {
        if (!nu(str)) {
            throw new IllegalArgumentException("Invalid OID");
        } else if (i != 2) {
            throw new IllegalArgumentException("Invalid version, must be 2");
        } else {
            this.protocolOID = str;
            this.version = i;
            this.parameterId = bigInteger;
        }
    }

    public String bAL() {
        return this.protocolOID;
    }

    public BigInteger bAS() {
        return this.parameterId;
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.protocolOID));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.parameterId != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.parameterId));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PACEInfo [");
        stringBuilder.append("protocol: ");
        stringBuilder.append(nv(this.protocolOID));
        stringBuilder.append(", version: ");
        stringBuilder.append(this.version);
        if (this.parameterId != null) {
            stringBuilder.append(", parameterId: ");
            stringBuilder.append(c(this.parameterId));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i;
        int hashCode = ((this.protocolOID.hashCode() * 7) + 1234567891) + (this.version * 5);
        if (this.parameterId == null) {
            i = 1991;
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
        if (!PACEInfo.class.equals(obj.getClass())) {
            return false;
        }
        return bAK().equals(((PACEInfo) obj).bAK());
    }

    public static boolean nu(String str) {
        return "0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str) || "0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str);
    }

    public static MappingType nx(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str)) {
            return MappingType.GM;
        }
        if ("0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str)) {
            return MappingType.IM;
        }
        if ("0.4.0.127.0.7.2.2.4.6.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str)) {
            return MappingType.CAM;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public static String ny(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str)) {
            return "DH";
        }
        if ("0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str)) {
            return "ECDH";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public static String nz(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str)) {
            return "DESede";
        }
        if ("0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str)) {
            return "AES";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public static String nA(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.2".equals(str)) {
            return "SHA-1";
        }
        if ("0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str) || "0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str)) {
            return "SHA-256";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public static int nB(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str) || "0.4.0.127.0.7.2.2.4.3.1".equals(str) || "0.4.0.127.0.7.2.2.4.2.1".equals(str) || "0.4.0.127.0.7.2.2.4.4.1".equals(str) || "0.4.0.127.0.7.2.2.4.1.2".equals(str) || "0.4.0.127.0.7.2.2.4.3.2".equals(str) || "0.4.0.127.0.7.2.2.4.2.2".equals(str) || "0.4.0.127.0.7.2.2.4.4.2".equals(str) || "0.4.0.127.0.7.2.2.4.6.2".equals(str)) {
            return 128;
        }
        if ("0.4.0.127.0.7.2.2.4.1.3".equals(str) || "0.4.0.127.0.7.2.2.4.2.3".equals(str) || "0.4.0.127.0.7.2.2.4.3.3".equals(str) || "0.4.0.127.0.7.2.2.4.4.3".equals(str) || "0.4.0.127.0.7.2.2.4.6.3".equals(str)) {
            return 192;
        }
        if ("0.4.0.127.0.7.2.2.4.1.4".equals(str) || "0.4.0.127.0.7.2.2.4.3.4".equals(str) || "0.4.0.127.0.7.2.2.4.2.4".equals(str) || "0.4.0.127.0.7.2.2.4.4.4".equals(str) || "0.4.0.127.0.7.2.2.4.6.4".equals(str)) {
            return 256;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public static AlgorithmParameterSpec b(BigInteger bigInteger) {
        return mw(bigInteger.intValue());
    }

    public static AlgorithmParameterSpec mw(int i) {
        switch (i) {
            case 0:
                return fcq;
            case 1:
                return fcr;
            case 2:
                return fcs;
            default:
                switch (i) {
                    case 8:
                        return fct;
                    case 9:
                        return fcy;
                    case 10:
                        return fcu;
                    case 11:
                        return fcz;
                    case 12:
                        return fcv;
                    case 13:
                        return fcA;
                    case 14:
                        return fcB;
                    case 15:
                        return fcw;
                    case 16:
                        return fcC;
                    case 17:
                        return fcD;
                    case 18:
                        return fcx;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown standardized domain parameters ");
                        stringBuilder.append(i);
                        throw new NumberFormatException(stringBuilder.toString());
                }
        }
    }

    public static String c(BigInteger bigInteger) {
        if (bigInteger == null) {
            return "null";
        }
        int intValue = bigInteger.intValue();
        switch (intValue) {
            case 0:
                return "1024-bit MODP Group with 160-bit Prime Order Subgroup";
            case 1:
                return "2048-bit MODP Group with 224-bit Prime Order Subgroup";
            case 2:
                return "2048-bit MODP Group with 256-bit Prime Order Subgroup";
            default:
                switch (intValue) {
                    case 8:
                        return "NIST P-192 (secp192r1)";
                    case 9:
                        return "BrainpoolP192r1";
                    case 10:
                        return "NIST P-224 (secp224r1)";
                    case 11:
                        return "BrainpoolP224r1";
                    case 12:
                        return "NIST P-256 (secp256r1)";
                    case 13:
                        return "BrainpoolP256r1";
                    case 14:
                        return "BrainpoolP320r1";
                    case 15:
                        return "NIST P-384 (secp384r1)";
                    case 16:
                        return "BrainpoolP384r1";
                    case 17:
                        return "BrainpoolP512r1";
                    case 18:
                        return "NIST P-521 (secp521r1)";
                    default:
                        return bigInteger.toString();
                }
        }
    }

    private String nv(String str) {
        if ("0.4.0.127.0.7.2.2.4.1.1".equals(str)) {
            return "id-PACE-DH-GM-3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.4.1.2".equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.4.1.3".equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-192";
        }
        if ("0.4.0.127.0.7.2.2.4.1.4".equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-256";
        }
        if ("0.4.0.127.0.7.2.2.4.3.1".equals(str)) {
            return "id-PACE-DH-IM-3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.4.3.2".equals(str)) {
            return "id-PACE-DH-IM-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.4.3.3".equals(str)) {
            return "id-PACE-DH-IM-AES-CBC-CMAC-192";
        }
        if ("0.4.0.127.0.7.2.2.4.3.4".equals(str)) {
            return "id-PACE_DH-IM-AES-CBC-CMAC-256";
        }
        if ("0.4.0.127.0.7.2.2.4.2.1".equals(str)) {
            return "id-PACE-ECDH-GM-3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.4.2.2".equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.4.2.3".equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-192";
        }
        if ("0.4.0.127.0.7.2.2.4.2.4".equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-256";
        }
        if ("0.4.0.127.0.7.2.2.4.4.1".equals(str)) {
            return "id-PACE-ECDH-IM_3DES-CBC-CBC";
        }
        if ("0.4.0.127.0.7.2.2.4.4.2".equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.4.4.3".equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-192";
        }
        if ("0.4.0.127.0.7.2.2.4.4.4".equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-256";
        }
        if ("0.4.0.127.0.7.2.2.4.6.2".equals(str)) {
            return "id-PACE-ECDH-CAM-AES-CBC-CMAC-128";
        }
        if ("0.4.0.127.0.7.2.2.4.6.3".equals(str)) {
            return "id-PACE-ECDH-CAM-AES-CBC-CMAC-192";
        }
        return "0.4.0.127.0.7.2.2.4.6.4".equals(str) ? "id-PACE-ECDH-CAM-AES-CBC-CMAC-256" : str;
    }
}
