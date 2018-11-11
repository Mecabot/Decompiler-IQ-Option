package com.jumio.dv.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.sdk.models.BaseScanPartModel;

@PersistWith("DvScanPartModel")
public class DvScanPartModel extends BaseScanPartModel {
    public DvScanPartModel() {
        super(ScanSide.FRONT, DocumentScanMode.MANUAL, DocumentScanMode.MANUAL.getFormat());
    }
}
