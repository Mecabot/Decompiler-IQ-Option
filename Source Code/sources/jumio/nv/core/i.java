package jumio.nv.core;

import android.content.Context;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.multipart.MultipartApiCall;
import com.jumio.nv.models.InitiateModel;
import com.jumio.persistence.DataAccess;
import java.io.IOException;

/* compiled from: LivenessCall */
public class i extends MultipartApiCall<Void> {
    private String a = null;
    private String[] b;

    /* renamed from: a */
    protected Void parseResponse(String str) {
        return null;
    }

    public i(Context context, DynamicProvider dynamicProvider, String[] strArr, Subscriber<Void> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.b = strArr;
    }

    public String getUri() {
        String str = "LIVENESS";
        if (this.a == null) {
            InitiateModel initiateModel = (InitiateModel) DataAccess.load(this.context, InitiateModel.class);
            if (initiateModel == null) {
                throw new IllegalStateException("SelectionModel cannot be null!");
            }
            this.a = initiateModel.getJumioScanRef();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -15, (byte) 42, (byte) 43, (byte) 27, (byte) 67, (byte) 85}, 983068124891981253L));
        stringBuilder.append(this.a);
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -40, (byte) -15, (byte) -72, (byte) -59, (byte) -38, (byte) 20, (byte) -54, (byte) 48}, -3512380628637652580L));
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public Void execute() {
        try {
            super.execute();
        } catch (Exception unused) {
            Log.i(this.TAG, "<- call(failed) - mark it as success anyways");
        }
        return null;
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
        JumioAnalytics.add(MobileEvents.networkRequest(JumioAnalytics.getSessionId(), getClass().getName(), i, str, j));
    }

    protected void prepareData() {
        int i = 0;
        while (i < this.b.length) {
            try {
                Object readFile = FileUtil.readFile(this.b[i]);
                r4 = new String[3];
                r4[0] = String.format("Content-Disposition: form-data; name=\"%s_%d\"; filename=\"%s_%d.jpg\"", new Object[]{this.a, Integer.valueOf(i), this.a, Integer.valueOf(i)});
                r4[1] = "Content-Type: image/webp";
                r4[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(readFile.length)});
                addPart(r4, readFile);
            } catch (IOException unused) {
                i++;
            }
        }
    }
}
