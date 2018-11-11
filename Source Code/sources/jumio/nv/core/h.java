package jumio.nv.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.SimpleApiCall;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.liveness.extraction.LivenessClient;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NetverifyCredentialsModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.models.CredentialsModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import jumio.nv.core.j.a;
import org.json.JSONObject;

/* compiled from: InitiateCall */
public class h extends SimpleApiCall<String> implements a {
    private static int a;
    private MerchantSettingsModel b;
    private ServerSettingsModel c;

    public h(Context context, c cVar, MerchantSettingsModel merchantSettingsModel, ServerSettingsModel serverSettingsModel, Subscriber<String> subscriber) {
        super(context, cVar, subscriber);
        this.b = merchantSettingsModel;
        this.c = serverSettingsModel;
    }

    public String getUri() {
        return StringObfuscater.format(new byte[]{(byte) 111, (byte) -17, (byte) -97, (byte) -127, (byte) -78}, 6070354384363082626L);
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
        JumioAnalytics.add(MobileEvents.networkRequest(JumioAnalytics.getSessionId(), getClass().getName(), i, str, j));
    }

    /* renamed from: a */
    protected String parseResponse(String str) {
        try {
            str = new JSONObject(str).getString("jumioIdScanReference");
            Serializable serializable = (InitiateModel) DataAccess.load(this.context, InitiateModel.class);
            if (serializable == null) {
                serializable = new InitiateModel();
            }
            serializable.setJumioScanRef(str);
            JumioAnalytics.setScanReference(str);
            if (Log.isFileLoggingActivated()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NV_");
                stringBuilder.append(str);
                LogUtils.setSesssionLogFolderName(stringBuilder.toString());
            }
            DataAccess.update(this.context, InitiateModel.class, serializable);
            return str;
        } catch (Throwable e) {
            Log.w(this.TAG, "JSON Exception", e);
            return null;
        }
    }

    /* renamed from: a */
    protected String offlineResponse() {
        String str = "";
        Serializable serializable = (InitiateModel) DataAccess.load(this.context, InitiateModel.class);
        if (serializable == null) {
            serializable = new InitiateModel();
        }
        serializable.setJumioScanRef(str);
        if (Log.isFileLoggingActivated()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NV_");
            stringBuilder.append(str);
            LogUtils.setSesssionLogFolderName(stringBuilder.toString());
        }
        DataAccess.update(this.context, InitiateModel.class, serializable);
        return str;
    }

    protected String getRequest() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk-platform", "Android");
        jSONObject.put("sdk-version", "JMSDK 2.10.0 (0-63)");
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("software-version", VERSION.RELEASE);
        jSONObject.put("software-build-number", Build.DISPLAY);
        jSONObject.put("kernel-version", System.getProperty("os.version"));
        JSONObject jSONObject2 = new JSONObject();
        if (this.b == null) {
            throw new IllegalStateException("InitiateCall#getRequestBody: model cannot be null!");
        }
        if (!this.b.getMerchantScanReference().equals("")) {
            jSONObject2.put("merchantIdScanReference", this.b.getMerchantScanReference());
        }
        if (!this.b.getMerchantReportingCriteria().equals("")) {
            jSONObject2.put("merchantReportingCriteria", this.b.getMerchantReportingCriteria());
        }
        jSONObject2.put("deviceDetail", jSONObject);
        String str = "requireVerification";
        boolean z = this.c.isVerificationAllowed() && this.b.requireVerification();
        jSONObject2.put(str, z);
        ArrayList arrayList = null;
        String visionStatus = LivenessClient.getVisionStatus(this.context);
        if (visionStatus != null) {
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("error", visionStatus);
            JumioAnalytics.add(MobileEvents.customAlert(JumioAnalytics.getSessionId(), "EyeTrackingGoogleVisionFailed", metaInfo));
        }
        if (!(this.c.getEnabledFields() == null || this.c.getEnabledFields().length() == 0)) {
            arrayList = new ArrayList(Arrays.asList(this.c.getEnabledFields().split(",")));
            if (!(JumioCameraManager.hasFrontFacingCamera(this.context) && visionStatus == null) && arrayList.contains("idFaceMatch")) {
                arrayList.remove("idFaceMatch");
            } else if (!this.b.isFaceMatchEnabled() && this.b.isFaceMatchSet()) {
                arrayList.remove("idFaceMatch");
            }
        }
        if (!this.b.getCustomerId().equals("")) {
            jSONObject2.put("customerId", this.b.getCustomerId());
        }
        if (!this.b.getCallbackUrl().equals("")) {
            jSONObject2.put("callbackUrl", this.b.getCallbackUrl());
        }
        if (!this.b.getAdditionalInformation().equals("")) {
            jSONObject2.put("additionalInformation", this.b.getAdditionalInformation());
        }
        if (!(arrayList == null || arrayList.size() == 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append((String) arrayList.get(i));
            }
            jSONObject2.put("enabledFields", stringBuilder.toString());
        }
        return jSONObject2.toString();
    }

    protected int networkErrorMock() {
        return a;
    }

    public boolean a(Throwable th, Context context) {
        CredentialsModel a = ((c) this.dynamicProvider).a();
        c cVar = (c) this.dynamicProvider;
        boolean z = a instanceof NetverifyCredentialsModel;
        boolean z2 = z && ((NetverifyCredentialsModel) a).shouldFinalize();
        boolean a2 = cVar.a(th, context, z2);
        if (a2 && z) {
            NetverifyCredentialsModel netverifyCredentialsModel = (NetverifyCredentialsModel) a;
            if (netverifyCredentialsModel.shouldFinalize()) {
                netverifyCredentialsModel.setOfflineSwitch(true);
                try {
                    NVBackend.forceRetry();
                } catch (Exception unused) {
                    return a2;
                }
            }
        }
    }
}
