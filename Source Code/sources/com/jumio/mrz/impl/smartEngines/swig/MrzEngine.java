package com.jumio.mrz.impl.smartEngines.swig;

public class MrzEngine {
    private long a;
    protected boolean swigCMemOwn;

    public static final class ImageOrientation {
        public static final ImageOrientation InvertedLandscape = new ImageOrientation("InvertedLandscape");
        public static final ImageOrientation InvertedPortrait = new ImageOrientation("InvertedPortrait");
        public static final ImageOrientation Landscape = new ImageOrientation("Landscape");
        public static final ImageOrientation Portrait = new ImageOrientation("Portrait");
        private static ImageOrientation[] a = new ImageOrientation[]{Landscape, Portrait, InvertedLandscape, InvertedPortrait};
        private static int b;
        private final int c;
        private final String d;

        public final int swigValue() {
            return this.c;
        }

        public String toString() {
            return this.d;
        }

        public static ImageOrientation swigToEnum(int i) {
            if (i < a.length && i >= 0 && a[i].c == i) {
                return a[i];
            }
            for (int i2 = 0; i2 < a.length; i2++) {
                if (a[i2].c == i) {
                    return a[i2];
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No enum ");
            stringBuilder.append(ImageOrientation.class);
            stringBuilder.append(" with value ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private ImageOrientation(String str) {
            this.d = str;
            int i = b;
            b = i + 1;
            this.c = i;
        }
    }

    protected MrzEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzEngine mrzEngine) {
        return mrzEngine == null ? 0 : mrzEngine.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngine(this.a);
            }
            this.a = 0;
        }
    }

    public MrzEngine(MrzEngineInternalSettings mrzEngineInternalSettings) {
        this(mrzjniInterfaceJNI.new_MrzEngine(MrzEngineInternalSettings.getCPtr(mrzEngineInternalSettings), mrzEngineInternalSettings), true);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface, MrzEngineSessionHelpers mrzEngineSessionHelpers, MrzEngineSessionSettings mrzEngineSessionSettings) {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_0(this.a, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface, MrzEngineSessionHelpers.getCPtr(mrzEngineSessionHelpers), mrzEngineSessionHelpers, MrzEngineSessionSettings.getCPtr(mrzEngineSessionSettings), mrzEngineSessionSettings);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface, MrzEngineSessionHelpers mrzEngineSessionHelpers) {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_1(this.a, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface, MrzEngineSessionHelpers.getCPtr(mrzEngineSessionHelpers), mrzEngineSessionHelpers);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface) {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_2(this.a, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface);
    }

    public void TerminateSession() {
        mrzjniInterfaceJNI.MrzEngine_TerminateSession(this.a, this);
    }

    public void FeedUncompressedImageData(byte[] bArr, int i, int i2, int i3, int i4, MrzRect mrzRect, ImageOrientation imageOrientation) {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_0(this.a, this, bArr, i, i2, i3, i4, MrzRect.getCPtr(mrzRect), mrzRect, imageOrientation.swigValue());
    }

    public void FeedUncompressedImageData(byte[] bArr, int i, int i2, int i3, int i4, MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_1(this.a, this, bArr, i, i2, i3, i4, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public void FeedUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3, MrzRect mrzRect, ImageOrientation imageOrientation) {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_0(this.a, this, bArr, i, i2, i3, MrzRect.getCPtr(mrzRect), mrzRect, imageOrientation.swigValue());
    }

    public void FeedUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3, MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_1(this.a, this, bArr, i, i2, i3, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public void FeedImageFile(String str, ImageOrientation imageOrientation) {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_0(this.a, this, str, imageOrientation.swigValue());
    }

    public void FeedImageFile(String str) {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_1(this.a, this, str);
    }
}
