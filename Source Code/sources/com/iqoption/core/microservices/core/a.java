package com.iqoption.core.microservices.core;

import android.net.Uri;
import com.google.gson.JsonObject;
import com.iqoption.core.f;
import com.iqoption.core.microservices.core.a.b;
import com.iqoption.core.microservices.core.a.c;
import io.reactivex.o;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.FormBody;
import okhttp3.Request.Builder;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0004J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/core/CoreRequests;", "", "()V", "API_COUNT_ONLINE", "", "API_CURRENCIES", "API_GET_MY_COUNTRY", "API_LOCALIZATION", "API_REGULATION", "API_TERMS", "getLocalization", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/core/response/LocalizationResponse;", "version", "getMyCountry", "Lcom/iqoption/core/microservices/core/response/MyCountryResponse;", "apiKey", "getOnlineCount", "Lcom/iqoption/core/microservices/core/response/OnlineCountResponses;", "getRegistrationCurrencies", "Lcom/iqoption/core/microservices/core/response/RegistrationCurrenciesResponse;", "getRegulation", "Lcom/iqoption/core/microservices/core/response/RegulationResponse;", "getTerms", "Lcom/google/gson/JsonObject;", "termsArg", "core_release"})
/* compiled from: CoreRequests.kt */
public final class a {
    public static final a aVw = new a();

    private a() {
    }

    public final o<b> VG() {
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        Builder a = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Builder(), null, 1, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.iqoption.core.connect.config.b.Sf().Sd());
        stringBuilder.append("api/users-stat");
        a = a.url(stringBuilder.toString()).get();
        h.d(a, "Request.Builder().accept…+ API_COUNT_ONLINE).get()");
        return com.iqoption.core.connect.http.b.b(bVar, a, CoreRequests$getOnlineCount$1.aVy, null, null, 12, null);
    }

    public final o<JsonObject> gB(String str) {
        h.e(str, "termsArg");
        FormBody build = new FormBody.Builder().addEncoded("key", str).addEncoded("lang", f.getLocale()).build();
        Builder a = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Builder(), null, 1, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.iqoption.core.connect.config.b.Sf().Sd());
        stringBuilder.append("api/article/get");
        Builder post = a.url(stringBuilder.toString()).post(build);
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        h.d(post, "builder");
        return com.iqoption.core.connect.http.b.b(bVar, post, CoreRequests$getTerms$1.aVA, null, null, 12, null);
    }

    public final o<c> VH() {
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        Builder a = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Builder(), null, 1, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.iqoption.core.connect.config.b.Sf().Sd());
        stringBuilder.append("api/v2/currencies");
        a = a.url(stringBuilder.toString()).get();
        h.d(a, "Request.Builder().accept…i + API_CURRENCIES).get()");
        return com.iqoption.core.connect.http.b.b(bVar, a, CoreRequests$getRegistrationCurrencies$1.aVz, null, null, 12, null);
    }

    public final o<com.iqoption.core.microservices.core.a.a> gn(String str) {
        h.e(str, "apiKey");
        Uri.Builder builder = new Uri.Builder();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.RQ().Du().getClusterApi());
        stringBuilder.append("api/geoip/getmycountry");
        Uri build = builder.encodedPath(stringBuilder.toString()).appendQueryParameter("geokey", str).build();
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        Builder builder2 = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Builder(), null, 1, null).url(build.toString()).get();
        h.d(builder2, "Request.Builder().accept…url(uri.toString()).get()");
        return com.iqoption.core.connect.http.b.b(bVar, builder2, CoreRequests$getMyCountry$1.aVx, null, null, 12, null);
    }
}
