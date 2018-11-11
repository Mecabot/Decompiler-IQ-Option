package org.jmrtd.lds;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DLSequence;

public class TerminalAuthenticationInfo extends SecurityInfo {
    private static final long serialVersionUID = 6220506985707094044L;
    private transient ASN1Sequence fcV;
    private String oid;
    private int version;

    TerminalAuthenticationInfo(String str, int i, ASN1Sequence aSN1Sequence) {
        this.oid = str;
        this.version = i;
        this.fcV = aSN1Sequence;
        bAN();
    }

    TerminalAuthenticationInfo(String str, int i) {
        this(str, i, null);
    }

    public TerminalAuthenticationInfo() {
        this(fcJ, 1);
    }

    @Deprecated
    public ASN1Primitive bAK() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.fcV != null) {
            aSN1EncodableVector.add(this.fcV);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String bAL() {
        return this.oid;
    }

    public int bAY() {
        return a(this.fcV);
    }

    public byte bAZ() {
        return b(this.fcV);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TerminalAuthenticationInfo [");
        stringBuilder.append("protocol: ");
        stringBuilder.append(nv(this.oid));
        stringBuilder.append(", ");
        stringBuilder.append("version: ");
        stringBuilder.append(this.version);
        stringBuilder.append(", ");
        stringBuilder.append("fileID: ");
        stringBuilder.append(bAY());
        stringBuilder.append(", ");
        stringBuilder.append("shortFileID: ");
        stringBuilder.append(bAZ());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.oid == null) {
            i = 0;
        } else {
            i = this.oid.hashCode();
        }
        i = ((i * 7) + 123) + (this.version * 5);
        if (this.fcV == null) {
            i2 = 1;
        } else {
            i2 = this.fcV.hashCode();
        }
        return i + (i2 * 3);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!TerminalAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        TerminalAuthenticationInfo terminalAuthenticationInfo = (TerminalAuthenticationInfo) obj;
        if (this.fcV == null && terminalAuthenticationInfo.fcV != null) {
            return false;
        }
        if (this.fcV == null || terminalAuthenticationInfo.fcV != null) {
            return bAK().equals(terminalAuthenticationInfo.bAK());
        }
        return false;
    }

    static boolean nu(String str) {
        return fcJ.equals(str);
    }

    private void bAN() {
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
            } else if (this.fcV == null) {
            } else {
                if (((DEROctetString) this.fcV.getObjectAt(0)).getOctets().length != 2) {
                    throw new IllegalArgumentException("Malformed FID.");
                } else if (this.fcV.size() == 2 && ((DEROctetString) this.fcV.getObjectAt(1)).getOctets().length != 1) {
                    throw new IllegalArgumentException("Malformed SFI.");
                }
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Malformed TerminalAuthenticationInfo", e);
        }
    }

    private static short a(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            return (short) -1;
        }
        byte[] octets = ((DEROctetString) aSN1Sequence.getObjectAt(0)).getOctets();
        return (short) ((octets[1] & 255) | ((octets[0] & 255) << 8));
    }

    private static byte b(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence != null && aSN1Sequence.size() == 2) {
            return ((DEROctetString) aSN1Sequence.getObjectAt(1)).getOctets()[0];
        }
        return (byte) -1;
    }

    private String nv(String str) {
        if (fcJ.equals(str)) {
            return "id-TA";
        }
        if (fcK.equals(str)) {
            return "id-TA-RSA";
        }
        if (fcL.equals(str)) {
            return "id-TA-RSA-v1-5-SHA-1";
        }
        if (fcM.equals(str)) {
            return "id-TA-RSA-v1-5-SHA-256";
        }
        if (fcN.equals(str)) {
            return "id-TA-RSA-PSS-SHA-1";
        }
        if (fcO.equals(str)) {
            return "id-TA-RSA-PSS-SHA-256";
        }
        if (fcP.equals(str)) {
            return "id-TA-ECDSA";
        }
        if (fcQ.equals(str)) {
            return "id-TA-ECDSA-SHA-1";
        }
        if (fcR.equals(str)) {
            return "id-TA-ECDSA-SHA-224";
        }
        return fcS.equals(str) ? "id-TA-ECDSA-SHA-256" : str;
    }
}
