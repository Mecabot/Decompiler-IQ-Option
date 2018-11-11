package com.jumio.core.data.document;

public enum ScanSide {
    FRONT(0, "FRONTSIDE"),
    BACK(1, "BACKSIDE"),
    FACE(2, "FACE");
    
    private String classifier;
    private int part;

    private ScanSide(int i, String str) {
        this.part = i;
        this.classifier = str;
    }

    public int getPartNumber() {
        return this.part;
    }

    public String getClassifier() {
        return this.classifier;
    }
}
