package com.jumio.nv.models;

import com.jumio.alejwt.swig.JWT;
import com.jumio.sdk.models.OfflineCredentialsModel;

public class NetverifyOfflineCredentialsModel extends OfflineCredentialsModel {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e = false;
    private byte[] f;

    protected void configureJWT(JWT jwt) {
        jwt.useGzip(true);
    }

    /* JADX WARNING: Missing block: B:9:?, code:
            return;
     */
    protected void parseJson(org.json.JSONObject r4) {
        /*
        r3 = this;
        r0 = "supportedCountries";
        r0 = r4.getString(r0);	 Catch:{ JSONException -> 0x003c }
        r3.b = r0;	 Catch:{ JSONException -> 0x003c }
        r0 = "enabledFields";
        r1 = 0;
        r0 = r4.optString(r0, r1);	 Catch:{ JSONException -> 0x003c }
        r3.c = r0;	 Catch:{ JSONException -> 0x003c }
        r0 = "product";
        r2 = "Fastfill";
        r0 = r4.optString(r0, r2);	 Catch:{ JSONException -> 0x003c }
        r2 = "Netverify";
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ JSONException -> 0x003c }
        r3.e = r0;	 Catch:{ JSONException -> 0x003c }
        r0 = "android-barcode";
        r0 = r4.optString(r0, r1);	 Catch:{ JSONException -> 0x003c }
        r3.d = r0;	 Catch:{ JSONException -> 0x003c }
        r0 = "status-pin";
        r4 = r4.optString(r0);	 Catch:{ Exception -> 0x0039 }
        r0 = 0;
        r4 = android.util.Base64.decode(r4, r0);	 Catch:{ Exception -> 0x0039 }
        r3.f = r4;	 Catch:{ Exception -> 0x0039 }
        goto L_0x003b;
    L_0x0039:
        r3.f = r1;	 Catch:{ JSONException -> 0x003c }
    L_0x003b:
        return;
    L_0x003c:
        r4 = new com.jumio.core.exceptions.PlatformNotSupportedException;
        r0 = "Token not valid";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.models.NetverifyOfflineCredentialsModel.parseJson(org.json.JSONObject):void");
    }

    public String getPreferredCountry() {
        return this.a;
    }

    public void setPreferredCountry(String str) {
        this.a = str;
    }

    public String getSupportedCountries() {
        return this.b;
    }

    public boolean isNetverifyable() {
        return this.e;
    }

    public byte[] getStatusPublicKey() {
        return this.f;
    }

    public String getEnabledFields() {
        return this.c;
    }

    public String getBarcodeLicense() {
        return this.d;
    }
}
