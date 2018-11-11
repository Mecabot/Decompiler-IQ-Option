package com.iqoption.core.ui.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: GridSpacingItemDecoration */
public class a extends ItemDecoration {
    private boolean bgf;
    private int spacing;
    private int spanCount;

    public a(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.bgf = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(view);
            if (findContainingViewHolder != null) {
                childAdapterPosition = findContainingViewHolder.getOldPosition();
            }
        }
        int i = childAdapterPosition % this.spanCount;
        if (this.bgf) {
            rect.left = this.spacing - ((this.spacing * i) / this.spanCount);
            rect.right = ((i + 1) * this.spacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
            return;
        }
        rect.left = (this.spacing * i) / this.spanCount;
        rect.right = this.spacing - (((i + 1) * this.spacing) / this.spanCount);
        rect.top = this.spacing;
    }
}
