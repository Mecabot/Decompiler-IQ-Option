package com.iqoption.dto.entity.position.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.position.PositionAndOrder;
import java.util.ArrayList;

public class PositionsResult {
    @SerializedName("positions")
    public ArrayList<PositionAndOrder> positions;
    @SerializedName("total")
    public Integer total;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PositionsResult{total=");
        stringBuilder.append(this.total);
        stringBuilder.append(", positions=");
        stringBuilder.append(this.positions);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
