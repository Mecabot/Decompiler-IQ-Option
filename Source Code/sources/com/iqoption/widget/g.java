package com.iqoption.widget;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: SpacingItemDecoration */
public class g extends ItemDecoration {
    private int bgg;
    private boolean dPa;
    private boolean dPb;

    public g(int i, boolean z, boolean z2) {
        this.bgg = i;
        this.dPa = z;
        this.dPb = z2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.bgg > 0) {
            if (this.dPa && recyclerView.getChildLayoutPosition(view) == 0) {
                if (h(recyclerView) == 1) {
                    rect.top = this.bgg;
                } else {
                    rect.left = this.bgg;
                }
            }
            if (this.dPb && recyclerView.getChildAdapterPosition(view) == q(recyclerView) - 1) {
                if (h(recyclerView) == 1) {
                    rect.bottom = this.bgg;
                } else {
                    rect.right = this.bgg;
                }
            }
        }
    }

    private int q(RecyclerView recyclerView) {
        return recyclerView.getAdapter().getItemCount();
    }

    private int h(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
        }
        throw new IllegalStateException("SpacingItemDecoration can only be used with a LinearLayoutManager.");
    }
}
