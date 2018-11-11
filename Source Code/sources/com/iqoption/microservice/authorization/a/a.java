package com.iqoption.microservice.authorization.a;

import com.google.gson.annotations.SerializedName;

/* compiled from: ErrorObject */
public class a {
    @SerializedName("code")
    public Integer cPp;
    @SerializedName("detail")
    public String detail;
    @SerializedName("title")
    public String title;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorObject{code=");
        stringBuilder.append(this.cPp);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", detail='");
        stringBuilder.append(this.detail);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
