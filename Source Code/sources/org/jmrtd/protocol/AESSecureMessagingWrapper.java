package org.jmrtd.protocol;

import java.io.Serializable;
import java.security.Key;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.jmrtd.d;

public class AESSecureMessagingWrapper extends SecureMessagingWrapper implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2086301081448345496L;
    private transient Cipher dsa = d.nq("AES/CBC/NoPadding");
    private transient Cipher fdb;
    private SecretKey ksEnc;
    private SecretKey ksMac;
    private transient Mac mac;
    private long ssc;

    public AESSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, long j) {
        this.ksEnc = secretKey;
        this.ksMac = secretKey2;
        this.ssc = j;
        this.fdb = d.a("AES/ECB/NoPadding", 1, (Key) secretKey);
        this.mac = d.a("AESCMAC", (Key) secretKey2);
    }

    public long bBP() {
        return this.ssc;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AESSecureMessagingWrapper [ ");
        stringBuilder.append(this.ksEnc.toString());
        stringBuilder.append(", ");
        stringBuilder.append(this.ksMac.toString());
        stringBuilder.append(", ");
        stringBuilder.append(this.ssc);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
