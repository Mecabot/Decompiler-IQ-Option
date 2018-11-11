package com.iqoption.core.ui.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: HorizontalSpacingItemDecoration */
public class b extends ItemDecoration {
    private int bgg;

    public b(int i) {
        this.bgg = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.bgg > 0 && recyclerView.getChildAdapterPosition(view) > 0) {
            rect.left = this.bgg;
        }
    }
}
