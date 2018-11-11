package org.jmrtd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.Provider;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import net.sf.scuba.smartcards.APDUEvent;
import net.sf.scuba.smartcards.APDUListener;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.util.Hex;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* compiled from: PassportApduService */
public class c extends CardService {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final Provider fbP = d.bAA();
    protected static final byte[] fbQ = new byte[]{(byte) -96, (byte) 0, (byte) 0, (byte) 2, (byte) 71, (byte) 16, (byte) 1};
    private static final IvParameterSpec fbR = new IvParameterSpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
    private Cipher dsa;
    private CardService fbS;
    private byte[] fbT;
    private Collection<APDUListener> fbU = new HashSet();
    private int fbV = 0;
    private Mac mac;

    public c(CardService cardService) {
        this.fbS = cardService;
        try {
            this.mac = Mac.getInstance("ISO9797Alg3Mac", fbP);
            this.dsa = d.nq("DESede/CBC/NoPadding");
        } catch (Throwable e) {
            throw new CardServiceException("Unexpected security exception during initialization", e);
        }
    }

    public void open() {
        if (!this.fbS.isOpen()) {
            this.fbS.open();
        }
        this.fbT = this.fbS.getATR();
    }

    public synchronized boolean isOpen() {
        return this.fbS.isOpen();
    }

    public synchronized ResponseAPDU a(CommandAPDU commandAPDU) {
        return this.fbS.transmit(commandAPDU);
    }

    private ResponseAPDU a(APDUWrapper aPDUWrapper, CommandAPDU commandAPDU) {
        ResponseAPDU a = a(aPDUWrapper != null ? aPDUWrapper.wrap(commandAPDU) : commandAPDU);
        short sw = (short) a.getSW();
        if (aPDUWrapper == null) {
            return a;
        }
        try {
            if (a.getBytes().length == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception during transmission of wrapped APDU\nC=");
                stringBuilder.append(Hex.bytesToHexString(commandAPDU.getBytes()));
                throw new CardServiceException(stringBuilder.toString(), sw);
            }
            ResponseAPDU unwrap = aPDUWrapper.unwrap(a);
            int i = this.fbV + 1;
            this.fbV = i;
            a(i, commandAPDU, unwrap);
            return unwrap;
        } catch (CardServiceException e) {
            throw e;
        } catch (Throwable e2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Exception during transmission of wrapped APDU\nC=");
            stringBuilder2.append(Hex.bytesToHexString(commandAPDU.getBytes()));
            throw new CardServiceException(stringBuilder2.toString(), e2, sw);
        } catch (Throwable th) {
            int i2 = this.fbV + 1;
            this.fbV = i2;
            a(i2, commandAPDU, a);
        }
    }

