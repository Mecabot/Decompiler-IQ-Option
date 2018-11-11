package com.iqoption.quiz;

import com.iqoption.quiz.LeaderBoardQuizDelegate.h;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: LeaderBoardQuizDelegate.kt */
final class LeaderBoardQuizDelegate$YouItemController$endTranslationY$2 extends Lambda implements a<Float> {
    final /* synthetic */ h this$0;

    LeaderBoardQuizDelegate$YouItemController$endTranslationY$2(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    public /* synthetic */ Object invoke() {
        return Float.valueOf(ayQ());
    }

    public final float ayQ() {
        return (float) this.this$0.view.getMeasuredHeight();
    }
}
