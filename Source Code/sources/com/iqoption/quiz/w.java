package com.iqoption.quiz;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.iqoption.a.t;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.c;
import com.iqoption.d.rf;
import com.iqoption.quiz.model.j;
import com.iqoption.quiz.model.k;
import com.iqoption.quiz.model.l;
import com.iqoption.quiz.model.m;
import com.iqoption.x.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/quiz/QuizLeaderBoardAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "diffCallback", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;", "Lcom/iqoption/quiz/model/QuizLeaderBoardAdapterItem;", "diffRequest", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffRequest;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemId", "", "item", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizLeaderBoardAdapter.kt */
public final class w extends Adapter<ViewHolder> {
    private static final t dgB = new t();
    public static final a dgK = new a();
    private final kotlin.jvm.a.b<l, kotlin.l> auy;
    private com.iqoption.core.ui.widget.recyclerview.adapter.a.b<j> bgh;
    private final com.iqoption.core.ui.widget.recyclerview.adapter.a.a<j> dgA = new com.iqoption.core.ui.widget.recyclerview.adapter.a.a();
    private List<? extends j> nj = m.emptyList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/quiz/QuizLeaderBoardAdapter$Companion;", "", "()V", "ID_STORE", "Lcom/iqoption/adapter/StableIdStore;", "VIEW_TYPE_ERROR", "", "VIEW_TYPE_ITEM", "VIEW_TYPE_LOADING", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizLeaderBoardAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: QuizLeaderBoardAdapter.kt */
    static final class b implements Runnable {
        final /* synthetic */ com.iqoption.core.ui.widget.recyclerview.adapter.a.b bgk;
        final /* synthetic */ w dgL;

        b(w wVar, com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar) {
            this.dgL = wVar;
            this.bgk = bVar;
        }

        public final void run() {
            final c a = this.bgk.a(this.dgL.dgA);
            com.iqoption.core.d.a.aSe.execute(new Runnable(this) {
                final /* synthetic */ b dgM;

                public final void run() {
                    if (h.E(this.dgM.dgL.bgh, a.ZR())) {
                        this.dgM.dgL.nj = a.ZR().ZQ();
                        a.ZS().dispatchUpdatesTo((Adapter) this.dgM.dgL);
                    }
                }
            });
        }
    }

    public w(kotlin.jvm.a.b<? super l, kotlin.l> bVar) {
        h.e(bVar, "onClick");
        this.auy = bVar;
        setHasStableIds(true);
    }

    public final void setItems(List<? extends j> list) {
        h.e(list, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar = new com.iqoption.core.ui.widget.recyclerview.adapter.a.b(this.nj, list);
        this.bgh = bVar;
        com.iqoption.core.d.a.aSc.execute(new b(this, bVar));
    }

    public int getItemCount() {
        return this.nj.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case -2:
                return new aa(com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_error_item, null, false, 6, null));
            case -1:
                return new aa(com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_loading_item, null, false, 6, null));
            case 0:
                return new x((rf) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_leaderboard_you_item, null, false, 6, null), this.auy);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown view type: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        if (viewHolder.getItemViewType() == 0) {
            x xVar = (x) viewHolder;
            Object obj = this.nj.get(i);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.quiz.model.QuizLeaderBoardItem");
            }
            xVar.c((l) obj);
        }
    }

    public int getItemViewType(int i) {
        j jVar = (j) this.nj.get(i);
        if (jVar instanceof m) {
            return -1;
        }
        if (jVar instanceof k) {
            return -2;
        }
        if (jVar instanceof l) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public long getItemId(int i) {
        return a((j) this.nj.get(i));
    }

    public final long a(j jVar) {
        h.e(jVar, "item");
        return dgB.dU((String) jVar.Jf());
    }
}
