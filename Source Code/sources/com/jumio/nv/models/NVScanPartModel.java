package com.jumio.nv.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.sdk.models.BaseScanPartModel;

@PersistWith("ScanPartModel")
public class NVScanPartModel extends BaseScanPartModel {
    @Nullable
    private DocumentDataModel a;
    private int b;
    private boolean c;

    public NVScanPartModel(@NonNull ScanSide scanSide, @NonNull DocumentScanMode documentScanMode, int i) {
        this(scanSide, documentScanMode, documentScanMode.getFormat(), i);
    }

    public NVScanPartModel(@NonNull ScanSide scanSide, @NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, int i) {
        super(scanSide, documentScanMode, documentFormat);
        this.b = i;
    }

    @Nullable
    public DocumentDataModel getDocumentInfo() {
        return this.a;
    }

    public void setDocumentInfo(@Nullable DocumentDataModel documentDataModel) {
        this.a = documentDataModel;
    }

    public int getPartIndex() {
        return this.b;
    }

    public boolean isSkipped() {
        return this.c;
    }

    public void setSkipped(boolean z) {
        this.c = z;
    }
}
