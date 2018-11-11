package com.iqoption.feed.feedlist.b;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: MicroItemDecoration */
public class g extends ItemDecoration {
    private final Drawable aRS;
    private final int bgg;
    private final Rect bounds = new Rect();

    public g(Drawable drawable, int i) {
        this.aRS = drawable;
        this.bgg = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        if (recyclerView.getLayoutManager() != null && this.aRS != null) {
            drawVertical(canvas, recyclerView);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft;
        int width;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (recyclerView.getChildAdapterPosition(childAt) >= 0) {
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.bounds);
                int round = this.bounds.bottom + Math.round(childAt.getTranslationY());
                this.aRS.setBounds(paddingLeft, round - this.aRS.getIntrinsicHeight(), width, round);
                this.aRS.draw(canvas);
            }
        }
        canvas.restore();
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (this.bgg > 0 && childLayoutPosition != 0) {
            rect.top = this.bgg;
        }
    }
}
