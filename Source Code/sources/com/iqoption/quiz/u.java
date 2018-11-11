package com.iqoption.quiz;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.iqoption.a.t;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.c;
import com.iqoption.d.qv;
import com.iqoption.quiz.model.e;
import com.iqoption.quiz.model.f;
import com.iqoption.quiz.model.g;
import com.iqoption.x.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/quiz/QuizInsightsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/quiz/model/QuizInsightItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "diffCallback", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "diffRequest", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffRequest;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemId", "", "item", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizInsightsAdapter.kt */
public final class u extends Adapter<ViewHolder> {
    private static final t dgB = new t();
    public static final a dgC = new a();
    private final kotlin.jvm.a.b<e, l> auy;
    private com.iqoption.core.ui.widget.recyclerview.adapter.a.b<f> bgh;
    private final com.iqoption.core.ui.widget.recyclerview.adapter.a.a<f> dgA = new com.iqoption.core.ui.widget.recyclerview.adapter.a.a();
    private List<? extends f> nj = m.emptyList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/QuizInsightsAdapter$Companion;", "", "()V", "ID_STORE", "Lcom/iqoption/adapter/StableIdStore;", "VIEW_TYPE_ERROR", "", "VIEW_TYPE_ITEM", "VIEW_TYPE_LOADING", "VIEW_TYPE_TITLE", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizInsightsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: QuizInsightsAdapter.kt */
    static final class b implements Runnable {
        final /* synthetic */ com.iqoption.core.ui.widget.recyclerview.adapter.a.b bgk;
        final /* synthetic */ u dgD;

        b(u uVar, com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar) {
            this.dgD = uVar;
            this.bgk = bVar;
        }

        public final void run() {
            final c a = this.bgk.a(this.dgD.dgA);
            com.iqoption.core.d.a.aSe.execute(new Runnable(this) {
                final /* synthetic */ b dgE;

                public final void run() {
                    if (h.E(this.dgE.dgD.bgh, a.ZR())) {
                        this.dgE.dgD.nj = a.ZR().ZQ();
                        a.ZS().dispatchUpdatesTo((Adapter) this.dgE.dgD);
                    }
                }
            });
        }
    }

    public u(kotlin.jvm.a.b<? super e, l> bVar) {
        h.e(bVar, "onClick");
        this.auy = bVar;
        setHasStableIds(true);
    }

    public final void setItems(List<? extends f> list) {
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
                return new aa(com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_insights_title_item, null, false, 6, null));
            case 1:
                return new v((qv) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_insights_item, null, false, 6, null), this.auy);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown view type: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        if (viewHolder.getItemViewType() == 1) {
            v vVar = (v) viewHolder;
            Object obj = this.nj.get(i);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.quiz.model.QuizInsightItem");
            }
            vVar.c((e) obj);
        }
    }

    public int getItemViewType(int i) {
        f fVar = (f) this.nj.get(i);
        if (fVar instanceof e) {
            return 1;
        }
        if (fVar instanceof com.iqoption.quiz.model.i) {
            return 0;
        }
        if (fVar instanceof com.iqoption.quiz.model.h) {
            return -1;
        }
        if (fVar instanceof g) {
            return -2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public long getItemId(int i) {
        return a((f) this.nj.get(i));
    }

    public final long a(f fVar) {
        h.e(fVar, "item");
        return dgB.dU((String) fVar.Jf());
    }
}
