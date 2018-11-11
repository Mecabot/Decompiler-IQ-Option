package com.iqoption.core.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.iqoption.core.j.g;

public class MaxSizeView extends View implements c {
    private int maxHeight = 0;
    private int maxWidth = 0;

    public Point g(int i, int i2, int i3, int i4) {
        return d.a(this, i, i2, i3, i4);
    }

    public MaxSizeView(Context context) {
        super(context);
    }

    public MaxSizeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public MaxSizeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public MaxSizeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.MaxSizeView, 0, 0);
        try {
            this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(g.MaxSizeView_maxHeightView, 0);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(g.MaxSizeView_maxWidthView, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        Point g = g(this.maxWidth, this.maxHeight, i, i2);
        super.onMeasure(g.x, g.y);
    }
}
