package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: QuizInsightsViewModel.kt */
final class QuizInsightsViewModel$insights$2 extends Lambda implements a<LiveData<List<? extends f>>> {
    final /* synthetic */ QuizInsightsViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012(\u0010\u0005\u001a$\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u00070\u00020\u0006H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "kotlin.jvm.PlatformType", "it", "", "Lcom/iqoption/quiz/api/response/InsightResponse;", "apply"})
    /* compiled from: QuizInsightsViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.QuizInsightsViewModel$insights$2$1 */
    static final class AnonymousClass1<T, R> implements f<T, b<? extends R>> {
        final /* synthetic */ QuizInsightsViewModel$insights$2 dlN;

        AnonymousClass1(QuizInsightsViewModel$insights$2 quizInsightsViewModel$insights$2) {
            this.dlN = quizInsightsViewModel$insights$2;
        }

        /* renamed from: J */
        public final e<List<f>> apply(List<com.iqoption.quiz.api.response.b> list) {
            h.e(list, "it");
            return this.dlN.this$0.ba(list).d((f) AnonymousClass1.dlO);
        }
    }

    QuizInsightsViewModel$insights$2(QuizInsightsViewModel quizInsightsViewModel) {
        this.this$0 = quizInsightsViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<List<f>> invoke() {
        e bW = e.bW(m.listOf(i.dlE, h.dlD));
        com.iqoption.quiz.api.b a = this.this$0.dli;
        h.d(a, "quizApi");
        return LiveDataReactiveStreams.a(bW.c((b) a.aAd().a((f) new AnonymousClass1(this)).f(AnonymousClass2.dlP).c(com.iqoption.core.h.i.Yo())).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
    }
}
