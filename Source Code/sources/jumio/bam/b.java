package jumio.bam;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.jumio.alejwt.swig.ALECore;
import com.jumio.alejwt.swig.ALESettings;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.environment.Environment;
import com.jumio.core.exceptions.PlatformNotSupportedException;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.EncryptionProvider;
import com.jumio.core.network.PinningConfig;
import com.jumio.core.network.ale.AleEncryptionProvider;
import com.jumio.core.network.ale.AleSecurityConfig;
import com.jumio.core.network.ale.SynchronizedAleCore;
import com.jumio.sdk.SDKExpiredException;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.models.OfflineCredentialsModel;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

/* compiled from: BamBackend */
public class b {
    private static boolean a = false;
    private static final String b = StringObfuscater.format(new byte[]{(byte) 10, (byte) -12, (byte) -87, (byte) -67, (byte) 95, (byte) 90, (byte) -113, (byte) 99, (byte) 43, (byte) 123, (byte) 34, (byte) 90, (byte) -120, (byte) -96, (byte) -107, (byte) -115, (byte) -111, (byte) 84, (byte) -120, (byte) -100, (byte) 10, (byte) -126, (byte) -87, (byte) 2, (byte) -59, (byte) 100, (byte) 94, (byte) -121, (byte) 35, (byte) -4, (byte) 57, (byte) -44, (byte) -58, (byte) 116, (byte) 24, (byte) -69, (byte) -35, (byte) 55, (byte) -9, (byte) -95, (byte) -109, (byte) -81, (byte) 112, (byte) -18, (byte) -48, (byte) -110, (byte) -96, (byte) -67, (byte) -14, (byte) 80, (byte) -5, (byte) 61, (byte) -121, (byte) -119, (byte) 97}, 6187360532917353291L);
    private static final String c = StringObfuscater.format(new byte[]{(byte) -99, (byte) -110, (byte) -122, (byte) -81, (byte) -50, (byte) -107, (byte) 37, (byte) -110, (byte) -117, (byte) -90, (byte) 34, (byte) -67, (byte) -96, Byte.MIN_VALUE, (byte) 112, (byte) -40, (byte) 87, (byte) -58, (byte) 112, (byte) -39, (byte) 17, (byte) 57, (byte) -41, (byte) 41, (byte) -82, (byte) -127, (byte) -66, (byte) -26, (byte) -113, (byte) -23, (byte) -25, (byte) 60, (byte) -50, (byte) 107, (byte) 39, (byte) -14, (byte) -93, (byte) 89, (byte) -52, (byte) -86, (byte) -124, (byte) -37, (byte) -21, (byte) 48, (byte) -13, (byte) 72, (byte) 41, (byte) -80, (byte) -109, (byte) -112, (byte) 110, (byte) 67, (byte) -17, (byte) -81, (byte) -38, (byte) 14, (byte) 72, (byte) 66, (byte) -89}, -3509753331641672212L);
    private static String d = b;
    private static String e = c;
    private static String f = AleSecurityConfig.ALE_KEY_ID_US;
    private static String g = AleSecurityConfig.ALE_KEY_ID_EU;
    private static String h = AleSecurityConfig.ALE_PUBLIC_KEY_US;
    private static String i = AleSecurityConfig.ALE_PUBLIC_KEY_EU;
    private static ExecutorService j = Executors.newSingleThreadExecutor();
    private static ALECore k;

    /* compiled from: BamBackend */
    static class b implements Runnable {
        private Context a;
        private OfflineCredentialsModel b;
        private Subscriber<w> c;

        public b(Context context, OfflineCredentialsModel offlineCredentialsModel, @Nullable Subscriber<w> subscriber) {
            this.a = context;
            this.b = offlineCredentialsModel;
            this.c = subscriber;
        }

        public void run() {
            try {
                this.b.verify(this.a);
                w wVar = new w();
                wVar.c(this.b.isBranding());
                wVar.a(false);
                wVar.b(false);
                this.c.onResult(wVar);
            } catch (Throwable e) {
                this.c.onError(e);
            }
        }
    }

    /* compiled from: BamBackend */
    static class a implements DynamicProvider {
        private Context a;
        private CredentialsModel b;

        public a(Context context, CredentialsModel credentialsModel) {
            this.a = context;
            this.b = credentialsModel;
        }

        public EncryptionProvider getEncryptionProvider() {
            return b.b(this.a, this.b);
        }

        public byte[][] getPublicKeys() {
            return this.b.getDataCenter() == JumioDataCenter.EU ? PinningConfig.PUBLIC_KEY_EU : PinningConfig.PUBLIC_KEY_US;
        }

        public boolean isOffline() {
            return this.b instanceof OfflineCredentialsModel;
        }
    }

    private static String a(CredentialsModel credentialsModel) {
        switch (credentialsModel.getDataCenter()) {
            case EU:
                return e;
            case US:
                return d;
            default:
                return null;
        }
    }

