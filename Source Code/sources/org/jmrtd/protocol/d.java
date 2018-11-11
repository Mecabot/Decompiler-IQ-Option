package org.jmrtd.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.util.Hex;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.BACKeySpec;
import org.jmrtd.PACEKeySpec;
import org.jmrtd.PACESecretKeySpec;
import org.jmrtd.PassportService;
import org.jmrtd.b;
import org.jmrtd.lds.PACEInfo;
import org.jmrtd.lds.PACEInfo.MappingType;
import org.jmrtd.lds.PACEInfo.a;
import org.jmrtd.protocol.PACEResult.PACEGMMappingResult;
import org.jmrtd.protocol.PACEResult.PACEGMWithDHMappingResult;
import org.jmrtd.protocol.PACEResult.PACEGMWithECDHMappingResult;
import org.jmrtd.protocol.PACEResult.PACEIMMappingResult;
import org.jmrtd.protocol.PACEResult.PACEMappingResult;

/* compiled from: PACEProtocol */
public class d {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final Provider fbP = org.jmrtd.d.bAA();
    private static final byte[] fdd = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private static final byte[] fde = new byte[]{(byte) -90, (byte) 104, (byte) -119, (byte) 42, (byte) 124, (byte) 65, (byte) -29, (byte) -54, (byte) 115, (byte) -97, (byte) 64, (byte) -80, (byte) 87, (byte) -40, (byte) 89, (byte) 4};
    private static final byte[] fdf = new byte[]{(byte) -92, (byte) -31, (byte) 54, (byte) -84, (byte) 114, (byte) 95, (byte) 115, (byte) -117, (byte) 1, (byte) -63, (byte) -10, (byte) 2, (byte) 23, (byte) -63, (byte) -120, (byte) -83};
    private static final byte[] fdg = new byte[]{(byte) -44, (byte) 99, (byte) -42, (byte) 82, (byte) 52, (byte) 18, (byte) 78, (byte) -9, (byte) -119, (byte) 112, (byte) 84, (byte) -104, (byte) 109, (byte) -54, (byte) 10, (byte) 23, (byte) 78, (byte) 40, (byte) -33, (byte) 117, (byte) -116, (byte) -70, (byte) -96, (byte) 63, (byte) 36, (byte) 6, (byte) 22, (byte) 65, (byte) 77, (byte) 90, (byte) 22, (byte) 118};
    private static final byte[] fdh = new byte[]{(byte) 84, (byte) -67, (byte) 114, (byte) 85, (byte) -16, (byte) -86, (byte) -8, (byte) 49, (byte) -66, (byte) -61, (byte) 66, (byte) 63, (byte) -49, (byte) 57, (byte) -42, (byte) -101, (byte) 108, (byte) -65, (byte) 6, (byte) 102, (byte) 119, (byte) -48, (byte) -6, (byte) -82, (byte) 90, (byte) -83, (byte) -39, (byte) -99, (byte) -8, (byte) -27, (byte) 53, (byte) 23};
    private PassportService fbN;
    private Random random = new SecureRandom();
    private SecureMessagingWrapper wrapper;

    public d(PassportService passportService, SecureMessagingWrapper secureMessagingWrapper) {
        this.fbN = passportService;
        this.wrapper = secureMessagingWrapper;
    }

