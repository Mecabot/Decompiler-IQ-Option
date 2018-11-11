package com.iqoption.core.microservices.livedeals;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.connect.k;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.event.OtnEmissionExecuted;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u0010J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u0010J\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/LiveDealsRequests;", "", "()V", "CMD_GET_TOP_DEALS", "", "CMD_GET_TOP_DEALS_BINARY_OPTION", "CMD_GET_TOP_DEALS_DIGITAL_OPTION", "CMD_GET_TOP_DEALS_FX_OPTION", "EVENT_LIVE_DEAL", "EVENT_LIVE_DEAL_BINARY_OPTION_PLACED", "EVENT_LIVE_DEAL_DIGITAL_OPTION", "EVENT_LIVE_DEAL_FX_OPTION", "getLiveDealBOUpdates", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "params", "Lcom/iqoption/core/microservices/livedeals/params/LiveDealsParams;", "getLiveDealDigitalUpdates", "liveDealsParams", "getLiveDealFxUpdates", "getLiveDealUpdates", "getTopDeals", "Lio/reactivex/Single;", "", "getTopDealsBO", "getTopDealsDigital", "getTopDealsFx", "core_release"})
/* compiled from: LiveDealsRequests.kt */
public final class a {
    public static final a aWC = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/livedeals/LiveDealsRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.microservices.livedeals.response.instrument.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/livedeals/response/instrument/LiveDealInstrument;", "response", "Lcom/iqoption/core/microservices/livedeals/response/instrument/TopDealsInstrumentResponse;", "apply"})
    /* compiled from: LiveDealsRequests.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, R> {
        public static final b aWD = new b();

        b() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.livedeals.response.instrument.a> apply(com.iqoption.core.microservices.livedeals.response.instrument.b bVar) {
            kotlin.jvm.internal.h.e(bVar, "response");
            Iterable<com.iqoption.core.microservices.livedeals.response.instrument.a> Wm = bVar.Wm();
            Collection arrayList = new ArrayList(n.e(Wm, 10));
            for (com.iqoption.core.microservices.livedeals.response.instrument.a a : Wm) {
                arrayList.add(com.iqoption.core.microservices.livedeals.response.instrument.a.a(a, 0, null, null, 0.0d, 0, 0, null, 0, null, null, Boolean.valueOf(true), null, 3071, null));
            }
            return u.W((List) arrayList);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/livedeals/LiveDealsRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<com.iqoption.core.microservices.livedeals.response.a.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/livedeals/response/bo/LiveDealBO;", "response", "Lcom/iqoption/core/microservices/livedeals/response/bo/TopDealsBOResponse;", "apply"})
    /* compiled from: LiveDealsRequests.kt */
    static final class d<T, R> implements io.reactivex.c.f<T, R> {
        public static final d aWE = new d();

