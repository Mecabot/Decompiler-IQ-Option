package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import com.iqoption.core.ui.c;
import com.iqoption.quiz.d.b;
import io.reactivex.c.f;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a(\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "", "Lcom/iqoption/quiz/winners/WinnerInfo;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$winnerInfo$2 extends Lambda implements a<LiveData<c<List<? extends b>>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "", "Lcom/iqoption/quiz/winners/WinnerInfo;", "t", "", "apply"})
    /* compiled from: TriviaSocketViewModel.kt */
    /* renamed from: com.iqoption.quiz.model.TriviaSocketViewModel$winnerInfo$2$2 */
    static final class AnonymousClass2<T, R> implements f<Throwable, c<List<? extends b>>> {
        final /* synthetic */ TriviaSocketViewModel$winnerInfo$2 dnk;

        AnonymousClass2(TriviaSocketViewModel$winnerInfo$2 triviaSocketViewModel$winnerInfo$2) {
            this.dnk = triviaSocketViewModel$winnerInfo$2;
        }

        /* renamed from: t */
        public final c<List<b>> apply(Throwable th) {
            h.e(th, "t");
            this.dnk.this$0.a(th, "getWinners");
            return c.a.a(c.baY, th, null, null, 6, null);
        }
    }

    TriviaSocketViewModel$winnerInfo$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<c<List<b>>> invoke() {
        return LiveDataReactiveStreams.a(this.this$0.dli.jl("").d((f) AnonymousClass1.dnj).f(new AnonymousClass2(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()));
    }
}
