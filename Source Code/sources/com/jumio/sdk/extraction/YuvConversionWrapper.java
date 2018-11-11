package com.jumio.sdk.extraction;

import com.jumio.commons.camera.CameraUtils.IYuvConversion;
import com.jumio.ocr.impl.smartEngines.swig.YuvUtils;

public class YuvConversionWrapper implements IYuvConversion {
    public int yuvCutRotateScale2rgb(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int i7, int i8, int i9) {
        return YuvUtils.yuvCutRotateScale2rgb(bArr, i, i2, i3, i4, i5, i6, bArr2, i7, i8, i9);
    }
}
