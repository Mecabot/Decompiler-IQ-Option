package jumio.nv.nfc;

import android.graphics.BitmapFactory;
import android.nfc.tech.IsoDep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.dto.ToastEntity;
import com.jumio.commons.utils.IOUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.util.Hex;
import org.jmrtd.BACKey;
import org.jmrtd.PACEKeySpec;
import org.jmrtd.PassportService;
import org.jmrtd.d;
import org.jmrtd.lds.ActiveAuthenticationInfo;
import org.jmrtd.lds.CardAccessFile;
import org.jmrtd.lds.PACEInfo;
import org.jmrtd.lds.SODFile;
import org.jmrtd.lds.SecurityInfo;
import org.jmrtd.lds.a;
import org.jmrtd.lds.icao.DG15File;
import org.jmrtd.lds.icao.DG1File;
import org.jmrtd.lds.iso19794.FaceImageInfo;
import org.jmrtd.lds.iso19794.FaceInfo;

/* compiled from: NfcPassportReader */
public class i implements k {
    static final /* synthetic */ boolean a = true;
    private final String b;
    private final BACKey c;
    private final PassportService d;
    private final SecureRandom e = new SecureRandom();
    private c f;
    private Collection<Integer> g;
    private boolean h = false;
    private IsoDep i;
    private boolean j = false;

    public i(PassportService passportService, String str, Date date, Date date2, String str2) {
        this.b = str2;
        this.c = new BACKey(str, date, date2);
        this.d = passportService;
        this.g = new TreeSet();
    }

    @NonNull
    public o a() {
        o oVar = new o(p.INIT);
        f.a("PassportReader", "passport service created");
        this.d.open();
        this.j = false;
        try {
            Collection bAP = new CardAccessFile(this.d.e((short) 284)).bAP();
            if (bAP == null || bAP.size() <= 0) {
                this.j = false;
                f.a("PassportReader", "passport service opened");
                this.d.hr(this.j);
                f.a("PassportReader", "select applet done");
                oVar.a(q.SUCCESSFUL);
                this.h = a;
                return oVar;
            }
            while (bAP.iterator().hasNext()) {
                SecurityInfo securityInfo = (SecurityInfo) bAP.iterator().next();
                if (securityInfo instanceof PACEInfo) {
                    this.d.a(PACEKeySpec.a(this.c), securityInfo.bAL(), PACEInfo.b(((PACEInfo) securityInfo).bAS()));
                    break;
                }
            }
            this.j = a;
            f.a("PassportReader", "passport service opened");
            this.d.hr(this.j);
            f.a("PassportReader", "select applet done");
            oVar.a(q.SUCCESSFUL);
            this.h = a;
            return oVar;
        } catch (Exception e) {
            f.c("PassportReader", e.getMessage());
        }
    }

    @NonNull
    public o b() {
        f.a("PassportReader", "performing BAC");
        o oVar = new o(p.BAC_CHECK);
        if (this.j) {
            oVar.a(q.SUCCESSFUL);
            return oVar;
        }
        int timeout = this.i.getTimeout();
        this.i.setTimeout(ToastEntity.ALERT_TOAST_DURATION);
        if (this.d.isOpen()) {
            try {
                this.d.b(this.c);
                oVar.a(q.SUCCESSFUL);
            } catch (CardServiceException e) {
                oVar.a(q.ERROR, e);
            }
        }
        if (timeout < 1000) {
            timeout = 1000;
        }
        this.i.setTimeout(timeout);
        return oVar;
    }

    @NonNull
    public List<o> c() {
        j();
        Map bAT = this.f.b().bAT();
        List arrayList = new ArrayList();
        for (Integer intValue : bAT.keySet()) {
            int intValue2 = intValue.intValue();
            o a = a(intValue2);
            a.a(Integer.valueOf(intValue2));
            arrayList.add(a);
        }
        return arrayList;
    }

    @NonNull
    public o a(d dVar, boolean z) {
        o a = dVar.a(this.d, this.g, z);
        this.f = (c) a.g();
        return new o(p.READ_LDS, a.b());
    }

    @NonNull
    public o a(boolean z) {
        return a(new b(), z);
    }

