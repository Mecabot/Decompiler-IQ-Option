package com.iqoption.dto.entity.position.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.position.Position;

public final class PositionResult {
    @SerializedName("position")
    public Position position;
}
