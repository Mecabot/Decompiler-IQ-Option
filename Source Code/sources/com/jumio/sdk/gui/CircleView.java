package com.jumio.sdk.gui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.jumio.core.R;

public class CircleView extends View {
    private static final int DEFAULT_FILL_COLOR = 0;
    float h;
    private int mFillColor;
    private Paint mFillPaint;
    float radius;
    float w;

    public CircleView(Context context) {
        super(context);
        init(null, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircleView, i, 0);
        this.mFillColor = obtainStyledAttributes.getColor(R.styleable.CircleView_jumio_fillColor, 0);
        obtainStyledAttributes.recycle();
        this.mFillPaint = new Paint();
        this.mFillPaint.setFlags(1);
        this.mFillPaint.setStyle(Style.FILL);
        this.mFillPaint.setColor(this.mFillColor);
    }

    private void invalidatePaints() {
        this.mFillPaint.setColor(this.mFillColor);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.w = (float) getMeasuredWidth();
        this.h = (float) getMeasuredHeight();
        this.radius = Math.min(this.w, this.h) / 2.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.w / 2.0f, this.h / 2.0f, this.radius, this.mFillPaint);
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
        invalidatePaints();
    }
}
