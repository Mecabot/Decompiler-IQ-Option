package com.iqoption.core.microservices.tradingengine;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.f;
import com.iqoption.core.microservices.tradingengine.response.active.j;
import com.iqoption.core.microservices.tradingengine.response.active.l;
import io.reactivex.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00182\u0006\u0010\"\u001a\u00020\u001bJ$\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u001bJ\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00182\u0006\u0010-\u001a\u00020%J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00182\u0006\u0010-\u001a\u00020%J\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bJ?\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000200030\u00182\u0006\u00104\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u000106¢\u0006\u0002\u00108J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00182\u0006\u0010\"\u001a\u00020\u001bJ$\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006<"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/TradingEngineRequests;", "", "()V", "CMD_GET_AVAILABLE_LEVERAGES", "", "CMD_GET_INITIALIZATION_DATA", "CMD_GET_INSTRUMENTS", "CMD_GET_ORDER", "CMD_GET_POSITION", "CMD_GET_POSITIONS", "CMD_GET_UNDERLYING_LIST", "EVENT_AVAILABLE_LEVERAGES_CHANGED", "EVENT_INSTRUMENTS_CHANGED", "EVENT_OPTION_QUOTE", "EVENT_ORDER_CHANGED", "EVENT_POSITION_CHANGED", "EVENT_UNDERLYING_LIST_CHANGED", "INSTRUMENT_TYPE", "IS_REGULATED", "MS_FX_QUOTES", "TRADING_INSTRUMENTS_FX_MICROSERVICE", "TYPE", "USER_GROUP_ID", "getAvailableLeverages", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeveragesResult;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getAvailableLeveragesUpdates", "Lio/reactivex/Flowable;", "getInitializationData", "Lcom/iqoption/core/microservices/tradingengine/response/active/ActiveSettingResult$ActiveSetting;", "getInstruments", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentsResult;", "type", "getInstrumentsUpdates", "userGroupId", "", "isRegulated", "", "getOptionQuotes", "Lcom/iqoption/core/microservices/tradingengine/response/OptionQuote;", "instrumentId", "getOrder", "Lcom/iqoption/core/microservices/tradingengine/response/order/Order;", "id", "getOrderUpdates", "getPosition", "Lcom/iqoption/core/microservices/tradingengine/response/position/Position;", "getPositionUpdates", "getPositions", "", "userBalanceId", "skip", "", "limit", "(JLcom/iqoption/core/data/model/InstrumentType;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "getUnderlyingList", "Lcom/iqoption/core/microservices/tradingengine/response/active/UnderlyingResult;", "getUnderlyingListUpdates", "core_release"})
/* compiled from: TradingEngineRequests.kt */
public final class a {
    public static final a aYp = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/tradingengine/TradingEngineRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.microservices.tradingengine.response.b.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/tradingengine/TradingEngineRequests$create$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<com.iqoption.core.microservices.tradingengine.response.active.e.a> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/tradingengine/TradingEngineRequests$create$$inlined$typeOf$3"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<j> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/tradingengine/TradingEngineRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class d extends TypeToken<l> {
    }

    private a() {
    }

    public final o<com.iqoption.core.microservices.tradingengine.response.b.b> y(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-available-leverages", type).gb("2.0").j("instrument_type", instrumentType).Sb();
    }

    public final e<com.iqoption.core.microservices.tradingengine.response.b.b> z(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        return f.DT().c("available-leverages-changed", com.iqoption.core.microservices.tradingengine.response.b.b.class).h("instrument_type", instrumentType).eT("2.0").Hr();
    }

    public final o<l> A(InstrumentType instrumentType) {
        h.e(instrumentType, Param.TYPE);
        String str = InstrumentType.FX_INSTRUMENT == instrumentType ? "trading-instruments-fx-option" : null;
        Type type = new d().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        o Sb = f.DS().a("get-underlying-list", type).cd(false).j(Param.TYPE, instrumentType).gc(str).Sb();
        com.iqoption.core.a.a.a.aMG.a(Sb, instrumentType);
        return Sb;
    }

    public final e<l> b(long j, boolean z, InstrumentType instrumentType) {
        h.e(instrumentType, Param.TYPE);
        return f.DT().c("underlying-list-changed", l.class).h(Param.TYPE, instrumentType).h("user_group_id", Long.valueOf(j)).h("is_regulated", Boolean.valueOf(z)).eU(InstrumentType.FX_INSTRUMENT == instrumentType ? "trading-instruments-fx-option" : null).eT("2.0").Hr();
    }

    public final o<j> B(InstrumentType instrumentType) {
        h.e(instrumentType, Param.TYPE);
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        o<j> Sb = f.DS().a("get-instruments", type).cd(false).gb("3.0").j(Param.TYPE, instrumentType).Sb();
        com.iqoption.core.a.a.a.aMG.b(Sb, instrumentType);
        return Sb;
    }

    public final e<j> c(long j, boolean z, InstrumentType instrumentType) {
        h.e(instrumentType, Param.TYPE);
        return f.DT().c("instruments-changed", j.class).h(Param.TYPE, instrumentType).h("user_group_id", Long.valueOf(j)).h("is_regulated", Boolean.valueOf(z)).eT("2.0").Hr();
    }

    public final o<com.iqoption.core.microservices.tradingengine.response.active.e.a> Xe() {
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-initialization-data", type).Sb();
    }
}
