package com.iqoption.microservice.d.a;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/* compiled from: OtnOperation */
public final class d {
    @SerializedName("diff")
    private BigDecimal cSw;
    @SerializedName("time")
    private long time;
    @SerializedName("operation_type")
    private String type;

    public String getType() {
        return this.type;
    }

    public BigDecimal asT() {
        return this.cSw.scaleByPowerOfTen(-18);
    }

    public long getTime() {
        return this.time;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void d(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            this.cSw = bigDecimal.scaleByPowerOfTen(18);
        } else {
            this.cSw = null;
        }
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnOperation{type='");
        stringBuilder.append(this.type);
        stringBuilder.append('\'');
        stringBuilder.append(", diff=");
        stringBuilder.append(this.cSw);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
