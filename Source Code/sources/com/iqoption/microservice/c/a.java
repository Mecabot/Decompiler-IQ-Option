package com.iqoption.microservice.c;

import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.b;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.c.a.c;
import com.iqoption.util.ag;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: OtnLeaderBoardRequests */
public final class a {
    private static b<Long, com.iqoption.microservice.c.a.a> aJR = CacheBuilder.qh().A(1).a(1, TimeUnit.MINUTES).qw();
    private static n<b<Long, com.iqoption.microservice.c.a.b>> cRV = Suppliers.a(new n<b<Long, com.iqoption.microservice.c.a.b>>() {
        /* renamed from: asG */
        public b<Long, com.iqoption.microservice.c.a.b> get() {
            return CacheBuilder.qh().A(10).a(30, TimeUnit.MINUTES).qw();
        }
    });

    public static s<com.iqoption.microservice.c.a.a> bC(final long j) {
        com.iqoption.microservice.c.a.a aVar = (com.iqoption.microservice.c.a.a) aJR.I(Long.valueOf(j));
        if (aVar != null) {
            return o.aR(aVar);
        }
        Long valueOf = Long.valueOf(com.iqoption.app.a.Cw().getUserId());
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", valueOf);
        hashMap.put("user_country_id", Integer.valueOf(0));
        hashMap.put("country_id", Long.valueOf(j));
        hashMap.put("from_position", Integer.valueOf(1));
        hashMap.put("to_position", Integer.valueOf(200));
        hashMap.put("position_country", Integer.valueOf(0));
        hashMap.put("near_traders_count", Integer.valueOf(0));
        hashMap.put("top_count", Integer.valueOf(0));
        hashMap.put("request_id", Integer.valueOf(0));
        hashMap.put("top_type", Integer.valueOf(3));
        return ag.a(new com.iqoption.mobbtech.connect.request.a.a.b.a(com.iqoption.microservice.c.a.a.class).cd(false).ga("request-leaderboard-deals-client").b(hashMap).Sa(), new g<com.iqoption.microservice.c.a.a, com.iqoption.microservice.c.a.a>() {
            /* renamed from: b */
            public s<com.iqoption.microservice.c.a.a> aP(com.iqoption.microservice.c.a.a aVar) {
                a.aJR.put(Long.valueOf(j), aVar);
                return o.aR(aVar);
            }
        });
    }

    public static s<com.iqoption.microservice.c.a.b> bD(final long j) {
        return ag.a(new com.iqoption.mobbtech.connect.request.a.a.b.a(com.iqoption.microservice.c.a.b.class).cd(false).ga("get-user-profile-client").j("user_id", Long.valueOf(j)).Sa(), new g<com.iqoption.microservice.c.a.b, com.iqoption.microservice.c.a.b>() {
            /* renamed from: a */
            public s<com.iqoption.microservice.c.a.b> aP(com.iqoption.microservice.c.a.b bVar) {
                ((b) a.cRV.get()).put(Long.valueOf(j), bVar);
                return o.aR(bVar);
            }
        });
    }

    public static s<c> I(Iterable<Long> iterable) {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(c.class).cd(false).ga("get-users-availability").c("user_ids", iterable).Sa();
    }
}
