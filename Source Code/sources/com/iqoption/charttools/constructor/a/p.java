package com.iqoption.charttools.constructor.a;

import android.graphics.PorterDuff.Mode;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.iqoption.charttools.o.c;
import com.iqoption.charttools.o.d;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.widget.recyclerview.a.b;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/LoadingViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: LoadingViewHolder.kt */
public final class p extends b<Object> {
    public void bb(Object obj) {
    }

    public p(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(new FrameLayout(viewGroup.getContext()));
        View view = this.itemView;
        h.d(view, "itemView");
        view.setLayoutParams(new LayoutParams(-1, -1));
        view = this.itemView;
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
        View view2 = progressBar;
        int f = a.f(view2, d.dp48);
        progressBar.setLayoutParams(a.m(f, f, 17));
        progressBar.getIndeterminateDrawable().setColorFilter(a.b(view2, c.green), Mode.SRC_IN);
        frameLayout.addView(view2);
    }
}
