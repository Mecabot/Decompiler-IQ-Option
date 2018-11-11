package com.iqoption.quiz;

import android.widget.TextView;
import com.iqoption.d.rd;
import com.iqoption.quiz.LeaderBoardQuizDelegate.g;
import com.iqoption.quiz.model.LeaderBoardFilter;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<LeaderBoardFilter, l> {
    final /* synthetic */ Object $context;
    final /* synthetic */ g this$0;

    public LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder$$special$$inlined$bindable$1(Object obj, g gVar) {
        this.$context = obj;
        this.this$0 = gVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(LeaderBoardFilter leaderBoardFilter) {
        leaderBoardFilter = leaderBoardFilter;
        rd rdVar = (rd) this.$context;
        rdVar.aip.setText(leaderBoardFilter.getLabel());
        TextView textView = rdVar.aip;
        h.d(textView, "text");
        textView.setSelected(leaderBoardFilter == ((LeaderBoardFilter) this.this$0.dfe.getValue()));
    }
}
