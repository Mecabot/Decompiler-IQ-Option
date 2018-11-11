package com.iqoption.core.connect.http.a;

import android.annotation.SuppressLint;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/x509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "()V", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "Companion", "core_release"})
/* compiled from: x509TrustManager.kt */
public final class c implements X509TrustManager {
    private static final X509Certificate[] aOi = new X509Certificate[0];
    public static final a aOj = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/x509TrustManager$Companion;", "", "()V", "ACCEPTED_ISSUERS", "", "Ljava/security/cert/X509Certificate;", "[Ljava/security/cert/X509Certificate;", "core_release"})
    /* compiled from: x509TrustManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        h.e(x509CertificateArr, "chain");
        h.e(str, "authType");
    }

    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        h.e(x509CertificateArr, "chain");
        h.e(str, "authType");
    }

    public X509Certificate[] getAcceptedIssuers() {
        return aOi;
    }
}
