package com.jumio.core.network;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class MultiPinningTrustManager extends JumioTrustManager {
    private static Boolean pinning = Boolean.valueOf(true);
    private byte[][] publicKeys;

    public MultiPinningTrustManager(byte[][] bArr, String str) {
        super(str);
        this.publicKeys = bArr;
    }

    public MultiPinningTrustManager(byte[] bArr, String str) {
        super(str);
        this.publicKeys = new byte[][]{bArr};
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        super.checkServerTrusted(x509CertificateArr, str);
    }

    protected void checkCertificate(X509Certificate x509Certificate) {
        super.checkCertificate(x509Certificate);
        if (pinning.booleanValue()) {
            try {
                byte[][] bArr = this.publicKeys;
                int length = bArr.length;
                Object obj = null;
                int i = 0;
                while (i < length) {
                    byte[] bArr2 = bArr[i];
                    if (bArr2 == null || bArr2.length % 2 == 0) {
                        if (Arrays.equals(bArr2, x509Certificate.getPublicKey().getEncoded())) {
                            obj = 1;
                            break;
                        }
                        i++;
                    } else {
                        throw new Exception("public key must have a length multiple of 2!");
                    }
                }
                if (obj == null) {
                    throw new Exception("SSL pinning failed!");
                }
            } catch (Throwable e) {
                throw new CertificateException("SSL Certificate match error", e);
            }
        }
    }
}
