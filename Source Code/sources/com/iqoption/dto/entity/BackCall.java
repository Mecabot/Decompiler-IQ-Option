package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;

public class BackCall {
    @SerializedName("result")
    public Result result;

    public class Result {
        @SerializedName("canOrderCallback")
        public Boolean canOrderCallback;
        @SerializedName("hasVipManager")
        public Boolean hasVipManager;
        @SerializedName("managerName")
        public String managerName;
        @SerializedName("managerPhone")
        public String managerPhone;
    }

    public boolean isEnabled() {
        return this.result.canOrderCallback != null && this.result.canOrderCallback.booleanValue();
    }
}
