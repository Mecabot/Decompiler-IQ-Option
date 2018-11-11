package com.jumio.clientlib.impl.templatematcher;

public class LibImage {
    private transient long a;
    private transient boolean b;

    protected LibImage(long j, boolean z) {
        this.b = z;
        this.a = j;
    }

    protected static long getCPtr(LibImage libImage) {
        return libImage == null ? 0 : libImage.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.b) {
                this.b = false;
                jniTemplateMatcherJNI.delete_LibImage(this.a);
            }
            this.a = 0;
        }
    }

    public LibImage(byte[] bArr, PixelFormatType pixelFormatType, int i, int i2, long j, int i3, int i4, int i5, int i6, boolean z) {
        this(jniTemplateMatcherJNI.new_LibImage__SWIG_0(bArr, pixelFormatType.swigValue(), i, i2, j, i3, i4, i5, i6, z), true);
    }

    public LibImage(byte[] bArr, PixelFormatType pixelFormatType, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        this(jniTemplateMatcherJNI.new_LibImage__SWIG_1(bArr, pixelFormatType.swigValue(), i, i2, j, i3, i4, i5, i6), true);
    }

    public SWIGTYPE_p_unsigned_char getFrameBuffer() {
        long LibImage_getFrameBuffer__SWIG_0 = jniTemplateMatcherJNI.LibImage_getFrameBuffer__SWIG_0(this.a, this);
        if (LibImage_getFrameBuffer__SWIG_0 == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(LibImage_getFrameBuffer__SWIG_0, false);
    }

    public void getFrameBuffer(byte[] bArr) {
        jniTemplateMatcherJNI.LibImage_getFrameBuffer__SWIG_1(this.a, this, bArr);
    }

    public PixelFormatType getFormat() {
        return PixelFormatType.swigToEnum(jniTemplateMatcherJNI.LibImage_getFormat(this.a, this));
    }

    public int getWidth() {
        return jniTemplateMatcherJNI.LibImage_getWidth(this.a, this);
    }

    public int getHeight() {
        return jniTemplateMatcherJNI.LibImage_getHeight(this.a, this);
    }

    public long getStride() {
        return jniTemplateMatcherJNI.LibImage_getStride(this.a, this);
    }

    public int getChannels() {
        return jniTemplateMatcherJNI.LibImage_getChannels(this.a, this);
    }

    public int getChannelDepth() {
        return jniTemplateMatcherJNI.LibImage_getChannelDepth(this.a, this);
    }

    public int getFrameIndex() {
        return jniTemplateMatcherJNI.LibImage_getFrameIndex(this.a, this);
    }

    public int getTimeStamp() {
        return jniTemplateMatcherJNI.LibImage_getTimeStamp(this.a, this);
    }
}
