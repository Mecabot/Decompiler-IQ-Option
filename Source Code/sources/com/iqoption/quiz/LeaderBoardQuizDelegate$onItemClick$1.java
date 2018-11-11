package com.iqoption.quiz;

import com.iqoption.quiz.model.l;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "invoke"})
/* compiled from: LeaderBoardQuizDelegate.kt */
final class LeaderBoardQuizDelegate$onItemClick$1 extends Lambda implements b<l, kotlin.l> {
    final /* synthetic */ LeaderBoardQuizDelegate this$0;

    LeaderBoardQuizDelegate$onItemClick$1(LeaderBoardQuizDelegate leaderBoardQuizDelegate) {
        this.this$0 = leaderBoardQuizDelegate;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((l) obj);
        return kotlin.l.etX;
    }

    public final void b(l lVar) {
        h.e(lVar, "it");
        this.this$0.a(Long.parseLong(lVar.Jf()), lVar.getDisplayName(), lVar.getPosition(), lVar.aBy());
    }
}
