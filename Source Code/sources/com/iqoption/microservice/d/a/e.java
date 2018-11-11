package com.iqoption.microservice.d.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: OtnOperationHistory */
public final class e {
    @SerializedName("history")
    private List<d> cSx;

    public List<d> asU() {
        return this.cSx;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnOperationHistory{operations=");
        stringBuilder.append(this.cSx);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
