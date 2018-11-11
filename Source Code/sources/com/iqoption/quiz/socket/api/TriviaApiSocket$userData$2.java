package com.iqoption.quiz.socket.api;

import com.iqoption.quiz.api.response.o;
import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/quiz/api/response/UserResponse;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaApiSocket.kt */
final class TriviaApiSocket$userData$2 extends Lambda implements a<e<o>> {
    final /* synthetic */ c this$0;

    TriviaApiSocket$userData$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: Jr */
    public final e<o> invoke() {
        final o oVar = o.diV;
        e c = this.this$0.aCN().d((f) new f<T, R>() {
            /* renamed from: f */
            public final o apply(o oVar) {
                h.e(oVar, "it");
                o oVar2 = oVar;
                h.d(oVar2, "response");
                synchronized (oVar2) {
                    oVar = oVar.a(oVar);
                }
                return oVar;
            }
        }).c((b) this.this$0.aCO().d((f) new f<T, R>() {
            /* renamed from: f */
            public final o apply(o oVar) {
                h.e(oVar, "it");
                o oVar2 = oVar;
                h.d(oVar2, "response");
                synchronized (oVar2) {
                    oVar = oVar.a(oVar);
                }
                return oVar;
            }
        })).d((b) this.this$0.doa.d((f) new f<T, R>() {
            /* renamed from: f */
            public final o apply(o oVar) {
                h.e(oVar, "it");
                o oVar2 = oVar;
                h.d(oVar2, "response");
                synchronized (oVar2) {
                    oVar = oVar.a(oVar);
                }
                return oVar;
            }
        })).c(com.iqoption.core.h.i.Yo());
        h.d(c, "getUserDirect().map { sy…           .observeOn(bg)");
        com.iqoption.core.h.e eVar = new com.iqoption.core.h.e(c, 0, "get-user", 2, null);
        e g = this.this$0.Jq();
        h.d(g, "isConnectedStream");
        return eVar.c(g).Yg();
    }
}
