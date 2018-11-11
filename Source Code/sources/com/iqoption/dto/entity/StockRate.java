package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;

public class StockRate {
    @SerializedName("percent_change_24h")
    public Double percentChange24h;
    @SerializedName("price_usd")
    public Double priceUsd;
}
