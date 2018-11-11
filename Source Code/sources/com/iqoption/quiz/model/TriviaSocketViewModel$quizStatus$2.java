package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.core.ui.c;
import com.iqoption.quiz.api.response.k;
import com.iqoption.quiz.m;
import io.reactivex.c.f;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/StatusResponse;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$quizStatus$2 extends Lambda implements a<LiveData<c<k>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/StatusResponse;", "it", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$quizStatus$2$1 */
    static final class AnonymousClass1<T, R> implements f<T, R> {
        final /* synthetic */ TriviaSocketViewModel$quizStatus$2 dmZ;

        AnonymousClass1(TriviaSocketViewModel$quizStatus$2 triviaSocketViewModel$quizStatus$2) {
            this.dmZ = triviaSocketViewModel$quizStatus$2;
        }

        /* renamed from: a */
        public final c<k> apply(k kVar) {
            h.e(kVar, "it");
            this.dmZ.this$0.wv.edit().putString("c5c7ewrefq7593423a", m.ayY().azm().toJson((Object) kVar)).apply();
            return c.baY.bm(kVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/StatusResponse;", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$quizStatus$2$2 */
    static final class AnonymousClass2<T, R> implements f<Throwable, c<k>> {
        final /* synthetic */ TriviaSocketViewModel$quizStatus$2 dmZ;

        AnonymousClass2(TriviaSocketViewModel$quizStatus$2 triviaSocketViewModel$quizStatus$2) {
            this.dmZ = triviaSocketViewModel$quizStatus$2;
        }

        /* renamed from: t */
        public final c<k> apply(Throwable th) {
            h.e(th, "t");
            this.dmZ.this$0.a(th, "getStatus");
            return c.a.a(c.baY, th, null, null, 6, null);
        }
    }

    TriviaSocketViewModel$quizStatus$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<c<k>> invoke() {
        return LiveDataReactiveStreams.a(this.this$0.dli.jm("").d((f) new AnonymousClass1(this)).f(new AnonymousClass2(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yo()));
    }
}
