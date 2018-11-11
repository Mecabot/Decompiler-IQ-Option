package jumio.nv.core;

import android.content.Context;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.SimpleApiCall;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NetverifyCredentialsModel;
import com.jumio.nv.models.NetverifyOfflineCredentialsModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.sdk.models.CredentialsModel;
import java.util.Iterator;
import java.util.UUID;
import jumio.nv.core.j.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingsCall */
public class k extends SimpleApiCall<ServerSettingsModel> implements a {
    private static int a;
    private MerchantSettingsModel b;
    private CredentialsModel c;

    public k(Context context, c cVar, CredentialsModel credentialsModel, MerchantSettingsModel merchantSettingsModel, Subscriber<ServerSettingsModel> subscriber) {
        super(context, cVar, subscriber);
        ApiCall.setTrackingId(UUID.randomUUID().toString());
        this.b = merchantSettingsModel;
        this.c = credentialsModel;
    }

    /* renamed from: a */
    protected ServerSettingsModel offlineResponse() {
        try {
            ((NetverifyOfflineCredentialsModel) this.c).verify(this.context);
            ServerSettingsModel serverSettingsModel = new ServerSettingsModel();
            serverSettingsModel.useOfflineToken((NetverifyOfflineCredentialsModel) this.c);
            publishResult(serverSettingsModel);
            return serverSettingsModel;
        } catch (Throwable e) {
            publishError(e);
            return null;
        }
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
        JumioAnalytics.add(MobileEvents.networkRequest(JumioAnalytics.getSessionId(), getClass().getName(), i, str, j));
    }

    /* renamed from: a */
    protected ServerSettingsModel parseResponse(String str) {
        try {
            ServerSettingsModel serverSettingsModel = new ServerSettingsModel();
            serverSettingsModel.parseJson(str, ((c) this.dynamicProvider).a());
            return serverSettingsModel;
        } catch (Throwable e) {
            Log.w(this.TAG, "Exception", e);
            return null;
        }
    }

    protected String getRequest() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.b.getSupportedDocumentTypes().iterator();
        while (it.hasNext()) {
            jSONArray.put(((NVDocumentType) it.next()).toString());
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put("cdnPublicKey");
        jSONArray2.put("barcodeScanner");
        jSONArray2.put("eMRTD");
        jSONArray2.put("eyeTracking");
        jSONArray2.put("eyeTrackingAnalytics");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idTypes", jSONArray);
        jSONObject.put("features", jSONArray2);
        return jSONObject.toString();
    }

    public String getUri() {
        return StringObfuscater.format(new byte[]{(byte) -22, (byte) -121, (byte) -25, (byte) 65, (byte) 43, (byte) 57, (byte) 98, (byte) -73}, -3991709031461092330L);
    }

    public boolean a(Throwable th, Context context) {
        boolean a = ((c) this.dynamicProvider).a(th, context, true);
        if (a) {
            this.c = ((NetverifyCredentialsModel) this.c).getOfflineCredentialsModel();
            offlineResponse();
        }
        return a;
    }

    protected int networkErrorMock() {
        return a;
    }
}
