package com.jumio.sdk.models;

import com.jumio.core.enums.JumioDataCenter;
import com.jumio.core.mvp.model.StaticModel;

public class CredentialsModel implements StaticModel {
    private String mApiSecret;
    private String mApiToken;
    private JumioDataCenter mDataCenter;

    public String getApiToken() {
        return this.mApiToken;
    }

    public void setApiToken(String str) {
        this.mApiToken = str;
    }

    public String getApiSecret() {
        return this.mApiSecret;
    }

    public void setApiSecret(String str) {
        this.mApiSecret = str;
    }

    public JumioDataCenter getDataCenter() {
        return this.mDataCenter;
    }

    public void setDataCenter(JumioDataCenter jumioDataCenter) {
        this.mDataCenter = jumioDataCenter;
    }
}
