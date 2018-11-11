package com.iqoption.asset.repository;

import android.support.annotation.UiThread;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.h.d;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J:\u0010\u0013\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00170\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J:\u0010\u001a\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00170\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/asset/repository/RisksRepository;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "DISPOSE_DELAY", "", "TAG", "", "kotlin.jvm.PlatformType", "streamsCache", "Lcom/iqoption/asset/repository/RisksRepository$StreamsCache;", "clearOnLogout", "", "createCommissionsStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "userGroupId", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "createOvernightFeeStream", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "Lkotlin/collections/HashMap;", "observeCommissions", "Lio/reactivex/Flowable;", "observeOvernightFee", "StreamsCache", "asset_release"})
/* compiled from: RisksRepository.kt */
public final class c implements com.iqoption.core.f.a.a {
    private static final String TAG = "c";
    public static final c aqA;
    private static final a aqz = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0010J\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005J8\u0010\u0016\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\t0\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005RB\u0010\u0003\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004j\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006`\tX\u0004¢\u0006\u0002\n\u0000Rn\u0010\n\u001ab\u0012\u0004\u0012\u00020\u0005\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\t0\u00060\u0004j0\u0012\u0004\u0012\u00020\u0005\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\t0\u0006`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/asset/repository/RisksRepository$StreamsCache;", "", "()V", "streamsCommissionsMap", "Ljava/util/HashMap;", "Lcom/iqoption/core/data/model/InstrumentType;", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "Lkotlin/collections/HashMap;", "streamsOvernightFeeMap", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "userGroupId", "", "checkValidateCache", "", "_userGroupId", "clear", "getCommissionsStream", "Lio/reactivex/Flowable;", "instrumentType", "getOvernightFeeStream", "asset_release"})
    /* compiled from: RisksRepository.kt */
    private static final class a {
        private final HashMap<InstrumentType, d<List<com.iqoption.core.microservices.risks.response.a.a>>> aqB = new HashMap();
        private final HashMap<InstrumentType, d<HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d>>> aqC = new HashMap();
        private long aqq = -1;

        private final void aE(long j) {
            if (this.aqq != j) {
                this.aqq = j;
                this.aqB.clear();
                this.aqC.clear();
            }
        }

        public final e<List<com.iqoption.core.microservices.risks.response.a.a>> f(long j, InstrumentType instrumentType) {
            e<List<com.iqoption.core.microservices.risks.response.a.a>> Yg;
            h.e(instrumentType, "instrumentType");
            aE(j);
            if (this.aqB.get(instrumentType) == null) {
                this.aqB.put(instrumentType, c.aqA.c(j, instrumentType));
            }
            d dVar = (d) this.aqB.get(instrumentType);
            if (dVar != null) {
                Yg = dVar.Yg();
                if (Yg != null) {
                    return Yg;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.TAG);
            stringBuilder.append("-getCommissionsStream ");
            stringBuilder.append(instrumentType);
            Yg = e.R(new Throwable(stringBuilder.toString()));
            h.d(Yg, "Flowable.error(Throwable…Stream $instrumentType\"))");
            return Yg;
        }

        public final e<HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d>> g(long j, InstrumentType instrumentType) {
            e<HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d>> Yg;
            h.e(instrumentType, "instrumentType");
            aE(j);
            if (this.aqC.get(instrumentType) == null) {
                this.aqC.put(instrumentType, c.aqA.e(j, instrumentType));
            }
            d dVar = (d) this.aqC.get(instrumentType);
            if (dVar != null) {
                Yg = dVar.Yg();
                if (Yg != null) {
                    return Yg;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.TAG);
            stringBuilder.append("-getOvernightFeeStream ");
            stringBuilder.append(instrumentType);
            Yg = e.R(new Throwable(stringBuilder.toString()));
            h.d(Yg, "Flowable.error(Throwable…Stream $instrumentType\"))");
            return Yg;
        }

        public final void clear() {
            this.aqq = -1;
            this.aqB.clear();
            this.aqC.clear();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "it", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionsResult;", "apply"})
    /* compiled from: RisksRepository.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aqD = new b();

        b() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.risks.response.a.a> apply(com.iqoption.core.microservices.risks.response.a.b bVar) {
            h.e(bVar, "it");
            return bVar.WC();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "it", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeResult;", "apply"})
    /* compiled from: RisksRepository.kt */
    static final class c<T, R> implements f<T, R> {
        public static final c aqE = new c();

        c() {
        }

        /* renamed from: a */
        public final HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d> apply(com.iqoption.core.microservices.risks.response.overnightfee.e eVar) {
            h.e(eVar, "it");
            return eVar.WM();
        }
    }

    static {
        c cVar = new c();
        aqA = cVar;
        com.iqoption.core.f.a.a(cVar);
    }

    private c() {
    }

    @UiThread
    public final e<List<com.iqoption.core.microservices.risks.response.a.a>> b(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        return aqz.f(j, instrumentType);
    }

    private final d<List<com.iqoption.core.microservices.risks.response.a.a>> c(long j, InstrumentType instrumentType) {
        e aWk = com.iqoption.core.microservices.risks.a.aXt.j(j, instrumentType).n(b.aqD).aWk();
        e v = com.iqoption.core.microservices.risks.a.aXt.v(instrumentType);
        h.d(aWk, "init");
        return new com.iqoption.core.h.b(aWk, v, d.Jt(), 10000, TAG);
    }

    @UiThread
    public final e<HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d>> d(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        return aqz.g(j, instrumentType);
    }

    private final d<HashMap<Integer, com.iqoption.core.microservices.risks.response.overnightfee.d>> e(long j, InstrumentType instrumentType) {
        e d = com.iqoption.core.microservices.risks.a.aXt.k(j, instrumentType).aWk().d((f) c.aqE);
        h.d(d, "init");
        return new d(d, 10000, TAG);
    }

    public void Js() {
        aqz.clear();
    }
}
