package com.iqoption.microservice.d.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: OtnEmissionHistory */
public final class b {
    @SerializedName("items")
    private List<Object> cSr;

    public List<Object> asR() {
        return this.cSr;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnEmissionHistory{emissions=");
        stringBuilder.append(this.cSr);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
