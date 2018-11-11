package com.jumio.nv.api.calls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import com.jumio.alejwt.swig.ALECore;
import com.jumio.alejwt.swig.ALESettings;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.Publisher;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.ApiError;
import com.jumio.core.network.DownloadTask;
import com.jumio.core.network.EncryptionProvider;
import com.jumio.core.network.NetworkException;
import com.jumio.core.network.PinningConfig;
import com.jumio.core.network.ale.AleEncryptionProvider;
import com.jumio.core.network.ale.AleSecurityConfig;
import com.jumio.core.network.ale.SynchronizedAleCore;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.NetverifyCredentialsModel;
import com.jumio.nv.models.NetverifyOfflineCredentialsModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.models.OfflineCredentialsModel;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import jumio.nv.core.c;
import jumio.nv.core.d;
import jumio.nv.core.e;
import jumio.nv.core.f;
import jumio.nv.core.g;
import jumio.nv.core.h;
import jumio.nv.core.i;
import jumio.nv.core.j;
import jumio.nv.core.k;
import org.json.JSONObject;

public class NVBackend {
    public static final String USER_AGENT = "Jumio Netverify Android SDK JMSDK 2.10.0 (0-63)";
    private static final String a = StringObfuscater.format(new byte[]{(byte) -92, (byte) 67, (byte) 116, (byte) 10, (byte) 114, (byte) -8, (byte) 46, (byte) 47, (byte) 47, (byte) 39, (byte) 126, (byte) 125, (byte) -111, (byte) -124, (byte) -105, (byte) 47, (byte) 101, (byte) -74, (byte) 71, (byte) 93, (byte) -76, (byte) -7, (byte) 39, (byte) -45, (byte) -91, (byte) -22, (byte) 121, (byte) -73, (byte) -77, (byte) -103, (byte) 60, (byte) 39, (byte) -28, (byte) 12, (byte) -88, (byte) -34, (byte) -34, (byte) 76, (byte) 87, (byte) 88, (byte) 37, (byte) -54, (byte) 71, (byte) -43, (byte) -32, (byte) -67, (byte) -12, (byte) 120, (byte) -86}, -4640201068163483407L);
    private static final String b = StringObfuscater.format(new byte[]{(byte) 41, (byte) 0, (byte) 67, (byte) -126, (byte) 0, (byte) 71, (byte) -117, (byte) -67, (byte) -75, (byte) -44, (byte) 41, (byte) 25, (byte) 77, (byte) -54, (byte) -44, (byte) -23, (byte) 47, (byte) -44, (byte) -33, (byte) 85, (byte) 94, (byte) 12, (byte) 24, (byte) -117, (byte) -13, (byte) -30, (byte) 73, (byte) -91, (byte) -18, (byte) 10, (byte) 77, (byte) 73, (byte) 75, (byte) -47, (byte) 116, (byte) 104, (byte) -114, (byte) -99, (byte) -8, (byte) -57, (byte) 106, (byte) -54, (byte) 33, (byte) 50, (byte) -22, (byte) 46, (byte) -12, (byte) 22, (byte) 42, (byte) 19, (byte) -121, (byte) 109, (byte) -3}, -6229241285353764017L);
    private static String c = a;
    private static String d = b;
    private static String e = AleSecurityConfig.ALE_KEY_ID_US;
    private static String f = AleSecurityConfig.ALE_KEY_ID_EU;
    private static String g = AleSecurityConfig.ALE_PUBLIC_KEY_US;
    private static String h = AleSecurityConfig.ALE_PUBLIC_KEY_EU;
    private static int i;
    private static j j = new j(Executors.newSingleThreadExecutor());
    private static ALECore k;

    static class b extends Publisher<Void> implements Callable<Void> {
        private b() {
        }

        /* renamed from: a */
        public Void call() {
            if (NVBackend.k != null) {
                NVBackend.k.delete();
                NVBackend.k = null;
            }
            publishResult(null);
            return null;
        }
    }

    static class a implements c {
        private Context a;
        private CredentialsModel b;

        public a(Context context, CredentialsModel credentialsModel) {
            this.a = context;
            this.b = credentialsModel;
        }

        public EncryptionProvider getEncryptionProvider() {
            return NVBackend.c(this.a, this.b);
        }

