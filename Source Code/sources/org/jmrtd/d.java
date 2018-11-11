package org.jmrtd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.util.Hex;
import org.jmrtd.lds.PACEInfo.a;
import org.jmrtd.lds.SecurityInfo;
import org.jmrtd.lds.icao.MRZInfo;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jce.ECNamedCurveTable;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.Fp;

/* compiled from: Util */
public class d {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final Provider fbP = new BouncyCastleProvider();

    public static Provider bAA() {
        return fbP;
    }

    public static SecretKey o(byte[] bArr, int i) {
        return a(bArr, "DESede", 128, i);
    }

    public static SecretKey a(byte[] bArr, String str, int i, int i2) {
        return a(bArr, str, i, null, i2);
    }

    public static SecretKey a(byte[] bArr, String str, int i, byte[] bArr2, int i2) {
        return a(bArr, str, i, bArr2, i2, (byte) 0);
    }

    public static SecretKey a(byte[] bArr, String str, int i, byte[] bArr2, int i2, byte b) {
        MessageDigest ns = ns(ae(str, i));
        ns.reset();
        ns.update(bArr);
        if (bArr2 != null) {
            ns.update(bArr2);
        }
        ns.update(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) i2});
        Object digest = ns.digest();
        byte[] bArr3 = null;
        if ("DESede".equalsIgnoreCase(str) || "3DES".equalsIgnoreCase(str)) {
            if (i == 112 || i == 128) {
                bArr3 = new byte[24];
                System.arraycopy(digest, 0, bArr3, 0, 8);
                System.arraycopy(digest, 8, bArr3, 8, 8);
                System.arraycopy(digest, 0, bArr3, 16, 8);
            } else {
                throw new IllegalArgumentException("KDF can only use DESede with 128-bit key length");
            }
        } else if ("AES".equalsIgnoreCase(str) || str.startsWith("AES")) {
            if (i == 128) {
                bArr3 = new byte[16];
                System.arraycopy(digest, 0, bArr3, 0, 16);
            } else if (i == 192) {
                bArr3 = new byte[24];
                System.arraycopy(digest, 0, bArr3, 0, 24);
            } else if (i != 256) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("KDF can only use AES with 128-bit, 192-bit key or 256-bit length, found: ");
                stringBuilder.append(i);
                stringBuilder.append("-bit key length");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else {
                bArr3 = new byte[32];
                System.arraycopy(digest, 0, bArr3, 0, 32);
            }
        }
        if (b == (byte) 0) {
            return new SecretKeySpec(bArr3, str);
        }
        return new PACESecretKeySpec(bArr3, str, b);
    }

    public static byte[] a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(MRZInfo.nC(str));
        stringBuilder.append(str2);
        stringBuilder.append(MRZInfo.nC(str2));
        stringBuilder.append(str3);
        stringBuilder.append(MRZInfo.nC(str3));
        return p(stringBuilder.toString(), str4, z);
    }

    public static byte[] p(String str, String str2, boolean z) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        instance.update(getBytes(str));
        Object digest = instance.digest();
        if (!z) {
            return digest;
        }
        Object obj = new byte[16];
        System.arraycopy(digest, 0, obj, 0, 16);
        return obj;
    }

    public static byte[] p(byte[] bArr, int i) {
        return c(bArr, 0, bArr.length, i);
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr, i, i2);
        byteArrayOutputStream.write(-128);
        while (byteArrayOutputStream.size() % i3 != 0) {
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] unpad(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == (byte) 0) {
            length--;
        }
        if ((bArr[length] & 255) != 128) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected constant 0x80, found 0x");
            stringBuilder.append(Integer.toHexString(bArr[length] & 255));
            stringBuilder.append("\nDEBUG: in = ");
            stringBuilder.append(Hex.bytesToHexString(bArr));
            stringBuilder.append(", index = ");
            stringBuilder.append(length);
            throw new BadPaddingException(stringBuilder.toString());
        }
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, obj, 0, length);
        return obj;
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("Plaintext is too short to recover message");
        } else if (((bArr[bArr.length - 1] & 15) ^ 12) != 0) {
            throw new NumberFormatException("Could not get M1, malformed trailer");
        } else {
            int i2;
            if (((bArr[bArr.length - 1] & 255) ^ 188) == 0) {
                i2 = 1;
            } else if (((bArr[bArr.length - 1] & 255) ^ 204) == 0) {
                i2 = 2;
            } else {
                throw new NumberFormatException("Not an ISO 9796-2 scheme 2 signature trailer");
            }
            if (((bArr[0] & 192) ^ 64) != 0) {
                throw new NumberFormatException("Could not get M1");
            } else if ((bArr[0] & 32) == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not get M1, first byte indicates partial recovery not enabled: ");
                stringBuilder.append(Integer.toHexString(bArr[0]));
                throw new NumberFormatException(stringBuilder.toString());
            } else {
                int i3 = 0;
                while (i3 < bArr.length && ((bArr[i3] & 15) ^ 10) != 0) {
                    i3++;
                }
                i3++;
                int length = ((bArr.length - i2) - i) - i3;
                if (length <= 0) {
                    throw new NumberFormatException("Could not get M1");
                }
                Object obj = new byte[length];
                System.arraycopy(bArr, i3, obj, 0, length);
                return obj;
            }
        }
    }

    public static byte[] a(BigInteger bigInteger, int i) {
        BigInteger valueOf = BigInteger.valueOf(256);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            BigInteger mod = bigInteger.mod(valueOf);
            bigInteger = bigInteger.divide(valueOf);
            bArr[(i - 1) - i2] = (byte) mod.intValue();
        }
        return bArr;
    }

    public static byte[] a(BigInteger bigInteger) {
        int length = bigInteger.toString(16).length();
        if (length % 2 != 0) {
            length++;
        }
        return a(bigInteger, length / 2);
    }

    public static BigInteger ak(byte[] bArr) {
        if (bArr != null) {
            return s(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException();
    }

    public static BigInteger s(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException();
        }
        BigInteger bigInteger = BigInteger.ZERO;
        BigInteger valueOf = BigInteger.valueOf(256);
        BigInteger bigInteger2 = bigInteger;
        for (int i3 = i; i3 < i + i2; i3++) {
            bigInteger2 = bigInteger2.multiply(valueOf).add(BigInteger.valueOf((long) (bArr[i3] & 255)));
        }
        return bigInteger2;
    }

    public static String np(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String str2 = null;
        str = str.toUpperCase();
        if (str.contains("WITH")) {
            str2 = str.split("WITH")[0];
        }
        if ("SHA1".equalsIgnoreCase(str2)) {
            return "SHA-1";
        }
        if ("SHA224".equalsIgnoreCase(str2)) {
            return "SHA-224";
        }
        if ("SHA256".equalsIgnoreCase(str2)) {
            return "SHA-256";
        }
        if ("SHA384".equalsIgnoreCase(str2)) {
            return "SHA-384";
        }
        return "SHA512".equalsIgnoreCase(str2) ? "SHA-512" : str2;
    }

    public static String ae(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if ("DESede".equals(str) || "AES-128".equals(str)) {
            return "SHA-1";
        } else {
            if ("AES".equals(str) && i == 128) {
                return "SHA-1";
            }
            if ("AES-256".equals(str) || "AES-192".equals(str)) {
                return "SHA-256";
            }
            if ("AES".equals(str) && (i == 192 || i == 256)) {
                return "SHA-256";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported cipher algorithm or key length \"");
            stringBuilder.append(str);
            stringBuilder.append("\", ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static DHParameterSpec a(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g = dHParameters.getG();
        BigInteger q = dHParameters.getQ();
        int l = dHParameters.getL();
        if (q == null) {
            return new DHParameterSpec(p, g, l);
        }
        return new a(p, g, q);
    }

    public static String a(PublicKey publicKey) {
        if (publicKey == null) {
            return "null";
        }
        String algorithm = publicKey.getAlgorithm();
        StringBuilder stringBuilder;
        if (publicKey instanceof RSAPublicKey) {
            int bitLength = ((RSAPublicKey) publicKey).getModulus().bitLength();
            stringBuilder = new StringBuilder();
            stringBuilder.append(algorithm);
            stringBuilder.append(" [");
            stringBuilder.append(bitLength);
            stringBuilder.append(" bit]");
            algorithm = stringBuilder.toString();
        } else if (publicKey instanceof ECPublicKey) {
            String a = a(((ECPublicKey) publicKey).getParams());
            if (a != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(algorithm);
                stringBuilder.append(" [");
                stringBuilder.append(a);
                stringBuilder.append("]");
                algorithm = stringBuilder.toString();
            }
        }
        return algorithm;
    }

    public static String a(ECParameterSpec eCParameterSpec) {
        ECNamedCurveSpec c = c(eCParameterSpec);
        if (c == null) {
            return null;
        }
        return c.getName();
    }

    public static ECParameterSpec a(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return b(b(eCNamedCurveParameterSpec));
    }

    public static ECParameterSpec b(ECParameterSpec eCParameterSpec) {
        try {
            ECPoint generator = eCParameterSpec.getGenerator();
            BigInteger order = eCParameterSpec.getOrder();
            int cofactor = eCParameterSpec.getCofactor();
            EllipticCurve curve = eCParameterSpec.getCurve();
            BigInteger a = curve.getA();
            BigInteger b = curve.getB();
            ECField field = curve.getField();
            if (field instanceof ECFieldFp) {
                return new ECParameterSpec(new EllipticCurve(new ECFieldFp(((ECFieldFp) field).getP()), a, b), generator, order, cofactor);
            }
            if (field instanceof ECFieldF2m) {
                return new ECParameterSpec(new EllipticCurve(new ECFieldF2m(((ECFieldF2m) field).getM()), a, b), generator, order, cofactor);
            }
            LOGGER.warning("Could not make named EC param spec explicit");
            return eCParameterSpec;
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Could not make named EC param spec explicit", e);
            return eCParameterSpec;
        }
    }

    private static ECNamedCurveSpec c(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec == null) {
            return null;
        }
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            return (ECNamedCurveSpec) eCParameterSpec;
        }
        List<String> list = Collections.list(ECNamedCurveTable.getNames());
        List arrayList = new ArrayList();
        for (String parameterSpec : list) {
            ECNamedCurveSpec b = b(ECNamedCurveTable.getParameterSpec(parameterSpec));
            if (b.getCurve().equals(eCParameterSpec.getCurve()) && b.getGenerator().equals(eCParameterSpec.getGenerator()) && b.getOrder().equals(eCParameterSpec.getOrder()) && b.getCofactor() == eCParameterSpec.getCofactor()) {
                arrayList.add(b);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (ECNamedCurveSpec) arrayList.get(0);
        }
        return (ECNamedCurveSpec) arrayList.get(0);
    }

    public static ECNamedCurveSpec b(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return new ECNamedCurveSpec(eCNamedCurveParameterSpec.getName(), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.getG(), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH(), eCNamedCurveParameterSpec.getSeed());
    }

    public static SubjectPublicKeyInfo b(PublicKey publicKey) {
        ASN1InputStream aSN1InputStream;
        try {
            String algorithm = publicKey.getAlgorithm();
            StringBuilder stringBuilder;
            if ("EC".equals(algorithm) || "ECDH".equals(algorithm) || (publicKey instanceof ECPublicKey)) {
                aSN1InputStream = new ASN1InputStream(publicKey.getEncoded());
                SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(aSN1InputStream.readObject());
                AlgorithmIdentifier algorithm2 = instance.getAlgorithm();
                String id = algorithm2.getAlgorithm().getId();
                if (SecurityInfo.fcU.equals(id)) {
                    ASN1Primitive toASN1Primitive = algorithm2.getParameters().toASN1Primitive();
                    if (toASN1Primitive instanceof ASN1ObjectIdentifier) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) toASN1Primitive;
                        X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
                        if (byOID == null) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Could not find X9.62 named curve for OID ");
                            stringBuilder.append(aSN1ObjectIdentifier.getId());
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                        org.spongycastle.math.ec.ECPoint g = byOID.getG();
                        X9ECParameters x9ECParameters = new X9ECParameters(byOID.getCurve(), g.getCurve().createPoint(g.getX().toBigInteger(), g.getY().toBigInteger(), false), byOID.getN(), byOID.getH(), byOID.getSeed());
                        if (publicKey instanceof org.spongycastle.jce.interfaces.ECPublicKey) {
                            org.spongycastle.jce.interfaces.ECPublicKey eCPublicKey = (org.spongycastle.jce.interfaces.ECPublicKey) publicKey;
                            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(instance.getAlgorithm().getAlgorithm(), x9ECParameters.toASN1Primitive());
                            org.spongycastle.math.ec.ECPoint q = eCPublicKey.getQ();
                            Logger logger = LOGGER;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("DEBUG: =====> q ");
                            stringBuilder2.append(q);
                            logger.info(stringBuilder2.toString());
                            instance = new SubjectPublicKeyInfo(algorithmIdentifier, q.getEncoded());
                            aSN1InputStream.close();
                            return instance;
                        }
                        aSN1InputStream.close();
                        return instance;
                    }
                    aSN1InputStream.close();
                    return instance;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Was expecting id-ecPublicKey (");
                stringBuilder.append(SecurityInfo.fcT);
                stringBuilder.append("), found ");
                stringBuilder.append(id);
                throw new IllegalStateException(stringBuilder.toString());
            } else if ("DH".equals(algorithm) || (publicKey instanceof DHPublicKey)) {
                aSN1InputStream = new ASN1InputStream(publicKey.getEncoded());
                AlgorithmIdentifier algorithm3 = SubjectPublicKeyInfo.getInstance(aSN1InputStream.readObject()).getAlgorithm();
                DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
                DHParameterSpec params = dHPublicKey.getParams();
                SubjectPublicKeyInfo subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(algorithm3.getAlgorithm(), new DHParameter(params.getP(), params.getG(), params.getL()).toASN1Primitive()), new ASN1Integer(dHPublicKey.getY()));
                aSN1InputStream.close();
                return subjectPublicKeyInfo;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unrecognized key type, found ");
                stringBuilder.append(publicKey.getAlgorithm());
                stringBuilder.append(", should be DH or ECDH");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        } catch (Throwable th) {
            aSN1InputStream.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A:{Splitter: B:1:0x0001, ExcHandler: java.lang.Exception (r5_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:6:0x0017, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:?, code:
            LOGGER.log(java.util.logging.Level.FINE, "Not DH public key? Fine, let's try EC public key", r5);
     */
    /* JADX WARNING: Missing block: B:9:0x002d, code:
            return java.security.KeyFactory.getInstance("EC", fbP).generatePublic(r1);
     */
    /* JADX WARNING: Missing block: B:10:0x002e, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x002f, code:
            LOGGER.log(java.util.logging.Level.WARNING, "Exception", r5);
     */
    /* JADX WARNING: Missing block: B:12:0x0038, code:
            return null;
     */
    public static java.security.PublicKey a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r5) {
        /*
        r0 = 0;
        r1 = "DER";
        r5 = r5.getEncoded(r1);	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r1 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r1.<init>(r5);	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r5 = "DH";
        r5 = java.security.KeyFactory.getInstance(r5);	 Catch:{ GeneralSecurityException -> 0x0017, Exception -> 0x002e }
        r5 = r5.generatePublic(r1);	 Catch:{ GeneralSecurityException -> 0x0017, Exception -> 0x002e }
        return r5;
    L_0x0017:
        r5 = move-exception;
        r2 = LOGGER;	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r3 = java.util.logging.Level.FINE;	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r4 = "Not DH public key? Fine, let's try EC public key";
        r2.log(r3, r4, r5);	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r5 = "EC";
        r2 = fbP;	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r5 = java.security.KeyFactory.getInstance(r5, r2);	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        r5 = r5.generatePublic(r1);	 Catch:{ GeneralSecurityException -> 0x0039, Exception -> 0x002e }
        return r5;
    L_0x002e:
        r5 = move-exception;
        r1 = LOGGER;
        r2 = java.util.logging.Level.WARNING;
        r3 = "Exception";
        r1.log(r2, r3, r5);
        return r0;
    L_0x0039:
        r5 = move-exception;
        r1 = LOGGER;
        r2 = java.util.logging.Level.WARNING;
        r3 = "Exception";
        r1.log(r2, r3, r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.d.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):java.security.PublicKey");
    }

    public static PublicKey c(PublicKey publicKey) {
        if (!(publicKey instanceof ECPublicKey)) {
            return publicKey;
        }
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            return KeyFactory.getInstance("EC", fbP).generatePublic(new ECPublicKeySpec(eCPublicKey.getW(), b(eCPublicKey.getParams())));
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Could not make public key param spec explicit", e);
            return publicKey;
        }
    }

    public static byte[] a(String str, PublicKey publicKey) {
        return a(str, publicKey, true);
    }

    public static byte[] a(String str, PublicKey publicKey, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
        try {
            tLVOutputStream.writeTag(32585);
            BigInteger p;
            if (publicKey instanceof DHPublicKey) {
                DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
                DHParameterSpec params = dHPublicKey.getParams();
                p = params.getP();
                int l = params.getL();
                BigInteger g = params.getG();
                BigInteger y = dHPublicKey.getY();
                tLVOutputStream.write(new ASN1ObjectIdentifier(str).getEncoded());
                if (!z) {
                    tLVOutputStream.writeTag(129);
                    tLVOutputStream.writeValue(a(p));
                    tLVOutputStream.writeTag(130);
                    tLVOutputStream.writeValue(a(BigInteger.valueOf((long) l)));
                    tLVOutputStream.writeTag(131);
                    tLVOutputStream.writeValue(a(g));
                }
                tLVOutputStream.writeTag(132);
                tLVOutputStream.writeValue(a(y));
            } else if (publicKey instanceof ECPublicKey) {
                ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
                AlgorithmParameterSpec params2 = eCPublicKey.getParams();
                p = a(params2);
                EllipticCurve curve = params2.getCurve();
                BigInteger a = curve.getA();
                BigInteger b = curve.getB();
                ECPoint generator = params2.getGenerator();
                BigInteger order = params2.getOrder();
                int cofactor = params2.getCofactor();
                ECPoint w = eCPublicKey.getW();
                tLVOutputStream.write(new ASN1ObjectIdentifier(str).getEncoded());
                if (!z) {
                    tLVOutputStream.writeTag(129);
                    tLVOutputStream.writeValue(a(p));
                    tLVOutputStream.writeTag(130);
                    tLVOutputStream.writeValue(a(a));
                    tLVOutputStream.writeTag(131);
                    tLVOutputStream.writeValue(a(b));
                    BigInteger affineX = generator.getAffineX();
                    BigInteger affineY = generator.getAffineY();
                    tLVOutputStream.writeTag(132);
                    tLVOutputStream.write(a(affineX));
                    tLVOutputStream.write(a(affineY));
                    tLVOutputStream.writeValueEnd();
                    tLVOutputStream.writeTag(133);
                    tLVOutputStream.writeValue(a(order));
                }
                tLVOutputStream.writeTag(134);
                tLVOutputStream.writeValue(a(w));
                if (!z) {
                    tLVOutputStream.writeTag(135);
                    tLVOutputStream.writeValue(a(BigInteger.valueOf((long) cofactor)));
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported public key: ");
                stringBuilder.append(publicKey.getClass().getCanonicalName());
                throw new InvalidKeyException(stringBuilder.toString());
            }
            tLVOutputStream.writeValueEnd();
            tLVOutputStream.flush();
            try {
                tLVOutputStream.close();
            } catch (Throwable e) {
                LOGGER.log(Level.FINE, "Error closing stream", e);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e2) {
            LOGGER.log(Level.WARNING, "Exception", e2);
            throw new IllegalStateException("Error in encoding public key");
        } catch (Throwable th) {
            try {
                tLVOutputStream.close();
            } catch (Throwable e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
        }
    }

    public static byte[] d(PublicKey publicKey) {
        if (publicKey == null) {
            throw new IllegalArgumentException("Cannot encode null public key");
        } else if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(a(eCPublicKey.getW()));
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable e) {
                throw new IllegalStateException("Internal error writing to memory", e);
            }
        } else if (publicKey instanceof DHPublicKey) {
            return a(((DHPublicKey) publicKey).getY());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported public key: ");
            stringBuilder.append(publicKey.getClass().getCanonicalName());
            throw new InvalidKeyException(stringBuilder.toString());
        }
    }

    public static ECPoint al(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            if (dataInputStream.read() != 4) {
                throw new IllegalArgumentException("Expected encoded ECPoint to start with 0x04");
            }
            int length = (bArr.length - 1) / 2;
            byte[] bArr2 = new byte[length];
            bArr = new byte[length];
            dataInputStream.readFully(bArr2);
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            ECPoint eCPoint = new ECPoint(ak(bArr2), ak(bArr));
            try {
                dataInputStream.close();
            } catch (Throwable e) {
                LOGGER.log(Level.FINE, "Error closing stream", e);
            }
            return eCPoint;
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Exception", e2);
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
        }
    }

    public static byte[] a(ECPoint eCPoint) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        try {
            byteArrayOutputStream.write(4);
            byteArrayOutputStream.write(a(affineX));
            byteArrayOutputStream.write(a(affineY));
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new IllegalStateException("Exception", e);
        }
    }

    public static PublicKey a(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec == null) {
            throw new IllegalArgumentException("Params cannot be null");
        }
        DataInputStream dataInputStream;
        try {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                return a("EC", new ECPublicKeySpec(al(bArr), (ECParameterSpec) algorithmParameterSpec));
            }
            if (algorithmParameterSpec instanceof DHParameterSpec) {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                if (dataInputStream.read() != 4) {
                    throw new IllegalArgumentException("Expected encoded public key to start with 0x04");
                }
                bArr = new byte[(bArr.length - 1)];
                dataInputStream.readFully(bArr);
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                PublicKey a = a("DH", new DHPublicKeySpec(ak(bArr), dHParameterSpec.getP(), dHParameterSpec.getG()));
                dataInputStream.close();
                return a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ECParameterSpec or DHParameterSpec, found ");
            stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
            throw new IllegalArgumentException(stringBuilder.toString());
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            LOGGER.log(Level.WARNING, "Exception", e2);
            throw new IllegalArgumentException(e2);
        } catch (Throwable th) {
            dataInputStream.close();
        }
    }

    public static ECPoint a(ECPoint eCPoint, ECPoint eCPoint2, ECParameterSpec eCParameterSpec) {
        return a(a(eCPoint, eCParameterSpec).add(a(eCPoint2, eCParameterSpec)));
    }

    public static ECPoint a(BigInteger bigInteger, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return a(a(eCPoint, eCParameterSpec).multiply(bigInteger));
    }

    public static byte[] getBytes(String str) {
        byte[] bytes = str.getBytes();
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return bytes;
        }
    }

    public static BigInteger a(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec == null) {
            throw new IllegalArgumentException("Parameters null");
        } else if (algorithmParameterSpec instanceof DHParameterSpec) {
            return ((DHParameterSpec) algorithmParameterSpec).getP();
        } else {
            StringBuilder stringBuilder;
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECField field = ((ECParameterSpec) algorithmParameterSpec).getCurve().getField();
                if (field instanceof ECFieldFp) {
                    return ((ECFieldFp) field).getP();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Was expecting prime field of type ECFieldFp, found ");
                stringBuilder.append(field.getClass().getCanonicalName());
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported agreement algorithm, was expecting DHParameterSpec or ECParameterSpec, found ");
            stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static byte[] a(byte b, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Data to wrap is null");
        }
        Object obj = new byte[(bArr.length + 2)];
        obj[0] = b;
        obj[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, obj, 2, bArr.length);
        return obj;
    }

    public static byte[] b(byte b, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            throw new IllegalArgumentException("Wrapped data is null or length < 2");
        }
        byte b2 = bArr[0];
        if (b2 != b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected tag ");
            stringBuilder.append(Integer.toHexString(b));
            stringBuilder.append(", found tag ");
            stringBuilder.append(Integer.toHexString(b2));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Object obj = new byte[(bArr.length - 2)];
        System.arraycopy(bArr, 2, obj, 0, obj.length);
        return obj;
    }

    public static org.spongycastle.math.ec.ECPoint a(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return d(eCParameterSpec).createPoint(eCPoint.getAffineX(), eCPoint.getAffineY(), false);
    }

    public static ECPoint a(org.spongycastle.math.ec.ECPoint eCPoint) {
        eCPoint = eCPoint.normalize();
        if (!eCPoint.isValid()) {
            LOGGER.warning("point not valid");
        }
        return new ECPoint(eCPoint.getAffineXCoord().toBigInteger(), eCPoint.getAffineYCoord().toBigInteger());
    }

    public static ECPoint b(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return a(a(eCPoint, eCParameterSpec).normalize());
    }

    private static ECCurve d(ECParameterSpec eCParameterSpec) {
        EllipticCurve curve = eCParameterSpec.getCurve();
        ECField field = curve.getField();
        if (field instanceof ECFieldFp) {
            int cofactor = eCParameterSpec.getCofactor();
            BigInteger order = eCParameterSpec.getOrder();
            return new Fp(a((AlgorithmParameterSpec) eCParameterSpec), curve.getA(), curve.getB(), order, BigInteger.valueOf((long) cofactor));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Only prime field supported (for now), found ");
        stringBuilder.append(field.getClass().getCanonicalName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static ECPublicKeyParameters a(ECPublicKey eCPublicKey) {
        ECParameterSpec params = eCPublicKey.getParams();
        return new ECPublicKeyParameters(a(eCPublicKey.getW(), params), e(params));
    }

    public static ECPrivateKeyParameters a(ECPrivateKey eCPrivateKey) {
        return new ECPrivateKeyParameters(eCPrivateKey.getS(), e(eCPrivateKey.getParams()));
    }

    public static ECDomainParameters e(ECParameterSpec eCParameterSpec) {
        return new ECDomainParameters(d(eCParameterSpec), a(eCParameterSpec.getGenerator(), eCParameterSpec), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static Cipher nq(String str) {
        try {
            return Cipher.getInstance(str);
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this cipher, falling back to explicit BC", e);
            return Cipher.getInstance(str, fbP);
        }
    }

    public static Cipher a(String str, int i, Key key) {
        try {
            Cipher instance = Cipher.getInstance(str);
            instance.init(i, key);
            return instance;
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Cipher, falling back to explicit BC", e);
            Cipher instance2 = Cipher.getInstance(str, fbP);
            instance2.init(i, key);
            return instance2;
        }
    }

    public static Mac nr(String str) {
        try {
            return Mac.getInstance(str);
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", e);
            return Mac.getInstance(str, fbP);
        }
    }

    public static Mac a(String str, Key key) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key);
            return instance;
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", e);
            Mac instance2 = Mac.getInstance(str, fbP);
            instance2.init(key);
            return instance2;
        }
    }

    public static MessageDigest ns(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Message Digest, falling back to explicit BC", e);
            return MessageDigest.getInstance(str, fbP);
        }
    }

    public static PublicKey a(String str, KeySpec keySpec) {
        try {
            return KeyFactory.getInstance(str).generatePublic(keySpec);
        } catch (Throwable e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Factory or Public Key, falling back to explicit BC", e);
            return KeyFactory.getInstance(str, fbP).generatePublic(keySpec);
        }
    }
}
