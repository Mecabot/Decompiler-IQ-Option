package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.entity.strike.Strike;
import java.util.ArrayList;

public class SpotResult extends StrikesResult {
    @SerializedName("spot")
    private ArrayList<Strike> spotList;

    public ArrayList<Strike> getStrikeList() {
        return this.spotList;
    }
}
