package com.jumio.nv.models;

import android.app.Activity;
import android.graphics.Bitmap.CompressFormat;
import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import java.util.ArrayList;

@PersistWith("MerchantSettingsModel")
public class MerchantSettingsModel implements StaticModel {
    private NVDocumentVariant a;
    private String b = "";
    private String c = "";
    private boolean d;
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private boolean i = false;
    private transient Activity j;
    private boolean k;
    private NVDocumentType l;
    private ArrayList<NVDocumentType> m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t = false;
    private String u;
    private CompressFormat v;
    private int w;

    public boolean isFaceMatchEnabled() {
        return this.o;
    }

    public void setFaceMatchEnabled(boolean z) {
        this.o = z;
    }

    public boolean isFaceMatchSet() {
        return this.p;
    }

    public void setFaceMatchSet(boolean z) {
        this.p = z;
    }

    public String getMerchantScanReference() {
        return this.b;
    }

    public void setMerchantScanReference(String str) {
        this.b = str;
    }

    public String getMerchantReportingCriteria() {
        return this.c;
    }

    public void setMerchantReportingCriteria(String str) {
        this.c = str;
    }

    public boolean requireVerification() {
        return this.d;
    }

    public String getCustomerId() {
        return this.e;
    }

    public void setCustomerId(String str) {
        this.e = str;
    }

    public String getCallbackUrl() {
        return this.f;
    }

    public void setCallbackUrl(String str) {
        this.f = str;
    }

    public String getIsoCode() {
        return this.g;
    }

    public void setCountryIsoCode(String str) {
        this.g = str;
    }

    public NVDocumentVariant getDocumentVariant() {
        return this.a;
    }

    public void setDocumentVariant(NVDocumentVariant nVDocumentVariant) {
        this.a = nVDocumentVariant;
    }

    public void setRequireVerification(boolean z) {
        this.d = z;
    }

    public boolean isCameraFrontfacing() {
        return this.i;
    }

    public void setCameraFacingFront(boolean z) {
        this.i = z;
    }

    public Activity getContext() {
        return this.j;
    }

    public void setContext(Activity activity) {
        this.j = activity;
    }

    public void setCountryPreSelected(boolean z) {
        this.k = z;
    }

    public boolean isCountryPreSelected() {
        return this.k;
    }

    public NVDocumentType getDocumentTypeId() {
        return this.l;
    }

    public void setPreSelectedDocumentType(NVDocumentType nVDocumentType) {
        this.l = nVDocumentType;
    }

    public ArrayList<NVDocumentType> getSupportedDocumentTypes() {
        return this.m;
    }

    public void setSupportedDocumentTypes(ArrayList<NVDocumentType> arrayList) {
        this.m = arrayList;
    }

    public void setDocumentVariantPreSelected(boolean z) {
        this.n = z;
    }

    public boolean isDocumentVariantPreSelected() {
        return this.n;
    }

    public void setDataExtractionOnMobileOnly(boolean z) {
        this.q = z;
    }

    public boolean isDataExtractionOnMobileOnly() {
        return this.q;
    }

    public void setEnableEMRTD(boolean z) {
        this.r = z;
    }

    public boolean isEnableEMRTD() {
        return this.r;
    }

    public void setSendDebugInfo(boolean z) {
        this.s = z;
    }

    public boolean isSendDebugInfo() {
        return this.s;
    }

    public String getAdditionalInformation() {
        return this.h;
    }

    public void setAdditionalInformation(String str) {
        this.h = str;
    }

    public boolean hasWaitedForInitialize() {
        return this.t;
    }

    public void setWaitedForInitialize(boolean z) {
        this.t = z;
    }

    public String getOutputDirectory() {
        return this.u;
    }

    public void setOutputDirectory(String str) {
        this.u = str;
    }

    public CompressFormat getOutputFormat() {
        return this.v;
    }

    public void setOutputFormat(CompressFormat compressFormat) {
        this.v = compressFormat;
    }

    public int getOutputLevel() {
        return this.w;
    }

    public void setOutputLevel(int i) {
        this.w = i;
    }
}
