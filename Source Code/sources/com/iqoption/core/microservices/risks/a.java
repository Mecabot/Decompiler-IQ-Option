package com.iqoption.core.microservices.risks;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.f;
import com.iqoption.core.microservices.risks.response.b.d;
import com.iqoption.core.microservices.risks.response.b.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u0012\u001a\u00020\u0013J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/risks/RisksRequests;", "", "()V", "ACTIVE_ID", "", "CMD_GET_COMMISSIONS", "CMD_GET_OVERNIGHT_FEE", "CMD_GET_SPREAD_MARKUPS", "EVENT_COMMISSION_CHANGED", "EVENT_OVERNIGHT_FEE_CHANGED", "EVENT_SPREAD_MARKUP_CHANGED", "INSTRUMENT_TYPE", "USER_GROUP_ID", "geSpreadMarkups", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkups;", "userGroupId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getCommissions", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionsResult;", "getCommissionsChanges", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "getOvernightFee", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeResult;", "getOvernightFeeChanges", "getSpreadMarkupChanges", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkupChanged;", "activeId", "core_release"})
/* compiled from: RisksRequests.kt */
public final class a {
    public static final a aXt = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/risks/RisksRequests$create$$inlined$typeOf$3"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<e> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/risks/RisksRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<com.iqoption.core.microservices.risks.response.a.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/risks/RisksRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<com.iqoption.core.microservices.risks.response.overnightfee.e> {
    }

    private a() {
    }

    public final o<com.iqoption.core.microservices.risks.response.a.b> j(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-commissions", type).gb("1.0").j("user_group_id", Long.valueOf(j)).j("instrument_type", instrumentType).Sb();
    }

    public final io.reactivex.e<com.iqoption.core.microservices.risks.response.a.a> v(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        return f.DT().c("commission-changed", com.iqoption.core.microservices.risks.response.a.a.class).eT("1.0").h("instrument_type", instrumentType).Hr();
    }

    public final o<com.iqoption.core.microservices.risks.response.overnightfee.e> k(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-overnight-fee", type).gb("1.0").j("user_group_id", Long.valueOf(j)).j("instrument_type", instrumentType).Sb();
    }

    public final o<e> l(long j, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-spread-markups", type).gb("1.0").j("user_group_id", Long.valueOf(j)).j("instrument_type", instrumentType).Sb();
    }

    public static /* synthetic */ io.reactivex.e a(a aVar, long j, InstrumentType instrumentType, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        return aVar.b(j, instrumentType, j2);
    }

    public final io.reactivex.e<d> b(long j, InstrumentType instrumentType, long j2) {
        h.e(instrumentType, "instrumentType");
        com.iqoption.core.connect.d h = f.DT().c("spread-markup-changed", d.class).eT("1.0").h("instrument_type", instrumentType).h("user_group_id", Long.valueOf(j));
        if (j2 != -1) {
            h.h("active_id", Long.valueOf(j2));
        }
        return h.Hr();
    }
}
