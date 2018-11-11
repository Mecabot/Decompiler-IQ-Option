package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.strike.Strike;
import java.util.ArrayList;

public class StrikesResult {
    @SerializedName("expiration")
    public long expiration;
    @SerializedName("period")
    public long period;
    @SerializedName("strike")
    private ArrayList<Strike> strikeList;
    @SerializedName("type")
    public InstrumentType type;
    @SerializedName("underlying")
    public String underlying;

    public ArrayList<Strike> getStrikeList() {
        return this.strikeList;
    }
}
