package org.jmrtd.protocol;

import java.security.PublicKey;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.CardServiceException;
import org.jmrtd.PassportService;

/* compiled from: AAProtocol */
public class a {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private PassportService fbN;
    private SecureMessagingWrapper wrapper;

    public a(PassportService passportService, SecureMessagingWrapper secureMessagingWrapper) {
        this.fbN = passportService;
        this.wrapper = secureMessagingWrapper;
    }

    public AAResult a(PublicKey publicKey, String str, String str2, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length == 8) {
                    return new AAResult(publicKey, str, str2, bArr, this.fbN.b(this.wrapper, bArr));
                }
            } catch (Throwable e) {
                throw new CardServiceException("Exception", e);
            }
        }
        throw new IllegalArgumentException("AA failed: bad challenge");
    }
}
