package com.umoove.all;

class UMNativeCore {
    static native void Destroy();

    static native void InitNative(int i, int i2, int i3, int i4, float f, int i5, int i6, float f2, float f3, int i7, double d, double d2, float f4, float f5, int i8);

    static native void Process(byte[] bArr, float[] fArr, int i, long j);

    static native void Reset();

    static native void SetDisplayWindow(int i, int i2);

    static native void Start();

    static native void Stop();

    static native void setDistanceBetweenEyes(float f);

    static native void setEyeBallRadius(float f);

    static native void setInitEyeMovement();

    static native void setInitHeadCenter();

    static native void setInitHeadMovement();

    static native void setInitIris();

    static native void setIrisRadius(float f);

    static native void setIrisTrackingMode(int i);

    static native void setStrictEyeMovement(boolean z);

    static {
        System.loadLibrary("umoove_lib");
    }
}
