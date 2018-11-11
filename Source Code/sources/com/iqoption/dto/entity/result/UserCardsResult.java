package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.microservices.billing.response.deposit.h;
import java.util.ArrayList;

public class UserCardsResult {
    @SerializedName("data")
    public ArrayList<h> userCards;
}
