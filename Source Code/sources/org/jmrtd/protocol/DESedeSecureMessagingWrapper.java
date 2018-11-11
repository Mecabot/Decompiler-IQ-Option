package org.jmrtd.protocol;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.jmrtd.d;

public class DESedeSecureMessagingWrapper extends SecureMessagingWrapper implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final IvParameterSpec fbR = new IvParameterSpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
    private static final long serialVersionUID = -2859033943345961793L;
    private transient Cipher dsa;
    private SecretKey ksEnc;
    private SecretKey ksMac;
    private transient Mac mac;
    private boolean shouldCheckMAC;
    private long ssc;

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2) {
        this(secretKey, secretKey2, true);
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, boolean z) {
        this(secretKey, secretKey2, z, 0);
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, long j) {
        this(secretKey, secretKey2, "DESede/CBC/NoPadding", "ISO9797Alg3Mac", true, j);
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, boolean z, long j) {
        this(secretKey, secretKey2, "DESede/CBC/NoPadding", "ISO9797Alg3Mac", z, j);
    }

    private DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, String str, String str2, boolean z, long j) {
        this.ksEnc = secretKey;
        this.ksMac = secretKey2;
        this.shouldCheckMAC = z;
        this.ssc = j;
        this.dsa = d.nq(str);
        this.mac = d.nr(str2);
    }

    public long bBP() {
        return this.ssc;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DESedeSecureMessagingWrapper [ ");
        stringBuilder.append(this.ksEnc.toString());
        stringBuilder.append(", ");
        stringBuilder.append(this.ksMac.toString());
        stringBuilder.append(", ");
        stringBuilder.append(this.ssc);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
