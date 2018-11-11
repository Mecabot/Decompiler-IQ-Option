package com.jumio.nv.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.NetverifyDocumentData;

@PersistWith("OfflineDataModel")
public class OfflineDataModel implements StaticModel {
    private String a = null;
    private String b = null;
    private String c = null;

    public String getFrontImage() {
        return this.a;
    }

    public void setFrontImage(String str) {
        this.a = str;
    }

    public String getBackImage() {
        return this.b;
    }

    public void setBackImage(String str) {
        this.b = str;
    }

    public String getFaceImage() {
        return this.c;
    }

    public void setFaceImage(String str) {
        this.c = str;
    }

    public void populateData(NetverifyDocumentData netverifyDocumentData) {
        netverifyDocumentData.setFrontImage(this.a);
        netverifyDocumentData.setBackImage(this.b);
        netverifyDocumentData.setFaceImage(this.c);
    }
}
