package com.jumio.core.data.document;

public enum DocumentScanMode {
    CREDIT(DocumentFormat.ID1),
    MRP(DocumentFormat.ID3),
    MRV(DocumentFormat.ID3),
    TD1(DocumentFormat.ID1),
    TD2(DocumentFormat.ID2),
    CNIS(DocumentFormat.ID2),
    PDF417(DocumentFormat.ID1),
    CSSN(DocumentFormat.ID1),
    LINEFINDER(DocumentFormat.ID1),
    FACE(DocumentFormat.NONE),
    MANUAL(DocumentFormat.NONE),
    TEMPLATEMATCHER(DocumentFormat.ID1),
    NFC(DocumentFormat.NONE);
    
    private DocumentFormat format;

    private DocumentScanMode(DocumentFormat documentFormat) {
        this.format = documentFormat;
    }

    public DocumentFormat getFormat() {
        return this.format;
    }
}
