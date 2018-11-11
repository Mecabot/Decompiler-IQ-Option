package com.jumio.nv;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.face.FaceDetector.Builder;
import com.jumio.MobileSDK;
import com.jumio.analytics.DismissType;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.utils.JumioBroadcastManager;
import com.jumio.core.BuildConfig;
import com.jumio.core.data.Strings;
import com.jumio.core.enums.JumioCameraPosition;
import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.environment.Environment;
import com.jumio.core.exceptions.MissingPermissionException;
import com.jumio.core.exceptions.PlatformNotSupportedException;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.plugins.PluginRegistry;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.core.util.JumioUrlValidator;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.benchmark.BenchmarkAlgorithm.DeviceCategory;
import com.jumio.nv.custom.NetverifyCustomSDKController;
import com.jumio.nv.custom.NetverifyCustomSDKInterface;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.liveness.extraction.LivenessClient;
import com.jumio.nv.liveness.extraction.LivenessDataModel;
import com.jumio.nv.models.BackendModel;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.NetverifyCredentialsModel;
import com.jumio.nv.models.NetverifyOfflineCredentialsModel;
import com.jumio.nv.models.OfflineDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.nv.models.TemplateModel;
import com.jumio.nv.utils.NetverifyLogUtils;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import jumio.nv.core.k;
import jumio.nv.core.q;

public class NetverifySDK extends MobileSDK {
    public static final String EXTRA_DETAILED_ERROR_CODE = "com.jumio.nv.NetverifySDK.EXTRA_DETAILED_ERROR_CODE";
    public static final String EXTRA_ERROR_CODE = "com.jumio.nv.NetverifySDK.EXTRA_ERROR_CODE";
    public static final String EXTRA_ERROR_MESSAGE = "com.jumio.nv.NetverifySDK.EXTRA_ERROR_MESSAGE";
    public static final String EXTRA_SCAN_DATA = "com.jumio.nv.NetverifySDK.EXTRA_SCAN_DATA";
    public static final String EXTRA_SCAN_REFERENCE = "com.jumio.nv.NetverifySDK.EXTRA_SCAN_REFERENCE";
    public static int REQUEST_CODE = 200;
    private static NetverifySDK a;
    private MerchantSettingsModel b;
    private CredentialsModel c;
    private Activity d;
    private boolean e;
    private String f;
    private String g;
    private String h;
    private String i;
    private ArrayList<NVDocumentType> j;
    private NVDocumentVariant k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private boolean s;
    private boolean t;
    private String u;
    private CompressFormat v;
    private int w;
    private a x;

    public enum GoogleVisionStatus {
        OPERATIONAL,
        NOT_OPERATIONAL,
        DIALOG_PENDING
    }

    class a extends Handler implements Subscriber<ServerSettingsModel> {
        private NetverifyInitiateCallback b;
        private int c;
        private int d;

        class a implements Subscriber<Void> {
            public void onError(Throwable th) {
            }

            private a() {
            }

            /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
                this();
            }

            /* renamed from: a */
            public void onResult(Void voidR) {
                a.this.sendEmptyMessage(a.this.c);
            }
        }

        /* synthetic */ a(NetverifySDK netverifySDK, Looper looper, NetverifyInitiateCallback netverifyInitiateCallback, AnonymousClass1 anonymousClass1) {
            this(looper, netverifyInitiateCallback);
        }

        private a(Looper looper, NetverifyInitiateCallback netverifyInitiateCallback) {
            super(looper);
            this.c = 100;
            this.d = 200;
            this.b = netverifyInitiateCallback;
        }

        public void handleMessage(Message message) {
            if (NetverifySDK.this.x != null) {
                NVBackend.unregisterFromUpdates(k.class, this);
            }
            if (message.what == this.c) {
                this.b.onNetverifyInitiateSuccess();
            } else if (message.what == this.d) {
                JumioException jumioException = (JumioException) message.obj;
                this.b.onNetverifyInitiateError(jumioException.getErrorCase().code(), jumioException.getDetailedErrorCase(), jumioException.getErrorCase().localizedMessage(NetverifySDK.this.d), jumioException.getErrorCase().retry());
            }
        }