    @Deprecated
    public PACEResult a(KeySpec keySpec, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        if (keySpec instanceof AccessKeySpec) {
            return a((AccessKeySpec) keySpec, str, algorithmParameterSpec);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong key type: ");
        stringBuilder.append(keySpec.getClass().getSimpleName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public PACEResult a(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            return a(accessKeySpec, a((KeySpec) accessKeySpec, str), str, algorithmParameterSpec);
        } catch (Throwable e) {
            throw new b("PCD side error in key derivation step", e);
        }
    }

    private PACEResult a(AccessKeySpec accessKeySpec, SecretKey secretKey, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        byte[] bArr;
        Throwable th;
        byte[] bArr2;
        SecretKey secretKey2 = secretKey;
        MappingType nx = PACEInfo.nx(str);
        String ny = PACEInfo.ny(str);
        String nz = PACEInfo.nz(str);
        String nA = PACEInfo.nA(str);
        int nB = PACEInfo.nB(str);
        a(ny, nz, nA, nB, algorithmParameterSpec);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nz);
            stringBuilder.append("/CBC/NoPadding");
            Cipher instance = Cipher.getInstance(stringBuilder.toString());
            try {
                this.fbN.a(this.wrapper, str, secretKey2 instanceof PACESecretKeySpec ? ((PACESecretKeySpec) secretKey2).bAy() : 1, null);
                PACEMappingResult a = a(nx, ny, algorithmParameterSpec, a(secretKey2, instance), instance);
                AlgorithmParameterSpec bBZ = a.bBZ();
                KeyPair a2 = a(ny, bBZ);
                PublicKey a3 = a(a2.getPublic(), bBZ);
                byte[] a4 = a(ny, a2.getPrivate(), a3);
                try {
                    Key a5 = org.jmrtd.d.a(a4, nz, nB, 1);
                    SecretKey a6 = org.jmrtd.d.a(a4, nz, nB, 2);
                    PublicKey publicKey = a3;
                    KeyPair keyPair = a2;
                    a4 = a(str, nx, a2, a3, a6);
                    try {
                        Logger logger;
                        StringBuilder stringBuilder2;
                        if (nz.startsWith("DESede")) {
                            this.wrapper = new DESedeSecureMessagingWrapper(a5, a6);
                        } else {
                            SecretKey secretKey3 = a6;
                            if (nz.startsWith("AES")) {
                                this.wrapper = new AESSecureMessagingWrapper(a5, secretKey3, this.wrapper == null ? 0 : this.wrapper.bBP());
                            } else {
                                logger = LOGGER;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Unsupported cipher algorithm ");
                                stringBuilder2.append(nz);
                                logger.warning(stringBuilder2.toString());
                            }
                        }
                        if (MappingType.CAM.equals(nx)) {
                            if (a4 == null) {
                                LOGGER.warning("Encrypted Chip Authentication data is null");
                            }
                            try {
                                Cipher instance2 = Cipher.getInstance("AES/CBC/NoPadding");
                                instance2.init(2, a5, new IvParameterSpec(fdd));
                                byte[] doFinal = instance2.doFinal(a4);
                                Logger logger2 = LOGGER;
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("DEBUG: paddedChipAuthenticationData = ");
                                stringBuilder3.append(Hex.bytesToHexString(doFinal));
                                logger2.info(stringBuilder3.toString());
                                byte[] unpad = org.jmrtd.d.unpad(doFinal);
                                try {
                                    logger = LOGGER;
                                    stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("DEBUG: chipAuthenticationData = ");
                                    stringBuilder2.append(Hex.bytesToHexString(unpad));
                                    logger.info(stringBuilder2.toString());
                                    bArr = unpad;
                                } catch (Throwable e) {
                                    th = e;
                                    bArr2 = unpad;
                                    LOGGER.log(Level.WARNING, "Could not decrypt Chip Authentication data", th);
                                    bArr = bArr2;
                                    return new PACECAMResult(accessKeySpec, ny, nz, nA, nB, a, keyPair, publicKey, a4, bArr, this.wrapper);
                                }
                            } catch (Throwable e2) {
                                th = e2;
                                bArr2 = null;
                                LOGGER.log(Level.WARNING, "Could not decrypt Chip Authentication data", th);
                                bArr = bArr2;
                                return new PACECAMResult(accessKeySpec, ny, nz, nA, nB, a, keyPair, publicKey, a4, bArr, this.wrapper);
                            }
                            return new PACECAMResult(accessKeySpec, ny, nz, nA, nB, a, keyPair, publicKey, a4, bArr, this.wrapper);
                        }
                        return new PACEResult(accessKeySpec, nx, ny, nz, nA, nB, a, keyPair, publicKey, this.wrapper);
                    } catch (Throwable e22) {
                        throw new IllegalStateException("Security exception in secure messaging establishment", e22);
                    }
                } catch (Throwable e222) {
                    throw new b("Security exception during secure messaging key derivation", e222);
                }
            } catch (CardServiceException e3) {
                CardServiceException cardServiceException = e3;
                throw new b("PICC side error in static PACE key derivation step", cardServiceException, cardServiceException.getSW());
            }
        } catch (Throwable e2222) {
            throw new b("PCD side error in static cipher construction during key derivation step", e2222);
        }
    }

