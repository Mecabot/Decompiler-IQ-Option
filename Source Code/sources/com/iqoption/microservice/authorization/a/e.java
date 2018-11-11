package com.iqoption.microservice.authorization.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: TokenResponse */
public class e {
    @SerializedName("data")
    public a cPy;
    @SerializedName("errors")
    public List<a> errors;

    /* compiled from: TokenResponse */
    public static class a {
        @SerializedName("token")
        public String token;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TokenResponse{data=");
        stringBuilder.append(this.cPy);
        stringBuilder.append(", errors=");
        stringBuilder.append(this.errors);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
