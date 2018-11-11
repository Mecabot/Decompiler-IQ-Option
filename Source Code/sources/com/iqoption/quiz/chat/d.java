package com.iqoption.quiz.chat;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.b.q;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J*\u0010\u0019\u001a\u0002H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\b¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItemsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/quiz/chat/ChatItemViewHolder;", "styles", "Lcom/iqoption/quiz/chat/ChatStyles;", "(Lcom/iqoption/quiz/chat/ChatStyles;)V", "diffCallback", "Lcom/iqoption/quiz/util/DiffCallback;", "Lcom/iqoption/quiz/chat/ChatItem;", "inflaterProvider", "Lcom/iqoption/quiz/chat/ChatItemsAdapter$InflaterProvider;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "lastRequest", "Lcom/iqoption/quiz/util/DiffRequest;", "getItemCount", "", "getItemId", "", "position", "inflate", "T", "Landroid/databinding/ViewDataBinding;", "layoutRes", "parent", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)Landroid/databinding/ViewDataBinding;", "onBindViewHolder", "", "holder", "onCreateViewHolder", "viewType", "Companion", "InflaterProvider", "quiz_release"})
/* compiled from: ChatItemsAdapter.kt */
public final class d extends Adapter<c> {
    private static final com.iqoption.quiz.c.i djB = new com.iqoption.quiz.c.i();
    public static final a djC = new a();
    private final b djA = new b();
    private final f djw;
    private final com.iqoption.quiz.c.b<b> djy = new com.iqoption.quiz.c.b();
    private com.iqoption.quiz.c.c<b> djz;
    private List<b> nj = m.emptyList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItemsAdapter$Companion;", "", "()V", "ID_STORE", "Lcom/iqoption/quiz/util/StableIdStore;", "quiz_release"})
    /* compiled from: ChatItemsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ChatItemsAdapter.kt */
    static final class c implements Runnable {
        final /* synthetic */ d djD;
        final /* synthetic */ com.iqoption.quiz.c.c djE;

        c(d dVar, com.iqoption.quiz.c.c cVar) {
            this.djD = dVar;
            this.djE = cVar;
        }

        public final void run() {
            final com.iqoption.quiz.c.d a = this.djE.a(this.djD.djy);
            io.reactivex.a.b.a.aWm().q(new Runnable(this) {
                final /* synthetic */ c djF;

                public final void run() {
                    if (h.E(this.djF.djD.djz, this.djF.djE)) {
                        this.djF.djD.nj = this.djF.djE.ZQ();
                        a.ZS().dispatchUpdatesTo((Adapter) this.djF.djD);
                    }
                }
            });
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/quiz/chat/ChatItemsAdapter$InflaterProvider;", "Lkotlin/Function1;", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "()V", "inflater", "invoke", "p1", "quiz_release"})
    /* compiled from: ChatItemsAdapter.kt */
    private static final class b implements kotlin.jvm.a.b<View, LayoutInflater> {
        private LayoutInflater aDN;

        /* renamed from: bN */
        public LayoutInflater invoke(View view) {
            h.e(view, "p1");
            LayoutInflater layoutInflater = this.aDN;
            if (layoutInflater != null) {
                return layoutInflater;
            }
            layoutInflater = LayoutInflater.from(view.getContext());
            this.aDN = layoutInflater;
            h.d(layoutInflater, "LayoutInflater.from(p1.c…t).also { inflater = it }");
            return layoutInflater;
        }
    }

    public d(f fVar) {
        h.e(fVar, "styles");
        this.djw = fVar;
        setHasStableIds(true);
    }

    public final List<b> getItems() {
        return this.nj;
    }

    public final void setItems(List<b> list) {
        h.e(list, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        com.iqoption.quiz.c.c cVar = new com.iqoption.quiz.c.c(this.nj, list);
        this.djz = cVar;
        io.reactivex.e.a.aXt().q(new c(this, cVar));
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: U */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        f fVar = this.djw;
        ViewDataBinding inflate = DataBindingUtil.inflate(this.djA.invoke(viewGroup), e.quiz_chat_item, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
        return new c(fVar, (q) inflate);
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        h.e(cVar, "holder");
        cVar.a((b) this.nj.get(i));
    }

    public long getItemId(int i) {
        return djB.dU(((b) this.nj.get(i)).Jf());
    }
}
