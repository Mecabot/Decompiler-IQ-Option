package com.jumio.clientlib.impl.templatematcher;

public class StringVector {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected StringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(StringVector stringVector) {
        return stringVector == null ? 0 : stringVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_StringVector(this.a);
            }
            this.a = 0;
        }
    }

    public StringVector() {
        this(jniTemplateMatcherJNI.new_StringVector__SWIG_0(), true);
    }

    public StringVector(long j) {
        this(jniTemplateMatcherJNI.new_StringVector__SWIG_1(j), true);
    }

    public long size() {
        return jniTemplateMatcherJNI.StringVector_size(this.a, this);
    }

    public long capacity() {
        return jniTemplateMatcherJNI.StringVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        jniTemplateMatcherJNI.StringVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return jniTemplateMatcherJNI.StringVector_isEmpty(this.a, this);
    }

    public void clear() {
        jniTemplateMatcherJNI.StringVector_clear(this.a, this);
    }

    public void add(String str) {
        jniTemplateMatcherJNI.StringVector_add(this.a, this, str);
    }

    public String get(int i) {
        return jniTemplateMatcherJNI.StringVector_get(this.a, this, i);
    }

    public void set(int i, String str) {
        jniTemplateMatcherJNI.StringVector_set(this.a, this, i, str);
    }
}