    @NonNull
    public o d() {
        j();
        o oVar = new o(p.PASSIVE_AUTH_DSC_CHECK);
        try {
            SODFile b = this.f.b();
            if (b == null) {
                return new o(p.PASSIVE_AUTH_DSC_CHECK, q.FAILED);
            }
            Certificate bAX = b.bAX();
            bAX.checkValidity();
            if (a(b, bAX)) {
                oVar.a(q.SUCCESSFUL);
            } else {
                oVar.a(q.FAILED);
            }
            return oVar;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("#### error in Passive Authentication: ");
            stringBuilder.append(e);
            f.a("PassportReader", stringBuilder.toString());
            oVar.a(q.ERROR, e);
        }
    }

    private boolean a(SODFile sODFile, Certificate certificate) {
        String bAW;
        byte[] bAU = sODFile.bAU();
        byte[] encryptedDigest = sODFile.getEncryptedDigest();
        try {
            bAW = sODFile.bAW();
        } catch (Exception unused) {
            bAW = null;
        }
        String bAV;
        if (bAW == null) {
            MessageDigest instance;
            bAV = sODFile.bAV();
            try {
                instance = MessageDigest.getInstance(bAV);
            } catch (Exception unused2) {
                instance = MessageDigest.getInstance(bAV, d.bAA());
            }
            instance.update(bAU);
            return Arrays.equals(instance.digest(), encryptedDigest);
        }
        Signature instance2;
        if ("SSAwithRSA/PSS".equals(bAW)) {
            bAW = sODFile.bAV();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bAW.replace("-", ""));
            stringBuilder.append("withRSA/PSS");
            bAW = stringBuilder.toString();
        }
        if ("RSA".equals(bAW)) {
            bAV = sODFile.bAV();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(bAV.replace("-", ""));
            stringBuilder2.append("withRSA");
            bAW = stringBuilder2.toString();
        }
        try {
            instance2 = Signature.getInstance(bAW);
        } catch (Exception unused3) {
            instance2 = Signature.getInstance(bAW, d.bAA());
        }
        instance2.initVerify(certificate);
        instance2.update(bAU);
        return instance2.verify(encryptedDigest);
    }

    @NonNull
    public o a(h hVar) {
        o oVar = new o(p.PASSIVE_AUTH_ROOT_CERT_CHECK);
        oVar.a(q.NOT_AVAILABLE);
        for (X509Certificate x509Certificate : hVar.b(this.b)) {
            o a = a(x509Certificate);
            if (a.d()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SN=");
                stringBuilder.append(x509Certificate.getSerialNumber());
                a.a(stringBuilder.toString());
                return a;
            }
            oVar = a;
        }
        return oVar;
    }

    @NonNull
    public o e() {
        j();
        try {
            return new o(p.ACTIVE_AUTH_CHECK, this.f.b().bAT().keySet().contains(Integer.valueOf(15)) ? q.SUCCESSFUL : q.NOT_AVAILABLE);
        } catch (IOException e) {
            e.printStackTrace();
            return new o(p.ACTIVE_AUTH_CHECK, q.FAILED);
        }
    }

    @NonNull
    public o f() {
        StringBuilder stringBuilder;
        j();
        f.a("PassportReader", "perform active auth");
        o oVar = new o(p.ACTIVE_AUTH_CHECK);
        try {
            DG15File h = this.f.h();
            if (h == null) {
                f.a("PassportReader", "active auth not available, DG15 not present");
                return new o(p.ACTIVE_AUTH_CHECK, q.NOT_AVAILABLE);
            }
            String str;
            String np;
            new DG15File(this.d.e((short) 271)).getEncoded();
            PublicKey publicKey = h.getPublicKey();
            String algorithm = publicKey.getAlgorithm();
            String str2 = "SHA1";
            String str3 = "SHA1WithRSA/ISO9796-2";
            if ("EC".equals(algorithm) || "ECDSA".equals(algorithm)) {
                int i;
                List bBv = this.f.g().bBv();
                if (bBv == null) {
                    i = 0;
                } else {
                    i = bBv.size();
                }
                if (i < 1) {
                    algorithm = "Found no active authentication info in EF.DG14";
                    f.a("PassportReader", algorithm);
                    return new o(p.ACTIVE_AUTH_CHECK, q.NOT_AVAILABLE, new Throwable(algorithm));
                }
                if (i > 1) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Found ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" in EF.DG14, expected 1.");
                    f.a("PassportReader", stringBuilder2.toString());
                }
                algorithm = ActiveAuthenticationInfo.nt(((ActiveAuthenticationInfo) bBv.get(0)).bAM());
                str = algorithm;
                np = d.np(algorithm);
            } else {
                np = str2;
                str = str3;
            }
            byte[] bArr = new byte[8];
            this.e.nextBytes(bArr);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("AA challenge: ");
            stringBuilder3.append(Hex.bytesToHexString(bArr));
            f.a("PassportReader", stringBuilder3.toString());
            byte[] bBO = this.d.a(publicKey, np, str, bArr).bBO();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("AA response: ");
            stringBuilder3.append(Hex.bytesToHexString(bBO));
            f.a("PassportReader", stringBuilder3.toString());
            return a(publicKey, np, str, bArr, bBO);
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("#### error reading DG15 ");
            stringBuilder.append(e);
            f.a("PassportReader", stringBuilder.toString());
            oVar.a(q.ERROR, e);
            return oVar;
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("#### algorithm not found: ");
            stringBuilder.append(e2);
            f.a("PassportReader", stringBuilder.toString());
            oVar.a(q.ERROR, e2);
            return oVar;
        } catch (CardServiceException e3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("### card service error: ");
            stringBuilder.append(e3);
            f.a("PassportReader", stringBuilder.toString());
            oVar.a(q.ERROR, e3);
            return oVar;
        }
    }

    @NonNull
    public o g() {
        j();
        f.a("PassportReader", "downloading image");
        o oVar = new o(p.FACE_IMAGE);
        try {
            for (FaceInfo bBM : this.f.d().bBx()) {
                for (FaceImageInfo faceImageInfo : bBM.bBM()) {
                    int bAG = faceImageInfo.bAG();
                    Object mimeType = faceImageInfo.getMimeType();
                    InputStream bAH = faceImageInfo.bAH();
                    f.a("PassportReader", String.format("Image mime: %s, len = %d", new Object[]{mimeType, Integer.valueOf(bAG)}));
                    Object decodeStream;
                    if (mimeType.equals("image/jpeg") || mimeType.equals("image/png")) {
                        decodeStream = BitmapFactory.decodeStream(bAH);
                        String str = "PassportReader";
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Bitmap decoding ");
                        stringBuilder.append(decodeStream != null ? "succssful" : "failed");
                        f.a(str, stringBuilder.toString());
                        oVar.a(decodeStream != null ? q.SUCCESSFUL : q.FAILED);
                        oVar.a(decodeStream);
                    } else if (mimeType.equals("image/jp2") || mimeType.equals("mime/jpx")) {
                        byte[] toByteArray = IOUtils.toByteArray(bAH);
                        dt dtVar = new dt();
                        String[][] b = cf.b();
                        for (int length = b.length - 1; length >= 0; length--) {
                            if (b[length][3] != null) {
                                dtVar.put(b[length][0], b[length][3]);
                            }
                        }
                        decodeStream = new cf(new dt(dtVar)).a(toByteArray);
                        oVar.a(decodeStream != null ? q.SUCCESSFUL : q.FAILED);
                        oVar.a(decodeStream);
                    } else {
                        oVar.a(q.NOT_AVAILABLE);
                        oVar.a(mimeType);
                        oVar.a(q.NOT_AVAILABLE);
                        oVar.a(mimeType);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            oVar.a(q.FAILED);
        }
        return oVar;
    }

    @NonNull
    public o h() {
        f.a("PassportReader", "read passport details");
        o oVar = new o(p.ADDITIONAL_DATA);
        Object nVar = new n();
        try {
            DG1File c = this.f.c();
            if (c != null) {
                nVar.a(c.bBw());
            }
            int[] bBa = this.f.a().bBa();
            List arrayList = new ArrayList();
            for (int mt : bBa) {
                arrayList.add(Integer.valueOf(a.mt(mt)));
            }
            if (arrayList.contains(Integer.valueOf(11))) {
                f.a("PassportReader", "read DG11 - personal details");
                nVar.a(new m(this.f.e()));
            }
            if (arrayList.contains(Integer.valueOf(12))) {
                f.a("PassportReader", "read DG12 - document details");
                nVar.a(new l(this.f.f()));
            }
            oVar.a(q.SUCCESSFUL);
            oVar.a(nVar);
        } catch (Throwable e) {
            oVar.a(q.ERROR, e);
        }
        return oVar;
    }

    @Nullable
    public String i() {
        j();
        try {
            return this.f.c().bBw().toString();
        } catch (Exception e) {
            f.b("PassportReader", "error reading DG1", e);
            return null;
        }
    }

    private o a(int i) {
        j();
        short ms = a.ms(a.mu(i));
        try {
            SODFile b = this.f.b();
            byte[] bArr = (byte[]) b.bAT().get(Integer.valueOf(i));
            String digestAlgorithm = b.getDigestAlgorithm();
            StringBuilder stringBuilder;
            try {
                MessageDigest a = a(digestAlgorithm);
                StringBuilder stringBuilder2;
                if (ms == (short) 259 || ms == (short) 260) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Skipping DG");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" during HT verification because EAC not yet implemented.");
                    return new o(p.PASSIVE_AUTH_HASH_CHECK, q.NOT_AVAILABLE, new Throwable(stringBuilder2.toString()));
                }
                try {
                    InputStream c;
                    int a2 = this.f.a(ms);
                    byte[] bArr2 = null;
                    if (a2 > 0) {
                        bArr2 = new byte[a2];
                        c = this.f.c(ms);
                        Closeable dataInputStream = new DataInputStream(c);
                        dataInputStream.readFully(bArr2);
                        IOUtils.closeQuietly(dataInputStream);
                    } else {
                        c = null;
                    }
                    if (c == null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Skipping DG");
                        stringBuilder2.append(i);
                        stringBuilder2.append(" during HT verification because file could not be read.");
                        String stringBuilder3 = stringBuilder2.toString();
                        f.a("PassportReader", stringBuilder3);
                        return new o(p.PASSIVE_AUTH_HASH_CHECK, q.NOT_AVAILABLE, new Throwable(stringBuilder3));
                    }
                    try {
                        boolean equals = Arrays.equals(bArr, a.digest(bArr2));
                        digestAlgorithm = "PassportReader";
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("hash check for DG");
                        stringBuilder.append(i);
                        stringBuilder.append(": ");
                        stringBuilder.append(equals ? " -- MATCH -- " : " -- MISMATCH -- ");
                        f.a(digestAlgorithm, stringBuilder.toString());
                        return new o(p.PASSIVE_AUTH_HASH_CHECK, equals ? q.SUCCESSFUL : q.FAILED);
                    } catch (Throwable e) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("exception computing hash ");
                        stringBuilder4.append(e);
                        f.a("PassportReader", stringBuilder4.toString());
                        return new o(p.PASSIVE_AUTH_HASH_CHECK, q.ERROR, e);
                    }
                } catch (Throwable e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("#### error reading DG");
                    stringBuilder.append(i);
                    stringBuilder.append(" hash: ");
                    stringBuilder.append(e2.getMessage());
                    f.a("PassportReader", stringBuilder.toString());
                    return new o(p.PASSIVE_AUTH_HASH_CHECK, q.ERROR, e2);
                }
            } catch (Throwable e3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported algorithm \"");
                stringBuilder.append(digestAlgorithm);
                stringBuilder.append("\"");
                f.a("PassportReader", stringBuilder.toString());
                return new o(p.PASSIVE_AUTH_HASH_CHECK, q.FAILED, e3);
            } catch (Throwable e32) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported provider for algorithm \"");
                stringBuilder.append(digestAlgorithm);
                stringBuilder.append("\"");
                f.a("PassportReader", stringBuilder.toString());
                return new o(p.PASSIVE_AUTH_HASH_CHECK, q.FAILED, e32);
            }
        } catch (Exception e4) {
            p pVar = p.PASSIVE_AUTH_HASH_CHECK;
            q qVar = q.ERROR;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("DG");
            stringBuilder5.append(i);
            stringBuilder5.append(" failed, could not get stored hash");
            stringBuilder5.append(e4.getMessage());
            return new o(pVar, qVar, new Throwable(stringBuilder5.toString()));
        }
    }

    private o a(X509Certificate x509Certificate) {
        j();
        o oVar = new o(p.PASSIVE_AUTH_ROOT_CERT_CHECK);
        try {
            this.f.b().bAX().verify(x509Certificate.getPublicKey());
            oVar.a(q.SUCCESSFUL);
        } catch (Throwable e) {
            oVar.a(q.FAILED, e);
        }
        return oVar;
    }

    private MessageDigest a(String str) {
        if (Security.getAlgorithms("MessageDigest").contains(str)) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, d.bAA());
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalArgumentException (r6_25 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:47:0x0157, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:49:0x0161, code:
            throw new net.sf.scuba.smartcards.CardServiceException(r6.toString());
     */
    private jumio.nv.nfc.o a(java.security.PublicKey r6, java.lang.String r7, java.lang.String r8, byte[] r9, byte[] r10) {
        /*
        r5 = this;
        r0 = r6.getAlgorithm();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r1 = "RSA";
        r1 = r1.equals(r0);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r2 = 2;
        if (r1 == 0) goto L_0x005a;
    L_0x000d:
        r7 = java.security.MessageDigest.getInstance(r7);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0 = org.jmrtd.d.bAA();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = java.security.Signature.getInstance(r8, r0);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0 = "RSA/NONE/NoPadding";
        r0 = javax.crypto.Cipher.getInstance(r0);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = (java.security.interfaces.RSAPublicKey) r6;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0.init(r2, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8.initVerify(r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r7.getDigestLength();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7 = a;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r7 != 0) goto L_0x0039;
    L_0x002f:
        r7 = 20;
        if (r6 == r7) goto L_0x0039;
    L_0x0033:
        r6 = new java.lang.AssertionError;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6.<init>();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        throw r6;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
    L_0x0039:
        r7 = r0.doFinal(r10);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = org.jmrtd.d.a(r6, r7);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8.update(r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8.update(r9);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r8.verify(r10);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7 = new jumio.nv.nfc.o;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = jumio.nv.nfc.p.ACTIVE_AUTH_CHECK;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r6 == 0) goto L_0x0054;
    L_0x0051:
        r6 = jumio.nv.nfc.q.SUCCESSFUL;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        goto L_0x0056;
    L_0x0054:
        r6 = jumio.nv.nfc.q.FAILED;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
    L_0x0056:
        r7.<init>(r8, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        return r7;
    L_0x005a:
        r1 = "EC";
        r1 = r1.equals(r0);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r1 != 0) goto L_0x0098;
    L_0x0062:
        r1 = "ECDSA";
        r0 = r1.equals(r0);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r0 == 0) goto L_0x006b;
    L_0x006a:
        goto L_0x0098;
    L_0x006b:
        r7 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7.<init>();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = "Unsupported AA public key type ";
        r7.append(r8);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r6.getClass();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r6.getSimpleName();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7.append(r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r7.toString();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7 = "PassportReader";
        jumio.nv.nfc.f.a(r7, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7 = new jumio.nv.nfc.o;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = jumio.nv.nfc.p.ACTIVE_AUTH_CHECK;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r9 = jumio.nv.nfc.q.FAILED;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r10 = new java.lang.Throwable;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r10.<init>(r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7.<init>(r8, r9, r10);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        return r7;
    L_0x0098:
        r6 = (java.security.interfaces.ECPublicKey) r6;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0 = "SHA256withECDSA";
        r1 = org.jmrtd.d.bAA();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0 = java.security.Signature.getInstance(r0, r1);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r1 = "SHA-256";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r0 == 0) goto L_0x00b8;
    L_0x00ac:
        if (r8 == 0) goto L_0x00d2;
    L_0x00ae:
        r3 = r0.getAlgorithm();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r3 = r8.equals(r3);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r3 != 0) goto L_0x00d2;
    L_0x00b8:
        r0 = "PassportReader";
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r4 = "Re-initializing ecdsaAASignature with signature algorithm ";
        r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r3.append(r8);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        jumio.nv.nfc.f.a(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0 = java.security.Signature.getInstance(r8);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
    L_0x00d2:
        if (r1 == 0) goto L_0x00e0;
    L_0x00d4:
        if (r7 == 0) goto L_0x00f9;
    L_0x00d6:
        r8 = r1.getAlgorithm();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = r7.equals(r8);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        if (r8 != 0) goto L_0x00f9;
    L_0x00e0:
        r8 = "PassportReader";
        r1 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r1.<init>();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r3 = "Re-initializing ecdsaAADigest with digest algorithm ";
        r1.append(r3);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r1.append(r7);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r1 = r1.toString();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        jumio.nv.nfc.f.a(r8, r1);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        java.security.MessageDigest.getInstance(r7);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
    L_0x00f9:
        r0.initVerify(r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r10.length;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r6 % r2;
        if (r6 == 0) goto L_0x0107;
    L_0x0100:
        r6 = "PassportReader";
        r7 = "Active Authentication response is not of even length";
        jumio.nv.nfc.f.a(r6, r7);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
    L_0x0107:
        r6 = r10.length;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = r6 / r2;
        r7 = 0;
        r8 = org.jmrtd.d.s(r10, r7, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6 = org.jmrtd.d.s(r10, r6, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r0.update(r9);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r9 = new org.spongycastle.asn1.DERSequence;	 Catch:{ IOException -> 0x0142 }
        r10 = new org.spongycastle.asn1.ASN1Encodable[r2];	 Catch:{ IOException -> 0x0142 }
        r1 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x0142 }
        r1.<init>(r8);	 Catch:{ IOException -> 0x0142 }
        r10[r7] = r1;	 Catch:{ IOException -> 0x0142 }
        r7 = 1;
        r8 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x0142 }
        r8.<init>(r6);	 Catch:{ IOException -> 0x0142 }
        r10[r7] = r8;	 Catch:{ IOException -> 0x0142 }
        r9.<init>(r10);	 Catch:{ IOException -> 0x0142 }
        r6 = r9.getEncoded();	 Catch:{ IOException -> 0x0142 }
        r6 = r0.verify(r6);	 Catch:{ IOException -> 0x0142 }
        r7 = new jumio.nv.nfc.o;	 Catch:{ IOException -> 0x0142 }
        r8 = jumio.nv.nfc.p.ACTIVE_AUTH_CHECK;	 Catch:{ IOException -> 0x0142 }
        if (r6 == 0) goto L_0x013c;
    L_0x0139:
        r6 = jumio.nv.nfc.q.SUCCESSFUL;	 Catch:{ IOException -> 0x0142 }
        goto L_0x013e;
    L_0x013c:
        r6 = jumio.nv.nfc.q.FAILED;	 Catch:{ IOException -> 0x0142 }
    L_0x013e:
        r7.<init>(r8, r6);	 Catch:{ IOException -> 0x0142 }
        return r7;
    L_0x0142:
        r6 = move-exception;
        r7 = "PassportReader";
        r8 = "Unexpected exception during AA signature verification with ECDSA";
        jumio.nv.nfc.f.a(r7, r8);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r6.printStackTrace();	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7 = new jumio.nv.nfc.o;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r8 = jumio.nv.nfc.p.ACTIVE_AUTH_CHECK;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r9 = jumio.nv.nfc.q.ERROR;	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        r7.<init>(r8, r9, r6);	 Catch:{ IllegalArgumentException -> 0x0157, IllegalArgumentException -> 0x0157 }
        return r7;
    L_0x0157:
        r6 = move-exception;
        r7 = new net.sf.scuba.smartcards.CardServiceException;
        r6 = r6.toString();
        r7.<init>(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.i.a(java.security.PublicKey, java.lang.String, java.lang.String, byte[], byte[]):jumio.nv.nfc.o");
    }

    private void j() {
        if (!this.h || this.f == null || this.g.isEmpty()) {
            throw new IllegalStateException("call open() and readLDS() before performing any other operations!");
        }
    }

    public void a(IsoDep isoDep) {
        this.i = isoDep;
    }
}
