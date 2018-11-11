package com.jumio.clientlib.impl.templatematcher;

public class FrameProcessor {
    private transient long a;
    private transient boolean b;

    protected FrameProcessor(long j, boolean z) {
        this.b = z;
        this.a = j;
    }

    protected static long getCPtr(FrameProcessor frameProcessor) {
        return frameProcessor == null ? 0 : frameProcessor.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.b) {
                this.b = false;
                jniTemplateMatcherJNI.delete_FrameProcessor(this.a);
            }
            this.a = 0;
        }
    }

    public void pushFrame(LibImage libImage) {
        jniTemplateMatcherJNI.FrameProcessor_pushFrame(this.a, this, LibImage.getCPtr(libImage), libImage);
    }

    public void reset() {
        jniTemplateMatcherJNI.FrameProcessor_reset(this.a, this);
    }
}
