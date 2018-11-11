package com.jumio.clientlib.impl.templatematcher;

public class FrameQueue {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected FrameQueue(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(FrameQueue frameQueue) {
        return frameQueue == null ? 0 : frameQueue.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_FrameQueue(this.a);
            }
            this.a = 0;
        }
    }

    public FrameQueue(long j) {
        this(jniTemplateMatcherJNI.new_FrameQueue(j), true);
    }

    public void pushFrame(LibImage libImage) {
        jniTemplateMatcherJNI.FrameQueue_pushFrame(this.a, this, LibImage.getCPtr(libImage), libImage);
    }

    public LibImage lastFrame() {
        long FrameQueue_lastFrame = jniTemplateMatcherJNI.FrameQueue_lastFrame(this.a, this);
        if (FrameQueue_lastFrame == 0) {
            return null;
        }
        return new LibImage(FrameQueue_lastFrame, true);
    }

    public LibImage getFrameByID(int i) {
        long FrameQueue_getFrameByID = jniTemplateMatcherJNI.FrameQueue_getFrameByID(this.a, this, i);
        if (FrameQueue_getFrameByID == 0) {
            return null;
        }
        return new LibImage(FrameQueue_getFrameByID, true);
    }

    public boolean removeFrameByID(int i) {
        return jniTemplateMatcherJNI.FrameQueue_removeFrameByID(this.a, this, i);
    }

    public void getFramesInRange(int i, int i2, FramesVector framesVector) {
        jniTemplateMatcherJNI.FrameQueue_getFramesInRange(this.a, this, i, i2, FramesVector.getCPtr(framesVector), framesVector);
    }

    public void getAllFrames(FramesVector framesVector) {
        jniTemplateMatcherJNI.FrameQueue_getAllFrames(this.a, this, FramesVector.getCPtr(framesVector), framesVector);
    }

    public long size() {
        return jniTemplateMatcherJNI.FrameQueue_size(this.a, this);
    }

    public void clear() {
        jniTemplateMatcherJNI.FrameQueue_clear(this.a, this);
    }
}
