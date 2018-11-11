package com.iqoption.fragment.dialog.popup;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "invoke"})
/* compiled from: PopupViewModel.kt */
final class PopupViewModel$popupStream$2 extends Lambda implements kotlin.jvm.a.a<e<List<? extends com.iqoption.core.microservices.popupserver.response.a>>> {
    final /* synthetic */ PopupViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
    /* compiled from: PopupViewModel.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a cBw = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.popupserver.response.a> apply(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(1, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
    /* compiled from: PopupViewModel.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b cBx = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.popupserver.response.a> apply(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(3, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "it", "apply"})
    /* compiled from: PopupViewModel.kt */
    static final class c<T, R> implements f<T, R> {
        public static final c cBy = new c();

        c() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.popupserver.response.a> apply(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(3, aVar);
        }
    }

    PopupViewModel$popupStream$2(PopupViewModel popupViewModel) {
        this.this$0 = popupViewModel;
        super(0);
    }

    /* renamed from: Jr */
    public final e<List<com.iqoption.core.microservices.popupserver.response.a>> invoke() {
        h.d(com.iqoption.core.microservices.popupserver.a.aWT.Wo().d((f) a.cBw), "PopupServerRequests.getP…Event.TYPE_CREATED, it) }");
        h.d(com.iqoption.core.microservices.popupserver.a.aWT.Wp().d((f) c.cBy), "PopupServerRequests.getP…Event.TYPE_DELETED, it) }");
        h.d(this.this$0.cBo.d((f) b.cBx), "deleteSubject\n          …Event.TYPE_DELETED, it) }");
        com.iqoption.core.data.repository.c cVar = com.iqoption.core.data.repository.c.aOM;
        o Wn = com.iqoption.core.microservices.popupserver.a.aWT.Wn();
        e K = e.K(m.listOf(K, r1, r2));
        h.d(K, "Flowable.merge(listOf(cr…ionsByServer, deletions))");
        return cVar.a(Wn, K).Yg();
    }
}
