package com.iqoption.videoeducation.a;

import android.graphics.PorterDuff.Mode;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.widget.recyclerview.a.b;
import com.iqoption.videoeducation.h;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogLoadingViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/videoeducation/VideoCatalogLoadingItem;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoCatalogLoadingViewHolder.kt */
public final class d extends b<h> {
    /* renamed from: a */
    public void bb(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "item");
    }

    public d(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        super(new FrameLayout(viewGroup.getContext()));
        View view = this.itemView;
        kotlin.jvm.internal.h.d(view, "itemView");
        view.setLayoutParams(new LayoutParams(-1, -1));
        view = this.itemView;
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
        View view2 = progressBar;
        int f = a.f(view2, R.dimen.dp32);
        progressBar.setLayoutParams(a.m(f, f, 17));
        progressBar.getIndeterminateDrawable().setColorFilter(a.b(view2, (int) R.color.green), Mode.SRC_IN);
        frameLayout.addView(view2);
    }
}
