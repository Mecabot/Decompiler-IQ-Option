package com.jumio.clientlib.impl.templatematcher;

public class FrameProcessingCallbackTemplateMatcher {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected FrameProcessingCallbackTemplateMatcher(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(FrameProcessingCallbackTemplateMatcher frameProcessingCallbackTemplateMatcher) {
        return frameProcessingCallbackTemplateMatcher == null ? 0 : frameProcessingCallbackTemplateMatcher.a;
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
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
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_change_ownership(this, this.a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_change_ownership(this, this.a, true);
    }

    public void intermediateResult(FrameQueue frameQueue, TemplateInfo templateInfo) {
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_intermediateResult(this.a, this, FrameQueue.getCPtr(frameQueue), frameQueue, TemplateInfo.getCPtr(templateInfo), templateInfo);
    }

    public void finalResult(FrameQueue frameQueue, TemplateInfo templateInfo) {
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_finalResult(this.a, this, FrameQueue.getCPtr(frameQueue), frameQueue, TemplateInfo.getCPtr(templateInfo), templateInfo);
    }

    public void noResult(FrameQueue frameQueue) {
        if (getClass() == FrameProcessingCallbackTemplateMatcher.class) {
            jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_noResult(this.a, this, FrameQueue.getCPtr(frameQueue), frameQueue);
            return;
        }
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_noResultSwigExplicitFrameProcessingCallbackTemplateMatcher(this.a, this, FrameQueue.getCPtr(frameQueue), frameQueue);
    }

    public FrameProcessingCallbackTemplateMatcher() {
        this(jniTemplateMatcherJNI.new_FrameProcessingCallbackTemplateMatcher(), true);
        jniTemplateMatcherJNI.FrameProcessingCallbackTemplateMatcher_director_connect(this, this.a, this.swigCMemOwn, true);
    }
}
