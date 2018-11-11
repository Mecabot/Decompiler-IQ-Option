package com.iqoption.core.microservices.techinstruments;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.core.microservices.techinstruments.a.e;
import com.iqoption.dto.entity.position.Order;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001a0\u0014JP\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/TechInstrumentsRequests;", "", "()V", "CMD_ADD_TEMPLATE", "", "CMD_DELETE_TEMPLATE", "CMD_GET_STANDARD_LIBRARY", "CMD_GET_TEMPLATE", "CMD_GET_TEMPLATES", "CMD_REPLACE_ALL_TEMPLATES", "CMD_UPDATE_TEMPLATE", "EVENT_MODIFIED_TEMPLATES", "templateUpdates", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/techinstruments/response/ModifiedTemplates;", "getTemplateUpdates", "()Lio/reactivex/Flowable;", "templateUpdates$delegate", "Lkotlin/Lazy;", "addTemplate", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/techinstruments/response/Template;", "name", "chart", "Lcom/google/gson/JsonObject;", "indicators", "", "figures", "deleteTemplate", "Lio/reactivex/Completable;", "id", "", "getStandardLibrary", "Lcom/iqoption/core/microservices/techinstruments/response/StandardLibrary;", "version", "(Ljava/lang/Long;)Lio/reactivex/Single;", "getTemplate", "getTemplates", "updateTemplate", "core_release"})
/* compiled from: TechInstrumentsRequests.kt */
public final class a {
    private static final kotlin.d aXT = g.f(TechInstrumentsRequests$templateUpdates$2.aXW);
    public static final a aXU = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "templateUpdates", "getTemplateUpdates()Lio/reactivex/Flowable;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/techinstruments/TechInstrumentsRequests$create$$inlined$typeOf$3"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<e> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/techinstruments/TechInstrumentsRequests$create$$inlined$typeOf$5"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<com.iqoption.core.microservices.techinstruments.a.d> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/techinstruments/TechInstrumentsRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<List<? extends e>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/techinstruments/TechInstrumentsRequests$create$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class d extends TypeToken<e> {
    }

    public final io.reactivex.e<com.iqoption.core.microservices.techinstruments.a.c> WO() {
        kotlin.d dVar = aXT;
        j jVar = apP[0];
        return (io.reactivex.e) dVar.getValue();
    }

    private a() {
    }

    public final o<List<e>> WN() {
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-templates", type).j(Order.LIMIT, Integer.valueOf(100)).Sb();
    }

    public final o<e> a(String str, JsonObject jsonObject, List<JsonObject> list, List<JsonObject> list2) {
        h.e(str, "name");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("add-template", type).j("name", str).j("chart", jsonObject).j("indicators", list).j("figures", list2).Sb();
    }

    public final o<e> a(long j, String str, JsonObject jsonObject, List<JsonObject> list, List<JsonObject> list2) {
        Type type = new d().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("update-template", type).j("id", Long.valueOf(j)).j("name", str).j("chart", jsonObject).j("indicators", list).j("figures", list2).Sb();
    }

    public final io.reactivex.a aJ(long j) {
        io.reactivex.a aWj = f.DS().a("delete-template", (kotlin.jvm.a.b) TechInstrumentsRequests$deleteTemplate$1.aXV).j("template_id", Long.valueOf(j)).Sb().aWj();
        h.d(aWj, "requestBuilderFactory\n  …         .ignoreElement()");
        return aWj;
    }

    public final o<com.iqoption.core.microservices.techinstruments.a.d> n(Long l) {
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-standard-library", type).j("version", l).Sb();
    }
}
