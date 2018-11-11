package com.iqoption.mobbtech.connect.response;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/* compiled from: LocalizationResponse */
public class f {
    @SerializedName("isSuccessful")
    private boolean aVB;
    @SerializedName("json")
    private JsonElement cVM;
    @SerializedName("version")
    private String version;

    public boolean isSuccessful() {
        return this.aVB;
    }

    public JsonElement auR() {
        return this.cVM;
    }

    public String getVersion() {
        return this.version;
    }
}