    public byte[] a(SecretKey secretKey, Cipher cipher) {
        try {
            byte[] b = org.jmrtd.d.b(Byte.MIN_VALUE, this.fbN.a((APDUWrapper) this.wrapper, new byte[0], false));
            cipher.init(2, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(b);
        } catch (Throwable e) {
            throw new b("PCD side exception in tranceiving nonce step", e);
        } catch (CardServiceException e2) {
            throw new b("PICC side exception in tranceiving nonce step", e2);
        }
    }

    public PACEMappingResult a(MappingType mappingType, String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, Cipher cipher) {
        switch (mappingType) {
            case CAM:
            case GM:
                return a(str, algorithmParameterSpec, bArr);
            case IM:
                return a(str, algorithmParameterSpec, bArr, cipher);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported mapping type ");
                stringBuilder.append(mappingType);
                throw new b(stringBuilder.toString());
        }
    }

    public PACEGMMappingResult a(String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str, fbP);
            instance.initialize(algorithmParameterSpec);
            KeyPair generateKeyPair = instance.generateKeyPair();
            PublicKey publicKey = generateKeyPair.getPublic();
            Key key = generateKeyPair.getPrivate();
            Object a = org.jmrtd.d.a(org.jmrtd.d.b((byte) -126, this.fbN.a((APDUWrapper) this.wrapper, org.jmrtd.d.a((byte) -127, org.jmrtd.d.d(publicKey)), false)), algorithmParameterSpec);
            if ("ECDH".equals(str)) {
                c cVar = new c();
                cVar.a(key);
                ECPoint e = cVar.e(a);
                return new PACEGMWithECDHMappingResult(algorithmParameterSpec, bArr, a, generateKeyPair, e, a(bArr, e, (ECParameterSpec) algorithmParameterSpec));
            } else if ("DH".equals(str)) {
                KeyAgreement instance2 = KeyAgreement.getInstance(str);
                instance2.init(key);
                instance2.doPhase(a, true);
                byte[] generateSecret = instance2.generateSecret();
                return new PACEGMWithDHMappingResult(algorithmParameterSpec, bArr, a, generateKeyPair, generateSecret, a(bArr, org.jmrtd.d.ak(generateSecret), (DHParameterSpec) algorithmParameterSpec));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported parameters for mapping nonce, expected \"ECDH\" / ECParameterSpec or \"DH\" / DHParameterSpec, found \"");
                stringBuilder.append(str);
                stringBuilder.append("\" /");
                stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e2) {
            throw new b("PCD side error in mapping nonce step", e2);
        } catch (CardServiceException e3) {
            throw new b("PICC side exception in mapping nonce step", e3);
        }
    }

    public PACEIMMappingResult a(String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, Cipher cipher) {
        try {
            byte[] bArr2 = new byte[bArr.length];
            this.random.nextBytes(bArr2);
            this.fbN.a((APDUWrapper) this.wrapper, org.jmrtd.d.a((byte) -127, bArr2), false);
            if ("ECDH".equals(str)) {
                return new PACEIMMappingResult(algorithmParameterSpec, bArr, bArr2, a(bArr, bArr2, cipher.getAlgorithm(), (ECParameterSpec) algorithmParameterSpec));
            }
            if ("DH".equals(str)) {
                return new PACEIMMappingResult(algorithmParameterSpec, bArr, bArr2, a(bArr, bArr2, cipher.getAlgorithm(), (DHParameterSpec) algorithmParameterSpec));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported parameters for mapping nonce, expected \"ECDH\" / ECParameterSpec or \"DH\" / DHParameterSpec, found \"");
            stringBuilder.append(str);
            stringBuilder.append("\" /");
            stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
            throw new IllegalArgumentException(stringBuilder.toString());
        } catch (Throwable e) {
            throw new b("PCD side error in mapping nonce step", e);
        } catch (CardServiceException e2) {
            throw new b("PICC side exception in mapping nonce step", e2, e2.getSW());
        }
    }

    public KeyPair a(String str, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str, fbP);
            instance.initialize(algorithmParameterSpec);
            return instance.generateKeyPair();
        } catch (Throwable e) {
            throw new b("PCD side error during generation of PCD key pair", e);
        }
    }

    public PublicKey a(PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            PublicKey a = org.jmrtd.d.a(org.jmrtd.d.b((byte) -124, this.fbN.a((APDUWrapper) this.wrapper, org.jmrtd.d.a((byte) -125, org.jmrtd.d.d(publicKey)), false)), algorithmParameterSpec);
            if (!publicKey.equals(a)) {
                return a;
            }
            throw new b("PCD's public key and PICC's public key are the same in key agreement step!");
        } catch (Throwable e) {
            throw new b("PCD side exception in key agreement step", e);
        } catch (Throwable e2) {
            throw new b("PCD side exception in key agreement step", e2);
        } catch (CardServiceException e3) {
            throw new b("PICC side exception in key agreement step", e3, e3.getSW());
        }
    }

    public byte[] a(String str, PrivateKey privateKey, PublicKey publicKey) {
        try {
            KeyAgreement instance = KeyAgreement.getInstance(str, fbP);
            instance.init(privateKey);
            instance.doPhase(a(publicKey, privateKey), true);
            return instance.generateSecret();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "PCD side error during key agreement", e);
            throw new b("PCD side error during key agreement");
        }
    }

    public byte[] a(String str, MappingType mappingType, KeyPair keyPair, PublicKey publicKey, SecretKey secretKey) {
        Throwable e;
        Level level;
        String str2;
        TLVInputStream tLVInputStream;
        try {
            tLVInputStream = new TLVInputStream(new ByteArrayInputStream(this.fbN.a((APDUWrapper) this.wrapper, org.jmrtd.d.a((byte) -123, a(str, secretKey, publicKey)), true)));
            Logger logger;
            try {
                int readTag = tLVInputStream.readTag();
                if (readTag != 134) {
                    Logger logger2 = LOGGER;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Was expecting tag 0x86, found: ");
                    stringBuilder.append(Integer.toHexString(readTag));
                    logger2.warning(stringBuilder.toString());
                }
                tLVInputStream.readLength();
                byte[] readValue = tLVInputStream.readValue();
                byte[] a = a(str, secretKey, keyPair.getPublic());
                StringBuilder stringBuilder2;
                if (!Arrays.equals(a, readValue)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("PICC authentication token mismatch, expectedPICCToken = ");
                    stringBuilder2.append(Hex.bytesToHexString(a));
                    stringBuilder2.append(", piccToken = ");
                    stringBuilder2.append(Hex.bytesToHexString(readValue));
                    throw new GeneralSecurityException(stringBuilder2.toString());
                } else if (mappingType == MappingType.CAM) {
                    int readTag2 = tLVInputStream.readTag();
                    if (readTag2 != 138) {
                        logger = LOGGER;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Was expecting tag 0x8A, found: ");
                        stringBuilder2.append(Integer.toHexString(readTag2));
                        logger.warning(stringBuilder2.toString());
                    }
                    tLVInputStream.readLength();
                    a = tLVInputStream.readValue();
                    try {
                        tLVInputStream.close();
                    } catch (Throwable e2) {
                        LOGGER.log(Level.FINE, "Exception closing stream", e2);
                    }
                    return a;
                } else {
                    try {
                        tLVInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        logger = LOGGER;
                        level = Level.FINE;
                        str2 = "Exception closing stream";
                        logger.log(level, str2, e);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable e4) {
                LOGGER.log(Level.WARNING, "Could not parse step 4 response", e4);
                try {
                    tLVInputStream.close();
                } catch (IOException e5) {
                    e4 = e5;
                    logger = LOGGER;
                    level = Level.FINE;
                    str2 = "Exception closing stream";
                    logger.log(level, str2, e4);
                    return null;
                }
            }
        } catch (Throwable e42) {
            throw new b("PCD side exception in authentication token generation step", e42);
        } catch (CardServiceException e6) {
            throw new b("PICC side exception in authentication token generation step", e6, e6.getSW());
        } catch (Throwable th) {
            try {
                tLVInputStream.close();
            } catch (Throwable e22) {
                LOGGER.log(Level.FINE, "Exception closing stream", e22);
            }
        }
    }

    public static SecretKey a(KeySpec keySpec, String str) {
        return org.jmrtd.d.a(a(keySpec), PACEInfo.nz(str), PACEInfo.nB(str), null, 3, keySpec instanceof PACEKeySpec ? ((PACEKeySpec) keySpec).bAy() : (byte) 0);
    }

    public static byte[] a(KeySpec keySpec) {
        StringBuilder stringBuilder;
        if (keySpec == null) {
            throw new IllegalArgumentException("Access key cannot be null");
        } else if (keySpec instanceof BACKeySpec) {
            BACKeySpec bACKeySpec = (BACKeySpec) keySpec;
            String bAv = bACKeySpec.bAv();
            String bAw = bACKeySpec.bAw();
            String bAx = bACKeySpec.bAx();
            if (bAw == null || bAw.length() != 6) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Wrong date format used for date of birth. Expected yyMMdd, found ");
                stringBuilder2.append(bAw);
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else if (bAx == null || bAx.length() != 6) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong date format used for date of expiry. Expected yyMMdd, found ");
                stringBuilder.append(bAx);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (bAv != null) {
                return r(nH(bAv), bAw, bAx);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong document number. Found ");
                stringBuilder.append(bAv);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } else if (keySpec instanceof PACEKeySpec) {
            return ((PACEKeySpec) keySpec).getKey();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported access key, was expecting BAC or CAN key specification, found ");
            stringBuilder.append(keySpec.getClass().getSimpleName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static ECParameterSpec a(byte[] bArr, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        ECPoint generator = eCParameterSpec.getGenerator();
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a = curve.getA();
        BigInteger b = curve.getB();
        BigInteger p = ((ECFieldFp) curve.getField()).getP();
        BigInteger order = eCParameterSpec.getOrder();
        int cofactor = eCParameterSpec.getCofactor();
        ECPoint a2 = org.jmrtd.d.a(org.jmrtd.d.a(org.jmrtd.d.ak(bArr), generator, eCParameterSpec), eCPoint, eCParameterSpec);
        if (!org.jmrtd.d.a(a2, eCParameterSpec).isValid()) {
            LOGGER.info("ephemeralGenerator is not a valid point");
        }
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(p), a, b), a2, order, cofactor);
    }

    public static DHParameterSpec a(byte[] bArr, BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        BigInteger p = dHParameterSpec.getP();
        return new DHParameterSpec(p, dHParameterSpec.getG().modPow(org.jmrtd.d.ak(bArr), p).multiply(bigInteger).mod(p), dHParameterSpec.getL());
    }

    public static AlgorithmParameterSpec a(byte[] bArr, byte[] bArr2, String str, ECParameterSpec eCParameterSpec) {
        BigInteger a = org.jmrtd.d.a((AlgorithmParameterSpec) eCParameterSpec);
        BigInteger order = eCParameterSpec.getOrder();
        int cofactor = eCParameterSpec.getCofactor();
        BigInteger a2 = eCParameterSpec.getCurve().getA();
        BigInteger b = eCParameterSpec.getCurve().getB();
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(a), a2, b), a(org.jmrtd.d.ak(a(bArr, bArr2, a, str)), eCParameterSpec), order, cofactor);
    }

    public static AlgorithmParameterSpec a(byte[] bArr, byte[] bArr2, String str, DHParameterSpec dHParameterSpec) {
        BigInteger g = dHParameterSpec.getG();
        if (g == null || g.equals(BigInteger.ONE)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid generator: ");
            stringBuilder.append(g);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        g = dHParameterSpec.getP();
        return new DHParameterSpec(g, org.jmrtd.d.ak(a(bArr, bArr2, g, str)).modPow(g.subtract(BigInteger.ONE).divide(dHParameterSpec instanceof a ? ((a) dHParameterSpec).getQ() : BigInteger.ONE), g), dHParameterSpec.getL());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, BigInteger bigInteger, String str) {
        if (bArr == null || bArr2 == null) {
            throw new IllegalArgumentException("Null nonce");
        }
        byte[] bArr3;
        byte[] bArr4;
        int length = bArr.length * 8;
        int length2 = bArr2.length * 8;
        if (length == 128) {
            bArr3 = fde;
            bArr4 = fdf;
        } else if (length == 192 || length == 256) {
            bArr3 = fdg;
            bArr4 = fdh;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown length ");
            stringBuilder.append(length);
            stringBuilder.append(", was expecting 128, 192, or 256");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str.endsWith("/CBC/NoPadding") ? "" : "/CBC/NoPadding");
        Cipher instance = Cipher.getInstance(stringBuilder2.toString());
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[instance.getBlockSize()]);
        instance.init(1, new SecretKeySpec(bArr2, str), ivParameterSpec);
        bArr = instance.doFinal(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr5 = bArr;
        int i = 0;
        while (i * length < bigInteger.bitLength() + 64) {
            try {
                instance.init(1, new SecretKeySpec(bArr5, 0, length2 / 8, str), ivParameterSpec);
                bArr5 = instance.doFinal(bArr3);
                byteArrayOutputStream.write(instance.doFinal(bArr4));
                i++;
            } catch (Throwable e) {
                LOGGER.log(Level.WARNING, "Could not write to stream", e);
                bArr = org.jmrtd.d.a(org.jmrtd.d.ak(byteArrayOutputStream.toByteArray()).mod(bigInteger));
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    LOGGER.log(Level.FINE, "Could not close stream", e2);
                }
                return bArr;
            } catch (Throwable e3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e22) {
                    LOGGER.log(Level.FINE, "Could not close stream", e22);
                }
                throw e3;
            }
        }
        bArr = org.jmrtd.d.a(org.jmrtd.d.ak(byteArrayOutputStream.toByteArray()).mod(bigInteger));
        try {
            byteArrayOutputStream.close();
        } catch (Throwable e222) {
            LOGGER.log(Level.FINE, "Could not close stream", e222);
        }
        return bArr;
    }

    public static ECPoint a(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        BigInteger a = org.jmrtd.d.a((AlgorithmParameterSpec) eCParameterSpec);
        int cofactor = eCParameterSpec.getCofactor();
        BigInteger a2 = eCParameterSpec.getCurve().getA();
        BigInteger b = eCParameterSpec.getCurve().getB();
        BigInteger mod = bigInteger.modPow(BigInteger.valueOf(2), a).negate().mod(a);
        BigInteger mod2 = mod.add(mod.modPow(BigInteger.valueOf(2), a)).mod(a);
        mod2 = b.negate().multiply(BigInteger.ONE.add(mod2)).multiply(a2.multiply(mod2).modPow(a.subtract(BigInteger.ONE).subtract(BigInteger.ONE), a)).mod(a);
        mod = mod.multiply(mod2).mod(a);
        BigInteger mod3 = mod2.modPow(BigInteger.valueOf(3), a).add(a2.multiply(mod2)).add(b).mod(a);
        mod.modPow(BigInteger.valueOf(3), a).add(a2.multiply(mod)).add(b).mod(a);
        bigInteger = bigInteger.modPow(BigInteger.valueOf(3), a).multiply(mod3).mod(a);
        a2 = mod3.modPow(a.subtract(BigInteger.ONE).subtract(a.add(BigInteger.ONE).multiply(BigInteger.valueOf(4).modInverse(a)).mod(a)), a);
        ECPoint eCPoint = a2.modPow(BigInteger.valueOf(2), a).multiply(mod3).mod(a).equals(BigInteger.ONE) ? new ECPoint(mod2, a2.multiply(mod3).mod(a)) : new ECPoint(mod, a2.multiply(bigInteger).mod(a));
        if (cofactor == 1) {
            return org.jmrtd.d.b(eCPoint, eCParameterSpec);
        }
        org.spongycastle.math.ec.ECPoint a3 = org.jmrtd.d.a(eCPoint, eCParameterSpec);
        a3.multiply(BigInteger.valueOf((long) cofactor));
        return org.jmrtd.d.a(a3);
    }

    public static PublicKey a(PublicKey publicKey, PrivateKey privateKey) {
        if ((publicKey instanceof ECPublicKey) && (privateKey instanceof ECPrivateKey)) {
            return KeyFactory.getInstance("EC", fbP).generatePublic(new ECPublicKeySpec(((ECPublicKey) publicKey).getW(), ((ECPrivateKey) privateKey).getParams()));
        }
        throw new NoSuchAlgorithmException("Unsupported key type");
    }

    public static byte[] a(String str, SecretKey secretKey, PublicKey publicKey) {
        return a(str, org.jmrtd.d.a(nI(PACEInfo.nz(str)), (Key) secretKey), publicKey);
    }

    private static byte[] a(String str, Mac mac, PublicKey publicKey) {
        Object doFinal = mac.doFinal(org.jmrtd.d.a(str, publicKey));
        Object obj = new byte[8];
        System.arraycopy(doFinal, 0, obj, 0, obj.length);
        return obj;
    }

    private static byte[] r(String str, String str2, String str3) {
        return org.jmrtd.d.a(str, str2, str3, "SHA-1", false);
    }

    private static String nH(String str) {
        str = str.replace('<', ' ').trim().replace(' ', '<');
        while (str.length() < 9) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("<");
            str = stringBuilder.toString();
        }
        return str;
    }

    private void a(String str, String str2, String str3, int i, AlgorithmParameterSpec algorithmParameterSpec) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (str == null) {
            throw new IllegalArgumentException("Unknown agreement algorithm");
        } else if (!"ECDH".equalsIgnoreCase(str) && !"DH".equalsIgnoreCase(str)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported agreement algorithm, expected ECDH or DH, found \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (str2 == null) {
            throw new IllegalArgumentException("Unknown cipher algorithm");
        } else if (!"DESede".equalsIgnoreCase(str2) && !"AES".equalsIgnoreCase(str2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported cipher algorithm, expected DESede or AES, found \"");
            stringBuilder.append(str2);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!"SHA-1".equalsIgnoreCase(str3) && !"SHA1".equalsIgnoreCase(str3) && !"SHA-256".equalsIgnoreCase(str3) && !"SHA256".equalsIgnoreCase(str3)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unsupported cipher algorithm, expected DESede or AES, found \"");
            stringBuilder2.append(str3);
            stringBuilder2.append("\"");
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else if (i != 128 && i != 192 && i != 256) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unsupported key length, expected 128, 192, or 256, found ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else if ("ECDH".equalsIgnoreCase(str) && !(algorithmParameterSpec instanceof ECParameterSpec)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ECParameterSpec for agreement algorithm \"");
            stringBuilder.append(str);
            stringBuilder.append("\", found ");
            stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if ("DH".equalsIgnoreCase(str) && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected DHParameterSpec for agreement algorithm \"");
            stringBuilder.append(str);
            stringBuilder.append("\", found ");
            stringBuilder.append(algorithmParameterSpec.getClass().getCanonicalName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static String nI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot infer MAC algorithm from cipher algorithm null");
        } else if (str.startsWith("DESede")) {
            return "ISO9797Alg3Mac";
        } else {
            if (str.startsWith("AES")) {
                return "AESCMAC";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot infer MAC algorithm from cipher algorithm \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new InvalidAlgorithmParameterException(stringBuilder.toString());
        }
    }
}
