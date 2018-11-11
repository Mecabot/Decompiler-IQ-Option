package com.iqoption.asset.repository;

import com.iqoption.core.connect.bus.IQBusState;
import com.iqoption.core.data.model.InstrumentType;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0006R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00040\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/asset/repository/MarkupRepository;", "", "()V", "isConnectedStream", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/connect/bus/IQBusState;", "()Lio/reactivex/Flowable;", "isConnectedStream$delegate", "Lkotlin/Lazy;", "markupItemIdentifier", "com/iqoption/asset/repository/MarkupRepository$markupItemIdentifier$1", "Lcom/iqoption/asset/repository/MarkupRepository$markupItemIdentifier$1;", "streamsCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/iqoption/core/data/model/InstrumentType;", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "userGroupId", "", "clearStreamCacheIfNewUserGroup", "", "createMarkupStream", "instrumentType", "getMarkup", "", "activeId", "leverage", "", "getMarkupStreamByInstrument", "asset_release"})
/* compiled from: MarkupRepository.kt */
public final class b {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "isConnectedStream", "isConnectedStream()Lio/reactivex/Flowable;"))};
    private static long aqq = -1;
    private static final ConcurrentHashMap<InstrumentType, e<List<com.iqoption.core.microservices.risks.response.b.a>>> aqr = new ConcurrentHashMap();
    private static final d aqs = g.f(MarkupRepository$isConnectedStream$2.aqx);
    private static final c aqt = new c();
    public static final b aqu = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "it", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkupChanged;", "apply"})
    /* compiled from: MarkupRepository.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a aqv = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.risks.response.b.a apply(com.iqoption.core.microservices.risks.response.b.d dVar) {
            h.e(dVar, "it");
            return dVar.WI();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "it", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkups;", "apply"})
    /* compiled from: MarkupRepository.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aqw = new b();

        b() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.risks.response.b.a> apply(com.iqoption.core.microservices.risks.response.b.e eVar) {
            h.e(eVar, "it");
            return (((Collection) eVar.getItems()).isEmpty() ^ 1) != 0 ? ((com.iqoption.core.microservices.risks.response.b.b) eVar.getItems().get(0)).Jj() : m.emptyList();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, aXE = {"com/iqoption/asset/repository/MarkupRepository$markupItemIdentifier$1", "Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "areItemsTheSame", "", "first", "second", "asset_release"})
    /* compiled from: MarkupRepository.kt */
    public static final class c implements com.iqoption.core.h.b.a<com.iqoption.core.microservices.risks.response.b.a> {
        c() {
        }

        /* renamed from: a */
        public boolean areItemsTheSame(com.iqoption.core.microservices.risks.response.b.a aVar, com.iqoption.core.microservices.risks.response.b.a aVar2) {
            h.e(aVar, "first");
            h.e(aVar2, "second");
            return aVar.WF() == aVar2.WF();
        }
    }

    private final e<IQBusState> Jq() {
        d dVar = aqs;
        j jVar = apP[0];
        return (e) dVar.getValue();
    }

    private b() {
    }

    private final e<List<com.iqoption.core.microservices.risks.response.b.a>> a(long j, InstrumentType instrumentType) {
        e d = com.iqoption.core.microservices.risks.a.aXt.l(j, instrumentType).aWk().d((f) b.aqw);
        h.d(d, "RisksRequests.geSpreadMa…].actives else listOf() }");
        e d2 = com.iqoption.core.microservices.risks.a.a(com.iqoption.core.microservices.risks.a.aXt, j, instrumentType, 0, 4, null).d((f) a.aqv);
        h.d(d2, "RisksRequests.getSpreadM…  .map { it.getActive() }");
        return new com.iqoption.core.h.e(new com.iqoption.core.h.b(d, d2, aqt, 0, "spread-markups (merge)", 8, null), "spread-markups").c(Jq()).Yg();
    }

    public final e<List<com.iqoption.core.microservices.risks.response.b.a>> a(InstrumentType instrumentType, long j) {
        h.e(instrumentType, "instrumentType");
        if (aqq != j) {
            aD(j);
        }
        e<List<com.iqoption.core.microservices.risks.response.b.a>> eVar = (e) aqr.get(instrumentType);
        if (eVar != null) {
            return eVar;
        }
        e<List<com.iqoption.core.microservices.risks.response.b.a>> eVar2;
        synchronized (aqr) {
            e<List<com.iqoption.core.microservices.risks.response.b.a>> eVar3 = (e) aqr.get(instrumentType);
            if (eVar3 != null) {
                eVar2 = eVar3;
            } else {
                eVar2 = aqu.a(j, instrumentType).aWd();
                Map map = aqr;
                h.d(eVar2, "it");
                map.put(instrumentType, eVar2);
            }
        }
        h.d(eVar2, "synchronized(streamsCach…              }\n        }");
        return eVar2;
    }

    private final void aD(long j) {
        synchronized (aqr) {
            if (aqq != j) {
                aqq = j;
                aqr.clear();
            }
            l lVar = l.etX;
        }
    }
}
