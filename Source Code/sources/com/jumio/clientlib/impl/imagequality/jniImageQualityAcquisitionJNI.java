package com.jumio.clientlib.impl.imagequality;

public class jniImageQualityAcquisitionJNI {
    public static final native float ImageQualityAcquisition_Evaluate(byte[] bArr, long j, int i, int i2, int i3);

    public static final native float ImageQualityAcquisition_decodeAndEvaluate(byte[] bArr);
}
