package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.core.ui.c;
import io.reactivex.c.f;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/SplashResponse;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSplashViewModel.kt */
final class TriviaSplashViewModel$splash$2 extends Lambda implements a<LiveData<c<com.iqoption.quiz.api.response.i>>> {
    final /* synthetic */ TriviaSplashViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/SplashResponse;", "t", "", "apply"})
    /* compiled from: TriviaSplashViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSplashViewModel$splash$2$2 */
    static final class AnonymousClass2<T, R> implements f<Throwable, c<com.iqoption.quiz.api.response.i>> {
        final /* synthetic */ TriviaSplashViewModel$splash$2 dno;

        AnonymousClass2(TriviaSplashViewModel$splash$2 triviaSplashViewModel$splash$2) {
            this.dno = triviaSplashViewModel$splash$2;
        }

        /* renamed from: t */
        public final c<com.iqoption.quiz.api.response.i> apply(Throwable th) {
            h.e(th, "t");
            this.dno.this$0.a(th, "getSplash");
            return c.a.a(c.baY, th, null, null, 6, null);
        }
    }

    TriviaSplashViewModel$splash$2(TriviaSplashViewModel triviaSplashViewModel) {
        this.this$0 = triviaSplashViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<c<com.iqoption.quiz.api.response.i>> invoke() {
        return LiveDataReactiveStreams.a(this.this$0.dgP.jk(TriviaSplashViewModel.dnl).d((f) AnonymousClass1.dnn).f(new AnonymousClass2(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
    }
}
