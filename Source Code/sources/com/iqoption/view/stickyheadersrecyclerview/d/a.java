package com.iqoption.view.stickyheadersrecyclerview.d;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;

/* compiled from: LinearLayoutOrientationProvider */
public class a implements b {
    public int h(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        a(layoutManager);
        return ((LinearLayoutManager) layoutManager).getOrientation();
    }

    public boolean p(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        a(layoutManager);
        return ((LinearLayoutManager) layoutManager).getReverseLayout();
    }

    private void a(LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
        }
    }
}
