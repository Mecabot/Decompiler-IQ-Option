package com.iqoption.dto.entity.position.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.position.Position;
import java.util.ArrayList;

public class HistoryResult {
    @SerializedName("history")
    public ArrayList<Position> history;
    @SerializedName("total")
    public Integer total;
}
