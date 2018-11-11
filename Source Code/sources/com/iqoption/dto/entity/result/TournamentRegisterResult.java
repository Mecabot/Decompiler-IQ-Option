package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;

public class TournamentRegisterResult {
    public static final int NEED_MORE_GOLD = 5;
    public static final int SUCCESSFUL_STATUS = 0;
    @SerializedName("result")
    public RegisterResult result;

    public static class RegisterResult {
        @SerializedName("amount")
        public Double amount;
        @SerializedName("currency")
        public String currency;
        @SerializedName("status")
        public Integer status;
    }
}
