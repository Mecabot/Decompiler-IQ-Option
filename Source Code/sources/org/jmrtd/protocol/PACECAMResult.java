package org.jmrtd.protocol;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Arrays;
import net.sf.scuba.util.Hex;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.lds.PACEInfo.MappingType;
import org.jmrtd.protocol.PACEResult.PACEMappingResult;

public class PACECAMResult extends PACEResult {
    private static final long serialVersionUID = -4288710920347109329L;
    private byte[] chipAuthenticationData;
    private byte[] encryptedChipAuthenticationData = null;

    public PACECAMResult(AccessKeySpec accessKeySpec, String str, String str2, String str3, int i, PACEMappingResult pACEMappingResult, KeyPair keyPair, PublicKey publicKey, byte[] bArr, byte[] bArr2, SecureMessagingWrapper secureMessagingWrapper) {
        Object obj = bArr;
        Object obj2 = bArr2;
        super(accessKeySpec, MappingType.CAM, str, str2, str3, i, pACEMappingResult, keyPair, publicKey, secureMessagingWrapper);
        if (obj != null) {
            this.encryptedChipAuthenticationData = new byte[obj.length];
            System.arraycopy(obj, 0, this.encryptedChipAuthenticationData, 0, obj.length);
        }
        this.chipAuthenticationData = null;
        if (obj2 != null) {
            this.chipAuthenticationData = new byte[obj2.length];
            System.arraycopy(obj2, 0, this.chipAuthenticationData, 0, obj2.length);
        }
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.chipAuthenticationData)) * 31) + Arrays.hashCode(this.encryptedChipAuthenticationData);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PACECAMResult pACECAMResult = (PACECAMResult) obj;
        if (!(Arrays.equals(this.chipAuthenticationData, pACECAMResult.chipAuthenticationData) && Arrays.equals(this.encryptedChipAuthenticationData, pACECAMResult.encryptedChipAuthenticationData))) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PACECAMResult [");
        stringBuilder.append("paceKey: ");
        stringBuilder.append(bBR());
        stringBuilder.append(", ");
        stringBuilder.append("mappingType: ");
        stringBuilder.append(bBT());
        stringBuilder.append(", ");
        stringBuilder.append("agreementAlg: ");
        stringBuilder.append(bBU());
        stringBuilder.append(", ");
        stringBuilder.append("cipherAlg: ");
        stringBuilder.append(bBV());
        stringBuilder.append(", ");
        stringBuilder.append("digestAlg: ");
        stringBuilder.append(bBW());
        stringBuilder.append(", ");
        stringBuilder.append("keyLength: ");
        stringBuilder.append(getKeyLength());
        stringBuilder.append(", ");
        stringBuilder.append("mappingResult: ");
        stringBuilder.append(bBS());
        stringBuilder.append(", ");
        stringBuilder.append("pcdKeyPair: ");
        stringBuilder.append(bBX());
        stringBuilder.append(", ");
        stringBuilder.append("piccPublicKey: ");
        stringBuilder.append(bBY());
        stringBuilder.append(", ");
        stringBuilder.append("encryptedChipAuthenticationData: ");
        stringBuilder.append(Hex.bytesToHexString(this.encryptedChipAuthenticationData));
        stringBuilder.append(", ");
        stringBuilder.append("wrapper: ");
        stringBuilder.append(bBQ());
        stringBuilder.append(", ");
        stringBuilder.append("chipAuthenticationData: ");
        stringBuilder.append(Hex.bytesToHexString(this.chipAuthenticationData));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
