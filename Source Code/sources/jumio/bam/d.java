package jumio.bam;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.SimpleApiCall;
import java.util.UUID;

/* compiled from: InitiateCall */
class d extends SimpleApiCall<w> {
    private x a;

    public String getUri() {
        return "";
    }

    public d(Context context, DynamicProvider dynamicProvider, x xVar, Subscriber<w> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.a = xVar;
        setTimeout(5000);
        ApiCall.setTrackingId(UUID.randomUUID().toString());
    }

    /* renamed from: a */
    protected w parseResponse(String str) {
        try {
            w wVar = new w();
            wVar.a(str);
            if (Log.isFileLoggingActivated()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("BAM_");
                stringBuilder.append(wVar.a());
                LogUtils.setSesssionLogFolderName(stringBuilder.toString());
            }
            return wVar;
        } catch (Throwable e) {
            Log.w(this.TAG, "Exception", e);
            return null;
        }
    }

    protected String getRequest() {
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        JumioJSONObject jumioJSONObject2 = new JumioJSONObject();
        jumioJSONObject2.put("sdk-platform", "Android");
        jumioJSONObject2.put("sdk-version", "JMSDK 2.10.0 (0-63)");
        jumioJSONObject2.put("manufacturer", Build.MANUFACTURER);
        jumioJSONObject2.put("model", Build.MODEL);
        jumioJSONObject2.put("software-version", VERSION.RELEASE);
        jumioJSONObject2.put("software-build-number", Build.DISPLAY);
        jumioJSONObject2.put("kernel-version", System.getProperty("os.version"));
        jumioJSONObject.put("mobileDeviceDetail", jumioJSONObject2);
        jumioJSONObject.put("merchantReportingCriteria", this.a.k());
        jumioJSONObject.put("dataTransferEnabledSupported", true);
        return jumioJSONObject.toString();
    }
}
