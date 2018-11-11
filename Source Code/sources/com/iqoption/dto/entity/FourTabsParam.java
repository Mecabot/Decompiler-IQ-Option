package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;

public class FourTabsParam {
    @SerializedName("no_reg")
    public Param noReg;
    @SerializedName("reg")
    public Param reg;

    public static class List extends ArrayList<FourTabsParam> {
    }

    public class Param {
        @SerializedName("asset_id")
        public Integer assetId;
        @SerializedName("instrument_type")
        public InstrumentType instrumentType;
    }
}
