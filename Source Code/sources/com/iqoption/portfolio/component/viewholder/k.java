package com.iqoption.portfolio.component.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.iqoption.portfolio.component.b.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, aXE = {"Lcom/iqoption/portfolio/component/viewholder/FilterViewHolders;", "T", "Landroid/databinding/ViewDataBinding;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "(Landroid/databinding/ViewDataBinding;)V", "getBinding", "()Landroid/databinding/ViewDataBinding;", "Landroid/databinding/ViewDataBinding;", "bound", "Lcom/iqoption/portfolio/component/data/FilterItem;", "getBound", "()Lcom/iqoption/portfolio/component/data/FilterItem;", "setBound", "(Lcom/iqoption/portfolio/component/data/FilterItem;)V", "<set-?>", "", "isInitialized", "()Z", "setInitialized", "(Z)V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilterViewHolders.kt */
public abstract class k<T extends ViewDataBinding> extends ViewHolder {
    private boolean HH;
    private final T ahp;

    public abstract void a(d dVar);

    public k(T t) {
        h.e(t, "binding");
        super(t.getRoot());
        this.ahp = t;
    }

    public final T getBinding() {
        return this.ahp;
    }

    protected final void eh(boolean z) {
        this.HH = z;
    }

    public final boolean isInitialized() {
        return this.HH;
    }
}
