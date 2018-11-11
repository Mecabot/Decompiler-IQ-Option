package com.iqoption.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: SeparatorDecoration */
public class e extends ItemDecoration {
    private final Paint mPaint = new Paint();

    public e(@ColorInt int i, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.mPaint.setColor(i);
        this.mPaint.setStrokeWidth(f);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.top = Math.round(this.mPaint.getStrokeWidth());
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        float strokeWidth = this.mPaint.getStrokeWidth() / 2.0f;
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).getViewAdapterPosition() < state.getItemCount()) {
                canvas.drawLine((float) childAt.getLeft(), ((float) childAt.getBottom()) + strokeWidth, (float) childAt.getRight(), ((float) childAt.getBottom()) + strokeWidth, this.mPaint);
            }
        }
    }
}
