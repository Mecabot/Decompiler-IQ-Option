package com.jumio.nv.models;

import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.nv.extraction.NfcController;

public class NfcScanPartModel extends NVScanPartModel {
    private NfcController a;

    public NfcScanPartModel(NfcController nfcController) {
        super(ScanSide.FRONT, DocumentScanMode.NFC, 4);
        this.a = nfcController;
    }

    public NfcController getNfcController() {
        return this.a;
    }
}
