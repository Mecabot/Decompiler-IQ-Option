package com.iqoption.portfolio.component;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.portfolio.component.b.d;
import com.iqoption.portfolio.component.viewholder.k;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001d\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u001c\u001a\u00020\u000bR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/portfolio/component/PortfolioFilterAdapter;", "Holder", "Lcom/iqoption/portfolio/component/viewholder/FilterViewHolders;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "items", "", "Lcom/iqoption/portfolio/component/data/FilterItem;", "holderFactory", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "onUpdateValue", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "view", "Landroid/support/v7/widget/RecyclerView;", "getItemCount", "", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "position", "(Lcom/iqoption/portfolio/component/viewholder/FilterViewHolders;I)V", "onCreateViewHolder", "parent", "viewType", "(Landroid/view/ViewGroup;I)Lcom/iqoption/portfolio/component/viewholder/FilterViewHolders;", "onDetachedFromRecyclerView", "updateValue", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PortfolioFilterAdapter.kt */
public final class l<Holder extends k<?>> extends Adapter<Holder> {
    private final b<ViewGroup, Holder> cZe;
    private final b<Holder, kotlin.l> cZf;
    private final List<d> nj;
    private RecyclerView view;

    public l(List<d> list, b<? super ViewGroup, ? extends Holder> bVar, b<? super Holder, kotlin.l> bVar2) {
        h.e(list, "items");
        h.e(bVar, "holderFactory");
        this.nj = list;
        this.cZe = bVar;
        this.cZf = bVar2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.view = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.view = (RecyclerView) null;
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: R */
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return (k) this.cZe.invoke(viewGroup);
    }

    /* renamed from: a */
    public void onBindViewHolder(Holder holder, int i) {
        h.e(holder, "holder");
        holder.a((d) this.nj.get(i));
        awG();
    }

    public final void awG() {
        b bVar = this.cZf;
        if (bVar != null) {
            RecyclerView recyclerView = this.view;
            if (recyclerView != null) {
                ViewGroup viewGroup = recyclerView;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    h.d(childAt, "getChildAt(index)");
                    ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(childAt);
                    if (!(findContainingViewHolder instanceof k)) {
                        findContainingViewHolder = null;
                    }
                    k kVar = (k) findContainingViewHolder;
                    if (kVar != null && kVar.isInitialized()) {
                        bVar.invoke(kVar);
                    }
                }
            }
        }
    }
}
