package com.iqoption.core.microservices.f;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.f;
import io.reactivex.c.k;
import io.reactivex.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/microservices/topassets/TopAssetsRequests;", "", "()V", "CMD_GET_TOP_ASSETS", "", "EVENT_TOP_ASSETS_UPDATED", "INSTRUMENT_TYPE", "getTopAssetUpdates", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadDataResult;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getTopAssets", "Lio/reactivex/Single;", "core_release"})
/* compiled from: TopAssetsRequests.kt */
public final class a {
    public static final a aYf = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadDataResult;", "test"})
    /* compiled from: TopAssetsRequests.kt */
    static final class a<T> implements k<com.iqoption.core.microservices.f.a.a.b> {
        final /* synthetic */ InstrumentType aqa;

        a(InstrumentType instrumentType) {
            this.aqa = instrumentType;
        }

        /* renamed from: c */
        public final boolean test(com.iqoption.core.microservices.f.a.a.b bVar) {
            h.e(bVar, "it");
            return bVar.getInstrumentType() == this.aqa;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/topassets/TopAssetsRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<com.iqoption.core.microservices.f.a.a.b> {
    }

    private a() {
    }

    public final o<com.iqoption.core.microservices.f.a.a.b> w(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-top-assets", type).gb("1.2").j("instrument_type", instrumentType).Sb();
    }

    public final e<com.iqoption.core.microservices.f.a.a.b> x(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        e<com.iqoption.core.microservices.f.a.a.b> a = f.DT().c("top-assets-updated", com.iqoption.core.microservices.f.a.a.b.class).eT("1.2").h("instrument_type", instrumentType).Hr().a((k) new a(instrumentType));
        h.d(a, "eventBuilderFactory\n    …tType == instrumentType }");
        return a;
    }
}
