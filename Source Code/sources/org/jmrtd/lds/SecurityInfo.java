package org.jmrtd.lds;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.d;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public abstract class SecurityInfo extends AbstractLDSInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final String fcF = EACObjectIdentifiers.id_PK_DH.getId();
    public static final String fcG = EACObjectIdentifiers.id_PK_ECDH.getId();
    public static final String fcH = EACObjectIdentifiers.id_CA_DH_3DES_CBC_CBC.getId();
    public static final String fcI = EACObjectIdentifiers.id_CA_ECDH_3DES_CBC_CBC.getId();
    public static final String fcJ = EACObjectIdentifiers.id_TA.getId();
    public static final String fcK = EACObjectIdentifiers.id_TA_RSA.getId();
    public static final String fcL = EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1.getId();
    public static final String fcM = EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256.getId();
    public static final String fcN = EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1.getId();
    public static final String fcO = EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256.getId();
    public static final String fcP = EACObjectIdentifiers.id_TA_ECDSA.getId();
    public static final String fcQ = EACObjectIdentifiers.id_TA_ECDSA_SHA_1.getId();
    public static final String fcR = EACObjectIdentifiers.id_TA_ECDSA_SHA_224.getId();
    public static final String fcS = EACObjectIdentifiers.id_TA_ECDSA_SHA_256.getId();
    public static final String fcT = X9ObjectIdentifiers.id_publicKeyType.getId();
    public static final String fcU = X9ObjectIdentifiers.id_ecPublicKey.getId();
    private static final long serialVersionUID = -7919854443619069808L;

    @Deprecated
    public abstract ASN1Primitive bAK();

    public abstract String bAL();

    public void f(OutputStream outputStream) {
        ASN1Primitive bAK = bAK();
        if (bAK == null) {
            throw new IOException("Could not decode from DER.");
        }
        byte[] encoded = bAK.getEncoded("DER");
        if (encoded == null) {
            throw new IOException("Could not decode from DER.");
        }
        outputStream.write(encoded);
    }

    public static SecurityInfo a(ASN1Primitive aSN1Primitive) {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
            String id = ((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId();
            ASN1Primitive toASN1Primitive = aSN1Sequence.getObjectAt(1).toASN1Primitive();
            aSN1Primitive = aSN1Sequence.size() == 3 ? aSN1Sequence.getObjectAt(2).toASN1Primitive() : null;
            int intValue;
            if (ActiveAuthenticationInfo.nu(id)) {
                intValue = ((ASN1Integer) toASN1Primitive).getValue().intValue();
                if (aSN1Primitive == null) {
                    return new ActiveAuthenticationInfo(id, intValue, null);
                }
                return new ActiveAuthenticationInfo(id, intValue, ((ASN1ObjectIdentifier) aSN1Primitive).getId());
            } else if (ChipAuthenticationPublicKeyInfo.nu(id)) {
                SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(toASN1Primitive);
                if (aSN1Primitive == null) {
                    return new ChipAuthenticationPublicKeyInfo(id, d.a(instance));
                }
                return new ChipAuthenticationPublicKeyInfo(id, d.a(instance), ((ASN1Integer) aSN1Primitive).getValue());
            } else if (ChipAuthenticationInfo.nu(id)) {
                intValue = ((ASN1Integer) toASN1Primitive).getValue().intValue();
                if (aSN1Primitive == null) {
                    return new ChipAuthenticationInfo(id, intValue);
                }
                return new ChipAuthenticationInfo(id, intValue, ((ASN1Integer) aSN1Primitive).getValue());
            } else if (TerminalAuthenticationInfo.nu(id)) {
                intValue = ((ASN1Integer) toASN1Primitive).getValue().intValue();
                if (aSN1Primitive == null) {
                    return new TerminalAuthenticationInfo(id, intValue);
                }
                return new TerminalAuthenticationInfo(id, intValue, (ASN1Sequence) aSN1Primitive);
            } else if (PACEInfo.nu(id)) {
                intValue = ((ASN1Integer) toASN1Primitive).getValue().intValue();
                int i = -1;
                if (aSN1Primitive != null) {
                    i = ((ASN1Integer) aSN1Primitive).getValue().intValue();
                }
                return new PACEInfo(id, intValue, i);
            } else if (PACEDomainParameterInfo.nu(id)) {
                AlgorithmIdentifier instance2 = AlgorithmIdentifier.getInstance(toASN1Primitive);
                if (aSN1Primitive != null) {
                    return new PACEDomainParameterInfo(id, instance2, ((ASN1Integer) aSN1Primitive).getValue());
                }
                return new PACEDomainParameterInfo(id, instance2);
            } else {
                Logger logger = LOGGER;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported SecurityInfo, oid = ");
                stringBuilder.append(id);
                logger.warning(stringBuilder.toString());
                return null;
            }
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e);
            throw new IllegalArgumentException("Malformed input stream.");
        }
    }
}
