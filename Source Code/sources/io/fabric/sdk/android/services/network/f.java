package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.c;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager */
class f implements X509TrustManager {
    private static final X509Certificate[] eoE = new X509Certificate[0];
    private final TrustManager[] eoF;
    private final g eoG;
    private final long eoH;
    private final Set<X509Certificate> eoI = Collections.synchronizedSet(new HashSet());
    private final List<byte[]> pins = new LinkedList();

    public f(g gVar, e eVar) {
        this.eoF = a(gVar);
        this.eoG = gVar;
        this.eoH = eVar.hJ();
        for (String gh : eVar.hI()) {
            this.pins.add(gh(gh));
        }
    }

    private TrustManager[] a(g gVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(gVar.eoJ);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean b(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.pins) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.eoF) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void a(X509Certificate[] x509CertificateArr) {
        if (this.eoH == -1 || System.currentTimeMillis() - this.eoH <= 15552000000L) {
            x509CertificateArr = a.a(x509CertificateArr, this.eoG);
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                if (!b(x509CertificateArr[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate pins are stale, (");
        stringBuilder.append(System.currentTimeMillis() - this.eoH);
        stringBuilder.append(" millis vs ");
        stringBuilder.append(15552000000L);
        stringBuilder.append(" millis) falling back to system trust.");
        c.aUg().w("Fabric", stringBuilder.toString());
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.eoI.contains(x509CertificateArr[0])) {
            a(x509CertificateArr, str);
            a(x509CertificateArr);
            this.eoI.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return eoE;
    }

    private byte[] gh(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
