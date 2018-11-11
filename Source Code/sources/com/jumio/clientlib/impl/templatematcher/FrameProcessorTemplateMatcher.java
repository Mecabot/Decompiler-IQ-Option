package com.jumio.clientlib.impl.templatematcher;

public class FrameProcessorTemplateMatcher extends FrameProcessor {
    private transient long a;
    private transient boolean b;

    protected FrameProcessorTemplateMatcher(long j, boolean z) {
        super(jniTemplateMatcherJNI.FrameProcessorTemplateMatcher_SWIGSmartPtrUpcast(j), true);
        this.b = z;
        this.a = j;
    }

    protected static long getCPtr(FrameProcessorTemplateMatcher frameProcessorTemplateMatcher) {
        return frameProcessorTemplateMatcher == null ? 0 : frameProcessorTemplateMatcher.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.b) {
                this.b = false;
                jniTemplateMatcherJNI.delete_FrameProcessorTemplateMatcher(this.a);
            }
            this.a = 0;
        }
        super.delete();
    }

    public FrameProcessorTemplateMatcher(FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher, FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher) {
        this(jniTemplateMatcherJNI.new_FrameProcessorTemplateMatcher(FrameProcessingSettingsTemplateMatcher.getCPtr(frameProcessingSettingsTemplateMatcher), frameProcessingSettingsTemplateMatcher, FrameProcessingCallbackTemplateMatcher.getCPtr(frameProcessingCallbackTemplateMatcher), frameProcessingCallbackTemplateMatcher), true);
    }

    public boolean addTemplatesFromBinaryFile(String str) {
        return jniTemplateMatcherJNI.FrameProcessorTemplateMatcher_addTemplatesFromBinaryFile(this.a, this, str);
    }

    public void clearAllTemplates() {
        jniTemplateMatcherJNI.FrameProcessorTemplateMatcher_clearAllTemplates(this.a, this);
    }

    public void discardFrameByID(int i) {
        jniTemplateMatcherJNI.FrameProcessorTemplateMatcher_discardFrameByID(this.a, this, i);
    }

    public boolean detectSingleFrame(LibImage libImage, TemplateInfo templateInfo) {
        return jniTemplateMatcherJNI.FrameProcessorTemplateMatcher_detectSingleFrame(this.a, this, LibImage.getCPtr(libImage), libImage, TemplateInfo.getCPtr(templateInfo), templateInfo);
    }
}
