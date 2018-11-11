package com.jumio.dv.api.calls;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.core.network.PreconditionNotSatisfiedException;
import com.jumio.core.network.multipart.MultipartApiCall;
import com.jumio.dv.models.DvSettingsModel;
import com.jumio.persistence.DataAccess;
import org.json.JSONObject;

/* compiled from: CompleteCall */
public class a extends MultipartApiCall<String> {
    private byte[] a;

    public a(Context context, DynamicProvider dynamicProvider, ImageData imageData, Subscriber<String> subscriber) {
        super(context, dynamicProvider, subscriber);
        this.a = imageData.getImageData();
    }

    @Nullable
    /* renamed from: a */
    public String execute() {
        if (this.a != null) {
            return (String) super.execute();
        }
        throw new PreconditionNotSatisfiedException("image data cannot be null!");
    }

    public String getUri() {
        return StringObfuscater.format(new byte[]{(byte) -122, (byte) -29, (byte) -111, (byte) -90, (byte) -5, (byte) 76, (byte) 28, (byte) -127}, 5325261152337364777L);
    }

    protected void responseReceived(int i, String str, long j, String str2) {
        super.responseReceived(i, str, j, str2);
    }

    /* renamed from: a */
    protected String parseResponse(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (Log.isFileLoggingActivated()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DV_");
                    stringBuilder.append(jSONObject.getString("scanReference"));
                    LogUtils.setSesssionLogFolderName(stringBuilder.toString());
                }
                return jSONObject.getString("scanReference");
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
        return null;
    }

    protected void prepareData() {
        DvSettingsModel dvSettingsModel = (DvSettingsModel) DataAccess.load(this.context, DvSettingsModel.class);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TYPE, dvSettingsModel.getType());
        if ("CUSTOM".equals(dvSettingsModel.getType().toUpperCase())) {
            jSONObject.put("customDocumentCode", dvSettingsModel.getCustomDocumentCode());
        }
        jSONObject.put("country", dvSettingsModel.getCountry());
        jSONObject.put("merchantScanReference", dvSettingsModel.getMerchantScanReference());
        jSONObject.put("customerId", dvSettingsModel.getCustomerId());
        if (!"".equals(dvSettingsModel.getAdditionalInformation())) {
            jSONObject.put("additionalInformation", dvSettingsModel.getAdditionalInformation());
        }
        if (!"".equals(dvSettingsModel.getMerchantReportingCriteria())) {
            jSONObject.put("merchantReportingCriteria", dvSettingsModel.getMerchantReportingCriteria());
        }
        if (!"".equals(dvSettingsModel.getCallbackUrl())) {
            jSONObject.put("callbackUrl", dvSettingsModel.getCallbackUrl());
        }
        String jSONObject2 = jSONObject.toString();
        String[] strArr = new String[3];
        strArr[0] = "Content-Disposition: form-data; name=\"metadata\"";
        strArr[1] = "Content-Type: application/json; charset=UTF-8";
        strArr[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(jSONObject2.length())});
        addPart(strArr, jSONObject2);
        String[] strArr2 = new String[3];
        strArr2[0] = "Content-Disposition: form-data; name=\"image\"; filename=\"image.jpg\"";
        strArr2[1] = "Content-Type: image/jpg";
        strArr2[2] = String.format("Content-Length: %d", new Object[]{Integer.valueOf(this.a.length)});
        addPart(strArr2, this.a);
    }
}
