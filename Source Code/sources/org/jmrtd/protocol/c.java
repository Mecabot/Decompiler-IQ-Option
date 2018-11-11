package org.jmrtd.protocol;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import org.jmrtd.d;

/* compiled from: PACEGMWithECDHAgreement */
public class c {
    private ECPrivateKey fdc;

    public void a(PrivateKey privateKey) {
        if (privateKey instanceof ECPrivateKey) {
            this.fdc = (ECPrivateKey) privateKey;
            return;
        }
        throw new InvalidKeyException("Not an ECPrivateKey");
    }

    public ECPoint e(PublicKey publicKey) {
        if (this.fdc == null) {
            throw new IllegalStateException("Not initialized!");
        } else if (publicKey instanceof ECPublicKey) {
            org.spongycastle.math.ec.ECPoint normalize = d.a((ECPublicKey) publicKey).getQ().multiply(d.a(this.fdc).getD()).normalize();
            if (!normalize.isInfinity()) {
                return d.a(normalize);
            }
            throw new IllegalStateException("Infinity");
        } else {
            throw new InvalidKeyException("Not an ECPublicKey");
        }
    }
}
