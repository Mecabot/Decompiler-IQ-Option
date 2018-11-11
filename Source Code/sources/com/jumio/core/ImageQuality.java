package com.jumio.core;

import com.jumio.clientlib.impl.imagequality.ImageQualityAcquisition;
import com.jumio.clientlib.impl.imagequality.PixelFormatType;
import com.jumio.commons.log.Log;
import com.jumio.ocr.impl.smartEngines.swig.ImageCheck;

public class ImageQuality {
    public static final float FOCUS_THRESHOLD = 0.12f;
    public static final int INTENSITY_THRESHOLD = 70;

    public static boolean isFlashNeeded(RawImageFrame rawImageFrame) {
        return isFlashNeeded(rawImageFrame.data, rawImageFrame.width, rawImageFrame.height, rawImageFrame.format == 0);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2) {
        return isFlashNeeded(bArr, i, i2, 70);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, int i3) {
        return isFlashNeeded(bArr, i, i2, i3, false);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, boolean z) {
        return isFlashNeeded(bArr, i, i2, 70, z);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, int i3, boolean z) {
        int i4 = z ? 3 : 1;
        int i5 = z ? 3 : 1;
        r4 = new Object[6];
        int i6 = i4 * i;
        r4[4] = Integer.valueOf(i6);
        r4[5] = Integer.valueOf(i5);
        Log.v("ImageCheck", String.format("-- isFlashNeeded: len = %d, threshold=%d, w = %d, h = %d, stride = %d, ch = %d", r4));
        try {
            return ImageCheck.isFlashNeeded(bArr, i3, i, i2, i6, i5);
        } catch (Throwable e) {
            Log.w("ImageCheck", "isFlashNeeded failed!", e);
            return false;
        }
    }

    public static boolean isRefocusNeeded(RawImageFrame rawImageFrame) {
        return calculateFocus(rawImageFrame.data, rawImageFrame.width, rawImageFrame.height, rawImageFrame.format == 0) < 0.12f;
    }

    public static float calculateFocus(byte[] bArr, int i, int i2) {
        return calculateFocus(bArr, i, i2, 0.12f);
    }

    public static float calculateFocus(byte[] bArr, int i, int i2, float f) {
        return calculateFocus(bArr, i, i2, f, false);
    }

    public static float calculateFocus(byte[] bArr, int i, int i2, boolean z) {
        return calculateFocus(bArr, i, i2, 0.12f, z);
    }

    public static float calculateFocus(byte[] bArr, int i, int i2, float f, boolean z) {
        PixelFormatType pixelFormatType;
        int i3 = z ? 3 : 1;
        if (z) {
            pixelFormatType = PixelFormatType.PIXEL_FORMAT_RGB_8;
        } else {
            pixelFormatType = PixelFormatType.PIXEL_FORMAT_YUV420_NV21;
        }
        try {
            Log.v("ImageCheck", String.format("-- computeFocusConfidence: len = %d, threshold=%f, w = %d, h = %d, stride = %d, format = %s", new Object[]{Integer.valueOf(bArr.length), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3 * i), pixelFormatType.toString()}));
            return ImageQualityAcquisition.Evaluate(bArr, ((long) i3) * ((long) i), i, i2, r8);
        } catch (Throwable e) {
            Log.w("ImageCheck", "computeFocusConfidence failed!", e);
            return -1.0f;
        }
    }
}
