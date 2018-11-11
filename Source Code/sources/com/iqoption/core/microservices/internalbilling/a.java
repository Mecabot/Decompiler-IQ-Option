package com.iqoption.core.microservices.internalbilling;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import io.reactivex.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000RW\u0010\t\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \b*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b \b*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \b*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0018\u00010\n0\n8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/microservices/internalbilling/InternalBillingRequests;", "", "()V", "CMD_GET_BALANCES", "", "EVENT_BALANCE_CHANGED", "EVENT_BALANCE_CREATED", "TAG", "kotlin.jvm.PlatformType", "balanceUpdatesStream", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "getBalanceUpdatesStream", "()Lio/reactivex/Flowable;", "balanceUpdatesStream$delegate", "Lkotlin/Lazy;", "getBalances", "Lio/reactivex/Single;", "", "core_release"})
/* compiled from: InternalBillingRequests.kt */
public final class a {
    private static final String TAG = "a";
    private static final d aWh = g.f(InternalBillingRequests$balanceUpdatesStream$2.aWj);
    public static final a aWi = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "balanceUpdatesStream", "getBalanceUpdatesStream()Lio/reactivex/Flowable;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/internalbilling/InternalBillingRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends com.iqoption.core.microservices.internalbilling.a.a>> {
    }

    public final e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a>> VY() {
        d dVar = aWh;
        j jVar = apP[0];
        return (e) dVar.getValue();
    }

    private a() {
    }

    public final o<List<com.iqoption.core.microservices.internalbilling.a.a>> VX() {
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-balances", type).Sb();
    }
}
