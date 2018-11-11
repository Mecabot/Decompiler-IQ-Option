package com.iqoption.quiz.model;

import android.arch.lifecycle.MediatorLiveData;
import com.iqoption.quiz.m;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"update", "", "invoke", "com/iqoption/quiz/model/TriviaSocketViewModel$shouldShowQuestionLocalLangNotificationData$1$1"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$$special$$inlined$apply$lambda$1 extends Lambda implements a<l> {
    final /* synthetic */ BooleanRef $isOnAirState;
    final /* synthetic */ BooleanRef $isQuestionReceived;
    final /* synthetic */ MediatorLiveData receiver$0;
    final /* synthetic */ TriviaSocketViewModel this$0;

    TriviaSocketViewModel$$special$$inlined$apply$lambda$1(MediatorLiveData mediatorLiveData, BooleanRef booleanRef, BooleanRef booleanRef2, TriviaSocketViewModel triviaSocketViewModel) {
        this.receiver$0 = mediatorLiveData;
        this.$isOnAirState = booleanRef;
        this.$isQuestionReceived = booleanRef2;
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    public final void invoke() {
        boolean z = false;
        if (!m.ayY().azk().getBoolean("QUESTION_LOCAL_LANG_NOTIFICATION_WAS_SHOWN", false) && this.$isOnAirState.element && (!this.this$0.aCc() || (this.this$0.aCc() && !this.$isQuestionReceived.element))) {
            z = true;
        }
        if (!z) {
            this.receiver$0.a(this.this$0.aBI());
            this.receiver$0.a(this.this$0.aBC());
        }
        this.receiver$0.setValue(Boolean.valueOf(z));
    }
}
