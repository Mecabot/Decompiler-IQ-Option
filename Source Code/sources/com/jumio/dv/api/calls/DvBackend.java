package com.jumio.dv.api.calls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.jumio.alejwt.swig.ALECore;
import com.jumio.alejwt.swig.ALESettings;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.EncryptionProvider;
import com.jumio.core.network.ale.AleEncryptionProvider;
import com.jumio.core.network.ale.AleSecurityConfig;
import com.jumio.core.network.ale.SynchronizedAleCore;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.models.OfflineCredentialsModel;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

public class DvBackend {
    public static final String USER_AGENT = "Jumio Netverify Android SDK JMSDK 2.10.0 (0-63)";
    private static final String a = StringObfuscater.format(new byte[]{(byte) -8, (byte) -103, (byte) 70, (byte) 1, (byte) -52, (byte) 46, (byte) -114, (byte) 8, (byte) -49, (byte) 90, (byte) -120, (byte) -67, (byte) -45, (byte) -99, (byte) -4, (byte) -45, (byte) 97, (byte) -87, (byte) -97, (byte) 51, (byte) 2, (byte) 70, (byte) 99, (byte) -119, (byte) -125, (byte) 105, (byte) -100, (byte) -69, (byte) 95, (byte) 43, (byte) -99, (byte) -5, (byte) 121, (byte) 126, (byte) -108, (byte) -124, (byte) -112, (byte) -22, (byte) 112, (byte) -124, (byte) -41, (byte) -35, (byte) 88, (byte) 58, (byte) -15, (byte) 38, (byte) 13, (byte) -95, (byte) 79, (byte) -76, (byte) -95, (byte) 115, (byte) -2, (byte) 51, (byte) 51, (byte) -55, (byte) -10, (byte) 41, (byte) 20, (byte) -77, (byte) 22, (byte) -64, (byte) 45, (byte) 10, (byte) 117, Byte.MIN_VALUE, (byte) -88, (byte) -38, (byte) 35, (byte) 116, (byte) -74}, 8115964288434239780L);
    private static final String b = StringObfuscater.format(new byte[]{(byte) -93, (byte) -65, (byte) 37, (byte) 79, (byte) -73, (byte) 12, (byte) 85, (byte) 27, (byte) -29, (byte) 59, (byte) -71, (byte) -83, (byte) 16, (byte) 41, (byte) -4, (byte) 19, (byte) 5, (byte) 44, (byte) -102, (byte) 120, (byte) 88, (byte) 47, (byte) -68, (byte) 108, (byte) 16, (byte) -46, (byte) 105, (byte) -41, (byte) -120, (byte) -98, (byte) -7, (byte) 123, (byte) 95, (byte) 123, (byte) 62, (byte) 123, (byte) -38, (byte) -20, (byte) 80, (byte) 24, (byte) 115, (byte) 48, (byte) 54, (byte) -35, (byte) 37, (byte) 60, (byte) -107, (byte) 35, (byte) 66, (byte) -92, (byte) 54, (byte) -103, (byte) 91, (byte) -95, (byte) 120, (byte) 84, (byte) 16, (byte) 88, (byte) -45, (byte) 72, (byte) 69, (byte) -20, (byte) 112, Byte.MIN_VALUE, (byte) -81, (byte) -105, (byte) 13, (byte) -48, (byte) 51, (byte) 114, (byte) 98, (byte) 44, (byte) -102, (byte) -35, (byte) 101}, 3425189963034516002L);
    private static String c = a;
    private static String d = b;
    private static String e = AleSecurityConfig.ALE_KEY_ID_US;
    private static String f = AleSecurityConfig.ALE_KEY_ID_EU;
    private static String g = AleSecurityConfig.ALE_PUBLIC_KEY_US;
    private static String h = AleSecurityConfig.ALE_PUBLIC_KEY_EU;
    private static ExecutorService i = Executors.newSingleThreadExecutor();
    private static ALECore j;

    private static class a implements DynamicProvider {
        private Context a;
        private CredentialsModel b;

