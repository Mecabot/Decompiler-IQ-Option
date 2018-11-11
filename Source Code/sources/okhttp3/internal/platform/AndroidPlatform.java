package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.util.Log;
import com.iqoption.dto.entity.position.Position;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

class AndroidPlatform extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final CloseGuard closeGuard = CloseGuard.get();
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;

    static final class CloseGuard {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        CloseGuard(Method method, Method method2, Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        Object createAndOpen(String str) {
            if (this.getMethod != null) {
                try {
                    Object invoke = this.getMethod.invoke(null, new Object[0]);
                    this.openMethod.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                    return null;
                }
            }
        }

        boolean warnIfOpen(Object obj) {
            boolean z = false;
            if (obj != null) {
                try {
                    this.warnIfOpenMethod.invoke(obj, new Object[0]);
                    z = true;
                } catch (Exception unused) {
                    return z;
                }
            }
        }

        static CloseGuard get() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod(Position.STATUS_OPEN, new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = method2;
            }
            return new CloseGuard(method3, method, method2);
        }
    }

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public int hashCode() {
            return 0;
        }

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        public List<Certificate> clean(List<Certificate> list, String str) {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{x509CertificateArr, "RSA", str});
            } catch (Throwable e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }
    }

    static final class AndroidTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.findByIssuerAndSignatureMethod = method;
            this.trustManager = x509TrustManager;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{x509Certificate});
                return trustAnchor != null ? trustAnchor.getTrustedCert() : null;
            } catch (Exception e) {
                throw Util.assertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            if (!(this.trustManager.equals(androidTrustRootIndex.trustManager) && this.findByIssuerAndSignatureMethod.equals(androidTrustRootIndex.findByIssuerAndSignatureMethod))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.sslParametersClass = cls;
        this.setUseSessionTickets = optionalMethod;
        this.setHostname = optionalMethod2;
        this.getAlpnSelectedProtocol = optionalMethod3;
        this.setAlpnProtocols = optionalMethod4;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        IOException iOException;
        try {
            socket.connect(inetSocketAddress, i);
        } catch (Throwable e) {
            if (Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable e2) {
            iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (Throwable e22) {
            if (VERSION.SDK_INT == 26) {
                iOException = new IOException("Exception in connect");
                iOException.initCause(e22);
                throw iOException;
            }
            throw e22;
        }
    }

    protected X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
        if (readFieldOrNull == null) {
            try {
                readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.valueOf(true));
            this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        if (this.setAlpnProtocols != null && this.setAlpnProtocols.isSupported(sSLSocket)) {
            this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, Platform.concatLengthPrefixed(list));
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String str = null;
        if (this.getAlpnSelectedProtocol == null || !this.getAlpnSelectedProtocol.isSupported(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, Util.UTF_8);
        }
        return str;
    }

    public void log(int i, String str, Throwable th) {
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(10);
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int min;
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public Object getStackTraceForCloseable(String str) {
        return this.closeGuard.createAndOpen(str);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (!this.closeGuard.warnIfOpen(obj)) {
            log(5, str, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.ClassNotFoundException (unused java.lang.ClassNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001b A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r5_1 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001b A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r5_1 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:3:0x001b, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0022, code:
            throw okhttp3.internal.Util.assertionError("unable to determine cleartext support", r5);
     */
    /* JADX WARNING: Missing block: B:7:0x0027, code:
            return super.isCleartextTrafficPermitted(r5);
     */
    public boolean isCleartextTrafficPermitted(java.lang.String r5) {
        /*
        r4 = this;
        r0 = "android.security.NetworkSecurityPolicy";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = "getInstance";
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = r0.getMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r3 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = r1.invoke(r3, r2);	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r0 = r4.api24IsCleartextTrafficPermitted(r5, r0, r1);	 Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        return r0;
    L_0x001b:
        r5 = move-exception;
        r0 = "unable to determine cleartext support";
        r5 = okhttp3.internal.Util.assertionError(r0, r5);
        throw r5;
    L_0x0023:
        r5 = super.isCleartextTrafficPermitted(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.isCleartextTrafficPermitted(java.lang.String):boolean");
    }

    private boolean api24IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    private boolean api23IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private static boolean supportsAlpn() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:5:?, code:
            r1 = java.lang.Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
     */
    /* JADX WARNING: Missing block: B:12:0x0056, code:
            return null;
     */
    public static okhttp3.internal.platform.Platform buildIfSupported() {
        /*
        r0 = 0;
        r1 = "com.android.org.conscrypt.SSLParametersImpl";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009 }
    L_0x0007:
        r3 = r1;
        goto L_0x0010;
    L_0x0009:
        r1 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0056 }
        goto L_0x0007;
    L_0x0010:
        r4 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = "setUseSessionTickets";
        r2 = 1;
        r5 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r4.<init>(r0, r1, r5);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = "setHostname";
        r6 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r8 = java.lang.String.class;
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5.<init>(r0, r1, r6);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = supportsAlpn();	 Catch:{ ClassNotFoundException -> 0x0056 }
        if (r1 == 0) goto L_0x004d;
    L_0x0032:
        r1 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = byte[].class;
        r8 = "getAlpnSelectedProtocol";
        r9 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1.<init>(r6, r8, r9);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r8 = "setAlpnProtocols";
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r9 = byte[].class;
        r2[r7] = r9;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6.<init>(r0, r8, r2);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r7 = r6;
        r6 = r1;
        goto L_0x004f;
    L_0x004d:
        r6 = r0;
        r7 = r6;
    L_0x004f:
        r1 = new okhttp3.internal.platform.AndroidPlatform;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2 = r1;
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0056 }
        return r1;
    L_0x0056:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.buildIfSupported():okhttp3.internal.platform.Platform");
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }
}
