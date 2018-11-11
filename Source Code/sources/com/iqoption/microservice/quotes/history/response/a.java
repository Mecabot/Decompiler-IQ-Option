package com.iqoption.microservice.quotes.history.response;

import com.google.gson.annotations.SerializedName;

/* compiled from: Candle */
public final class a {
    @SerializedName("to")
    private long cSy;
    @SerializedName("close")
    private double cSz;

    public long asV() {
        return this.cSy;
    }

    public double asW() {
        return this.cSz;
    }
}
