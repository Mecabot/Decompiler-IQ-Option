package com.iqoption.quiz.widget.maxsize;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.iqoption.quiz.ae.i;

public class MaxSizeFrameLayout extends FrameLayout implements a {
    private float heightPercent = 0.0f;
    private int maxHeight = 0;
    private int maxWidth = 0;
    private float widthPercent = 0.0f;

    public Point a(float f, float f2, int i, int i2) {
        return b.a((a) this, f, f2, i, i2);
    }

    public Point g(int i, int i2, int i3, int i4) {
        return b.a((a) this, i, i2, i3, i4);
    }

    public MaxSizeFrameLayout(Context context) {
        super(context);
    }

    public MaxSizeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public MaxSizeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public MaxSizeFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.MaxSizeWidget, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == i.MaxSizeWidget_maxSizeWidth) {
                    this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == i.MaxSizeWidget_maxSizeHeight) {
                    this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == i.MaxSizeWidget_maxSizeWidthPercent) {
                    this.widthPercent = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == i.MaxSizeWidget_maxSizeHeightPercent) {
                    this.heightPercent = obtainStyledAttributes.getFloat(index, 0.0f);
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        Point a;
        if (this.maxWidth == 0 && this.maxHeight == 0) {
            a = a(this.widthPercent, this.heightPercent, i, i2);
        } else {
            a = g(this.maxWidth, this.maxHeight, i, i2);
        }
        super.onMeasure(a.x, a.y);
    }
}
