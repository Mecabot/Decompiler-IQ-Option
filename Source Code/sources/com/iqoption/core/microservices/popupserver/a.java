package com.iqoption.core.microservices.popupserver;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/microservices/popupserver/PopupServerRequests;", "", "()V", "CMD_ADD_POPUP_EVENT", "", "CMD_GET_POPUPS", "EVENT_POPUP_ADDED", "EVENT_POPUP_DISABLED", "popupStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "getPopupStream", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "popupStream$delegate", "Lkotlin/Lazy;", "addPopupEvent", "Lio/reactivex/Completable;", "popupId", "", "eventName", "params", "Lorg/json/JSONObject;", "getPopupAddedUpdate", "Lio/reactivex/Flowable;", "getPopupDisabledUpdate", "getPopups", "Lio/reactivex/Single;", "Popups", "core_release"})
/* compiled from: PopupServerRequests.kt */
public final class a {
    private static final kotlin.d aWS = g.f(PopupServerRequests$popupStream$2.aWW);
    public static final a aWT = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "popupStream", "getPopupStream()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/popupserver/PopupServerRequests$Popups;", "", "popups", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "(Ljava/util/List;)V", "getPopups", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
    /* compiled from: PopupServerRequests.kt */
    public static final class a {
        @SerializedName("popups")
        private final List<com.iqoption.core.microservices.popupserver.response.a> aWU;

        public a() {
            this(null, 1, null);
        }

        /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aWU, ((com.iqoption.core.microservices.popupserver.a.a) r2).aWU) != false) goto L_0x0015;
     */
        public boolean equals(java.lang.Object r2) {
            /*
            r1 = this;
            if (r1 == r2) goto L_0x0015;
        L_0x0002:
            r0 = r2 instanceof com.iqoption.core.microservices.popupserver.a.a;
            if (r0 == 0) goto L_0x0013;
        L_0x0006:
            r2 = (com.iqoption.core.microservices.popupserver.a.a) r2;
            r0 = r1.aWU;
            r2 = r2.aWU;
            r2 = kotlin.jvm.internal.h.E(r0, r2);
            if (r2 == 0) goto L_0x0013;
        L_0x0012:
            goto L_0x0015;
        L_0x0013:
            r2 = 0;
            return r2;
        L_0x0015:
            r2 = 1;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.popupserver.a.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List list = this.aWU;
            return list != null ? list.hashCode() : 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Popups(popups=");
            stringBuilder.append(this.aWU);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(List<com.iqoption.core.microservices.popupserver.response.a> list) {
            h.e(list, "popups");
            this.aWU = list;
        }

        public /* synthetic */ a(List list, int i, f fVar) {
            if ((i & 1) != 0) {
                list = m.emptyList();
            }
            this(list);
        }

        public final List<com.iqoption.core.microservices.popupserver.response.a> Wq() {
            return this.aWU;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/popupserver/PopupServerRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<Object> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/popupserver/PopupServerRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<a> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "Lcom/iqoption/core/microservices/popupserver/PopupServerRequests$Popups;", "apply"})
    /* compiled from: PopupServerRequests.kt */
    static final class d<T, R> implements f<T, R> {
        public static final d aWV = new d();

        d() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.popupserver.response.a> apply(a aVar) {
            h.e(aVar, "it");
            return aVar.Wq();
        }
    }

    private a() {
    }

    public final o<List<com.iqoption.core.microservices.popupserver.response.a>> Wn() {
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        o<List<com.iqoption.core.microservices.popupserver.response.a>> n = com.iqoption.core.f.DS().a("get-popups", type).Sb().n(d.aWV);
        h.d(n, "requestBuilderFactory\n  …       .map { it.popups }");
        return n;
    }

    public final e<com.iqoption.core.microservices.popupserver.response.a> Wo() {
        return com.iqoption.core.f.DT().c("popup-added", com.iqoption.core.microservices.popupserver.response.a.class).Hr();
    }

    public final e<com.iqoption.core.microservices.popupserver.response.a> Wp() {
        return com.iqoption.core.f.DT().c("popup-disabled", com.iqoption.core.microservices.popupserver.response.a.class).Hr();
    }

    public static /* bridge */ /* synthetic */ io.reactivex.a a(a aVar, long j, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 4) != 0) {
            jSONObject = (JSONObject) null;
        }
        return aVar.a(j, str, jSONObject);
    }

    public final io.reactivex.a a(long j, String str, JSONObject jSONObject) {
        h.e(str, "eventName");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("popup_id", j);
        jSONObject2.put("event_name", str);
        if (jSONObject != null) {
            jSONObject2.put("params", jSONObject);
        }
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        io.reactivex.a aWj = com.iqoption.core.f.DS().a("add-popup-event", type).dF(0).m(jSONObject2).Sb().aWj();
        h.d(aWj, "requestBuilderFactory\n  …         .ignoreElement()");
        return aWj;
    }
}
