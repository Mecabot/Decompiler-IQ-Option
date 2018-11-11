package com.jumio.clientlib.impl.templatematcher;

public class TemplateInfo {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected TemplateInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(TemplateInfo templateInfo) {
        return templateInfo == null ? 0 : templateInfo.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_TemplateInfo(this.a);
            }
            this.a = 0;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        jniTemplateMatcherJNI.TemplateInfo_change_ownership(this, this.a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniTemplateMatcherJNI.TemplateInfo_change_ownership(this, this.a, true);
    }

    public TemplateInfo() {
        this(jniTemplateMatcherJNI.new_TemplateInfo__SWIG_0(), true);
        jniTemplateMatcherJNI.TemplateInfo_director_connect(this, this.a, this.swigCMemOwn, true);
    }

    public TemplateInfo(int i, String str, String str2, String str3, String str4, TemplatePolygon templatePolygon, int i2, double d) {
        this(jniTemplateMatcherJNI.new_TemplateInfo__SWIG_1(i, str, str2, str3, str4, TemplatePolygon.getCPtr(templatePolygon), templatePolygon, i2, d), true);
        jniTemplateMatcherJNI.TemplateInfo_director_connect(this, this.a, this.swigCMemOwn, true);
    }

    public String getDocumentType() {
        return jniTemplateMatcherJNI.TemplateInfo_getDocumentType(this.a, this);
    }

    public void setDocumentType(String str) {
        jniTemplateMatcherJNI.TemplateInfo_setDocumentType(this.a, this, str);
    }

    public String getDocumentSubType() {
        return jniTemplateMatcherJNI.TemplateInfo_getDocumentSubType(this.a, this);
    }

    public void setDocumentSubType(String str) {
        jniTemplateMatcherJNI.TemplateInfo_setDocumentSubType(this.a, this, str);
    }

    public int getTrainImageIndex() {
        return jniTemplateMatcherJNI.TemplateInfo_getTrainImageIndex(this.a, this);
    }

    public void setTrainImageIndex(int i) {
        jniTemplateMatcherJNI.TemplateInfo_setTrainImageIndex(this.a, this, i);
    }

    public String getCountry() {
        return jniTemplateMatcherJNI.TemplateInfo_getCountry(this.a, this);
    }

    public void setCountry(String str) {
        jniTemplateMatcherJNI.TemplateInfo_setCountry(this.a, this, str);
    }

    public String getState() {
        return jniTemplateMatcherJNI.TemplateInfo_getState(this.a, this);
    }

    public void setState(String str) {
        jniTemplateMatcherJNI.TemplateInfo_setState(this.a, this, str);
    }

    public String getRegion() {
        return jniTemplateMatcherJNI.TemplateInfo_getRegion(this.a, this);
    }

    public void setRegion(String str) {
        jniTemplateMatcherJNI.TemplateInfo_setRegion(this.a, this, str);
    }

    public TemplatePolygon getPolygon() {
        return new TemplatePolygon(jniTemplateMatcherJNI.TemplateInfo_getPolygon(this.a, this), false);
    }

    public void setPolygon(TemplatePolygon templatePolygon) {
        jniTemplateMatcherJNI.TemplateInfo_setPolygon(this.a, this, TemplatePolygon.getCPtr(templatePolygon), templatePolygon);
    }

    public int getTemplateWidth() {
        return jniTemplateMatcherJNI.TemplateInfo_getTemplateWidth(this.a, this);
    }

    public void setTemplateWidth(int i) {
        jniTemplateMatcherJNI.TemplateInfo_setTemplateWidth(this.a, this, i);
    }

    public int getTemplateHeight() {
        return jniTemplateMatcherJNI.TemplateInfo_getTemplateHeight(this.a, this);
    }

    public void setTemplateHeight(int i) {
        jniTemplateMatcherJNI.TemplateInfo_setTemplateHeight(this.a, this, i);
    }

    public int getFrameIndex() {
        return jniTemplateMatcherJNI.TemplateInfo_getFrameIndex(this.a, this);
    }

    public void setFrameIndex(int i) {
        jniTemplateMatcherJNI.TemplateInfo_setFrameIndex(this.a, this, i);
    }

    public int getMatchesCount() {
        return jniTemplateMatcherJNI.TemplateInfo_getMatchesCount(this.a, this);
    }

    public void setMatchesCount(int i) {
        jniTemplateMatcherJNI.TemplateInfo_setMatchesCount(this.a, this, i);
    }

    public double getTransformError() {
        return jniTemplateMatcherJNI.TemplateInfo_getTransformError(this.a, this);
    }

    public void setTransformError(double d) {
        jniTemplateMatcherJNI.TemplateInfo_setTransformError(this.a, this, d);
    }

    public void setHomography(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        jniTemplateMatcherJNI.TemplateInfo_setHomography(this.a, this, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }
}
