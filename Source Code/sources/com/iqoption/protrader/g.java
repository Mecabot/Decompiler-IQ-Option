package com.iqoption.protrader;

import com.iqoption.microservice.regulators.response.a;
import io.reactivex.e;
import io.reactivex.o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, aXE = {"Lcom/iqoption/protrader/RegulatorsRepository;", "", "()V", "positionsStreams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/microservice/regulators/response/ProTraderApplicationStatus;", "getPositionsStreams", "()Ljava/util/concurrent/ConcurrentHashMap;", "positionsStreams$delegate", "Lkotlin/Lazy;", "getProTraderApplicationStatus", "Lio/reactivex/Flowable;", "userId", "getProTraderNotification", "Lio/reactivex/Single;", "Lcom/iqoption/microservice/regulators/response/ProTraderNotification;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RegulatorsRepository.kt */
public final class g {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "positionsStreams", "getPositionsStreams()Ljava/util/concurrent/ConcurrentHashMap;"))};
    private static final d ddS = g.f(RegulatorsRepository$positionsStreams$2.ddU);
    public static final g ddT = new g();

    private final ConcurrentHashMap<Long, com.iqoption.core.h.d<a>> ayy() {
        d dVar = ddS;
        j jVar = apP[0];
        return (ConcurrentHashMap) dVar.getValue();
    }

    private g() {
    }

    public final e<a> bO(long j) {
        com.iqoption.core.h.d dVar = (com.iqoption.core.h.d) ayy().get(Long.valueOf(j));
        if (dVar != null) {
            return dVar.Yg();
        }
        e c = e.e((Future) com.iqoption.microservice.regulators.a.cSK.asY()).c((b) com.iqoption.microservice.regulators.a.cSK.asZ());
        h.d(c, "initial.concatWith(updates)");
        return new com.iqoption.core.h.d(c, 0, null, 6, null).Yg();
    }

    public final o<com.iqoption.microservice.regulators.response.b> ayz() {
        o<com.iqoption.microservice.regulators.response.b> f = o.f((Future) com.iqoption.microservice.regulators.a.cSK.asX());
        h.d(f, "Single.fromFuture(Regula…tProTraderNotification())");
        return f;
    }
}
