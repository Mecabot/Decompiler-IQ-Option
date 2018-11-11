package org.jmrtd.lds;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.asn1.cms.SignerInfo;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.jce.provider.X509CertificateObject;

/* compiled from: SignedDataUtil */
class b {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");

    public static SignedData s(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).readObject();
        StringBuilder stringBuilder;
        if (aSN1Sequence.size() != 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Was expecting a DER sequence of length 2, found a DER sequence of length ");
            stringBuilder.append(aSN1Sequence.size());
            throw new IOException(stringBuilder.toString());
        }
        String id = ((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId();
        if ("1.2.840.113549.1.7.2".equals(id)) {
            ASN1Primitive a = a(aSN1Sequence.getObjectAt(1));
            if (a instanceof ASN1Sequence) {
                return SignedData.getInstance(a);
            }
            throw new IOException("Was expecting an ASN.1 sequence as content");
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Was expecting signed-data content type OID (1.2.840.113549.1.7.2), found ");
        stringBuilder.append(id);
        throw new IOException(stringBuilder.toString());
    }

    public static void a(SignedData signedData, OutputStream outputStream) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier("1.2.840.113549.1.7.2"));
        aSN1EncodableVector.add(new DERTaggedObject(0, signedData));
        outputStream.write(new DLSequence(aSN1EncodableVector).getEncoded("DER"));
    }

    public static ASN1Primitive a(ASN1Encodable aSN1Encodable) {
        StringBuilder stringBuilder;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                return aSN1TaggedObject.getObject();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Was expecting tag 0, found ");
            stringBuilder.append(Integer.toHexString(tagNo));
            throw new IOException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Was expecting an ASN1TaggedObject, found ");
        stringBuilder.append(aSN1Encodable.getClass().getCanonicalName());
        throw new IOException(stringBuilder.toString());
    }

