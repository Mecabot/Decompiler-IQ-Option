package com.iqoption.quiz.model;

import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/model/TriviaSocketViewModel$CountDownTimeLiveData;", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$splashCountDownTime$2 extends Lambda implements a<d> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    TriviaSocketViewModel$splashCountDownTime$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aCj */
    public final d invoke() {
        return new d(this.this$0, TimeUnit.HOURS.toMillis(1), AnonymousClass1.dng);
    }
}
