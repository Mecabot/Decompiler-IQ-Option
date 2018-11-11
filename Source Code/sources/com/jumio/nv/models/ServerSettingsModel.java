package com.jumio.nv.models;

import android.support.annotation.Nullable;
import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.core.plugins.PluginRegistry;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.nv.IsoCountryConverter;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ServerSettingsModel")
public class ServerSettingsModel implements StaticModel {
    private String a;
    private boolean b = true;
    private String c;
    private boolean d = true;
    private CountryDocumentModel e = new CountryDocumentModel();
    private boolean f = false;
    private boolean g = false;
    private String h = null;
    private int i = 0;
    private byte[] j;
    private byte[] k;
    private int l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private boolean r;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:33:0x00f0, code:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:34:0x00f1, code:
            com.jumio.commons.log.Log.w("ServerSettingsModel", "JSONException ", r8);
     */
    public void parseJson(java.lang.String r8, @android.support.annotation.Nullable com.jumio.sdk.models.CredentialsModel r9) {
        /*
        r7 = this;
        r0 = 1;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f0 }
        r1.<init>(r8);	 Catch:{ JSONException -> 0x00f0 }
        r8 = "configurations";
        r8 = r1.optJSONObject(r8);	 Catch:{ JSONException -> 0x00f0 }
        r2 = 0;
        if (r8 == 0) goto L_0x008d;
    L_0x000f:
        r3 = "barcodeScannerKey";
        r3 = r8.optString(r3);	 Catch:{ JSONException -> 0x00f0 }
        r7.a = r3;	 Catch:{ JSONException -> 0x00f0 }
        r3 = 0;
        r4 = "cdnPublicKey";
        r4 = r8.optString(r4);	 Catch:{ Exception -> 0x0025 }
        r4 = android.util.Base64.decode(r4, r3);	 Catch:{ Exception -> 0x0025 }
        r7.j = r4;	 Catch:{ Exception -> 0x0025 }
        goto L_0x0027;
    L_0x0025:
        r7.j = r2;	 Catch:{ JSONException -> 0x00f0 }
    L_0x0027:
        r4 = new org.json.JSONArray;	 Catch:{ Exception -> 0x004c }
        r4.<init>();	 Catch:{ Exception -> 0x004c }
        r5 = "ID";
        r4.put(r5);	 Catch:{ Exception -> 0x004c }
        r5 = "TA";
        r4.put(r5);	 Catch:{ Exception -> 0x004c }
        r5 = "TP";
        r4.put(r5);	 Catch:{ Exception -> 0x004c }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x004c }
        r6 = "eMRTD";
        r6 = r8.optString(r6);	 Catch:{ Exception -> 0x004c }
        r5.<init>(r6);	 Catch:{ Exception -> 0x004c }
        r6 = "DEU";
        r5.put(r6, r4);	 Catch:{ Exception -> 0x004c }
        r2 = r5;
    L_0x004c:
        r4 = "eyeTrackingKey";
        r4 = r8.getInt(r4);	 Catch:{ Exception -> 0x0080 }
        r7.l = r4;	 Catch:{ Exception -> 0x0080 }
        r4 = "eyeTrackingThresholdMax";
        r4 = r8.getDouble(r4);	 Catch:{ Exception -> 0x0080 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0080 }
        r7.m = r4;	 Catch:{ Exception -> 0x0080 }
        r4 = "eyeTrackingEarlyThresholdMin";
        r4 = r8.getDouble(r4);	 Catch:{ Exception -> 0x0080 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0080 }
        r7.n = r4;	 Catch:{ Exception -> 0x0080 }
        r4 = "eyeTrackingEarlyThresholdMax";
        r4 = r8.getDouble(r4);	 Catch:{ Exception -> 0x0080 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0080 }
        r7.o = r4;	 Catch:{ Exception -> 0x0080 }
        r4 = "eyeTrackingPositionsMin";
        r4 = r8.getInt(r4);	 Catch:{ Exception -> 0x0080 }
        r7.p = r4;	 Catch:{ Exception -> 0x0080 }
        r4 = "eyeTrackingPositionsMax";
        r4 = r8.getInt(r4);	 Catch:{ Exception -> 0x0080 }
        r7.q = r4;	 Catch:{ Exception -> 0x0080 }
        goto L_0x0082;
    L_0x0080:
        r7.l = r3;	 Catch:{ JSONException -> 0x00f0 }
    L_0x0082:
        r4 = "eyeTrackingAnalyticsEnabled";
        r8 = r8.optInt(r4, r3);	 Catch:{ JSONException -> 0x00f0 }
        if (r8 != r0) goto L_0x008b;
    L_0x008a:
        r3 = 1;
    L_0x008b:
        r7.r = r3;	 Catch:{ JSONException -> 0x00f0 }
    L_0x008d:
        r8 = "brandingEnabled";
        r8 = r1.optBoolean(r8, r0);	 Catch:{ JSONException -> 0x00f0 }
        r7.b = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = "countryForIp";
        r8 = r1.optString(r8);	 Catch:{ JSONException -> 0x00f0 }
        r7.c = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = "analyticsEnabled";
        r8 = r1.optBoolean(r8, r0);	 Catch:{ JSONException -> 0x00f0 }
        r7.g = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = "enabledFields";
        r8 = r1.optString(r8);	 Catch:{ JSONException -> 0x00f0 }
        r7.h = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = "verificationAllowed";
        r8 = r1.optBoolean(r8, r0);	 Catch:{ JSONException -> 0x00f0 }
        r7.d = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = "maxLivenessImages";
        r3 = 10;
        r8 = r1.optInt(r8, r3);	 Catch:{ JSONException -> 0x00f0 }
        r7.i = r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = r7.i;	 Catch:{ JSONException -> 0x00f0 }
        if (r8 < 0) goto L_0x00c8;
    L_0x00c4:
        r8 = r7.i;	 Catch:{ JSONException -> 0x00f0 }
        if (r8 <= r3) goto L_0x00ca;
    L_0x00c8:
        r7.i = r3;	 Catch:{ JSONException -> 0x00f0 }
    L_0x00ca:
        r8 = "supportedCountries";
        r8 = r1.getJSONArray(r8);	 Catch:{ JSONException -> 0x00f0 }
        r7.a(r8, r2);	 Catch:{ JSONException -> 0x00f0 }
        if (r9 == 0) goto L_0x00f8;
    L_0x00d6:
        r8 = r9 instanceof com.jumio.nv.models.NetverifyCredentialsModel;	 Catch:{ JSONException -> 0x00f0 }
        if (r8 == 0) goto L_0x00f8;
    L_0x00da:
        r8 = r9;
        r8 = (com.jumio.nv.models.NetverifyCredentialsModel) r8;	 Catch:{ JSONException -> 0x00f0 }
        r8 = r8.getOfflineCredentialsModel();	 Catch:{ JSONException -> 0x00f0 }
        if (r8 == 0) goto L_0x00f8;
    L_0x00e3:
        r9 = (com.jumio.nv.models.NetverifyCredentialsModel) r9;	 Catch:{ JSONException -> 0x00f0 }
        r8 = r9.getOfflineCredentialsModel();	 Catch:{ JSONException -> 0x00f0 }
        r8 = r8.getStatusPublicKey();	 Catch:{ JSONException -> 0x00f0 }
        r7.k = r8;	 Catch:{ JSONException -> 0x00f0 }
        goto L_0x00f8;
    L_0x00f0:
        r8 = move-exception;
        r9 = "ServerSettingsModel";
        r1 = "JSONException ";
        com.jumio.commons.log.Log.w(r9, r1, r8);
    L_0x00f8:
        r7.f = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.models.ServerSettingsModel.parseJson(java.lang.String, com.jumio.sdk.models.CredentialsModel):void");
    }

    public void useOfflineToken(NetverifyOfflineCredentialsModel netverifyOfflineCredentialsModel) {
        this.j = null;
        this.a = netverifyOfflineCredentialsModel.getBarcodeLicense();
        this.b = netverifyOfflineCredentialsModel.isBranding();
        this.c = netverifyOfflineCredentialsModel.getPreferredCountry();
        this.g = false;
        this.h = netverifyOfflineCredentialsModel.getEnabledFields();
        this.d = netverifyOfflineCredentialsModel.isNetverifyable();
        this.i = 10;
        this.l = 0;
        this.k = netverifyOfflineCredentialsModel.getStatusPublicKey();
        try {
            a(new JSONArray(netverifyOfflineCredentialsModel.getSupportedCountries()), null);
        } catch (Throwable e) {
            Log.w("ServerSettingsModel", "JSONException ", e);
        }
        this.f = true;
    }

    private void a(JSONArray jSONArray, @Nullable JSONObject jSONObject) {
        String arrays = Arrays.toString(PluginRegistry.getAvailablePlugins().toArray());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Available plugins: ");
        stringBuilder.append(arrays);
        Log.d("NetverifySDK", stringBuilder.toString());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Country country = new Country(jSONObject2.getString("country"));
            if (!country.getName().equalsIgnoreCase(IsoCountryConverter.convertToAlpha2(jSONObject2.getString("country")))) {
                JSONArray optJSONArray = jSONObject2.optJSONArray("idTypes");
                List arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        DocumentType a = a(country, optJSONArray.getJSONObject(i2), jSONObject);
                        if (PluginRegistry.getPlugin(getScanPluginMode(a.getDocumentScanMode())) != null) {
                            arrayList.add(a);
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Skipping scan mode ");
                            stringBuilder2.append(a.getDocumentScanMode());
                            stringBuilder2.append(" because no plugin was found!");
                            Log.i("ServerSettingsModel", stringBuilder2.toString());
                        }
                    }
                } else {
                    DocumentType a2 = a(country, jSONObject2.getJSONObject("idTypes"), jSONObject);
                    if (PluginRegistry.getPlugin(getScanPluginMode(a2.getDocumentScanMode())) != null) {
                        arrayList.add(a2);
                    } else {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Skipping scan mode ");
                        stringBuilder3.append(a2.getDocumentScanMode());
                        stringBuilder3.append(" because no plugin was found!");
                        Log.i("ServerSettingsModel", stringBuilder3.toString());
                    }
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList);
                    this.e.add(country, (DocumentType[]) arrayList.toArray(new DocumentType[arrayList.size()]));
                }
            }
        }
    }

    public PluginMode getScanPluginMode(DocumentScanMode documentScanMode) {
        switch (documentScanMode) {
            case CREDIT:
                return PluginMode.CARD;
            case MRP:
            case MRV:
            case TD1:
            case TD2:
            case CNIS:
                return PluginMode.MRZ;
            case PDF417:
                PluginMode pluginMode = PluginMode.BARCODE;
                if (!PluginRegistry.hasPlugin(pluginMode) || this.a == null || this.a.length() == 0) {
                    return PluginMode.BARCODE_NATIVE;
                }
                return pluginMode;
            case TEMPLATEMATCHER:
                return PluginMode.TEMPLATE_MATCHER;
            case CSSN:
            case LINEFINDER:
                return PluginMode.LINE_FINDER;
            case FACE:
                return PluginMode.FACE;
            case MANUAL:
                return PluginMode.MANUAL;
            case NFC:
                return PluginMode.NFC;
            default:
                return null;
        }
    }

    private DocumentType a(Country country, JSONObject jSONObject, JSONObject jSONObject2) {
        int length;
        String[] strArr;
        DocumentType documentType;
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = jSONObject2;
        boolean optBoolean = jSONObject3.optBoolean("paperVariant", false);
        JSONArray optJSONArray = jSONObject3.optJSONArray("paperVariantParts");
        if (optBoolean) {
            if (optJSONArray != null) {
                length = optJSONArray.length();
            } else if (jSONObject3.optString("paperVariantParts", null) != null) {
                length = 1;
            }
            if (jSONObject4 == null && jSONObject4.has(country.getIsoCode())) {
                optJSONArray = jSONObject4.optJSONArray(country.getIsoCode());
                if (optJSONArray != null) {
                    String[] strArr2 = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        strArr2[i] = optJSONArray.getString(i);
                    }
                    strArr = strArr2;
                } else {
                    strArr = new String[]{jSONObject4.getString(country.getIsoCode())};
                }
            } else {
                strArr = null;
            }
            documentType = new DocumentType(jSONObject3.getString("idType"), jSONObject3.optInt("parts"), jSONObject3.optString("mrzFormat", ""), jSONObject3.optString("mrzSide", ""), jSONObject3.optString("barcodeFormat", ""), jSONObject3.optString("barcodeSide", ""), jSONObject3.optString("thirdPartyOcr", ""), optBoolean, length, strArr, jSONObject3.optString("masking", ""));
            if (!"FRA".equals(country.getIsoCode()) && documentType.getDocumentScanMode() == DocumentScanMode.TD2) {
                documentType.setDocumentScanMode(DocumentScanMode.CNIS);
            } else if ("DEU".equals(country.getIsoCode()) && documentType.getId() == NVDocumentType.IDENTITY_CARD) {
                documentType.setFallbackScan(false);
                documentType.setDocumentScanMode(DocumentScanMode.TD1);
                documentType.setDocumentScanSide(ScanSide.BACK);
                documentType.setPaperVariant(PluginRegistry.hasPlugin(PluginMode.MRZ));
                documentType.setPaperScanMode(DocumentScanMode.TD2);
                documentType.setPaperScanSide(ScanSide.FRONT);
                documentType.setPaperParts(2);
            }
            return documentType;
        }
        length = 0;
        if (jSONObject4 == null) {
        }
        strArr = null;
        documentType = new DocumentType(jSONObject3.getString("idType"), jSONObject3.optInt("parts"), jSONObject3.optString("mrzFormat", ""), jSONObject3.optString("mrzSide", ""), jSONObject3.optString("barcodeFormat", ""), jSONObject3.optString("barcodeSide", ""), jSONObject3.optString("thirdPartyOcr", ""), optBoolean, length, strArr, jSONObject3.optString("masking", ""));
        if (!"FRA".equals(country.getIsoCode())) {
        }
        documentType.setFallbackScan(false);
        documentType.setDocumentScanMode(DocumentScanMode.TD1);
        documentType.setDocumentScanSide(ScanSide.BACK);
        documentType.setPaperVariant(PluginRegistry.hasPlugin(PluginMode.MRZ));
        documentType.setPaperScanMode(DocumentScanMode.TD2);
        documentType.setPaperScanSide(ScanSide.FRONT);
        documentType.setPaperParts(2);
        return documentType;
    }

    public boolean isLoaded() {
        return this.f;
    }

    public String getBarcodeScannerKey() {
        return this.a;
    }

    public boolean isBrandingEnabled() {
        return this.b;
    }

    public String getCountryForIp() {
        return this.c;
    }

    public CountryDocumentModel getCountryModel() {
        return this.e;
    }

    public boolean isVerificationAllowed() {
        return this.d;
    }

    public boolean isAnalyticsEnabled() {
        return this.g;
    }

    public String getEnabledFields() {
        return this.h;
    }

    public int getMaxLivenessImages() {
        return this.i;
    }

    public byte[] getStatusPublicKey() {
        return this.k;
    }

    public byte[] getCdnPublicKey() {
        return this.j;
    }

    public boolean isCdnUsable() {
        return (this.j == null || this.j.length == 0) ? false : true;
    }

    public int getEyeTrackingKey() {
        return this.l;
    }

    public float getEyeTrackingThresholdMax() {
        return this.m;
    }

    public float getEyeTrackingEarlyThresholdMin() {
        return this.n;
    }

    public float getEyeTrackingEarlyThresholdMax() {
        return this.o;
    }

    public int getEyeTrackingPositionsMin() {
        return this.p;
    }

    public int getEyeTrackingPositionsMax() {
        return this.q;
    }

    public boolean isEyeTrackingAnalyticsEnabled() {
        return this.r;
    }
}
