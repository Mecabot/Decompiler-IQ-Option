package jumio.nv.core;

import android.content.Context;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.SimpleApiCall;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.data.document.NVMRZFormat;
import com.jumio.nv.liveness.extraction.LivenessDataModel;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.persistence.DataAccess;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataCall */
public class e extends SimpleApiCall<Void> {
    private static int a;
    private SelectionModel b = null;
    private InitiateModel c = null;

    /* renamed from: a */
    protected Void parseResponse(String str) {
        return null;
    }

    public e(Context context, DynamicProvider dynamicProvider, Subscriber<Void> subscriber) {
        super(context, dynamicProvider, subscriber);
    }

    public String getUri() {
        if (this.c == null) {
            this.c = (InitiateModel) DataAccess.load(this.context, InitiateModel.class);
        }
        if (this.c == null) {
            throw new IllegalStateException("InitiateModel cannot be null!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) 48, (byte) 93, (byte) 92, (byte) 2, (byte) -8, (byte) 57}, -7687084684853639532L));
        stringBuilder.append(this.c.getJumioScanRef());
        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -74, (byte) 83, (byte) 66, (byte) 26, (byte) -72}, -7668719030812587582L));
        return stringBuilder.toString();
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
        JumioAnalytics.add(MobileEvents.networkRequest(JumioAnalytics.getSessionId(), getClass().getName(), i, str, j));
    }

    protected String getRequest() {
        if (this.b == null) {
            this.b = (SelectionModel) DataAccess.load(this.context, SelectionModel.class);
        }
        if (this.b == null) {
            throw new IllegalStateException("SelectionModel cannot be null!");
        }
        List scanModes = this.b.getUploadModel().getScanModes();
        DocumentDataModel documentData = this.b.getUploadModel().getDocumentData();
        if (documentData == null) {
            publishError(new IllegalArgumentException("DataCall: documentData cannot be null!"));
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        JSONObject jSONObject = new JSONObject();
        if (scanModes.contains(DocumentScanMode.MRP)) {
            a(jSONObject, "mrzFormat", DocumentType.MRZ_FORMAT_MRP);
        }
        if (scanModes.contains(DocumentScanMode.MRV)) {
            a(jSONObject, "mrzFormat", documentData.getMrzData().getFormat() == NVMRZFormat.MRV_A ? DocumentType.MRZ_FORMAT_MRV_A : DocumentType.MRZ_FORMAT_MRV_B);
        }
        if (scanModes.contains(DocumentScanMode.TD1)) {
            a(jSONObject, "mrzFormat", DocumentType.MRZ_FORMAT_TD1);
        }
        if (scanModes.contains(DocumentScanMode.TD2)) {
            a(jSONObject, "mrzFormat", DocumentType.MRZ_FORMAT_TD2);
        }
        if (scanModes.contains(DocumentScanMode.CNIS)) {
            a(jSONObject, "mrzFormat", DocumentType.MRZ_FORMAT_CNIS);
        }
        if (scanModes.contains(DocumentScanMode.CSSN) || scanModes.contains(DocumentScanMode.TEMPLATEMATCHER)) {
            a(jSONObject, "thirdPartyOcr", this.b.getSelectedDoctype().getThirdPartyOcr());
        }
        if (scanModes.contains(DocumentScanMode.PDF417)) {
            a(jSONObject, "barcodeFormat", DocumentType.BARCODE_FORMAT_PDF417);
        }
        NVDocumentType id = this.b.getSelectedDoctype().getId();
        NVDocumentVariant selectedVariant = this.b.getSelectedVariant();
        a(jSONObject, "idType", id.toString());
        a(jSONObject, "documentVariant", selectedVariant.toString());
        String issuingCountry = documentData.getIssuingCountry();
        String str = "issuingCountry";
        if (issuingCountry == null || issuingCountry.length() == 0) {
            issuingCountry = this.b.getSelectedCountry().getIsoCode();
        }
        a(jSONObject, str, issuingCountry);
        if (this.b.isVerificationRequired()) {
            documentData.fillRequest(jSONObject, simpleDateFormat, this.b, this.b.getUploadModel());
            LivenessDataModel livenessDataModel = (LivenessDataModel) DataAccess.load(this.context, LivenessDataModel.class);
            if (livenessDataModel != null) {
                a(jSONObject, "livenessResult", String.valueOf(livenessDataModel.getLivenessResult()));
                a(jSONObject, "livenessValue", String.valueOf(livenessDataModel.getLivenessValue()));
                if (livenessDataModel.getEyetrackingData() != null) {
                    try {
                        jSONObject.put("eyeTrackingData", new JSONObject(livenessDataModel.getEyetrackingData()));
                    } catch (JSONException unused) {
                        return jSONObject.toString();
                    }
                }
            }
        }
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            jSONObject.put(str, str2);
        }
    }

    protected int networkErrorMock() {
        return a;
    }
}
