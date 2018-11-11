package com.jumio.sdk.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;

public abstract class BaseScanPartModel implements StaticModel {
    @NonNull
    private DocumentFormat documentFormat;
    @Nullable
    private ImageData mScannedImage;
    @NonNull
    private DocumentScanMode scanMode;
    @NonNull
    private ScanSide sideToScan;

    public BaseScanPartModel(@NonNull ScanSide scanSide, @NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat) {
        this.sideToScan = scanSide;
        this.scanMode = documentScanMode;
        this.documentFormat = documentFormat;
    }

    @NonNull
    public ImageData getScannedImage() {
        if (this.mScannedImage == null) {
            this.mScannedImage = new ImageData();
        }
        return this.mScannedImage;
    }

    public void setScannedImage(@Nullable ImageData imageData) {
        this.mScannedImage = imageData;
    }

    @NonNull
    public ScanSide getSideToScan() {
        return this.sideToScan;
    }

    @NonNull
    public DocumentFormat getFormat() {
        return this.documentFormat;
    }

    @NonNull
    public DocumentScanMode getScanMode() {
        return this.scanMode;
    }

    public void setScanMode(DocumentScanMode documentScanMode) {
        this.scanMode = documentScanMode;
    }
}
