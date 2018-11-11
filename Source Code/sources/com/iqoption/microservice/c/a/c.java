package com.iqoption.microservice.c.a;

import com.google.common.base.d;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: UsersAvailability */
public class c {
    @SerializedName("statuses")
    @Expose
    public List<a> cSj;

    /* compiled from: UsersAvailability */
    public static class a {
        public static d<a, String> cSk = new d<a, String>() {
            /* renamed from: a */
            public String apply(a aVar) {
                return aVar.status;
            }
        };
        @SerializedName("user_id")
        @Expose
        public Integer cSl;
        @SerializedName("idle_duration")
        @Expose
        public Integer cSm;
        @SerializedName("platform_id")
        @Expose
        public Integer platformId;
        @SerializedName("status")
        @Expose
        public String status;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Status{userId=");
            stringBuilder.append(this.cSl);
            stringBuilder.append(", platformId=");
            stringBuilder.append(this.platformId);
            stringBuilder.append(", idleDuration=");
            stringBuilder.append(this.cSm);
            stringBuilder.append(", status='");
            stringBuilder.append(this.status);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UsersAvailability{statuses=");
        stringBuilder.append(this.cSj);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
