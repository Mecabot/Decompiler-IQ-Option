package com.jumio.clientlib.impl.templatematcher;

public class FrameProcessingSettingsTemplateMatcher {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected FrameProcessingSettingsTemplateMatcher(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher) {
        return frameProcessingSettingsTemplateMatcher == null ? 0 : frameProcessingSettingsTemplateMatcher.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_FrameProcessingSettingsTemplateMatcher(this.a);
            }
            this.a = 0;
        }
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean z, HierarchicalClusteringSettings hierarchicalClusteringSettings, int i2, int i3) {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_0(i, z, HierarchicalClusteringSettings.getCPtr(hierarchicalClusteringSettings), hierarchicalClusteringSettings, i2, i3), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean z, HierarchicalClusteringSettings hierarchicalClusteringSettings, int i2) {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_1(i, z, HierarchicalClusteringSettings.getCPtr(hierarchicalClusteringSettings), hierarchicalClusteringSettings, i2), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean z, HierarchicalClusteringSettings hierarchicalClusteringSettings) {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_2(i, z, HierarchicalClusteringSettings.getCPtr(hierarchicalClusteringSettings), hierarchicalClusteringSettings), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean z) {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_3(i, z), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i) {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_4(i), true);
    }

    public FrameProcessingSettingsTemplateMatcher() {
        this(jniTemplateMatcherJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_5(), true);
    }

    public int getMaxKeyPointsToDetect() {
        return jniTemplateMatcherJNI.FrameProcessingSettingsTemplateMatcher_getMaxKeyPointsToDetect(this.a, this);
    }

    public boolean getUseClustring() {
        return jniTemplateMatcherJNI.FrameProcessingSettingsTemplateMatcher_getUseClustring(this.a, this);
    }

    public HierarchicalClusteringSettings getClusteringSettings() {
        return new HierarchicalClusteringSettings(jniTemplateMatcherJNI.FrameProcessingSettingsTemplateMatcher_getClusteringSettings(this.a, this), false);
    }

    public int getNumSuccessMatchesToComplete() {
        return jniTemplateMatcherJNI.FrameProcessingSettingsTemplateMatcher_getNumSuccessMatchesToComplete(this.a, this);
    }

    public int getNumImagesToKeep() {
        return jniTemplateMatcherJNI.FrameProcessingSettingsTemplateMatcher_getNumImagesToKeep(this.a, this);
    }
}
