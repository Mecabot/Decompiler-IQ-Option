package com.iqoption.microservice.quotes.history;

import com.google.common.util.concurrent.s;
import com.iqoption.core.connect.k;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.microservice.quotes.history.response.b;
import com.iqoption.microservice.quotes.history.response.c;
import com.iqoption.microservice.quotes.history.response.d;

/* compiled from: QuotesHistoryRequests */
public final class a {
    public static s<b> a(int i, long j, long j2, int i2) {
        return com.iqoption.mobbtech.connect.request.a.a.b.A(b.class).ga("get-candles").gb("2.0").cd(false).j("active_id", Integer.valueOf(i)).j("from", Long.valueOf(j)).j("to", Long.valueOf(j2)).j("size", Integer.valueOf(i2)).Sa();
    }

    public static s<d> a(int i, long j, long j2, int i2, int i3, int i4, int i5) {
        k j3 = com.iqoption.mobbtech.connect.request.a.a.b.A(d.class).ga("get-candles").cd(false).gb("2.0").j("active_id", Integer.valueOf(i)).j("format", "compact_json").j("size", Integer.valueOf(i2));
        if (j != 0) {
            j3.j("from", Long.valueOf(j));
        }
        if (j2 != 0) {
            j3.j("to", Long.valueOf(j2));
        }
        if (i3 != 0) {
            j3.j("from_id", Integer.valueOf(i3));
        }
        if (i4 != 0) {
            j3.j("to_id", Integer.valueOf(i4));
        }
        if (i5 != 0) {
            j3.j(OtnEmissionExecuted.COUNT, Integer.valueOf(i5));
        }
        return j3.Sa();
    }

    public static s<c> fq(int i) {
        s Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(c.class).ga("get-first-candles").gb("1.0").cd(false).j("active_id", Integer.valueOf(i)).Sa();
        com.iqoption.core.a.a.a.aMG.a(Sa, i);
        return Sa;
    }
}
