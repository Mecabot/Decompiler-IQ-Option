package org.jmrtd.lds;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.asn1.icao.DataGroupHash;
import org.spongycastle.asn1.icao.LDSSecurityObject;

public class SODFile extends AbstractTaggedLDSFile {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -1081347374739311111L;
    private transient SignedData fcE;

    public SODFile(InputStream inputStream) {
        super(119, inputStream);
    }

    protected void r(InputStream inputStream) {
        this.fcE = b.s(inputStream);
    }

    protected void g(OutputStream outputStream) {
        b.a(this.fcE, outputStream);
    }

    public Map<Integer, byte[]> bAT() {
        DataGroupHash[] datagroupHash = a(this.fcE).getDatagroupHash();
        Map<Integer, byte[]> treeMap = new TreeMap();
        for (DataGroupHash dataGroupHash : datagroupHash) {
            treeMap.put(Integer.valueOf(dataGroupHash.getDataGroupNumber()), dataGroupHash.getDataGroupHashValue().getOctets());
        }
        return treeMap;
    }

    public byte[] getEncryptedDigest() {
        return b.e(this.fcE);
    }

    public byte[] bAU() {
        return b.d(this.fcE);
    }

    public String getDigestAlgorithm() {
        return a(a(this.fcE));
    }

    private static String a(LDSSecurityObject lDSSecurityObject) {
        try {
            return b.nt(lDSSecurityObject.getDigestAlgorithmIdentifier().getAlgorithm().getId());
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }

    public String bAV() {
        return b.b(this.fcE);
    }

    public String bAW() {
        return b.c(this.fcE);
    }

    public X509Certificate bAX() {
        return b.f(this.fcE);
    }

    public String toString() {
        try {
            X509Certificate bAX = bAX();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SODFile ");
            stringBuilder.append(bAX.getIssuerX500Principal());
            return stringBuilder.toString();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e);
            return "SODFile";
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        return Arrays.equals(getEncoded(), ((SODFile) obj).getEncoded());
    }

    public int hashCode() {
        return (Arrays.hashCode(getEncoded()) * 11) + 111;
    }

    private static LDSSecurityObject a(SignedData signedData) {
        ASN1InputStream aSN1InputStream;
        try {
            StringBuilder stringBuilder;
            ContentInfo encapContentInfo = signedData.getEncapContentInfo();
            String id = encapContentInfo.getContentType().getId();
            DEROctetString dEROctetString = (DEROctetString) encapContentInfo.getContent();
            if (!("2.23.136.1.1.1".equals(id) || "1.2.528.1.1006.1.20.1".equals(id) || "1.3.27.1.1.1".equals(id))) {
                Logger logger = LOGGER;
                stringBuilder = new StringBuilder();
                stringBuilder.append("SignedData does not appear to contain an LDS SOd. (content type is ");
                stringBuilder.append(id);
                stringBuilder.append(", was expecting ");
                stringBuilder.append("2.23.136.1.1.1");
                stringBuilder.append(")");
                logger.warning(stringBuilder.toString());
            }
            aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(dEROctetString.getOctets()));
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject instanceof ASN1Sequence) {
                LDSSecurityObject instance = LDSSecurityObject.getInstance(readObject);
                if (aSN1InputStream.readObject() != null) {
                    LOGGER.warning("Ignoring extra object found after LDSSecurityObject...");
                }
                aSN1InputStream.close();
                return instance;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ASN1Sequence, found ");
            stringBuilder.append(readObject.getClass().getSimpleName());
            throw new IllegalStateException(stringBuilder.toString());
        } catch (Throwable e) {
            throw new IllegalStateException("Could not read security object in signedData", e);
        } catch (Throwable th) {
            aSN1InputStream.close();
        }
    }
}
