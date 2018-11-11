package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.SweepGradient;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.iqoption.x.R;

public final class CryptoBumperView extends View {
    private static Property<CryptoBumperView, Integer> dBD = new Property<CryptoBumperView, Integer>(Integer.class, "staticGradientBalance") {
        /* renamed from: c */
        public Integer get(CryptoBumperView cryptoBumperView) {
            return Integer.valueOf(cryptoBumperView.dBy.getAlpha());
        }

        /* renamed from: a */
        public void set(CryptoBumperView cryptoBumperView, Integer num) {
            cryptoBumperView.dBy.setAlpha(num.intValue());
            cryptoBumperView.awG.setAlpha(255 - num.intValue());
            cryptoBumperView.postInvalidateOnAnimation();
        }
    };
    private Paint awG;
    @ColorInt
    private int color;
    private float dBA;
    private float dBB;
    private boolean dBC;
    @ColorInt
    private int dBw;
    @ColorInt
    private int dBx;
    private Paint dBy;
    private float dBz;
    private float radius;

    public void setDrawStatic(boolean z) {
        if (this.dBC != z) {
            this.dBC = z;
            invalidate();
        }
    }

    public CryptoBumperView(Context context) {
        this(context, null);
    }

    public CryptoBumperView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CryptoBumperView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dBy = new Paint(1);
        init();
    }

    @TargetApi(21)
    public CryptoBumperView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.dBy = new Paint(1);
        init();
    }

    private void init() {
        Context context = getContext();
        this.color = ContextCompat.getColor(context, R.color.green);
        this.dBw = ContextCompat.getColor(context, R.color.green_80);
        this.dBx = ContextCompat.getColor(context, R.color.green_00);
        this.dBz = getResources().getDimension(R.dimen.dp2);
        this.dBy = new Paint(1);
        this.dBy.setColor(this.color);
        this.dBy.setStyle(Style.STROKE);
        this.dBy.setStrokeWidth(this.dBz);
        this.awG = new Paint(this.dBy);
        this.awG.setAlpha(0);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dBA = ((float) i) / 2.0f;
        this.dBB = ((float) i2) / 2.0f;
        this.radius = Math.min(this.dBA, this.dBB) - (this.dBz / 2.0f);
        this.awG.setShader(new SweepGradient(this.dBA, this.dBB, new int[]{this.color, this.dBw, this.dBx, this.dBx}, new float[]{0.0f, 0.5f, 0.75f, 1.0f}));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dBC) {
            canvas.drawCircle(this.dBA, this.dBB, this.radius, this.dBy);
        }
        canvas.drawCircle(this.dBA, this.dBB, this.radius, this.awG);
    }
}
