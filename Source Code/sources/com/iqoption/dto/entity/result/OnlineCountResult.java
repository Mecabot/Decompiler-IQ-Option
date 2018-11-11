package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;

public class OnlineCountResult {
    @SerializedName("result")
    public OnlineCount result;

    public class OnlineCount {
        @SerializedName("online")
        public Integer online;
    }
}
