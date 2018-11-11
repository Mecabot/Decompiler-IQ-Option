package com.iqoption.vip;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.app.IQApp;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, aXE = {"Lcom/iqoption/vip/EducationItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: EducationItemDecoration.kt */
public final class d extends ItemDecoration {
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        h.e(rect, "outRect");
        h.e(view, Promotion.ACTION_VIEW);
        h.e(recyclerView, "parent");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        Adapter adapter = recyclerView.getAdapter();
        h.d(adapter, "parent.adapter");
        if (childAdapterPosition < adapter.getItemCount() - 1 && recyclerView.getAdapter().getItemViewType(childAdapterPosition + 1) == 1) {
            IQApp Dk = IQApp.Dk();
            h.d(Dk, "IQApp.instance()");
            rect.bottom = Dk.getResources().getDimensionPixelOffset(R.dimen.dp8);
        }
    }
}
