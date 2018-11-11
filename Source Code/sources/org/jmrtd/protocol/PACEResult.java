package org.jmrtd.protocol;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.lds.PACEInfo.MappingType;

public class PACEResult implements Serializable {
    private static final long serialVersionUID = -6819675856205885052L;
    private String agreementAlg;
    private String cipherAlg;
    private String digestAlg;
    private int keyLength;
    private PACEMappingResult mappingResult;
    private MappingType mappingType;
    private AccessKeySpec paceKey;
    private KeyPair pcdKeyPair;
    private PublicKey piccPublicKey;
    private SecureMessagingWrapper wrapper;

    public static abstract class PACEMappingResult implements Serializable {
        private static final long serialVersionUID = 2773111318950631118L;
        private transient AlgorithmParameterSpec fdj;
        private transient AlgorithmParameterSpec fdk;
        private byte[] piccNonce = null;

        public PACEMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec2) {
            this.fdj = algorithmParameterSpec;
            this.fdk = algorithmParameterSpec2;
            if (bArr != null) {
                this.piccNonce = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.piccNonce, 0, bArr.length);
            }
        }

        public AlgorithmParameterSpec bBZ() {
            return this.fdk;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.fdk == null ? 0 : this.fdk.hashCode()) + 31) * 31) + Arrays.hashCode(this.piccNonce)) * 31;
            if (this.fdj != null) {
                i = this.fdj.hashCode();
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
            PACEMappingResult pACEMappingResult = (PACEMappingResult) obj;
            if (this.fdk == null) {
                if (pACEMappingResult.fdk != null) {
                    return false;
                }
            } else if (!this.fdk.equals(pACEMappingResult.fdk)) {
                return false;
            }
            if (!Arrays.equals(this.piccNonce, pACEMappingResult.piccNonce)) {
                return false;
            }
            if (this.fdj == null) {
                if (pACEMappingResult.fdj != null) {
                    return false;
                }
            } else if (!this.fdj.equals(pACEMappingResult.fdj)) {
                return false;
            }
            return true;
        }
    }

    public static abstract class PACEGMMappingResult extends PACEMappingResult {
        private static final long serialVersionUID = -3373471956987358728L;
        private KeyPair pcdMappingKeyPair;
        private PublicKey piccMappingPublicKey;

        public PACEGMMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, PublicKey publicKey, KeyPair keyPair, AlgorithmParameterSpec algorithmParameterSpec2) {
            super(algorithmParameterSpec, bArr, algorithmParameterSpec2);
            this.piccMappingPublicKey = publicKey;
            this.pcdMappingKeyPair = keyPair;
        }

        public int hashCode() {
            return (super.hashCode() * 31) + (this.piccMappingPublicKey == null ? 0 : this.piccMappingPublicKey.hashCode());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj) || getClass() != obj.getClass()) {
                return false;
            }
            PACEGMMappingResult pACEGMMappingResult = (PACEGMMappingResult) obj;
            if (this.piccMappingPublicKey == null) {
                if (pACEGMMappingResult.piccMappingPublicKey != null) {
                    return false;
                }
            } else if (!this.piccMappingPublicKey.equals(pACEGMMappingResult.piccMappingPublicKey)) {
                return false;
            }
            if (this.pcdMappingKeyPair == null) {
                if (pACEGMMappingResult.pcdMappingKeyPair != null) {
                    return false;
                }
            } else if (!this.pcdMappingKeyPair.equals(pACEGMMappingResult.pcdMappingKeyPair)) {
                return false;
            }
            return true;
        }
    }

    public static class PACEIMMappingResult extends PACEMappingResult {
        private static final long serialVersionUID = -6415752866407346050L;
        private byte[] pcdNonce = null;

        public PACEIMMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, byte[] bArr2, AlgorithmParameterSpec algorithmParameterSpec2) {
            super(algorithmParameterSpec, bArr, algorithmParameterSpec2);
            if (bArr2 != null) {
                this.pcdNonce = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, this.pcdNonce, 0, bArr2.length);
            }
        }

        public int hashCode() {
            return (super.hashCode() * 31) + Arrays.hashCode(this.pcdNonce);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj) || getClass() != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.pcdNonce, ((PACEIMMappingResult) obj).pcdNonce);
        }
    }

    public static class PACEGMWithDHMappingResult extends PACEGMMappingResult {
        private static final long serialVersionUID = -2829641255641406199L;
        private byte[] sharedSecret = null;

        public PACEGMWithDHMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, PublicKey publicKey, KeyPair keyPair, byte[] bArr2, AlgorithmParameterSpec algorithmParameterSpec2) {
            super(algorithmParameterSpec, bArr, publicKey, keyPair, algorithmParameterSpec2);
            if (bArr2 != null) {
                this.sharedSecret = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, this.sharedSecret, 0, bArr2.length);
            }
        }

        public int hashCode() {
            return (super.hashCode() * 31) + Arrays.hashCode(this.sharedSecret);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj) || getClass() != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.sharedSecret, ((PACEGMWithDHMappingResult) obj).sharedSecret);
        }
    }

    public static class PACEGMWithECDHMappingResult extends PACEGMMappingResult {
        private static final long serialVersionUID = -3892431861957032423L;
        private BigInteger sharedSecretPointX;
        private BigInteger sharedSecretPointY;

        public PACEGMWithECDHMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, PublicKey publicKey, KeyPair keyPair, ECPoint eCPoint, AlgorithmParameterSpec algorithmParameterSpec2) {
            super(algorithmParameterSpec, bArr, publicKey, keyPair, algorithmParameterSpec2);
            this.sharedSecretPointX = eCPoint.getAffineX();
            this.sharedSecretPointY = eCPoint.getAffineY();
        }

        public int hashCode() {
            int i;
            int hashCode = super.hashCode() * 31;
            int i2 = 0;
            if (this.sharedSecretPointX == null) {
                i = 0;
            } else {
                i = this.sharedSecretPointX.hashCode();
            }
            hashCode += i;
            if (this.sharedSecretPointY != null) {
                i2 = this.sharedSecretPointY.hashCode();
            }
            return hashCode + i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj) || getClass() != obj.getClass()) {
                return false;
            }
            PACEGMWithECDHMappingResult pACEGMWithECDHMappingResult = (PACEGMWithECDHMappingResult) obj;
            if (this.sharedSecretPointX == null) {
                if (pACEGMWithECDHMappingResult.sharedSecretPointX != null) {
                    return false;
                }
            } else if (!this.sharedSecretPointX.equals(pACEGMWithECDHMappingResult.sharedSecretPointX)) {
                return false;
            }
            if (this.sharedSecretPointY == null) {
                if (pACEGMWithECDHMappingResult.sharedSecretPointY != null) {
                    return false;
                }
            } else if (!this.sharedSecretPointY.equals(pACEGMWithECDHMappingResult.sharedSecretPointY)) {
                return false;
            }
            return true;
        }
    }

    public PACEResult(AccessKeySpec accessKeySpec, MappingType mappingType, String str, String str2, String str3, int i, PACEMappingResult pACEMappingResult, KeyPair keyPair, PublicKey publicKey, SecureMessagingWrapper secureMessagingWrapper) {
        this.paceKey = accessKeySpec;
        this.mappingType = mappingType;
        this.agreementAlg = str;
        this.cipherAlg = str2;
        this.digestAlg = str3;
        this.keyLength = i;
        this.mappingResult = pACEMappingResult;
        this.pcdKeyPair = keyPair;
        this.piccPublicKey = publicKey;
        this.wrapper = secureMessagingWrapper;
    }

    public AccessKeySpec bBR() {
        return this.paceKey;
    }

    public PACEMappingResult bBS() {
        return this.mappingResult;
    }

    public SecureMessagingWrapper bBQ() {
        return this.wrapper;
    }

    public MappingType bBT() {
        return this.mappingType;
    }

    public String bBU() {
        return this.agreementAlg;
    }

    public String bBV() {
        return this.cipherAlg;
    }

    public String bBW() {
        return this.digestAlg;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public KeyPair bBX() {
        return this.pcdKeyPair;
    }

    public PublicKey bBY() {
        return this.piccPublicKey;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PACEResult [");
        stringBuilder.append("paceKey: ");
        stringBuilder.append(this.paceKey);
        stringBuilder.append(", mappingType: ");
        stringBuilder.append(this.mappingType);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", agreementAlg: ");
        stringBuilder2.append(this.agreementAlg);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", cipherAlg: ");
        stringBuilder2.append(this.cipherAlg);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", digestAlg: ");
        stringBuilder2.append(this.digestAlg);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", keyLength: ");
        stringBuilder2.append(this.keyLength);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", mappingResult: ");
        stringBuilder2.append(this.mappingResult);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", pcdKeyPair: ");
        stringBuilder2.append(this.pcdKeyPair);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", piccPublicKey: ");
        stringBuilder2.append(this.piccPublicKey);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((21901 + (this.paceKey == null ? 0 : this.paceKey.hashCode())) * 1991) + (this.agreementAlg == null ? 0 : this.agreementAlg.hashCode())) * 1991) + (this.cipherAlg == null ? 0 : this.cipherAlg.hashCode())) * 1991) + (this.digestAlg == null ? 0 : this.digestAlg.hashCode())) * 1991) + (this.mappingResult == null ? 0 : this.mappingResult.hashCode())) * 1991) + this.keyLength) * 1991) + (this.mappingType == null ? 0 : this.mappingType.hashCode())) * 1991) + (this.pcdKeyPair == null ? 0 : this.pcdKeyPair.hashCode())) * 1991) + (this.piccPublicKey == null ? 0 : this.piccPublicKey.hashCode())) * 1991;
        if (this.wrapper != null) {
            i = this.wrapper.hashCode();
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
        PACEResult pACEResult = (PACEResult) obj;
        if (this.paceKey == null) {
            if (pACEResult.paceKey != null) {
                return false;
            }
        } else if (!this.paceKey.equals(pACEResult.paceKey)) {
            return false;
        }
        if (this.agreementAlg == null) {
            if (pACEResult.agreementAlg != null) {
                return false;
            }
        } else if (!this.agreementAlg.equals(pACEResult.agreementAlg)) {
            return false;
        }
        if (this.cipherAlg == null) {
            if (pACEResult.cipherAlg != null) {
                return false;
            }
        } else if (!this.cipherAlg.equals(pACEResult.cipherAlg)) {
            return false;
        }
        if (this.digestAlg == null) {
            if (pACEResult.digestAlg != null) {
                return false;
            }
        } else if (!this.digestAlg.equals(pACEResult.digestAlg)) {
            return false;
        }
        if (this.mappingResult == null) {
            if (pACEResult.mappingResult != null) {
                return false;
            }
        } else if (!this.mappingResult.equals(pACEResult.mappingResult)) {
            return false;
        }
        if (this.keyLength != pACEResult.keyLength || this.mappingType != pACEResult.mappingType) {
            return false;
        }
        if (this.pcdKeyPair == null) {
            if (pACEResult.pcdKeyPair != null) {
                return false;
            }
        } else if (!this.pcdKeyPair.equals(pACEResult.pcdKeyPair)) {
            return false;
        }
        if (this.piccPublicKey == null) {
            if (pACEResult.piccPublicKey != null) {
                return false;
            }
        } else if (!this.piccPublicKey.equals(pACEResult.piccPublicKey)) {
            return false;
        }
        if (this.wrapper == null) {
            if (pACEResult.wrapper != null) {
                return false;
            }
        } else if (!this.wrapper.equals(pACEResult.wrapper)) {
            return false;
        }
        return true;
    }
}
