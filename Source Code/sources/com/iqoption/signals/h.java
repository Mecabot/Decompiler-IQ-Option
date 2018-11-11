package com.iqoption.signals;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.c;
import com.iqoption.d.aje;
import com.iqoption.d.ajk;
import com.iqoption.x.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/signals/SignalsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/signals/SignalItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "diffCallback", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;", "Lcom/iqoption/signals/AdapterItem;", "diffRequest", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffRequest;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalsAdapter.kt */
public final class h extends Adapter<ViewHolder> {
    public static final a drl = new a();
    private final kotlin.jvm.a.b<c, l> auy;
    private com.iqoption.core.ui.widget.recyclerview.adapter.a.b<a> bgh;
    private final com.iqoption.core.ui.widget.recyclerview.adapter.a.a<a> dgA = new com.iqoption.core.ui.widget.recyclerview.adapter.a.a();
    private List<? extends a> nj = m.emptyList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/signals/SignalsAdapter$Companion;", "", "()V", "VIEW_TYPE_ITEM", "", "VIEW_TYPE_LOADING", "VIEW_TYPE_TITLE", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SignalsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SignalsAdapter.kt */
    static final class b implements Runnable {
        final /* synthetic */ com.iqoption.core.ui.widget.recyclerview.adapter.a.b bgk;
        final /* synthetic */ h drm;

        b(h hVar, com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar) {
            this.drm = hVar;
            this.bgk = bVar;
        }

        public final void run() {
            final c a = this.bgk.a(this.drm.dgA);
            com.iqoption.core.d.a.aSe.execute(new Runnable(this) {
                final /* synthetic */ b drn;

                public final void run() {
                    if (kotlin.jvm.internal.h.E(this.drn.drm.bgh, a.ZR())) {
                        this.drn.drm.nj = a.ZR().ZQ();
                        a.ZS().dispatchUpdatesTo((Adapter) this.drn.drm);
                    }
                }
            });
        }
    }

    public h(kotlin.jvm.a.b<? super c, l> bVar) {
        kotlin.jvm.internal.h.e(bVar, "onClick");
        this.auy = bVar;
    }

    public final void setItems(List<? extends a> list) {
        kotlin.jvm.internal.h.e(list, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar = new com.iqoption.core.ui.widget.recyclerview.adapter.a.b(this.nj, list);
        this.bgh = bVar;
        com.iqoption.core.d.a.aSc.execute(new b(this, bVar));
    }

    public int getItemCount() {
        return this.nj.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        if (i == 2) {
            return new d((aje) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.signal_item, null, false, 6, null), this.auy);
        }
        switch (i) {
            case -1:
                return new e(viewGroup);
            case 0:
                return new g((ajk) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.signal_title_item, null, false, 6, null));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        kotlin.jvm.internal.h.e(viewHolder, "holder");
        int itemViewType = viewHolder.getItemViewType();
        Object obj;
        if (itemViewType == 0) {
            g gVar = (g) viewHolder;
            obj = this.nj.get(i);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.signals.SignalTitleItem");
            }
            gVar.a((f) obj);
        } else if (itemViewType == 2) {
            d dVar = (d) viewHolder;
            obj = this.nj.get(i);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.signals.SignalItem");
            }
            dVar.b((c) obj);
        }
    }

    public int getItemViewType(int i) {
        a aVar = (a) this.nj.get(i);
        if (kotlin.jvm.internal.h.E(aVar, b.drb)) {
            return -1;
        }
        if (aVar instanceof f) {
            return 0;
        }
        if (aVar instanceof c) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
