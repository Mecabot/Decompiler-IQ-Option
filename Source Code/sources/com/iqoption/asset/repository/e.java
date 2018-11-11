package com.iqoption.asset.repository;

import com.iqoption.core.data.model.InstrumentType;
import io.reactivex.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, aXE = {"Lcom/iqoption/asset/repository/TopAssetsRepository;", "", "()V", "streamCache", "Lcom/iqoption/asset/repository/TopAssetsRepository$StreamCache;", "valueMerger", "com/iqoption/asset/repository/TopAssetsRepository$valueMerger$1", "Lcom/iqoption/asset/repository/TopAssetsRepository$valueMerger$1;", "createTopAssetsStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "observeTopAssets", "Lio/reactivex/Flowable;", "userId", "", "StreamCache", "asset_release"})
/* compiled from: TopAssetsRepository.kt */
public final class e {
    private static a aqI;
    private static final d aqJ = new d();
    public static final e aqK = new e();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00070\u0005¢\u0006\u0002\u0010\u000bR/\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/asset/repository/TopAssetsRepository$StreamCache;", "", "userId", "", "streamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/iqoption/core/data/model/InstrumentType;", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "(JLjava/util/concurrent/ConcurrentHashMap;)V", "getStreamsMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getUserId", "()J", "asset_release"})
    /* compiled from: TopAssetsRepository.kt */
    private static final class a {
        private final ConcurrentHashMap<InstrumentType, com.iqoption.core.h.d<Map<Integer, com.iqoption.core.microservices.f.a.a.a>>> aqL;
        private final long userId;

        public a(long j, ConcurrentHashMap<InstrumentType, com.iqoption.core.h.d<Map<Integer, com.iqoption.core.microservices.f.a.a.a>>> concurrentHashMap) {
            h.e(concurrentHashMap, "streamsMap");
            this.userId = j;
            this.aqL = concurrentHashMap;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final ConcurrentHashMap<InstrumentType, com.iqoption.core.h.d<Map<Integer, com.iqoption.core.microservices.f.a.a.a>>> Ju() {
            return this.aqL;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "it", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadDataResult;", "apply"})
    /* compiled from: TopAssetsRepository.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aqM = new b();

        b() {
        }

        /* renamed from: b */
        public final Map<Integer, com.iqoption.core.microservices.f.a.a.a> apply(com.iqoption.core.microservices.f.a.a.b bVar) {
            h.e(bVar, "it");
            return bVar.Xd();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "it", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadDataResult;", "apply"})
    /* compiled from: TopAssetsRepository.kt */
    static final class c<T, R> implements f<T, R> {
        public static final c aqN = new c();

        c() {
        }

        /* renamed from: b */
        public final Map<Integer, com.iqoption.core.microservices.f.a.a.a> apply(com.iqoption.core.microservices.f.a.a.b bVar) {
            h.e(bVar, "it");
            return bVar.Xd();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/asset/repository/TopAssetsRepository$valueMerger$1", "Lcom/iqoption/core/rx/LiveStreamMapValueMergerSupplier$ValueMerger;", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "mergeValue", "old", "new", "asset_release"})
    /* compiled from: TopAssetsRepository.kt */
    public static final class d implements com.iqoption.core.h.c.a<com.iqoption.core.microservices.f.a.a.a> {
        d() {
        }

        /* renamed from: b */
        public com.iqoption.core.microservices.f.a.a.a A(com.iqoption.core.microservices.f.a.a.a aVar, com.iqoption.core.microservices.f.a.a.a aVar2) {
            if (aVar2 == null) {
                return aVar;
            }
            if (aVar != null) {
                com.iqoption.core.microservices.f.a.a.a.c WW = aVar2.WW();
                if (WW != null) {
                    aVar.a(WW);
                }
                WW = aVar2.WX();
                if (WW != null) {
                    aVar.b(WW);
                }
                WW = aVar2.WY();
                if (WW != null) {
                    aVar.c(WW);
                }
                WW = aVar2.Xa();
                if (WW != null) {
                    aVar.e(WW);
                }
                WW = aVar2.Xb();
                if (WW != null) {
                    aVar.f(WW);
                }
                WW = aVar2.Xc();
                if (WW != null) {
                    aVar.g(WW);
                }
            }
            return aVar2;
        }
    }

    private e() {
    }

    public final io.reactivex.e<Map<Integer, com.iqoption.core.microservices.f.a.a.a>> h(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        a aVar = aqI;
        if (aVar == null || aVar.getUserId() != j) {
            aqI = new a(j, new ConcurrentHashMap());
        }
        a aVar2 = aqI;
        if (aVar2 == null) {
            h.aXZ();
        }
        ConcurrentHashMap Ju = aVar2.Ju();
        if (Ju.get(instrumentType) == null) {
            Ju.put(instrumentType, t(instrumentType));
        }
        Object obj = Ju.get(instrumentType);
        if (obj == null) {
            h.aXZ();
        }
        return ((com.iqoption.core.h.d) obj).Yg();
    }

    private final com.iqoption.core.h.d<Map<Integer, com.iqoption.core.microservices.f.a.a.a>> t(InstrumentType instrumentType) {
        io.reactivex.e d = com.iqoption.core.microservices.f.a.aYf.w(instrumentType).aWk().d((f) b.aqM);
        io.reactivex.e d2 = com.iqoption.core.microservices.f.a.aYf.x(instrumentType).d((f) c.aqN);
        h.d(d, "init");
        h.d(d2, "update");
        com.iqoption.core.h.c.a aVar = aqJ;
        long toMillis = TimeUnit.SECONDS.toMillis(5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TopAssets:");
        stringBuilder.append(instrumentType);
        return new com.iqoption.core.h.c(d, d2, aVar, toMillis, stringBuilder.toString());
    }
}