        public a(Context context, CredentialsModel credentialsModel) {
            this.a = context;
            this.b = credentialsModel;
        }

        public EncryptionProvider getEncryptionProvider() {
            return DvBackend.b(this.a, this.b);
        }

        public byte[][] getPublicKeys() {
            return this.b.getDataCenter() == JumioDataCenter.EU ? b.b : b.a;
        }

        public boolean isOffline() {
            return this.b instanceof OfflineCredentialsModel;
        }
    }

    private static String a(CredentialsModel credentialsModel) {
        switch (credentialsModel.getDataCenter()) {
            case EU:
                return d;
            case US:
                return c;
            default:
                return null;
        }
    }

    public static ApiCall complete(Context context, CredentialsModel credentialsModel, ImageData imageData, Subscriber<String> subscriber) {
        Object aVar = new a(context, new a(context, credentialsModel), imageData, subscriber);
        aVar.configure(a(credentialsModel), "Jumio Netverify Android SDK JMSDK 2.10.0 (0-63)");
        i.submit(aVar);
        return aVar;
    }

    public static int cancelAllPending() {
        int size = i.shutdownNow().size();
        i = Executors.newSingleThreadExecutor();
        return size;
    }

    private static synchronized EncryptionProvider b(Context context, CredentialsModel credentialsModel) {
        String str;
        EncryptionProvider aleEncryptionProvider;
        synchronized (DvBackend.class) {
            if (j == null) {
                String str2;
                String str3 = null;
                switch (credentialsModel.getDataCenter()) {
                    case EU:
                        str2 = f;
                        str = h;
                        break;
                    case US:
                        str2 = e;
                        str = g;
                        break;
                    default:
                        str2 = null;
                        str = str2;
                        break;
                }
                Environment.loadAleLib();
                Matcher matcher = Pattern.compile("^https://acquisition\\.(.+?)?(?:\\.int)?(?:\\.)?(?:jumio|netverify)\\.com/.*$").matcher(a(credentialsModel));
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
                        j = new SynchronizedAleCore(aLESettings);
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
            aleEncryptionProvider = new AleEncryptionProvider(j, Base64.encodeToString(stringBuilder4.toString().getBytes(), 2));
        }
        return aleEncryptionProvider;
    }

    public static synchronized void freeEncryption() {
        synchronized (DvBackend.class) {
            i.submit(new Runnable() {
                public void run() {
                    if (DvBackend.j != null) {
                        DvBackend.j.delete();
                        DvBackend.j = null;
                    }
                }
            });
        }
    }

    public static JumioException errorFromThrowable(Context context, Throwable th, Class<?> cls) {
        JumioErrorCase jumioErrorCase = null;
        NetworkInfo activeNetworkInfo = context != null ? ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            jumioErrorCase = com.jumio.dv.a.a.DEVICE_IS_OFFLINE;
        } else {
            boolean z = th instanceof UnexpectedResponseException;
            if (z && ((UnexpectedResponseException) th).isHttpUnauthorized()) {
                jumioErrorCase = com.jumio.dv.a.a.AUTH_FAILED;
            } else if (z && ((UnexpectedResponseException) th).getStatusCode() == 403) {
                jumioErrorCase = com.jumio.dv.a.a.INVALID_CREDENTIALS;
            } else if (z && ((UnexpectedResponseException) th).getStatusCode() == MobileEvents.EVENTTYPE_EXCEPTION) {
                jumioErrorCase = com.jumio.dv.a.a.ALE_KEY_NOT_VALID;
            } else if (th instanceof SSLException) {
                jumioErrorCase = com.jumio.dv.a.a.CERTIFICATE_ERROR;
            } else if (cls == a.class) {
                jumioErrorCase = com.jumio.dv.a.a.REQUEST_COMPLETE_FAILED;
            }
        }
        return new JumioException(jumioErrorCase, th instanceof UnexpectedResponseException ? ((UnexpectedResponseException) th).getStatusCode() : 0);
    }
}
