package com.iqoption.view.timer.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public final class FlowerView extends View {
    private Paint dJU;
    private a dJV;

    public FlowerView(Context context) {
        super(context);
        ce(context);
    }

    public FlowerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    public FlowerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ce(context);
    }

    @TargetApi(21)
    public FlowerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ce(context);
    }

    private void ce(Context context) {
        setLayerType(2, null);
        this.dJV = new a(20);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) (i / 8);
        if (f < 5.0f) {
            f = 5.0f;
        }
        float f2 = f / 2.0f;
        this.dJU = new Paint();
        this.dJU.setAntiAlias(true);
        this.dJU.setStrokeWidth(f2);
        this.dJU.setStrokeCap(Cap.ROUND);
        this.dJU.setColor(-1);
        this.dJV.d(i, f);
    }

    protected void onDraw(Canvas canvas) {
        if (this.dJU != null) {
            for (int i = 0; i < 20; i++) {
                RectF rectF = this.dJV.aJQ()[i];
                this.dJU.setAlpha(this.dJV.aJR()[i]);
                canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.dJU);
            }
        }
    }

    public void x(long j, long j2) {
        this.dJV.w(j, j2);
        ViewCompat.postInvalidateOnAnimation(this);
    }
}