        public byte[][] getPublicKeys() {
            return this.b.getDataCenter() == JumioDataCenter.EU ? PinningConfig.PUBLIC_KEY_EU : PinningConfig.PUBLIC_KEY_US;
        }

        public boolean isOffline() {
            return (this.b instanceof OfflineCredentialsModel) || ((this.b instanceof NetverifyCredentialsModel) && ((NetverifyCredentialsModel) this.b).getOfflineCredentialsModel() != null && ((NetverifyCredentialsModel) this.b).useOffline());
        }

        public boolean a(Throwable th, Context context, boolean z) {
            if ((th instanceof SocketTimeoutException) || (th instanceof NetworkException) || (th instanceof SSLException) || ((th instanceof UnexpectedResponseException) && ((UnexpectedResponseException) th).getStatusCode() == 403)) {
                InitiateModel initiateModel = (InitiateModel) DataAccess.load(context, InitiateModel.class);
                if ((initiateModel == null || initiateModel.getJumioScanRef() == null) && (this.b instanceof NetverifyCredentialsModel) && ((NetverifyCredentialsModel) this.b).getOfflineCredentialsModel() != null && ((NetverifyCredentialsModel) this.b).getOfflineCredentialsModel().isNetverifyable() && !(z && NVBackend.d(context, this.b))) {
                    return true;
                }
            }
            return false;
        }

