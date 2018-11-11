package com.iqoption.core.microservices.popupserver;

import com.iqoption.core.data.repository.c;
import com.iqoption.core.h.d;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "invoke"})
/* compiled from: PopupServerRequests.kt */
final class PopupServerRequests$popupStream$2 extends Lambda implements kotlin.jvm.a.a<d<List<? extends com.iqoption.core.microservices.popupserver.response.a>>> {
    public static final PopupServerRequests$popupStream$2 aWW = new PopupServerRequests$popupStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
    /* compiled from: PopupServerRequests.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a aWX = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.popupserver.response.a> apply(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(1, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
    /* compiled from: PopupServerRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aWY = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.popupserver.response.a> apply(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(3, aVar);
        }
    }

    PopupServerRequests$popupStream$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<List<com.iqoption.core.microservices.popupserver.response.a>> invoke() {
        h.d(a.aWT.Wo().d((f) a.aWX), "getPopupAddedUpdate()\n  …Event.TYPE_CREATED, it) }");
        h.d(a.aWT.Wp().d((f) b.aWY), "getPopupDisabledUpdate()…Event.TYPE_DELETED, it) }");
        c cVar = c.aOM;
        o Wn = a.aWT.Wn();
        e K = e.K(m.listOf(K, r1));
        h.d(K, "Flowable.merge(listOf(creations, deletions))");
        return cVar.a(Wn, K);
    }
}
