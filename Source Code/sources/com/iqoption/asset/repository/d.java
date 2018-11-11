package com.iqoption.asset.repository;

import com.iqoption.core.microservices.risks.response.overnightfee.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, aXE = {"commissionIdentifier", "Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "getCommissionIdentifier", "()Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "overnightIdentifier", "Lcom/iqoption/core/util/MapUtils$Func2;", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeData;", "getOvernightIdentifier", "()Lcom/iqoption/core/util/MapUtils$Func2;", "asset_release"})
/* compiled from: RisksRepository.kt */
public final class d {
    private static final com.iqoption.core.h.b.a<com.iqoption.core.microservices.risks.response.a.a> aqF = new a();
    private static final com.iqoption.core.util.l.a<c, c, c> aqG = b.aqH;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, aXE = {"com/iqoption/asset/repository/RisksRepositoryKt$commissionIdentifier$1", "Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "areItemsTheSame", "", "first", "second", "asset_release"})
    /* compiled from: RisksRepository.kt */
    public static final class a implements com.iqoption.core.h.b.a<com.iqoption.core.microservices.risks.response.a.a> {
        a() {
        }

        /* renamed from: a */
        public boolean areItemsTheSame(com.iqoption.core.microservices.risks.response.a.a aVar, com.iqoption.core.microservices.risks.response.a.a aVar2) {
            h.e(aVar, "first");
            h.e(aVar2, "second");
            return aVar.getActiveId() == aVar2.getActiveId();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeData;", "kotlin.jvm.PlatformType", "oldValue", "newValue", "apply"})
    /* compiled from: RisksRepository.kt */
    static final class b<A, B, C> implements com.iqoption.core.util.l.a<c, c, c> {
        public static final b aqH = new b();

        b() {
        }

        /* renamed from: a */
        public final c apply(c cVar, c cVar2) {
            return cVar2;
        }
    }

    public static final com.iqoption.core.h.b.a<com.iqoption.core.microservices.risks.response.a.a> Jt() {
        return aqF;
    }
}
