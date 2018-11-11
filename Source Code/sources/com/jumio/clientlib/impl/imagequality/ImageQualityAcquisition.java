package com.jumio.clientlib.impl.imagequality;

public class ImageQualityAcquisition {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ImageQualityAcquisition(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageQualityAcquisition imageQualityAcquisition) {
        return imageQualityAcquisition == null ? 0 : imageQualityAcquisition.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public static float Evaluate(byte[] bArr, long j, int i, int i2, PixelFormatType pixelFormatType) {
        return jniImageQualityAcquisitionJNI.ImageQualityAcquisition_Evaluate(bArr, j, i, i2, pixelFormatType.swigValue());
    }

    public static float decodeAndEvaluate(byte[] bArr) {
        return jniImageQualityAcquisitionJNI.ImageQualityAcquisition_decodeAndEvaluate(bArr);
    }
}
