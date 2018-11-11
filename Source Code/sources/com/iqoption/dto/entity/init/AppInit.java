package com.iqoption.dto.entity.init;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.PushSetting;
import java.util.ArrayList;

public class AppInit {
    @SerializedName("deposit_stat")
    public ArrayList<DepositStat> depositStats;
    @SerializedName("feed_top_traders_post_ussr_countries")
    public ArrayList<Integer> feedTopTradersPostUssrCountries;
    @SerializedName("push_settings")
    public ArrayList<PushSetting> pushSettings;

    public static class DepositStat {
        public Double amount;
        @SerializedName("balance_id")
        public Long balanceId;
        public String currency;
        @SerializedName("op_id")
        public String opId;
        @SerializedName("platform_id")
        public Integer platformId;
        @SerializedName("user_id")
        public String userId;
    }
}
