package com.jumio.clientlib.impl.templatematcher;

public class FramesVector {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected FramesVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(FramesVector framesVector) {
        return framesVector == null ? 0 : framesVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_FramesVector(this.a);
            }
            this.a = 0;
        }
    }

    public FramesVector() {
        this(jniTemplateMatcherJNI.new_FramesVector__SWIG_0(), true);
    }

    public FramesVector(long j) {
        this(jniTemplateMatcherJNI.new_FramesVector__SWIG_1(j), true);
    }

    public long size() {
        return jniTemplateMatcherJNI.FramesVector_size(this.a, this);
    }

    public long capacity() {
        return jniTemplateMatcherJNI.FramesVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        jniTemplateMatcherJNI.FramesVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return jniTemplateMatcherJNI.FramesVector_isEmpty(this.a, this);
    }

    public void clear() {
        jniTemplateMatcherJNI.FramesVector_clear(this.a, this);
    }

    public void add(LibImage libImage) {
        jniTemplateMatcherJNI.FramesVector_add(this.a, this, LibImage.getCPtr(libImage), libImage);
    }

    public LibImage get(int i) {
        long FramesVector_get = jniTemplateMatcherJNI.FramesVector_get(this.a, this, i);
        if (FramesVector_get == 0) {
            return null;
        }
        return new LibImage(FramesVector_get, true);
    }

    public void set(int i, LibImage libImage) {
        jniTemplateMatcherJNI.FramesVector_set(this.a, this, i, LibImage.getCPtr(libImage), libImage);
    }
}
