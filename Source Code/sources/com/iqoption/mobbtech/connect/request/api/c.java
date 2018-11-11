package com.iqoption.mobbtech.connect.request.api;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;

/* compiled from: Heartbeat */
class c {
    @SerializedName("request_id")
    private final String cPL = UUID.randomUUID().toString();
    @SerializedName("msg")
    private final a cUF;
    @SerializedName("name")
    private final String name = "heartbeat";

    /* compiled from: Heartbeat */
    private static class a {
        @SerializedName("userTime")
        Long cUG;
        @SerializedName("heartbeatTime")
        Long cUH;

        a(long j, long j2) {
            this.cUG = Long.valueOf(j);
            this.cUH = Long.valueOf(j2);
        }
    }

    public c(long j, long j2) {
        this.cUF = new a(j2, j);
    }
}