    public synchronized void a(APDUWrapper aPDUWrapper, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("AID cannot be null");
        }
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 4, 12, bArr);
        a(commandAPDU, a(aPDUWrapper, commandAPDU));
    }

    public synchronized byte[] bAz() {
        return a(null);
    }

    public synchronized byte[] a(APDUWrapper aPDUWrapper) {
        return a(aPDUWrapper, new CommandAPDU(0, -124, 0, 0, 8)).getData();
    }

    public synchronized byte[] b(APDUWrapper aPDUWrapper, byte[] bArr) {
        if (bArr != null) {
            if (bArr.length == 8) {
            }
        }
        throw new IllegalArgumentException("rndIFD wrong length");
        return a(aPDUWrapper, new CommandAPDU(0, -120, 0, 0, bArr, 256)).getData();
    }

    /* JADX WARNING: Missing block: B:8:0x0019, code:
            if (r7 != r8) goto L_0x001b;
     */
    public synchronized byte[] a(byte[] r25, byte[] r26, byte[] r27, javax.crypto.SecretKey r28, javax.crypto.SecretKey r29) {
        /*
        r24 = this;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r5 = r28;
        r6 = r29;
        monitor-enter(r24);
        if (r2 == 0) goto L_0x0143;
    L_0x000f:
        r7 = r2.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r8 = 8;
        if (r7 == r8) goto L_0x0016;
    L_0x0014:
        goto L_0x0143;
    L_0x0016:
        if (r3 == 0) goto L_0x001b;
    L_0x0018:
        r7 = r3.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r7 == r8) goto L_0x001d;
    L_0x001b:
        r3 = new byte[r8];	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x001d:
        if (r4 == 0) goto L_0x0135;
    L_0x001f:
        r7 = r4.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r9 = 16;
        if (r7 == r9) goto L_0x0026;
    L_0x0024:
        goto L_0x0135;
    L_0x0026:
        if (r5 != 0) goto L_0x0030;
    L_0x0028:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "kEnc == null";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x0030:
        if (r6 != 0) goto L_0x003a;
    L_0x0032:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "kMac == null";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x003a:
        r7 = r1.dsa;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r10 = 1;
        r11 = fbR;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r7.init(r10, r5, r11);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r7 = 32;
        r10 = new byte[r7];	 Catch:{ GeneralSecurityException -> 0x0140 }
        r11 = 0;
        java.lang.System.arraycopy(r2, r11, r10, r11, r8);	 Catch:{ GeneralSecurityException -> 0x0140 }
        java.lang.System.arraycopy(r3, r11, r10, r8, r8);	 Catch:{ GeneralSecurityException -> 0x0140 }
        java.lang.System.arraycopy(r4, r11, r10, r9, r9);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r1.dsa;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r2.doFinal(r10);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r2.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r3 == r7) goto L_0x0071;
    L_0x0059:
        r3 = new java.lang.IllegalStateException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4.<init>();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r5 = "Cryptogram wrong length ";
        r4.append(r5);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r2.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4.append(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r4.toString();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3.<init>(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r3;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x0071:
        r3 = r1.mac;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3.init(r6);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r1.mac;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = org.jmrtd.d.p(r2, r8);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r3.doFinal(r4);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = r3.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r4 == r8) goto L_0x008b;
    L_0x0083:
        r2 = new java.lang.IllegalStateException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "MAC wrong length";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x008b:
        r15 = 0;
        r16 = 0;
        r4 = 40;
        r4 = new byte[r4];	 Catch:{ GeneralSecurityException -> 0x0140 }
        java.lang.System.arraycopy(r2, r11, r4, r11, r7);	 Catch:{ GeneralSecurityException -> 0x0140 }
        java.lang.System.arraycopy(r3, r11, r4, r7, r8);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r23 = 40;
        r2 = new net.sf.scuba.smartcards.CommandAPDU;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r18 = 0;
        r19 = -126; // 0xffffffffffffff82 float:NaN double:NaN;
        r20 = 0;
        r21 = 0;
        r17 = r2;
        r22 = r4;
        r17.<init>(r18, r19, r20, r21, r22, r23);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r1.a(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r2 != 0) goto L_0x00b9;
    L_0x00b1:
        r2 = new net.sf.scuba.smartcards.CardServiceException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "Mutual authentication failed, received null response APDU";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x00b9:
        r3 = r2.getBytes();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r2.getSW();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = (short) r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r3 != 0) goto L_0x00cc;
    L_0x00c4:
        r3 = new net.sf.scuba.smartcards.CardServiceException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = "Mutual authentication failed, received empty data in response APDU";
        r3.<init>(r4, r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r3;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x00cc:
        r6 = -28672; // 0xffffffffffff9000 float:NaN double:NaN;
        if (r2 == r6) goto L_0x00ea;
    L_0x00d0:
        r18 = 0;
        r2 = new net.sf.scuba.smartcards.CommandAPDU;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r13 = 0;
        r14 = -126; // 0xffffffffffffff82 float:NaN double:NaN;
        r12 = r2;
        r17 = r4;
        r12.<init>(r13, r14, r15, r16, r17, r18);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r1.a(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r2.getBytes();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r2.getSW();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = (short) r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x00ea:
        r4 = r3.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r6 = 42;
        if (r4 == r6) goto L_0x0107;
    L_0x00ef:
        r4 = new net.sf.scuba.smartcards.CardServiceException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r5 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r5.<init>();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r6 = "Mutual authentication failed: expected length: 40 + 2, actual length: ";
        r5.append(r6);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r3.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r5.append(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r5.toString();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4.<init>(r3, r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r4;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x0107:
        r2 = r1.dsa;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = fbR;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r6 = 2;
        r2.init(r6, r5, r4);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r1.dsa;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = r3.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = r4 - r8;
        r4 = r4 - r6;
        r2 = r2.doFinal(r3, r11, r4);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = r2.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        if (r3 == r7) goto L_0x0133;
    L_0x011b:
        r3 = new java.lang.IllegalStateException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4.<init>();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r5 = "Cryptogram wrong length ";
        r4.append(r5);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r2.length;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r4.append(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        r2 = r4.toString();	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3.<init>(r2);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r3;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x0133:
        monitor-exit(r24);
        return r2;
    L_0x0135:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "kIFD wrong length";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x013d:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0153;
    L_0x0140:
        r0 = move-exception;
        r2 = r0;
        goto L_0x014b;
    L_0x0143:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ GeneralSecurityException -> 0x0140 }
        r3 = "rndIFD wrong length";
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0140 }
        throw r2;	 Catch:{ GeneralSecurityException -> 0x0140 }
    L_0x014b:
        r3 = new net.sf.scuba.smartcards.CardServiceException;	 Catch:{ all -> 0x013d }
        r4 = "Security exception during mutual auth";
        r3.<init>(r4, r2);	 Catch:{ all -> 0x013d }
        throw r3;	 Catch:{ all -> 0x013d }
    L_0x0153:
        monitor-exit(r24);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.c.a(byte[], byte[], byte[], javax.crypto.SecretKey, javax.crypto.SecretKey):byte[]");
    }

    public synchronized void a(APDUWrapper aPDUWrapper, String str, int i, byte[] bArr) {
        if (str == null) {
            throw new IllegalArgumentException("OID cannot be null");
        }
        byte[] no = no(str);
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            byte[] a = d.a((byte) -125, new byte[]{(byte) i});
            if (bArr != null) {
                bArr = d.a((byte) -124, bArr);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(no);
                byteArrayOutputStream.write(a);
                if (bArr != null) {
                    byteArrayOutputStream.write(bArr);
                }
                short sw = (short) a(aPDUWrapper, new CommandAPDU(0, 34, 193, 164, byteArrayOutputStream.toByteArray())).getSW();
                if (sw != (short) -28672) {
                    throw new CardServiceException("Sending MSE AT failed", sw);
                }
            } catch (Throwable e) {
                LOGGER.log(Level.WARNING, "Error while copying data", e);
                throw new IllegalStateException("Error while copying data");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported key type reference (MRZ, CAN, etc), found ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private byte[] no(String str) {
        TLVInputStream tLVInputStream;
        try {
            tLVInputStream = new TLVInputStream(new ByteArrayInputStream(new ASN1ObjectIdentifier(str).getEncoded()));
            tLVInputStream.readTag();
            tLVInputStream.readLength();
            byte[] readValue = tLVInputStream.readValue();
            tLVInputStream.close();
            return d.a(Byte.MIN_VALUE, readValue);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal OID: \"");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        } catch (Throwable th) {
            tLVInputStream.close();
        }
    }

    public synchronized byte[] a(APDUWrapper aPDUWrapper, byte[] bArr, boolean z) {
        ResponseAPDU a;
        a = a(aPDUWrapper, new CommandAPDU(z ? 0 : 16, -122, 0, 0, d.a((byte) 124, bArr), 256));
        short sw = (short) a.getSW();
        if (sw != (short) -28672) {
            throw new CardServiceException("Sending general authenticate failed", sw);
        }
        return d.b((byte) 124, a.getData());
    }

    protected void a(int i, CommandAPDU commandAPDU, ResponseAPDU responseAPDU) {
        if (this.fbU != null && !this.fbU.isEmpty()) {
            APDUEvent aPDUEvent = new APDUEvent(this, "PLAINTEXT", i, commandAPDU, responseAPDU);
            for (APDUListener exchangedAPDU : this.fbU) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    private static void a(CommandAPDU commandAPDU, ResponseAPDU responseAPDU) {
        short sw = (short) responseAPDU.getSW();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CAPDU = ");
        stringBuilder.append(Hex.bytesToHexString(commandAPDU.getBytes()));
        stringBuilder.append(", RAPDU = ");
        stringBuilder.append(Hex.bytesToHexString(responseAPDU.getBytes()));
        String stringBuilder2 = stringBuilder.toString();
        if (sw != (short) -28672) {
            if (sw != (short) 27010) {
                if (sw != (short) 27266) {
                    switch (sw) {
                        case (short) 27013:
                        case (short) 27014:
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Error occured, ");
                            stringBuilder.append(stringBuilder2);
                            throw new CardServiceException(stringBuilder.toString(), sw);
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("File not found, ");
                stringBuilder.append(stringBuilder2);
                throw new CardServiceException(stringBuilder.toString(), sw);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Access to file denied, ");
            stringBuilder.append(stringBuilder2);
            throw new CardServiceException(stringBuilder.toString(), sw);
        }
    }
}
