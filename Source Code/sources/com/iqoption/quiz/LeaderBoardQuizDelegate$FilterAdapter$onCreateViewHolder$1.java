package com.iqoption.quiz;

import com.iqoption.quiz.model.LeaderBoardFilter;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/model/LeaderBoardFilter;", "invoke"})
/* compiled from: LeaderBoardQuizDelegate.kt */
final class LeaderBoardQuizDelegate$FilterAdapter$onCreateViewHolder$1 extends Lambda implements b<LeaderBoardFilter, l> {
    final /* synthetic */ f this$0;

    LeaderBoardQuizDelegate$FilterAdapter$onCreateViewHolder$1(f fVar) {
        this.this$0 = fVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((LeaderBoardFilter) obj);
        return l.etX;
    }

    public final void b(LeaderBoardFilter leaderBoardFilter) {
        h.e(leaderBoardFilter, "it");
        this.this$0.deO.d(leaderBoardFilter);
        this.this$0.dfd.dismiss();
    }
}