    public static String b(SignedData signedData) {
        try {
            return nt(g(signedData).getDigestAlgorithm().getAlgorithm().getId());
        } catch (NoSuchAlgorithmException e) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No such algorithm");
            stringBuilder.append(e);
            logger.log(level, stringBuilder.toString());
            return null;
        }
    }

    public static String c(SignedData signedData) {
        try {
            String id = g(signedData).getDigestEncryptionAlgorithm().getAlgorithm().getId();
            if (id != null) {
                return nt(id);
            }
            LOGGER.warning("Could not determine digest encryption algorithm OID");
            return null;
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "No such algorithm", e);
            return null;
        }
    }

    public static byte[] d(SignedData signedData) {
        byte[] encoded;
        Throwable e;
        SignerInfo g = g(signedData);
        ASN1Set authenticatedAttributes = g.getAuthenticatedAttributes();
        byte[] octets = ((DEROctetString) signedData.getEncapContentInfo().getContent()).getOctets();
        if (authenticatedAttributes.size() == 0) {
            return octets;
        }
        String id = g.getDigestAlgorithm().getAlgorithm().getId();
        try {
            encoded = authenticatedAttributes.getEncoded("DER");
            try {
                a(a(authenticatedAttributes), id, octets);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
                LOGGER.log(Level.WARNING, "Error getting signedAttributes", e);
                return encoded;
            }
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            encoded = null;
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error checking signedAttributes in eContent! No such algorithm: \"");
            stringBuilder.append(id);
            logger.log(level, stringBuilder.toString(), e);
            return encoded;
        } catch (IOException e5) {
            e = e5;
            encoded = null;
            LOGGER.log(Level.WARNING, "Error getting signedAttributes", e);
            return encoded;
        }
        return encoded;
    }

    public static byte[] e(SignedData signedData) {
        return g(signedData).getEncryptedDigest().getOctets();
    }

    public static X509Certificate f(SignedData signedData) {
        ASN1Set certificates = signedData.getCertificates();
        byte[] bArr = null;
        if (certificates == null || certificates.size() <= 0) {
            return null;
        }
        if (certificates.size() != 1) {
            Logger logger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found ");
            stringBuilder.append(certificates.size());
            stringBuilder.append(" certificates");
            logger.warning(stringBuilder.toString());
        }
        X509Certificate x509Certificate = null;
        for (int i = 0; i < certificates.size(); i++) {
            x509Certificate = new X509CertificateObject(Certificate.getInstance(certificates.getObjectAt(i)));
            bArr = x509Certificate.getEncoded();
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Reconstructing using preferred provider didn't work.", e);
            return x509Certificate;
        }
    }

    public static String nt(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(X509ObjectIdentifiers.organization.getId())) {
            return "O";
        }
        if (str.equals(X509ObjectIdentifiers.organizationalUnitName.getId())) {
            return "OU";
        }
        if (str.equals(X509ObjectIdentifiers.commonName.getId())) {
            return "CN";
        }
        if (str.equals(X509ObjectIdentifiers.countryName.getId())) {
            return "C";
        }
        if (str.equals(X509ObjectIdentifiers.stateOrProvinceName.getId())) {
            return "ST";
        }
        if (str.equals(X509ObjectIdentifiers.localityName.getId())) {
            return "L";
        }
        if (str.equals(X509ObjectIdentifiers.id_SHA1.getId())) {
            return "SHA-1";
        }
        if (str.equals(NISTObjectIdentifiers.id_sha224.getId())) {
            return "SHA-224";
        }
        if (str.equals(NISTObjectIdentifiers.id_sha256.getId())) {
            return "SHA-256";
        }
        if (str.equals(NISTObjectIdentifiers.id_sha384.getId())) {
            return "SHA-384";
        }
        if (str.equals(NISTObjectIdentifiers.id_sha512.getId())) {
            return "SHA-512";
        }
        if (str.equals("1.2.840.10045.4.1")) {
            return "SHA1withECDSA";
        }
        if (str.equals("1.2.840.10045.4.3.1")) {
            return "SHA224withECDSA";
        }
        if (str.equals("1.2.840.10045.4.3.2")) {
            return "SHA256withECDSA";
        }
        if (str.equals("1.2.840.10045.4.3.3")) {
            return "SHA384withECDSA";
        }
        if (str.equals("1.2.840.10045.4.3.4")) {
            return "SHA512withECDSA";
        }
        if (str.equals("1.2.840.113549.1.1.1")) {
            return "RSA";
        }
        if (str.equals("1.2.840.113549.1.1.2")) {
            return "MD2withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.3")) {
            return "MD4withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.4")) {
            return "MD5withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.5")) {
            return "SHA1withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.11")) {
            return "SHA256withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.12")) {
            return "SHA384withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.13")) {
            return "SHA512withRSA";
        }
        if (str.equals("1.2.840.113549.1.1.14")) {
            return "SHA224withRSA";
        }
        if (str.equals("1.3.14.3.2.26")) {
            return "SHA-1";
        }
        if (str.equals("1.2.840.113549.1.1.10")) {
            return "SSAwithRSA/PSS";
        }
        if (str.equals("1.2.840.113549.1.1.8")) {
            return "MGF1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown OID ");
        stringBuilder.append(str);
        throw new NoSuchAlgorithmException(stringBuilder.toString());
    }

    private static void a(Collection<Attribute> collection, String str, byte[] bArr) {
        for (Attribute attribute : collection) {
            if ("1.2.840.113549.1.9.4".equals(attribute.getAttrType().getId())) {
                ASN1Set attrValues = attribute.getAttrValues();
                if (attrValues.size() != 1) {
                    LOGGER.warning("Expected only one attribute value in signedAttribute message digest in eContent!");
                }
                byte[] octets = ((DEROctetString) attrValues.getObjectAt(0)).getOctets();
                if (octets == null) {
                    LOGGER.warning("Error extracting signedAttribute message digest in eContent!");
                }
                if (!Arrays.equals(octets, MessageDigest.getInstance(str).digest(bArr))) {
                    throw new SignatureException("Error checking signedAttribute message digest in eContent!");
                }
            }
        }
    }

    private static List<Attribute> a(ASN1Set aSN1Set) {
        List<ASN1Sequence> list = Collections.list(aSN1Set.getObjects());
        List<Attribute> arrayList = new ArrayList(list.size());
        for (ASN1Sequence instance : list) {
            arrayList.add(Attribute.getInstance(instance));
        }
        return arrayList;
    }

    private static SignerInfo g(SignedData signedData) {
        ASN1Set signerInfos = signedData.getSignerInfos();
        if (signerInfos == null || signerInfos.size() <= 0) {
            throw new IllegalArgumentException("No signer info in signed data");
        }
        if (signerInfos.size() > 1) {
            Logger logger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found ");
            stringBuilder.append(signerInfos.size());
            stringBuilder.append(" signerInfos");
            logger.warning(stringBuilder.toString());
        }
        return SignerInfo.getInstance(signerInfos.getObjectAt(0));
    }
}
