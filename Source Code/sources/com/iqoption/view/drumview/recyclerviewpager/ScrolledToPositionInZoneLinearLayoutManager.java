package com.iqoption.view.drumview.recyclerviewpager;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;

public class ScrolledToPositionInZoneLinearLayoutManager extends LinearLayoutManager {
    private final LinearSmoothScroller dGd;

    public ScrolledToPositionInZoneLinearLayoutManager(Context context, int i) {
        super(context, i, false);
        this.dGd = new LinearSmoothScroller(context) {
            public PointF computeScrollVectorForPosition(int i) {
                return ScrolledToPositionInZoneLinearLayoutManager.this.computeScrollVectorForPosition(i);
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 200.0f / ((float) displayMetrics.densityDpi);
            }

            public int calculateDxToMakeVisible(View view, int i) {
                LayoutManager layoutManager = getLayoutManager();
                if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
                    return 0;
                }
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, ((layoutManager.getWidth() / 2) - (view.getWidth() / 2)) - 1, ((layoutManager.getWidth() / 2) + (view.getWidth() / 2)) + 1, i);
            }

            public int calculateDyToMakeVisible(View view, int i) {
                LayoutManager layoutManager = getLayoutManager();
                if (layoutManager == null || !layoutManager.canScrollVertically()) {
                    return 0;
                }
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return calculateDtToFit(view.getTop() - layoutParams.topMargin, view.getBottom() + layoutParams.bottomMargin, ((layoutManager.getHeight() / 2) - (view.getHeight() / 2)) - 1, ((layoutManager.getHeight() / 2) + (view.getHeight() / 2)) + 1, i);
            }
        };
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        this.dGd.setTargetPosition(i);
        startSmoothScroll(this.dGd);
    }
}
