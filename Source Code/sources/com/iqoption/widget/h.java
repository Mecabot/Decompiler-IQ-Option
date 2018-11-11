package com.iqoption.widget;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: SpacingItemDecoration2 */
public class h extends ItemDecoration {
    private int bgg;
    private int orientation = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public h(int i) {
        this.bgg = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.bgg > 0 && recyclerView.getChildLayoutPosition(view) != 0) {
            if (this.orientation == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                this.orientation = h(recyclerView);
            }
            if (this.orientation == 1) {
                rect.top = this.bgg;
            } else {
                rect.left = this.bgg;
            }
        }
    }

    private int h(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
        }
        throw new IllegalStateException("SpacingItemDecoration can only be used with a LinearLayoutManager.");
    }
}
