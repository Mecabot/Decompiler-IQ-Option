package com.iqoption.microservice.quotes.history.response;

import com.google.gson.annotations.SerializedName;

/* compiled from: Quote */
public final class e {
    @SerializedName("ts")
    private long time;
    @SerializedName("value")
    private double value;

    public long getTime() {
        return this.time;
    }

    public double getValue() {
        return this.value;
    }
}
