package com.jumio.core.network;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JumioTrustManager implements X509TrustManager {
    private static Boolean certificateCheck = Boolean.valueOf(true);
    private X509TrustManager defaultTrustManager = null;
    private String hostname;

    public JumioTrustManager(String str) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.defaultTrustManager = (X509TrustManager) instance.getTrustManagers()[0];
            this.hostname = str;
        } catch (Exception unused) {
            this.defaultTrustManager = null;
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.defaultTrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr.length < 2) {
            throw new CertificateException("SSL Certificate Chain is not sufficient");
        }
        if (certificateCheck.booleanValue()) {
            if (VERSION.SDK_INT >= 24) {
                new X509TrustManagerExtensions(this.defaultTrustManager).checkServerTrusted(x509CertificateArr, str, this.hostname);
            } else {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }
        checkCertificate(x509CertificateArr[0]);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.defaultTrustManager.getAcceptedIssuers();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:4:?, code:
            com.jumio.commons.log.Log.w("JumioTrustManager", "SSL Certificate is not yet valid");
     */
    /* JADX WARNING: Missing block: B:7:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:8:?, code:
            return;
     */
    protected void checkCertificate(java.security.cert.X509Certificate r3) {
        /*
        r2 = this;
        r3.checkValidity();	 Catch:{ CertificateNotYetValidException -> 0x0006 }
        goto L_0x000d;
    L_0x0004:
        r3 = move-exception;
        goto L_0x000e;
    L_0x0006:
        r3 = "JumioTrustManager";
        r0 = "SSL Certificate is not yet valid";
        com.jumio.commons.log.Log.w(r3, r0);	 Catch:{ Exception -> 0x0004 }
    L_0x000d:
        return;
    L_0x000e:
        r0 = new java.security.cert.CertificateException;
        r1 = "SSL Certificate match error";
        r0.<init>(r1, r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.JumioTrustManager.checkCertificate(java.security.cert.X509Certificate):void");
    }
}
