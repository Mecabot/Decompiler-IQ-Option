package com.microblink.secured;

import com.microblink.secured.a.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: line */
public final class u {
    String dXa;
    String dXb;
    a dXc;
    public a dXd;
    a dXe;
    public a dXf;
    public int dXg = -1;
    double dXh = 0.0d;
    double dXi = 1.0d;
    public double dXj = 1.0d;
    h dXk;
    public h dXl;
    public h dXm;
    h dXn;
    h dXo;
    public h dXp;
    public h dXq;
    public h dXr;
    public h dXs;

    public u(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.dXa = str;
        this.dXb = str2;
    }

    public u(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        String[] split = str.split("::");
        this.dXb = split[1];
        this.dXa = split[0];
        if (jSONObject.has("backFacingPreviewSize")) {
            jSONArray = jSONObject.getJSONArray("backFacingPreviewSize");
            this.dXc = new a(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("backFacingPictureSize")) {
            jSONArray = jSONObject.getJSONArray("backFacingPictureSize");
            this.dXd = new a(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPreviewSize")) {
            jSONArray = jSONObject.getJSONArray("frontFacingPreviewSize");
            this.dXe = new a(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPictureSize")) {
            jSONArray = jSONObject.getJSONArray("frontFacingPictureSize");
            this.dXf = new a(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("cameraInitDelayMs")) {
            this.dXg = jSONObject.getInt("cameraInitDelayMs");
        }
        if (jSONObject.has("minZoomLevel")) {
            this.dXh = jSONObject.getDouble("minZoomLevel");
        }
        if (jSONObject.has("maxZoomLevel")) {
            this.dXi = jSONObject.getDouble("maxZoomLevel");
        }
        if (jSONObject.has("blacklisted")) {
            this.dXk = new h(jSONObject.getString("blacklisted"));
        }
        if (jSONObject.has("displayOrientationNotWorking")) {
            this.dXl = new h(jSONObject.getString("displayOrientationNotWorking"));
        }
        if (jSONObject.has("naturalOrientationIsLandscapeLeft")) {
            this.dXm = new h(jSONObject.getString("naturalOrientationIsLandscapeLeft"));
        }
        if (jSONObject.has("focusUntrusty")) {
            this.dXn = new h(jSONObject.getString("focusUntrusty"));
        }
        if (jSONObject.has("meteringNotWorking")) {
            this.dXo = new h(jSONObject.getString("meteringNotWorking"));
        }
        if (jSONObject.has("zeroCopyBufferAllowed")) {
            this.dXp = new h(jSONObject.getString("zeroCopyBufferAllowed"));
        }
        if (jSONObject.has("eglPbufferNotSupported")) {
            this.dXq = new h(jSONObject.getString("eglPbufferNotSupported"));
        }
        if (jSONObject.has("frameQualityFactor")) {
            this.dXj = jSONObject.getDouble("frameQualityFactor");
        }
        if (jSONObject.has("phaseAutoFocusSupported")) {
            this.dXr = new h(jSONObject.getString("phaseAutoFocusSupported"));
        }
        if (jSONObject.has("forceUseLegacyCamera")) {
            this.dXs = new h(jSONObject.getString("forceUseLegacyCamera"));
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DeviceInfo{mDevice='");
        stringBuilder.append(this.dXa);
        stringBuilder.append('\'');
        stringBuilder.append(", mModel='");
        stringBuilder.append(this.dXb);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
