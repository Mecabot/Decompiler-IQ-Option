package io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* compiled from: CertificateChainCleaner */
final class a {
    public static X509Certificate[] a(X509Certificate[] x509CertificateArr, g gVar) {
        LinkedList linkedList = new LinkedList();
        boolean c = gVar.c(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        int i = 1;
        boolean z = c;
        int i2 = 1;
        while (i2 < x509CertificateArr.length) {
            if (gVar.c(x509CertificateArr[i2])) {
                z = true;
            }
            if (!a(x509CertificateArr[i2], x509CertificateArr[i2 - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i2]);
            i2++;
        }
        X509Certificate d = gVar.d(x509CertificateArr[i2 - 1]);
        if (d != null) {
            linkedList.add(d);
        } else {
            i = z;
        }
        if (i != 0) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    private static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
