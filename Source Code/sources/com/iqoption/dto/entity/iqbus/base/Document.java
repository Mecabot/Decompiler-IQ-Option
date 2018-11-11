package com.iqoption.dto.entity.iqbus.base;

import com.google.gson.annotations.SerializedName;

public class Document {
    @SerializedName("name")
    public String name;
    @SerializedName("status")
    public Integer status;

    public boolean isSuccessful() {
        return this.status != null && this.status.intValue() == 0;
    }
}
