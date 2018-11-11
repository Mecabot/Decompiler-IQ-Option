package org.jmrtd.protocol;

import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import net.sf.scuba.smartcards.CardServiceException;
import org.jmrtd.BACKeySpec;
import org.jmrtd.PassportService;
import org.jmrtd.d;

/* compiled from: BACProtocol */
public class b {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private PassportService fbN;
    private Random random = new SecureRandom();

    public b(PassportService passportService) {
        this.fbN = passportService;
    }

    public BACResult b(BACKeySpec bACKeySpec) {
        try {
            byte[] c = c(bACKeySpec);
            return new BACResult(bACKeySpec, a(d.o(c, 1), d.o(c, 2)));
        } catch (CardServiceException e) {
            LOGGER.log(Level.WARNING, "BAC failed", e);
            throw e;
        } catch (Throwable e2) {
            throw new CardServiceException("Error during BAC", e2);
        }
    }

    private SecureMessagingWrapper a(SecretKey secretKey, SecretKey secretKey2) {
        byte[] bAz = this.fbN.bAz();
        byte[] bArr = new byte[8];
        this.random.nextBytes(bArr);
        byte[] bArr2 = new byte[16];
        this.random.nextBytes(bArr2);
        Object a = this.fbN.a(bArr, bAz, bArr2, secretKey, secretKey2);
        Object obj = new byte[16];
        int i = 0;
        System.arraycopy(a, 16, obj, 0, 16);
        byte[] bArr3 = new byte[16];
        while (i < 16) {
            bArr3[i] = (byte) ((bArr2[i] & 255) ^ (obj[i] & 255));
            i++;
        }
        return new DESedeSecureMessagingWrapper(d.o(bArr3, 1), d.o(bArr3, 2), c(bAz, bArr));
    }

    public static byte[] c(BACKeySpec bACKeySpec) {
        String bAv = bACKeySpec.bAv();
        String bAw = bACKeySpec.bAw();
        String bAx = bACKeySpec.bAx();
        StringBuilder stringBuilder;
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
            return q(nH(bAv), bAw, bAx);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Wrong document number. Found ");
            stringBuilder.append(bAv);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static long c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 8 || bArr2 == null || bArr2.length != 8) {
            throw new IllegalStateException("Wrong length input");
        }
        int i = 4;
        long j = 0;
        int i2 = 4;
        while (i2 < 8) {
            i2++;
            j = (j << 8) + ((long) (bArr[i2] & 255));
        }
        while (i < 8) {
            i++;
            j = (j << 8) + ((long) (bArr2[i] & 255));
        }
        return j;
    }

    private static byte[] q(String str, String str2, String str3) {
        return d.a(str, str2, str3, "SHA-1", true);
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
}
