package com.iqoption.core.data.repository;

import io.reactivex.e;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0013J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00142\u0006\u0010\u0015\u001a\u00020\u0016R5\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/data/repository/BalanceRepository;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "balancesStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "kotlin.jvm.PlatformType", "getBalancesStream", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "balancesStream$delegate", "Lkotlin/Lazy;", "clearOnLogout", "", "getBalance", "Lio/reactivex/Maybe;", "id", "", "getBalances", "Lio/reactivex/Flowable;", "Lio/reactivex/Single;", "type", "", "core_release"})
/* compiled from: BalanceRepository.kt */
public final class a implements com.iqoption.core.f.a.a {
    private static final d aOF = g.f(BalanceRepository$balancesStream$2.aOH);
    public static final a aOG;
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "balancesStream", "getBalancesStream()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};

    private final com.iqoption.core.h.d<List<com.iqoption.core.microservices.internalbilling.a.a>> SJ() {
        d dVar = aOF;
        j jVar = apP[0];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    static {
        a aVar = new a();
        aOG = aVar;
        com.iqoption.core.f.a.a(aVar);
    }

    private a() {
    }

    public void Js() {
        com.iqoption.core.h.d.a(SJ(), null, 1, null);
    }

    public final e<List<com.iqoption.core.microservices.internalbilling.a.a>> SK() {
        return SJ().Yg();
    }
}
