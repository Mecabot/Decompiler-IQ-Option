package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.microservices.avatar.a;

public class AvatarResult {
    @SerializedName("result")
    private a avatar;

    public a getAvatar() {
        return this.avatar;
    }
}
