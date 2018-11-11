package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.core.ui.c;
import io.reactivex.c.f;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/LifeResponse;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$lifeCount$2 extends Lambda implements a<LiveData<c<com.iqoption.quiz.api.response.c>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/LifeResponse;", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$lifeCount$2$2 */
    static final class AnonymousClass2<T, R> implements f<Throwable, c<com.iqoption.quiz.api.response.c>> {
        final /* synthetic */ TriviaSocketViewModel$lifeCount$2 dmS;

        AnonymousClass2(TriviaSocketViewModel$lifeCount$2 triviaSocketViewModel$lifeCount$2) {
            this.dmS = triviaSocketViewModel$lifeCount$2;
        }

        /* renamed from: t */
        public final c<com.iqoption.quiz.api.response.c> apply(Throwable th) {
            h.e(th, "t");
            this.dmS.this$0.a(th, "getStatus");
            return c.a.a(c.baY, th, null, null, 6, null);
        }
    }

    TriviaSocketViewModel$lifeCount$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<c<com.iqoption.quiz.api.response.c>> invoke() {
        return LiveDataReactiveStreams.a(this.this$0.dli.jj("").d((f) AnonymousClass1.dmR).f(new AnonymousClass2(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
    }
}
