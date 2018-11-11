package com.iqoption.portfolio.component;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: PortfolioItemDecoration */
public final class m extends ItemDecoration {
    private final int space;

    private static boolean fT(int i) {
        return (i == -1 || i == -2) ? false : true;
    }

    public m(int i) {
        this.space = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder != null && fT(childViewHolder.getItemViewType()) && a(view, recyclerView)) {
            rect.set(0, 0, 0, this.space);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    private static boolean a(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) != recyclerView.getAdapter().getItemCount() - 1;
    }
}
