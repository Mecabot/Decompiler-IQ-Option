package com.jumio.nv.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;

@PersistWith("InitiateModel")
public class InitiateModel implements StaticModel {
    private String a;

    public String getJumioScanRef() {
        return this.a;
    }

    public void setJumioScanRef(String str) {
        this.a = str;
    }
}
