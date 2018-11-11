package jumio.nv.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.content.LocalBroadcastManager;
import android.util.TypedValue;
import com.jumio.analytics.DismissType;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.StringUtil;
import com.jumio.core.data.Strings;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.nv.R;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.benchmark.Benchmark;
import com.jumio.nv.benchmark.BenchmarkAlgorithm.DeviceCategory;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.liveness.extraction.LivenessDataModel;
import com.jumio.nv.models.BackendModel;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.OfflineDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.models.CredentialsModel;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;

/* compiled from: NetverifyController */
public class b {
    protected BroadcastReceiver a;
    protected NfcController b;
    protected DeviceRotationManager c;
    protected b d;

    /* compiled from: NetverifyController */
    class a implements UncaughtExceptionHandler {
        private final UncaughtExceptionHandler b;

        public a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            String str = JumioAnalytics.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrapping handler :");
            stringBuilder.append(uncaughtExceptionHandler.getClass().toString());
            Log.v(str, stringBuilder.toString());
            this.b = uncaughtExceptionHandler;
        }

        public void a() {
            if (Thread.getDefaultUncaughtExceptionHandler() == this) {
                Thread.setDefaultUncaughtExceptionHandler(this.b);
            }
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (th instanceof Exception) {
                String str = JumioAnalytics.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("uncaught exception: ");
                stringBuilder.append(th);
                Log.d(str, stringBuilder.toString());
                JumioAnalytics.add(MobileEvents.exception(JumioAnalytics.getSessionId(), (Exception) th));
                JumioAnalytics.add(MobileEvents.sdkLifecycle(JumioAnalytics.getSessionId(), DismissType.ABORTED));
                JumioAnalytics.flush();
            }
            if (this.b != null) {
                this.b.uncaughtException(thread, th);
            }
        }
    }

    /* compiled from: NetverifyController */
    public interface b {
        void finishSDK(Intent intent);
    }

    /* compiled from: NetverifyController */
    class c implements NfcController {
        public boolean consumeIntent(int i, Intent intent) {
            return false;
        }

        public void downloadCertificates(ServerSettingsModel serverSettingsModel) {
        }

        public boolean hasNfcFeature() {
            return false;
        }

        public boolean hasRootCertificate(String str) {
            return false;
        }

        public boolean isNfcEnabled() {
            return false;
        }

        public void pause(Activity activity) {
        }

        public void setEnabled(boolean z) {
        }

        public void setTagAccess(Object obj) {
        }

        public void start(Activity activity) {
        }

        public void stop() {
        }

        private c() {
        }

        /* synthetic */ c(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public b() {
        Strings.setFactory(new com.jumio.nv.data.NVStrings.a());
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(Activity activity, CredentialsModel credentialsModel, boolean z) {
        this.c = new DeviceRotationManager(activity, Rotation.NATIVE);
        if (z) {
            Collection arrayList = new ArrayList();
            a(activity, R.style.Base_Theme_Netverify, R.styleable.jumio, arrayList);
            a(activity, R.style.Base_Theme_Netverify, R.styleable.netverify, arrayList);
            MerchantSettingsModel merchantSettingsModel = (MerchantSettingsModel) DataAccess.load((Context) activity, MerchantSettingsModel.class);
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("dataCenter", credentialsModel.getDataCenter() != null ? credentialsModel.getDataCenter().toString() : "");
            metaInfo.put("preselectedCountry", merchantSettingsModel.getIsoCode() != null ? merchantSettingsModel.getIsoCode() : "");
            int i = 0;
            int i2 = merchantSettingsModel.getDocumentVariant() == NVDocumentVariant.PAPER ? 1 : merchantSettingsModel.getDocumentVariant() == NVDocumentVariant.PLASTIC ? 2 : 0;
            metaInfo.put("preselectedDocumentStyle", Integer.valueOf(i2));
            if (merchantSettingsModel.getSupportedDocumentTypes() != null) {
                Iterator it = merchantSettingsModel.getSupportedDocumentTypes().iterator();
                while (it.hasNext()) {
                    int i3;
                    switch ((NVDocumentType) it.next()) {
                        case PASSPORT:
                            i3 = i | 1;
                            break;
                        case DRIVER_LICENSE:
                            i3 = i | 2;
                            break;
                        case IDENTITY_CARD:
                            i3 = i | 4;
                            break;
                        case VISA:
                            i3 = i | 8;
                            break;
                        default:
                            continue;
                    }
                    i = i3;
                }
                if (i > 0) {
                    metaInfo.put("preselectedDocumentTypes", Integer.valueOf(i));
                }
            }
            metaInfo.put("requireFaceMatch", Boolean.valueOf(merchantSettingsModel.isFaceMatchEnabled()));
            metaInfo.put("requireVerification", Boolean.valueOf(merchantSettingsModel.requireVerification()));
            metaInfo.put("merchantReportingCriteria", Boolean.valueOf(StringUtil.nullOrEmpty(merchantSettingsModel.getMerchantReportingCriteria()) ^ true));
            metaInfo.put("merchantScanReference ", Boolean.valueOf(StringUtil.nullOrEmpty(merchantSettingsModel.getMerchantScanReference()) ^ true));
            metaInfo.put("customerId", Boolean.valueOf(StringUtil.nullOrEmpty(merchantSettingsModel.getCustomerId()) ^ true));
            metaInfo.put("cameraPositionFront", Boolean.valueOf(merchantSettingsModel.isCameraFrontfacing()));
            metaInfo.put("callbackUrl", Boolean.valueOf(StringUtil.nullOrEmpty(merchantSettingsModel.getCallbackUrl()) ^ true));
            metaInfo.put("dataExtractionOnMobileOnly", Boolean.valueOf(merchantSettingsModel.isDataExtractionOnMobileOnly()));
            metaInfo.put("sendDebugInfoToJumio", Boolean.valueOf(merchantSettingsModel.isSendDebugInfo()));
            metaInfo.put("eMrtdEnabled", Boolean.valueOf(merchantSettingsModel.isEnableEMRTD()));
            metaInfo.put("didFinishInitializing", Boolean.valueOf(merchantSettingsModel.hasWaitedForInitialize()));
            metaInfo.put("theming", new JSONArray(arrayList));
            if (ReflectionUtil.hasClass("com.facebook.react.ReactActivity")) {
                metaInfo.put("superDelegate", "ReactActivity");
            } else if (ReflectionUtil.hasClass("org.apache.cordova.CordovaActivity")) {
                metaInfo.put("superDelegate", "CordovaActivity");
            }
            JumioAnalytics.add(MobileEvents.sdkParameters(JumioAnalytics.getSessionId(), metaInfo));
        }
        new Benchmark(activity).startMeasurement();
    }

    private void a(Activity activity, int i, int[] iArr, ArrayList<String> arrayList) {
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(i, iArr);
        TypedArray obtainStyledAttributes2 = activity.getTheme().obtainStyledAttributes(iArr);
        int i2 = 0;
        while (i2 < obtainStyledAttributes.length()) {
            try {
                TypedValue peekValue = obtainStyledAttributes.peekValue(i2);
                TypedValue peekValue2 = obtainStyledAttributes2.peekValue(i2);
                if (peekValue.type != peekValue2.type || peekValue.data != peekValue2.data || peekValue.string != peekValue2.string || peekValue.density != peekValue2.density) {
                    arrayList.add(activity.getResources().getResourceEntryName(iArr[i2]));
                }
            } catch (Exception unused) {
                i2++;
            }
        }
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    public void a() {
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    }

    public void a(Context context) {
        this.a = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.jumio.nv.CLOSE_SDK")) {
                    b.this.a(context, intent);
                }
            }
        };
        LocalBroadcastManager.getInstance(context).registerReceiver(this.a, a.a());
    }

    public void b(Context context) {
        if (this.a != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.a);
            this.a = null;
        }
    }

    public void b() {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null && (defaultUncaughtExceptionHandler instanceof a)) {
            ((a) defaultUncaughtExceptionHandler).a();
        }
    }

    public void c() {
        JumioAnalytics.shutdown(new Runnable() {
            public void run() {
                NVBackend.freeEncryption();
            }
        });
    }

    public NfcController c(Context context) {
        if (this.b == null) {
            this.b = p.a(context);
            if (this.b == null) {
                this.b = new c(this, null);
            }
        }
        return this.b;
    }

    public DeviceRotationManager d() {
        return this.c;
    }

    public void a(Context context, Intent intent) {
        int i = 0;
        try {
            JumioAnalytics.add(MobileEvents.sdkLifecycle(JumioAnalytics.getSessionId(), intent.getIntExtra("com.jumio.nv.RESULT", 0) == -1 ? DismissType.FINISHED : DismissType.CANCELLED));
        } catch (IllegalStateException unused) {
            DataAccess.delete(context, SelectionModel.class);
            DataAccess.delete(context, InitiateModel.class);
            DataAccess.delete(context, BackendModel.class);
            DataAccess.delete(context, LivenessDataModel.class);
            DataAccess.delete(context, DeviceCategory.class);
            DataAccess.delete(context, NVScanPartModel.class);
            DataAccess.delete(context, "fallbackScanPartModel");
            DataAccess.delete(context, PreviewProperties.class);
            DataAccess.delete(context, BackendModel.class);
            DataAccess.delete(context, DocumentDataModel.class);
            DataAccess.delete(context, OfflineDataModel.class);
            File[] listFiles = new File(context.getFilesDir(), "jumio").listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file = listFiles[i];
                    if (file.isFile() && file.getName().startsWith("tmp_") && !file.delete()) {
                        file.deleteOnExit();
                    }
                    i++;
                }
            }
            NVBackend.cancelAllPending();
            if (this.d != null) {
                this.d.finishSDK(intent);
            }
        }
    }
}
