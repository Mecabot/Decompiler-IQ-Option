package com.iqoption.quiz.d;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.b.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014J*\u0010\u0015\u001a\u0002H\u0016\"\n\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\b¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010#\u001a\u00020\u001d2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00142\b\u0010%\u001a\u0004\u0018\u00010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, aXE = {"Lcom/iqoption/quiz/winners/WinnersAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/quiz/winners/WinnerViewHolder;", "()V", "idSupplier", "Lcom/iqoption/quiz/util/StableIdStore;", "inflater", "Landroid/view/LayoutInflater;", "items", "", "Lcom/iqoption/quiz/winners/WinnerInfo;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getItems", "", "inflate", "T", "Landroid/databinding/ViewDataBinding;", "layoutRes", "parent", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)Landroid/databinding/ViewDataBinding;", "onAttachedToRecyclerView", "", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "onDetachedFromRecyclerView", "setItems", "list", "diffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "Companion", "quiz_release"})
/* compiled from: WinnersAdapter.kt */
public final class d extends Adapter<c> {
    public static final a dpm = new a();
    private LayoutInflater aDN;
    private RecyclerView ahx;
    private final com.iqoption.quiz.c.i dpl = new com.iqoption.quiz.c.i();
    private final List<b> nj = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/quiz/winners/WinnersAdapter$Companion;", "", "()V", "VIEW_TYPE_WINNER", "", "quiz_release"})
    /* compiled from: WinnersAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public d() {
        setHasStableIds(true);
    }

    public static final /* synthetic */ LayoutInflater a(d dVar) {
        LayoutInflater layoutInflater = dVar.aDN;
        if (layoutInflater == null) {
            h.lS("inflater");
        }
        return layoutInflater;
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: V */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        if (i != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown viewType ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ViewDataBinding inflate = DataBindingUtil.inflate(a(this), e.winner_item, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
        return new c((y) inflate);
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        h.e(cVar, "holder");
        cVar.a((b) this.nj.get(i));
        cVar.gv(i);
    }

    public long getItemId(int i) {
        return ((b) this.nj.get(i)).getId();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        LayoutInflater from = LayoutInflater.from(recyclerView.getContext());
        h.d(from, "LayoutInflater.from(this)");
        this.aDN = from;
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = (RecyclerView) null;
    }

    public final void b(List<b> list, DiffResult diffResult) {
        this.nj.clear();
        if (list != null) {
            this.nj.addAll(list);
        }
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo((Adapter) this);
        } else {
            notifyDataSetChanged();
        }
    }

    public final List<b> getItems() {
        return this.nj;
    }
}
