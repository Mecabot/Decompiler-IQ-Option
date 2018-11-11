package com.jumio.commons.camera;

public interface ICameraCallback {
    void onCameraAvailable(boolean z);

    void onCameraError(Throwable th);

    void onManualRefocus(int i, int i2);

    void onPreviewAvailable(PreviewProperties previewProperties);

    void onPreviewFrame(byte[] bArr);

    void onStopPreview();
}
