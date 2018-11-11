package com.iqoption.core.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import com.iqoption.core.j.g;

public class MaxSizeCardViewLayout extends CardView implements c {
    private int maxHeight = 0;
    private int maxWidth = 0;

    public Point g(int i, int i2, int i3, int i4) {
        return d.a(this, i, i2, i3, i4);
    }

    public MaxSizeCardViewLayout(Context context) {
        super(context);
    }

    public MaxSizeCardViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public MaxSizeCardViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.MaxSizeCardViewLayout, 0, 0);
        try {
            this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(g.MaxSizeCardViewLayout_maxHeightCardView, 0);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(g.MaxSizeCardViewLayout_maxWidthCardView, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        Point g = g(this.maxWidth, this.maxHeight, i, i2);
        super.onMeasure(g.x, g.y);
    }
}