        @InvokeOnUiThread(false)
        /* renamed from: a */
        public void onResult(ServerSettingsModel serverSettingsModel) {
            DataAccess.update(NetverifySDK.this.d, ServerSettingsModel.class, (Serializable) serverSettingsModel);
            NVBackend.unregisterFromUpdates(k.class, this);
            if (NetverifySDK.this.b.isSendDebugInfo() || serverSettingsModel.isAnalyticsEnabled()) {
                NVBackend.unlockAnalytics(NetverifySDK.this.d, NetverifySDK.this.c);
            } else {
                JumioAnalytics.disable();
            }
            if (NetverifySDK.this.b.isCountryPreSelected()) {
                ArrayList arrayList = new ArrayList(NetverifySDK.this.b.getSupportedDocumentTypes());
                arrayList.remove(NVDocumentType.PASSPORT);
                arrayList.remove(NVDocumentType.VISA);
                Country country = new Country(NetverifySDK.this.b.getIsoCode());
                TemplateModel templateModel = new TemplateModel(NetverifySDK.this.d);
                templateModel.add(new a(this, null));
                templateModel.getOrLoad(country, (NVDocumentType[]) arrayList.toArray(new NVDocumentType[arrayList.size()]), serverSettingsModel);
                return;
            }
            sendEmptyMessage(this.c);
        }

