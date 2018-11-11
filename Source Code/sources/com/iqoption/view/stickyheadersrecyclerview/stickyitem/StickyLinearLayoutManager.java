package com.iqoption.view.stickyheadersrecyclerview.stickyitem;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class StickyLinearLayoutManager extends LinearLayoutManager {
    private View dJg;

    public StickyLinearLayoutManager(Context context, View view) {
        super(context);
        this.dJg = view;
    }

    public StickyLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public StickyLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        super.onLayoutChildren(recycler, state);
        addView(this.dJg);
        e(this.dJg, MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layoutDecorated(this.dJg, 0, 0, getWidth(), getHeight());
    }

    private void e(View view, int i, int i2) {
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(updateSpecWithExtra(i, layoutParams.leftMargin + rect.left, layoutParams.rightMargin + rect.right), updateSpecWithExtra(i2, layoutParams.topMargin + rect.top, layoutParams.bottomMargin + rect.bottom));
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }
}
