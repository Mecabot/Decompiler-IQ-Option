package com.jumio.clientlib.impl.templatematcher;

public class TemplatePolygon {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected TemplatePolygon(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(TemplatePolygon templatePolygon) {
        return templatePolygon == null ? 0 : templatePolygon.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_TemplatePolygon(this.a);
            }
            this.a = 0;
        }
    }

    public TemplatePolygon() {
        this(jniTemplateMatcherJNI.new_TemplatePolygon__SWIG_0(), true);
    }

    public TemplatePolygon(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this(jniTemplateMatcherJNI.new_TemplatePolygon__SWIG_1(f, f2, f3, f4, f5, f6, f7, f8), true);
    }

    public float getTLx() {
        return jniTemplateMatcherJNI.TemplatePolygon_getTLx(this.a, this);
    }

    public float getTLy() {
        return jniTemplateMatcherJNI.TemplatePolygon_getTLy(this.a, this);
    }

    public float getTRx() {
        return jniTemplateMatcherJNI.TemplatePolygon_getTRx(this.a, this);
    }

    public float getTRy() {
        return jniTemplateMatcherJNI.TemplatePolygon_getTRy(this.a, this);
    }

    public float getBRx() {
        return jniTemplateMatcherJNI.TemplatePolygon_getBRx(this.a, this);
    }

    public float getBRy() {
        return jniTemplateMatcherJNI.TemplatePolygon_getBRy(this.a, this);
    }

    public float getBLx() {
        return jniTemplateMatcherJNI.TemplatePolygon_getBLx(this.a, this);
    }

    public float getBLy() {
        return jniTemplateMatcherJNI.TemplatePolygon_getBLy(this.a, this);
    }

    public void setTLx(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setTLx(this.a, this, f);
    }

    public void setTLy(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setTLy(this.a, this, f);
    }

    public void setTRx(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setTRx(this.a, this, f);
    }

    public void setTRy(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setTRy(this.a, this, f);
    }

    public void setBRx(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setBRx(this.a, this, f);
    }

    public void setBRy(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setBRy(this.a, this, f);
    }

    public void setBLx(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setBLx(this.a, this, f);
    }

    public void setBLy(float f) {
        jniTemplateMatcherJNI.TemplatePolygon_setBLy(this.a, this, f);
    }
}
