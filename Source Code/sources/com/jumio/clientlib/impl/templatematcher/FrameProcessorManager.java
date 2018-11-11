package com.jumio.clientlib.impl.templatematcher;

public class FrameProcessorManager {
    private transient long a;
    private transient boolean b;

    protected FrameProcessorManager(long j, boolean z) {
        this.b = z;
        this.a = j;
    }

    protected static long getCPtr(FrameProcessorManager frameProcessorManager) {
        return frameProcessorManager == null ? 0 : frameProcessorManager.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.b) {
                this.b = false;
                jniTemplateMatcherJNI.delete_FrameProcessorManager(this.a);
            }
            this.a = 0;
        }
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr) {
        this(jniTemplateMatcherJNI.new_FrameProcessorManager__SWIG_0(SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr)), true);
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr, SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr2) {
        this(jniTemplateMatcherJNI.new_FrameProcessorManager__SWIG_1(SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr), SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr2)), true);
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr, SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr2, SWIGTYPE_p_FrameProcessorPtr sWIGTYPE_p_FrameProcessorPtr3) {
        this(jniTemplateMatcherJNI.new_FrameProcessorManager__SWIG_2(SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr), SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr2), SWIGTYPE_p_FrameProcessorPtr.getCPtr(sWIGTYPE_p_FrameProcessorPtr3)), true);
    }

    public void pushFrame(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, PixelFormatType pixelFormatType, int i6) {
        jniTemplateMatcherJNI.FrameProcessorManager_pushFrame(this.a, this, bArr, j, i, i2, i3, i4, i5, pixelFormatType.swigValue(), i6);
    }

    public void reset() {
        jniTemplateMatcherJNI.FrameProcessorManager_reset(this.a, this);
    }
}
