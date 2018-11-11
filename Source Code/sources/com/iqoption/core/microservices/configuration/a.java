package com.iqoption.core.microservices.configuration;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.microservices.configuration.a.c;
import com.iqoption.core.microservices.configuration.a.e;
import io.reactivex.c.f;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import okhttp3.Request.Builder;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150%0$2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0%0$J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0%0$J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0$2\u0006\u0010*\u001a\u00020+J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0%0$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000RW\u0010\u0012\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0016*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0014 \u0016*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0016*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0014\u0018\u00010\u00130\u00138FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018RW\u0010\u001b\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u0016*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00140\u0014 \u0016*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u0016*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00140\u0014\u0018\u00010\u00130\u00138FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001d\u0010\u0018RW\u0010\u001f\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020  \u0016*\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00140\u0014 \u0016*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020  \u0016*\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00140\u0014\u0018\u00010\u00130\u00138FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b!\u0010\u0018¨\u0006-"}, aXE = {"Lcom/iqoption/core/microservices/configuration/ConfigurationRequests;", "", "()V", "CMD_GET_ACTIVES_LIST", "", "CMD_GET_COUNTRIES_LIST", "CMD_GET_COUNTRIES_V3_HTTP", "CMD_GET_COUNTRY", "CMD_GET_CURRENCIES_LIST", "EVENT_ACTIVE_CREATED", "EVENT_ACTIVE_DELETED", "EVENT_ACTIVE_UPDATED", "EVENT_COUNTRY_CREATED", "EVENT_COUNTRY_DELETED", "EVENT_COUNTRY_UPDATED", "EVENT_CURRENCY_CREATED", "EVENT_CURRENCY_DELETED", "EVENT_CURRENCY_UPDATED", "activeUpdatesStream", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Active;", "kotlin.jvm.PlatformType", "getActiveUpdatesStream", "()Lio/reactivex/Flowable;", "activeUpdatesStream$delegate", "Lkotlin/Lazy;", "countryUpdatesStream", "Lcom/iqoption/core/microservices/configuration/response/Country;", "getCountryUpdatesStream", "countryUpdatesStream$delegate", "currencyUpdatesStream", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "getCurrencyUpdatesStream", "currencyUpdatesStream$delegate", "getActives", "Lio/reactivex/Single;", "", "instrumentType", "getCountries", "getCountriesHttp", "getCountry", "id", "", "getCurrencies", "core_release"})
/* compiled from: ConfigurationRequests.kt */
public final class a {
    private static final d aUw = g.f(ConfigurationRequests$activeUpdatesStream$2.aUA);
    private static final d aUx = g.f(ConfigurationRequests$currencyUpdatesStream$2.aUI);
    private static final d aUy = g.f(ConfigurationRequests$countryUpdatesStream$2.aUE);
    public static final a aUz = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "activeUpdatesStream", "getActiveUpdatesStream()Lio/reactivex/Flowable;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "currencyUpdatesStream", "getCurrencyUpdatesStream()Lio/reactivex/Flowable;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "countryUpdatesStream", "getCountryUpdatesStream()Lio/reactivex/Flowable;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/configuration/ConfigurationRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends c>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "it", "Lcom/iqoption/core/microservices/configuration/response/GetCurrenciesResponse;", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aUN = new b();

        b() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.configuration.a.d> apply(e eVar) {
            h.e(eVar, "it");
            return eVar.VF();
        }
    }

    public final io.reactivex.e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.d>> VB() {
        d dVar = aUx;
        j jVar = apP[1];
        return (io.reactivex.e) dVar.getValue();
    }

    public final io.reactivex.e<com.iqoption.core.microservices.a<c>> VD() {
        d dVar = aUy;
        j jVar = apP[2];
        return (io.reactivex.e) dVar.getValue();
    }

    private a() {
    }

    public final o<List<com.iqoption.core.microservices.configuration.a.d>> VA() {
        o<List<com.iqoption.core.microservices.configuration.a.d>> n = com.iqoption.core.f.DS().b("get-currencies-list", e.class).gb("4.0").Sb().n(b.aUN);
        h.d(n, "requestBuilderFactory\n  …   .map { it.currencies }");
        return n;
    }

    public final o<List<c>> VC() {
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("get-countries-list", type).Sb();
    }

    public final o<List<c>> SM() {
        Builder builder = new Builder();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.iqoption.core.f.RQ().Du().getClusterApi());
        stringBuilder.append("api/v3/countries");
        Builder builder2 = builder.url(stringBuilder.toString()).get();
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        h.d(builder2, "builder");
        return com.iqoption.core.connect.http.b.b(bVar, builder2, ConfigurationRequests$getCountriesHttp$1.aUM, null, null, 12, null);
    }
}
