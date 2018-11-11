package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;
import java.util.Comparator;

public class OvernightHistory {
    public static final Comparator SORTING = OvernightHistory$$Lambda$0.$instance;
    @SerializedName("active_id")
    public int activeId;
    @SerializedName("amount_delta")
    public double amountDelta;
    @SerializedName("filled_at")
    public long filledAt;
    @SerializedName("instrument_type")
    public InstrumentType instrumentType;

    public static class List extends ArrayList<OvernightHistory> {
    }
}
