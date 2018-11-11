package com.jumio.clientlib.impl.templatematcher;

public class HierarchicalClusteringSettings {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected HierarchicalClusteringSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(HierarchicalClusteringSettings hierarchicalClusteringSettings) {
        return hierarchicalClusteringSettings == null ? 0 : hierarchicalClusteringSettings.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_HierarchicalClusteringSettings(this.a);
            }
            this.a = 0;
        }
    }

    public HierarchicalClusteringSettings(int i, int i2, int i3, int i4) {
        this(jniTemplateMatcherJNI.new_HierarchicalClusteringSettings__SWIG_0(i, i2, i3, i4), true);
    }

    public HierarchicalClusteringSettings(int i, int i2, int i3) {
        this(jniTemplateMatcherJNI.new_HierarchicalClusteringSettings__SWIG_1(i, i2, i3), true);
    }

    public HierarchicalClusteringSettings(int i, int i2) {
        this(jniTemplateMatcherJNI.new_HierarchicalClusteringSettings__SWIG_2(i, i2), true);
    }

    public HierarchicalClusteringSettings(int i) {
        this(jniTemplateMatcherJNI.new_HierarchicalClusteringSettings__SWIG_3(i), true);
    }

    public HierarchicalClusteringSettings() {
        this(jniTemplateMatcherJNI.new_HierarchicalClusteringSettings__SWIG_4(), true);
    }

    public int getBranching() {
        return jniTemplateMatcherJNI.HierarchicalClusteringSettings_getBranching(this.a, this);
    }

    public int getTrees() {
        return jniTemplateMatcherJNI.HierarchicalClusteringSettings_getTrees(this.a, this);
    }

    public int getLeafMaxSize() {
        return jniTemplateMatcherJNI.HierarchicalClusteringSettings_getLeafMaxSize(this.a, this);
    }

    public int getMaxChecks() {
        return jniTemplateMatcherJNI.HierarchicalClusteringSettings_getMaxChecks(this.a, this);
    }
}