        public CredentialsModel a() {
            return this.b;
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

    public static void initiate(Context context, CredentialsModel credentialsModel, MerchantSettingsModel merchantSettingsModel, ServerSettingsModel serverSettingsModel, @Nullable Subscriber<String> subscriber) {
        a(context, subscriber, new h(context, new a(context, credentialsModel), merchantSettingsModel, serverSettingsModel, j), credentialsModel);
    }

    public static void settings(Context context, CredentialsModel credentialsModel, MerchantSettingsModel merchantSettingsModel, @Nullable Subscriber<ServerSettingsModel> subscriber) {
        a(context, subscriber, new k(context, new a(context, credentialsModel), credentialsModel, merchantSettingsModel, j), credentialsModel);
    }

    public static void addPart(Context context, CredentialsModel credentialsModel, NVScanPartModel nVScanPartModel, @Nullable Subscriber<Void> subscriber, byte[] bArr) {
        a(context, subscriber, new d(context, new a(context, credentialsModel), nVScanPartModel.getSideToScan(), nVScanPartModel.getScannedImage(), bArr, j), credentialsModel);
    }

    public static void liveness(Context context, CredentialsModel credentialsModel, @Nullable Subscriber<Void> subscriber, String[] strArr) {
        a(context, subscriber, new i(context, new a(context, credentialsModel), strArr, j), credentialsModel);
    }

    public static void data(Context context, CredentialsModel credentialsModel, @Nullable Subscriber<Void> subscriber) {
        a(context, subscriber, new e(context, new a(context, credentialsModel), j), credentialsModel);
    }

    public static void extractData(Context context, CredentialsModel credentialsModel, @Nullable Subscriber<DocumentDataModel> subscriber, byte[] bArr) {
        a(context, subscriber, new f(context, new a(context, credentialsModel), bArr, j), credentialsModel);
    }

    public static void finalizeCall(Context context, CredentialsModel credentialsModel, Subscriber<Void> subscriber) {
        ApiCall gVar = new g(context, new a(context, credentialsModel), j);
        if (credentialsModel instanceof NetverifyCredentialsModel) {
            ((NetverifyCredentialsModel) credentialsModel).setFinalize(true);
        }
        a(context, subscriber, gVar, credentialsModel);
    }

    public static void registerForUpdates(Context context, Class<? extends ApiCall> cls, Subscriber subscriber) {
        j.b(context, cls, subscriber);
    }

    public static void unregisterFromUpdates(Class<? extends ApiCall> cls, Subscriber subscriber) {
        j.a(cls, subscriber);
    }

    public static void unlockAnalytics(Context context, CredentialsModel credentialsModel) {
        if (!(credentialsModel instanceof NetverifyOfflineCredentialsModel)) {
            JumioAnalytics.unlock(context, new a(context, credentialsModel), a(credentialsModel), "Jumio Netverify Android SDK JMSDK 2.10.0 (0-63)");
        }
    }

    public static int cancelAllPending() {
        int b = j.b();
        j.c();
        j = new j(Executors.newSingleThreadExecutor());
        return b;
    }

    public static void forceRetry() {
        j.a();
    }

    private static synchronized EncryptionProvider c(Context context, CredentialsModel credentialsModel) {
        String str;
        EncryptionProvider aleEncryptionProvider;
        synchronized (NVBackend.class) {
            if (k == null) {
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

    private static boolean d(Context context, CredentialsModel credentialsModel) {
        ServerSettingsModel serverSettingsModel = (ServerSettingsModel) DataAccess.load(context, ServerSettingsModel.class);
        boolean z = true;
        try {
            byte[] statusPublicKey;
            ApiError.onStatusMock(i);
            if (serverSettingsModel != null) {
                statusPublicKey = serverSettingsModel.getStatusPublicKey();
            } else if (!(credentialsModel instanceof NetverifyCredentialsModel) || ((NetverifyCredentialsModel) credentialsModel).getOfflineCredentialsModel() == null) {
                return true;
            } else {
                statusPublicKey = ((NetverifyCredentialsModel) credentialsModel).getOfflineCredentialsModel().getStatusPublicKey();
            }
            if (new JSONObject(new String(new DownloadTask("https://status.jumio.com", statusPublicKey, 5000).startSync())).optInt(NotificationCompat.CATEGORY_STATUS, 0) != 1) {
                z = false;
            }
        } catch (Exception e) {
            if ((e instanceof UnexpectedResponseException) && ((UnexpectedResponseException) e).getStatusCode() == -1) {
                z = Boolean.parseBoolean(e.getMessage());
            }
        }
        return z;
    }

    public static synchronized void freeEncryption() {
        synchronized (NVBackend.class) {
            j.a(new b());
        }
    }

    private static void a(Context context, @Nullable Subscriber subscriber, ApiCall apiCall, CredentialsModel credentialsModel) {
        j.b(context, apiCall.getClass(), subscriber);
        apiCall.configure(a(credentialsModel), "Jumio Netverify Android SDK JMSDK 2.10.0 (0-63)");
        j.a(apiCall);
    }

    public static JumioException errorFromThrowable(Context context, Throwable th, Class<?> cls) {
        JumioErrorCase jumioErrorCase = null;
        NetworkInfo activeNetworkInfo = context != null ? ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            jumioErrorCase = NVErrorCase.DEVICE_IS_OFFLINE;
        } else {
            boolean z = th instanceof UnexpectedResponseException;
            if (z && ((UnexpectedResponseException) th).getStatusCode() == UnexpectedResponseException.STATUS_CODE_UNAUTHORIZED) {
                jumioErrorCase = NVErrorCase.AUTH_FAILED;
            } else if (z && ((UnexpectedResponseException) th).getStatusCode() == 403) {
                jumioErrorCase = NVErrorCase.INVALID_CREDENTIALS;
            } else if (z && ((UnexpectedResponseException) th).getStatusCode() == MobileEvents.EVENTTYPE_EXCEPTION) {
                jumioErrorCase = NVErrorCase.ALE_KEY_NOT_VALID;
            } else if (z && ((UnexpectedResponseException) th).getStatusCode() == 412) {
                jumioErrorCase = NVErrorCase.TRANSACTION_FINISHED;
            } else if (th instanceof SSLException) {
                jumioErrorCase = NVErrorCase.CERTIFICATE_ERROR;
            } else if (cls == k.class) {
                jumioErrorCase = NVErrorCase.REQUEST_SETTINGS_FAILED;
            } else if (cls == h.class) {
                jumioErrorCase = NVErrorCase.REQUEST_INITIATE_FAILED;
            } else if (cls == d.class) {
                jumioErrorCase = NVErrorCase.REQUEST_ADD_PART_FAILED;
            } else if (cls == g.class) {
                jumioErrorCase = NVErrorCase.REQUEST_FINALIZE_FAILED;
            } else if (cls == e.class) {
                jumioErrorCase = NVErrorCase.REQUEST_DATA_FAILED;
            } else if (cls == f.class) {
                jumioErrorCase = NVErrorCase.REQUEST_EXTRACT_DATA_FAILED;
            }
        }
        return new JumioException(jumioErrorCase, th instanceof UnexpectedResponseException ? ((UnexpectedResponseException) th).getStatusCode() : 0);
    }
}
