package com.jumio.core.network;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class PinningTrustManager extends JumioTrustManager {
    private byte[] publicKey;

    public PinningTrustManager(byte[] bArr, String str) {
        super(str);
        this.publicKey = bArr;
    }

    protected void checkCertificate(X509Certificate x509Certificate) {
        super.checkCertificate(x509Certificate);
        try {
            if (this.publicKey == null || this.publicKey.length % 2 == 0) {
                if (!Arrays.equals(this.publicKey, x509Certificate.getPublicKey().getEncoded())) {
                    throw new Exception("SSL pinning failed!");
                }
                return;
            }
            throw new Exception("public key must have a length multiple of 2!");
        } catch (Throwable e) {
            throw new CertificateException("SSL Certificate match error", e);
        }
    }
}