    public static void a(Context context, CredentialsModel credentialsModel, x xVar, @Nullable Subscriber<w> subscriber) {
        if (credentialsModel instanceof OfflineCredentialsModel) {
            j.submit(new b(context, (OfflineCredentialsModel) credentialsModel, subscriber));
            return;
        }
        a(false);
        Callable dVar = new d(context, new a(context, credentialsModel), xVar, subscriber);
        dVar.configure(a(credentialsModel), "Jumio Netswipe Android SDK JMSDK 2.10.0 (0-63)");
        j.submit(dVar);
    }

    public static void a(Context context, CredentialsModel credentialsModel, ImageData imageData, String str, @Nullable Subscriber<String> subscriber, byte[] bArr) {
        if (a) {
            if (subscriber != null) {
                subscriber.onResult(str);
            }
            return;
        }
        Callable cVar = new c(context, new a(context, credentialsModel), imageData, bArr, str, subscriber);
        cVar.configure(a(credentialsModel), "Jumio Netswipe Android SDK JMSDK 2.10.0 (0-63)");
        j.submit(cVar);
    }

    public static void a(Context context, CredentialsModel credentialsModel, x xVar, y yVar, String str, @Nullable Subscriber<String> subscriber) {
        if (a) {
            if (subscriber != null) {
                subscriber.onResult(str);
            }
            return;
        }
        Callable eVar = new e(context, new a(context, credentialsModel), xVar, yVar, str, subscriber);
        eVar.configure(a(credentialsModel), "Jumio Netswipe Android SDK JMSDK 2.10.0 (0-63)");
        j.submit(eVar);
    }

    public static void a(Context context, CredentialsModel credentialsModel, y yVar, String str) {
        if (!a) {
            Callable fVar = new f(context, new a(context, credentialsModel), yVar, str);
            fVar.configure(a(credentialsModel), "Jumio Netswipe Android SDK JMSDK 2.10.0 (0-63)");
            j.submit(fVar);
        }
    }

    private static synchronized EncryptionProvider b(Context context, CredentialsModel credentialsModel) {
        String str;
        EncryptionProvider aleEncryptionProvider;
        synchronized (b.class) {
            if (k == null) {
                String str2;
                String str3 = null;
                switch (credentialsModel.getDataCenter()) {
                    case EU:
                        str2 = g;
                        str = i;
                        break;
                    case US:
                        str2 = f;
                        str = h;
                        break;
                    default:
                        str2 = null;
                        str = str2;
                        break;
                }
                Environment.loadAleLib();
                Matcher matcher = Pattern.compile("^https://(?:nv|bam)-sdk\\.(.+?)?(?:\\.int)?(?:\\.)?jumio\\.com/.*$").matcher(a(credentialsModel));
                if (matcher.matches()) {
                    str3 = matcher.group(1);
                }
                try {
                } catch (Exception unused) {
                    ALESettings aLESettings = new ALESettings();
                    aLESettings.setKeyID(str2);
                    aLESettings.setPublicKey(str);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Environment.getDataDirectory(context).getAbsolutePath());
                    stringBuilder.append("/ale/");
                    String stringBuilder2 = stringBuilder.toString();
                    if (str3 != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringBuilder2);
                        stringBuilder.append(str3);
                        stringBuilder.append("/");
                        stringBuilder2 = stringBuilder.toString();
                    }
                    File file = new File(stringBuilder2);
                    if (file.exists() || file.mkdirs()) {
                        aLESettings.setDirectory(stringBuilder2);
                        k = new SynchronizedAleCore(aLESettings);
                    } else {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("cannot create directory ");
                        stringBuilder3.append(file);
                        throw new RuntimeException(stringBuilder3.toString());
                    }
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(credentialsModel.getApiToken());
            stringBuilder4.append(":");
            stringBuilder4.append(credentialsModel.getApiSecret());
            aleEncryptionProvider = new AleEncryptionProvider(k, Base64.encodeToString(stringBuilder4.toString().getBytes(), 2));
        }
        return aleEncryptionProvider;
    }

    public static synchronized void a() {
        synchronized (b.class) {
            j.submit(new Runnable() {
                public void run() {
                    if (b.k != null) {
                        b.k.delete();
                        b.k = null;
                    }
                }
            });
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public static JumioException a(Throwable th) {
        JumioErrorCase jumioErrorCase;
        boolean z = th instanceof UnexpectedResponseException;
        if (z && ((UnexpectedResponseException) th).isHttpUnauthorized()) {
            jumioErrorCase = i.AUTH_FAILED;
        } else if (z && ((UnexpectedResponseException) th).getStatusCode() == 403) {
            jumioErrorCase = i.INVALID_CREDENTIALS;
        } else if (z && ((UnexpectedResponseException) th).getStatusCode() == MobileEvents.EVENTTYPE_EXCEPTION) {
            jumioErrorCase = i.ALE_KEY_NOT_VALID;
        } else if (th instanceof SSLException) {
            jumioErrorCase = i.CERTIFICATE_ERROR;
        } else if ((th instanceof PlatformNotSupportedException) || (th instanceof SDKExpiredException)) {
            jumioErrorCase = i.AUTH_FAILED;
        } else {
            jumioErrorCase = null;
        }
        int statusCode = z ? ((UnexpectedResponseException) th).getStatusCode() : 0;
        if (jumioErrorCase == null) {
            return null;
        }
        return new JumioException(jumioErrorCase, statusCode);
    }
}
