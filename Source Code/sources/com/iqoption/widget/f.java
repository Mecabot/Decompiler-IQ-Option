package com.iqoption.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: SimpleDividerItemDecoration */
public class f extends ItemDecoration {
    private final Drawable dOU;
    private final boolean dOV;
    private final boolean dOW;

    protected boolean a(RecyclerView recyclerView, View view) {
        return false;
    }

    public f(Context context, @DrawableRes int i, boolean z, boolean z2) {
        this.dOU = ContextCompat.getDrawable(context, i);
        this.dOV = z;
        this.dOW = z2;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (!(a(recyclerView, childAt) || (this.dOV && childAdapterPosition == 0))) {
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (!this.dOW || childAdapterPosition != itemCount - 1) {
                    int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.dOU.setBounds(paddingLeft, bottom, width, this.dOU.getIntrinsicHeight() + bottom);
                    this.dOU.draw(canvas);
                }
            }
        }
    }
}
