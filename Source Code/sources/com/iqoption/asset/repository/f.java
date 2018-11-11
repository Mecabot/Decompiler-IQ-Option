package com.iqoption.asset.repository;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.h.d;
import com.iqoption.core.microservices.tradingengine.response.active.e.a;
import com.iqoption.core.microservices.tradingengine.response.active.j;
import com.iqoption.core.microservices.tradingengine.response.active.l;
import com.iqoption.core.microservices.tradingengine.response.b.b;
import io.reactivex.e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001a\u001a\u00020\u0004J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\nJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/asset/repository/TradingEngineRepository;", "", "()V", "DISPOSE_DELAY_MILLIS", "", "initializationDataCache", "Lcom/iqoption/asset/repository/UserIdStreamCache;", "Lcom/iqoption/core/microservices/tradingengine/response/active/ActiveSettingResult$ActiveSetting;", "instrumentCache", "Lcom/iqoption/asset/repository/UserIdStreamMapCache;", "Lcom/iqoption/core/data/model/InstrumentType;", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentsResult;", "leveragesCache", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeveragesResult;", "underlyingCache", "Lcom/iqoption/core/microservices/tradingengine/response/active/UnderlyingResult;", "createAvailableLeveragesStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "instrumentType", "createInstrumentsStream", "groupId", "isRegulated", "", "createUnderlyingStream", "getInitializationData", "Lio/reactivex/Flowable;", "userId", "observeAvailableLeverages", "observeInstruments", "observeUnderlying", "asset_release"})
/* compiled from: TradingEngineRepository.kt */
public final class f {
    private static final long aqO = TimeUnit.SECONDS.toMillis(10);
    private static g<a> aqP;
    private static h<InstrumentType, b> aqQ;
    private static h<InstrumentType, l> aqR;
    private static h<InstrumentType, j> aqS;
    public static final f aqT = new f();

    private f() {
    }

    public final e<b> i(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        h hVar = aqQ;
        if (hVar == null || hVar.getUserId() != j) {
            aqQ = new h(j, new ConcurrentHashMap());
        }
        h hVar2 = aqQ;
        if (hVar2 == null) {
            h.aXZ();
        }
        ConcurrentHashMap Ju = hVar2.Ju();
        if (Ju.get(instrumentType) == null) {
            Ju.put(instrumentType, u(instrumentType));
        }
        Object obj = Ju.get(instrumentType);
        if (obj == null) {
            h.aXZ();
        }
        return ((d) obj).Yg();
    }

    public final e<a> aF(long j) {
        g gVar = aqP;
        if (gVar == null || gVar.getUserId() != j) {
            e aWk = com.iqoption.core.microservices.tradingengine.a.aYp.Xe().aWk();
            h.d(aWk, "initial");
            aqP = new g(j, new d(aWk, aqO, null, 4, null));
        }
        g gVar2 = aqP;
        if (gVar2 == null) {
            h.aXZ();
        }
        return gVar2.Jv().Yg();
    }

    public final e<l> b(long j, long j2, boolean z, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        h hVar = aqR;
        if (hVar == null || hVar.getUserId() != j) {
            aqR = new h(j, new ConcurrentHashMap());
        }
        h hVar2 = aqR;
        if (hVar2 == null) {
            h.aXZ();
        }
        ConcurrentHashMap Ju = hVar2.Ju();
        if (Ju.get(instrumentType) == null) {
            Ju.put(instrumentType, a(j2, z, instrumentType));
        }
        Object obj = Ju.get(instrumentType);
        if (obj == null) {
            h.aXZ();
        }
        return ((d) obj).Yg();
    }

    public final e<j> c(long j, long j2, boolean z, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        h hVar = aqS;
        if (hVar == null || hVar.getUserId() != j) {
            aqS = new h(j, new ConcurrentHashMap());
        }
        h hVar2 = aqS;
        if (hVar2 == null) {
            h.aXZ();
        }
        ConcurrentHashMap Ju = hVar2.Ju();
        if (Ju.get(instrumentType) == null) {
            Ju.put(instrumentType, a(instrumentType, j2, z));
        }
        Object obj = Ju.get(instrumentType);
        if (obj == null) {
            h.aXZ();
        }
        return ((d) obj).Yg();
    }

    private final d<b> u(InstrumentType instrumentType) {
        e aWk = com.iqoption.core.microservices.tradingengine.a.aYp.y(instrumentType).aWk();
        e z = com.iqoption.core.microservices.tradingengine.a.aYp.z(instrumentType);
        h.d(aWk, "init");
        return new d(aWk, z, aqO, null, 8, null);
    }

    private final d<l> a(long j, boolean z, InstrumentType instrumentType) {
        e aWk = com.iqoption.core.microservices.tradingengine.a.aYp.A(instrumentType).aWk();
        e b = com.iqoption.core.microservices.tradingengine.a.aYp.b(j, z, instrumentType);
        h.d(aWk, "init");
        return new d(aWk, b, aqO, null, 8, null);
    }

    private final d<j> a(InstrumentType instrumentType, long j, boolean z) {
        e aWk = com.iqoption.core.microservices.tradingengine.a.aYp.B(instrumentType).aWk();
        e c = com.iqoption.core.microservices.tradingengine.a.aYp.c(j, z, instrumentType);
        h.d(aWk, "init");
        return new d(aWk, c, aqO, null, 8, null);
    }
}
