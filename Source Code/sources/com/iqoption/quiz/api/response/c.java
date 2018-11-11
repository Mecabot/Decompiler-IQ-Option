package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;

/* compiled from: LifeResponse */
public class c {
    public static c dim = new c() {
        {
            this.count = 0;
            this.total = 0;
        }
    };
    @SerializedName("count")
    public int count;
    @SerializedName("total_count")
    public int total;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LifeResponse{count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", total=");
        stringBuilder.append(this.total);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