        @InvokeOnUiThread(false)
        public void onError(Throwable th) {
            Message message = new Message();
            message.what = this.d;
            message.obj = NVBackend.errorFromThrowable(NetverifySDK.this.d, th, k.class);
            sendMessage(message);
        }
    }

    private NetverifySDK(Activity activity, String str, String str2, JumioDataCenter jumioDataCenter) {
        this.e = false;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = null;
        this.k = null;
        this.l = "";
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = "";
        this.s = true;
        this.t = false;
        this.x = null;
        if (activity == null) {
            throw new NullPointerException("rootActivity is null");
        }
        MobileSDK.checkSDKRequirements(activity, false);
        Environment.checkOcrVersion(activity);
        DataAccess.delete((Context) activity, MerchantSettingsModel.class);
        DataAccess.delete((Context) activity, ServerSettingsModel.class);
        DataAccess.delete((Context) activity, SelectionModel.class);
        DataAccess.delete((Context) activity, LivenessDataModel.class);
        DataAccess.delete((Context) activity, InitiateModel.class);
        this.d = activity;
        this.c = new NetverifyCredentialsModel();
        this.c.setApiToken(str);
        this.c.setApiSecret(str2);
        this.c.setDataCenter(jumioDataCenter);
        this.b = new MerchantSettingsModel();
        this.b.setContext(activity);
    }

    private NetverifySDK(Activity activity, String str, @Nullable String str2) {
        this(activity, null, null, null);
        this.c = new NetverifyOfflineCredentialsModel();
        ((NetverifyOfflineCredentialsModel) this.c).setOfflineToken(str);
        ((NetverifyOfflineCredentialsModel) this.c).verify(activity);
        if (((NetverifyOfflineCredentialsModel) this.c).isNetverifyable()) {
            throw new PlatformNotSupportedException("Wrong product token");
        }
    }

    public static synchronized NetverifySDK create(Activity activity, String str, String str2, JumioDataCenter jumioDataCenter) {
        NetverifySDK netverifySDK;
        synchronized (NetverifySDK.class) {
            if (a == null) {
                a = new NetverifySDK(activity, str, str2, jumioDataCenter);
            }
            netverifySDK = a;
        }
        return netverifySDK;
    }

    public static synchronized NetverifySDK create(Activity activity, String str, @Nullable String str2) {
        NetverifySDK netverifySDK;
        synchronized (NetverifySDK.class) {
            if (a == null) {
                a = new NetverifySDK(activity, str, str2);
            }
            if (!(str2 == null || str2.length() == 3)) {
                str2 = null;
            }
            ((NetverifyOfflineCredentialsModel) a.c).setPreferredCountry(str2);
            netverifySDK = a;
        }
        return netverifySDK;
    }

    private static synchronized void a() {
        synchronized (NetverifySDK.class) {
            a = null;
        }
    }

    public static boolean isSupportedPlatform(Context context) {
        return MobileSDK.isSupportedPlatform(context, false);
    }

    public static GoogleVisionStatus isMobileVisionOperational(Activity activity, int i) {
        try {
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(activity);
            if (isGooglePlayServicesAvailable == 0) {
                q qVar = new q(new Builder(activity).setLandmarkType(0).setMode(1).setProminentFaceOnly(true).setClassificationType(1).build());
                if (qVar.isOperational()) {
                    qVar.release();
                    return GoogleVisionStatus.OPERATIONAL;
                }
                throw new Exception("Facedetector not operational");
            } else if (!instance.isUserResolvableError(isGooglePlayServicesAvailable)) {
                return GoogleVisionStatus.NOT_OPERATIONAL;
            } else {
                Dialog errorDialog = instance.getErrorDialog(activity, isGooglePlayServicesAvailable, i);
                errorDialog.setCancelable(false);
                errorDialog.show();
                return GoogleVisionStatus.DIALOG_PENDING;
            }
        } catch (Exception unused) {
            return GoogleVisionStatus.NOT_OPERATIONAL;
        }
    }

    public static String getDebugID() {
        try {
            UUID sessionId = JumioAnalytics.getSessionId();
            if (sessionId != null) {
                return sessionId.toString();
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public synchronized void destroy() {
        DataAccess.delete(this.d, MerchantSettingsModel.class);
        DataAccess.delete(this.d, ServerSettingsModel.class);
        DataAccess.delete(this.d, SelectionModel.class);
        DataAccess.delete(this.d, LivenessDataModel.class);
        DataAccess.delete(this.d, InitiateModel.class);
        DataAccess.delete(this.d, DeviceCategory.class);
        DataAccess.delete(this.d, NVScanPartModel.class);
        DataAccess.delete(this.d, "fallbackScanPartModel");
        DataAccess.delete(this.d, PreviewProperties.class);
        DataAccess.delete(this.d, BackendModel.class);
        DataAccess.delete(this.d, DocumentDataModel.class);
        DataAccess.delete(this.d, OfflineDataModel.class);
        JumioAnalytics.shutdown(new Runnable() {
            public void run() {
                NVBackend.freeEncryption();
            }
        });
        this.e = false;
        JumioBroadcastManager.destroy();
        this.c = null;
        this.b = null;
        this.d = null;
        a();
        super.destroy();
    }

    public void setOfflineToken(String str, @Nullable String str2) {
        if (this.c instanceof NetverifyCredentialsModel) {
            NetverifyOfflineCredentialsModel netverifyOfflineCredentialsModel = new NetverifyOfflineCredentialsModel();
            netverifyOfflineCredentialsModel.setOfflineToken(str);
            netverifyOfflineCredentialsModel.verify(this.d);
            netverifyOfflineCredentialsModel.setPreferredCountry(str2);
            if (netverifyOfflineCredentialsModel.isNetverifyable()) {
                ((NetverifyCredentialsModel) this.c).setOfflineCredentialsModel(netverifyOfflineCredentialsModel);
                return;
            }
            throw new PlatformNotSupportedException("Wrong product token");
        }
    }

    public void setOutput(String str, CompressFormat compressFormat, int i) {
        if (str == null || !new File(str).isDirectory()) {
            throw new IllegalArgumentException("Provided path is no directory or doesn't exist.");
        } else if (compressFormat == null) {
            throw new IllegalArgumentException("Compressformat can not be null!");
        } else if (i < 0 || i > 100) {
            throw new IllegalArgumentException("Quality level must be between 0 and 100 !");
        } else {
            this.u = str;
            this.v = compressFormat;
            this.w = i;
        }
    }

    public void setCustomerId(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.g = str;
    }

    public void setPreselectedCountry(String str) {
        if (str == null || str.length() != 3) {
            str = "";
        }
        this.h = str;
    }

    public void setPreselectedDocumentTypes(ArrayList<NVDocumentType> arrayList) {
        this.j = new ArrayList();
        if (arrayList != null && arrayList.size() != 0) {
            this.j.addAll(arrayList);
        }
    }

    public void setPreselectedDocumentVariant(NVDocumentVariant nVDocumentVariant) {
        this.k = nVDocumentVariant;
    }

    public void setMerchantScanReference(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.l = str;
    }

    public void setRequireFaceMatch(boolean z) {
        this.n = true;
        this.m = z;
    }

    public void setRequireVerification(boolean z) {
        this.o = z;
    }

    public void setMerchantReportingCriteria(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.f = str;
    }

    public void setCameraPosition(JumioCameraPosition jumioCameraPosition) {
        this.p = jumioCameraPosition == JumioCameraPosition.FRONT;
    }

    public void setDataExtractionOnMobileOnly(boolean z) {
        this.q = z;
    }

    public void setCallbackUrl(String str) {
        if (str == null) {
            str = "";
        }
        if (!new JumioUrlValidator(new String[]{"https"}, false, false, false, false).isValid(str) || str.length() > 255) {
            Log.w("NetverifySDK", "The provided callback url is not valid!");
        } else {
            this.r = str;
        }
    }

    public void setEnableEMRTD(boolean z) {
        this.s = z;
    }

    public void sendDebugInfoToJumio(boolean z) {
        this.t = z;
    }

    public void setAdditionalInformation(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.i = str;
    }

    public synchronized void initiate(@NonNull NetverifyInitiateCallback netverifyInitiateCallback) {
        if (netverifyInitiateCallback == null) {
            throw new IllegalArgumentException("NetverifyInitiateCallback must be set!");
        } else if (this.c instanceof NetverifyOfflineCredentialsModel) {
            netverifyInitiateCallback.onNetverifyInitiateSuccess();
        } else if (this.x == null) {
            this.x = new a(this, Looper.getMainLooper(), netverifyInitiateCallback, null);
            b();
            ServerSettingsModel serverSettingsModel = (ServerSettingsModel) DataAccess.load(this.d, ServerSettingsModel.class);
            if (serverSettingsModel == null || !serverSettingsModel.isLoaded()) {
                NVBackend.settings(this.d, this.c, this.b, this.x);
            } else {
                netverifyInitiateCallback.onNetverifyInitiateSuccess();
            }
        }
    }

    private void b() {
        NetverifyLogUtils.init();
        boolean z = true;
        if (!this.e) {
            if (this.c instanceof NetverifyOfflineCredentialsModel) {
                JumioAnalytics.disable();
            } else {
                JumioAnalytics.start();
                this.e = true;
            }
        }
        JumioAnalytics.add(MobileEvents.sdkLifecycle(JumioAnalytics.getSessionId(), DismissType.INSTANCE_CREATED));
        if (this.j == null) {
            this.j = new ArrayList();
        }
        if (this.j.size() == 0) {
            this.j.add(NVDocumentType.PASSPORT);
            this.j.add(NVDocumentType.VISA);
            this.j.add(NVDocumentType.IDENTITY_CARD);
            this.j.add(NVDocumentType.DRIVER_LICENSE);
        }
        MerchantSettingsModel merchantSettingsModel = (MerchantSettingsModel) DataAccess.load(this.d, MerchantSettingsModel.class);
        if (merchantSettingsModel != null) {
            Object obj = this.j.size() == merchantSettingsModel.getSupportedDocumentTypes().size() ? 1 : null;
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                if (!merchantSettingsModel.getSupportedDocumentTypes().contains((NVDocumentType) it.next())) {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                DataAccess.delete(this.d, ServerSettingsModel.class);
            }
        } else {
            DataAccess.delete(this.d, ServerSettingsModel.class);
        }
        DataAccess.delete(this.d, MerchantSettingsModel.class);
        DataAccess.delete(this.d, SelectionModel.class);
        DataAccess.delete(this.d, LivenessDataModel.class);
        DataAccess.delete(this.d, InitiateModel.class);
        DataAccess.delete(this.d, DeviceCategory.class);
        DataAccess.delete(this.d, NVScanPartModel.class);
        DataAccess.delete(this.d, "fallbackScanPartModel");
        DataAccess.delete(this.d, PreviewProperties.class);
        DataAccess.delete(this.d, BackendModel.class);
        DataAccess.delete(this.d, DocumentDataModel.class);
        DataAccess.delete(this.d, OfflineDataModel.class);
        this.b.setCountryIsoCode(this.h);
        this.b.setCountryPreSelected(this.h.length() != 0);
        if (this.j.size() == 1) {
            this.b.setPreSelectedDocumentType((NVDocumentType) this.j.get(0));
        }
        this.b.setSupportedDocumentTypes(this.j);
        this.b.setDocumentVariant(this.k);
        this.b.setDocumentVariantPreSelected(this.k != null);
        merchantSettingsModel = this.b;
        boolean z2 = this.m && JumioCameraManager.hasFrontFacingCamera(this.d) && LivenessClient.getVisionStatus(this.d) == null;
        merchantSettingsModel.setFaceMatchEnabled(z2);
        merchantSettingsModel = this.b;
        z2 = (!this.n && JumioCameraManager.hasFrontFacingCamera(this.d) && LivenessClient.getVisionStatus(this.d) == null) ? false : true;
        merchantSettingsModel.setFaceMatchSet(z2);
        this.b.setMerchantScanReference(this.l);
        this.b.setMerchantReportingCriteria(this.f);
        this.b.setCustomerId(this.g);
        this.b.setRequireVerification(this.o);
        this.b.setCameraFacingFront(this.p);
        this.b.setCallbackUrl(this.r);
        this.b.setDataExtractionOnMobileOnly(this.q);
        this.b.setEnableEMRTD(this.s);
        this.b.setSendDebugInfo(this.t);
        this.b.setAdditionalInformation(this.i);
        this.b.setOutputDirectory(this.u);
        this.b.setOutputFormat(this.v);
        this.b.setOutputLevel(this.w);
        if (this.c instanceof NetverifyOfflineCredentialsModel) {
            this.b.setRequireVerification(false);
            this.b.setDataExtractionOnMobileOnly(true);
        }
        if (this.c instanceof NetverifyCredentialsModel) {
            ((NetverifyCredentialsModel) this.c).setOfflineSwitch(false);
        }
        JumioAnalytics.allowEvent(MobileEvents.EVENTTYPE_ANDROID_LIFECYCLE, this.t);
        boolean hasSystemFeature = this.d.getPackageManager().hasSystemFeature("android.hardware.nfc");
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.d);
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            z = false;
        }
        String str = null;
        String str2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.d.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                str2 = activeNetworkInfo.getType() == 0 ? "CELLULAR" : "WIFI";
            } else if (((TelephonyManager) this.d.getSystemService("phone")).getDataState() == 2) {
                str2 = "CELLULAR";
            }
            str = str2;
        } catch (Exception unused) {
            str2 = BuildConfig.VERSION_NAME;
            JumioAnalytics.add(MobileEvents.mobileDeviceInformation(JumioAnalytics.getSessionId(), str2.substring(0, str2.indexOf(" (")), str, hasSystemFeature, z));
            if (PluginRegistry.getPlugin(PluginMode.NFC) == null) {
                this.b.setEnableEMRTD(false);
            }
            Logger.getLogger("org.jmrtd").setLevel(Level.OFF);
            DataAccess.update(this.d, MerchantSettingsModel.class, this.b);
            Strings.setFactory(new com.jumio.nv.data.NVStrings.a());
        }
    }

    public void start() {
        this.d.startActivityForResult(getIntent(), REQUEST_CODE);
    }

    public Intent getIntent() {
        if (MobileSDK.hasAllRequiredPermissions(this.d)) {
            b();
            this.b.setWaitedForInitialize(this.x != null);
            DataAccess.update(this.d, MerchantSettingsModel.class, this.b);
            if (this.x != null) {
                NVBackend.unregisterFromUpdates(k.class, this.x);
                this.x = null;
            } else {
                ServerSettingsModel serverSettingsModel = (ServerSettingsModel) DataAccess.load(this.d, ServerSettingsModel.class);
                if (serverSettingsModel == null || !serverSettingsModel.isLoaded()) {
                    NVBackend.settings(this.d, this.c, this.b, null);
                }
            }
            return super.getIntent(this.d, NetverifyActivity.class, this.c);
        }
        throw new MissingPermissionException(MobileSDK.getMissingPermissions(this.d));
    }

    public NetverifyCustomSDKController start(NetverifyCustomSDKInterface netverifyCustomSDKInterface) {
        if (MobileSDK.hasAllRequiredPermissions(this.d)) {
            if (this.h != null) {
                this.h = "";
            }
            if (this.j != null) {
                this.j.clear();
            }
            b();
            boolean z = false;
            this.b.setEnableEMRTD(false);
            MerchantSettingsModel merchantSettingsModel = this.b;
            if (this.x != null) {
                z = true;
            }
            merchantSettingsModel.setWaitedForInitialize(z);
            DataAccess.update(this.d, MerchantSettingsModel.class, this.b);
            if (this.x != null) {
                NVBackend.unregisterFromUpdates(k.class, this.x);
                this.x = null;
            } else {
                ServerSettingsModel serverSettingsModel = (ServerSettingsModel) DataAccess.load(this.d, ServerSettingsModel.class);
                if (serverSettingsModel == null || !serverSettingsModel.isLoaded()) {
                    NVBackend.settings(this.d, this.c, this.b, null);
                }
            }
            return new NetverifyCustomSDKController(this.d, this.c, netverifyCustomSDKInterface);
        }
        throw new MissingPermissionException(MobileSDK.getMissingPermissions(this.d));
    }
}