        d() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.livedeals.response.a.a> apply(com.iqoption.core.microservices.livedeals.response.a.b bVar) {
            kotlin.jvm.internal.h.e(bVar, "response");
            Iterable<com.iqoption.core.microservices.livedeals.response.a.a> Wm = bVar.Wm();
            Collection arrayList = new ArrayList(n.e(Wm, 10));
            for (com.iqoption.core.microservices.livedeals.response.a.a a : Wm) {
                arrayList.add(com.iqoption.core.microservices.livedeals.response.a.a.a(a, 0, null, null, null, 0.0d, 0, 0, 0, null, 0, null, null, Boolean.valueOf(true), 4095, null));
            }
            return u.W((List) arrayList);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/livedeals/LiveDealsRequests$create$$inlined$typeOf$3"})
    /* compiled from: GsonExtensions.kt */
    public static final class e extends TypeToken<com.iqoption.core.microservices.livedeals.response.b.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/livedeals/response/digital/LiveDealDigital;", "response", "Lcom/iqoption/core/microservices/livedeals/response/digital/TopDealsDigitalResponse;", "apply"})
    /* compiled from: LiveDealsRequests.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        public static final f aWF = new f();

        f() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.livedeals.response.b.a> apply(com.iqoption.core.microservices.livedeals.response.b.b bVar) {
            kotlin.jvm.internal.h.e(bVar, "response");
            Iterable<com.iqoption.core.microservices.livedeals.response.b.a> Wm = bVar.Wm();
            Collection arrayList = new ArrayList(n.e(Wm, 10));
            for (com.iqoption.core.microservices.livedeals.response.b.a a : Wm) {
                arrayList.add(com.iqoption.core.microservices.livedeals.response.b.a.a(a, 0, null, null, 0.0d, 0, 0, null, 0, null, 0, null, null, Boolean.valueOf(true), 4095, null));
            }
            return u.W((List) arrayList);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/livedeals/LiveDealsRequests$create$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class g extends TypeToken<com.iqoption.core.microservices.livedeals.response.c.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/livedeals/response/fx/LiveDealFx;", "response", "Lcom/iqoption/core/microservices/livedeals/response/fx/TopDealsFxResponse;", "apply"})
    /* compiled from: LiveDealsRequests.kt */
    static final class h<T, R> implements io.reactivex.c.f<T, R> {
        public static final h aWG = new h();

        h() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.livedeals.response.c.a> apply(com.iqoption.core.microservices.livedeals.response.c.b bVar) {
            kotlin.jvm.internal.h.e(bVar, "response");
            Iterable<com.iqoption.core.microservices.livedeals.response.c.a> Wm = bVar.Wm();
            Collection arrayList = new ArrayList(n.e(Wm, 10));
            for (com.iqoption.core.microservices.livedeals.response.c.a a : Wm) {
                arrayList.add(com.iqoption.core.microservices.livedeals.response.c.a.a(a, 0, null, null, 0.0d, 0, 0, null, 0, null, 0, null, null, Boolean.valueOf(true), 4095, null));
            }
            return u.W((List) arrayList);
        }
    }

    private a() {
    }

    public final o<List<com.iqoption.core.microservices.livedeals.response.a>> a(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "liveDealsParams");
        Object instrumentType = cVar.getInstrumentType();
        if (com.iqoption.core.ext.c.b(instrumentType, InstrumentType.CFD_INSTRUMENT, InstrumentType.FOREX_INSTRUMENT, InstrumentType.CRYPTO_INSTRUMENT)) {
            com.iqoption.core.microservices.livedeals.a.b bVar = (com.iqoption.core.microservices.livedeals.a.b) cVar;
            Type type = new a().getType();
            kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
            k j = com.iqoption.core.f.DS().a("get-top-deals", type).gb("1.0").j("instrument_active_id", Integer.valueOf(bVar.getActiveId())).j("instrument_type", instrumentType).j("from", bVar.Wf()).j("to", bVar.Wg());
            Integer count = bVar.getCount();
            if (count != null) {
                j.j(OtnEmissionExecuted.COUNT, Integer.valueOf(count.intValue()));
            }
            o<List<com.iqoption.core.microservices.livedeals.response.a>> n = j.Sb().n(b.aWD);
            kotlin.jvm.internal.h.d(n, "builder\n                …sBig = true) }.toList() }");
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected instrument type: ");
        stringBuilder.append(instrumentType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final io.reactivex.e<? extends com.iqoption.core.microservices.livedeals.response.a> b(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "params");
        Object instrumentType = cVar.getInstrumentType();
        if (com.iqoption.core.ext.c.b(instrumentType, InstrumentType.CFD_INSTRUMENT, InstrumentType.FOREX_INSTRUMENT, InstrumentType.CRYPTO_INSTRUMENT)) {
            return com.iqoption.core.f.DT().c("live-deal", com.iqoption.core.microservices.livedeals.response.instrument.a.class).eT("1.0").h("instrument_active_id", Integer.valueOf(cVar.getActiveId())).h("instrument_type", instrumentType).Hr();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected instrument type: ");
        stringBuilder.append(instrumentType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final o<List<com.iqoption.core.microservices.livedeals.response.a>> c(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "params");
        Object instrumentType = cVar.getInstrumentType();
        if (com.iqoption.core.ext.c.b(instrumentType, InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT)) {
            Type type = new c().getType();
            kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
            o<List<com.iqoption.core.microservices.livedeals.response.a>> n = com.iqoption.core.f.DS().a("get-top-deals-binary-option", type).gb("1.0").j("active_id", Integer.valueOf(cVar.getActiveId())).j("option_type", instrumentType.toOptionActiveType()).Sb().n(d.aWE);
            kotlin.jvm.internal.h.d(n, "requestBuilderFactory\n  …sBig = true) }.toList() }");
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected instrument type: ");
        stringBuilder.append(instrumentType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final io.reactivex.e<? extends com.iqoption.core.microservices.livedeals.response.a> d(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "params");
        Object instrumentType = cVar.getInstrumentType();
        if (com.iqoption.core.ext.c.b(instrumentType, InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT)) {
            return com.iqoption.core.f.DT().c("live-deal-binary-option-placed", com.iqoption.core.microservices.livedeals.response.a.a.class).eT("1.0").h("active_id", Integer.valueOf(cVar.getActiveId())).h("option_type", instrumentType.toOptionActiveType()).Hr();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected instrument type: ");
        stringBuilder.append(instrumentType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final o<List<com.iqoption.core.microservices.livedeals.response.a>> e(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "liveDealsParams");
        InstrumentType instrumentType = cVar.getInstrumentType();
        if (instrumentType != InstrumentType.DIGITAL_INSTRUMENT) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected instrument type: ");
            stringBuilder.append(instrumentType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        com.iqoption.core.microservices.livedeals.a.a aVar = (com.iqoption.core.microservices.livedeals.a.a) cVar;
        Type type = new e().getType();
        kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
        o<List<com.iqoption.core.microservices.livedeals.response.a>> n = com.iqoption.core.f.DS().a("get-top-deals-digital-option", type).gb("1.0").j("instrument_active_id", Integer.valueOf(aVar.getActiveId())).j("expiration_type", aVar.We()).Sb().n(f.aWF);
        kotlin.jvm.internal.h.d(n, "requestBuilderFactory\n  …sBig = true) }.toList() }");
        return n;
    }

    public final io.reactivex.e<? extends com.iqoption.core.microservices.livedeals.response.a> f(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "liveDealsParams");
        InstrumentType instrumentType = cVar.getInstrumentType();
        if (instrumentType != InstrumentType.DIGITAL_INSTRUMENT) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected instrument type: ");
            stringBuilder.append(instrumentType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        com.iqoption.core.microservices.livedeals.a.a aVar = (com.iqoption.core.microservices.livedeals.a.a) cVar;
        return com.iqoption.core.f.DT().c("live-deal-digital-option", com.iqoption.core.microservices.livedeals.response.b.a.class).eT("1.0").h("instrument_active_id", Integer.valueOf(aVar.getActiveId())).h("expiration_type", aVar.We()).Hr();
    }

    public final o<List<com.iqoption.core.microservices.livedeals.response.a>> g(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "liveDealsParams");
        InstrumentType instrumentType = cVar.getInstrumentType();
        if (instrumentType != InstrumentType.FX_INSTRUMENT) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected instrument type: ");
            stringBuilder.append(instrumentType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        com.iqoption.core.microservices.livedeals.a.a aVar = (com.iqoption.core.microservices.livedeals.a.a) cVar;
        Type type = new g().getType();
        kotlin.jvm.internal.h.d(type, "object : TypeToken<T>() {}.type");
        o<List<com.iqoption.core.microservices.livedeals.response.a>> n = com.iqoption.core.f.DS().a("get-top-deals-fx-option", type).gb("1.0").j("instrument_active_id", Integer.valueOf(aVar.getActiveId())).j("expiration_type", aVar.We()).Sb().n(h.aWG);
        kotlin.jvm.internal.h.d(n, "requestBuilderFactory\n  …sBig = true) }.toList() }");
        return n;
    }

    public final io.reactivex.e<? extends com.iqoption.core.microservices.livedeals.response.a> h(com.iqoption.core.microservices.livedeals.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "liveDealsParams");
        InstrumentType instrumentType = cVar.getInstrumentType();
        if (instrumentType != InstrumentType.FX_INSTRUMENT) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected instrument type: ");
            stringBuilder.append(instrumentType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        com.iqoption.core.microservices.livedeals.a.a aVar = (com.iqoption.core.microservices.livedeals.a.a) cVar;
        return com.iqoption.core.f.DT().c("live-deal-fx-option", com.iqoption.core.microservices.livedeals.response.c.a.class).eT("1.0").h("instrument_active_id", Integer.valueOf(aVar.getActiveId())).h("expiration_type", aVar.We()).Hr();
    }
}
